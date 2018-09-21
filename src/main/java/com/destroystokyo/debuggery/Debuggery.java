/*
 * This file is part of Debuggery.
 *
 * Debuggery is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Debuggery is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Debuggery.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.destroystokyo.debuggery;

import com.destroystokyo.debuggery.commands.*;
import com.destroystokyo.debuggery.commands.base.CommandBase;
import com.destroystokyo.debuggery.reflection.ReflectionUtil;
import com.destroystokyo.debuggery.reflection.types.TypeHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class Debuggery extends JavaPlugin {
    public static final boolean DEBUG_MODE = Boolean.getBoolean("debuggery.debug");
    private final Map<String, CommandBase> commands = new HashMap<>();

    @Override
    public void onEnable() {
        if (DEBUG_MODE) {
            this.getLogger().warning("Debug mode enabled!");
        }

        TypeHandler.getInstance(); // init type handler at startup
        this.registerCommands();
    }

    @Override
    public void onDisable() {
        ReflectionUtil.clearMethodMapCache();
    }

    private void registerCommands() {
        this.registerCommand(new BlockCommand());
        this.registerCommand(new ChunkCommand());
        this.registerCommand(new DebuggeryCommand(this));
        this.registerCommand(new EntityCommand());
        this.registerCommand(new ItemCommand());
        this.registerCommand(new PlayerCommand());
        this.registerCommand(new ServerCommand());
        this.registerCommand(new WorldCommand());

        commands.values().forEach(c -> this.getCommand(c.getName()).setExecutor(c));
    }

    private void registerCommand(final CommandBase command) {
        this.commands.put(command.getName(), command);
    }

    public Map<String, CommandBase> getAllCommands() {
        return Collections.unmodifiableMap(commands);
    }
}

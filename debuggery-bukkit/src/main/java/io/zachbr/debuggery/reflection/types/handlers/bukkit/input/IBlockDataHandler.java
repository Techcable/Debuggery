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

package io.zachbr.debuggery.reflection.types.handlers.bukkit.input;

import io.zachbr.debuggery.reflection.types.handlers.base.IPolymorphicHandler;
import io.zachbr.debuggery.reflection.types.handlers.base.platform.PlatformSender;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IBlockDataHandler implements IPolymorphicHandler {

    @Override
    public @NotNull Object instantiateInstance(String input, Class<?> clazz, @Nullable PlatformSender<?> sender) {
        // first try from straight material name
        Material material;
        try {
            material = IMaterialHandler.getMaterial(input);
            return Bukkit.createBlockData(material);
        } catch (NullPointerException ignored) {
        }

        // next try using vanilla data strings
        return Bukkit.createBlockData(input); // will throw illegalargumentexception
    }

    @Override
    public @NotNull Class<?> getRelevantClass() {
        return BlockData.class;
    }
}

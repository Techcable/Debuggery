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

package io.zachbr.debuggery.reflection.bukkit.implementations;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class TestBlockState implements BlockState {
    private final MaterialData data;
    private final byte lightLevel;
    private final Location loc;
    private final boolean placed;
    private final BlockData blockData;

    public TestBlockState(MaterialData data, byte lightLevel, Location loc, boolean placed, BlockData blockData) {
        this.data = data;
        this.lightLevel = lightLevel;
        this.loc = loc;
        this.placed = placed;
        this.blockData = blockData;
    }

    @Override
    public Block getBlock() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MaterialData getData() {
        return this.data;
    }

    @Override
    public void setData(MaterialData data) {
        throw new UnsupportedOperationException();
    }

    @Override
    public BlockData getBlockData() {
        return this.blockData;
    }

    @Override
    public void setBlockData(BlockData blockData) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Material getType() {
        return this.data.getItemType();
    }

    @Override
    public void setType(Material type) {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte getLightLevel() {
        return this.lightLevel;
    }

    @Override
    public World getWorld() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getX() {
        return getLocation().getBlockX();
    }

    @Override
    public int getY() {
        return getLocation().getBlockY();
    }

    @Override
    public int getZ() {
        return getLocation().getBlockZ();
    }

    @Override
    public Location getLocation() {
        return this.loc;
    }

    @Override
    public Location getLocation(Location loc) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Chunk getChunk() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(boolean force) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(boolean force, boolean applyPhysics) {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte getRawData() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setRawData(byte data) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isPlaced() {
        return placed;
    }

    @Override
    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<MetadataValue> getMetadata(String metadataKey) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasMetadata(String metadataKey) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeMetadata(String metadataKey, Plugin owningPlugin) {
        throw new UnsupportedOperationException();
    }
}

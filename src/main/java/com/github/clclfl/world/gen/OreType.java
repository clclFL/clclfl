package com.github.clclfl.world.gen;

import com.github.clclfl.block.BlockRegistryHandler;
import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OreType {

    COBALT_NETHER(Lazy.of((BlockRegistryHandler.COBALT_ORE_NETHER)) , 8 , 10 , 35);

    private final Lazy<Block> block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;

    OreType(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public Lazy<Block> getBlock() {
        return block;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public static OreType get(Block block){
        for (OreType ore : values()){
            if (block == ore.block){
                return ore;
            }
        }
        return null;
    }
}
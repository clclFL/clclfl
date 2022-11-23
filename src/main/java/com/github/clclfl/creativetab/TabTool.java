package com.github.clclfl.creativetab;

import com.github.clclfl.item.ItemRegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class TabTool extends ItemGroup {

    public TabTool() {
        super("weapon_group");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistryHandler.COBALT_SHARP_EDGE.get());
    }
}

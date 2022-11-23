package com.github.clclfl.creativetab;

import com.github.clclfl.item.ItemRegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class TabClclfl extends ItemGroup {

    public TabClclfl() {super("clclfl_group");}

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistryHandler.COBALT_INGOT.get());
    }
}

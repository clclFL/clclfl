package com.github.clclfl.item;

import com.github.clclfl.Utils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class CobaltCrystalsCluster extends Item {

    public CobaltCrystalsCluster(Properties properties) {
        super(properties);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(Utils.TipHelper.getTip("tooltip.clclfl.cobaltCrystalsCluster.line1"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
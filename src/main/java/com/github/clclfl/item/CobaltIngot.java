package com.github.clclfl.item;

import com.github.clclfl.Utils;
import com.github.clclfl.creativetab.ModCreativeTab;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class CobaltIngot extends Item {

    public CobaltIngot(Properties properties) {
        super(properties);
    }

    @Deprecated
    public CobaltIngot() {
        super(new Properties().group(ModCreativeTab.TAB_CLCLFL));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
//        tooltip.add(new TranslationTextComponent("tooltip.clclfl.cobaltIngot.line1"));
//        tooltip.add(new TranslationTextComponent("tooltip.clclfl.cobaltIngot.line2"));
        tooltip.add(new TranslationTextComponent("tooltip.clclfl.cobaltIngot.line1"));
        tooltip.add(new TranslationTextComponent("tooltip.clclfl.cobaltIngot.line2"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}


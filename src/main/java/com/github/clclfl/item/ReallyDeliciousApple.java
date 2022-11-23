package com.github.clclfl.item;

import com.github.clclfl.Utils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class ReallyDeliciousApple extends Item {

    public ReallyDeliciousApple(Properties properties) {
        super(properties);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("tooltip.clclfl.reallyDeliciousApple.line1"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean isImmuneToFire() {
        return true;
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        stack.addEnchantment(Objects.requireNonNull(Enchantment.getEnchantmentByID(1)), 1);
        return super.getItemEnchantability(stack);
    }

}

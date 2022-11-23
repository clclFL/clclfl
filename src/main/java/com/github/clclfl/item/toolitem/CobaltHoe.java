package com.github.clclfl.item.toolitem;

import com.github.clclfl.Utils;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class CobaltHoe extends HoeItem {

    public CobaltHoe(IItemTier itemTier, int attackDamage, float attackSpeed, Properties properties) {
        super(itemTier, attackDamage, attackSpeed, properties);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        ToolTipHelper.addNormalToolInfo(new ToolTipHelper.ToolItemContext(stack , worldIn , tooltip , flagIn) ,
                "cobaltHoe.line1" , "cobaltHoe.line2");
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote && entityIn instanceof PlayerEntity) {
            PlayerEntity playerIn = (PlayerEntity) entityIn;

            if (playerIn.getHeldItem(Hand.MAIN_HAND).isItemEqual(stack)
                    || playerIn.getHeldItem(Hand.OFF_HAND).isItemEqual(stack)) {
                EffectInstance effect = playerIn.getActivePotionEffect(Effects.SPEED);

                if (effect == null) {
                    playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 60, 0));
//                    consumeDamage(stack, worldIn, playerIn , 1);
                } else if (effect.getDuration() < 20 && effect.getDuration() <= 0) {
                    playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 60, 0));
//                    consumeDamage(stack, worldIn, playerIn , 1);
                }
            }
        }
    }

    public void consumeDamage(ItemStack stack, World worldIn, PlayerEntity entityIn , int amount) {
        if (!worldIn.isRemote && stack != null) {
            PlayerEntity player = entityIn;
            boolean isInMainHand = player.getHeldItem(Hand.MAIN_HAND).isItemEqual(stack);
            if (isInMainHand) {
                stack.damageItem(amount, player, playerIn -> playerIn.sendBreakAnimation(Hand.MAIN_HAND));
            } else {
                stack.damageItem(amount, player, playerIn -> playerIn.sendBreakAnimation(Hand.OFF_HAND));
            }
        }
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return super.shouldCauseReequipAnimation(oldStack, newStack, slotChanged);
    }
}

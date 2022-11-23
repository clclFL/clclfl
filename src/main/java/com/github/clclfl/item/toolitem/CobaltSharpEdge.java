package com.github.clclfl.item.toolitem;

import com.github.clclfl.Utils;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class CobaltSharpEdge extends SwordItem {

    public CobaltSharpEdge(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        ToolTipHelper.addNormalToolInfo(new ToolTipHelper.ToolItemContext(stack , worldIn , tooltip , flagIn) ,
                "cobaltSharpEdge.line1");

        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

//    @Override
//    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
//        if (!player.getEntityWorld().isRemote
//                && (player.getHeldItem(Hand.MAIN_HAND).isItemEqual(stack)
//                || player.getHeldItem(Hand.OFF_HAND).isItemEqual(stack))){
//            System.out.println(entity + "is being attacked by " + player.getDisplayName());
//        }
//        return super.onLeftClickEntity(stack, player, entity);
//    }
}

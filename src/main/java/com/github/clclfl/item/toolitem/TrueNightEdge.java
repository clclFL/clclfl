package com.github.clclfl.item.toolitem;

import com.github.clclfl.Utils;
import com.github.clclfl.item.ModItemTier;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class TrueNightEdge extends SwordItem {

    public TrueNightEdge(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        ToolTipHelper.addNormalToolInfo(new ToolTipHelper.ToolItemContext(stack, worldIn, tooltip, flagIn)
                , "trueNightEdge.line1");
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}

package com.github.clclfl.item;

import com.github.clclfl.Utils;
import com.github.clclfl.item.toolitem.ToolTipHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class CobaltCore extends Item {

    public CobaltCore(Properties properties) {
        super(properties);
    }
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
//        if (!Screen.hasShiftDown()){
//            tooltip.add(ToolTipHelper.getNormalDisplayTip());
//        } else {
//            tooltip.add(Utils.TipHelper.getNormalTip("tooltip.clclfl.cobaltCore.line1"));
//            tooltip.add(Utils.TipHelper.getNormalTip("tooltip.clclfl.cobaltCore.line2"));
//            tooltip.add(Utils.TipHelper.getCustomTooltip("tooltip.clclfl.cobaltCore.line3"
//                    , TextFormatting.GRAY , TextFormatting.BOLD));
//        }
        ToolTipHelper.addNormalToolInfo(new ToolTipHelper.ToolItemContext(stack , worldIn , tooltip , flagIn) ,
                "cobaltCore.line1" , "cobaltCore.line2" , "cobaltCore.line3");
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}

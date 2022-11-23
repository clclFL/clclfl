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

public class AmethystCore extends Item {

    public AmethystCore(Properties properties) {
        super(properties);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        ToolTipHelper.addNormalToolInfo(new ToolTipHelper.ToolItemContext(stack , worldIn , tooltip , flagIn) ,
                "amethystCore.line1" , "amethystCore.line2" , "amethystCore.line3");

        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}

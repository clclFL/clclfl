package com.github.clclfl.item.blockitem;

import com.github.clclfl.Utils;
import com.github.clclfl.block.BlockRegistryHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class AmethystBlock extends BlockItem {

    public AmethystBlock(Properties builder) {
        super(BlockRegistryHandler.AMETHYST_BLOCK.get(), builder);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(Utils.TipHelper.getTip("tooltip.clclfl.amethystBlock.line1"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}

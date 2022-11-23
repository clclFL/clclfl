package com.github.clclfl.block;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nullable;
import java.util.List;

public class CobaltOre extends Block {

    public CobaltOre(Properties properties) {
        super(properties);
    }

//    @Override
//    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
//        tooltip.add(Utils.getTooltip("cobaltOre.line1"));
//        super.addInformation(stack, worldIn, tooltip, flagIn);
//    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? 1 + this.RANDOM.nextInt(5) : 0;
    }
}

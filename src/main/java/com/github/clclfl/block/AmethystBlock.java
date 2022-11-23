package com.github.clclfl.block;

import com.github.clclfl.item.Amethyst;
import com.github.clclfl.item.ItemRegistryHandler;
import com.github.clclfl.tags.ClclflTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public class AmethystBlock extends Block {

    public AmethystBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if (!worldIn.isRemote){
            entityIn.setFire(5);
        }
        super.onEntityWalk(worldIn, pos, entityIn);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (handIn == Hand.OFF_HAND){
            System.out.println("off hand click");
        }

//        if (!worldIn.isRemote){
//            if (handIn == Hand.MAIN_HAND && player.getHeldItem(Hand.MAIN_HAND)
//
//                    .isItemEqual(new ItemStack(ItemRegistryHandler.AMETHYST_CORE.get()))) {
//        if (!worldIn.isRemote){
//            if (handIn == Hand.MAIN_HAND && player.getHeldItem(Hand.MAIN_HAND).getItem().isIn(
//                    ClclflTags.Items.COBALT_RECIPES_MATERIALS))
                //                if (!player.isCreative()) {
//                    player.getHeldItem(Hand.MAIN_HAND)
//                            .setCount(player.getHeldItem(Hand.MAIN_HAND).getCount() - 1);
//                }
//                System.out.println("main hand click, block should be destroyed");
//                worldIn.destroyBlock(pos, false);

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        float chance = 0.35f;
        if (chance < rand.nextFloat()){
            worldIn.addParticle(ParticleTypes.FLAME , pos.getX() + rand.nextDouble() ,
                    pos.getY() + 0.50 , pos.getZ() + rand.nextDouble() ,
                    0.0D , 0.05D , 0.0D);
        }

        super.animateTick(stateIn, worldIn, pos, rand);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        if (!worldIn.isRemote){
            System.out.println("left click");
        }
    }
}

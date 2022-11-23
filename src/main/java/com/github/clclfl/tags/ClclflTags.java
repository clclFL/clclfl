package com.github.clclfl.tags;

import com.github.clclfl.Utils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class ClclflTags {

    public static class Blocks {

        public static final Tags.IOptionalNamedTag<Block> COBALT_BLOCK_MATERIALS =
                createTag("cobalt_block_materials");

        private static Tags.IOptionalNamedTag<Block> createTag(String name){
            return BlockTags.createOptional(new ResourceLocation(Utils.MOD_ID , name));
        }

        private static Tags.IOptionalNamedTag<Block> createForgeTags(String name){
            return BlockTags.createOptional(new ResourceLocation("forge" , name));
        }

    }

    public static class Items{

        public static final Tags.IOptionalNamedTag<Item> COBALT_RECIPES_MATERIALS =
                createTag("gems/cobalt_recipes_material");
        public static final Tags.IOptionalNamedTag<Item> COBALT_BLOCK_MATERIAL =
                createTag("cobalt_block_materials");

        private static Tags.IOptionalNamedTag<Item> createTag(String name){
            return ItemTags.createOptional(new ResourceLocation(Utils.MOD_ID , name));
        }

        private static Tags.IOptionalNamedTag<Item> createForgeTags(String name){
            return ItemTags.createOptional(new ResourceLocation("forge" , name));
        }
    }
}

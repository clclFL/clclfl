package com.github.clclfl.block;

import com.github.clclfl.Utils;
import com.github.clclfl.creativetab.ModCreativeTab;
import com.github.clclfl.item.ItemRegistryHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BlockRegistryHandler {

    public static final DeferredRegister<Block> BLOCK_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, Utils.MOD_ID);

    public static final RegistryObject<Block> COBALT_BLOCK = registryBlock("cobalt_block",
            () -> new CobaltBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(8f)));

    public static final RegistryObject<Block> COBALT_ORE = registryBlock("cobalt_ore",
            () -> new CobaltOre(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool()
                    .hardnessAndResistance(5f)));

    public static final RegistryObject<Block> COBALT_ORE_NETHER = registryBlock("cobalt_ore_nether",
            () -> new CobaltOreNether(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool()
                    .hardnessAndResistance(5f)));

    public static final RegistryObject<Block> AMETHYST_BLOCK = BLOCK_REGISTER.register("amethyst_block",
            () -> new AmethystBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(8f)));

    public static final RegistryObject<Block> COBALT_BLOCK_NATIVE = BLOCK_REGISTER.register(
            "cobalt_block_native", () -> new CobaltBlockNative(
                    AbstractBlock.Properties.create(Material.IRON).harvestLevel(2).harvestTool(ToolType.PICKAXE)
                            .setRequiresTool().hardnessAndResistance(5f)));

    public static final RegistryObject<Block> COBALT_STAIRS = registryBlock("cobalt_stairs",
            () -> new StairsBlock(() -> COBALT_BLOCK_NATIVE.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.IRON).harvestLevel(3).harvestTool(ToolType.PICKAXE)
                            .setRequiresTool().hardnessAndResistance(5f)));

    public static final RegistryObject<Block> COBALT_FENCE = registryBlock("cobalt_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.IRON).harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f)));

    public static final RegistryObject<Block> COBALT_FENCE_GATE = registryBlock("cobalt_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.IRON).harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f)));

    public static final RegistryObject<Block> COBALT_SLAB = registryBlock("cobalt_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.IRON).harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f)));

    public static final RegistryObject<Block> COBALT_BUTTON = registryBlock("cobalt_button",
            () -> new StoneButtonBlock(AbstractBlock.Properties.create(Material.IRON).harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f).doesNotBlockMovement()));

    public static final RegistryObject<Block> COBALT_PRESSURE_PLATE = registryBlock("cobalt_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.IRON).harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f)));


    /**  REGISTRY METHOD  */
    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCK_REGISTER.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ItemRegistryHandler.ITEM_REGISTER.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModCreativeTab.TAB_CLCLFL)));
    }

    @Deprecated
    public static void register(IEventBus eventBus) {
        BLOCK_REGISTER.register(eventBus);
    }

}

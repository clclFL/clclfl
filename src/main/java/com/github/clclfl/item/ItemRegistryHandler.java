package com.github.clclfl.item;

import com.github.clclfl.Utils;
import com.github.clclfl.creativetab.ModCreativeTab;
import com.github.clclfl.item.blockitem.AmethystBlock;
import com.github.clclfl.item.blockitem.CobaltBlockNative;
import com.github.clclfl.item.toolitem.*;
import com.github.clclfl.sound.SoundEventRegistryHandler;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistryHandler {

    //Item register
    public static final DeferredRegister<Item> ITEM_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

    /** Icon item registry */
    public static final RegistryObject<Item> COBALT_INGOT = ITEM_REGISTER.register(
            "cobalt_ingot", () -> new CobaltIngot(new Item.Properties().group(ModCreativeTab.TAB_CLCLFL)));

    //    public static final RegistryObject<Item> COBALT_SHARP_EDGE = REGISTRY.register("cobalt_sharp_edge" , CobaltSharpEdge::new);
//    public static final RegistryObject<Item> COBALT_SHARP_EDGE = ITEM_REGISTER.register("cobalt_sharp_edge",
//            () -> new CobaltSharpEdge(ModItemTier.COBALT , 4 , -2.4f ,
//                    new Item.Properties().group(ModCreativeTab.TAB_WEAPON)));

    /** Cobalt tool */
    public static final RegistryObject<Item> COBALT_SHARP_EDGE = ITEM_REGISTER.register(
            "cobalt_sharp_edge" , () -> new CobaltSharpEdge(ModItemTier.COBALT , 2 , -2.2f,
                    new Item.Properties().group(ModCreativeTab.TAB_TOOL)));

    public static final RegistryObject<Item> COBALT_SWORD = ITEM_REGISTER.register(
            "cobalt_sword" , () -> new CobaltSword(ModItemTier.COBALT , 5 , -2.4f,
                    new Item.Properties().group(ModCreativeTab.TAB_TOOL)));

    public static final RegistryObject<Item> TRUE_NIGHT_EDGE = ITEM_REGISTER.register(
            "true_night_edge" , () -> new TrueNightEdge(ModItemTier.TRUE_NIGHT_EDGE , 6 , -2.6f,
                    new Item.Properties().group(ModCreativeTab.TAB_TOOL)));

    public static final RegistryObject<Item> TRUE_EXCALIBUR = ITEM_REGISTER.register(
            "true_excalibur" , () -> new TrueExcalibur(ModItemTier.TRUE_NIGHT_EDGE , 1 , -2.2f,
                    new Item.Properties().group(ModCreativeTab.TAB_TOOL)));

//    public static final RegistryObject<Item> COBALT_SPEAR = ITEM_REGISTER.register(
//            "cobalt_spear" , () -> new CobaltSpear(ModItemTier.COBALT , 8 , -2.8f,
//                    new Item.Properties().group(ModCreativeTab.TAB_TOOL)));

    public static final RegistryObject<Item> COBALT_PICKAXE = ITEM_REGISTER.register(
            "cobalt_pickaxe" , () -> new PickaxeItem(ModItemTier.COBALT, 3 , -3.0f,
                    new Item.Properties().group(ModCreativeTab.TAB_TOOL)));

    public static final RegistryObject<Item> COBALT_SHOVEL = ITEM_REGISTER.register(
            "cobalt_shovel" , () -> new ShovelItem(ModItemTier.COBALT , 2 , -3.0f,
                    new Item.Properties().group(ModCreativeTab.TAB_TOOL)));

    public static final RegistryObject<Item> COBALT_AXE = ITEM_REGISTER.register(
            "cobalt_axe" , () -> new AxeItem(ModItemTier.COBALT , 7 , -3.0f,
                    new Item.Properties().group(ModCreativeTab.TAB_TOOL)));

    public static final RegistryObject<Item> COBALT_HOE = ITEM_REGISTER.register(
            "cobalt_hoe" , () -> new CobaltHoe(ModItemTier.COBALT , 1 , -3.0f,
                    new Item.Properties().group(ModCreativeTab.TAB_TOOL)));

    public static final RegistryObject<Item> COBALT_HORSE_ARMOR = ITEM_REGISTER.register(
            "cobalt_horse_armor" , () -> new HorseArmorItem(13 , "cobalt" ,
                    new Item.Properties().group(ModCreativeTab.TAB_CLCLFL)));

    /*
     public HorseArmorItem(int armorValue, String tierArmor, Item.Properties builder) {
        this(armorValue, new ResourceLocation("textures/entity/horse/armor/horse_armor_" + tierArmor + ".png"), builder);
     }
     */

    /** Normal registry */
    public static final RegistryObject<Item> AMETHYST = ITEM_REGISTER.register(
            "amethyst" , () -> new Amethyst(new Item.Properties().group(ModCreativeTab.TAB_CLCLFL)));

    public static final RegistryObject<Item> COBALT_CRYSTALS = ITEM_REGISTER.register(
            "cobalt_crystals" , () -> new CobaltCrystals(
                    new Item.Properties().group(ModCreativeTab.TAB_CLCLFL)));

    public static final RegistryObject<Item> COBALT_CRYSTALS_CLUSTER = ITEM_REGISTER.register(
            "cobalt_crystals_cluster" , () -> new CobaltCrystalsCluster(
                    new Item.Properties().group(ModCreativeTab.TAB_CLCLFL)));

    public static final RegistryObject<Item> COBALT_CRYSTALS_BUNCH = ITEM_REGISTER.register(
            "cobalt_crystals_bunch" , () -> new Item(
                    new Item.Properties().group(ModCreativeTab.TAB_CLCLFL)));

    public static final RegistryObject<BlockItem> AMETHYST_BLOCK = ITEM_REGISTER.register(
            "amethyst_block" , () -> new AmethystBlock(
                    new Item.Properties().group(ModCreativeTab.TAB_CLCLFL)));

    public static final RegistryObject<Item> AMETHYST_CORE = ITEM_REGISTER.register(
            "amethyst_core" , () -> new AmethystCore(
                    new Item.Properties().food(new Food.Builder().hunger(4)
                                    .setAlwaysEdible().saturation(4)
                                    .effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE , 200) , 0.25f)
                                    .fastToEat().build())
                            .group(ModCreativeTab.TAB_CLCLFL)));

    public static final RegistryObject<Item> COBALT_CORE = ITEM_REGISTER.register(
            "cobalt_core" , () -> new CobaltCore(
                    new Item.Properties().group(ModCreativeTab.TAB_CLCLFL)
                            .food(new Food.Builder().hunger(4).saturation(4).setAlwaysEdible()
                                    .effect(() -> new EffectInstance(Effects.GLOWING , 300) , 0.5f)
                                    .fastToEat().build())
                            .maxStackSize(16)
            ));

    public static final RegistryObject<Item> REALLY_DELICIOUS_APPLE = ITEM_REGISTER.register(
            "really_delicious_apple" , () -> new ReallyDeliciousApple(
                    new Item.Properties().group(ModCreativeTab.TAB_CLCLFL)
                            .food(new Food.Builder().hunger(10).saturation(7).setAlwaysEdible()
                                    .effect(new EffectInstance(Effects.REGENERATION , 100 , 2) , 1.0f)
                                    .build())
                            .maxStackSize(64)
            ));

    public static final RegistryObject<BlockItem> COBALT_BLOCK_NATIVE = ITEM_REGISTER.register(
            "cobalt_block_native" , () -> new CobaltBlockNative(
                    new Item.Properties().group(ModCreativeTab.TAB_CLCLFL)));

    //test item
//    public static final RegistryObject<Item> TEST = ITEM_REGISTER.register(
//            "test" , () -> new Test(new Item.Properties().group(ModCreativeTab.TAB_CLCLFL)));

    @Deprecated
    public static <T extends Item> RegistryObject<T> register(String name, T item) {
        return ITEM_REGISTER.register(name, () -> item);
    }

    @Deprecated
    public static void register(IEventBus eventBus) {
        eventBus.register(eventBus);
    }

}

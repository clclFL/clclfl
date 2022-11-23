package com.github.clclfl;

import com.github.clclfl.block.BlockRegistryHandler;
import com.github.clclfl.paintings.PaintingRegistryHandler;
import com.github.clclfl.client.config.Config;
import com.github.clclfl.item.ItemRegistryHandler;
import com.github.clclfl.keybind.KeyBinds;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import org.apache.commons.lang3.tuple.Pair;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Utils.MOD_ID)
public class Clclfl {
    private static final Logger LOGGER = LogManager.getLogger();

    public Clclfl() {
        //Event bus for registering.
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext context = ModLoadingContext.get();

        //Registry block, item and sound
        ItemRegistryHandler.ITEM_REGISTER.register(eventBus);
        BlockRegistryHandler.BLOCK_REGISTER.register(eventBus);

//        PaintingRegistryHandler.PAINTING_REGISTER.register(eventBus);
        PaintingRegistryHandler.register(eventBus);

//        ItemRegistryHandler.register(eventBus);
//        BlockRegistryHandler.register(eventBus);
//        SoundEventRegistryHandler.register(eventBus);

        // Register the setup method for modloading
        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);

        //registry config and Screen
        context.registerConfig(ModConfig.Type.COMMON, Config.CLCLFL_CONFIG);
        context.registerExtensionPoint(
                ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY,
                        (a, b) -> true));

        MinecraftForge.EVENT_BUS.register(this);
    }

    // some example code to dispatch IMC to another mod
    private void enqueueIMC(final InterModEnqueueEvent event)
    {
//        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        //keybinds registry
    }

    public static Logger getLogger() {
        return LOGGER;
    }

    // some example code to receive and process InterModComms from other mods
    private void processIMC(final InterModProcessEvent event)
    {
//        LOGGER.info("Got IMC {}", event.getIMCStream().
//                map(m->m.getMessageSupplier().get()).
//                collect(Collectors.toList()));
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
//            LOGGER.info("HELLO from Register Block");
        }
    }
}

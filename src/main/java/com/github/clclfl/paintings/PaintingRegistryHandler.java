package com.github.clclfl.paintings;

import com.github.clclfl.Utils;
import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PaintingRegistryHandler {

    public static final DeferredRegister<PaintingType> PAINTING_REGISTER =
            DeferredRegister.create(ForgeRegistries.PAINTING_TYPES , Utils.MOD_ID);

    public static final RegistryObject<PaintingType> HISTORY_OF_ISLAND =
            PAINTING_REGISTER.register("history_of_island" , () -> new PaintingType(64 , 32));
    public static final RegistryObject<PaintingType> PRE_GENERATION_AND_BOSSES =
            PAINTING_REGISTER.register("pregeneration_and_bosses" , () -> new PaintingType(64 , 32));

    public static void register(IEventBus eventBus){
        PAINTING_REGISTER.register(eventBus);
    }
}

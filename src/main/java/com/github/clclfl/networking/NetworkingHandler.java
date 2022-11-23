package com.github.clclfl.networking;

import com.github.clclfl.Utils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetworkingHandler {

    public static SimpleChannel INSTANCE_1;
    public static SimpleChannel SOUND_CHANNEL;
    public static final String VERSION = "1.0";
    private static int ID = 0;

    public static int nextID(){
        return ID++;
    }

    public static void registerMessage(){
        INSTANCE_1 = NetworkRegistry.newSimpleChannel(

                new ResourceLocation(Utils.MOD_ID , "test_networking"),
                () -> VERSION,
                (version) -> version.equals(VERSION),
                (version) -> version.equals(VERSION)
        );

        INSTANCE_1.messageBuilder(SendPack.class , nextID())
                .encoder(SendPack::toByte).decoder(SendPack::new).consumer(SendPack::handler).add();

        SOUND_CHANNEL = NetworkRegistry.newSimpleChannel(
                new ResourceLocation(Utils.MOD_ID , "sound_networking"),
                () -> VERSION,
                (version) -> version.equals(VERSION),
                (version) -> version.equals(VERSION)
        );

//        SOUND_CHANNEL.registerMessage(nextID() , SoundEventPack.class ,
//                SoundEventPack::toByte , SoundEventPack::new , SoundEventPack::handle);

        /*
           public <MSG> IndexedMessageCodec.MessageHandler<MSG>
                registerMessage(int index,
                        Class<MSG> messageType,
                        BiConsumer<MSG, PacketBuffer> encoder,
                        Function<PacketBuffer, MSG> decoder,
                        BiConsumer<MSG, Supplier<NetworkEvent.Context>> messageConsumer) {

           return registerMessage(index, messageType, encoder, decoder, messageConsumer, Optional.empty());
    }
        */
    }
}

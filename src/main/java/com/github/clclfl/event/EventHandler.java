package com.github.clclfl.event;

import com.github.clclfl.Utils;

import com.github.clclfl.commands.ReturnHomeCommand;
import com.github.clclfl.commands.SetHomeCommand;
import com.github.clclfl.networking.NetworkingHandler;
import com.github.clclfl.sound.SoundEventRegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.management.PlayerList;

import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import net.minecraftforge.event.OnDatapackSyncEvent;

import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = Utils.MOD_ID)
public class EventHandler {

    /**
     * Command Register
     * @param event
     */
    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event){
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    //After player died
    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone event){
        if (!event.getOriginal().getEntityWorld().isRemote){
            event.getPlayer().getPersistentData().putIntArray(
                    Utils.MOD_ID + "homepos" , event.getOriginal().getPersistentData().getIntArray(
                            Utils.MOD_ID + "homepos"));
        }
    }
    @SubscribeEvent
    public static void onPlayerJoinIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getPlayer() != null && !event.getPlayer().world.isRemote) {
//            Clclfl.getLogger().info("Server Side UUID : " + event.getPlayer().getUniqueID());
        }
    }

    /**
     * This event will be fired once player get into the server or put into command "/reload",
     * in this method developer can add some custom packet in it to make Sync.
     */
    public static void onDatapackSync(OnDatapackSyncEvent event) {
        if (event.getPlayer() == null) {

        }
    }
}


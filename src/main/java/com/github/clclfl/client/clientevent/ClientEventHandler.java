package com.github.clclfl.client.clientevent;

import com.github.clclfl.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.util.text.*;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityLeaveWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = Utils.MOD_ID, value = Dist.CLIENT)
public class ClientEventHandler {

    private static UUID currentUUID = null;

    @SubscribeEvent
    public static void onPlayerJoinIn(EntityJoinWorldEvent event) {
        if (!event.getEntity().getEntityWorld().isRemote && event.isCanceled()) return;
        ClientPlayerEntity clientPlayer = Minecraft.getInstance().player;
        if (clientPlayer == null) return;
        if (currentUUID == null) {
            currentUUID = clientPlayer.getUniqueID();
            sendOriginalMsg(clientPlayer);
        }
    }

    public static void sendOriginalMsg(ClientPlayerEntity clientPlayer) {
        clientPlayer.sendMessage(new TranslationTextComponent(
                "message.clclfl.join1", clientPlayer.getName().getString()), UUID.randomUUID());

        clientPlayer.sendMessage(new TranslationTextComponent(
                "message.clclfl.join2"), UUID.randomUUID());

        clientPlayer.sendMessage(new TranslationTextComponent(
                "message.clclfl.join3").setStyle(Style.EMPTY.setClickEvent(
                new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.blu3fat.club/program")
        )), UUID.randomUUID());
    }

    @SubscribeEvent
    public static void onPlayerLoggedOut(EntityLeaveWorldEvent event) {
        if (!event.isCanceled() && event.getWorld().isRemote) {
            ClientPlayerEntity clientPlayer = Minecraft.getInstance().player;
            if (clientPlayer != null) {
                //do some stuff while client player leaving
            }
        }
    }

    /**
     * Key input event
     */
//    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        Minecraft client = Minecraft.getInstance();
        ClientPlayerEntity player = client.player;
        if (player != null) {
        }
    }
}


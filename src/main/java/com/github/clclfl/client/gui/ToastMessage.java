package com.github.clclfl.client.gui;

import com.github.clclfl.Utils;
import com.github.clclfl.client.clientevent.ClientEventHandler;
import com.github.clclfl.client.config.Config;
import com.github.clclfl.item.ItemRegistryHandler;
import com.github.clclfl.sound.SoundEventRegistryHandler;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.EntityTickableSound;
import net.minecraft.client.gui.toasts.IToast;
import net.minecraft.client.gui.toasts.ToastGui;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;

import java.util.Objects;

public class ToastMessage implements IToast {

    private ItemStack itemStack;
    private long firstDrawTime = 1000L;
    private String title;
    private String description;
    private boolean hasPlayedSound = false;
    private final ResourceLocation TEXTURE_TOASTS = new ResourceLocation(Utils.MOD_ID ,
            "textures/gui/toasts.png");
    private static int stringNum = 0;

    private final static int TOAST_Y = 0;

    private int getStringPosY(){
        return stringNum++ == 0 ? TOAST_Y + 7 : TOAST_Y + 18;
    }

    public void show(String title, String description) {
        this.title = title;
        this.description = description;
        this.itemStack = new ItemStack(ItemRegistryHandler.COBALT_INGOT.get());
        firstDrawTime = 500L;
        Minecraft.getInstance().getToastGui().add(this);
    }

    //draw method
    @SuppressWarnings("NullableProblems")
    @Override
    public Visibility func_230444_a_(MatrixStack matrixStack, ToastGui toastGui, long delta) {
        stringNum = 0;
        toastGui.getMinecraft().getTextureManager().bindTexture(TEXTURE_TOASTS);
        GlStateManager.blendColor(1.0F, 1.0F, 1.0F, 1.0F);
        toastGui.blit(new MatrixStack(), 0, TOAST_Y, 0, 0, 160, 32);
        toastGui.getMinecraft().fontRenderer.drawString(matrixStack, title, 30, getStringPosY(), 100000);
        toastGui.getMinecraft().fontRenderer.drawString(matrixStack, description, 30, getStringPosY(), 100000);
        if (!this.hasPlayedSound && delta > 0L) {
            this.hasPlayedSound = true;
            toastGui.getMinecraft().getSoundHandler().play(new EntityTickableSound(
                    SoundEvents.BLOCK_NOTE_BLOCK_BIT, SoundCategory.RECORDS , 2, 1 ,
                    Objects.requireNonNull(Minecraft.getInstance().player)));
        }
        RenderHelper.enableStandardItemLighting();
        toastGui.getMinecraft().getItemRenderer().renderItemAndEffectIntoGUI(null, itemStack, 8, TOAST_Y + 8);
        return delta - this.firstDrawTime >= 2000L ? IToast.Visibility.HIDE : IToast.Visibility.SHOW;
    }
}

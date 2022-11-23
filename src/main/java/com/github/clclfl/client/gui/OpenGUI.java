package com.github.clclfl.client.gui;

import com.github.clclfl.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TranslationTextComponent;

public class OpenGUI {

    public OpenGUI() {
        Minecraft.getInstance().displayGuiScreen(new ObsidianFirstGui(new TranslationTextComponent(Utils.MOD_ID + ".test")));
    }
}
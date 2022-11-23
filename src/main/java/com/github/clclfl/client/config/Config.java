package com.github.clclfl.client.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {

    public static ForgeConfigSpec CLCLFL_CONFIG;
    public static ForgeConfigSpec.BooleanValue DISABLE_BACKPACKSOUND;
    public static ForgeConfigSpec.IntValue BACK_PACK_SOUND_STATUE;
    public static ForgeConfigSpec.IntValue MUSIC_BOX_CLEW_TONE;


    static {
        //create a builder.
        ForgeConfigSpec.Builder CONFIG_BUILDER = new ForgeConfigSpec.Builder();
        //upload options into builder with "push", and refresh the data with "pop".
        CONFIG_BUILDER.comment("General Setting").push("general");

        CONFIG_BUILDER.pop();
        CLCLFL_CONFIG = CONFIG_BUILDER.build();
    }
}

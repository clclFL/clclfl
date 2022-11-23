package com.github.clclfl.commands;

import com.github.clclfl.Utils;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;

public class ReturnHomeCommand {

    public ReturnHomeCommand(CommandDispatcher<CommandSource> dispatcher){
        dispatcher.register(Commands.literal("home").executes(
                (command) -> returnHome(command.getSource())));
    }

    private int returnHome(CommandSource source) throws CommandSyntaxException {
        ServerPlayerEntity player = source.asPlayer();
        boolean hasHomepos = player.getPersistentData().getIntArray(Utils.MOD_ID + "homepos").length != 0;

        if (!hasHomepos){
            source.sendFeedback(Utils.TipHelper.getTip("command.clclfl.setHomeCommand.setPos") ,true);
            return -1;
        } else {
            int[] playerPos = player.getPersistentData().getIntArray(Utils.MOD_ID + "homepos");
            player.setPositionAndUpdate(playerPos[0] , playerPos[1] , playerPos[2]);
            source.sendFeedback(Utils.TipHelper.getTip("command.clclfl.returnHomeCommand.playerReturnHome") , true);
            return 1;
        }

    }

}

package com.github.clclfl.commands;

import com.github.clclfl.Utils;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;

public class SetHomeCommand {

    public SetHomeCommand(CommandDispatcher<CommandSource> dispatcher){
        dispatcher.register(Commands.literal("sethome").executes((command) -> {
            return setHome(command.getSource());
        }
        ));
    }

    private static int setHome(CommandSource source) throws CommandSyntaxException {
        ServerPlayerEntity player = source.asPlayer();
        BlockPos playerPosition = player.getPosition();

        //Record with modid, player's position.
        player.getPersistentData().putIntArray(Utils.MOD_ID + "homepos",
                new int[]{playerPosition.getX() , playerPosition.getY() , playerPosition.getZ()});

        String pos = "(" + playerPosition.getX() + ", " + playerPosition.getY() + ", " + playerPosition.getZ() + ")";
        source.sendFeedback(new TranslationTextComponent("command.clclfl.setHomeCommand.setPos" , pos) , true);
//        source.sendFeedback(new TranslationTextComponent(
//                "command.clclfl.setHomeCommand.setPos" , pos) , true);
        return 1;
    }
}

package com.grandmen123.xtutorial.cmd.custom;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;

public class Gm {
    public static void register(CommandDispatcher<ServerCommandSource> serverCommandSourceCommandDispatcher,
                                CommandRegistryAccess commandRegistryAccess,
                                CommandManager.RegistrationEnvironment registrationEnvironment) {
        serverCommandSourceCommandDispatcher.register(CommandManager.literal("gms").executes(Gm::runS));
        serverCommandSourceCommandDispatcher.register(CommandManager.literal("gmc").executes(Gm::runC));
        serverCommandSourceCommandDispatcher.register(CommandManager.literal("gma").executes(Gm::runA));
        serverCommandSourceCommandDispatcher.register(CommandManager.literal("gmsp").executes(Gm::runSP));
    }

    public static int runS(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        return run(context, GameMode.SURVIVAL);
    }

    public static int runC(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        return run(context, GameMode.CREATIVE);
    }

    public static int runA(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        return run(context, GameMode.ADVENTURE);
    }

    public static int runSP(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        return run(context, GameMode.SPECTATOR);
    }

    public static int run(CommandContext<ServerCommandSource> context, GameMode gameMode) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().getPlayer();
        if (player == null || gameMode == null) {
            context.getSource().sendFeedback(() -> Text.translatable("command.xtutorial.gm.failure"), false);
            return -1;
        }

        player.changeGameMode(gameMode);
        context.getSource().sendFeedback(() -> Text.translatable("command.xtutorial.gm.success")
                                                   .append(gameMode.getTranslatableName()),
                                         false);

        return 0;
    }
}

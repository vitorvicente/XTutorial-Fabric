package com.grandmen123.xtutorial.cmd.custom;

import com.grandmen123.xtutorial.util.IEntityDataSaver;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class Home {
    public static final String HOME_POS_KEY = "homepos";

    public static void register(CommandDispatcher<ServerCommandSource> serverCommandSourceCommandDispatcher,
                                CommandRegistryAccess commandRegistryAccess,
                                CommandManager.RegistrationEnvironment registrationEnvironment) {
        serverCommandSourceCommandDispatcher.register(
                CommandManager.literal("home").executes(Home::run));
        serverCommandSourceCommandDispatcher.register(
                CommandManager.literal("home").then(CommandManager.literal("set").executes(Home::runSet)));
    }

    public static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        IEntityDataSaver player = ((IEntityDataSaver) context.getSource().getPlayer());
        if (player == null || player.getPersistentData().getIntArray(HOME_POS_KEY).length != 3) {
            context.getSource().sendFeedback(() -> Text.translatable("command.xtutorial.home.failure"), false);
            return -1;
        }
        int[] homePos = player.getPersistentData().getIntArray(HOME_POS_KEY);

        context.getSource().getPlayer().requestTeleport(homePos[0], homePos[1], homePos[2]);
        context.getSource().sendFeedback(() -> Text.translatable("command.xtutorial.home.success")
                                                   .append(Text.literal(" ("
                                                                        + homePos[0]
                                                                        + ", " + homePos[1]
                                                                        + ", " + homePos[2] + ")")),
                                         false);

        return 0;
    }

    public static int runSet(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        IEntityDataSaver player = ((IEntityDataSaver) context.getSource().getPlayer());
        if (player == null) {
            context.getSource().sendFeedback(() -> Text.translatable("command.xtutorial.home.set.failure"), false);
            return -1;
        }

        BlockPos playerPos = context.getSource().getPlayer().getBlockPos();

        player.getPersistentData().putIntArray(Home.HOME_POS_KEY, new int[]{playerPos.getX(), playerPos.getY(),
                                                                            playerPos.getZ()});
        context.getSource().sendFeedback(() -> Text.translatable("command.xtutorial.home.set.success")
                                                   .append(Text.literal(" ("
                                                                        + playerPos.getX()
                                                                        + ", " + playerPos.getY()
                                                                        + ", " + playerPos.getZ() + ")")),
                                         false);
        return 0;
    }
}

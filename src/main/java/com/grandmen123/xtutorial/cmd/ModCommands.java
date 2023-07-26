package com.grandmen123.xtutorial.cmd;

import com.grandmen123.xtutorial.cmd.custom.Gm;
import com.grandmen123.xtutorial.cmd.custom.Home;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

import static com.grandmen123.xtutorial.XTutorial.LOGGER;

public class ModCommands {
    public static void registerCommands() {
        LOGGER.info("Registering Mod Commands");

        CommandRegistrationCallback.EVENT.register(Home::register);
        CommandRegistrationCallback.EVENT.register(Gm::register);
    }
}

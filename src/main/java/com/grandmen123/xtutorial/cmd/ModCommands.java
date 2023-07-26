package com.grandmen123.xtutorial.cmd;

import com.grandmen123.xtutorial.cmd.custom.Gm;
import com.grandmen123.xtutorial.cmd.custom.Home;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class ModCommands {
    public static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(Home::register);
        CommandRegistrationCallback.EVENT.register(Gm::register);
    }
}

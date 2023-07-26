package com.grandmen123.xtutorial.event;

import com.grandmen123.xtutorial.event.custom.AttackEntityHandler;
import com.grandmen123.xtutorial.event.custom.PlayerCopyHandler;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;

import static com.grandmen123.xtutorial.XTutorial.LOGGER;

public class ModEvents {
    public static void registerEvents() {
        LOGGER.info("Registering Mod Events");

        AttackEntityCallback.EVENT.register(new AttackEntityHandler());
        ServerPlayerEvents.COPY_FROM.register(new PlayerCopyHandler());
    }
}

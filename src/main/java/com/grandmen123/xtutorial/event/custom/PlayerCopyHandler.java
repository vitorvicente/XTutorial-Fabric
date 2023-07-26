package com.grandmen123.xtutorial.event.custom;

import com.grandmen123.xtutorial.cmd.custom.Home;
import com.grandmen123.xtutorial.util.IEntityDataSaver;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.server.network.ServerPlayerEntity;

public class PlayerCopyHandler implements ServerPlayerEvents.CopyFrom {
    @Override
    public void copyFromPlayer(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        ((IEntityDataSaver) newPlayer)
                .getPersistentData()
                .putIntArray(Home.HOME_POS_KEY, ((IEntityDataSaver) oldPlayer)
                        .getPersistentData()
                        .getIntArray(Home.HOME_POS_KEY));
    }
}

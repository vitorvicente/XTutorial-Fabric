package com.grandmen123.xtutorial;

import net.fabricmc.api.ClientModInitializer;

import static com.grandmen123.xtutorial.XTutorial.LOGGER;

public class XTutorialClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Client");
        LOGGER.info("Finished Initializing Client");
    }
}

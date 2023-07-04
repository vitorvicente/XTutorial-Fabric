package com.grandmen123.xtutorial;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import static com.grandmen123.xtutorial.XTutorial.LOGGER;

public class XTutorialDataGen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		LOGGER.info("Starting DataGen");
		LOGGER.info("Finished DataGen");
	}
}

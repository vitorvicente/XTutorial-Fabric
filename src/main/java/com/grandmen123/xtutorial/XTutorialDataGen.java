package com.grandmen123.xtutorial;

import com.grandmen123.xtutorial.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import static com.grandmen123.xtutorial.XTutorial.LOGGER;

public class XTutorialDataGen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		LOGGER.info("Starting DataGen");
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModBlockLootTableGen::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeGen::new);
		pack.addProvider(ModLangProviderENUS::new);
		pack.addProvider(ModPaintingTagProvider::new);
		pack.addProvider(ModAdvancementProvider::new);
		pack.addProvider(ModPOITagProvider::new);

		LOGGER.info("Finished DataGen");
	}
}

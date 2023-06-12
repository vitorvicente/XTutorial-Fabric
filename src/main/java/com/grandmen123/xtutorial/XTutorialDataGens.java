package com.grandmen123.xtutorial;

import com.grandmen123.xtutorial.data.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class XTutorialDataGens implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModBlockTagsGen::new);
        pack.addProvider(ModLangProvider::new);
        pack.addProvider(ModLootTableGen::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeGen::new);
        pack.addProvider(ModWorldGen::new);
    }
}

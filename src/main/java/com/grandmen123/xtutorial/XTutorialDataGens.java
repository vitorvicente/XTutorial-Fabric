package com.grandmen123.xtutorial;

import com.grandmen123.xtutorial.data.*;
import com.grandmen123.xtutorial.world.ModConfiguredFeatures;
import com.grandmen123.xtutorial.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class XTutorialDataGens implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModBlockTagsGen::new);
        pack.addProvider(ModItemTagsGen::new);
        pack.addProvider(ModLangProvider::new);
        pack.addProvider(ModLootTableGen::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeGen::new);
        pack.addProvider(ModWorldGen::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
    }
}

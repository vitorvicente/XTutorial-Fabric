package com.grandmen123.xtutorial.world.gen;

import com.grandmen123.xtutorial.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGen {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                                      GenerationStep.Feature.UNDERGROUND_ORES,
                                      ModPlacedFeatures.CITRINE_ORE_PLACED_KEY);
    }
}

package com.grandmen123.xtutorial.world.gen;

import com.grandmen123.xtutorial.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGen {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                                      GenerationStep.Feature.VEGETAL_DECORATION,
                                      ModPlacedFeatures.RED_MAPLE_PLACED_KEY);
    }
}

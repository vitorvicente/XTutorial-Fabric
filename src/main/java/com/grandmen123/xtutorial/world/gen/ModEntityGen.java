package com.grandmen123.xtutorial.world.gen;

import com.grandmen123.xtutorial.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntityGen {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SAVANNA), SpawnGroup.CREATURE,
                                    ModEntities.TIGER, 35, 1, 3);

        SpawnRestriction.register(ModEntities.TIGER, SpawnRestriction.Location.ON_GROUND,
                                  Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}

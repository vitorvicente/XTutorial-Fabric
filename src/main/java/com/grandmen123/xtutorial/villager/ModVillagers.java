package com.grandmen123.xtutorial.villager;

import com.google.common.collect.ImmutableSet;
import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

import static com.grandmen123.xtutorial.XTutorial.LOGGER;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> SOUND_POI_KEY = registerPoiKey("soundpoi");
    @SuppressWarnings("unused")
    public static final PointOfInterestType SOUND_POI = registerPoi("soundpoi", ModBlocks.SOUND_BLOCK);
    public static final VillagerProfession SOUND_MASTER = registerProfession("soundmaster", SOUND_POI_KEY);

    @SuppressWarnings("SameParameterValue")
    private static RegistryKey<PointOfInterestType> registerPoiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(XTutorial.MOD_ID, name));
    }

    @SuppressWarnings("SameParameterValue")
    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(XTutorial.MOD_ID, name), 1, 1, block);
    }

    @SuppressWarnings("SameParameterValue")
    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(XTutorial.MOD_ID, name),
                                 new VillagerProfession(name, entry -> true, entry -> entry.matchesKey(type),
                                                        ImmutableSet.of(), ImmutableSet.of(),
                                                        SoundEvents.ENTITY_VILLAGER_WORK_MASON));
    }

    public static void registerVillagers() {
        LOGGER.info("Registering Mod Villagers!");
    }
}

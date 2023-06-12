package com.grandmen123.xtutorial.world;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> RED_MAPLE_PLACED_KEY = registerKey("red_maple_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatureRegistryEntryLookup =
                context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, RED_MAPLE_PLACED_KEY,
                 configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_MAPLE_KEY),
                 VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                         PlacedFeatures.createCountExtraModifier(1, 0.1f, 3),
                         ModBlocks.RED_MAPLE_SAPLING));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(XTutorial.MOD_ID, name));
    }

    public static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    public static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}

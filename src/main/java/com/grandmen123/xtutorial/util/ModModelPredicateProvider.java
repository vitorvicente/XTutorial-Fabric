package com.grandmen123.xtutorial.util;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider {
    public static final String PREDICATE_ON_SUFFIX = "on";
    public static final String PREDICATE_OFF_SUFFIX = "off";

    public static void registerModModels() {
        ModelPredicateProviderRegistry.register(ModItems.DATA_TABLET,
                                                new Identifier(XTutorial.MOD_ID, PREDICATE_ON_SUFFIX),
                                                (stack, world, entity, seed) -> stack.hasNbt() ? 1 : 0);
    }
}

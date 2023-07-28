package com.grandmen123.xtutorial.util;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider {
    public static final String PREDICATE_ON_SUFFIX = "on";
    public static final String PREDICATE_OFF_SUFFIX = "off";

    public static void registerModModels() {
        ModelPredicateProviderRegistry.register(ModItems.DATA_TABLET,
                                                new Identifier(XTutorial.MOD_ID, PREDICATE_ON_SUFFIX),
                                                (stack, world, entity, seed) -> stack.hasNbt() ? 1 : 0);

        registerBow(ModItems.PINK_GARNET_BOW);
    }

    public static void registerBow(Item bow) {
        ModelPredicateProviderRegistry.register(bow, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0f;
            }
            if (entity.getActiveItem() != stack) {
                return 0.0f;
            }
            return (float) (stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f;
        });
        ModelPredicateProviderRegistry.register(bow, new Identifier("pulling"), (stack, world, entity, seed) ->
                entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f);

    }
}

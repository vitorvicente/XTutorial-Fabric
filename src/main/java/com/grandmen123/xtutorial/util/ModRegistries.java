package com.grandmen123.xtutorial.util;

import com.grandmen123.xtutorial.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
    }

    private static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.PEAT_BRICK, 200);
    }
}

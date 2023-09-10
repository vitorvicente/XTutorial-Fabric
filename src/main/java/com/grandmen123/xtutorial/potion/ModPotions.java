package com.grandmen123.xtutorial.potion;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.grandmen123.xtutorial.XTutorial.LOGGER;

public class ModPotions {

    @SuppressWarnings("unused")
    public static final Potion SLIMEY_POTION =
            registerPotion("slimey_potion",
                           new Potion(new StatusEffectInstance(ModEffects.SLIMEY, 1200, 0)));

    @SuppressWarnings("SameParameterValue")
    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(XTutorial.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        LOGGER.info("Registering Mod Potions");
    }
}

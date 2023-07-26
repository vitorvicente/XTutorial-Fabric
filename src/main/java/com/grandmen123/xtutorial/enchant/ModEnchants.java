package com.grandmen123.xtutorial.enchant;

import com.grandmen123.xtutorial.XTutorial;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.grandmen123.xtutorial.XTutorial.LOGGER;

public class ModEnchants {

    public static final Enchantment LIGHTING_STRIKER = register("lightning_striker",
                                                                new LightningStrikerEnchant(Enchantment.Rarity.UNCOMMON,
                                                                                            EnchantmentTarget.WEAPON,
                                                                                            EquipmentSlot.MAINHAND));

    private static Enchantment register(String name, Enchantment enchantment) {
        Registry.register(Registries.ENCHANTMENT, new Identifier(XTutorial.MOD_ID, name), enchantment);
        return enchantment;
    }

    public static void registerModEnchantments() {
        LOGGER.info("Registering Mod Enchantments");
    }
}

package com.grandmen123.xtutorial;

import com.grandmen123.xtutorial.block.ModBlocks;
import com.grandmen123.xtutorial.cmd.ModCommands;
import com.grandmen123.xtutorial.effect.ModEffects;
import com.grandmen123.xtutorial.enchant.ModEnchants;
import com.grandmen123.xtutorial.event.ModEvents;
import com.grandmen123.xtutorial.item.ModItems;
import com.grandmen123.xtutorial.painting.ModPaintings;
import com.grandmen123.xtutorial.particle.ModParticles;
import com.grandmen123.xtutorial.potion.ModPotions;
import com.grandmen123.xtutorial.sound.ModSounds;
import com.grandmen123.xtutorial.util.ModLootTableModifiers;
import com.grandmen123.xtutorial.util.ModRegistries;
import com.grandmen123.xtutorial.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XTutorial implements ModInitializer {

    public static final String MOD_ID = "xtutorial";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Mod");

        ModItemGroup.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModPaintings.registerPaintings();
        ModPotions.registerPotions();
        ModRegistries.registerModStuffs();

        ModEnchants.registerModEnchantments();
        ModEffects.registerEffects();
        ModCommands.registerCommands();
        ModEvents.registerEvents();
        ModSounds.registerSounds();
        ModParticles.registerParticles();
        ModVillagers.registerVillagers();

        ModLootTableModifiers.modifyLootTables();

        LOGGER.info("Finished Initializing Mod");
    }

	public static void addToItemGroup(ItemConvertible item) {
		ModItemGroup.addToItemGroup(item);
	}

    public static class ModItemGroup {
        public static ItemGroup XTUTORIAL_ITEM_GROUP;

        private static void addToItemGroup(ItemConvertible item) {
            ItemGroupEvents.modifyEntriesEvent(
					RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "xtutorial_itemgroup")))
                           .register(entries -> entries.add(item));
        }

        public static void registerItemGroups() {
			XTUTORIAL_ITEM_GROUP = Registry.register(
					Registries.ITEM_GROUP, new Identifier(MOD_ID, "xtutorial_itemgroup"),
					FabricItemGroup.builder().displayName(Text.translatable("itemgroup.xtutorial"))
								   .icon(() -> new ItemStack(ModItems.PINK_GARNET)).build());
        }

    }
}
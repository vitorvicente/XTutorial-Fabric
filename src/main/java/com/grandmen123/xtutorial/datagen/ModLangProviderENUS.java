package com.grandmen123.xtutorial.datagen;

import com.grandmen123.xtutorial.block.ModBlocks;
import com.grandmen123.xtutorial.effect.ModEffects;
import com.grandmen123.xtutorial.enchant.ModEnchants;
import com.grandmen123.xtutorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModLangProviderENUS extends FabricLanguageProvider {
    public ModLangProviderENUS(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("itemgroup.xtutorial", "XTutorial");

        translationBuilder.add(ModBlocks.PINK_GARNET_BLOCK, "Pink Garnet Block");
        translationBuilder.add(ModBlocks.PINK_GARNET_SLAB, "Pink Garnet Slabs");
        translationBuilder.add(ModBlocks.PINK_GARNET_STAIRS, "Pink Garnet Stairs");
        translationBuilder.add(ModBlocks.PINK_GARNET_BUTTON, "Pink Garnet Button");
        translationBuilder.add(ModBlocks.PINK_GARNET_PRESSURE_PLATE, "Pink Garnet Pressure Plate");
        translationBuilder.add(ModBlocks.PINK_GARNET_FENCE, "Pink Garnet Fence");
        translationBuilder.add(ModBlocks.PINK_GARNET_FENCE_GATE, "Pink Garnet Fence Gate");
        translationBuilder.add(ModBlocks.PINK_GARNET_WALL, "Pink Garnet Wall");
        translationBuilder.add(ModBlocks.PINK_GARNET_DOOR, "Pink Garnet Door");
        translationBuilder.add(ModBlocks.PINK_GARNET_TRAPDOOR, "Pink Garnet Trapdoor");

        translationBuilder.add(ModBlocks.RAW_PINK_GARNET_BLOCK, "Raw Pink Garnet Block");
        translationBuilder.add(ModItems.PINK_GARNET, "Pink Garnet");
        translationBuilder.add(ModItems.RAW_PINK_GARNET, "Raw Pink Garnet");
        translationBuilder.add(ModBlocks.PINK_GARNET_ORE, "Pink Garnet Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE, "DeepSlate Pink Garnet Ore");
        translationBuilder.add(ModBlocks.NETHERRACK_PINK_GARNET_ORE, "Netherrack Pink Garnet ore");
        translationBuilder.add(ModBlocks.END_STONE_PINK_GARNET_ORE, "End Stone Pink Garnet Ore");

        translationBuilder.add(ModItems.PEAT_BRICK, "Peat Brick");

        translationBuilder.add(ModBlocks.SOUND_BLOCK, "Sound Block");
        translationBuilder.add("block.xtutorial.sound_block.tooltip",
                               "Press §eSHIFT§r for More Information");
        translationBuilder.add("block.xtutorial.sound_block.tooltip.shift",
                               "Right Click this Block to Play a Sound!");

        translationBuilder.add(ModItems.METAL_DETECTOR, "Metal Detector");
        translationBuilder.add("item.xtutorial.metal_detector.no_valuables", "No Valuables Found");
        translationBuilder.add("item.xtutorial.metal_detector.found_valuables", "Found Valuables");
        translationBuilder.add("item.xtutorial.metal_detector.tooltip",
                               "Press §eSHIFT§r for More Information");
        translationBuilder.add("item.xtutorial.metal_detector.tooltip.shift",
                               "This item can help you find ores by right clicking surface blocks!");

        translationBuilder.add(ModItems.PINK_GARNET_SWORD, "Pink Garnet Sword");
        translationBuilder.add(ModItems.PINK_GARNET_PICKAXE, "Pink Garnet Pickaxe");
        translationBuilder.add(ModItems.PINK_GARNET_AXE, "Pink Garnet Axe");
        translationBuilder.add(ModItems.PINK_GARNET_SHOVEL, "Pink Garnet Shovel");
        translationBuilder.add(ModItems.PINK_GARNET_HOE, "Pink Garnet Hoe");
        translationBuilder.add(ModItems.PINK_GARNET_PAXEL, "Pink Garnet Paxel");
        translationBuilder.add(ModItems.PINK_GARNET_BOW, "Pink Garnet Bow");
        translationBuilder.add(ModItems.PINK_GARNET_SHIELD, "Pink Garnet Shield");

        translationBuilder.add(ModItems.PINK_GARNET_HELMET, "Pink Garnet Paxel");
        translationBuilder.add(ModItems.PINK_GARNET_CHESTPLATE, "Pink Garnet Paxel");
        translationBuilder.add(ModItems.PINK_GARNET_LEGGINGS, "Pink Garnet Paxel");
        translationBuilder.add(ModItems.PINK_GARNET_BOOTS, "Pink Garnet Paxel");

        translationBuilder.add(ModItems.PINK_GARNET_HORSE_ARMOR, "Pink Garnet Horse Armor");

        translationBuilder.add(ModEnchants.LIGHTING_STRIKER, "Lighting Striker");

        translationBuilder.add(ModBlocks.PINK_GARNET_LAMP, "Pink Garnet Lamp");

        translationBuilder.add(ModItems.DATA_TABLET, "Data Tablet");

        translationBuilder.add(ModItems.CAULIFLOWER, "Cauliflower");
        translationBuilder.add(ModItems.CAULIFLOWER_SEEDS, "Cauliflower Seeds");

        translationBuilder.add(ModBlocks.PETUNIA, "Petunia");

        translationBuilder.add("sound.xtutorial.metal_detector_found_ore", "Metal Detector Found Ore!");

        translationBuilder.add("sound.xtutorial.pink_garnet_lamp_break", "Broke a Pink Garnet Lamp Block!");
        translationBuilder.add("sound.xtutorial.pink_garnet_lamp_step", "Stepped on a Pink Garnet Lamp Block!");
        translationBuilder.add("sound.xtutorial.pink_garnet_lamp_place", "Placed a Pink Garnet Lamp Block!");
        translationBuilder.add("sound.xtutorial.pink_garnet_lamp_hit", "Hit a Pink Garnet Lamp Block!");
        translationBuilder.add("sound.xtutorial.pink_garnet_lamp_fall", "Fell on a Pink Garnet Lamp Block!");

        translationBuilder.add("command.xtutorial.home.set.failure",
                               "Unable to Set Home Here!");
        translationBuilder.add("command.xtutorial.home.set.success",
                               "Set Home at: ");
        translationBuilder.add("command.xtutorial.home.failure",
                               "Unable to Teleport Home!");
        translationBuilder.add("command.xtutorial.home.success",
                               "Teleported to Home at: ");

        translationBuilder.add("command.xtutorial.gm.success",
                               "Set own game mode to ");
        translationBuilder.add("command.xtutorial.gm.failure",
                               "Failed to set own game mode!");


        translationBuilder.add("xtutorial.event.hit.sheep.pink_garnet_sword",
                               "just hurt a sheep with our custom Sword!");
        translationBuilder.add("xtutorial.event.hit.sheep",
                               "just hurt a sheep!");

        translationBuilder.add(ModItems.BAR_BRAWL_MUSIC_DISC, "Bar Brawl Music Disc");
        translationBuilder.add("item.xtutorial.bar_brawl_music_disc.desc", "Bryan Tech - Bar Brawl (CC0)");
        translationBuilder.add("sound.xtutorial.bar_brawl", "Bar Brawl!");

        translationBuilder.add(ModBlocks.GEM_EMPOWERING_STATION, "Gem Empowering Station");
        translationBuilder.add(ModItems.RADIATION_STAFF, "Radiation Staff");

        translationBuilder.add("painting.xtutorial.saw_them.title", "Saw Them");
        translationBuilder.add("painting.xtutorial.shrimp.title", "Shrimp");
        translationBuilder.add("painting.xtutorial.world.title", "World");
        translationBuilder.add("painting.xtutorial.saw_them.author", "NanoAttack");
        translationBuilder.add("painting.xtutorial.shrimp.author", "NanoAttack");
        translationBuilder.add("painting.xtutorial.world.author", "NanoAttack");

        translationBuilder.add(ModEffects.SLIMEY, "Slimey");
        translationBuilder.add("item.minecraft.potion.effect.slimey_potion", "Slimey Potion");
        translationBuilder.add("item.minecraft.splash_potion.effect.slimey_potion", "Slimey Splash Potion");
        translationBuilder.add("item.minecraft.lingering_potion.effect.slimey_potion", "Slimey Lingering Potion");

        translationBuilder.add("advancement.xtutorial.pink_garnet.name", "XTutorial");
        translationBuilder.add("advancement.xtutorial.metal_detector.name", "Metal Detector");
        translationBuilder.add("advancement.xtutorial.pink_garnet.desc", "The Power is in the Pink");
        translationBuilder.add("advancement.xtutorial.metal_detector.desc", "Batteries not included!");

        translationBuilder.add("entity.minecraft.villager.soundmaster", "Soundmaster");

        translationBuilder.add(ModItems.SOAP_WATER_BUCKET, "Soap Water Bucket");

    }
}

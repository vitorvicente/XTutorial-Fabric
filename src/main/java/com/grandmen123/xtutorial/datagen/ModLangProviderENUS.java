package com.grandmen123.xtutorial.datagen;

import com.grandmen123.xtutorial.block.ModBlocks;
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
    }
}

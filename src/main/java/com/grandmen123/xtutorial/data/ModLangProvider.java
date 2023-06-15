package com.grandmen123.xtutorial.data;

import com.grandmen123.xtutorial.block.ModBlocks;
import com.grandmen123.xtutorial.entity.ModEntities;
import com.grandmen123.xtutorial.item.ModItemGroup;
import com.grandmen123.xtutorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModLangProvider extends FabricLanguageProvider {
    public ModLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItemGroup.XTUTORIAL_CREATIVE_TAB, "XTutorial");

        translationBuilder.add(ModItems.CITRINE, "Citrine");
        translationBuilder.add(ModItems.RAW_CITRINE, "Raw Citrine");
        translationBuilder.add(ModBlocks.CITRINE_BLOCK, "Citrine Block");
        translationBuilder.add(ModBlocks.CITRINE_ORE, "Citrine Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_CITRINE_ORE, "Deepslate Citrine Ore");

        translationBuilder.add(ModBlocks.RED_MAPLE_LOG, "Red Maple Log");
        translationBuilder.add(ModBlocks.RED_MAPLE_WOOD, "Red Maple Wood");
        translationBuilder.add(ModBlocks.STRIPPED_RED_MAPLE_LOG, "Stripped Red Maple Log");
        translationBuilder.add(ModBlocks.STRIPPED_RED_MAPLE_WOOD, "Stripped Red Maple Wood");
        translationBuilder.add(ModBlocks.RED_MAPLE_PLANKS, "Red Maple Planks");
        translationBuilder.add(ModBlocks.RED_MAPLE_LEAVES, "Red Maple Leaves");
        translationBuilder.add(ModBlocks.RED_MAPLE_SAPLING, "Red Maple Sapling");

        translationBuilder.add(ModItems.TIGER_SPAWN_EGG, "Tiger Spawn Egg");
        translationBuilder.add(ModEntities.TIGER, "Tiger");

        translationBuilder.add(ModItems.ANIMATED_ITEM, "Animated Item");
        translationBuilder.add(ModBlocks.ANIMATED_BLOCK, "Animated Block");
    }
}

package com.grandmen123.xtutorial.data;

import com.grandmen123.xtutorial.block.ModBlocks;
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
        translationBuilder.add(ModItems.CITRINE, "Citrine");
        translationBuilder.add(ModItems.RAW_CITRINE, "Raw Citrine");
        translationBuilder.add(ModBlocks.CITRINE_BLOCK, "Citrine Block");
        translationBuilder.add(ModBlocks.CITRINE_ORE, "Citrine Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_CITRINE_ORE, "Deepslate Citrine Ore");
        translationBuilder.add(ModItemGroup.CITRINE, "Citrine Item Group");
    }
}

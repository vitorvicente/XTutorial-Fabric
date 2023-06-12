package com.grandmen123.xtutorial.data;

import com.grandmen123.xtutorial.block.ModBlocks;
import com.grandmen123.xtutorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGen extends FabricRecipeProvider {
    public ModRecipeGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, List.of(ModItems.RAW_CITRINE), RecipeCategory.MISC, ModItems.CITRINE, 3f, 300,
                      "citrine");
        offerSmelting(exporter, List.of(ModBlocks.CITRINE_ORE), RecipeCategory.MISC, ModItems.RAW_CITRINE, 3f, 300,
                      "citrine");
        offerSmelting(exporter, List.of(ModBlocks.DEEPSLATE_CITRINE_ORE), RecipeCategory.MISC, ModItems.RAW_CITRINE, 3f, 300,
                      "citrine");
        offerBlasting(exporter, List.of(ModItems.RAW_CITRINE), RecipeCategory.MISC, ModItems.CITRINE, 3f, 300,
                      "citrine");
        offerBlasting(exporter, List.of(ModBlocks.CITRINE_ORE), RecipeCategory.MISC, ModItems.RAW_CITRINE, 3f, 300,
                      "citrine");
        offerBlasting(exporter, List.of(ModBlocks.DEEPSLATE_CITRINE_ORE), RecipeCategory.MISC, ModItems.RAW_CITRINE, 3f, 300,
                      "citrine");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.CITRINE,
                                         RecipeCategory.BUILDING_BLOCKS, ModBlocks.CITRINE_BLOCK);
    }
}

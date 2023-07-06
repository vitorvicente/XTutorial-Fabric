package com.grandmen123.xtutorial.datagen;

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
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.PINK_GARNET,
                                         RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RAW_PINK_GARNET,
                                         RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_PINK_GARNET_BLOCK);

        offerSmelting(exporter, List.of(ModItems.RAW_PINK_GARNET), RecipeCategory.MISC, ModItems.PINK_GARNET,
                      0.7f, 200, "pink_garnet");
        offerSmelting(exporter, List.of(ModBlocks.PINK_GARNET_ORE, ModBlocks.DEEPSLATE_PINK_GARNET_ORE,
                                        ModBlocks.NETHERRACK_PINK_GARNET_ORE, ModBlocks.END_STONE_PINK_GARNET_ORE),
                      RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 0.7f, 200, "pink_garnet");

        offerBlasting(exporter, List.of(ModItems.RAW_PINK_GARNET), RecipeCategory.MISC, ModItems.PINK_GARNET,
                      0.7f, 100, "pink_garnet");
        offerBlasting(exporter, List.of(ModBlocks.PINK_GARNET_ORE, ModBlocks.DEEPSLATE_PINK_GARNET_ORE,
                                        ModBlocks.NETHERRACK_PINK_GARNET_ORE, ModBlocks.END_STONE_PINK_GARNET_ORE),
                      RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 0.7f, 100, "pink_garnet");
    }
}

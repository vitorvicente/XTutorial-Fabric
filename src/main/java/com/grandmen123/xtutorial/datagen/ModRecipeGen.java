package com.grandmen123.xtutorial.datagen;

import com.grandmen123.xtutorial.block.ModBlocks;
import com.grandmen123.xtutorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
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

        offerSlabRecipe(exporter, RecipeCategory.MISC, ModBlocks.PINK_GARNET_SLAB, ModBlocks.PINK_GARNET_BLOCK);
        createStairsRecipe(ModBlocks.PINK_GARNET_STAIRS, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion("has_pink_garnet_block", conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .offerTo(exporter);
        offerPressurePlateRecipe(exporter, ModBlocks.PINK_GARNET_PRESSURE_PLATE, ModBlocks.PINK_GARNET_BLOCK);
        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, ModBlocks.PINK_GARNET_BUTTON, ModItems.PINK_GARNET);
        createFenceRecipe(ModBlocks.PINK_GARNET_FENCE, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion("has_pink_garnet_block", conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .offerTo(exporter);
        createFenceGateRecipe(ModBlocks.PINK_GARNET_FENCE_GATE, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion("has_pink_garnet_block", conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .offerTo(exporter);
        offerWallRecipe(exporter, RecipeCategory.MISC, ModBlocks.PINK_GARNET_WALL, ModBlocks.PINK_GARNET_BLOCK);
        createDoorRecipe(ModBlocks.PINK_GARNET_DOOR, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion("has_pink_garnet_block", conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .offerTo(exporter);
        createTrapdoorRecipe(ModBlocks.PINK_GARNET_TRAPDOOR, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK))
                .criterion("has_pink_garnet_block", conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                .offerTo(exporter);

        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModBlocks.PINK_GARNET_STAIRS,
                                ModBlocks.PINK_GARNET_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModBlocks.PINK_GARNET_SLAB,
                                ModBlocks.PINK_GARNET_BLOCK, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModBlocks.PINK_GARNET_WALL,
                                ModBlocks.PINK_GARNET_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_SWORD)
                               .input('#', ModItems.PINK_GARNET)
                               .input('i', Items.STICK)
                               .pattern("#")
                               .pattern("#")
                               .pattern("i")
                               .criterion("has_pink_garnet", conditionsFromItem(ModItems.PINK_GARNET))
                               .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_PICKAXE)
                               .input('#', ModItems.PINK_GARNET)
                               .input('i', Items.STICK)
                               .pattern("###")
                               .pattern(" i ")
                               .pattern(" i ")
                               .criterion("has_pink_garnet", conditionsFromItem(ModItems.PINK_GARNET))
                               .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_AXE)
                               .input('#', ModItems.PINK_GARNET)
                               .input('i', Items.STICK)
                               .pattern("##")
                               .pattern("#i")
                               .pattern(" i")
                               .criterion("has_pink_garnet", conditionsFromItem(ModItems.PINK_GARNET))
                               .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_SHOVEL)
                               .input('#', ModItems.PINK_GARNET)
                               .input('i', Items.STICK)
                               .pattern("#")
                               .pattern("i")
                               .pattern("i")
                               .criterion("has_pink_garnet", conditionsFromItem(ModItems.PINK_GARNET))
                               .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_HOE)
                               .input('#', ModItems.PINK_GARNET)
                               .input('i', Items.STICK)
                               .pattern("##")
                               .pattern(" i")
                               .pattern(" i")
                               .criterion("has_pink_garnet", conditionsFromItem(ModItems.PINK_GARNET))
                               .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_PAXEL)
                               .input('p', ModItems.PINK_GARNET_PICKAXE)
                               .input('a', ModItems.PINK_GARNET_AXE)
                               .input('s', ModItems.PINK_GARNET_SHOVEL)
                               .input('S', ModItems.PINK_GARNET_SWORD)
                               .input('h', ModItems.PINK_GARNET_HOE)
                               .input('i', Items.STICK)
                               .pattern("pSa")
                               .pattern("sih")
                               .pattern(" i ")
                               .criterion("has_pink_garnet", conditionsFromItem(ModItems.PINK_GARNET))
                               .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PINK_GARNET_HELMET)
                               .input('#', ModItems.PINK_GARNET)
                               .pattern("###")
                               .pattern("# #")
                               .criterion("has_pink_garnet", conditionsFromItem(ModItems.PINK_GARNET))
                               .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PINK_GARNET_CHESTPLATE)
                               .input('#', ModItems.PINK_GARNET)
                               .pattern("# #")
                               .pattern("###")
                               .pattern("###")
                               .criterion("has_pink_garnet", conditionsFromItem(ModItems.PINK_GARNET))
                               .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PINK_GARNET_LEGGINGS)
                               .input('#', ModItems.PINK_GARNET)
                               .pattern("###")
                               .pattern("# #")
                               .pattern("# #")
                               .criterion("has_pink_garnet", conditionsFromItem(ModItems.PINK_GARNET))
                               .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PINK_GARNET_BOOTS)
                               .input('#', ModItems.PINK_GARNET)
                               .pattern("# #")
                               .pattern("# #")
                               .criterion("has_pink_garnet", conditionsFromItem(ModItems.PINK_GARNET))
                               .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PINK_GARNET_HORSE_ARMOR)
                               .input('#', ModItems.PINK_GARNET)
                               .pattern("  #")
                               .pattern("###")
                               .pattern("# #")
                               .criterion("has_pink_garnet", conditionsFromItem(ModItems.PINK_GARNET))
                               .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_GARNET_LAMP)
                               .input('#', ModItems.PINK_GARNET)
                               .input('i', Blocks.GLOWSTONE)
                               .pattern(" # ")
                               .pattern("#i#")
                               .pattern(" # ")
                               .criterion("has_pink_garnet", conditionsFromItem(ModItems.PINK_GARNET))
                               .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GEM_EMPOWERING_STATION)
                               .input('i', ModItems.PINK_GARNET)
                               .input('#', Blocks.IRON_BLOCK)
                               .pattern(" i ")
                               .pattern("###")
                               .pattern("# #")
                               .criterion("has_pink_garnet", conditionsFromItem(ModItems.PINK_GARNET))
                               .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RADIATION_STAFF)
                               .input('#', Items.EMERALD)
                               .input('i', Items.STICK)
                               .pattern("#")
                               .pattern("i")
                               .pattern("i")
                               .criterion("has_emerald", conditionsFromItem(Items.EMERALD))
                               .offerTo(exporter);
    }
}

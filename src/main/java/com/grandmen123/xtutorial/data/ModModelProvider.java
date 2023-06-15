package com.grandmen123.xtutorial.data;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.block.ModBlocks;
import com.grandmen123.xtutorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CITRINE_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CITRINE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEEPSLATE_CITRINE_ORE);

        blockStateModelGenerator.registerLog(ModBlocks.RED_MAPLE_LOG).log(ModBlocks.RED_MAPLE_LOG)
                                .wood(ModBlocks.RED_MAPLE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_RED_MAPLE_LOG).log(ModBlocks.STRIPPED_RED_MAPLE_LOG)
                                .wood(ModBlocks.STRIPPED_RED_MAPLE_WOOD);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RED_MAPLE_PLANKS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RED_MAPLE_LEAVES);

        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.RED_MAPLE_SAPLING,
                                                                 BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerParentedItemModel(ModItems.TIGER_SPAWN_EGG,
                                                           ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));


        blockStateModelGenerator.blockStateCollector.accept(generateOnlyBlockState(ModBlocks.ANIMATED_BLOCK,
                                                                                   "animated_block"));

        blockStateModelGenerator.registerParentedItemModel(ModItems.ANIMATED_BLOCK_ITEM,
                                                           ModelIds.getBlockModelId(ModBlocks.ANIMATED_BLOCK));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CITRINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_CITRINE, Models.GENERATED);
    }

    private VariantsBlockStateSupplier generateOnlyBlockState(Block block, String id) {
        return BlockStateModelGenerator.createSingletonBlockState(block,
                                                                  new Identifier(XTutorial.MOD_ID,
                                                                                 "block/" + id));
    }
}

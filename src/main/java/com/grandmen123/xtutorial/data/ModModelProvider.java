package com.grandmen123.xtutorial.data;

import com.grandmen123.xtutorial.block.ModBlocks;
import com.grandmen123.xtutorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CITRINE_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CITRINE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEEPSLATE_CITRINE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CITRINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_CITRINE, Models.GENERATED);
    }
}

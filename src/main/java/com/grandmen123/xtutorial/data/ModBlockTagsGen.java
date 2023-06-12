package com.grandmen123.xtutorial.data;

import com.grandmen123.xtutorial.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.mininglevel.v1.MiningLevelManager;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsGen extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagsGen(FabricDataOutput output,
                           CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CITRINE_BLOCK)
                .add(ModBlocks.CITRINE_ORE)
                .add(ModBlocks.DEEPSLATE_CITRINE_ORE)
                .setReplace(false);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CITRINE_BLOCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CITRINE_ORE);
        getOrCreateTagBuilder(MiningLevelManager.getBlockTag(4))
                .add(ModBlocks.DEEPSLATE_CITRINE_ORE);
    }
}

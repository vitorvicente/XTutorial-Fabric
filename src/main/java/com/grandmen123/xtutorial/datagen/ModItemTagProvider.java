package com.grandmen123.xtutorial.datagen;

import com.grandmen123.xtutorial.block.ModBlocks;
import com.grandmen123.xtutorial.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output,
                              CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Items.PINK_GARNET_ORES)
                .add(ModBlocks.PINK_GARNET_ORE.asItem())
                .add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE.asItem())
                .add(ModBlocks.NETHERRACK_PINK_GARNET_ORE.asItem())
                .add(ModBlocks.END_STONE_PINK_GARNET_ORE.asItem());
    }
}

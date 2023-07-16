package com.grandmen123.xtutorial.datagen;

import com.grandmen123.xtutorial.block.ModBlocks;
import com.grandmen123.xtutorial.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

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

        getOrCreateTagBuilder(ItemTags.SLABS)
                .add(ModBlocks.PINK_GARNET_SLAB.asItem());

        getOrCreateTagBuilder(ItemTags.STAIRS)
                .add(ModBlocks.PINK_GARNET_STAIRS.asItem());

        getOrCreateTagBuilder(ItemTags.BUTTONS)
                .add(ModBlocks.PINK_GARNET_BUTTON.asItem());

        getOrCreateTagBuilder(ItemTags.FENCES)
                .add(ModBlocks.PINK_GARNET_FENCE.asItem());

        getOrCreateTagBuilder(ItemTags.FENCE_GATES)
                .add(ModBlocks.PINK_GARNET_FENCE_GATE.asItem());

        getOrCreateTagBuilder(ItemTags.WALLS)
                .add(ModBlocks.PINK_GARNET_WALL.asItem());

        getOrCreateTagBuilder(ItemTags.DOORS)
                .add(ModBlocks.PINK_GARNET_DOOR.asItem());

        getOrCreateTagBuilder(ItemTags.TRAPDOORS)
                .add(ModBlocks.PINK_GARNET_TRAPDOOR.asItem());
    }
}

package com.grandmen123.xtutorial.datagen;

import com.grandmen123.xtutorial.block.ModBlocks;
import com.grandmen123.xtutorial.item.ModItems;
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

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.PINK_GARNET_SWORD)
                .add(ModItems.PINK_GARNET_PAXEL);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.PINK_GARNET_PICKAXE)
                .add(ModItems.PINK_GARNET_PAXEL);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.PINK_GARNET_AXE)
                .add(ModItems.PINK_GARNET_PAXEL);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.PINK_GARNET_SHOVEL)
                .add(ModItems.PINK_GARNET_PAXEL);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.PINK_GARNET_HOE)
                .add(ModItems.PINK_GARNET_PAXEL);

        getOrCreateTagBuilder(ModTags.Items.PAXELS)
                .add(ModItems.PINK_GARNET_PAXEL);

        getOrCreateTagBuilder(ItemTags.TOOLS)
                .add(ModItems.PINK_GARNET_SWORD)
                .add(ModItems.PINK_GARNET_PICKAXE)
                .add(ModItems.PINK_GARNET_AXE)
                .add(ModItems.PINK_GARNET_SHOVEL)
                .add(ModItems.PINK_GARNET_HOE)
                .add(ModItems.PINK_GARNET_PAXEL)
                .add(ModItems.PINK_GARNET_BOW)
                .add(ModItems.PINK_GARNET_SHIELD);

        getOrCreateTagBuilder(ModTags.Items.ADVANCED_TOOLS)
                .add(ModItems.DATA_TABLET)
                .add(ModItems.RADIATION_STAFF)
                .add(ModItems.METAL_DETECTOR);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.PINK_GARNET_HELMET)
                .add(ModItems.PINK_GARNET_CHESTPLATE)
                .add(ModItems.PINK_GARNET_LEGGINGS)
                .add(ModItems.PINK_GARNET_BOOTS);

        getOrCreateTagBuilder(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(ModItems.CAULIFLOWER_SEEDS);

        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS)
                .add(ModBlocks.PETUNIA.asItem());

        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.BAR_BRAWL_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.BAR_BRAWL_MUSIC_DISC);
    }
}

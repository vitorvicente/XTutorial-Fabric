package com.grandmen123.xtutorial.datagen;

import com.grandmen123.xtutorial.block.ModBlocks;
import com.grandmen123.xtutorial.block.custom.CauliflowerCropBlock;
import com.grandmen123.xtutorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.state.property.IntProperty;

public class ModBlockLootTableGen extends FabricBlockLootTableProvider {
    public ModBlockLootTableGen(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.PINK_GARNET_BLOCK);
        addDrop(ModBlocks.PINK_GARNET_STAIRS);
        addDrop(ModBlocks.PINK_GARNET_SLAB, slabDrops(ModBlocks.PINK_GARNET_SLAB));
        addDrop(ModBlocks.PINK_GARNET_BUTTON);
        addDrop(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
        addDrop(ModBlocks.PINK_GARNET_FENCE);
        addDrop(ModBlocks.PINK_GARNET_FENCE_GATE);
        addDrop(ModBlocks.PINK_GARNET_WALL);
        addDrop(ModBlocks.PINK_GARNET_DOOR, doorDrops(ModBlocks.PINK_GARNET_DOOR));
        addDrop(ModBlocks.PINK_GARNET_TRAPDOOR);
        addDropWithSilkTouch(ModBlocks.PINK_GARNET_LAMP);


        addDrop(ModBlocks.RAW_PINK_GARNET_BLOCK);
        addDrop(ModBlocks.PINK_GARNET_ORE,
                oreDrops(ModBlocks.PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));
        addDrop(ModBlocks.DEEPSLATE_PINK_GARNET_ORE,
                oreDrops(ModBlocks.DEEPSLATE_PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));
        addDrop(ModBlocks.NETHERRACK_PINK_GARNET_ORE,
                oreDrops(ModBlocks.NETHERRACK_PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));
        addDrop(ModBlocks.END_STONE_PINK_GARNET_ORE,
                oreDrops(ModBlocks.END_STONE_PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));

        addDrop(ModBlocks.SOUND_BLOCK);
        genCropDrop(ModBlocks.CAULIFLOWER_CROP, ModItems.CAULIFLOWER, ModItems.CAULIFLOWER_SEEDS,
                    CauliflowerCropBlock.AGE, CauliflowerCropBlock.MAX_AGE);
    }

    private void genCropDrop(Block block, Item crop, Item seeds, IntProperty ageProperty, int maxAge) {
        BlockStatePropertyLootCondition.Builder builder =
                BlockStatePropertyLootCondition.builder(block).properties(
                        StatePredicate.Builder.create().exactMatch(ageProperty, maxAge));
        this.addDrop(block, this.cropDrops(block, crop, seeds, builder));
    }
}

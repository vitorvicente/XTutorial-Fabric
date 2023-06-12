package com.grandmen123.xtutorial.data;

import com.grandmen123.xtutorial.block.ModBlocks;
import com.grandmen123.xtutorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableGen extends FabricBlockLootTableProvider {
    public ModLootTableGen(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CITRINE_ORE, oreDrops(ModBlocks.CITRINE_ORE, ModItems.RAW_CITRINE));
        addDrop(ModBlocks.DEEPSLATE_CITRINE_ORE, oreDrops(ModBlocks.DEEPSLATE_CITRINE_ORE, ModItems.RAW_CITRINE));
        addDrop(ModBlocks.CITRINE_BLOCK);

        addDrop(ModBlocks.RED_MAPLE_LOG);
        addDrop(ModBlocks.RED_MAPLE_WOOD);
        addDrop(ModBlocks.STRIPPED_RED_MAPLE_LOG);
        addDrop(ModBlocks.STRIPPED_RED_MAPLE_WOOD);
        addDrop(ModBlocks.RED_MAPLE_PLANKS);
        addDrop(ModBlocks.RED_MAPLE_LEAVES, leavesDrops(ModBlocks.RED_MAPLE_LEAVES, ModBlocks.RED_MAPLE_LEAVES, 0.4f));
        addDrop(ModBlocks.RED_MAPLE_SAPLING);
    }
}

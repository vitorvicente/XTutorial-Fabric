package com.grandmen123.xtutorial.block;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block CITRINE_BLOCK =
            registerBlock("citrine_block", new Block(FabricBlockSettings
                                                             .of(Material.METAL)
                                                             .strength(4.0f)
                                                             .requiresTool()), ModItemGroup.CITRINE);
    public static final Block CITRINE_ORE =
            registerBlock("citrine_ore", new ExperienceDroppingBlock(FabricBlockSettings
                                                                             .of(Material.METAL)
                                                                             .strength(4.0f)
                                                                             .requiresTool(),
                                                                     UniformIntProvider.create(3, 7)),
                          ModItemGroup.CITRINE);
    public static final Block DEEPSLATE_CITRINE_ORE =
            registerBlock("deepslate_citrine_ore", new ExperienceDroppingBlock(FabricBlockSettings
                                                                                       .of(Material.METAL)
                                                                                       .strength(4.0f)
                                                                                       .requiresTool(),
                                                                               UniformIntProvider.create(3, 7)),
                          ModItemGroup.CITRINE);


    private static Block registerBlock(String name, Block block, ItemGroup itemGroup) {
        registerBlockItem(name, block, itemGroup);
        return Registry.register(Registries.BLOCK, new Identifier(XTutorial.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup itemGroup) {
        Item item = Registry.register(Registries.ITEM, new Identifier(XTutorial.MOD_ID, name),
                                      new BlockItem(block, new FabricItemSettings()));

        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        XTutorial.LOGGER.info("Registering Mod Blocks for " + XTutorial.MOD_ID);
    }
}

package com.grandmen123.xtutorial.block;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.block.custom.AnimatedBlock;
import com.grandmen123.xtutorial.item.ModItemGroup;
import com.grandmen123.xtutorial.world.tree.RedMapleSaplingGen;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
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
                                                             .requiresTool()), ModItemGroup.XTUTORIAL_CREATIVE_TAB);
    public static final Block CITRINE_ORE =
            registerBlock("citrine_ore", new ExperienceDroppingBlock(FabricBlockSettings
                                                                             .of(Material.METAL)
                                                                             .strength(4.0f)
                                                                             .requiresTool(),
                                                                     UniformIntProvider.create(3, 7)),
                          ModItemGroup.XTUTORIAL_CREATIVE_TAB);
    public static final Block DEEPSLATE_CITRINE_ORE =
            registerBlock("deepslate_citrine_ore", new ExperienceDroppingBlock(FabricBlockSettings
                                                                                       .of(Material.METAL)
                                                                                       .strength(4.0f)
                                                                                       .requiresTool(),
                                                                               UniformIntProvider.create(3, 7)),
                          ModItemGroup.XTUTORIAL_CREATIVE_TAB);

    public static final Block RED_MAPLE_LOG =
            registerBlock("red_maple_log",
                          new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4.0f)),
                          ModItemGroup.XTUTORIAL_CREATIVE_TAB);
    public static final Block RED_MAPLE_WOOD =
            registerBlock("red_maple_wood",
                          new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4.0f)),
                          ModItemGroup.XTUTORIAL_CREATIVE_TAB);
    public static final Block STRIPPED_RED_MAPLE_LOG =
            registerBlock("stripped_red_maple_log",
                          new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(4.0f)),
                          ModItemGroup.XTUTORIAL_CREATIVE_TAB);
    public static final Block STRIPPED_RED_MAPLE_WOOD =
            registerBlock("stripped_red_maple_wood",
                          new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4.0f)),
                          ModItemGroup.XTUTORIAL_CREATIVE_TAB);
    public static final Block RED_MAPLE_PLANKS =
            registerBlock("red_maple_planks",
                          new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4.0f)),
                          ModItemGroup.XTUTORIAL_CREATIVE_TAB);
    public static final Block RED_MAPLE_LEAVES =
            registerBlock("red_maple_leaves",
                          new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(4.0f)),
                          ModItemGroup.XTUTORIAL_CREATIVE_TAB);
    public static final Block RED_MAPLE_SAPLING =
            registerBlock("red_maple_sapling",
                          new SaplingBlock(new RedMapleSaplingGen(),
                                           FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).strength(4.0f)),
                          ModItemGroup.XTUTORIAL_CREATIVE_TAB);

    public static final Block ANIMATED_BLOCK =
            Registry.register(Registries.BLOCK, new Identifier(XTutorial.MOD_ID, "animated_block"),
                          new AnimatedBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).nonOpaque()));


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
        registerFlammableBlocks();
        registerStrippableBlocks();
    }

    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.RED_MAPLE_LOG, 5, 5);
        registry.add(ModBlocks.RED_MAPLE_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_RED_MAPLE_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_RED_MAPLE_WOOD, 5, 5);
        registry.add(ModBlocks.RED_MAPLE_LEAVES, 30, 60);
        registry.add(ModBlocks.RED_MAPLE_PLANKS, 5, 20);
    }

    public static void registerStrippableBlocks() {
        StrippableBlockRegistry.register(RED_MAPLE_LOG, STRIPPED_RED_MAPLE_LOG);
        StrippableBlockRegistry.register(RED_MAPLE_WOOD, STRIPPED_RED_MAPLE_WOOD);
    }
}

package com.grandmen123.xtutorial.block;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.block.custom.SoundBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static com.grandmen123.xtutorial.XTutorial.LOGGER;
import static com.grandmen123.xtutorial.XTutorial.MOD_ID;

public class ModBlocks {

    public static final Block PINK_GARNET_BLOCK = registerBlock(
            "pink_garnet_block", new Block(FabricBlockSettings
                                                   .copyOf(Blocks.IRON_BLOCK)));
    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock(
            "raw_pink_garnet_block", new Block(FabricBlockSettings
                                                       .copyOf(Blocks.DIAMOND_BLOCK)));

    public static final Block PINK_GARNET_ORE = registerBlock(
            "pink_garnet_ore", new ExperienceDroppingBlock(FabricBlockSettings
                                                                   .copyOf(Blocks.STONE),
                                                           UniformIntProvider.create(3, 7)));
    public static final Block DEEPSLATE_PINK_GARNET_ORE = registerBlock(
            "deepslate_pink_garnet_ore", new ExperienceDroppingBlock(FabricBlockSettings
                                                                             .copyOf(Blocks.DEEPSLATE),
                                                                     UniformIntProvider.create(3, 7)));
    public static final Block NETHERRACK_PINK_GARNET_ORE = registerBlock(
            "netherrack_pink_garnet_ore", new ExperienceDroppingBlock(FabricBlockSettings
                                                                              .copyOf(Blocks.NETHERRACK),
                                                                      UniformIntProvider.create(3, 7)));
    public static final Block END_STONE_PINK_GARNET_ORE = registerBlock(
            "end_stone_pink_garnet_ore", new ExperienceDroppingBlock(FabricBlockSettings
                                                                             .copyOf(Blocks.END_STONE),
                                                                     UniformIntProvider.create(3, 7)));

    public static final Block SOUND_BLOCK = registerBlock(
            "sound_block", new SoundBlock(FabricBlockSettings
                                                  .copyOf(Blocks.IRON_BLOCK)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), new BlockItem(block,
                                                                                       new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        LOGGER.info("Registering Mod Blocks");
        addBlocksToItemGroup();
    }

    private static void addBlocksToItemGroup() {
        XTutorial.addToItemGroup(PINK_GARNET_BLOCK);
        XTutorial.addToItemGroup(RAW_PINK_GARNET_BLOCK);
        XTutorial.addToItemGroup(PINK_GARNET_ORE);
        XTutorial.addToItemGroup(DEEPSLATE_PINK_GARNET_ORE);
        XTutorial.addToItemGroup(NETHERRACK_PINK_GARNET_ORE);
        XTutorial.addToItemGroup(END_STONE_PINK_GARNET_ORE);

        XTutorial.addToItemGroup(SOUND_BLOCK);
    }
}

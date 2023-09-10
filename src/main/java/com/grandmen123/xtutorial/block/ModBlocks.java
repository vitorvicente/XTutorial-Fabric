package com.grandmen123.xtutorial.block;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.block.custom.CauliflowerCropBlock;
import com.grandmen123.xtutorial.block.custom.GemEmpoweringStationBlock;
import com.grandmen123.xtutorial.block.custom.PinkGarnetLampBlock;
import com.grandmen123.xtutorial.block.custom.SoundBlock;
import com.grandmen123.xtutorial.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
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

    public static final Block PINK_GARNET_STAIRS = registerBlock(
            "pink_garnet_stairs", new StairsBlock(ModBlocks.PINK_GARNET_BLOCK.getDefaultState(),
                                                  FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block PINK_GARNET_SLAB = registerBlock(
            "pink_garnet_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block PINK_GARNET_BUTTON = registerBlock(
            "pink_garnet_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE_BUTTON),
                                                  BlockSetType.IRON, 10, true));
    public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock(
            "pink_garnet_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                                   FabricBlockSettings.copyOf(Blocks.STONE_PRESSURE_PLATE), BlockSetType.IRON));
    public static final Block PINK_GARNET_WALL = registerBlock(
            "pink_garnet_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block PINK_GARNET_FENCE = registerBlock(
            "pink_garnet_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block PINK_GARNET_FENCE_GATE = registerBlock(
            "pink_garnet_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), WoodType.OAK));
    public static final Block PINK_GARNET_DOOR = registerBlock(
            "pink_garnet_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_DOOR), BlockSetType.IRON));
    public static final Block PINK_GARNET_TRAPDOOR = registerBlock(
            "pink_garnet_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_TRAPDOOR), BlockSetType.IRON));

    public static final Block PINK_GARNET_LAMP = registerBlock(
            "pink_garnet_lamp_block",
            new PinkGarnetLampBlock(
                    FabricBlockSettings.copyOf(Blocks.REDSTONE_LAMP)
                                       .luminance(state -> state.get(PinkGarnetLampBlock.CLICKED) ? 15 : 0)
                                       .sounds(ModSounds.PINK_GARNET_LAMP_SOUNDS)));

    public static final Block CAULIFLOWER_CROP = registerBlockWithoutBlockItem(
            "cauliflower_crop", new CauliflowerCropBlock(FabricBlockSettings
                                                                 .copyOf(Blocks.WHEAT)));

    public static final Block PETUNIA = registerBlock(
            "petunia", new FlowerBlock(StatusEffects.ABSORPTION, 5,
                                       FabricBlockSettings.copyOf(Blocks.ALLIUM)));
    public static final Block POTTED_PETUNIA = registerBlockWithoutBlockItem(
            "potted_petunia", new FlowerPotBlock(PETUNIA, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM)));


    public static final Block GEM_EMPOWERING_STATION = registerBlock(
            "gem_empowering_station", new GemEmpoweringStationBlock(FabricBlockSettings
                                                                            .copyOf(Blocks.IRON_BLOCK).nonOpaque()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return registerBlockWithoutBlockItem(name, block);
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);

    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, name),
                          new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        LOGGER.info("Registering Mod Blocks");

        addBlocksToItemGroup();
    }

    private static void addBlocksToItemGroup() {
        XTutorial.addToItemGroup(PINK_GARNET_BLOCK);
        XTutorial.addToItemGroup(PINK_GARNET_SLAB);
        XTutorial.addToItemGroup(PINK_GARNET_STAIRS);
        XTutorial.addToItemGroup(PINK_GARNET_BUTTON);
        XTutorial.addToItemGroup(PINK_GARNET_PRESSURE_PLATE);
        XTutorial.addToItemGroup(PINK_GARNET_FENCE);
        XTutorial.addToItemGroup(PINK_GARNET_FENCE_GATE);
        XTutorial.addToItemGroup(PINK_GARNET_WALL);
        XTutorial.addToItemGroup(PINK_GARNET_DOOR);
        XTutorial.addToItemGroup(PINK_GARNET_TRAPDOOR);

        XTutorial.addToItemGroup(RAW_PINK_GARNET_BLOCK);
        XTutorial.addToItemGroup(PINK_GARNET_ORE);
        XTutorial.addToItemGroup(DEEPSLATE_PINK_GARNET_ORE);
        XTutorial.addToItemGroup(NETHERRACK_PINK_GARNET_ORE);
        XTutorial.addToItemGroup(END_STONE_PINK_GARNET_ORE);

        XTutorial.addToItemGroup(SOUND_BLOCK);

        XTutorial.addToItemGroup(PINK_GARNET_LAMP);

        XTutorial.addToItemGroup(PETUNIA);

        XTutorial.addToItemGroup(GEM_EMPOWERING_STATION);
    }
}

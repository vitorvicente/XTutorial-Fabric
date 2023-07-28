package com.grandmen123.xtutorial.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.block.ModBlocks;
import com.grandmen123.xtutorial.block.custom.CauliflowerCropBlock;
import com.grandmen123.xtutorial.block.custom.PinkGarnetLampBlock;
import com.grandmen123.xtutorial.item.ModItems;
import com.grandmen123.xtutorial.util.ModAdvancedModelUtils;
import com.grandmen123.xtutorial.util.ModModelPredicateProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool pinkGarnetTexturePool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PINK_GARNET_BLOCK);
        pinkGarnetTexturePool.stairs(ModBlocks.PINK_GARNET_STAIRS);
        pinkGarnetTexturePool.slab(ModBlocks.PINK_GARNET_SLAB);
        pinkGarnetTexturePool.button(ModBlocks.PINK_GARNET_BUTTON);
        pinkGarnetTexturePool.pressurePlate(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
        pinkGarnetTexturePool.fence(ModBlocks.PINK_GARNET_FENCE);
        pinkGarnetTexturePool.fenceGate(ModBlocks.PINK_GARNET_FENCE_GATE);
        pinkGarnetTexturePool.wall(ModBlocks.PINK_GARNET_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.PINK_GARNET_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PINK_GARNET_TRAPDOOR);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHERRACK_PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_PINK_GARNET_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);

        registerCustomLamp(blockStateModelGenerator, ModBlocks.PINK_GARNET_LAMP, PinkGarnetLampBlock.CLICKED);

        blockStateModelGenerator.registerCrop(ModBlocks.CAULIFLOWER_CROP, CauliflowerCropBlock.AGE,
                                              0, 1, 2, 3, 4, 5, 6);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.PETUNIA, ModBlocks.POTTED_PETUNIA,
                                                        BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.GEM_EMPOWERING_STATION);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);

        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);

        itemModelGenerator.register(ModItems.PEAT_BRICK, Models.GENERATED);

        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.PINK_GARNET_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_PAXEL, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.PINK_GARNET_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PINK_GARNET_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PINK_GARNET_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PINK_GARNET_BOOTS);

        itemModelGenerator.register(ModItems.PINK_GARNET_HORSE_ARMOR, Models.GENERATED);

        registerOnOffItem(itemModelGenerator, ModItems.DATA_TABLET);

        itemModelGenerator.register(ModItems.BAR_BRAWL_MUSIC_DISC, Models.GENERATED);

        registerBowItem(itemModelGenerator, ModItems.PINK_GARNET_BOW);
    }

    @SuppressWarnings("SameParameterValue")
    private void registerCustomLamp(BlockStateModelGenerator blockStateModelGenerator, Block block,
                                    BooleanProperty booleanProperty) {
        Identifier identifier = TexturedModel
                .CUBE_ALL.upload(block, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = blockStateModelGenerator
                .createSubModel(block, "_on", Models.CUBE_ALL, TextureMap::all);

        blockStateModelGenerator.blockStateCollector
                .accept(VariantsBlockStateSupplier.create(block)
                                                  .coordinate(BlockStateModelGenerator
                                                                      .createBooleanModelMap(
                                                                              booleanProperty,
                                                                              identifier2,
                                                                              identifier)));
    }

    @SuppressWarnings("SameParameterValue")
    private void registerOnOffItem(ItemModelGenerator itemModelGenerator, Item item) {
        Identifier defaultItem = ModelIds.getItemModelId(item);
        Identifier itemOn = ModelIds.getItemSubModelId(item, "_" + ModModelPredicateProvider.PREDICATE_ON_SUFFIX);
        Identifier itemOff = ModelIds.getItemSubModelId(item, "_" + ModModelPredicateProvider.PREDICATE_OFF_SUFFIX);

        JsonObject jsonObject = Models.GENERATED.createJson(defaultItem, Map.of(TextureKey.LAYER0, itemOff));
        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject1 = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();

        jsonObject2.addProperty(
                new Identifier(XTutorial.MOD_ID, ModModelPredicateProvider.PREDICATE_ON_SUFFIX).toString(), 1);
        jsonObject1.add("predicate", jsonObject2);
        jsonObject1.addProperty("model", itemOn.toString());
        jsonArray.add(jsonObject1);
        jsonObject.add("overrides", jsonArray);

        itemModelGenerator.writer.accept(defaultItem, () -> jsonObject);
        Models.GENERATED.upload(itemOn, TextureMap.layer0(defaultItem), itemModelGenerator.writer);
    }

    @SuppressWarnings("SameParameterValue")
    private void registerBowItem(ItemModelGenerator itemModelGenerator, Item item) {
        Identifier baseId = ModelIds.getItemModelId(item);
        Model bowModel = new Model(Optional.of(baseId), Optional.empty(), TextureKey.LAYER0);
        List<Identifier> stateIds = List.of(ModelIds.getItemSubModelId(item, "_pulling_0"),
                                            ModelIds.getItemSubModelId(item, "_pulling_1"),
                                            ModelIds.getItemSubModelId(item, "_pulling_2"));

        JsonObject jsonObject = Models.GENERATED.createJson(baseId, Map.of(TextureKey.LAYER0, baseId));
        JsonObject display = ModAdvancedModelUtils.genBowDisplayObject();

        JsonArray overrides = new JsonArray();
        int counter = 0;
        for (Identifier id : stateIds) {
            JsonObject predicateWrapper = new JsonObject();
            JsonObject predicateInner = new JsonObject();
            double pull = (counter == 1) ? 0.65 : 0.9;

            predicateInner.addProperty("pulling", 1);
            if (counter != 0)
                predicateInner.addProperty("pull", pull);

            predicateWrapper.addProperty("model", id.toString());
            predicateWrapper.add("predicate", predicateInner);
            overrides.add(predicateWrapper);
            counter++;

            bowModel.upload(id, TextureMap.layer0(id), itemModelGenerator.writer);
        }

        jsonObject.add("display", display);
        jsonObject.add("overrides", overrides);

        itemModelGenerator.writer.accept(baseId, () -> jsonObject);
    }
}

package com.grandmen123.xtutorial;

import com.grandmen123.xtutorial.block.ModBlocks;
import com.grandmen123.xtutorial.util.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import static com.grandmen123.xtutorial.XTutorial.LOGGER;

public class XTutorialClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Client");

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAULIFLOWER_CROP, RenderLayer.getCutout());

        ModModelPredicateProvider.registerModModels();

        LOGGER.info("Finished Initializing Client");
    }
}

package com.grandmen123.xtutorial;

import com.grandmen123.xtutorial.block.ModBlocks;
import com.grandmen123.xtutorial.block.entity.ModBlockEntities;
import com.grandmen123.xtutorial.block.entity.client.AnimatedBlockRenderer;
import com.grandmen123.xtutorial.entity.ModEntities;
import com.grandmen123.xtutorial.entity.client.TigerRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class XTutorialClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_MAPLE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_MAPLE_SAPLING, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.TIGER, TigerRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.ANIMATED_BLOCK_ENTITY, AnimatedBlockRenderer::new);
    }
}

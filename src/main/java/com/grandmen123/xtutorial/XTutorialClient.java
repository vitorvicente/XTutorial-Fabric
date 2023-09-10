package com.grandmen123.xtutorial;

import com.grandmen123.xtutorial.block.ModBlocks;
import com.grandmen123.xtutorial.fluid.ModFluids;
import com.grandmen123.xtutorial.particle.ModParticles;
import com.grandmen123.xtutorial.particle.custom.PinkGarnetParticle;
import com.grandmen123.xtutorial.util.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;

import static com.grandmen123.xtutorial.XTutorial.LOGGER;

public class XTutorialClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Client");

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_GARNET_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAULIFLOWER_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PETUNIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_PETUNIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_SOAP_WATER,
                                               ModFluids.FLOWING_SOAP_WATER);

        ModModelPredicateProvider.registerModModels();

        ParticleFactoryRegistry.getInstance()
                               .register(ModParticles.PINK_GARNET_PARTICLE, PinkGarnetParticle.Factory::new);

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_SOAP_WATER, ModFluids.FLOWING_SOAP_WATER,
                                                     SimpleFluidRenderHandler.coloredWater(0xA1E038D0));

        LOGGER.info("Finished Initializing Client");
    }
}

package com.grandmen123.xtutorial.block.entity.client;

import com.grandmen123.xtutorial.block.entity.AnimatedBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class AnimatedBlockRenderer extends GeoBlockRenderer<AnimatedBlockEntity> {
    public AnimatedBlockRenderer(BlockEntityRendererFactory.Context context) {
        super(new AnimatedBlockModel());
    }
}

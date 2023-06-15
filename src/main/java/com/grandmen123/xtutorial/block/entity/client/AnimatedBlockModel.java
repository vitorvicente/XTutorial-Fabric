package com.grandmen123.xtutorial.block.entity.client;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.block.entity.AnimatedBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedBlockModel extends GeoModel<AnimatedBlockEntity> {
    @Override
    public Identifier getModelResource(AnimatedBlockEntity animatable) {
        return new Identifier(XTutorial.MOD_ID, "geo/animated_block.geo.json");
    }

    @Override
    public Identifier getTextureResource(AnimatedBlockEntity animatable) {
        return new Identifier(XTutorial.MOD_ID, "textures/block/animated_block.png");
    }

    @Override
    public Identifier getAnimationResource(AnimatedBlockEntity animatable) {
        return new Identifier(XTutorial.MOD_ID, "animations/animated_block.animation.json");
    }
}

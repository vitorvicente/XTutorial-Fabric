package com.grandmen123.xtutorial.item.client;

import com.grandmen123.xtutorial.item.custom.AnimatedItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AnimatedItemRenderer extends GeoItemRenderer<AnimatedItem> {
    public AnimatedItemRenderer() {
        super(new AnimatedItemModel());
    }
}

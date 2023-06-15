package com.grandmen123.xtutorial.item.client;

import com.grandmen123.xtutorial.item.custom.AmethystArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class AmethystArmorRenderer extends GeoArmorRenderer<AmethystArmorItem> {
    public AmethystArmorRenderer() {
        super(new AmethystArmorModel());
    }
}

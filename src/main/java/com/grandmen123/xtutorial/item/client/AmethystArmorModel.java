package com.grandmen123.xtutorial.item.client;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.item.custom.AmethystArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class AmethystArmorModel extends GeoModel<AmethystArmorItem> {
    @Override
    public Identifier getModelResource(AmethystArmorItem animatable) {
        return new Identifier(XTutorial.MOD_ID, "geo/amethyst_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(AmethystArmorItem animatable) {
        return new Identifier(XTutorial.MOD_ID, "textures/armor/amethyst_armor.png");
    }

    @Override
    public Identifier getAnimationResource(AmethystArmorItem animatable) {
        return new Identifier(XTutorial.MOD_ID, "animations/amethyst_armor.animation.json");
    }
}

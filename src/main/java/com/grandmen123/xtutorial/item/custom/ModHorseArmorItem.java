package com.grandmen123.xtutorial.item.custom;

import com.grandmen123.xtutorial.XTutorial;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.util.Identifier;

public class ModHorseArmorItem extends HorseArmorItem {
    public ModHorseArmorItem(int bonus, String name, Settings settings) {
        super(bonus, name, settings);
    }

    @Override
    public Identifier getEntityTexture() {
        return new Identifier(XTutorial.MOD_ID, super.getEntityTexture().getPath());
    }
}

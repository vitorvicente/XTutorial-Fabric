package com.grandmen123.xtutorial.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;

// With the help of SameDifferent
// under MIT License: https://github.com/samedifferent/TrickOrTreat/blob/master/LICENSE
public class SlimeyEffect extends StatusEffect {
    public SlimeyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.horizontalCollision) {
            entity.setVelocity(new Vec3d(entity.getVelocity().getX() * 0.92D,
                                         0.20 * 0.8D,
                                         entity.getVelocity().getZ() * 0.92D));
        }

        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}

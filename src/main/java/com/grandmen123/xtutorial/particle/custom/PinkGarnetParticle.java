package com.grandmen123.xtutorial.particle.custom;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import org.jetbrains.annotations.Nullable;

public class PinkGarnetParticle extends SpriteBillboardParticle {
    protected PinkGarnetParticle(SpriteProvider spriteProvider, ClientWorld world,
                                 double xCoord, double yCoord, double zCoord,
                                 double xVelocity, double yVelocity, double zVelocity) {
        super(world, xCoord, yCoord, zCoord, xVelocity, yVelocity, zVelocity);

        this.scale *= 0.25f;

        this.setVelocity(0.5f, xVelocity, yVelocity, zVelocity);
        this.setAgeParams(10, spriteProvider);
        this.setRGB(1f, 1f, 1f);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @SuppressWarnings("SameParameterValue")
    private void setVelocity(float multiplier, double x, double y, double z) {
        this.velocityMultiplier = multiplier;
        this.velocityX = x;
        this.velocityY = y;
        this.velocityZ = z;
    }

    @SuppressWarnings("SameParameterValue")
    private void setAgeParams(int maxAge, SpriteProvider spriteProvider) {
        this.maxAge = maxAge;
        this.setSpriteForAge(spriteProvider);
    }

    @SuppressWarnings("SameParameterValue")
    private void setRGB(float r, float g, float b) {
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    public static class Factory implements ParticleFactory<DefaultParticleType> {

        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }


        @Nullable
        @Override
        public Particle createParticle(DefaultParticleType particleType, ClientWorld world,
                                       double xCoord, double yCoord, double zCoord,
                                       double xVelocity, double yVelocity, double zVelocity) {
            return new PinkGarnetParticle(this.spriteProvider, world,
                                          xCoord, yCoord, zCoord,
                                          xVelocity, yVelocity, zVelocity);
        }
    }
}

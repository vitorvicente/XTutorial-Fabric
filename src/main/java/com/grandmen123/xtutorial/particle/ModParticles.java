package com.grandmen123.xtutorial.particle;

import com.grandmen123.xtutorial.XTutorial;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.grandmen123.xtutorial.XTutorial.LOGGER;

public class ModParticles {

    public static final DefaultParticleType PINK_GARNET_PARTICLE = registerParticle("pink_garnet_particle",
                                                                                    FabricParticleTypes.simple());

    @SuppressWarnings("SameParameterValue")
    private static DefaultParticleType registerParticle(String name, DefaultParticleType defaultParticleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(XTutorial.MOD_ID, name), defaultParticleType);
    }

    public static void registerParticles() {
        LOGGER.info("Registering Mod Particles!");
    }
}

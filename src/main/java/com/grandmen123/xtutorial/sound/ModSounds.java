package com.grandmen123.xtutorial.sound;

import com.grandmen123.xtutorial.XTutorial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import static com.grandmen123.xtutorial.XTutorial.LOGGER;

public class ModSounds {

    public static final SoundEvent METAL_DETECTOR_FOUND_ORE = registerSoundEvent("metal_detector_found_ore");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(XTutorial.MOD_ID, name);

        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSounds() {
        LOGGER.info("Registering Mod Sounds");
    }
}

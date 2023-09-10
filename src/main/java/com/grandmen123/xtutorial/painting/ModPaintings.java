package com.grandmen123.xtutorial.painting;

import com.grandmen123.xtutorial.XTutorial;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.grandmen123.xtutorial.XTutorial.LOGGER;

public class ModPaintings {

    @SuppressWarnings("unused")
    public static final PaintingVariant SAW_THEM = registerPainting("saw_them", new PaintingVariant(16, 16));
    @SuppressWarnings("unused")
    public static final PaintingVariant SHRIMP = registerPainting("shrimp", new PaintingVariant(32, 16));
    @SuppressWarnings("unused")
    public static final PaintingVariant WORLD = registerPainting("world", new PaintingVariant(32, 32));


    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(XTutorial.MOD_ID, name), paintingVariant);
    }

    public static void registerPaintings() {
        LOGGER.info("Registering Mod Paintings");
    }
}

package com.grandmen123.xtutorial.datagen;

import com.grandmen123.xtutorial.XTutorial;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.PaintingVariantTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModPaintingTagProvider extends FabricTagProvider<PaintingVariant> {

    public ModPaintingTagProvider(FabricDataOutput output,
                                     CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, RegistryKeys.PAINTING_VARIANT, registryLookupFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(PaintingVariantTags.PLACEABLE)
                .addOptional(new Identifier(XTutorial.MOD_ID, "saw_them"))
                .addOptional(new Identifier(XTutorial.MOD_ID, "shrimp"))
                .addOptional(new Identifier(XTutorial.MOD_ID, "world"));
    }
}

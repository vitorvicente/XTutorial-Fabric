package com.grandmen123.xtutorial.data;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsGen extends FabricTagProvider.ItemTagProvider {
    public ModItemTagsGen(FabricDataOutput output,
                          CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static TagKey<Item> MAPLE_LOGS = createTag("maple_logs");


    private static TagKey<Item> createTag(String name) {
        return TagKey.of(Registries.ITEM.getKey(), new Identifier(XTutorial.MOD_ID, name));
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(MAPLE_LOGS)
                .add(ModBlocks.RED_MAPLE_LOG.asItem())
                .add(ModBlocks.RED_MAPLE_WOOD.asItem())
                .add(ModBlocks.STRIPPED_RED_MAPLE_LOG.asItem())
                .add(ModBlocks.STRIPPED_RED_MAPLE_WOOD.asItem())
                .setReplace(false);

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.RED_MAPLE_PLANKS.asItem())
                .setReplace(false);

        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(ModBlocks.RED_MAPLE_SAPLING.asItem())
                .setReplace(false);
    }
}

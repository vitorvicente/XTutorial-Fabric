package com.grandmen123.xtutorial.datagen;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement rootAdvancement =
                Advancement
                        .Builder
                        .create()
                        .display(new AdvancementDisplay(new ItemStack(ModItems.PINK_GARNET),
                                                        Text.translatable(
                                                                "advancement.xtutorial.pink_garnet.name"),
                                                        Text.translatable(
                                                                "advancement.xtutorial.pink_garnet.desc"),
                                                        new Identifier(XTutorial.MOD_ID,
                                                                       "textures/block/pink_garnet_ore.png"),
                                                        AdvancementFrame.TASK, true, true, false))
                        .criterion("has_pink_garnet",
                                   InventoryChangedCriterion.Conditions.items(ModItems.PINK_GARNET))
                        .build(consumer, XTutorial.MOD_ID + ":xtutorial");

        @SuppressWarnings("unused")
        Advancement metalDetector =
                Advancement
                        .Builder
                        .create()
                        .display(new AdvancementDisplay(new ItemStack(ModItems.METAL_DETECTOR),
                                                        Text.translatable(
                                                                "advancement.xtutorial.metal_detector.name"),
                                                        Text.translatable(
                                                                "advancement.xtutorial.metal_detector.desc"),
                                                        new Identifier(XTutorial.MOD_ID,
                                                                       "textures/block/pink_garnet_ore.png"),
                                                        AdvancementFrame.TASK, true, true, false))
                        .criterion("has_metal_detector",
                                   InventoryChangedCriterion.Conditions.items(ModItems.METAL_DETECTOR))
                        .parent(rootAdvancement)
                        .build(consumer, XTutorial.MOD_ID + ":metal_detector");
    }
}

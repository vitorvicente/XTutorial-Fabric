package com.grandmen123.xtutorial.item;

import com.grandmen123.xtutorial.XTutorial;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup CITRINE;

    public static void registerItemGroups() {
        CITRINE = FabricItemGroup.builder(new Identifier(XTutorial.MOD_ID, "citrine"))
                                 .displayName(Text.translatable("itemgroup.citrine"))
                                 .icon(() -> new ItemStack(ModItems.CITRINE)).build();
    }
}

package com.grandmen123.xtutorial.item;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.entity.ModEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item CITRINE = registerItem("citrine", new Item(new FabricItemSettings()));
    public static final Item RAW_CITRINE = registerItem("raw_citrine", new Item(new FabricItemSettings()));

    public static final Item TIGER_SPAWN_EGG =
            registerItem("tiger_spawn_egg", new SpawnEggItem(ModEntities.TIGER, 0xD57E36, 0x1D0D00,
                                                             new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(XTutorial.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.XTUTORIAL_CREATIVE_TAB, CITRINE);
        addToItemGroup(ModItemGroup.XTUTORIAL_CREATIVE_TAB, RAW_CITRINE);
        addToItemGroup(ModItemGroup.XTUTORIAL_CREATIVE_TAB, TIGER_SPAWN_EGG);
    }

    private static void addToItemGroup(ItemGroup itemGroup, Item item) {
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        XTutorial.LOGGER.info("Registering Mod Items for " + XTutorial.MOD_ID);

        addItemsToItemGroup();
    }
}

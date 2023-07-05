package com.grandmen123.xtutorial.item;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.item.custom.MetalDetectorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.grandmen123.xtutorial.XTutorial.LOGGER;
import static com.grandmen123.xtutorial.XTutorial.MOD_ID;

public class ModItems {

    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new FabricItemSettings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new FabricItemSettings()));

    public static final Item METAL_DETECTOR =
            registerItem("metal_detector", new MetalDetectorItem(new FabricItemSettings().maxDamage(256)));

    public static final Item CAULIFLOWER = registerItem("cauliflower",
                                                        new Item(new FabricItemSettings().food(
                                                                ModFoodComponents.CAULIFLOWER)));

    public static final Item PEAT_BRICK = registerItem("peat_brick", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item);
    }

    public static void registerModItems() {
        LOGGER.info("Registering Mod Items");

        addItemsToItemGroup();
    }

    private static void addItemsToItemGroup() {
        XTutorial.addToItemGroup(PINK_GARNET);
        XTutorial.addToItemGroup(RAW_PINK_GARNET);

        XTutorial.addToItemGroup(METAL_DETECTOR);

        XTutorial.addToItemGroup(CAULIFLOWER);

        XTutorial.addToItemGroup(PEAT_BRICK);
    }
}
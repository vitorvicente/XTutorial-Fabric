package com.grandmen123.xtutorial;

import com.grandmen123.xtutorial.block.ModBlocks;
import com.grandmen123.xtutorial.block.entity.ModBlockEntities;
import com.grandmen123.xtutorial.entity.ModEntities;
import com.grandmen123.xtutorial.item.ModItemGroup;
import com.grandmen123.xtutorial.item.ModItems;
import com.grandmen123.xtutorial.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class XTutorial implements ModInitializer {
    public static final String MOD_ID = "xtutorial";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");
        ModItemGroup.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModWorldGen.genModWorldGen();
        ModEntities.register();
        ModBlockEntities.registerAllBlockEntities();

        GeckoLib.initialize();
    }
}

package com.grandmen123.xtutorial.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static com.grandmen123.xtutorial.XTutorial.MOD_ID;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_DETECTABLE_BLOCKS =
                createBlockTag("metal_detector_detectable_blocks");
        public static final TagKey<Block> PINK_GARNET_ORES =
                createBlockTag("pink_garnet_ores");
        public static final TagKey<Block> NEEDS_PINK_GARNET_TOOL =
                customBlockTag("fabric", "needs_tool_level_5");

        public static final TagKey<Block> PAXEL_MINEABLE = createBlockTag("mineable/paxel");

        private static TagKey<Block> createBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(MOD_ID, name));
        }

        @SuppressWarnings("unused")
        private static TagKey<Block> createCommonBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", name));
        }

        @SuppressWarnings("SameParameterValue")
        private static TagKey<Block> customBlockTag(String group, String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(group, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> PINK_GARNET_ORES =
                createItemTag("pink_garnet_ores");
        public static final TagKey<Item> PAXELS =
                createItemTag("paxels");

        public static final TagKey<Item> ADVANCED_TOOLS =
                createItemTag("advanced_tools");

        private static TagKey<Item> createItemTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, name));
        }

        @SuppressWarnings("unused")
        private static TagKey<Item> createCommonItemTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier("c", name));
        }

        @SuppressWarnings("unused")
        private static TagKey<Item> customItemTag(String group, String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(group, name));
        }
    }
}

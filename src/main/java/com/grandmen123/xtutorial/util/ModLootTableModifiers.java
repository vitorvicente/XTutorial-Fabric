package com.grandmen123.xtutorial.util;

import com.grandmen123.xtutorial.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ModLootTableModifiers {
    private static final Identifier GRASS_BLOCK_ID =
            new Identifier("minecraft", "blocks/grass");
    private static final Identifier IGLOO_STRUCTURE_CHEST_ID =
            new Identifier("minecraft", "chests/igloo_chest");
    private static final Identifier CREEPER_ID =
            new Identifier("minecraft", "entities/creeper");

    private static final LootPool.Builder GRASS_BLOCK_LOOT =
            LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(0.35f))
                    .with(ItemEntry.builder(ModItems.CAULIFLOWER_SEEDS))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
    private static final LootPool.Builder IGLOO_STRUCTURE_CHEST_LOOT =
            LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(1f))
                    .with(ItemEntry.builder(ModItems.METAL_DETECTOR))
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1f)).build());
    private static final LootPool.Builder CREEPER_LOOT =
            LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(0.75f))
                    .with(ItemEntry.builder(ModItems.PEAT_BRICK))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0f, 16.0f)).build());

    private static final Map<Identifier, LootPool.Builder> MODIFIED_LOOT_TABLES =
            Map.of(GRASS_BLOCK_ID, GRASS_BLOCK_LOOT,
                   IGLOO_STRUCTURE_CHEST_ID, IGLOO_STRUCTURE_CHEST_LOOT,
                   CREEPER_ID, CREEPER_LOOT);


    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            for (Identifier identifier : MODIFIED_LOOT_TABLES.keySet())
                if (identifier.equals(id))
                    tableBuilder.pool(MODIFIED_LOOT_TABLES.get(identifier).build());
        }));
    }
}

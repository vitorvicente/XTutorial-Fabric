package com.grandmen123.xtutorial.util;

import com.grandmen123.xtutorial.item.ModItems;
import com.grandmen123.xtutorial.mixin.BrewingRecipeRegistryMixin;
import com.grandmen123.xtutorial.potion.ModPotions;
import com.grandmen123.xtutorial.villager.ModVillagers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
        registerModCompostables();
        registerPotionRecipes();
        registerCustomTrades();
    }

    private static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.PEAT_BRICK, 200);
    }

    private static void registerModCompostables() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CAULIFLOWER, 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CAULIFLOWER_SEEDS, 0.3f);
    }

    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.PINK_GARNET,
                                                              ModPotions.SLIMEY_POTION);
    }

    private static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                                                factories -> factories.add(((entity, random) -> new TradeOffer(
                                                        new ItemStack(Items.EMERALD, 2),
                                                        new ItemStack(ModItems.CAULIFLOWER, 2),
                                                        6, 2, 0.02f
                                                ))));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 3,
                                                factories -> factories.add(((entity, random) -> new TradeOffer(
                                                        new ItemStack(Items.EMERALD, 32),
                                                        new ItemStack(ModItems.PINK_GARNET_PAXEL, 1),
                                                        2, 8, 0.08f
                                                ))));

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 1,
                                                factories -> factories.add(((entity, random) -> new TradeOffer(
                                                        new ItemStack(Items.EMERALD, 32),
                                                        new ItemStack(ModItems.BAR_BRAWL_MUSIC_DISC, 1),
                                                        2, 8, 0.08f
                                                ))));
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 2,
                                                factories -> factories.add(((entity, random) -> new TradeOffer(
                                                        new ItemStack(Items.EMERALD, 32),
                                                        new ItemStack(Items.MUSIC_DISC_13, 1),
                                                        2, 8, 0.08f
                                                ))));
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 3,
                                                factories -> factories.add(((entity, random) -> new TradeOffer(
                                                        new ItemStack(Items.EMERALD, 32),
                                                        new ItemStack(Items.MUSIC_DISC_CAT, 1),
                                                        2, 8, 0.08f
                                                ))));
    }
}

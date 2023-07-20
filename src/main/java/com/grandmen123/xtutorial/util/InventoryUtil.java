package com.grandmen123.xtutorial.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InventoryUtil {

    public static boolean playerHasStackInInventory(PlayerEntity player, Item item) {
        for (ItemStack stack : player.getInventory().main) {
            if (!stack.isEmpty() && stack.isOf(item))
                return true;
        }
        return false;
    }

    public static int getFirstInventoryIndex(PlayerEntity player, Item item) {
        int index = 0;
        for (ItemStack stack : player.getInventory().main) {
            if (!stack.isEmpty() && stack.isOf(item))
                return index;
            index++;
        }
        return -1;
    }
}

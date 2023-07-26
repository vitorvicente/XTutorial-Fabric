package com.grandmen123.xtutorial.event.custom;

import com.grandmen123.xtutorial.item.ModItems;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AttackEntityHandler implements AttackEntityCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity,
                                 @Nullable EntityHitResult hitResult) {
        if (entity instanceof SheepEntity && !world.isClient() && !player.isSpectator()) {
            if (player.getStackInHand(hand).getItem() == ModItems.PINK_GARNET_SWORD)
                player.sendMessage(
                        Text.literal(player.getName().getString() + " ")
                            .append(Text.translatable("xtutorial.event.hit.sheep.pink_garnet_sword")));
            else
                player.sendMessage(
                        Text.literal(player.getName().getString() + " ")
                            .append(Text.translatable("xtutorial.event.hit.sheep")));
        }

        return ActionResult.PASS;
    }
}

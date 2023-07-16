package com.grandmen123.xtutorial.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class LightningStrikerEnchant extends Enchantment {
    public LightningStrikerEnchant(Rarity weight, EnchantmentTarget target,
                                   EquipmentSlot... slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!user.getWorld().isClient()) {
            ServerWorld world = (ServerWorld) user.getWorld();
            BlockPos pos = target.getBlockPos();

            for (int i = 0; i < level; i++)
                EntityType.LIGHTNING_BOLT.spawn(world, pos, SpawnReason.TRIGGERED);
        }


        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}

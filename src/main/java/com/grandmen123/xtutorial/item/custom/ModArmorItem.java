package com.grandmen123.xtutorial.item.custom;

import com.google.common.collect.ImmutableMap;
import com.grandmen123.xtutorial.item.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Optional;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
            new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>()
                    .put(ModArmorMaterials.PINK_GARNET, new StatusEffectInstance(StatusEffects.HASTE,
                                                                                 600,
                                                                                 2))
                    .build();

    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {
            Item helmetItem = player.getInventory().getArmorStack(0).getItem();
            if (hasFullSuitOfArmorOn(player) && helmetItem instanceof ArmorItem) {
                Optional<StatusEffectInstance> statusEffect =
                        getStatusEffect(((ArmorItem) helmetItem).getMaterial());

                statusEffect.ifPresent(statusEffectInstance -> applyStatusEffect(player, statusEffectInstance));
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void applyStatusEffect(PlayerEntity player, StatusEffectInstance statusEffect) {
        if (!player.hasStatusEffect(statusEffect.getEffectType())) {
            player.addStatusEffect(new StatusEffectInstance(statusEffect.getEffectType(),
                                                            statusEffect.getDuration(),
                                                            statusEffect.getAmplifier()));
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        for (ItemStack armorStack : player.getArmorItems()) {
            if (armorStack.isEmpty() || !(armorStack.getItem() instanceof ArmorItem))
                return false;
        }

        ArmorItem boots = (ArmorItem) player.getInventory().getArmorStack(0).getItem();
        ArmorItem leggings = (ArmorItem) player.getInventory().getArmorStack(1).getItem();
        ArmorItem chestplate = (ArmorItem) player.getInventory().getArmorStack(2).getItem();
        ArmorItem helmet = (ArmorItem) player.getInventory().getArmorStack(3).getItem();

        return boots.getMaterial() == leggings.getMaterial() && boots.getMaterial() == chestplate.getMaterial()
               && boots.getMaterial() == helmet.getMaterial();
    }

    private Optional<StatusEffectInstance> getStatusEffect(ArmorMaterial material) {
        return Optional.ofNullable(MATERIAL_TO_EFFECT_MAP.get(material));
    }
}

package com.grandmen123.xtutorial.entity;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.entity.custom.TigerEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<TigerEntity> TIGER = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(XTutorial.MOD_ID, "tiger"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TigerEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.75f)).build());

    public static void register() {

        FabricDefaultAttributeRegistry.register(ModEntities.TIGER, TigerEntity.setAttributes());
    }
}

package com.grandmen123.xtutorial.data;

import com.grandmen123.xtutorial.XTutorial;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModWorldGen extends FabricDynamicRegistryProvider {
    public ModWorldGen(FabricDataOutput output,
                       CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {

    }

    @Override
    public String getName() {
        return XTutorial.MOD_ID;
    }
}

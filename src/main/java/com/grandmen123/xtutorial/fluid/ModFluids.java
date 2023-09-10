package com.grandmen123.xtutorial.fluid;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.fluid.custom.SoapWaterFluid;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.grandmen123.xtutorial.XTutorial.LOGGER;

public class ModFluids {

    public static final FlowableFluid STILL_SOAP_WATER = registerFluid("soap_water",
                                                                       new SoapWaterFluid.Still());
    public static final FlowableFluid FLOWING_SOAP_WATER = registerFluid("flowing_soap_water",
                                                                       new SoapWaterFluid.Flowing());

    private static FlowableFluid registerFluid(String name, FlowableFluid fluid) {
        return Registry.register(Registries.FLUID, new Identifier(XTutorial.MOD_ID, name), fluid);
    }

    public static void registerFluids() {
        LOGGER.info("Registering Mod Fluids");
    }
}

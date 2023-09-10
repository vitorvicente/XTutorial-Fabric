package com.grandmen123.xtutorial.mixin;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {

    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useRadiationStaffModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode,
                                             boolean leftHanded, MatrixStack matrixStack,
                                             VertexConsumerProvider consumer, int light, int overlay) {
        if (stack.isOf(ModItems.RADIATION_STAFF) && renderMode != ModelTransformationMode.GUI)
            return ((ItemRendererAccessor) this).getModels().getModelManager().getModel(
                    new ModelIdentifier(XTutorial.MOD_ID, "radiation_staff_3d", "inventory"));

        return value;
    }
}

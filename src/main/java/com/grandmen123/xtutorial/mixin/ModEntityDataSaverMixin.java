package com.grandmen123.xtutorial.mixin;

import com.grandmen123.xtutorial.XTutorial;
import com.grandmen123.xtutorial.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class ModEntityDataSaverMixin implements IEntityDataSaver {
    private static final String PERSISTENT_DATA_KEY = XTutorial.MOD_ID + ".persistent_data";
    private NbtCompound persistentData;

    @Override
    public NbtCompound getPersistentData() {
        if (this.persistentData == null)
            this.persistentData = new NbtCompound();

        return this.persistentData;
    }

    @Override
    public void setPersistentData(NbtCompound persistentData) {
        this.persistentData = persistentData;
    }

    @Inject(method = "writeNbt", at = @At(("HEAD")))
    protected void injectWriteMethod(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> info) {
        if (!this.getPersistentData().isEmpty())
            nbt.put(PERSISTENT_DATA_KEY, persistentData);
    }

    @Inject(method = "readNbt", at = @At(("HEAD")))
    protected void injectReadMethod(NbtCompound nbt, CallbackInfo info) {
        if (nbt.contains(PERSISTENT_DATA_KEY, 10))
            this.setPersistentData(nbt.getCompound(PERSISTENT_DATA_KEY));
    }
}

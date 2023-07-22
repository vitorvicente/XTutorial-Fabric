package com.grandmen123.xtutorial.util;

import net.minecraft.nbt.NbtCompound;

public interface IEntityDataSaver {
    NbtCompound getPersistentData();

    void setPersistentData(NbtCompound nbt);
}

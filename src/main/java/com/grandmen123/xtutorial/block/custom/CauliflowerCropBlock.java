package com.grandmen123.xtutorial.block.custom;

import com.grandmen123.xtutorial.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class CauliflowerCropBlock extends CropBlock {
    public static final int MAX_AGE = 6;
    public static final IntProperty AGE = IntProperty.of("age", 0, MAX_AGE);
    public CauliflowerCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.CAULIFLOWER_SEEDS;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}

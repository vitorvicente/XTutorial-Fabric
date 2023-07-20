package com.grandmen123.xtutorial.item.custom;

import com.grandmen123.xtutorial.XTutorial;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DataTabletItem extends Item {

    public static final String LAST_VALUABLE_FOUND_NBT_KEY = XTutorial.MOD_ID + "last_valuable_found";

    public DataTabletItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (stack.hasNbt() && stack.getNbt() != null) {
            stack.setNbt(new NbtCompound());

        }

        return super.use(world, user, hand);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        if (stack.hasNbt() && stack.getNbt() != null) {
            String currentFoundValuable = stack.getNbt().getString(LAST_VALUABLE_FOUND_NBT_KEY);
            if (!currentFoundValuable.isBlank() && !currentFoundValuable.isEmpty())
                return true;
        }
        return super.hasGlint(stack);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.hasNbt() && stack.getNbt() != null) {
            String currentFoundValuable = stack.getNbt().getString(LAST_VALUABLE_FOUND_NBT_KEY);
            tooltip.add(Text.literal(currentFoundValuable));
        }
    }
}

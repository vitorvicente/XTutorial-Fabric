package com.grandmen123.xtutorial.item.custom;

import com.grandmen123.xtutorial.item.ModItems;
import com.grandmen123.xtutorial.util.InventoryUtil;
import com.grandmen123.xtutorial.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {

    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getPlayer() == null)
            return ActionResult.PASS;

        if (!context.getWorld().isClient()) {
            BlockPos blockPos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= blockPos.getY() + 64; i++) {
                BlockState blockState = context.getWorld().getBlockState(blockPos.down(i));
                Block block = blockState.getBlock();

                if (blockState.isIn(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)) {
                    foundBlock = true;
                    handleFoundData(player, blockPos.down(i), block);
                    break;
                }
            }

            if (!foundBlock) {
                player.sendMessage(Text.translatable("item.xtutorial.metal_detector.no_valuables"));
            }
        }
        context.getStack().damage(1, context.getPlayer(),
                                  playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));



        return super.useOnBlock(context);
    }

    private void handleFoundData(PlayerEntity player, BlockPos down, Block block) {
        Text message = Text.translatable("item.xtutorial.metal_detector.found_valuables")
                           .append(Text.literal(" " + block.getName().getString() + " @ "
                                                + down.getX() + ", "
                                                + down.getY() + ", "
                                                + down.getZ()));

        if (InventoryUtil.playerHasStackInInventory(player, ModItems.DATA_TABLET)) {
            int index = InventoryUtil.getFirstInventoryIndex(player, ModItems.DATA_TABLET);
            NbtCompound nbtData = new NbtCompound();
            nbtData.putString(DataTabletItem.LAST_VALUABLE_FOUND_NBT_KEY, message.getString());
            player.getInventory().getStack(index).setNbt(nbtData);
        }

        player.sendMessage(message);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.xtutorial.metal_detector.tooltip.shift"));
        } else {
            tooltip.add(Text.translatable("item.xtutorial.metal_detector.tooltip"));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}

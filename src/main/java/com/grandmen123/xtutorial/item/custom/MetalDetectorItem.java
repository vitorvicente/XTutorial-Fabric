package com.grandmen123.xtutorial.item.custom;

import com.grandmen123.xtutorial.item.ModItems;
import com.grandmen123.xtutorial.sound.ModSounds;
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
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
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
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.xtutorial.metal_detector.tooltip.shift"));
        } else {
            tooltip.add(Text.translatable("item.xtutorial.metal_detector.tooltip"));
        }
        super.appendTooltip(stack, world, tooltip, context);
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
                if (context.getWorld().getBlockState(blockPos.down(i))
                           .isIn(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)) {
                    foundBlock = true;
                    handleFoundData(context, player, i);
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

    private void handleFoundData(ItemUsageContext context,
                                 PlayerEntity player,
                                 int depth) {

        BlockPos down = context.getBlockPos().down(depth);
        Block block = context.getWorld().getBlockState(down).getBlock();
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

        player.playSound(ModSounds.METAL_DETECTOR_FOUND_ORE, SoundCategory.BLOCKS, 1.0f, 1.0f);

        spawnFoundParticles(((ServerWorld) context.getWorld()), context.getBlockPos(),
                            context.getWorld().getBlockState(down));

        player.sendMessage(message);
    }

    private void spawnFoundParticles(ServerWorld world, BlockPos blockPos, BlockState blockState) {
        for (int i = 0; i < 20; i++)
            world.spawnParticles(new BlockStateParticleEffect(ParticleTypes.BLOCK, blockState),
                                 blockPos.getX() + 0.5d, blockPos.getY() + 1, blockPos.getZ() + 0.5, 2,
                                 Math.cos(i * 10) * 0.25d, 0.15d, Math.sin(i * 18) * 0.25d, 5f);
    }
}

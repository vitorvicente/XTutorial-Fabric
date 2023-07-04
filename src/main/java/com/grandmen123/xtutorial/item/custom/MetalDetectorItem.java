package com.grandmen123.xtutorial.item.custom;

import com.grandmen123.xtutorial.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class MetalDetectorItem extends Item {
    private static final List<Block> VALUABLE_BLOCKS = List.of(Blocks.IRON_ORE, Blocks.GOLD_ORE, Blocks.COPPER_ORE,
                                                               Blocks.DIAMOND_ORE, Blocks.EMERALD_ORE,
                                                               Blocks.LAPIS_ORE, Blocks.REDSTONE_ORE,
                                                               Blocks.COAL_ORE, Blocks.DEEPSLATE_COAL_ORE,
                                                               Blocks.DEEPSLATE_COPPER_ORE, Blocks.DEEPSLATE_IRON_ORE,
                                                               Blocks.DEEPSLATE_GOLD_ORE, Blocks.DEEPSLATE_DIAMOND_ORE,
                                                               Blocks.DEEPSLATE_LAPIS_ORE,
                                                               Blocks.DEEPSLATE_REDSTONE_ORE,
                                                               Blocks.DEEPSLATE_EMERALD_ORE,
                                                               Blocks.NETHER_GOLD_ORE,
                                                               Blocks.NETHER_QUARTZ_ORE,
                                                               ModBlocks.PINK_GARNET_ORE,
                                                               ModBlocks.DEEPSLATE_PINK_GARNET_ORE,
                                                               ModBlocks.NETHERRACK_PINK_GARNET_ORE,
                                                               ModBlocks.END_STONE_PINK_GARNET_ORE);

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

                if (VALUABLE_BLOCKS.contains(block)) {
                    outputValuableCoordinates(player, blockPos.down(i), block);
                    foundBlock = true;
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

    private void outputValuableCoordinates(PlayerEntity player, BlockPos blockPos, Block block) {
        player.sendMessage(Text.translatable("item.xtutorial.metal_detector.found_valuables")
                               .append(Text.literal(block.getName().getString() + " @ "
                                                    + blockPos.getX() + ", "
                                                    + blockPos.getY() + ", "
                                                    + blockPos.getZ())));
    }
}

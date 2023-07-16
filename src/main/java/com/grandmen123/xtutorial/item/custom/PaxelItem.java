package com.grandmen123.xtutorial.item.custom;

import com.google.common.collect.ImmutableMap;
import com.grandmen123.xtutorial.util.ModTags;
import com.mojang.datafixers.util.Pair;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PaxelItem extends MiningToolItem {
    protected static final Map<Block, Block>
            STRIPPED_BLOCKS = new ImmutableMap.Builder<Block, Block>().put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD)
                                                                      .put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG)
                                                                      .put(Blocks.DARK_OAK_WOOD,
                                                                           Blocks.STRIPPED_DARK_OAK_WOOD)
                                                                      .put(Blocks.DARK_OAK_LOG,
                                                                           Blocks.STRIPPED_DARK_OAK_LOG)
                                                                      .put(Blocks.ACACIA_WOOD,
                                                                           Blocks.STRIPPED_ACACIA_WOOD)
                                                                      .put(Blocks.ACACIA_LOG,
                                                                           Blocks.STRIPPED_ACACIA_LOG)
                                                                      .put(Blocks.CHERRY_WOOD,
                                                                           Blocks.STRIPPED_CHERRY_WOOD)
                                                                      .put(Blocks.CHERRY_LOG,
                                                                           Blocks.STRIPPED_CHERRY_LOG)
                                                                      .put(Blocks.BIRCH_WOOD,
                                                                           Blocks.STRIPPED_BIRCH_WOOD)
                                                                      .put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG)
                                                                      .put(Blocks.JUNGLE_WOOD,
                                                                           Blocks.STRIPPED_JUNGLE_WOOD)
                                                                      .put(Blocks.JUNGLE_LOG,
                                                                           Blocks.STRIPPED_JUNGLE_LOG)
                                                                      .put(Blocks.SPRUCE_WOOD,
                                                                           Blocks.STRIPPED_SPRUCE_WOOD)
                                                                      .put(Blocks.SPRUCE_LOG,
                                                                           Blocks.STRIPPED_SPRUCE_LOG)
                                                                      .put(Blocks.WARPED_STEM,
                                                                           Blocks.STRIPPED_WARPED_STEM)
                                                                      .put(Blocks.WARPED_HYPHAE,
                                                                           Blocks.STRIPPED_WARPED_HYPHAE)
                                                                      .put(Blocks.CRIMSON_STEM,
                                                                           Blocks.STRIPPED_CRIMSON_STEM)
                                                                      .put(Blocks.CRIMSON_HYPHAE,
                                                                           Blocks.STRIPPED_CRIMSON_HYPHAE)
                                                                      .put(Blocks.MANGROVE_WOOD,
                                                                           Blocks.STRIPPED_MANGROVE_WOOD)
                                                                      .put(Blocks.MANGROVE_LOG,
                                                                           Blocks.STRIPPED_MANGROVE_LOG)
                                                                      .put(Blocks.BAMBOO_BLOCK,
                                                                           Blocks.STRIPPED_BAMBOO_BLOCK).build();

    protected static final Map<Block, BlockState>
            PATH_STATES = new ImmutableMap.Builder<Block, BlockState>().put(Blocks.GRASS_BLOCK,
                                                                            Blocks.DIRT_PATH.getDefaultState())
                                                                       .put(Blocks.DIRT,
                                                                            Blocks.DIRT_PATH.getDefaultState())
                                                                       .put(Blocks.PODZOL,
                                                                            Blocks.DIRT_PATH.getDefaultState())
                                                                       .put(Blocks.COARSE_DIRT,
                                                                            Blocks.DIRT_PATH.getDefaultState())
                                                                       .put(Blocks.MYCELIUM,
                                                                            Blocks.DIRT_PATH.getDefaultState())
                                                                       .put(Blocks.ROOTED_DIRT,
                                                                            Blocks.DIRT_PATH.getDefaultState())
                                                                       .build();

    protected static final Map<Block, Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>>>
            TILLING_ACTIONS = ImmutableMap.of(Blocks.GRASS_BLOCK, Pair.of(HoeItem::canTillFarmland,
                                                                          HoeItem.createTillAction(
                                                                                  Blocks.FARMLAND.getDefaultState())),
                                              Blocks.DIRT_PATH, Pair.of(HoeItem::canTillFarmland,
                                                                        HoeItem.createTillAction(
                                                                                Blocks.FARMLAND.getDefaultState())),
                                              Blocks.DIRT, Pair.of(HoeItem::canTillFarmland,
                                                                   HoeItem.createTillAction(
                                                                           Blocks.FARMLAND.getDefaultState())),
                                              Blocks.COARSE_DIRT, Pair.of(HoeItem::canTillFarmland,
                                                                          HoeItem.createTillAction(
                                                                                  Blocks.DIRT.getDefaultState())),
                                              Blocks.ROOTED_DIRT, Pair.of(itemUsageContext -> true,
                                                                          HoeItem.createTillAndDropAction(
                                                                                  Blocks.DIRT.getDefaultState(),
                                                                                  Items.HANGING_ROOTS)));


    public PaxelItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(attackDamage, attackSpeed, material, ModTags.Blocks.PAXEL_MINEABLE, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        BlockState blockState = world.getBlockState(blockPos);

        // Axe Strip
        Optional<BlockState> optional = this.getStrippedState(blockState);
        Optional<BlockState> optional2 = Oxidizable.getDecreasedOxidationState(blockState);
        Optional<BlockState> optional3 =
                Optional.ofNullable(HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get().get(blockState.getBlock()))
                        .map(block -> block.getStateWithProperties(blockState));
        ItemStack itemStack = context.getStack();
        Optional<BlockState> optional4 = Optional.empty();
        if (optional.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0f, 1.0f);
            optional4 = optional;
        } else if (optional2.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.syncWorldEvent(playerEntity, WorldEvents.BLOCK_SCRAPED, blockPos, 0);
            optional4 = optional2;
        } else if (optional3.isPresent()) {
            world.playSound(playerEntity, blockPos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.syncWorldEvent(playerEntity, WorldEvents.WAX_REMOVED, blockPos, 0);
            optional4 = optional3;
        }
        if (optional4.isPresent()) {
            if (playerEntity instanceof ServerPlayerEntity) {
                Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity) playerEntity, blockPos, itemStack);
            }
            world.setBlockState(blockPos, optional4.get(), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, optional4.get()));
            if (playerEntity != null) {
                itemStack.damage(1, playerEntity, p -> p.sendToolBreakStatus(context.getHand()));
            }
            return ActionResult.success(world.isClient);
        }

        // Shovel Path
        if (context.getSide() != Direction.DOWN && playerEntity != null && !playerEntity.isSneaking()) {
            Optional<BlockState> optional5 = this.getPathedState(blockState);
            Optional<BlockState> optional6 = Optional.empty();
            if (optional5.isPresent() && world.getBlockState(blockPos.up()).isAir()) {
                world.playSound(playerEntity, blockPos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0f,
                                1.0f);
                optional6 = optional5;
            } else if (blockState.getBlock() instanceof CampfireBlock && blockState.get(CampfireBlock.LIT)) {
                if (!world.isClient()) {
                    world.syncWorldEvent(null, WorldEvents.FIRE_EXTINGUISHED, blockPos, 0);
                }
                CampfireBlock.extinguish(context.getPlayer(), world, blockPos, blockState);
                optional6 = Optional.of(blockState.with(CampfireBlock.LIT, false));
            }
            if (optional6.isPresent()) {
                if (!world.isClient) {
                    world.setBlockState(blockPos, optional6.get(), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
                    world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos,
                                        GameEvent.Emitter.of(playerEntity, optional6.get()));
                    context.getStack().damage(1, playerEntity, p -> p.sendToolBreakStatus(context.getHand()));
                }
                return ActionResult.success(world.isClient);
            }
        }

        // Hoe Plant
        Optional<Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>>> pair = getTilledState(blockState);
        if (pair.isPresent() && playerEntity != null && playerEntity.isSneaking()) {
            Predicate<ItemUsageContext> predicate = pair.get().getFirst();
            Consumer<ItemUsageContext> consumer = pair.get().getSecond();
            if (predicate.test(context)) {
                world.playSound(playerEntity, blockPos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!world.isClient) {
                    consumer.accept(context);
                    context.getStack().damage(1, playerEntity, p -> p.sendToolBreakStatus(context.getHand()));
                }
                return ActionResult.success(world.isClient);
            }
        }


        return ActionResult.PASS;
    }


    private Optional<BlockState> getStrippedState(BlockState state) {
        return Optional.ofNullable(STRIPPED_BLOCKS.get(state.getBlock()))
                       .map(block -> block.getDefaultState().with(
                               PillarBlock.AXIS, state.get(PillarBlock.AXIS)));
    }

    private Optional<BlockState> getPathedState(BlockState state) {
        return Optional.ofNullable(PATH_STATES.get(state.getBlock()));
    }

    private Optional<Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>>> getTilledState(BlockState state) {
        return Optional.ofNullable(TILLING_ACTIONS.get(state.getBlock()));
    }
}

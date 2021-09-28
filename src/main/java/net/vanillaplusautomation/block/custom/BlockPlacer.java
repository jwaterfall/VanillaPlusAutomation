package net.vanillaplusautomation.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.*;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.vanillaplusautomation.block.custom.entity.BlockPlacerBlockEntity;

import java.util.Random;

public class BlockPlacer extends BlockWithEntity {
    public static final DirectionProperty FACING;
    public static final BooleanProperty TRIGGERED;

    public BlockPlacer(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState) ((BlockState) ((BlockState) this.stateManager.getDefaultState()).with(FACING,
                Direction.NORTH)).with(TRIGGERED, false));
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
            BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof BlockPlacerBlockEntity) {
                player.openHandledScreen((BlockPlacerBlockEntity) blockEntity);
            }

            return ActionResult.CONSUME;
        }
    }
    protected void placeBlock(ServerWorld world, BlockPos pos) {
        BlockPointerImpl blockPointer = new BlockPointerImpl(world, pos);
        Direction direction = (Direction) blockPointer.getBlockState().get(BlockPlacer.FACING);
        BlockPos blockPos = blockPointer.getPos().offset(direction);
        Direction direction2 = blockPointer.getWorld().isAir(blockPos.down()) ? direction : Direction.UP;
        BlockPlacerBlockEntity blockPlacerBlockEntity = (BlockPlacerBlockEntity) blockPointer.getBlockEntity();
        int i = blockPlacerBlockEntity.chooseNonEmptySlot();

        if (i < 0) {
            world.playSound(null, blockPos, SoundEvents.BLOCK_DISPENSER_FAIL, SoundCategory.BLOCKS, 1f, 1.2f);
        } else {
            ItemStack itemStack = blockPlacerBlockEntity.getStack(i);
            Item item = itemStack.getItem();

            if (item instanceof BlockItem) {
                Boolean isAccepted = ((BlockItem) item)
                        .place(new AutomaticItemPlacementContext(world, blockPos, direction, itemStack, direction2))
                        .isAccepted();
                if (isAccepted) {
                    world.playSound(null, blockPos, SoundEvents.BLOCK_DISPENSER_DISPENSE, SoundCategory.BLOCKS, 1f, 1f);
                } else {
                    world.playSound(null, blockPos, SoundEvents.BLOCK_DISPENSER_FAIL, SoundCategory.BLOCKS, 1f, 1.2f);
                }
                ;
            } else {
                world.playSound(null, blockPos, SoundEvents.BLOCK_DISPENSER_FAIL, SoundCategory.BLOCKS, 1f, 1.2f);
            }

            blockPlacerBlockEntity.setStack(i, itemStack);
        }
    }

    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos,
            boolean notify) {
        boolean bl = world.isReceivingRedstonePower(pos) || world.isReceivingRedstonePower(pos.up());
        boolean bl2 = (Boolean) state.get(TRIGGERED);
        if (bl && !bl2) {
            world.getBlockTickScheduler().schedule(pos, this, 4);
            world.setBlockState(pos, (BlockState) state.with(TRIGGERED, true), Block.NO_REDRAW);
        } else if (!bl && bl2) {
            world.setBlockState(pos, (BlockState) state.with(TRIGGERED, false), Block.NO_REDRAW);
        }

    }

    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.placeBlock(world, pos);
    }

    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BlockPlacerBlockEntity(pos, state);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState) this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if (itemStack.hasCustomName()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof BlockPlacerBlockEntity) {
                ((BlockPlacerBlockEntity) blockEntity).setCustomName(itemStack.getName());
            }
        }

    }

    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof BlockPlacerBlockEntity) {
                ItemScatterer.spawn(world, (BlockPos) pos, (Inventory) ((BlockPlacerBlockEntity) blockEntity));
                world.updateComparators(pos, this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    public static Position getOutputLocation(BlockPointer pointer) {
        Direction direction = (Direction) pointer.getBlockState().get(FACING);
        double d = pointer.getX() + 0.7D * (double) direction.getOffsetX();
        double e = pointer.getY() + 0.7D * (double) direction.getOffsetY();
        double f = pointer.getZ() + 0.7D * (double) direction.getOffsetZ();
        return new PositionImpl(d, e, f);
    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState) state.with(FACING, rotation.rotate((Direction) state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation((Direction) state.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, TRIGGERED);
    }

    static {
        FACING = FacingBlock.FACING;
        TRIGGERED = Properties.TRIGGERED;
    }
}

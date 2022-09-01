package net.vanillaplusautomation.machines.blockbreaker;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.item.Item;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.vanillaplusautomation.machines.Machine;
import net.vanillaplusautomation.machines.MachineBlockEntity;

import java.util.Arrays;
import java.util.List;

public class BlockBreakerBlockEntity extends MachineBlockEntity {
    private static final List<Block> PROHIBITED_BLOCKS = Arrays.asList(Blocks.AIR, Blocks.BEDROCK, Blocks.SPAWNER, Blocks.BARRIER);

    public BlockBreakerBlockEntity(final Machine machineType, BlockPos pos, BlockState state) {
        super(machineType, pos, state);
    }

    @Override
    public boolean performOperation(BlockState state, ServerWorld world, BlockPos pos, Direction facing, Random random) {
        BlockPos targetBlockPos = pos.offset(facing);
        BlockState targetBlockState = world.getBlockState(targetBlockPos);
        Block targetBlock = targetBlockState.getBlock();
        Item item = targetBlock.asItem();

        if (PROHIBITED_BLOCKS.contains(targetBlock) || targetBlock instanceof FluidBlock) {
            return false;
        }

        boolean success = addItem(item);

        if (success) {
            world.breakBlock(targetBlockPos, false);
        }

        return success;
    }
}

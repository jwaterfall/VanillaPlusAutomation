package net.vanillaplusautomation.machines.blockplacer;

import net.minecraft.block.BlockState;
import net.minecraft.item.AutomaticItemPlacementContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.vanillaplusautomation.machines.Machine;
import net.vanillaplusautomation.machines.MachineBlockEntity;

public class BlockPlacerBlockEntity extends MachineBlockEntity {
    public BlockPlacerBlockEntity(final Machine machineType, BlockPos pos, BlockState state) {
        super(machineType, pos, state);
    }

    @Override
    public boolean performOperation(BlockState state, ServerWorld world, BlockPos pos, Direction facing, Random random) {
        BlockPos targetBlockPos = pos.offset(facing);
        Direction side = world.isAir(targetBlockPos.down()) ? facing : Direction.UP;
        int slot = getNonEmptySlot(world.random);

        if (slot < 0) {
            return false;
        }

        ItemStack itemStack = getStack(slot);
        Item item = itemStack.getItem();

        if (item instanceof BlockItem) {
            boolean isAccepted = ((BlockItem) item).place(new AutomaticItemPlacementContext(world, targetBlockPos, facing, itemStack, side)).isAccepted();
            if (isAccepted) {
                itemStack.decrement(1);
                setStack(slot, itemStack);
                return true;
            } else {
                return false;
            }
        }

        return false;
    }
}

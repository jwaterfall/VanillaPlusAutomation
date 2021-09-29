package net.vanillaplusautomation.machines;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public interface BlockEntitySupplier {
    MachineBlockEntity create(Machine machineType, BlockPos pos, BlockState state);
}
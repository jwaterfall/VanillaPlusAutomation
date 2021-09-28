package net.vanillaplusautomation.machines;

public interface BlockSupplier {
    MachineBlock create(Machine machineType, BlockEntitySupplier blockEntity);
}

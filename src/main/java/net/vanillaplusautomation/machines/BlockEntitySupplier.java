package net.vanillaplusautomation.machines;

public interface BlockEntitySupplier {
    MachineBlockEntity create(Machine machineType);
}
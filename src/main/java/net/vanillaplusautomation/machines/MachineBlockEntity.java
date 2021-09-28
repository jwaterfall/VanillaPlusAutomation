package net.vanillaplusautomation.machines;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.Generic3x3ContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class MachineBlockEntity extends BlockEntity {
    private static final Random RANDOM = new Random();
    private DefaultedList<ItemStack> inventory;
    private Machine machineType;

    protected MachineBlockEntity(Machine machineType) {
        super(machineType.getBlockEntityType());
        this.inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);
        this.machineType = machineType;
    }

    public int size() {
        return 9;
    }

    public Boolean addItem(Item item) {
        for (int i = 0; i < this.inventory.size(); ++i) {
            ItemStack itemStack = this.inventory.get(i);
            if(itemStack.isEmpty()) continue;

            int existingCount = itemStack.getCount();
            Boolean isSameItem = itemStack.isOf(item);
            int maxCount = item.getMaxCount();

            if (isSameItem && existingCount <= maxCount - 1) {
                itemStack.increment(1);
                this.setStack(i, itemStack);
                return true;
            }
        }

        for (int i = 0; i < this.inventory.size(); ++i) {
            ItemStack itemStack = this.inventory.get(i);
            if (itemStack.isEmpty()) {
                this.setStack(i, new ItemStack(item));
                return true;
            }
        }

        return false;
    }

    protected Text getContainerName() {
        return this.machineType.getName();
    }

    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        if (!this.deserializeLootTable(nbt)) {
            Inventories.readNbt(nbt, this.inventory);
        }

    }

    public NbtCompound writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (!this.serializeLootTable(nbt)) {
            Inventories.writeNbt(nbt, this.inventory);
        }

        return nbt;
    }

    protected DefaultedList<ItemStack> getInvStackList() {
        return this.inventory;
    }

    protected void setInvStackList(DefaultedList<ItemStack> list) {
        this.inventory = list;
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new Generic3x3ContainerScreenHandler(syncId, playerInventory, this);
    }
}

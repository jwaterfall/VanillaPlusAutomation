package net.vanillaplusautomation.machines;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.Generic3x3ContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

public class MachineBlockEntity extends LootableContainerBlockEntity {
    private DefaultedList<ItemStack> inventory;
    private final Machine machineType;

    protected MachineBlockEntity(Machine machineType, BlockPos pos, BlockState state) {
        super(machineType.getEntityType(), pos, state);
        this.inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);
        this.machineType = machineType;
    }

    public int size() {
        return 9;
    }

    public boolean performOperation(BlockState state, ServerWorld world, BlockPos pos, Direction facing, Random random) {
        return true;
    }

    public Boolean addItem(Item item) {
        for (int i = 0; i < this.inventory.size(); ++i) {
            ItemStack itemStack = this.inventory.get(i);
            if (itemStack.isEmpty()) continue;

            int existingCount = itemStack.getCount();
            boolean isSameItem = itemStack.isOf(item);
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

    public int getNonEmptySlot(Random random) {
        this.checkLootInteraction((PlayerEntity) null);
        int i = -1;
        int j = 1;

        for (int k = 0; k < this.inventory.size(); ++k) {
            if (!((ItemStack) this.inventory.get(k)).isEmpty() && random.nextInt(j++) == 0) {
                i = k;
            }
        }

        return i;
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

    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (!this.serializeLootTable(nbt)) {
            Inventories.writeNbt(nbt, this.inventory);
        }
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

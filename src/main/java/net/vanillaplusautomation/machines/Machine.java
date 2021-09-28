package net.vanillaplusautomation.machines;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.vanillaplusautomation.VanillaPlusAutomation;
import net.vanillaplusautomation.item.ModItemGroup;
import net.vanillaplusautomation.machines.blockbreaker.BlockBreakerBlockEntity;

import java.util.Locale;
import java.util.function.Supplier;

public enum Machine {
    BLOCK_BREAKER(MachineBlock::new, BlockBreakerBlockEntity::new);

    private MachineBlock block;
    private BlockEntityType<?> blockEntityType;

    private Machine(final BlockSupplier blockSupplier, final BlockEntitySupplier blockEntitySupplier){
        block = blockSupplier.create(this, blockEntitySupplier);
    }

    public Block getBlock() {
        return block;
    }

    public void setEntityType(final BlockEntityType<?> newEntityType) {
        if (blockEntityType != null) {
            throw new IllegalStateException("Entity type already set for machine type " + toString());
        }

        blockEntityType = newEntityType;
    }

    public BlockEntityType<?> getEntityType() {
        return blockEntityType;
    }

    public Supplier<? extends BlockEntity> getEntitySupplier() {
        return () -> block.createBlockEntity();
    }

    public Identifier buildIdentifier() {
        return new Identifier(VanillaPlusAutomation.MOD_ID, name().toLowerCase(Locale.ROOT));
    }

    public void register() {
        Registry.register(Registry.ITEM, buildIdentifier(),
                new BlockItem(block,
                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        Registry.register(Registry.BLOCK, buildIdentifier(), block);

        final BlockEntityType<?> entityType = FabricBlockEntityTypeBuilder
                .create(getEntitySupplier(), block)
                .build(null);

        Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                buildIdentifier(),
                entityType);

        setEntityType(entityType);
    }
}

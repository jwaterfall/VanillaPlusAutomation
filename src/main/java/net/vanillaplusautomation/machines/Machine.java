package net.vanillaplusautomation.machines;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.vanillaplusautomation.VanillaPlusAutomation;
import net.vanillaplusautomation.item.ModItemGroup;
import net.vanillaplusautomation.machines.blockbreaker.BlockBreakerBlockEntity;
import net.vanillaplusautomation.machines.blockplacer.BlockPlacerBlockEntity;

import java.util.Locale;

public enum Machine {
    BLOCK_BREAKER(Text.translatable("container.block_breaker"), MachineBlock::new, BlockBreakerBlockEntity::new),
    BLOCK_PLACER(Text.translatable("container.block_placer"), MachineBlock::new, BlockPlacerBlockEntity::new);

    private final MachineBlock block;
    private BlockEntityType<?> blockEntityType;
    private final Text name;

    private Machine(Text name, final BlockSupplier blockSupplier, final BlockEntitySupplier blockEntitySupplier) {
        block = blockSupplier.create(this, blockEntitySupplier);
        this.name = name;
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

    public Text getName() {
        return name;
    }

    ;

    public BlockEntityType<?> getEntityType() {
        return blockEntityType;
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
                .create(block::createBlockEntity, block)
                .build(null);

        Registry.register(
                Registry.BLOCK_ENTITY_TYPE,
                buildIdentifier(),
                entityType);

        setEntityType(entityType);
    }
}

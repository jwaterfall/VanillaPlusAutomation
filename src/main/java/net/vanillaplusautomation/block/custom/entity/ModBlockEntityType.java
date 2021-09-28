package net.vanillaplusautomation.block.custom.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.vanillaplusautomation.VanillaPlusAutomation;
import net.vanillaplusautomation.block.ModBlocks;

public class ModBlockEntityType {
    public static final BlockEntityType<BlockPlacerBlockEntity> BLOCK_PLACER_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE, new Identifier(VanillaPlusAutomation.MOD_ID, "block_placer_block_entity"),
            FabricBlockEntityTypeBuilder.create(BlockPlacerBlockEntity::new, ModBlocks.BLOCK_PLACER).build(null));

    public static void registerModBlockEntitiesTypes() {
        System.out.println("Registering block entity types for " + VanillaPlusAutomation.MOD_ID);
    }
}

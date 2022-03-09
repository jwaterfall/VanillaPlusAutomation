package net.vanillaplusautomation.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.vanillaplusautomation.VanillaPlusAutomation;
import net.vanillaplusautomation.block.custom.CustomStairsBlock;
import net.vanillaplusautomation.item.ModItemGroup;

public class ModBlocks {
        public static final Block RUBY_ORE = registerBlock("ruby_ore", new Block(FabricBlockSettings.of(Material.STONE)
                        .strength(3.0f).requiresTool()));

        public static final Block SAPPHIRE_ORE = registerBlock("sapphire_ore", new Block(FabricBlockSettings
                        .of(Material.STONE).strength(3.0f).requiresTool()));

        public static final Block PERIDOT_ORE = registerBlock("peridot_ore", new Block(FabricBlockSettings
                        .of(Material.STONE).strength(3.0f).requiresTool()));

        public static final Block ELECTROTINE_ORE = registerBlock("electrotine_ore", new Block(FabricBlockSettings
                        .of(Material.STONE).strength(3.0f).requiresTool()));

        public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", new Block(FabricBlockSettings
                        .of(Material.STONE).strength(4.5f).requiresTool()));

        public static final Block DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
                        new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f)
                                        .requiresTool()));

        public static final Block DEEPSLATE_PERIDOT_ORE = registerBlock("deepslate_peridot_ore",
                        new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f)
                                        .requiresTool()));

        public static final Block DEEPSLATE_ELECTROTINE_ORE = registerBlock("deepslate_electrotine_ore",
                        new Block(FabricBlockSettings.of(Material.STONE).strength(4.5f)
                                        .requiresTool()));

        public static final Block RUBY_BLOCK = registerBlock("ruby_block", new Block(FabricBlockSettings
                        .of(Material.STONE).strength(5.0f).requiresTool()));

        public static final Block SAPPHIRE_BLOCK = registerBlock("sapphire_block", new Block(FabricBlockSettings
                        .of(Material.STONE).strength(5.0f).requiresTool()));

        public static final Block PERIDOT_BLOCK = registerBlock("peridot_block", new Block(FabricBlockSettings
                        .of(Material.STONE).strength(5.0f).requiresTool()));

        public static final Block ELECTROTINE_BLOCK = registerBlock("electrotine_block", new Block(FabricBlockSettings
                        .of(Material.STONE).strength(5.0f).requiresTool()));

        public static final Block BASALT = registerBlock("basalt", new Block(FabricBlockSettings.of(Material.STONE)
                        .strength(1.5f).requiresTool()));

        public static final Block POLISHED_BASALT = registerBlock("polished_basalt", new PillarBlock(FabricBlockSettings
                .of(Material.STONE).strength(1.5f).requiresTool()));

        public static final Block BASALT_PILLAR = registerBlock("basalt_pillar", new PillarBlock(FabricBlockSettings
                .of(Material.STONE).strength(1.5f).requiresTool()));

        public static final Block BASALT_BRICKS = registerBlock("basalt_bricks", new Block(FabricBlockSettings
                        .of(Material.STONE).strength(1.5f).requiresTool()));

        public static final Block BASALT_BRICK_STAIRS = registerBlock("basalt_brick_stairs",
                        new CustomStairsBlock(ModBlocks.BASALT_BRICKS.getDefaultState(),
                                        FabricBlockSettings.of(Material.STONE).strength(1.5f)
                                                        .requiresTool()));

        public static final Block BASALT_BRICK_SLAB = registerBlock("basalt_brick_slab",
                        new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f)
                                        .requiresTool()));

        public static final Block BASALT_BRICK_WALL = registerBlock("basalt_brick_wall",
                        new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f)
                                        .requiresTool()));

        public static final Block MARBLE = registerBlock("marble", new Block(FabricBlockSettings.of(Material.STONE)
                        .strength(1.5f).requiresTool()));

        public static final Block POLISHED_MARBLE = registerBlock("polished_marble", new PillarBlock(FabricBlockSettings
                .of(Material.STONE).strength(1.5f).requiresTool()));

        public static final Block MARBLE_PILLAR = registerBlock("marble_pillar", new PillarBlock(FabricBlockSettings
                        .of(Material.STONE).strength(1.5f).requiresTool()));

        public static final Block MARBLE_BRICKS = registerBlock("marble_bricks", new Block(FabricBlockSettings
                        .of(Material.STONE).strength(1.5f).requiresTool()));

        public static final Block MARBLE_BRICK_STAIRS = registerBlock("marble_brick_stairs",
                        new CustomStairsBlock(ModBlocks.MARBLE_BRICKS.getDefaultState(),
                                        FabricBlockSettings.of(Material.STONE).strength(1.5f)
                                                       .requiresTool()));

        public static final Block MARBLEBRICK_SLAB = registerBlock("marble_brick_slab",
                        new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f)
                                       .requiresTool()));

        public static final Block MARBLE_BRICK_WALL = registerBlock("marble_brick_wall",
                        new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.5f)
                                        .requiresTool()));

        private static Block registerBlock(String name, Block block) {
                registerBlockItem(name, block);
                return Registry.register(Registry.BLOCK, new Identifier(VanillaPlusAutomation.MOD_ID, name), block);
        }

        private static Item registerBlockItem(String name, Block block) {
                return Registry.register(Registry.ITEM, new Identifier(VanillaPlusAutomation.MOD_ID, name),
                        new BlockItem(block,
                                new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));
        }

        public static void registerModBlocks() {
                System.out.println("Registering blocks items for " + VanillaPlusAutomation.MOD_ID);
        }
}

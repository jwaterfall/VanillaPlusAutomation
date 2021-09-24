package net.vanillaplusautomation.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.vanillaplusautomation.VanillaPlusAutomation;
import net.vanillaplusautomation.item.custom.CustomAxeItem;
import net.vanillaplusautomation.item.custom.CustomHoeItem;
import net.vanillaplusautomation.item.custom.CustomPickaxeItem;
import net.vanillaplusautomation.item.custom.DowsingRodItem;

public class ModItems {
        // Items
        public static final Item RUBY = registerItem("ruby",
                        new Item(new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item SAPPHIRE = registerItem("sapphire",
                        new Item(new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item PERIDOT = registerItem("peridot",
                        new Item(new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item RAW_ELECTROTINE = registerItem("raw_electrotine",
                        new Item(new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item ELECTROTINE_INGOT = registerItem("electrotine_ingot",
                        new Item(new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item ELECTROTINE_NUGGET = registerItem("electrotine_nugget",
                        new Item(new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        // Tools
        public static final Item DOWSING_ROD = registerItem("dowsing_rod", new DowsingRodItem(
                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION).maxDamage(10)));

        public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe",
                        new CustomPickaxeItem(ModToolMaterials.RUBY, 1, -2.8F,
                                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item RUBY_AXE = registerItem("ruby_axe", new CustomAxeItem(ModToolMaterials.RUBY, 6.0F,
                        -3.0F, new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item RUBY_SHOVEL = registerItem("ruby_shovel", new ShovelItem(ModToolMaterials.RUBY, 1.5F,
                        -3.0F, new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item RUBY_SWORD = registerItem("ruby_sword", new SwordItem(ModToolMaterials.RUBY, 3, -2.4F,
                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item RUBY_HOE = registerItem("ruby_hoe", new CustomHoeItem(ModToolMaterials.RUBY, -2, 0.0F,
                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item SAPPHIRE_PICKAXE = registerItem("sapphire_pickaxe",
                        new CustomPickaxeItem(ModToolMaterials.SAPPHIRE, 1, -2.8F,
                                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item SAPPHIRE_AXE = registerItem("sapphire_axe",
                        new CustomAxeItem(ModToolMaterials.SAPPHIRE, 6.0F, -3.0F,
                                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item SAPPHIRE_SHOVEL = registerItem("sapphire_shovel",
                        new ShovelItem(ModToolMaterials.SAPPHIRE, 1.5F, -3.0F,
                                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item SAPPHIRE_SWORD = registerItem("sapphire_sword",
                        new SwordItem(ModToolMaterials.SAPPHIRE, 3, -2.4F,
                                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item SAPPHIRE_HOE = registerItem("sapphire_hoe",
                        new CustomHoeItem(ModToolMaterials.SAPPHIRE, -2, 0.0F,
                                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item PERIDOT_PICKAXE = registerItem("peridot_pickaxe",
                        new CustomPickaxeItem(ModToolMaterials.PERIDOT, 1, -2.8F,
                                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item PERIDOT_AXE = registerItem("peridot_axe", new CustomAxeItem(ModToolMaterials.PERIDOT,
                        6.0F, -3.0F, new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item PERIDOT_SHOVEL = registerItem("peridot_shovel",
                        new ShovelItem(ModToolMaterials.PERIDOT, 1.5F, -3.0F,
                                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item PERIDOT_SWORD = registerItem("peridot_sword", new SwordItem(ModToolMaterials.PERIDOT,
                        3, -2.4F, new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item PERIDOT_HOE = registerItem("peridot_hoe", new CustomHoeItem(ModToolMaterials.PERIDOT,
                        -2, 0.0F, new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        // Armor
        public static final Item RUBY_HELMET = registerItem("ruby_helmet", new ArmorItem(ModArmorMaterials.RUBY,
                        EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate", new ArmorItem(ModArmorMaterials.RUBY,
                        EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings", new ArmorItem(ModArmorMaterials.RUBY,
                        EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item RUBY_BOOTS = registerItem("ruby_boots", new ArmorItem(ModArmorMaterials.RUBY,
                        EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item SAPPHIRE_HELMET = registerItem("sapphire_helmet",
                        new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlot.HEAD,
                                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item SAPPHIRE_CHESTPLATE = registerItem("sapphire_chestplate",
                        new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlot.CHEST,
                                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item SAPPHIRE_LEGGINGS = registerItem("sapphire_leggings",
                        new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlot.LEGS,
                                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item SAPPHIRE_BOOTS = registerItem("sapphire_boots",
                        new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlot.FEET,
                                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item PERIDOT_HELMET = registerItem("peridot_helmet",
                        new ArmorItem(ModArmorMaterials.PERIDOT, EquipmentSlot.HEAD,
                                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item PERIDOT_CHESTPLATE = registerItem("peridot_chestplate",
                        new ArmorItem(ModArmorMaterials.PERIDOT, EquipmentSlot.CHEST,
                                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item PERIDOT_LEGGINGS = registerItem("peridot_leggings",
                        new ArmorItem(ModArmorMaterials.PERIDOT, EquipmentSlot.LEGS,
                                        new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        public static final Item PERIDOT_BOOTS = registerItem("peridot_boots", new ArmorItem(ModArmorMaterials.PERIDOT,
                        EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.VANILLA_PLUS_AUTOMATION)));

        private static Item registerItem(String name, Item item) {
                return Registry.register(Registry.ITEM, new Identifier(VanillaPlusAutomation.MOD_ID, name), item);
        }

        public static void registerModItems() {
                System.out.println("Registering mod items for " + VanillaPlusAutomation.MOD_ID);
        }
}

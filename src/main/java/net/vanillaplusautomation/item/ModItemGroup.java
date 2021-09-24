package net.vanillaplusautomation.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.vanillaplusautomation.VanillaPlusAutomation;

public class ModItemGroup {
    public static final ItemGroup VANILLA_PLUS_AUTOMATION = FabricItemGroupBuilder.build(
            new Identifier(VanillaPlusAutomation.MOD_ID, "vanilla_plus_automation"),
            () -> new ItemStack(ModItems.RUBY));
}

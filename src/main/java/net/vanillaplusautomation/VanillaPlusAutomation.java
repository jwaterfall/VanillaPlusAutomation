package net.vanillaplusautomation;

import net.fabricmc.api.ModInitializer;
import net.vanillaplusautomation.block.ModBlocks;
import net.vanillaplusautomation.item.ModItems;
import net.vanillaplusautomation.ore.ModOres;

public class VanillaPlusAutomation implements ModInitializer {
	public static final String MOD_ID = "vanillaplusautomation";

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModOres.registerModOres();
	}
}

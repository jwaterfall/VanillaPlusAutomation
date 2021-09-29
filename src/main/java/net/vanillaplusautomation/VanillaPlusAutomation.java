package net.vanillaplusautomation;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.vanillaplusautomation.block.ModBlocks;
import net.vanillaplusautomation.item.ModItems;
import net.vanillaplusautomation.machines.Machine;
import net.vanillaplusautomation.ore.ModOres;

public class VanillaPlusAutomation implements ModInitializer, ClientModInitializer {
	public static final String MOD_ID = "vanillaplusautomation";

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModOres.registerModOres();

		for (final Machine machine : Machine.values()) {
			machine.register();
		}
	}

	@Override
	public void onInitializeClient() {
	}
}

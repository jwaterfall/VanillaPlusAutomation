package net.vanillaplusautomation;

import net.fabricmc.api.ModInitializer;
import net.vanillaplusautomation.block.ModBlocks;
import net.vanillaplusautomation.item.ModItems;
import net.vanillaplusautomation.machines.Machine;
import net.vanillaplusautomation.ore.ModOres;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VanillaPlusAutomation implements ModInitializer {
	public static final String MOD_ID = "vanillaplusautomation";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModOres.registerModOres();

		for (final Machine machine : Machine.values()) {
			machine.register();
		}
	}
}

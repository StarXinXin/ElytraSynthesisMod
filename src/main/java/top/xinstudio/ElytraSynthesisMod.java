package top.xinstudio;

import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.xinstudio.registry.ModItemGroup;
import top.xinstudio.registry.ModItems;

public class ElytraSynthesisMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "elytra-synthesis-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger("elytra-synthesis-mod");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

//		ModItems.registerModItems();
//		ModItemGroup.registerModItemGroup();
//		ElytraSynthesisClient.registerModelPredicates();

		LOGGER.info("Hello Fabric world!");
	}
}
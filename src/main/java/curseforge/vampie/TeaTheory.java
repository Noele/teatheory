package curseforge.vampie;

import curseforge.vampie.block.ModBlocks;
import curseforge.vampie.block.entity.ModBlockEntities;
import curseforge.vampie.item.ModItemGroups;
import curseforge.vampie.item.ModItems;
import curseforge.vampie.recipe.ModRecipes;
import curseforge.vampie.world.WorldGen;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TeaTheory implements ModInitializer {
	public static final String MOD_ID = "teatheory";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private ModItems modItems;
	private ModBlocks modBlocks;
	private ModItemGroups modItemGroups;
	private WorldGen worldGen;

	@Override
	public void onInitialize() {
		LOGGER.debug("Registering Mod Items for " + MOD_ID);
		modItems = new ModItems();

		LOGGER.debug("Registering Mod Recipes for " + MOD_ID);
		ModRecipes.register();

		LOGGER.debug("Registering Mod Blocks for " + MOD_ID);
		modBlocks = new ModBlocks();

		LOGGER.debug("Registering Mod Block Entities for " + MOD_ID);
		ModBlockEntities.register(modBlocks.BOILER_BLOCK);

		LOGGER.debug("Registering Mod Groups for " + MOD_ID);
		modItemGroups = new ModItemGroups(modItems, modBlocks);

		LOGGER.debug("Running world generation for " + MOD_ID);
		worldGen = new WorldGen();

	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}

package curseforge.vampie;

import curseforge.vampie.item.ModItemGroups;
import curseforge.vampie.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TeaTheory implements ModInitializer {
	public static final String MOD_ID = "teatheory";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private ModItems modItems;
	private ModItemGroups modItemGroups;

	@Override
	public void onInitialize() {
		LOGGER.debug("Registering Mod Items for " + MOD_ID);
		modItems = new ModItems();

		LOGGER.debug("Registering Mod Groups for " + MOD_ID);
		modItemGroups = new ModItemGroups(modItems);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}

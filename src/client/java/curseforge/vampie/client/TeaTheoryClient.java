package curseforge.vampie.client;

import net.fabricmc.api.ClientModInitializer;

public class TeaTheoryClient implements ClientModInitializer {
	/** Registers client-only tooltip behavior. */
	@Override
	public void onInitializeClient() {
		TeaTooltips.register();
	}
}
package curseforge.vampie.client;

import net.fabricmc.api.ClientModInitializer;

public class TeaTheoryClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		TeaTooltips.register();
	}
}
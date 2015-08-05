package crazyores.packs.core.event;

import net.minecraftforge.common.MinecraftForge;

public class CoreEventManager {
	
	public static void registerEvents() {
		MinecraftForge.EVENT_BUS.register(new CoreActionsEvent());
		MinecraftForge.EVENT_BUS.register(new CoreChatEvent());
		MinecraftForge.EVENT_BUS.register(new TapaziteObeliskEvent());
	}
}

package crazyores.packs.core.event;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;

public class CoreEventManager {
	
	public static void registerEvents() {
		MinecraftForge.EVENT_BUS.register(new CoreActionsEvent());
		MinecraftForge.EVENT_BUS.register(new CoreChatEvent());
		MinecraftForge.EVENT_BUS.register(new TapaziteObeliskEvent());
		FMLCommonHandler.instance().bus().register(new FreezeEvent());
		MinecraftForge.EVENT_BUS.register(new FreezeEvent());
		MinecraftForge.EVENT_BUS.register(new CoreBucketEvent());
	}
}

package crazyores.manager.start;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.manager.config.COConfigManager;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.proxy.IProxy;
import crazyores.manager.world.generate.Generate;

public class CrazyOresInit {
	
	public static void preInit(FMLPreInitializationEvent preInitEvent) {
		COConfigManager.init(preInitEvent);
		COPackManager.loadPackData();
	}
	
	public static void init(FMLInitializationEvent initEvent, IProxy proxy) {
		proxy.registerTileEntites();
		proxy.renderEntities();
		GameRegistry.registerWorldGenerator(new Generate(), 1);
	}
	
	public static void postInit(FMLPostInitializationEvent postInitEvent) {
	}
}

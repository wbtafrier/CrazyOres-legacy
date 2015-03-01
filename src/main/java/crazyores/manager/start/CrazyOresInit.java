package crazyores.manager.start;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import crazyores.manager.config.COConfigManager;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.proxy.ClientProxy;

public class CrazyOresInit {
	
	public static void preInit(FMLPreInitializationEvent preInitEvent) {
		COConfigManager.init(preInitEvent);
		COPackManager.loadPackData();
	}
	
	public static void init(FMLInitializationEvent initEvent, ClientProxy clientProxy) {
		clientProxy.registerTileEntites();
		clientProxy.renderEntities();
	}
	
	public static void postInit(FMLPostInitializationEvent postInitEvent) {
	}
}

package crazyores.manager.start;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import crazyores.manager.config.COConfigManager;
import crazyores.manager.tabs.COTabRegistry;
import crazyores.manager.util.COPackManager;

public class CrazyOresInit {

	public static void preInit(FMLPreInitializationEvent preInitEvent) {
		COConfigManager.init(preInitEvent);
		COPackManager.loadPackData();
	}
	
	public static void init(FMLInitializationEvent initEvent) {}
	
	public static void postInit(FMLPostInitializationEvent postInitEvent) {
		COTabRegistry.initTabs();
	}
}

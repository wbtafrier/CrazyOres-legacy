package crazyores.packs.core.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import crazyores.manager.config.COConfigManager;
import crazyores.manager.proxy.IProxy;
import crazyores.manager.util.COPackManager;
import crazyores.manager.util.CrazyOresData;
import crazyores.manager.util.CrazyOresLogger;

@Mod(modid = CrazyOresData.crazyOresCoreID, name = CrazyOresData.crazyOresCoreName, version = CrazyOresData.crazyOresCoreVersion)
public class CrazyOresCore {

	@SidedProxy(clientSide = CrazyOresData.clientProxy, serverSide = CrazyOresData.serverProxy)
	public static IProxy proxy;
	
	@Instance(CrazyOresData.crazyOresCoreID)
	public static CrazyOresCore instance;
	
	@EventHandler
	private void preInit(FMLPreInitializationEvent preInitEvent) {
		COConfigManager.init(preInitEvent);
		COPackManager.loadPackData();
	}
	
	@EventHandler
	private void init(FMLInitializationEvent initEvent) {}
	
	@EventHandler
	private void postInit(FMLPostInitializationEvent postInitEvent) {
		CrazyOresLogger.outputLoadedPacks();
	}
}

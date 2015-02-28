package crazyores.packs.foods.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import crazyores.manager.pack.data.CrazyOresData;
import crazyores.manager.proxy.IProxy;

@Mod(modid = CrazyOresData.foodsPackID, name = CrazyOresData.foodsPackName, version = CrazyOresData.foodsPackVersion)
public class CrazyOresFoods {

	@SidedProxy(clientSide = CrazyOresData.clientProxy, serverSide = CrazyOresData.serverProxy)
	public static IProxy proxy;
	
	@Instance(CrazyOresData.foodsPackID)
	public static CrazyOresFoods instance;
	
	@EventHandler
	private void preInit(FMLPreInitializationEvent preInitEvent) {
		
	}
	
	@EventHandler
	private void init(FMLInitializationEvent initEvent) {
		
	}
	
	@EventHandler
	private void postInit(FMLPostInitializationEvent postInitEvent) {
		
	}
}

//package crazyores.packs.foods.main;
//
//import cpw.mods.fml.common.Mod;
//import cpw.mods.fml.common.Mod.EventHandler;
//import cpw.mods.fml.common.Mod.Instance;
//import cpw.mods.fml.common.SidedProxy;
//import cpw.mods.fml.common.event.FMLInitializationEvent;
//import cpw.mods.fml.common.event.FMLPostInitializationEvent;
//import cpw.mods.fml.common.event.FMLPreInitializationEvent;
//import crazyores.manager.pack.data.CrazyOresData;
//import crazyores.manager.proxy.IProxy;
//import crazyores.packs.core.main.CrazyOresCore;
//
//@Mod(modid = CrazyOresData.foodsPackID, name = CrazyOresData.foodsModsListName, version = CrazyOresData.foodsPackVersion, dependencies = "required-after:crazyores_core@[2.0,)", acceptedMinecraftVersions = "[1.7.10]")
//public class CrazyOresFoods {
//
//	@SidedProxy(clientSide = CrazyOresData.clientProxy, serverSide = CrazyOresData.serverProxy)
//	public static IProxy proxy;
//	
//	@Instance(CrazyOresData.foodsPackID)
//	public static CrazyOresFoods instance;
//	
//	@EventHandler
//	private void preInit(FMLPreInitializationEvent preInitEvent) {
//		
//	}
//	
//	@EventHandler
//	private void init(FMLInitializationEvent initEvent) {
//		
//	}
//	
//	@EventHandler
//	private void postInit(FMLPostInitializationEvent postInitEvent) {
//		
//	}
//}

package crazyores.packs.core.main;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import crazyores.manager.pack.data.CrazyOresData;
import crazyores.manager.proxy.ClientProxy;
import crazyores.manager.start.CrazyOresInit;
import crazyores.manager.util.CrazyOresLogger;
import crazyores.packs.core.item.CoreItems;

@Mod(modid = CrazyOresData.corePackID, name = CrazyOresData.coreModsListName, version = CrazyOresData.corePackVersion, acceptedMinecraftVersions = "[1.7.10]")
public class CrazyOresCore {

	@SidedProxy(clientSide = CrazyOresData.clientProxy, serverSide = CrazyOresData.serverProxy)
	public static ClientProxy proxy;
	
	@Instance(CrazyOresData.corePackID)
	public static CrazyOresCore instance;
	
	@EventHandler
	private void preInit(FMLPreInitializationEvent preInitEvent) {
		CrazyOresInit.preInit(preInitEvent);
	}
	
	@EventHandler
	private void init(FMLInitializationEvent initEvent) {
		CrazyOresInit.init(initEvent, proxy);
	}
	
	@EventHandler
	private void postInit(FMLPostInitializationEvent postInitEvent) {
		CrazyOresInit.postInit(postInitEvent);
		CrazyOresLogger.outputLoadedPacks();
	}
}

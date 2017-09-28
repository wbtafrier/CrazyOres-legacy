package crazyores.manager.start;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import crazyores.manager.config.COConfigManager;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.proxy.IProxy;
import crazyores.manager.world.generate.Generate;
import crazyores.packs.core.entity.CoreEntityRegistry;
import crazyores.packs.core.entity.EntityZectiumCore;
import crazyores.packs.core.entity.tileentity.TileEntityTapaziteCrystal;
import crazyores.packs.core.main.CrazyOresCore;
import crazyores.packs.core.util.CoreHarvestLevels;

public class CrazyOresInit {
	
	public static void preInit(FMLPreInitializationEvent preInitEvent, IProxy proxy) {
		COConfigManager.init(preInitEvent);
		COPackManager.preInit();
		proxy.registerProxyEvents();
	}
	
	public static void init(FMLInitializationEvent initEvent, IProxy proxy) {
		proxy.renderEntities();
		COPackManager.init();
	}
	
	public static void postInit(FMLPostInitializationEvent postInitEvent) {
		COPackManager.postInit();
	}
}

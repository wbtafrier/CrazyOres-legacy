package crazyores.manager.proxy;

import java.io.File;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.Loader;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.util.CrazyOresLogger;
import crazyores.packs.core.entity.CoreEntityRegistry;
import crazyores.packs.core.render.CoreRenderRegistry;

public class ClientProxy implements IProxy {

	@Override
	public void renderEntities() {
		if (Loader.isModLoaded(COPackManager.corePack.getPackID())) {
			CoreRenderRegistry.renderCoreEntities();
		}
	}
	
	@Override
	public void registerTileEntites() {
		if (Loader.isModLoaded(COPackManager.corePack.getPackID())) {
			CoreEntityRegistry.registryCoreEntities();
			CoreEntityRegistry.initEntities();
		}
	}

	@Override
	public File getMinecraftDir() {
		return null;
	}
}

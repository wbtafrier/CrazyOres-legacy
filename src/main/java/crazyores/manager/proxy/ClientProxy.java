package crazyores.manager.proxy;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.Loader;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.util.CrazyOresLogger;
import crazyores.packs.core.entity.CoreEntityRegistry;
import crazyores.packs.core.event.CoreClientEvent;
import crazyores.packs.core.render.CoreRenderRegistry;

public class ClientProxy implements IProxy {

	@Override
	public void renderEntities() {
		if (Loader.isModLoaded(COPackManager.corePack.getPackID())) {
			CoreRenderRegistry.renderCoreEntities();
			CoreRenderRegistry.renderCoreTileEntities();
		}
	}
	
	@Override
	public File getMinecraftDir() {
		return null;
	}

	@Override
	public void registerProxyEvents() {
		if (Loader.isModLoaded(COPackManager.corePack.getPackID())) {
			MinecraftForge.EVENT_BUS.register(new CoreClientEvent());
		}
	}
}

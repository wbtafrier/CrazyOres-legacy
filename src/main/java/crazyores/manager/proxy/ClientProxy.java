package crazyores.manager.proxy;

import java.io.File;

import net.minecraft.client.renderer.tileentity.TileEntityRendererChestHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Loader;
import crazyores.manager.pack.COPackManager;
import crazyores.packs.core.event.CoreBowEvent;
import crazyores.packs.core.render.CoreRenderRegistry;
import crazyores.packs.core.render.ReinforcedChestItemRenderer;

public class ClientProxy implements IProxy {

	@Override
	public void renderEntities() {
		if (Loader.isModLoaded(COPackManager.corePack.getPackID())) {
			CoreRenderRegistry.renderCoreEntities();
			CoreRenderRegistry.renderCoreTileEntities();
			TileEntityRendererChestHelper.instance = new ReinforcedChestItemRenderer();
		}
	}
	
	@Override
	public File getMinecraftDir() {
		return null;
	}

	@Override
	public void registerProxyEvents() {
		if (Loader.isModLoaded(COPackManager.corePack.getPackID())) {
			MinecraftForge.EVENT_BUS.register(new CoreBowEvent());
		}
	}
}

package crazyores.packs.core.entity;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.client.registry.ClientRegistry;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.util.CrazyOresLogger;
import crazyores.packs.core.render.TileEntityTapaziteCrystalRenderer;

public class CoreEntityRegistry {

	public static void registryCoreEntities() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTapaziteCrystal.class, new TileEntityTapaziteCrystalRenderer());
	}
}

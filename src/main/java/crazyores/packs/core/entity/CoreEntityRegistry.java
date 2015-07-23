package crazyores.packs.core.entity;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.client.registry.ClientRegistry;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.util.CrazyOresLogger;
import crazyores.packs.core.entity.tileentity.TileEntityTapaziteCrystal;
import crazyores.packs.core.render.RenderTapaziteCrystal;

public class CoreEntityRegistry {

	public static void registryCoreEntities() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTapaziteCrystal.class, new RenderTapaziteCrystal());
	}
}

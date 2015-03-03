package crazyores.packs.core.render;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.util.CrazyOresLogger;
import crazyores.packs.core.entity.tileentity.TileEntityTapaziteCrystal;

public class CoreRenderRegistry {

	public static void renderCoreEntities() {
		GameRegistry.registerTileEntity(TileEntityTapaziteCrystal.class, "tileEntityTapaziteCrystal");
	}
}

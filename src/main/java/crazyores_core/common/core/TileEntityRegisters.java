package crazyores_core.common.core;

import cpw.mods.fml.common.registry.GameRegistry;
import crazyores_core.common.tileentity.TileEntityDemoniteFurnace;

public class TileEntityRegisters
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityDemoniteFurnace.class, "DemoniteFurnace");
	}
}

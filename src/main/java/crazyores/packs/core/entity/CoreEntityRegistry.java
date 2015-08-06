package crazyores.packs.core.entity;

import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.packs.core.entity.tileentity.TileEntityTapaziteCrystal;
import crazyores.packs.core.main.CrazyOresCore;
import crazyores.packs.core.render.RenderTapaziteCrystal;

public class CoreEntityRegistry {

	public static void registryCoreEntities() {
		EntityRegistry.registerModEntity(EntityZectiumCore.class, "zectium_core", EntityRegistry.findGlobalUniqueEntityId(), CrazyOresCore.instance, 64, 10, true);
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTapaziteCrystal.class, new RenderTapaziteCrystal());
	}
}

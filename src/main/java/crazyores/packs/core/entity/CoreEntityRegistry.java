package crazyores.packs.core.entity;

import net.minecraft.entity.projectile.EntitySnowball;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import crazyores.packs.core.entity.tileentity.TileEntityTapaziteCrystal;
import crazyores.packs.core.main.CrazyOresCore;
import crazyores.packs.core.render.RenderTapaziteCrystal;

public class CoreEntityRegistry {

	public static void registryCoreEntities() {
		EntityRegistry.registerModEntity(EntityZectiumCore.class, "zectium_core", EntityRegistry.findGlobalUniqueEntityId(), 
				CrazyOresCore.instance, 64, 10, true);
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTapaziteCrystal.class, new RenderTapaziteCrystal());
	}
}

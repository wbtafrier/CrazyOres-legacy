package crazyores.packs.core.entity;

import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.packs.core.entity.tileentity.TileEntityTapaziteCrystal;
import crazyores.packs.core.main.CrazyOresCore;
import crazyores.packs.core.render.RenderTapaziteCrystal;

public class CoreEntityRegistry {

	public static void registryCoreEntities() {
		EntityRegistry.registerModEntity(EntityZectiumCore.class, "zectium_core", EntityRegistry.findGlobalUniqueEntityId(), CrazyOresCore.instance, 64, 10, true);
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTapaziteCrystal.class, new RenderTapaziteCrystal());
	}
	
	public static void initEntities() {
		TileEntity.addMapping(TileEntityTapaziteCrystal.class, "TapaziteCrystal");
	}
}

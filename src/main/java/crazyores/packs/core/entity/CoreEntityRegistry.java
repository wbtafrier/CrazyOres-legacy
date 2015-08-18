package crazyores.packs.core.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.packs.core.entity.golem.EntityAdamiteGolem;
import crazyores.packs.core.entity.golem.EntityCopperGolem;
import crazyores.packs.core.entity.golem.EntityDemoniteGolem;
import crazyores.packs.core.entity.golem.EntityEnderGolem;
import crazyores.packs.core.entity.golem.EntityFoolsRubyGolem;
import crazyores.packs.core.entity.golem.EntityOsmoniumGolem;
import crazyores.packs.core.entity.golem.EntityRubyGolem;
import crazyores.packs.core.entity.golem.EntitySapphireGolem;
import crazyores.packs.core.entity.golem.EntityStarconiumGolem;
import crazyores.packs.core.entity.golem.EntityTapaziteGolem;
import crazyores.packs.core.entity.golem.EntityZectiumGolem;
import crazyores.packs.core.entity.tileentity.TileEntityDemoniteFurnace;
import crazyores.packs.core.entity.tileentity.TileEntityTapaziteCrystal;
import crazyores.packs.core.main.CrazyOresCore;

public class CoreEntityRegistry {

	//Only use getUniqueGlobalID when creating a mob with spawn eggs. Otherwise the ids are specific to each mod.
	private static int coreIDCounter = 0;
	
	public static void registerCoreEntities() {
		EntityRegistry.registerModEntity(EntityZectiumCore.class, "Zectium Core", coreIDCounter++, CrazyOresCore.instance, 64, 20, true);
		EntityRegistry.registerModEntity(EntityCopperGolem.class, "Copper Golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntitySapphireGolem.class, "Sapphire Golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityAdamiteGolem.class, "Adamite Golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityRubyGolem.class, "Ruby Golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityFoolsRubyGolem.class, "Fool's Ruby Golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityZectiumGolem.class, "Zectium Golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityTapaziteGolem.class, "Tapazite Golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityOsmoniumGolem.class, "Osmonium Golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityStarconiumGolem.class, "Starconium Golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityDemoniteGolem.class, "Demonite Golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityEnderGolem.class, "Ender Golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		
		EntityRegistry.registerModEntity(EntityFlamingArrow.class, "Flaming Arrow", coreIDCounter++, CrazyOresCore.instance, 128, 1, true);
	}
	
	public static void registerCoreTileEntities() {
		GameRegistry.registerTileEntity(TileEntityTapaziteCrystal.class, "Tapazite Crystal");
		GameRegistry.registerTileEntity(TileEntityDemoniteFurnace.class, "Demonite Furnace");
	}
}

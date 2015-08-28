package crazyores.packs.core.entity;

import java.util.Arrays;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.packs.core.entity.arrow.EntityExplosiveArrow;
import crazyores.packs.core.entity.arrow.EntityFlamingArrow;
import crazyores.packs.core.entity.arrow.EntityFreezingArrow;
import crazyores.packs.core.entity.arrow.EntityLightningArrow;
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
import crazyores.packs.core.entity.mob.EntityAdamiteShark;
import crazyores.packs.core.entity.mob.EntityGreatWhiteShark;
import crazyores.packs.core.entity.mob.EntityZectiumProtector;
import crazyores.packs.core.entity.tileentity.TileEntityDemoniteFurnace;
import crazyores.packs.core.entity.tileentity.TileEntityTapaziteCrystal;
import crazyores.packs.core.main.CrazyOresCore;

public class CoreEntityRegistry {

	//Only use getUniqueGlobalID when creating a mob with spawn eggs. Otherwise the ids are specific to each mod.
	private static int coreIDCounter = 0;
	
	//Put names in the lang file! They read as: entity.crazyores_core.theentityname.name
	
	public static void registerCoreEntities() {
		EntityRegistry.registerModEntity(EntityZectiumCore.class, "zectium_core", coreIDCounter++, CrazyOresCore.instance, 64, 10, true);
		EntityRegistry.registerModEntity(EntityCopperGolem.class, "copper_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntitySapphireGolem.class, "sapphire_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityAdamiteGolem.class, "adamite_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityRubyGolem.class, "ruby_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityFoolsRubyGolem.class, "fools_ruby_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityZectiumGolem.class, "zectium_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityTapaziteGolem.class, "tapazite_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityOsmoniumGolem.class, "osmonium_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityStarconiumGolem.class, "starconium_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityDemoniteGolem.class, "demonite_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityEnderGolem.class, "ender_golem", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		
		EntityRegistry.registerModEntity(EntityFlamingArrow.class, "flaming_arrow", coreIDCounter++, CrazyOresCore.instance, 128, 1, true);
		EntityRegistry.registerModEntity(EntityExplosiveArrow.class, "explosive_arrow", coreIDCounter++, CrazyOresCore.instance, 128, 1, true);
		EntityRegistry.registerModEntity(EntityLightningArrow.class, "electric_arrow", coreIDCounter++, CrazyOresCore.instance, 128, 1, true);
		EntityRegistry.registerModEntity(EntityFreezingArrow.class, "freezing_arrow", coreIDCounter++, CrazyOresCore.instance, 128, 1, true);
		
		EntityRegistry.registerModEntity(EntityZectiumProtector.class, "zectium_protector", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		
		EntityRegistry.registerModEntity(EntityGreatWhiteShark.class, "great_white_shark", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityAdamiteShark.class, "adamite_shark", coreIDCounter++, CrazyOresCore.instance, 64, 3, true);
		
//		System.out.println("ADDING SPAWN");
		BiomeGenBase[] allBiomes = FluentIterable.from(Arrays.asList(BiomeGenBase.getBiomeGenArray())).filter(Predicates.notNull()).toArray(BiomeGenBase.class);
		EntityRegistry.addSpawn(EntityGreatWhiteShark.class, 1, 1, 1, EnumCreatureType.waterCreature, allBiomes);
	}
	
	public static void registerCoreTileEntities() {
		GameRegistry.registerTileEntity(TileEntityTapaziteCrystal.class, "tapazite_crystal");
		GameRegistry.registerTileEntity(TileEntityDemoniteFurnace.class, "demonite_furnace");
	}
}

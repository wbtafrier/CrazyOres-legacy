package crazyores_core.common.core;

import cpw.mods.fml.common.registry.EntityRegistry;
import crazyores_core.common.entity.EntityAdamiteArrow;
import crazyores_core.common.entity.EntityAdamiteGolem;
import crazyores_core.common.entity.EntityCopperArrow;
import crazyores_core.common.entity.EntityCopperGolem;
import crazyores_core.common.entity.EntityCrystalArrow;
import crazyores_core.common.entity.EntityCrystalGolem;
import crazyores_core.common.entity.EntityDemoniteGolem;
import crazyores_core.common.entity.EntityEnderArrow;
import crazyores_core.common.entity.EntityFoolsRubyGolem;
import crazyores_core.common.entity.EntityInvisiumArrow;
import crazyores_core.common.entity.EntityMeteoriteArrow;
import crazyores_core.common.entity.EntityNames;
import crazyores_core.common.entity.EntityOsmoniumArrow;
import crazyores_core.common.entity.EntityOsmoniumGolem;
import crazyores_core.common.entity.EntityRubyArrow;
import crazyores_core.common.entity.EntityRubyGolem;
import crazyores_core.common.entity.EntitySapphireArrow;
import crazyores_core.common.entity.EntitySapphireGolem;
import crazyores_core.common.entity.EntityStarconiumArrow;
import crazyores_core.common.entity.EntityStarconiumGolem;
import crazyores_core.common.entity.EntityTapaziteArrow;
import crazyores_core.common.entity.EntityTapaziteGolem;
import crazyores_core.common.entity.EntityZectiumArrow;
import crazyores_core.common.entity.EntityZectiumGolem;

public class EntityRegisters 
{
    public static void registerEntities(EntityNames en)
    {
    	EntityRegistry.registerGlobalEntityID(EntityCopperGolem.class, en.COPPER_GOLEM, EntityRegistry.findGlobalUniqueEntityId());
    	EntityRegistry.registerGlobalEntityID(EntitySapphireGolem.class, en.SAPPHIRE_GOLEM, EntityRegistry.findGlobalUniqueEntityId());
    	EntityRegistry.registerGlobalEntityID(EntityAdamiteGolem.class, en.ADAMITE_GOLEM, EntityRegistry.findGlobalUniqueEntityId());
    	EntityRegistry.registerGlobalEntityID(EntityRubyGolem.class, en.RUBY_GOLEM, EntityRegistry.findGlobalUniqueEntityId());
    	EntityRegistry.registerGlobalEntityID(EntityZectiumGolem.class, en.ZECTIUM_GOLEM, EntityRegistry.findGlobalUniqueEntityId());
    	EntityRegistry.registerGlobalEntityID(EntityTapaziteGolem.class, en.TAPAZITE_GOLEM, EntityRegistry.findGlobalUniqueEntityId());
    	EntityRegistry.registerGlobalEntityID(EntityFoolsRubyGolem.class, en.FOOLS_RUBY_GOLEM, EntityRegistry.findGlobalUniqueEntityId());
    	EntityRegistry.registerGlobalEntityID(EntityCrystalGolem.class, en.CRYSTAL_GOLEM, EntityRegistry.findGlobalUniqueEntityId());
    	EntityRegistry.registerGlobalEntityID(EntityOsmoniumGolem.class, en.OSMONIUM_GOLEM, EntityRegistry.findGlobalUniqueEntityId());
    	EntityRegistry.registerGlobalEntityID(EntityDemoniteGolem.class, en.DEMONITE_GOLEM, EntityRegistry.findGlobalUniqueEntityId());
    	EntityRegistry.registerGlobalEntityID(EntityStarconiumGolem.class, en.STARCONIUM_GOLEM, EntityRegistry.findGlobalUniqueEntityId());

//    	EntityRegistry.registerModEntity(EntityZectiumNukePrimed.class, en.ZECTIUM_NUKE, EntityRegistry.findGlobalUniqueEntityId(), this, 160, 10, true);
//    	EntityRegistry.registerModEntity(EntityIronNukePrimed.class, en.IRON_NUKE, EntityRegistry.findGlobalUniqueEntityId(), this, 160, 10, true);
//    	EntityRegistry.registerModEntity(EntityGoldNukePrimed.class, en.GOLD_NUKE, EntityRegistry.findGlobalUniqueEntityId(), this, 160, 10, true);
//    	EntityRegistry.registerModEntity(EntityDiamondNukePrimed.class, en.DIAMOND_NUKE, EntityRegistry.findGlobalUniqueEntityId(), this, 160, 10, true);
//    	EntityRegistry.registerModEntity(EntityCopperNukePrimed.class, en.COPPER_NUKE, EntityRegistry.findGlobalUniqueEntityId(), this, 160, 10, true);
//    	EntityRegistry.registerModEntity(EntitySapphireNukePrimed.class, en.SAPPHIRE_NUKE, EntityRegistry.findGlobalUniqueEntityId(), this, 160, 10, true);
//    	EntityRegistry.registerModEntity(EntityMeteoriteNukePrimed.class, en.METEORITE_NUKE, EntityRegistry.findGlobalUniqueEntityId(), this, 160, 10, true);
//    	EntityRegistry.registerModEntity(EntityRubyNukePrimed.class, en.RUBY_NUKE, EntityRegistry.findGlobalUniqueEntityId(), this, 160, 10, true);
//    	EntityRegistry.registerModEntity(EntityCrystalNukePrimed.class, en.CRYSTAL_NUKE, EntityRegistry.findGlobalUniqueEntityId(), this, 160, 10, true);
//    	EntityRegistry.registerModEntity(EntityStarconiumNukePrimed.class, en.STARCONIUM_NUKE, EntityRegistry.findGlobalUniqueEntityId(), this, 160, 10, true);
//    	if(this.ultraUnlock)
//    	EntityRegistry.registerModEntity(EntityUltraNukePrimed.class, en.ULTRA_NUKE, EntityRegistry.findGlobalUniqueEntityId(), this, 160, 10, true);
    	
    	EntityRegistry.registerModEntity(EntityMeteoriteArrow.class, en.METEORITE_ARROW, EntityRegistry.findGlobalUniqueEntityId(), CrazyOres.instance, 128, 1, true);
    	EntityRegistry.registerModEntity(EntityCopperArrow.class, en.COPPER_ARROW, EntityRegistry.findGlobalUniqueEntityId(), CrazyOres.instance, 128, 1, true);
    	EntityRegistry.registerModEntity(EntityInvisiumArrow.class, en.INVISIUM_ARROW, EntityRegistry.findGlobalUniqueEntityId(), CrazyOres.instance, 128, 1, true);
    	EntityRegistry.registerModEntity(EntitySapphireArrow.class, en.SAPPHIRE_ARROW, EntityRegistry.findGlobalUniqueEntityId(), CrazyOres.instance, 128, 1, true);
    	EntityRegistry.registerModEntity(EntityAdamiteArrow.class, en.ADAMITE_ARROW, EntityRegistry.findGlobalUniqueEntityId(), CrazyOres.instance, 128, 1, true);
    	EntityRegistry.registerModEntity(EntityRubyArrow.class, en.RUBY_ARROW, EntityRegistry.findGlobalUniqueEntityId(), CrazyOres.instance, 128, 1, true);
    	EntityRegistry.registerModEntity(EntityZectiumArrow.class, en.ZECTIUM_ARROW, EntityRegistry.findGlobalUniqueEntityId(), CrazyOres.instance, 128, 1, true);
    	EntityRegistry.registerModEntity(EntityTapaziteArrow.class, en.TAPAZITE_ARROW, EntityRegistry.findGlobalUniqueEntityId(), CrazyOres.instance, 128, 1, true);
    	EntityRegistry.registerModEntity(EntityCrystalArrow.class, en.CRYSTAL_ARROW, EntityRegistry.findGlobalUniqueEntityId(), CrazyOres.instance, 128, 1, true);
    	EntityRegistry.registerModEntity(EntityOsmoniumArrow.class, en.OSMONIUM_ARROW, EntityRegistry.findGlobalUniqueEntityId(), CrazyOres.instance, 128, 1, true);
    	EntityRegistry.registerModEntity(EntityEnderArrow.class, en.ENDER_ARROW, EntityRegistry.findGlobalUniqueEntityId(), CrazyOres.instance, 128, 1, true);
    	EntityRegistry.registerModEntity(EntityStarconiumArrow.class, en.STARCONIUM_ARROW, EntityRegistry.findGlobalUniqueEntityId(), CrazyOres.instance, 128, 1, true);
//    	EntityRegistry.registerModEntity(EntityCrystalCore.class, en.CRYSTAL_CORE, EntityRegistry.findGlobalUniqueEntityId(), this, 64, 10, true);
//    	EntityRegistry.registerModEntity(EntityExperienceOrb.class, en.EXPERIENCE_ORB, EntityRegistry.findGlobalUniqueEntityId(), CrazyOres.instance, 64, 10, true);
    }
}

package crazyores_core.client.core;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores_core.client.model.ModelAdamiteGolem;
import crazyores_core.client.model.ModelCopperGolem;
import crazyores_core.client.model.ModelCrystalGolem;
import crazyores_core.client.model.ModelDemoniteGolem;
import crazyores_core.client.model.ModelFoolsRubyGolem;
import crazyores_core.client.model.ModelOsmoniumGolem;
import crazyores_core.client.model.ModelRubyGolem;
import crazyores_core.client.model.ModelSapphireGolem;
import crazyores_core.client.model.ModelStarconiumGolem;
import crazyores_core.client.model.ModelTapaziteGolem;
import crazyores_core.client.model.ModelZectiumGolem;
import crazyores_core.client.render.RenderAdamiteArrow;
import crazyores_core.client.render.RenderAdamiteGolem;
import crazyores_core.client.render.RenderCopperArrow;
import crazyores_core.client.render.RenderCopperGolem;
import crazyores_core.client.render.RenderCrystalArrow;
import crazyores_core.client.render.RenderCrystalGolem;
import crazyores_core.client.render.RenderDemoniteGolem;
import crazyores_core.client.render.RenderEnderArrow;
import crazyores_core.client.render.RenderFoolsRubyGolem;
import crazyores_core.client.render.RenderInvisiumArrow;
import crazyores_core.client.render.RenderMeteoriteArrow;
import crazyores_core.client.render.RenderOsmoniumArrow;
import crazyores_core.client.render.RenderOsmoniumGolem;
import crazyores_core.client.render.RenderRubyArrow;
import crazyores_core.client.render.RenderRubyGolem;
import crazyores_core.client.render.RenderSapphireArrow;
import crazyores_core.client.render.RenderSapphireGolem;
import crazyores_core.client.render.RenderStarconiumArrow;
import crazyores_core.client.render.RenderStarconiumGolem;
import crazyores_core.client.render.RenderTapaziteArrow;
import crazyores_core.client.render.RenderTapaziteGolem;
import crazyores_core.client.render.RenderZectiumArrow;
import crazyores_core.client.render.RenderZectiumGolem;
import crazyores_core.common.core.CommonProxy;
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

public class ClientProxy extends CommonProxy
{
//	private ClientPickupHandler pickup = new ClientPickupHandler();
	
	public void renderEntities()
	{
    	RenderingRegistry.registerEntityRenderingHandler(EntityFoolsRubyGolem.class, new RenderFoolsRubyGolem(new ModelFoolsRubyGolem(), "foolsruby"));
    	RenderingRegistry.registerEntityRenderingHandler(EntityCopperGolem.class, new RenderCopperGolem(new ModelCopperGolem(), "copper"));
    	RenderingRegistry.registerEntityRenderingHandler(EntitySapphireGolem.class, new RenderSapphireGolem(new ModelSapphireGolem(), "sapphire"));
    	RenderingRegistry.registerEntityRenderingHandler(EntityAdamiteGolem.class, new RenderAdamiteGolem(new ModelAdamiteGolem(), "adamite"));
    	RenderingRegistry.registerEntityRenderingHandler(EntityRubyGolem.class, new RenderRubyGolem(new ModelRubyGolem(), "ruby"));
    	RenderingRegistry.registerEntityRenderingHandler(EntityZectiumGolem.class, new RenderZectiumGolem(new ModelZectiumGolem(), "zectium"));
    	RenderingRegistry.registerEntityRenderingHandler(EntityTapaziteGolem.class, new RenderTapaziteGolem(new ModelTapaziteGolem(), "tapazite"));
    	RenderingRegistry.registerEntityRenderingHandler(EntityCrystalGolem.class, new RenderCrystalGolem(new ModelCrystalGolem(), "crystal"));
    	RenderingRegistry.registerEntityRenderingHandler(EntityOsmoniumGolem.class, new RenderOsmoniumGolem(new ModelOsmoniumGolem(), "osmonium"));
    	RenderingRegistry.registerEntityRenderingHandler(EntityDemoniteGolem.class, new RenderDemoniteGolem(new ModelDemoniteGolem(), "demonite"));
    	RenderingRegistry.registerEntityRenderingHandler(EntityStarconiumGolem.class, new RenderStarconiumGolem(new ModelStarconiumGolem(), "starconium"));
    	RenderingRegistry.registerEntityRenderingHandler(EntityMeteoriteArrow.class, new RenderMeteoriteArrow());
    	RenderingRegistry.registerEntityRenderingHandler(EntityCopperArrow.class, new RenderCopperArrow());
    	RenderingRegistry.registerEntityRenderingHandler(EntityInvisiumArrow.class, new RenderInvisiumArrow());
    	RenderingRegistry.registerEntityRenderingHandler(EntitySapphireArrow.class, new RenderSapphireArrow());
    	RenderingRegistry.registerEntityRenderingHandler(EntityAdamiteArrow.class, new RenderAdamiteArrow());
    	RenderingRegistry.registerEntityRenderingHandler(EntityRubyArrow.class, new RenderRubyArrow());
    	RenderingRegistry.registerEntityRenderingHandler(EntityZectiumArrow.class, new RenderZectiumArrow());
    	RenderingRegistry.registerEntityRenderingHandler(EntityTapaziteArrow.class, new RenderTapaziteArrow());
    	RenderingRegistry.registerEntityRenderingHandler(EntityCrystalArrow.class, new RenderCrystalArrow());
    	RenderingRegistry.registerEntityRenderingHandler(EntityOsmoniumArrow.class, new RenderOsmoniumArrow());
    	RenderingRegistry.registerEntityRenderingHandler(EntityEnderArrow.class, new RenderEnderArrow());
    	RenderingRegistry.registerEntityRenderingHandler(EntityStarconiumArrow.class, new RenderStarconiumArrow());
//    	RenderingRegistry.registerEntityRenderingHandler(EntityZectiumNukePrimed.class, new RenderZectiumNukePrimed());
//    	RenderingRegistry.registerEntityRenderingHandler(EntityIronNukePrimed.class, new RenderIronNukePrimed());
//    	RenderingRegistry.registerEntityRenderingHandler(EntityGoldNukePrimed.class, new RenderGoldNukePrimed());
//    	RenderingRegistry.registerEntityRenderingHandler(EntityDiamondNukePrimed.class, new RenderDiamondNukePrimed());
//    	RenderingRegistry.registerEntityRenderingHandler(EntityCopperNukePrimed.class, new RenderCopperNukePrimed());
//    	RenderingRegistry.registerEntityRenderingHandler(EntitySapphireNukePrimed.class, new RenderSapphireNukePrimed());
//    	RenderingRegistry.registerEntityRenderingHandler(EntityMeteoriteNukePrimed.class, new RenderMeteoriteNukePrimed());
//    	RenderingRegistry.registerEntityRenderingHandler(EntityRubyNukePrimed.class, new RenderRubyNukePrimed());
//    	RenderingRegistry.registerEntityRenderingHandler(EntityCrystalNukePrimed.class, new RenderCrystalNukePrimed());
//    	RenderingRegistry.registerEntityRenderingHandler(EntityStarconiumNukePrimed.class, new RenderStarconiumNukePrimed());
//    	RenderingRegistry.registerEntityRenderingHandler(EntityUltraNukePrimed.class, new RenderUltraNukePrimed());
//    	RenderingRegistry.registerEntityRenderingHandler(EntityCrystalCore.class, new RenderCrystalCore(mod_CrazyOres.CrystalCore));
//    	RenderingRegistry.registerEntityRenderingHandler(EntityExperienceOrb.class, new RenderExperienceOrb(ItemList.xpOrb));
	}
	
	public void clientRegs()
	{
//		GameRegistry.registerPickupHandler(pickup);
	}
}

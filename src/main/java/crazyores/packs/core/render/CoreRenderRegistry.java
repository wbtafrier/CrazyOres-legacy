package crazyores.packs.core.render;

import net.minecraft.client.renderer.entity.RenderSnowball;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import crazyores.packs.core.entity.EntityZectiumCore;
import crazyores.packs.core.entity.arrow.EntityElectricArrow;
import crazyores.packs.core.entity.arrow.EntityExplosiveArrow;
import crazyores.packs.core.entity.arrow.EntityFlamingArrow;
import crazyores.packs.core.entity.arrow.EntityFreezingArrow;
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
import crazyores.packs.core.entity.golem.EnumGolemType;
import crazyores.packs.core.entity.tileentity.TileEntityTapaziteCrystal;
import crazyores.packs.core.item.CoreItems;
import crazyores.packs.core.model.ModelAdamiteGolem;
import crazyores.packs.core.model.ModelCopperGolem;
import crazyores.packs.core.model.ModelDemoniteGolem;
import crazyores.packs.core.model.ModelEnderGolem;
import crazyores.packs.core.model.ModelFoolsRubyGolem;
import crazyores.packs.core.model.ModelOsmoniumGolem;
import crazyores.packs.core.model.ModelRubyGolem;
import crazyores.packs.core.model.ModelSapphireGolem;
import crazyores.packs.core.model.ModelStarconiumGolem;
import crazyores.packs.core.model.ModelTapaziteGolem;
import crazyores.packs.core.model.ModelZectiumGolem;

public class CoreRenderRegistry {

	public static void renderCoreEntities() {
		RenderingRegistry.registerEntityRenderingHandler(EntityZectiumCore.class, new RenderSnowball(CoreItems.zectiumCore));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityCopperGolem.class, new RenderGolems(new ModelCopperGolem(), EnumGolemType.COPPER));
		RenderingRegistry.registerEntityRenderingHandler(EntitySapphireGolem.class, new RenderGolems(new ModelSapphireGolem(), EnumGolemType.SAPPHIRE));
		RenderingRegistry.registerEntityRenderingHandler(EntityAdamiteGolem.class, new RenderGolems(new ModelAdamiteGolem(), EnumGolemType.ADAMITE));
		RenderingRegistry.registerEntityRenderingHandler(EntityRubyGolem.class, new RenderGolems(new ModelRubyGolem(), EnumGolemType.RUBY));
		RenderingRegistry.registerEntityRenderingHandler(EntityFoolsRubyGolem.class, new RenderGolems(new ModelFoolsRubyGolem(), EnumGolemType.FOOLS_RUBY));
		RenderingRegistry.registerEntityRenderingHandler(EntityZectiumGolem.class, new RenderGolems(new ModelZectiumGolem(), EnumGolemType.ZECTIUM));
		RenderingRegistry.registerEntityRenderingHandler(EntityTapaziteGolem.class, new RenderGolems(new ModelTapaziteGolem(), EnumGolemType.TAPAZITE));
		RenderingRegistry.registerEntityRenderingHandler(EntityOsmoniumGolem.class, new RenderGolems(new ModelOsmoniumGolem(), EnumGolemType.OSMONIUM));
		RenderingRegistry.registerEntityRenderingHandler(EntityStarconiumGolem.class, new RenderGolems(new ModelStarconiumGolem(), EnumGolemType.STARCONIUM));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityDemoniteGolem.class, new RenderGolems(new ModelDemoniteGolem(), EnumGolemType.DEMONITE));
		RenderingRegistry.registerEntityRenderingHandler(EntityEnderGolem.class, new RenderGolems(new ModelEnderGolem(), EnumGolemType.ENDER));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityFlamingArrow.class, new CoreRenderArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityExplosiveArrow.class, new CoreRenderArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityElectricArrow.class, new CoreRenderArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityFreezingArrow.class, new CoreRenderArrow());
	}
	
	public static void renderCoreTileEntities() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTapaziteCrystal.class, new RenderTapaziteCrystal());
	}
}

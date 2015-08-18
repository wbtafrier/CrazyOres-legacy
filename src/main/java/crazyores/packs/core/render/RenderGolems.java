package crazyores.packs.core.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import crazyores.packs.core.entity.golem.CoreEntityGolem;
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
import crazyores.packs.core.model.ModelAdamiteGolem;
import crazyores.packs.core.model.ModelCopperGolem;
import crazyores.packs.core.model.ModelDemoniteGolem;
import crazyores.packs.core.model.ModelEnderGolem;
import crazyores.packs.core.model.ModelFoolsRubyGolem;
import crazyores.packs.core.model.ModelOsmoniumGolem;
import crazyores.packs.core.model.ModelRubyGolem;
import crazyores.packs.core.model.ModelSapphireGolem;
import crazyores.packs.core.model.ModelStarconiumGolem;
import crazyores.packs.core.model.ModelTapaziteCrystal;
import crazyores.packs.core.model.ModelTapaziteGolem;
import crazyores.packs.core.model.ModelZectiumGolem;
import crazyores.packs.core.util.CoreResourceHandler;

public class RenderGolems extends RenderLiving {

	private ModelCopperGolem copperGolemModel;
	private ModelSapphireGolem sapphireGolemModel;
	private ModelAdamiteGolem adamiteGolemModel;
	private ModelRubyGolem rubyGolemModel;
	private ModelFoolsRubyGolem foolsRubyGolemModel;
	private ModelZectiumGolem zectiumGolemModel;
	private ModelTapaziteGolem tapaziteGolemModel;
	private ModelTapaziteCrystal crystalGolemModel;
	private ModelOsmoniumGolem osmoniumGolemModel;
	private ModelStarconiumGolem starconiumGolemModel;
	private ModelDemoniteGolem demoniteGolemModel;
	private ModelEnderGolem enderGolemModel;
	
	public RenderGolems(ModelBase golem, EnumGolemType type) {
		super(golem, 0.5F);

		if (type.equals(EnumGolemType.COPPER))
			this.copperGolemModel = (ModelCopperGolem)this.mainModel;
		else if (type.equals(EnumGolemType.SAPPHIRE))
			this.sapphireGolemModel = (ModelSapphireGolem)this.mainModel;
		else if (type.equals(EnumGolemType.ADAMITE))
			this.adamiteGolemModel = (ModelAdamiteGolem)this.mainModel;
		else if (type.equals(EnumGolemType.RUBY))
			this.rubyGolemModel = (ModelRubyGolem)this.mainModel;
		else if (type.equals(EnumGolemType.FOOLS_RUBY))
			this.foolsRubyGolemModel = (ModelFoolsRubyGolem)this.mainModel;
		else if (type.equals(EnumGolemType.ZECTIUM))
			this.zectiumGolemModel = (ModelZectiumGolem)this.mainModel;
		else if (type.equals(EnumGolemType.TAPAZITE))
			this.tapaziteGolemModel = (ModelTapaziteGolem)this.mainModel;
		else if (type.equals(EnumGolemType.OSMONIUM))
			this.osmoniumGolemModel = (ModelOsmoniumGolem)this.mainModel;
		else if (type.equals(EnumGolemType.STARCONIUM))
			this.starconiumGolemModel = (ModelStarconiumGolem)this.mainModel;
		else if (type.equals(EnumGolemType.DEMONITE))
			this.demoniteGolemModel = (ModelDemoniteGolem)this.mainModel;
		else if (type.equals(EnumGolemType.ENDER))
			this.enderGolemModel = (ModelEnderGolem)this.mainModel;
	}

	public void doRender(CoreEntityGolem golem, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(golem, par2, par4, par6, par8, par9);
	}

	protected ResourceLocation getEntityTexture(CoreEntityGolem golem) {
		
		if (golem instanceof EntityCopperGolem)
			return CoreResourceHandler.COPPER_GOLEM_IMAGE;
		else if (golem instanceof EntitySapphireGolem)
			return CoreResourceHandler.SAPPHIRE_GOLEM_IMAGE;
		else if (golem instanceof EntityAdamiteGolem)
			return CoreResourceHandler.ADAMITE_GOLEM_IMAGE;
		else if (golem instanceof EntityRubyGolem)
			return CoreResourceHandler.RUBY_GOLEM_IMAGE;
		else if (golem instanceof EntityFoolsRubyGolem)
			return CoreResourceHandler.FOOLS_RUBY_GOLEM_IMAGE;
		else if (golem instanceof EntityZectiumGolem)
			return CoreResourceHandler.ZECTIUM_GOLEM_IMAGE;
		else if (golem instanceof EntityTapaziteGolem)
			return CoreResourceHandler.TAPAZITE_GOLEM_IMAGE;
		else if (golem instanceof EntityOsmoniumGolem)
			return CoreResourceHandler.OSMONIUM_GOLEM_IMAGE;
		else if (golem instanceof EntityStarconiumGolem)
			return CoreResourceHandler.STARCONIUM_GOLEM_IMAGE;
		else if (golem instanceof EntityDemoniteGolem)
			return CoreResourceHandler.DEMONITE_GOLEM_IMAGE;
		else if (golem instanceof EntityEnderGolem)
			return CoreResourceHandler.ENDER_GOLEM_IMAGE;
		else
			return CoreResourceHandler.UNKNOWN_IMAGE;
	}
	
	protected void rotateCorpse(CoreEntityGolem golem, float x, float y, float z) {
        super.rotateCorpse(golem, x, y, z);

        if ((double)golem.limbSwingAmount >= 0.01D) {
            float f3 = 13.0F;
            float f4 = golem.limbSwing - golem.limbSwingAmount * (1.0F - z) + 6.0F;
            float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
            GL11.glRotatef(6.5F * f5, 0.0F, 0.0F, 1.0F);
        }
    }
	
	protected void renderEquippedItems(CoreEntityGolem golem, float idk) {
        super.renderEquippedItems(golem, idk);

        if (golem.getHoldRoseTick() != 0) {
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glPushMatrix();
            
            if (golem instanceof EntityCopperGolem)
            	GL11.glRotatef(5.0F + 180.0F * this.copperGolemModel.rightArm.rotateAngleX / (float)Math.PI, 1.0F, 0.0F, 0.0F);
            
            
            GL11.glTranslatef(-0.6875F, 1.25F, -0.9375F);
            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            float f1 = 0.8F;
            GL11.glScalef(f1, -f1, f1);
            int i = golem.getBrightnessForRender(idk);
            int j = i % 65536;
            int k = i / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.bindTexture(TextureMap.locationBlocksTexture);
            this.field_147909_c.renderBlockAsItem(Blocks.red_flower, 0, 1.0F);
            GL11.glPopMatrix();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        }
    }

	/**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntityLiving entity, double x, double y, double z, float f1, float f2) {
    	this.doRender((CoreEntityGolem)entity, x, y, z, f1, f2);
    }

    protected void renderEquippedItems(EntityLivingBase entity, float f1) {
        this.renderEquippedItems((CoreEntityGolem)entity, f1);
    }

    protected void rotateCorpse(EntityLivingBase entity, float x, float y, float z) {
        this.rotateCorpse((CoreEntityGolem)entity, x, y, z);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntityLivingBase entity, double x, double y, double z, float f1, float f2) {
        this.doRender((CoreEntityGolem)entity, x, y, z, f1, f2);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity entity) {
    	return this.getEntityTexture((CoreEntityGolem)entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity entity, double x, double y, double z, float f1, float f2) {
        this.doRender((CoreEntityGolem)entity, x, y, z, f1, f2);
    }
    
    @Override
    protected void preRenderCallback(EntityLivingBase entity, float par2) {
    	if (entity instanceof EntityEnderGolem) {
    		this.scaleGolem((CoreEntityGolem)entity, par2);
    	}
    }
    
    private float s = 2.0f;
    private boolean flip = false;
    
	protected void scaleGolem(CoreEntityGolem entity, float par2) {
		//for shits and giggles ;)
		
		if (s >= 20) flip = true;
		if (s <= 2) flip = false;
		
		if (!flip)
			GL11.glScalef(s += 0.01, s += 0.01, s += 0.01);
		else
			GL11.glScalef(s -= 0.01, s -= 0.01, s -= 0.01);
    }
}

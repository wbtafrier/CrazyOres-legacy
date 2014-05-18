package crazyores_core.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
import crazyores_core.common.entity.EntityGolems;

@SideOnly(Side.CLIENT)
public class RenderGolems extends RenderLiving
{
	/** Fool's Ruby Golem's Model. */
	private ModelFoolsRubyGolem foolsRubyGolemModel = null;
	/** Copper Golem's Model. */
	private ModelCopperGolem copperGolemModel = null;
	/** Sapphire Golem's Model. */
	private ModelSapphireGolem sapphireGolemModel = null;
	/** Adamite Golem's Model. */
	private ModelAdamiteGolem adamiteGolemModel = null;
	/** Ruby Golem's Model. */
	private ModelRubyGolem rubyGolemModel = null;
	/** Zectium Golem's Model. */
	private ModelZectiumGolem zectiumGolemModel = null;
	/** Tapazite Golem's Model. */
	private ModelTapaziteGolem tapaziteGolemModel = null;
	/** Crystal Golem's Model. */
	private ModelCrystalGolem crystalGolemModel = null;
	/** Osmonium Golem's Model. */
	private ModelOsmoniumGolem osmoniumGolemModel = null;
	/** Demonite Golem's Model. */
	private ModelDemoniteGolem demoniteGolemModel = null;
	/** Starconium Golem's Model. */
	private ModelStarconiumGolem starconiumGolemModel = null;
	
	public static String name = "";
	private static ResourceLocation golemLocation = new ResourceLocation("CrazyOres:textures/mob/");

	public RenderGolems(ModelBase golem, String n)
	{
		super(golem, 0.5F);

		name = n;
		if (name.equalsIgnoreCase("copper"))
			this.copperGolemModel = (ModelCopperGolem)this.mainModel;
		else if (name.equalsIgnoreCase("sapphire"))
			this.sapphireGolemModel = (ModelSapphireGolem)this.mainModel;
		else if (name.equalsIgnoreCase("adamite"))
			this.adamiteGolemModel = (ModelAdamiteGolem)this.mainModel;
		else if (name.equalsIgnoreCase("ruby"))
			this.rubyGolemModel = (ModelRubyGolem)this.mainModel;
		else if (name.equalsIgnoreCase("zectium"))
			this.zectiumGolemModel = (ModelZectiumGolem)this.mainModel;
		else if (name.equalsIgnoreCase("tapazite"))
			this.tapaziteGolemModel = (ModelTapaziteGolem)this.mainModel;
		else if (name.equalsIgnoreCase("crystal"))
			this.crystalGolemModel = (ModelCrystalGolem)this.mainModel;
		else if (name.equalsIgnoreCase("osmonium"))
			this.osmoniumGolemModel = (ModelOsmoniumGolem)this.mainModel;
		else if (name.equalsIgnoreCase("starconium"))
			this.starconiumGolemModel = (ModelStarconiumGolem)this.mainModel;
		else if (name.equalsIgnoreCase("demonite"))
			this.demoniteGolemModel = (ModelDemoniteGolem)this.mainModel;
		else if (name.equalsIgnoreCase("foolsruby"))
			this.foolsRubyGolemModel = (ModelFoolsRubyGolem)this.mainModel;
	}

	/**
	 * Renders the Iron Golem.
	 */
	public void doRender(EntityGolems par1EntityGolems, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRender(par1EntityGolems, par2, par4, par6, par8, par9);
	}

	protected ResourceLocation getEntityTexture(EntityGolems par1EntityGolems)
	{
		return golemLocation;
	}

	/**
	 * Rotates Iron Golem corpse.
	 */
	protected void rotateIronGolemCorpse(EntityGolems par1EntityGolems, float par2, float par3, float par4)
	{
		super.rotateCorpse(par1EntityGolems, par2, par3, par4);

		if ((double)par1EntityGolems.limbSwingAmount >= 0.01D)
		{
			float f3 = 13.0F;
			float f4 = par1EntityGolems.limbSwing - par1EntityGolems.limbSwingAmount * (1.0F - par4) + 6.0F;
			float f5 = 0.0F;
			
			if (par1EntityGolems.getName().equals("foolsRuby"))
				f5 = 0.0F;
			else
				f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
			
			GL11.glRotatef(6.5F * f5, 0.0F, 0.0F, 1.0F);
		}
	}

	/**
	 * Renders Iron Golem Equipped items.
	 */
	protected void renderIronGolemEquippedItems(EntityGolems par1EntityGolems, float par2)
	{
		return;
	}

	public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.doRender((EntityGolems)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2)
	{
		this.renderIronGolemEquippedItems((EntityGolems)par1EntityLivingBase, par2);
	}

	protected void rotateCorpse(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4)
	{
		this.rotateIronGolemCorpse((EntityGolems)par1EntityLivingBase, par2, par3, par4);
	}

	public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9)
	{
		this.doRender((EntityGolems)par1EntityLivingBase, par2, par4, par6, par8, par9);
	}

	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEntityTexture((EntityGolems)par1Entity);
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	 * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	 * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
	 * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.doRender((EntityGolems)par1Entity, par2, par4, par6, par8, par9);
	}
}

package crazyores_core.client.model;

import crazyores_core.common.entity.EntityGolems;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;

public class ModelCopperGolem extends ModelBase
{
	//fields
	ModelRenderer Golem_Middle;
	ModelRenderer golemHead;
	ModelRenderer body;
	public ModelRenderer armRight;
	ModelRenderer armLeft;
	ModelRenderer legRight;
	ModelRenderer legLeft;

	public ModelCopperGolem()
	{
		textureWidth = 128;
		textureHeight = 128;

		Golem_Middle = new ModelRenderer(this, 0, 70);
		Golem_Middle.addBox(0F, 0F, 0F, 10, 9, 6);
		Golem_Middle.setRotationPoint(-5F, 0F, -1.5F);
		Golem_Middle.setTextureSize(128, 128);
		Golem_Middle.mirror = true;
		setRotation(Golem_Middle, 0F, 0F, 0F);
		golemHead = (new ModelRenderer(this)).setTextureSize(128, 128);
		golemHead.setRotationPoint(0F, -11F, -1F);
		golemHead.setTextureOffset(0, 0).addBox(-4F, -10F, -5F, 8, 10, 8);
		golemHead.setTextureOffset(24, 0).addBox(-1F, -3F, -7F, 2, 4, 2);
		body = new ModelRenderer(this, 0, 40);
		body.addBox(-4F, 0F, -2F, 18, 12, 11);
		body.setRotationPoint(-5F, -11F, -4F);
		body.setTextureSize(128, 128);
		body.mirror = true;
		setRotation(body, 0.2230717F, 0F, 0F);
		armRight = new ModelRenderer(this, 60, 21);
		armRight.addBox(-3F, -3F, -2F, 4, 28, 6);
		armRight.setRotationPoint(-10F, -7F, 0F);
		armRight.setTextureSize(128, 128);
		armRight.mirror = true;
		setRotation(armRight, 0F, 0F, 0F);
		armLeft = new ModelRenderer(this, 60, 58);
		armLeft.addBox(-1F, -2F, -2F, 4, 28, 6);
		armLeft.setRotationPoint(10F, -7F, 0F);
		armLeft.setTextureSize(128, 128);
		armLeft.mirror = true;
		setRotation(armLeft, 0F, 0F, 0F);
		legRight = new ModelRenderer(this, 37, 0);
		legRight.addBox(-2F, 0F, -2F, 6, 16, 5);
		legRight.setRotationPoint(-5F, 8F, 0F);
		legRight.setTextureSize(128, 128);
		legRight.mirror = true;
		setRotation(legRight, 0F, 0F, 0F);
		legLeft = new ModelRenderer(this, 60, 0);
		legLeft.addBox(-1F, 0F, -2F, 6, 16, 5);
		legLeft.setRotationPoint(2F, 8F, 0F);
		legLeft.setTextureSize(128, 128);
		legLeft.mirror = true;
		setRotation(legLeft, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		//	    Nose.render(f5);
		Golem_Middle.render(f5);
		golemHead.render(f5);
		body.render(f5);
		armRight.render(f5);
		armLeft.render(f5);
		legRight.render(f5);
		legLeft.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.golemHead.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.golemHead.rotateAngleX = f4 / (180F / (float)Math.PI);
		//		this.Nose.rotateAngleY = f3 / (180F / (float)Math.PI);
		//		this.Nose.rotateAngleX = f4 / (180F / (float)Math.PI);
		this.legLeft.rotateAngleX = -1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.legRight.rotateAngleX = 1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.legLeft.rotateAngleY = 0.0F;
		this.legRight.rotateAngleY = 0.0F;
	}

	/**
	 * Used for easily adding entity-dependent animations. The second and third float params here are the same second
	 * and third as in the setRotationAngles method.
	 */
	public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4)
	{
		EntityGolems entitygolems = (EntityGolems)par1EntityLivingBase;
		int i = entitygolems.getAttackTimer();

		if (i > 0)
		{
			this.armRight.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F);
			this.armLeft.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F);
		}
		else
		{
			this.armRight.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3;
			this.armLeft.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3;
		}
	}


	private float func_78172_a(float par1, float par2)
	{
		return (Math.abs(par1 % par2 - par2 * 0.5F) - par2 * 0.25F) / (par2 * 0.25F);
	}

}

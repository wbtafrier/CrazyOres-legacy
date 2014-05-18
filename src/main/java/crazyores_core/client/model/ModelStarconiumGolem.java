package crazyores_core.client.model;

import crazyores_core.common.entity.EntityGolems;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class ModelStarconiumGolem extends ModelBase
{
	//fields
	ModelRenderer golemHead;
	ModelRenderer golemNeck;
	ModelRenderer golemChest;
	ModelRenderer golemMiddle;
	ModelRenderer golemBottom;
	ModelRenderer armRightTop;
	ModelRenderer armRightTopMiddle;
	ModelRenderer armRightBottomMiddle;
	public ModelRenderer armRightBottom;
	ModelRenderer armLeftTop;
	ModelRenderer armLeftTopMiddle;
	ModelRenderer armLeftBottomMiddle;
	ModelRenderer armLeftBottom;
	ModelRenderer legRightTop;
	ModelRenderer legRightMiddle;
	ModelRenderer legRightBottom;
	ModelRenderer legLeftTop;
	ModelRenderer legLeftMiddle;
	ModelRenderer legLeftBottom;

	public ModelStarconiumGolem()
	{
		textureWidth = 256;
		textureHeight = 256;

		golemHead = (new ModelRenderer(this)).setTextureSize(256, 256);
		golemHead.setTextureOffset(0, 0).addBox(-5F, -10F, -5F, 13, 15, 12);
		golemHead.setTextureOffset(38, 0).addBox(-0.5F, -0F, -7F, 4, 6, 2);
		golemHead.setRotationPoint(-1.5F, -43F, 0F);
		golemHead.setTextureSize(256, 256);
		golemHead.mirror = true;
		setRotation(golemHead, 0F, 0F, 0F);
		golemNeck = new ModelRenderer(this, 0, 28);
		golemNeck.addBox(0F, 0F, 0F, 18, 3, 14);
		golemNeck.setRotationPoint(-9F, -39F, -2.533333F);
		golemNeck.setTextureSize(256, 256);
		golemNeck.mirror = true;
		setRotation(golemNeck, 0F, 0F, 0F);
		golemChest = new ModelRenderer(this, 0, 46);
		golemChest.addBox(-4F, 0F, -2F, 34, 22, 19);
		golemChest.setRotationPoint(-13F, -39F, -2F);
		golemChest.setTextureSize(256, 256);
		golemChest.mirror = true;
		setRotation(golemChest, -0.1858931F, 0F, 0F);
		golemMiddle = new ModelRenderer(this, 0, 88);
		golemMiddle.addBox(0F, 0F, 0F, 26, 12, 12);
		golemMiddle.setRotationPoint(-13F, -17F, -4F);
		golemMiddle.setTextureSize(256, 256);
		golemMiddle.mirror = true;
		setRotation(golemMiddle, 0F, 0F, 0F);
		golemBottom = new ModelRenderer(this, 0, 113);
		golemBottom.addBox(0F, 0F, 0F, 20, 12, 10);
		golemBottom.setRotationPoint(-10F, -8F, -3F);
		golemBottom.setTextureSize(256, 256);
		golemBottom.mirror = true;
		setRotation(golemBottom, -0.0371786F, 0F, 0F);
		armRightTop = new ModelRenderer(this, 148, 4);
		armRightTop.addBox(0F, 0F, 0F, 7, 23, 9);
		armRightTop.setRotationPoint(-23.5F, -32.3F, -1F);
		armRightTop.setTextureSize(256, 256);
		armRightTop.mirror = true;
		setRotation(armRightTop, 0.1115358F, 0F, 0F);
		armRightTopMiddle = new ModelRenderer(this, 148, 37);
		armRightTopMiddle.addBox(0.5F, 15.3F, 8F, 6, 11, 10);
		armRightTopMiddle.setRotationPoint(-23.5F, -32.3F, -1F);
		armRightTopMiddle.setTextureSize(256, 256);
		armRightTopMiddle.mirror = true;
		setRotation(armRightTopMiddle, -0.3717838F, 0F, 0F);
		armRightBottomMiddle = new ModelRenderer(this, 148, 59);
		armRightBottomMiddle.addBox(0F, 16F, 16.8F, 7, 9, 10);
		armRightBottomMiddle.setRotationPoint(-23.5F, -32.3F, -1F);
		armRightBottomMiddle.setTextureSize(256, 256);
		armRightBottomMiddle.mirror = true;
		setRotation(armRightBottomMiddle, -0.7679449F, 0F, 0F);
		armRightBottom = new ModelRenderer(this, 148, 79);
		armRightBottom.addBox(-0.5F, 9.533334F, 24F, 8, 15, 11);
		armRightBottom.setRotationPoint(-23.5F, -32.3F, -1F);
		armRightBottom.setTextureSize(256, 256);
		armRightBottom.mirror = true;
		setRotation(armRightBottom, -1.22173F, 0F, 0F);
		armLeftTop = new ModelRenderer(this, 114, 4);
		armLeftTop.addBox(-7F, 0F, 0F, 7, 23, 9);
		armLeftTop.setRotationPoint(23.5F, -32.3F, -1F);
		armLeftTop.setTextureSize(256, 256);
		armLeftTop.mirror = true;
		setRotation(armLeftTop, 0.111544F, 0F, 0F);
		armLeftTopMiddle = new ModelRenderer(this, 114, 37);
		armLeftTopMiddle.addBox(-6.5F, 15.3F, 8F, 6, 11, 10);
		armLeftTopMiddle.setRotationPoint(23.5F, -32.3F, -1F);
		armLeftTopMiddle.setTextureSize(256, 256);
		armLeftTopMiddle.mirror = true;
		setRotation(armLeftTopMiddle, -0.37179F, 0F, 0F);
		armLeftBottomMiddle = new ModelRenderer(this, 112, 59);
		armLeftBottomMiddle.addBox(-7F, 16F, 16.8F, 7, 9, 10);
		armLeftBottomMiddle.setRotationPoint(23.5F, -32.3F, -1F);
		armLeftBottomMiddle.setTextureSize(256, 256);
		armLeftBottomMiddle.mirror = true;
		setRotation(armLeftBottomMiddle, -0.7679449F, 0F, 0F);
		armLeftBottom = new ModelRenderer(this, 108, 79);
		armLeftBottom.addBox(-7.5F, 9.5F, 24F, 8, 15, 11);
		armLeftBottom.setRotationPoint(23.5F, -32.3F, -1F);
		armLeftBottom.setTextureSize(256, 256);
		armLeftBottom.mirror = true;
		setRotation(armLeftBottom, -1.22173F, 0F, 0F);
		legRightTop = new ModelRenderer(this, 148, 110);
		legRightTop.addBox(-2.1F, 0F, -0.8F, 8, 14, 6);
		legRightTop.setRotationPoint(-9.5F, 1F, 0.5F);
		legRightTop.setTextureSize(256, 256);
		legRightTop.mirror = true;
		setRotation(legRightTop, -0.2974216F, 0.2708895F, 0F);
		legRightMiddle = new ModelRenderer(this, 148, 131);
		legRightMiddle.addBox(-1.6F, 9.5F, -5.5F, 7, 7, 8);
		legRightMiddle.setRotationPoint(-9.5F, 1F, 0.5F);
		legRightMiddle.setTextureSize(256, 256);
		legRightMiddle.mirror = true;
		setRotation(legRightMiddle, 0F, 0.2708926F, 0F);
		legRightBottom = new ModelRenderer(this, 148, 147);
		legRightBottom.addBox(-4F, 15F, -5.3F, 11, 8, 10);
		legRightBottom.setRotationPoint(-9.5F, 1F, 0.5F);
		legRightBottom.setTextureSize(256, 256);
		legRightBottom.mirror = true;
		setRotation(legRightBottom, 0F, 0.2708926F, 0F);
		legLeftTop = new ModelRenderer(this, 117, 110);
		legLeftTop.addBox(-4F, 0F, -0.8F, 8, 14, 6);
		legLeftTop.setRotationPoint(8.5F, 1F, 0.5F);
		legLeftTop.setTextureSize(256, 256);
		legLeftTop.mirror = true;
		setRotation(legLeftTop, -0.2974216F, -0.2708926F, 0F);
		legLeftMiddle = new ModelRenderer(this, 115, 131);
		legLeftMiddle.addBox(-3.5F, 9.5F, -5.5F, 7, 7, 8);
		legLeftMiddle.setRotationPoint(8.5F, 1F, 0.5F);
		legLeftMiddle.setTextureSize(256, 256);
		legLeftMiddle.mirror = true;
		setRotation(legLeftMiddle, 0F, -0.2708926F, 0F);
		legLeftBottom = new ModelRenderer(this, 103, 147);
		legLeftBottom.addBox(-5.1F, 15F, -5.3F, 11, 8, 10);
		legLeftBottom.setRotationPoint(8.5F, 1F, 0.5F);
		legLeftBottom.setTextureSize(256, 256);
		legLeftBottom.mirror = true;
		setRotation(legLeftBottom, 0F, -0.2708926F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		golemHead.render(f5);
		golemNeck.render(f5);
		golemChest.render(f5);
		golemMiddle.render(f5);
		golemBottom.render(f5);
		armRightTop.render(f5);
		armRightTopMiddle.render(f5);
		armRightBottomMiddle.render(f5);
		armRightBottom.render(f5);
		armLeftTop.render(f5);
		armLeftTopMiddle.render(f5);
		armLeftBottomMiddle.render(f5);
		armLeftBottom.render(f5);
		legRightTop.render(f5);
		legRightMiddle.render(f5);
		legRightBottom.render(f5);
		legLeftTop.render(f5);
		legLeftMiddle.render(f5);
		legLeftBottom.render(f5);
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
		this.legLeftTop.rotateAngleX = -1.5F * this.func_78172_a(f, 13.0F) * f1 + -0.2974216F;
		this.legLeftMiddle.rotateAngleX = -1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.legLeftBottom.rotateAngleX = -1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.legRightTop.rotateAngleX = 1.5F * this.func_78172_a(f, 13.0F) * f1 + -0.2974216F;
		this.legRightMiddle.rotateAngleX = 1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.legRightBottom.rotateAngleX = 1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.legLeftTop.rotateAngleY = -0.2708926F;
		this.legLeftMiddle.rotateAngleY = -0.2708926F;
		this.legLeftBottom.rotateAngleY = -0.2708926F;
		this.legRightTop.rotateAngleY = 0.2708926F;
		this.legRightMiddle.rotateAngleY = 0.2708926F;
		this.legRightBottom.rotateAngleY = 0.2708926F;
	}

	public float func_78172_a(float par1, float par2)
	{
		return (Math.abs(par1 % par2 - par2 * 0.5F) - par2 * 0.25F) / (par2 * 0.25F);
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
			this.armRightTop.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + 0.1115358F;
			this.armRightTopMiddle.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -0.3717838F;
			this.armRightBottomMiddle.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -0.7679449F;
			this.armRightBottom.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -1.22173F;
			this.armLeftTop.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + 0.1115358F;
			this.armLeftTopMiddle.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -0.3717838F;
			this.armLeftBottomMiddle.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -0.7679449F;
			this.armLeftBottom.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -1.22173F;
		}
		else
		{
			this.armRightTop.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + 0.1115358F;
			this.armRightTopMiddle.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -0.3717838F;
			this.armRightBottomMiddle.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -0.7679449F;
			this.armRightBottom.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -1.22173F;
			this.armLeftTop.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + 0.1115358F;
			this.armLeftTopMiddle.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -0.3717838F;
			this.armLeftBottomMiddle.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -0.7679449F;
			this.armLeftBottom.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -1.22173F;
		}
	}
}

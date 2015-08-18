package crazyores.packs.core.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import crazyores.packs.core.entity.golem.EntityTapaziteGolem;

public class ModelTapaziteGolem extends ModelBase {
	
	public ModelRenderer golemChest;
	public ModelRenderer golemHead;
	public ModelRenderer golemMiddle;
	public ModelRenderer legRightTop;
	public ModelRenderer legLeftTop;
	public ModelRenderer legRightMiddle;
	public ModelRenderer legLeftMiddle;
	public ModelRenderer legRightBottom;
	public ModelRenderer legLeftBottom;
	public ModelRenderer armRightTop;
	public ModelRenderer armLeftTop;
	public ModelRenderer armRightMiddle;
	public ModelRenderer armLeftMiddle;
	public ModelRenderer armRightBottom;
	public ModelRenderer armLeftBottom;
	public ModelRenderer golemLower;

	public ModelTapaziteGolem() {
		textureWidth = 128;
		textureHeight = 128;

		golemChest = new ModelRenderer(this, 0, 23);
		golemChest.setTextureSize(textureWidth, textureWidth);
		golemChest.setRotationPoint(-9F, -21F, -7F);
		golemChest.addBox(-4F, 0F, -2F, 26, 17, 13);
		golemChest.mirror = true;
		setRotation(golemChest, 0.3346075F, 0F, 0F);

		golemHead = new ModelRenderer(this);
		golemChest.setTextureSize(textureWidth, textureWidth);
		golemHead.setRotationPoint(-1F, -25F, -2F);
		golemHead.setTextureOffset(0, 0).addBox(-4.5F, -10F, -5F, 10, 12, 10);
		golemHead.setTextureOffset(30, 0).addBox(-1F, -2F, -7F, 3, 5, 2);
		golemHead.mirror = true;
		setRotation(golemHead, 0F, 0F, 0F);

		golemLower = new ModelRenderer(this, 0, 78);
		golemChest.setTextureSize(textureWidth, textureWidth);
		golemLower.setRotationPoint(-7F, -1F, -3F);
		golemLower.addBox(0F, 0F, 0F, 14, 10, 10);
		golemLower.mirror = true;
		setRotation(golemLower, -0.0371786F, 0F, 0F);
		
		golemMiddle = new ModelRenderer(this, 0, 54);
		golemChest.setTextureSize(textureWidth, textureWidth);
		golemMiddle.setRotationPoint(-8.5F, -11F, -4F);
		golemMiddle.addBox(0F, 0F, 0F, 17, 11, 12);
		golemMiddle.mirror = true;
		setRotation(golemMiddle, 0F, 0F, 0F);

		legRightTop = new ModelRenderer(this, 97, 78);
		golemChest.setTextureSize(textureWidth, textureWidth);
		legRightTop.setRotationPoint(-7.5F, 5F, 0.5F);
		legRightTop.addBox(-2F, 0F, -1F, 7, 9, 6);
		legRightTop.mirror = true;
		setRotation(legRightTop, -0.2974216F, 0.1487164F, 0F);

		legLeftTop = new ModelRenderer(this, 70, 78);
		golemChest.setTextureSize(textureWidth, textureWidth);
		legLeftTop.setRotationPoint(7.5F, 5F, 0.5F);
		legLeftTop.addBox(-4F, 0F, -1F, 7, 9, 6);
		legLeftTop.mirror = true;
		setRotation(legLeftTop, -0.2974216F, -0.1487195F, 0F);

		legRightMiddle = new ModelRenderer(this, 97, 94);
		golemChest.setTextureSize(textureWidth, textureWidth);
		legRightMiddle.setRotationPoint(-7.5F, 5F, 0.5F);
		legRightMiddle.addBox(-1.7F, 8F, -4.5F, 6, 4, 6);
		legRightMiddle.mirror = true;
		setRotation(legRightMiddle, 0F, 0F, 0F);

		legLeftMiddle = new ModelRenderer(this, 72, 94);
		golemChest.setTextureSize(textureWidth, textureWidth);
		legLeftMiddle.setRotationPoint(7.5F, 5F, 0.5F);
		legLeftMiddle.addBox(-3.3F, 8F, -4.5F, 6, 4, 6);
		legLeftMiddle.mirror = true;
		setRotation(legLeftMiddle, 0F, 0F, 0F);

		legRightBottom = new ModelRenderer(this, 93, 105);
		golemChest.setTextureSize(textureWidth, textureWidth);
		legRightBottom.setRotationPoint(-7.5F, 5F, 0.5F);
		legRightBottom.addBox(-3.4F, 11F, -4.3F, 9, 8, 8);
		legRightBottom.mirror = true;
		setRotation(legRightBottom, 0F, 0F, 0F);

		legLeftBottom = new ModelRenderer(this, 58, 105);
		golemChest.setTextureSize(textureWidth, textureWidth);
		legLeftBottom.setRotationPoint(7.5F, 5F, 0.5F);
		legLeftBottom.addBox(-4.6F, 11F, -4.3F, 9, 8, 8);
		legLeftBottom.mirror = true;
		setRotation(legLeftBottom, 0F, 0F, 0F);

		armRightTop = new ModelRenderer(this, 104, 4);
		golemChest.setTextureSize(textureWidth, textureWidth);
		armRightTop.setRotationPoint(-16.5F, -16.3F, -4F);
		armRightTop.addBox(0F, 0F, 0F, 5, 19, 7);
		armRightTop.mirror = true;
		setRotation(armRightTop, 0.1115358F, 0.0743572F, 0.0371786F);

		armLeftTop = new ModelRenderer(this, 79, 4);
		golemChest.setTextureSize(textureWidth, textureWidth);
		armLeftTop.setRotationPoint(11.5F, -16.3F, -4F);
		armLeftTop.addBox(0F, 0F, 0F, 5, 19, 7);
		armLeftTop.mirror = true;
		setRotation(armLeftTop, 0.111544F, -0.074351F, -0.0371755F);
		
		armRightMiddle = new ModelRenderer(this, 104, 31);
		golemChest.setTextureSize(textureWidth, textureWidth);
		armRightMiddle.setRotationPoint(-16.5F, -16.3F, -4F);
		armRightMiddle.addBox(0.5F, 12.3F, 8F, 4, 9, 7);
		armRightMiddle.mirror = true;
		setRotation(armRightMiddle, -0.4461411F, 0.074351F, 0.0371755F);
		
		armLeftMiddle = new ModelRenderer(this, 81, 31);
		golemChest.setTextureSize(textureWidth, textureWidth);
		armLeftMiddle.setRotationPoint(11.5F, -16.3F, -4F);
		armLeftMiddle.addBox(0.5F, 12.3F, 8F, 4, 9, 7);
		armLeftMiddle.mirror = true;
		setRotation(armLeftMiddle, -0.4461411F, -0.074351F, -0.0371755F);
		
		armRightBottom = new ModelRenderer(this, 104, 48);
		golemChest.setTextureSize(textureWidth, textureWidth);
		armRightBottom.setRotationPoint(-16.5F, -16.3F, -4F);
		armRightBottom.addBox(-0.8F, 16F, 11.3F, 5, 13, 7);
		armRightBottom.mirror = true;
		setRotation(armRightBottom, -0.7679449F, 0F, 0F);
		armRightBottom.mirror = false;
		
		armLeftBottom = new ModelRenderer(this, 79, 48);
		golemChest.setTextureSize(textureWidth, textureWidth);
		armLeftBottom.setRotationPoint(11.5F, -16.3F, -4F);
		armLeftBottom.addBox(0.8F, 16F, 11.5F, 5, 13, 7);
		armLeftBottom.mirror = true;
		setRotation(armLeftBottom, -0.7679449F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		golemChest.render(f5);
		golemHead.render(f5);
		golemMiddle.render(f5);
		legRightTop.render(f5);
		legLeftTop.render(f5);
		legRightMiddle.render(f5);
		legLeftMiddle.render(f5);
		legRightBottom.render(f5);
		legLeftBottom.render(f5);
		armRightTop.render(f5);
		armLeftTop.render(f5);
		armRightMiddle.render(f5);
		armLeftMiddle.render(f5);
		armRightBottom.render(f5);
		armLeftBottom.render(f5);
		golemLower.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.golemHead.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.golemHead.rotateAngleX = f4 / (180F / (float)Math.PI);
		this.legLeftTop.rotateAngleX = -1.5F * this.func_78172_a(f, 13.0F) * f1 + -0.2974289F;
		this.legLeftMiddle.rotateAngleX = -1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.legLeftBottom.rotateAngleX = -1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.legRightTop.rotateAngleX = 1.5F * this.func_78172_a(f, 13.0F) * f1 + -0.2974289F;
		this.legRightMiddle.rotateAngleX = 1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.legRightBottom.rotateAngleX = 1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.legLeftTop.rotateAngleY = -0.185895F;
		this.legLeftMiddle.rotateAngleY = -6.391F;
		this.legLeftBottom.rotateAngleY = 0.0F;
		this.legRightTop.rotateAngleY = 0.185895F;
		this.legRightMiddle.rotateAngleY = 6.391F;
		this.legRightBottom.rotateAngleY = 0.0F;
	}

	public float func_78172_a(float par1, float par2) {
		return (Math.abs(par1 % par2 - par2 * 0.5F) - par2 * 0.25F) / (par2 * 0.25F);
	}

	/**
	 * Used for easily adding entity-dependent animations. The second and third float params here are the same second
	 * and third as in the setRotationAngles method.
	 */
	public void setLivingAnimations(EntityLivingBase entity, float par2, float par3, float par4) {
		EntityTapaziteGolem entitygolems = (EntityTapaziteGolem)entity;
		int i = entitygolems.getAttackTimer();

		if (i > 0) {
			this.armRightTop.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + 6.391F;
			this.armRightMiddle.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -25.562F;
			this.armRightBottom.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -44.562F;
			this.armLeftTop.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + 6.391F;
			this.armLeftMiddle.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -25.562F;
			this.armLeftBottom.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -44.562F;
		}
		else {
			this.armRightTop.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + 6.391F;
			this.armRightMiddle.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -25.562F;
			this.armRightBottom.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -44.562F;
			this.armLeftTop.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + 6.391F;
			this.armLeftMiddle.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -25.562F;
			this.armLeftBottom.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -44.562F;
		}
	}
}
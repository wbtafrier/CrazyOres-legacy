package crazyores.packs.core.model;

import crazyores.packs.core.entity.golem.EntitySapphireGolem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class ModelSapphireGolem extends ModelBase {
	
	public ModelRenderer golemMiddle;
	public ModelRenderer golemHead;
	public ModelRenderer golemChest;
	public ModelRenderer armRightTop;
	public ModelRenderer armRightMiddle;
	public ModelRenderer armRightBottom;
	public ModelRenderer legRight;
	public ModelRenderer legLeft;
	public ModelRenderer armLeftBottom;
	public ModelRenderer armLeftMiddle;
	public ModelRenderer armLeftTop;

	public ModelSapphireGolem() {
		textureWidth = 128;
		textureHeight = 128;

		golemHead = new ModelRenderer(this);
		golemHead.setTextureSize(textureWidth, textureHeight);
		golemHead.setRotationPoint(0F, -12F, -1F);
		golemHead.setTextureOffset(0, 0).addBox(-4F, -10F, -5F, 8, 10, 8);
		golemHead.setTextureOffset(24, 0).addBox(-1F, -3F, -7F, 2, 4, 2);
		golemHead.mirror = true;
		setRotation(golemHead, 0F, 0F, 0F);
		
		golemMiddle = new ModelRenderer(this, 0, 70);
		golemMiddle.setTextureSize(textureWidth, textureHeight);
		golemMiddle.setRotationPoint(-6F, 0F, -2.5F);
		golemMiddle.addBox(0F, 0F, 0F, 12, 9, 7);
		golemMiddle.mirror = true;
		setRotation(golemMiddle, 0F, 0F, 0F);

		golemChest = new ModelRenderer(this, 0, 40);
		golemChest.setTextureSize(textureWidth, textureHeight);
		golemChest.setRotationPoint(-5F, -11F, -5F);
		golemChest.addBox(-4F, 0F, -2F, 18, 13, 11);
		golemChest.mirror = true;
		setRotation(golemChest, 0.2974289F, 0F, 0F);
		
		armRightTop = new ModelRenderer(this, 60, 21);
		armRightTop.setTextureSize(textureWidth, textureHeight);
		armRightTop.setRotationPoint(-13F, -10.3F, -2F);
		armRightTop.addBox(0F, 0F, 0F, 4, 16, 6);
		armRightTop.mirror = true;
		setRotation(armRightTop, 0F, 0F, 0F);
		
		legRight = new ModelRenderer(this, 37, 0);
		legRight.setTextureSize(textureWidth, textureHeight);
		legRight.setRotationPoint(-5.5F, 8F, 0F);
		legRight.addBox(-2F, 0F, -2F, 6, 16, 5);
		legRight.mirror = true;
		setRotation(legRight, 0F, 0F, 0F);
		
		legLeft = new ModelRenderer(this, 60, 0);
		legLeft.setTextureSize(textureWidth, textureHeight);
		legLeft.setRotationPoint(2.5F, 8F, 0F);
		legLeft.addBox(-1F, 0F, -2F, 6, 16, 5);
		legLeft.mirror = true;
		setRotation(legLeft, 0F, 0F, 0F);
		
		armRightMiddle = new ModelRenderer(this, 28, 26);
		armRightMiddle.setTextureSize(textureWidth, textureHeight);
		armRightMiddle.setRotationPoint(-13F, -10.3F, -2F);
		armRightMiddle.addBox(0.5F, 10F, 5.15F, 3, 7, 6);
		armRightMiddle.mirror = true;
		setRotation(armRightMiddle, -0.4461411F, 0F, 0F);
		
		armRightBottom = new ModelRenderer(this, 4, 21);
		armRightBottom.setTextureSize(textureWidth, textureHeight);
		armRightBottom.setRotationPoint(-13F, -10.3F, -2F);
		armRightBottom.addBox(0F, 15F, 5.3F, 4, 12, 6);
		armRightBottom.mirror = true;
		setRotation(armRightBottom, -0.4461411F, 0F, 0F);
		
		armLeftBottom = new ModelRenderer(this, 82, 73);
		armLeftBottom.setTextureSize(textureWidth, textureHeight);
		armLeftBottom.setRotationPoint(13F, -10.3F, -2.0F);
		armLeftBottom.addBox(-4F, 15F, 5.3F, 4, 12, 6);
		armLeftBottom.mirror = true;
		setRotation(armLeftBottom, -0.4461411F, 0F, 0F);
		
		armLeftMiddle = new ModelRenderer(this, 82, 58);
		armLeftMiddle.setTextureSize(textureWidth, textureHeight);
		armLeftMiddle.setRotationPoint(13F, -10.3F, -2F);
		armLeftMiddle.addBox(-3.5F, 10F, 5.15F, 3, 7, 6);
		armLeftMiddle.mirror = true;
		setRotation(armLeftMiddle, -0.4461411F, 0F, 0F);
		
		armLeftTop = new ModelRenderer(this, 60, 58);
		armLeftTop.setTextureSize(textureWidth, textureHeight);
		armLeftTop.setRotationPoint(13F, -10.3F, -2F);
		armLeftTop.addBox(-4F, 0F, 0F, 4, 16, 6);
		armLeftTop.mirror = true;
		setRotation(armLeftTop, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		golemMiddle.render(f5);
		golemHead.render(f5);
		golemChest.render(f5);
		armRightTop.render(f5);
		legRight.render(f5);
		legLeft.render(f5);
		armRightMiddle.render(f5);
		armRightBottom.render(f5);
		armLeftBottom.render(f5);
		armLeftMiddle.render(f5);
		armLeftTop.render(f5);
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
		this.legLeft.rotateAngleX = -1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.legRight.rotateAngleX = 1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.legLeft.rotateAngleY = 0.0F;
		this.legRight.rotateAngleY = 0.0F;
	}

	public float func_78172_a(float par1, float par2) {
		return (Math.abs(par1 % par2 - par2 * 0.5F) - par2 * 0.25F) / (par2 * 0.25F);
	}

	/**
	 * Used for easily adding entity-dependent animations. The second and third float params here are the same second
	 * and third as in the setRotationAngles method.
	 */
	public void setLivingAnimations(EntityLivingBase entity, float par2, float par3, float par4) {
		EntitySapphireGolem golem = (EntitySapphireGolem)entity;
		int i = golem.getAttackTimer();

		if (i > 0) {
			this.armRightTop.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F);
			this.armRightMiddle.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -25.562F;
			this.armRightBottom.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -25.562F;
			this.armLeftTop.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F);
			this.armLeftMiddle.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -25.562F;
			this.armLeftBottom.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -25.562F;
		}
		else {
			this.armRightTop.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3;
			this.armRightMiddle.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -25.562F;
			this.armRightBottom.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -25.562F;
			this.armLeftTop.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3;
			this.armLeftMiddle.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -25.562F;
			this.armLeftBottom.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -25.562F;
		}
	}
}

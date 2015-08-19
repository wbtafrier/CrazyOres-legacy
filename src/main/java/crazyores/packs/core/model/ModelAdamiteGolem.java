package crazyores.packs.core.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import crazyores.packs.core.entity.golem.EntityGolems;
import crazyores.packs.core.entity.golem.EntityAdamiteGolem;

public class ModelAdamiteGolem extends ModelBase {
	
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

	public ModelAdamiteGolem() {
		textureWidth = 128;
		textureHeight = 128;

		golemHead = new ModelRenderer(this);
		golemHead.setTextureSize(textureWidth, textureHeight);
		golemHead.setRotationPoint(0F, -14F, -1F);
		golemHead.setTextureOffset(0, 0).addBox(-4F, -10F, -5F, 8, 10, 8);
		golemHead.setTextureOffset(24, 0).addBox(-1F, -3F, -7F, 2, 4, 2);
		golemHead.mirror = true;
		setRotation(golemHead, 0F, 0F, 0F);
		
		golemChest = new ModelRenderer(this, 0, 40);
		golemChest.setTextureSize(textureWidth, textureHeight);
		golemChest.setRotationPoint(-6F, -12F, -7F);
		golemChest.addBox(-4F, 0F, -2F, 20, 14, 13);
		golemChest.mirror = true;
		setRotation(golemChest, 0.3346075F, 0F, 0F);

		golemMiddle = new ModelRenderer(this, 0, 70);
		golemMiddle.setTextureSize(textureWidth, textureHeight);
		golemMiddle.setRotationPoint(-7F, -2F, -3F);
		golemMiddle.addBox(0F, 0F, 0F, 14, 11, 8);
		golemMiddle.mirror = true;
		setRotation(golemMiddle, 0F, 0F, 0F);
		
		legRightTop = new ModelRenderer(this, 80, 0);
		legRightTop.setTextureSize(textureWidth, textureHeight);
		legRightTop.setRotationPoint(-6.5F, 8F, 0.5F);
		legRightTop.addBox(-2F, 0F, -2F, 6, 6, 5);
		legRightTop.mirror = true;
		setRotation(legRightTop, -0.2974289F, 0.1858931F, 0F);
		
		legLeftTop = new ModelRenderer(this, 50, 0);
		legLeftTop.setTextureSize(textureWidth, textureHeight);
		legLeftTop.setRotationPoint(6.5F, 8F, 0F);
		legLeftTop.addBox(-4F, 0F, -2F, 6, 6, 5);
		legLeftTop.mirror = true;
		setRotation(legLeftTop, -0.2974216F, -0.185895F, 0F);
		
		legRightMiddle = new ModelRenderer(this, 80, 12);
		legRightMiddle.setTextureSize(textureWidth, textureHeight);
		legRightMiddle.setRotationPoint(-6.5F, 8F, 0.5F);
		legRightMiddle.addBox(-1.5F, 4F, -4.5F, 5, 4, 5);
		legRightMiddle.mirror = true;
		setRotation(legRightMiddle, 0F, 0.1115358F, 0F);
		
		legLeftMiddle = new ModelRenderer(this, 50, 12);
		legLeftMiddle.setTextureSize(textureWidth, textureHeight);
		legLeftMiddle.setRotationPoint(6.5F, 8F, 0F);
		legLeftMiddle.addBox(-3.5F, 4F, -4.5F, 5, 4, 5);
		legLeftMiddle.mirror = true;
		setRotation(legLeftMiddle, 0F, -0.111544F, 0F);
		
		legRightBottom = new ModelRenderer(this, 80, 22);
		legRightBottom.setTextureSize(textureWidth, textureHeight);
		legRightBottom.setRotationPoint(-6.5F, 8F, 0.5F);
		legRightBottom.addBox(-2.3F, 7F, -4F, 6, 9, 5);
		legRightBottom.mirror = true;
		setRotation(legRightBottom, 0F, 0F, 0F);
		
		legLeftBottom = new ModelRenderer(this, 50, 22);
		legLeftBottom.setTextureSize(textureWidth, textureHeight);
		legLeftBottom.setRotationPoint(6.5F, 8F, 0F);
		legLeftBottom.addBox(-3.7F, 7F, -4F, 6, 9, 5);
		legLeftBottom.mirror = true;
		setRotation(legLeftBottom, 0F, 0F, 0F);
		
		armRightTop = new ModelRenderer(this, 100, 40);
		armRightTop.setTextureSize(textureWidth, textureHeight);
		armRightTop.setRotationPoint(-14F, -10.3F, -4F);
		armRightTop.addBox(0F, 0F, 0F, 4, 16, 6);
		armRightTop.mirror = true;
		setRotation(armRightTop, 0F, 0F, 0F);
		
		armLeftTop = new ModelRenderer(this, 75, 40);
		armLeftTop.setTextureSize(textureWidth, textureHeight);
		armLeftTop.setRotationPoint(14F, -10.3F, -4F);
		armLeftTop.addBox(-4F, 0F, 0F, 4, 16, 6);
		armLeftTop.mirror = true;
		setRotation(armLeftTop, 0F, 0F, 0F);
		
		armRightMiddle = new ModelRenderer(this, 100, 63);
		armRightMiddle.setTextureSize(textureWidth, textureHeight);
		armRightMiddle.setRotationPoint(-14F, -10.3F, -4F);
		armRightMiddle.addBox(0.5F, 10F, 5.15F, 3, 7, 6);
		armRightMiddle.mirror = true;
		setRotation(armRightMiddle, -0.4461411F, 0F, 0F);
		
		armLeftMiddle = new ModelRenderer(this, 75, 63);
		armLeftMiddle.setTextureSize(textureWidth, textureHeight);
		armLeftMiddle.setRotationPoint(14F, -10.3F, -4F);
		armLeftMiddle.addBox(-3.5F, 10F, 5.15F, 3, 7, 6);
		armLeftMiddle.mirror = true;
		setRotation(armLeftMiddle, -0.4461411F, 0F, 0F);
		
		armRightBottom = new ModelRenderer(this, 100, 77);
		armRightBottom.setTextureSize(textureWidth, textureHeight);
		armRightBottom.setRotationPoint(-14F, -10.3F, -4F);
		armRightBottom.addBox(0F, 15F, 5.3F, 4, 12, 6);
		armRightBottom.mirror = true;
		setRotation(armRightBottom, -0.4461411F, 0F, 0F);
		
		armLeftBottom = new ModelRenderer(this, 75, 77);
		armLeftBottom.setTextureSize(textureWidth, textureHeight);
		armLeftBottom.setRotationPoint(14F, -10.3F, -4F);
		armLeftBottom.addBox(-4F, 15F, 5.3F, 4, 12, 6);
		armLeftBottom.mirror = true;
		setRotation(armLeftBottom, -0.4461411F, 0F, 0F);
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
		EntityAdamiteGolem golem = (EntityAdamiteGolem)entity;
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
			int j = golem.getHoldRoseTick();
			
			if (j > 0) {
				this.armRightTop.rotateAngleX = ((-0.8F + 0.025F * this.func_78172_a((float)j, 100.0F)));
				this.armRightMiddle.rotateAngleX = ((-0.8F + 0.025F * this.func_78172_a((float)j, 100.0F)) + -25.562F);
				this.armRightBottom.rotateAngleX = ((-0.8F + 0.025F * this.func_78172_a((float)j, 100.0F)) + -25.562F);
				
				this.armLeftTop.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3;
				this.armLeftMiddle.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -25.562F;
				this.armLeftBottom.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -25.562F;
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
}

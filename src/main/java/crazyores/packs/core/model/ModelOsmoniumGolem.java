package crazyores.packs.core.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import crazyores.packs.core.entity.golem.EntityOsmoniumGolem;

public class ModelOsmoniumGolem extends ModelBase {

	public ModelRenderer golemHead;
	public ModelRenderer golemChest;
	public ModelRenderer golemMiddle;
	public ModelRenderer golemBottom;
	public ModelRenderer armRightTop;
	public ModelRenderer armRightTopMiddle;
	public ModelRenderer armRightBottomMiddle;
	public ModelRenderer armRightBottom;
	public ModelRenderer armLeftTop;
	public ModelRenderer armLeftTopMiddle;
	public ModelRenderer armLeftBottomMiddle;
	public ModelRenderer armLeftBottom;
	public ModelRenderer legRightTop;
	public ModelRenderer legRightMiddle;
	public ModelRenderer legRightBottom;
	public ModelRenderer legLeftTop;
	public ModelRenderer legLeftMiddle;
	public ModelRenderer legLeftBottom;

	public ModelOsmoniumGolem() {
		textureWidth = 256;
		textureHeight = 256;

		golemHead = new ModelRenderer(this);
		golemHead.setRotationPoint(-0.5F, -34F, 0F);
		golemHead.setTextureOffset(0, 0).addBox(-5F, -10F, -5F, 11, 13, 11);
		golemHead.setTextureOffset(34, 0).addBox(-1F, -1F, -7F, 3, 5, 2);
		golemHead.setTextureSize(textureWidth, textureHeight);
		golemHead.mirror = true;
		setRotation(golemHead, 0F, 0F, 0F);

		golemChest = new ModelRenderer(this, 0, 25);
		golemChest.setRotationPoint(-10F, -33F, 0F);
		golemChest.addBox(-4F, 0F, -2F, 28, 18, 18);
		golemChest.setTextureSize(textureWidth, textureHeight);
		golemChest.mirror = true;
		setRotation(golemChest, -0.5576792F, 0F, 0F);
		
		golemMiddle = new ModelRenderer(this, 0, 62);
		golemMiddle.setRotationPoint(-11F, -17F, -4F);
		golemMiddle.addBox(0F, 0F, 0F, 22, 12, 12);
		golemMiddle.setTextureSize(textureWidth, textureHeight);
		golemMiddle.mirror = true;
		setRotation(golemMiddle, 0F, 0F, 0F);
		
		golemBottom = new ModelRenderer(this, 0, 87);
		golemBottom.setRotationPoint(-8F, -8F, -3F);
		golemBottom.addBox(0F, 0F, 0F, 16, 12, 10);
		golemBottom.setTextureSize(textureWidth, textureHeight);
		golemBottom.mirror = true;
		setRotation(golemBottom, -0.0371786F, 0F, 0F);

		armRightTop = new ModelRenderer(this, 131, 4);
		armRightTop.setRotationPoint(-19.5F, -26.3F, -3F);
		armRightTop.addBox(0F, 0F, -1F, 6, 19, 9);
		armRightTop.setTextureSize(textureWidth, textureHeight);
		armRightTop.mirror = true;
		setRotation(armRightTop, 0.1115358F, 0F, 0F);
		
		armRightTopMiddle = new ModelRenderer(this, 131, 33);
		armRightTopMiddle.setRotationPoint(-19F, -26.3F, -3F);
		armRightTopMiddle.addBox(0F, 12.3F, 8.3F, 5, 10, 8);
		armRightTopMiddle.setTextureSize(textureWidth, textureHeight);
		armRightTopMiddle.mirror = true;
		setRotation(armRightTopMiddle, -0.4461411F, 0F, 0F);
		
		armRightBottomMiddle = new ModelRenderer(this, 131, 52);
		armRightBottomMiddle.setRotationPoint(-19.5F, -26.3F, -3F);
		armRightBottomMiddle.addBox(0F, 15F, 14F, 6, 10, 8);
		armRightBottomMiddle.setTextureSize(textureWidth, textureHeight);
		armRightBottomMiddle.mirror = true;
		setRotation(armRightBottomMiddle, -0.7679449F, 0F, 0F);
		
		armRightBottom = new ModelRenderer(this, 131, 71);
		armRightBottom.setRotationPoint(-19.5F, -26.3F, -3F);
		armRightBottom.addBox(-0.5F, 17F, 16F, 7, 13, 8);
		armRightBottom.setTextureSize(textureWidth, textureHeight);
		armRightBottom.mirror = true;
		setRotation(armRightBottom, -0.8726646F, 0F, 0F);
		
		armLeftTop = new ModelRenderer(this, 100, 4);
		armLeftTop.setRotationPoint(19.5F, -26.3F, -3F);
		armLeftTop.addBox(-6F, 0F, -1F, 6, 19, 9);
		armLeftTop.setTextureSize(textureWidth, textureHeight);
		armLeftTop.mirror = true;
		setRotation(armLeftTop, 0.111544F, 0F, 0F);
		
		armLeftTopMiddle = new ModelRenderer(this, 104, 33);
		armLeftTopMiddle.setRotationPoint(19.5F, -26.3F, -3F);
		armLeftTopMiddle.addBox(-5.5F, 12.3F, 8.333333F, 5, 10, 8);
		armLeftTopMiddle.setTextureSize(textureWidth, textureHeight);
		armLeftTopMiddle.mirror = true;
		setRotation(armLeftTopMiddle, -0.4461411F, 0F, 0F);
		
		armLeftBottomMiddle = new ModelRenderer(this, 102, 52);
		armLeftBottomMiddle.setRotationPoint(19.5F, -26.3F, -3F);
		armLeftBottomMiddle.addBox(-6F, 15F, 14F, 6, 10, 8);
		armLeftBottomMiddle.setTextureSize(textureWidth, textureHeight);
		armLeftBottomMiddle.mirror = true;
		setRotation(armLeftBottomMiddle, -0.7679449F, 0F, 0F);
		
		armLeftBottom = new ModelRenderer(this, 100, 71);
		armLeftBottom.setRotationPoint(19.5F, -26.3F, -3F);
		armLeftBottom.addBox(-6.5F, 17F, 16F, 7, 13, 8);
		armLeftBottom.setTextureSize(textureWidth, textureHeight);
		armLeftBottom.mirror = true;
		setRotation(armLeftBottom, -0.8726646F, 0F, 0F);

		legRightTop = new ModelRenderer(this, 131, 99);
		legRightTop.setRotationPoint(-8.5F, 2F, 0.5F);
		legRightTop.addBox(-2.1F, 0F, -0.8F, 7, 13, 6);
		legRightTop.setTextureSize(textureWidth, textureHeight);
		legRightTop.mirror = true;
		setRotation(legRightTop, -0.2974216F, 0.1487164F, 0F);
		
		legRightMiddle = new ModelRenderer(this, 131, 119);
		legRightMiddle.setRotationPoint(-8.5F, 2F, 0.5F);
		legRightMiddle.addBox(-1.6F, 8.5F, -5.5F, 6, 7, 6);
		legRightMiddle.setTextureSize(textureWidth, textureHeight);
		legRightMiddle.mirror = true;
		setRotation(legRightMiddle, 0F, 0.1487195F, 0F);
		
		legRightBottom = new ModelRenderer(this, 131, 133);
		legRightBottom.setRotationPoint(-8.5F, 2F, 0.5F);
		legRightBottom.addBox(-4F, 14F, -5.3F, 10, 8, 9);
		legRightBottom.setTextureSize(textureWidth, textureHeight);
		legRightBottom.mirror = true;
		setRotation(legRightBottom, 0F, 0.1487195F, 0F);
		
		legLeftTop = new ModelRenderer(this, 104, 99);
		legLeftTop.setRotationPoint(8.5F, 2F, 0.5F);
		legLeftTop.addBox(-4F, 0F, -0.8F, 7, 13, 6);
		legLeftTop.setTextureSize(textureWidth, textureHeight);
		legLeftTop.mirror = true;
		setRotation(legLeftTop, -0.2974216F, -0.1487195F, 0F);
		
		legLeftMiddle = new ModelRenderer(this, 106, 119);
		legLeftMiddle.setRotationPoint(8.5F, 2F, 0.5F);
		legLeftMiddle.addBox(-3.5F, 8.5F, -5.5F, 6, 7, 6);
		legLeftMiddle.setTextureSize(textureWidth, textureHeight);
		legLeftMiddle.mirror = true;
		setRotation(legLeftMiddle, 0F, -0.1487195F, 0F);
		
		legLeftBottom = new ModelRenderer(this, 92, 133);
		legLeftBottom.setRotationPoint(8.5F, 2F, 0.5F);
		legLeftBottom.addBox(-5.1F, 14F, -5.3F, 10, 8, 9);
		legLeftBottom.setTextureSize(textureWidth, textureHeight);
		legLeftBottom.mirror = true;
		setRotation(legLeftBottom, 0F, -0.1487195F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		golemHead.render(f5);
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

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.golemHead.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.golemHead.rotateAngleX = f4 / (180F / (float)Math.PI);
		this.legLeftTop.rotateAngleX = -1.5F * this.func_78172_a(f, 13.0F) * f1 + -0.2974216F;
		this.legLeftMiddle.rotateAngleX = -1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.legLeftBottom.rotateAngleX = -1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.legRightTop.rotateAngleX = 1.5F * this.func_78172_a(f, 13.0F) * f1 + -0.2974216F;
		this.legRightMiddle.rotateAngleX = 1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.legRightBottom.rotateAngleX = 1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.legLeftTop.rotateAngleY = -0.1487195F;
		this.legLeftMiddle.rotateAngleY = -0.1487195F;
		this.legLeftBottom.rotateAngleY = -0.1487195F;
		this.legRightTop.rotateAngleY = 0.1487164F;
		this.legRightMiddle.rotateAngleY = 0.1487195F;
		this.legRightBottom.rotateAngleY = 0.1487195F;
	}

	public float func_78172_a(float par1, float par2) {
		return (Math.abs(par1 % par2 - par2 * 0.5F) - par2 * 0.25F) / (par2 * 0.25F);
	}

	/**
	 * Used for easily adding entity-dependent animations. The second and third float params here are the same second
	 * and third as in the setRotationAngles method.
	 */
	public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
		EntityOsmoniumGolem golem = (EntityOsmoniumGolem)par1EntityLivingBase;
		int i = golem.getAttackTimer();

		if (i > 0) {
			this.armRightTop.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + 0.111544F;
			this.armRightTopMiddle.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -0.4461411F;
			this.armRightBottomMiddle.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -0.7679449F;
			this.armRightBottom.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -0.8726646F;
			
			this.armLeftTop.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + 0.111544F;
			this.armLeftTopMiddle.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -0.4461411F;
			this.armLeftBottomMiddle.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -0.7679449F;
			this.armLeftBottom.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F) + -0.8726646F;
		}
		else {
			int j = golem.getHoldRoseTick();
			
			if (j > 0) {
				this.armRightTop.rotateAngleX = (-0.5F + 0.025F * this.func_78172_a((float)j, 100.0F)) + 0.111544F;
				this.armRightTopMiddle.rotateAngleX = (-0.5F + 0.025F * this.func_78172_a((float)j, 100.0F)) + -0.4461411F;
				this.armRightBottomMiddle.rotateAngleX = (-0.5F + 0.025F * this.func_78172_a((float)j, 100.0F)) + -0.7679449F;
				this.armRightBottom.rotateAngleX = (-0.5F + 0.025F * this.func_78172_a((float)j, 100.0F)) + -0.8726646F;
				
				this.armLeftTop.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + 0.111544F;
				this.armLeftTopMiddle.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -0.4461411F;
				this.armLeftBottomMiddle.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -0.7679449F;
				this.armLeftBottom.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -0.8726646F;
			}
			else {
				this.armRightTop.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + 0.111544F;
				this.armRightTopMiddle.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -0.4461411F;
				this.armRightBottomMiddle.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -0.7679449F;
				this.armRightBottom.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -0.8726646F;
				
				this.armLeftTop.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + 0.111544F;
				this.armLeftTopMiddle.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -0.4461411F;
				this.armLeftBottomMiddle.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -0.7679449F;
				this.armLeftBottom.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -0.8726646F;
			}
		}
	}
}
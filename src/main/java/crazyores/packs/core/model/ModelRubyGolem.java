package crazyores.packs.core.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import crazyores.packs.core.entity.golem.EntityRubyGolem;

public class ModelRubyGolem extends ModelBase {
	
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

	public ModelRubyGolem() {
		textureWidth = 128;
		textureHeight = 128;

		golemChest = new ModelRenderer(this, 0, 20);
		golemChest.setTextureSize(textureWidth, textureHeight);
		golemChest.setRotationPoint(-7F, -15F, -7F);
		golemChest.addBox(-4F, 0F, -2F, 22, 15, 13);
		golemChest.mirror = true;
		setRotation(golemChest, 0.3346075F, 0F, 0F);

		golemHead = new ModelRenderer(this);
		golemHead.setTextureSize(textureWidth, textureHeight);
		golemHead.setRotationPoint(0F, -17F, -1F);
		golemHead.setTextureOffset(0, 0).addBox(-4F, -10F, -5F, 8, 10, 8);
		golemHead.setTextureOffset(24, 0).addBox(-1F, -3F, -7F, 2, 4, 2);
		golemHead.mirror = true;
		setRotation(golemHead, 0F, 0F, 0F);


		golemMiddle = new ModelRenderer(this, 0, 51);
		golemMiddle.setTextureSize(textureWidth, textureHeight);
		golemMiddle.setRotationPoint(-7F, -4F, -3F);
		golemMiddle.addBox(0F, 0F, 0F, 14, 12, 9);
		golemMiddle.mirror = true;
		setRotation(golemMiddle, 0F, 0F, 0F);
		
		legRightTop = new ModelRenderer(this, 29, 74);
		legRightTop.setTextureSize(textureWidth, textureHeight);
		legRightTop.setRotationPoint(-6.5F, 6F, 0.5F);
		legRightTop.addBox(-2F, 0F, -1F, 6, 8, 5);
		legRightTop.mirror = true;
		setRotation(legRightTop, -0.2974216F, 0.1487164F, 0F);
		
		legLeftTop = new ModelRenderer(this, 4, 74);
		legLeftTop.setTextureSize(textureWidth, textureHeight);
		legLeftTop.setRotationPoint(6.5F, 6F, 0.5F);
		legLeftTop.addBox(-4F, 0F, -1F, 6, 8, 5);
		legLeftTop.mirror = true;
		setRotation(legLeftTop, -0.2974216F, -0.1487195F, 0F);
		
		legRightMiddle = new ModelRenderer(this, 29, 89);
		legRightMiddle.setTextureSize(textureWidth, textureHeight);
		legRightMiddle.setRotationPoint(-6.5F, 6F, 0.5F);
		legRightMiddle.addBox(-1.5F, 7F, -3.5F, 5, 4, 5);
		legRightMiddle.mirror = true;
		setRotation(legRightMiddle, 0F, 0.1115358F, 0F);
		
		legLeftMiddle = new ModelRenderer(this, 6, 89);
		legLeftMiddle.setTextureSize(textureWidth, textureHeight);
		legLeftMiddle.setRotationPoint(6.5F, 6F, 0.5F);
		legLeftMiddle.addBox(-3.5F, 7F, -3.5F, 5, 4, 5);
		legLeftMiddle.mirror = true;
		setRotation(legLeftMiddle, 0F, -0.111544F, 0F);
		
		legRightBottom = new ModelRenderer(this, 29, 100);
		legRightBottom.setTextureSize(textureWidth, textureHeight);
		legRightBottom.setRotationPoint(-6.5F, 6F, 0.5F);
		legRightBottom.addBox(-2.8F, 10F, -4.3F, 7, 8, 6);
		legRightBottom.mirror = true;
		setRotation(legRightBottom, 0F, 0F, 0F);
		
		legLeftBottom = new ModelRenderer(this, 0, 100);
		legLeftBottom.setTextureSize(textureWidth, textureHeight);
		legLeftBottom.setRotationPoint(6.5F, 6F, 0.5F);
		legLeftBottom.addBox(-4.3F, 10F, -4.3F, 7, 8, 6);
		legLeftBottom.mirror = true;
		setRotation(legLeftBottom, 0F, 0F, 0F);
		
		armRightTop = new ModelRenderer(this, 100, 4);
		armRightTop.setTextureSize(textureWidth, textureHeight);
		armRightTop.setRotationPoint(-15.5F, -13.3F, -4F);
		armRightTop.addBox(0F, 0F, 0F, 5, 17, 6);
		armRightTop.mirror = true;
		setRotation(armRightTop, 0.1115358F, 0.0743572F, 0.0371786F);
		
		armLeftTop = new ModelRenderer(this, 75, 4);
		armLeftTop.setTextureSize(textureWidth, textureHeight);
		armLeftTop.setRotationPoint(10.5F, -13.3F, -4F);
		armLeftTop.addBox(0F, 0F, 0F, 5, 17, 6);
		armLeftTop.mirror = true;
		setRotation(armLeftTop, 0.111544F, -0.074351F, -0.0371755F);
		
		armRightMiddle = new ModelRenderer(this, 100, 29);
		armRightMiddle.setTextureSize(textureWidth, textureHeight);
		armRightMiddle.setRotationPoint(-15.5F, -13.3F, -4F);
		armRightMiddle.addBox(0.5F, 10.3F, 7F, 4, 9, 6);
		armRightMiddle.mirror = true;
		setRotation(armRightMiddle, -0.4461411F, 0.074351F, 0.0371755F);
		
		armLeftMiddle = new ModelRenderer(this, 77, 29);
		armLeftMiddle.setTextureSize(textureWidth, textureHeight);
		armLeftMiddle.setRotationPoint(10.5F, -13.3F, -4F);
		armLeftMiddle.addBox(0.5F, 10.3F, 7F, 4, 9, 6);
		armLeftMiddle.mirror = true;
		setRotation(armLeftMiddle, -0.4461411F, -0.074351F, -0.0371755F);
		
		armRightBottom = new ModelRenderer(this, 100, 46);
		armRightBottom.setTextureSize(textureWidth, textureHeight);
		armRightBottom.setRotationPoint(-15.5F, -13.3F, -4F);
		armRightBottom.addBox(-0.8F, 16F, 7.3F, 5, 13, 6);
		armRightBottom.mirror = true;
		setRotation(armRightBottom, -0.4461411F, 0F, 0F);
		
		armLeftBottom = new ModelRenderer(this, 75, 46);
		armLeftBottom.setTextureSize(textureWidth, textureHeight);
		armLeftBottom.setRotationPoint(10.5F, -13.3F, -4F);
		armLeftBottom.addBox(0.8F, 16F, 7.5F, 5, 13, 6);
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
		this.legLeftTop.rotateAngleX = -1.5F * this.func_78172_a(f, 13.0F) * f1 + -0.2974216F;	
		this.legLeftMiddle.rotateAngleX = -1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.legLeftBottom.rotateAngleX = -1.5F * this.func_78172_a(f, 13.0F) * f1;	
		this.legRightTop.rotateAngleX = 1.5F * this.func_78172_a(f, 13.0F) * f1 + -0.2974216F;	
		this.legRightMiddle.rotateAngleX = 1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.legRightBottom.rotateAngleX = 1.5F * this.func_78172_a(f, 13.0F) * f1;	
		this.legLeftTop.rotateAngleY = -0.1487195F;	
		this.legLeftMiddle.rotateAngleY = -0.111544F;	
		this.legLeftBottom.rotateAngleY = 0.0F;	
		this.legRightTop.rotateAngleY = 0.1487164F;
		this.legRightMiddle.rotateAngleY = 0.1115358F;
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
		
		EntityRubyGolem golem = (EntityRubyGolem) entity;
		int i = golem.getAttackTimer();

		if (i > 0) {
			this.armRightTop.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float) i - par4, 10.0F) + 6.391F;
			this.armRightMiddle.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float) i - par4, 10.0F) + -25.562F;
			this.armRightBottom.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float) i - par4, 10.0F) + -25.562F;
			
			this.armLeftTop.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float) i - par4, 10.0F) + 6.391F;
			this.armLeftMiddle.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float) i - par4, 10.0F) + -25.562F;
			this.armLeftBottom.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float) i - par4, 10.0F) + -25.562F;
		} 
		else {
			int j = golem.getHoldRoseTick();

			if (j > 0) {
				this.armRightTop.rotateAngleX = (-0.8F + 0.025F * this.func_78172_a((float) j, 100.0F)) + 6.391F;
				this.armRightMiddle.rotateAngleX = (-0.8F + 0.025F * this.func_78172_a((float) j, 100.0F)) + -25.562F;
				this.armRightBottom.rotateAngleX = (-0.8F + 0.025F * this.func_78172_a((float) j, 100.0F)) + -25.562F;
				this.armRightBottom.rotateAngleY = (0.05F * this.func_78172_a((float) i - par4, 100.0F));

				this.armLeftTop.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + 6.391F;
				this.armLeftMiddle.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -25.562F;
				this.armLeftBottom.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -25.562F;
				this.armLeftBottom.rotateAngleY = (0.05F * this.func_78172_a(par2, 13.0F));
			} 
			else {
				this.armRightTop.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + 6.391F;
				this.armRightMiddle.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -25.562F;
				this.armRightBottom.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -25.562F;
				
				this.armLeftTop.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + 6.391F;
				this.armLeftMiddle.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -25.562F;
				this.armLeftBottom.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3 + -25.562F;
			}
		}
	}
}
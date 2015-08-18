package crazyores.packs.core.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import crazyores.packs.core.entity.golem.EntityCopperGolem;

public class ModelCopperGolem extends ModelBase
{
	public ModelRenderer golemMiddle;
	public ModelRenderer golemHead;
	public ModelRenderer body;
	public ModelRenderer rightArm;
	public ModelRenderer leftArm;
	public ModelRenderer rightLeg;
	public ModelRenderer leftLeg;
	
	public ModelCopperGolem() {
		textureWidth = 128;
		textureHeight = 128;

		golemHead = new ModelRenderer(this);
		golemHead.setTextureSize(textureWidth, textureHeight);
		golemHead.setRotationPoint(0F, -11F, -1F);
		golemHead.setTextureOffset(0, 0).addBox(-4F, -10F, -5F, 8, 10, 8);
		golemHead.setTextureOffset(24, 0).addBox(-1F, -3F, -7F, 2, 4, 2);
		
		golemMiddle = new ModelRenderer(this, 0, 70);
		golemMiddle.setTextureSize(textureWidth, textureHeight);
		golemMiddle.setRotationPoint(-5F, 0F, -1.5F);
		golemMiddle.addBox(0F, 0F, 0F, 10, 9, 6);
		golemMiddle.mirror = true;
		setRotation(golemMiddle, 0F, 0F, 0F);
		
		body = new ModelRenderer(this, 0, 40);
		body.setTextureSize(textureWidth, textureHeight);
		body.setRotationPoint(-5F, -11F, -4F);
		body.addBox(-4F, 0F, -2F, 18, 12, 11);
		body.mirror = true;
		setRotation(body, 0.2230717F, 0F, 0F);
		
		rightArm = new ModelRenderer(this, 60, 21);
		rightArm.setTextureSize(textureWidth, textureHeight);
		rightArm.setRotationPoint(-10F, -7F, 0F);
		rightArm.addBox(-3F, -3F, -2F, 4, 28, 6);
		rightArm.mirror = true;
		setRotation(rightArm, 0F, 0F, 0F);
		
		leftArm = new ModelRenderer(this, 60, 58);
		leftArm.setTextureSize(textureWidth, textureHeight);
		leftArm.setRotationPoint(10F, -7F, 0F);
		leftArm.addBox(-1F, -2F, -2F, 4, 28, 6);
		leftArm.mirror = true;
		setRotation(leftArm, 0F, 0F, 0F);
		
		rightLeg = new ModelRenderer(this, 37, 0);
		rightLeg.setTextureSize(textureWidth, textureHeight);
		rightLeg.setRotationPoint(-5F, 8F, 0F);
		rightLeg.addBox(-2F, 0F, -2F, 6, 16, 5);
		rightLeg.mirror = true;
		setRotation(rightLeg, 0F, 0F, 0F);
		
		leftLeg = new ModelRenderer(this, 60, 0);
		leftLeg.setTextureSize(textureWidth, textureHeight);
		leftLeg.addBox(-1F, 0F, -2F, 6, 16, 5);
		leftLeg.setRotationPoint(2F, 8F, 0F);
		leftLeg.mirror = true;
		setRotation(leftLeg, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		golemHead.render(f5);
		golemMiddle.render(f5);
		body.render(f5);
		rightArm.render(f5);
		leftArm.render(f5);
		rightLeg.render(f5);
		leftLeg.render(f5);
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
		this.leftLeg.rotateAngleX = -1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.rightLeg.rotateAngleX = 1.5F * this.func_78172_a(f, 13.0F) * f1;
		this.leftLeg.rotateAngleY = 0.0F;
		this.rightLeg.rotateAngleY = 0.0F;
	}

	/**
	 * Used for easily adding entity-dependent animations. The second and third float params here are the same second
	 * and third as in the setRotationAngles method.
	 */
	public void setLivingAnimations(EntityLivingBase entity, float par2, float par3, float par4) {
		EntityCopperGolem golem = (EntityCopperGolem)entity;
		int i = golem.getAttackTimer();

		if (i > 0) {
			this.rightArm.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F);
			this.leftArm.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - par4, 10.0F);
		}
		else {
			int j = golem.getHoldRoseTick();
			
			if (j > 0) {
                this.rightArm.rotateAngleX = -0.8F + 0.025F * this.func_78172_a((float)j, 70.0F);
                this.leftArm.rotateAngleX = 0.0F;
            }
			else {
				this.rightArm.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(par2, 13.0F)) * par3;
				this.leftArm.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(par2, 13.0F)) * par3;
			}
		}
	}

	private float func_78172_a(float par1, float par2) {
		return (Math.abs(par1 % par2 - par2 * 0.5F) - par2 * 0.25F) / (par2 * 0.25F);
	}

}
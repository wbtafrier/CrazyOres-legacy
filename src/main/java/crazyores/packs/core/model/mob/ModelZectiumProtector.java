package crazyores.packs.core.model.mob;

import crazyores.packs.core.entity.golem.EntityCopperGolem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class ModelZectiumProtector extends ModelBase {

	private ModelRenderer mainBody;
	private ModelRenderer propeller1;
	private ModelRenderer lowerBody;
	private ModelRenderer propeller2;

	public ModelZectiumProtector() {
		textureWidth = 128;
		textureHeight = 128;

		mainBody = new ModelRenderer(this, 0, 109);
		mainBody.addBox(-7F, 0F, -7F, 14, 3, 14);
		mainBody.setRotationPoint(0F, 16F, 0F);
		mainBody.setTextureSize(128, 128);
		mainBody.mirror = true;
		setRotation(mainBody, 0F, 0F, 0F);
		
		propeller1 = new ModelRenderer(this, 0, 54);
		propeller1.addBox(-2F, 0F, -15F, 4, 1, 30);
		propeller1.setRotationPoint(0F, 21F, 0F);
		propeller1.setTextureSize(128, 128);
		propeller1.mirror = true;
		setRotation(propeller1, 0F, 0F, 0F);
		
		lowerBody = new ModelRenderer(this, 0, 0);
		lowerBody.addBox(-9F, 0F, -9F, 18, 34, 18);
		lowerBody.setRotationPoint(0F, -18F, 0F);
		lowerBody.setTextureSize(128, 128);
		lowerBody.mirror = true;
		setRotation(lowerBody, 0F, 0F, 0F);
		
		propeller2 = new ModelRenderer(this, 0, 92);
		propeller2.addBox(-10F, 0F, -2F, 20, 1, 4);
		propeller2.setRotationPoint(0F, 23F, 0F);
		propeller2.setTextureSize(128, 128);
		propeller2.mirror = true;
		setRotation(propeller2, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		mainBody.render(f5);
		propeller1.render(f5);
		lowerBody.render(f5);
		propeller2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void setLivingAnimations(EntityLivingBase entity, float par2, float par3, float par4) {
		this.propeller1.rotateAngleY = (this.propeller1.rotateAngleY + 0.08f) % 360;
		this.propeller2.rotateAngleY = (this.propeller2.rotateAngleY + 0.2f) % 360;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}

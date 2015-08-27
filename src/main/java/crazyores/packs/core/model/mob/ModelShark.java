package crazyores.packs.core.model.mob;

import crazyores.packs.core.entity.mob.EntityShark;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class ModelShark extends ModelBase {

	private ModelRenderer leftFlipper;
	private ModelRenderer rightFlipper;
	private ModelRenderer head;
	private ModelRenderer topFin1;
	private ModelRenderer tailTop;
	private ModelRenderer tailBottom;
	private ModelRenderer back2;
	private ModelRenderer tailConnector;
	private ModelRenderer back1;
	private ModelRenderer mainBody;
	private ModelRenderer lowerJaw;
	
	private final float JAW_ROTATION;
	private final float HEAD_ROTATION;
	
	public ModelShark() {
		textureWidth = 256;
		textureHeight = 256;

		leftFlipper = new ModelRenderer(this, 110, 2);
		leftFlipper.addBox(-18F, -1F, 0F, 18, 2, 15);
		leftFlipper.setRotationPoint(-10F, 11F, -5F);
		leftFlipper.setTextureSize(256, 256);
		leftFlipper.mirror = true;
		setRotation(leftFlipper, -0.0371755F, 0.2230705F, -0.260246F);

		rightFlipper = new ModelRenderer(this, 180, 2);
		rightFlipper.addBox(0F, -1F, 0F, 18, 2, 15);
		rightFlipper.setRotationPoint(10F, 11F, -5F);
		rightFlipper.setTextureSize(256, 256);
		rightFlipper.mirror = true;
		setRotation(rightFlipper, -0.0371786F, -0.2230717F, 0.2602503F);

		head = new ModelRenderer(this, 4, 3);
		head.addBox(-8F, -7F, -6F, 16, 10, 12);
		head.setRotationPoint(0F, 11F, -16F);
		head.setTextureSize(256, 256);
		head.mirror = true;
		setRotation(head, 0.0371786F, 0F, 0F);

		topFin1 = new ModelRenderer(this, 84, 41);
		topFin1.addBox(-1.5F, -9F, -7F, 3, 16, 14);
		topFin1.setRotationPoint(0F, 0F, 4F);
		topFin1.setTextureSize(256, 256);
		topFin1.mirror = true;
		setRotation(topFin1, -0.4833219F, 0F, 0F);

		tailBottom = new ModelRenderer(this, 222, 132);
		tailBottom.addBox(-1.5F, -8F, -4F, 3, 16, 8);
		tailBottom.setRotationPoint(0.2F, 18F, 48F);
		tailBottom.setTextureSize(64, 32);
		tailBottom.mirror = true;
		setRotation(tailBottom, 0.8179294F, 0F, 0F);

		tailTop = new ModelRenderer(this, 200, 100);
		tailTop.addBox(-1F, -5F, -10F, 2, 10, 20);
		tailTop.setRotationPoint(0F, 8F, 48F);
		tailTop.setTextureSize(64, 32);
		tailTop.mirror = true;
		setRotation(tailTop, 1.061656F, 0F, 0F);

		back2 = new ModelRenderer(this, 187, 132);
		back2.addBox(-4F, -4F, -4F, 8, 8, 8);
		back2.setRotationPoint(0F, 16F, 43F);
		back2.setTextureSize(64, 32);
		back2.mirror = true;
		setRotation(back2, -0.0407999F, 0F, 0F);

		tailConnector = new ModelRenderer(this, 141, 106);
		tailConnector.addBox(-8F, -6F, -6F, 16, 12, 12);
		tailConnector.setRotationPoint(0F, 14F, 35F);
		tailConnector.setTextureSize(64, 32);
		tailConnector.mirror = true;
		setRotation(tailConnector, -0.2039995F, 0F, 0F);

		back1 = new ModelRenderer(this, 100, 74);
		back1.addBox(-10F, -7F, -7F, 20, 14, 16);
		back1.setRotationPoint(0F, 12F, 21F);
		back1.setTextureSize(64, 32);
		back1.mirror = true;
		setRotation(back1, -0.1223997F, 0F, 0F);

		mainBody = new ModelRenderer(this, 21, 73);
		mainBody.addBox(-11F, -14F, -8F, 22, 28, 16);
		mainBody.setRotationPoint(0F, 11F, 2F);
		mainBody.setTextureSize(64, 32);
		mainBody.mirror = true;
		setRotation(mainBody, 1.570796F, 0F, 0F);

		lowerJaw = new ModelRenderer(this, 4, 27);
		lowerJaw.addBox(-7F, -1F, -12F, 14, 2, 12);
		lowerJaw.setRotationPoint(0F, 16F, -12F);
		lowerJaw.setTextureSize(256, 256);
		lowerJaw.mirror = true;
		setRotation(lowerJaw, -0.052363F, 0F, 0F);
		
		JAW_ROTATION = lowerJaw.rotateAngleX;
		HEAD_ROTATION = head.rotateAngleX;
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		leftFlipper.render(f5);
		rightFlipper.render(f5);
		head.render(f5);
		topFin1.render(f5);
		tailTop.render(f5);
		tailBottom.render(f5);
		back2.render(f5);
		tailConnector.render(f5);
		back1.render(f5);
		mainBody.render(f5);
		lowerJaw.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
	
	@Override
	public void setLivingAnimations(EntityLivingBase entity, float par2, float par3, float par4) {
		if (entity instanceof EntityShark) {
			EntityShark shark = (EntityShark)entity;
			
			head.rotateAngleX = (float) (HEAD_ROTATION + shark.getTopJawRotation());
			lowerJaw.rotateAngleX = (float) (JAW_ROTATION + shark.getBottomJawRotation());
		}
	}
}

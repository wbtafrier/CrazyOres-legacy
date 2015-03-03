//package crazyores.packs.core.model;
//
//import net.minecraft.client.model.ModelBase;
//import net.minecraft.client.model.ModelRenderer;
//import net.minecraft.entity.Entity;
//
//public class ModelTapaziteCrystal extends ModelBase
//{
//	public ModelTapaziteObelisk[] obelisks;
//	private ModelRenderer obelisk1;
//	private ModelRenderer obelisk2;
//	private ModelRenderer obelisk3;
//	private ModelRenderer obelisk4;
//	ModelRenderer obelisk5;
//	
//	public int obeliskGrowthHeight;
//
//	public ModelTapaziteCrystal(ModelTapaziteObeliskHelper obeliskHelper) {
//		
//		obelisks = obeliskHelper.getObelisks();
//		
////		for (int i = 0; i < obelisks.length; i++) {
////			
////			obelisk.setTextureSize(obelisks[i].textureWidth, obelisks[i].textureHeight);
////			obelisk = new ModelRenderer(this, obelisks[i].textureOffsetX, obelisks[i].textureOffsetY);
////			
////			obelisk.addBox(obelisks[i].ballOffsetPoint[0], obelisks[i].ballOffsetPoint[1], obelisks[i].ballOffsetPoint[2], obelisks[i].boxBounds[0], obelisks[i].boxBounds[1], obelisks[i].boxBounds[2]);
////			obelisk.setRotationPoint(obelisks[i].rotationPoint[0], obelisks[i].rotationPoint[1], obelisks[i].rotationPoint[2]);
////			obelisk.mirror = obelisks[i].mirror;
////			setRotation(obelisk, obelisks[i].obeliskRotation[0], obelisks[i].obeliskRotation[1], obelisks[i].obeliskRotation[2]);
////		}
//		
//		switch (obelisks.length) {
//		
//		case 5:
//			obelisk5 = new ModelRenderer(this, obelisks[4].textureOffsetX, obelisks[4].textureOffsetY);
//			obelisk5.setTextureSize(obelisks[4].textureWidth, obelisks[4].textureHeight);
//			obelisk5.addBox(obelisks[4].ballOffsetPointX, obelisks[4].ballOffsetPointY, obelisks[4].ballOffsetPointZ, obelisks[4].boxBounds[0], obelisks[4].boxBounds[1], obelisks[4].boxBounds[2]);
//			obelisk5.setRotationPoint(obelisks[4].rotationPointX, obelisks[4].rotationPointY, obelisks[4].rotationPointZ);
//			obelisk5.mirror = obelisks[4].mirror;
//			setRotation(obelisk5, obelisks[4].obeliskRotationX, obelisks[4].obeliskRotationY, obelisks[4].obeliskRotationZ);
//		case 4:
//			obelisk4 = new ModelRenderer(this, obelisks[3].textureOffsetX, obelisks[3].textureOffsetY);
//			obelisk4.setTextureSize(obelisks[3].textureWidth, obelisks[3].textureHeight);
//			obelisk4.addBox(obelisks[3].ballOffsetPointX, obelisks[3].ballOffsetPointY, obelisks[3].ballOffsetPointZ, obelisks[3].boxBounds[0], obelisks[3].boxBounds[1], obelisks[3].boxBounds[2]);
//			obelisk4.setRotationPoint(obelisks[3].rotationPointX, obelisks[3].rotationPointY, obelisks[3].rotationPointZ);
//			obelisk4.mirror = obelisks[3].mirror;
//			setRotation(obelisk4, obelisks[3].obeliskRotationX, obelisks[3].obeliskRotationY, obelisks[3].obeliskRotationZ);
//		case 3:
//			obelisk3 = new ModelRenderer(this, obelisks[2].textureOffsetX, obelisks[2].textureOffsetY);
//			obelisk3.setTextureSize(obelisks[2].textureWidth, obelisks[2].textureHeight);
//			obelisk3.addBox(obelisks[2].ballOffsetPointX, obelisks[2].ballOffsetPointY, obelisks[2].ballOffsetPointZ, obelisks[2].boxBounds[0], obelisks[2].boxBounds[1], obelisks[2].boxBounds[2]);
//			obelisk3.setRotationPoint(obelisks[2].rotationPointX, obelisks[2].rotationPointY, obelisks[2].rotationPointZ);
//			obelisk3.mirror = obelisks[2].mirror;
//			setRotation(obelisk3, obelisks[2].obeliskRotationX, obelisks[2].obeliskRotationY, obelisks[2].obeliskRotationZ);
//		case 2:
//			obelisk2 = new ModelRenderer(this, obelisks[1].textureOffsetX, obelisks[1].textureOffsetY);
//			obelisk2.setTextureSize(obelisks[1].textureWidth, obelisks[1].textureHeight);
//			obelisk2.addBox(obelisks[1].ballOffsetPointX, obelisks[1].ballOffsetPointY, obelisks[1].ballOffsetPointZ, obelisks[1].boxBounds[0], obelisks[1].boxBounds[1], obelisks[1].boxBounds[2]);
//			obelisk2.setRotationPoint(obelisks[1].rotationPointX, obelisks[1].rotationPointY, obelisks[1].rotationPointZ);
//			obelisk2.mirror = obelisks[1].mirror;
//			setRotation(obelisk2, obelisks[1].obeliskRotationX, obelisks[1].obeliskRotationY, obelisks[1].obeliskRotationZ);
//		default:
//			obelisk1 = new ModelRenderer(this, obelisks[0].textureOffsetX, obelisks[0].textureOffsetY);
//			obelisk1.setTextureSize(obelisks[0].textureWidth, obelisks[0].textureHeight);
//			obelisk1.addBox(obelisks[0].ballOffsetPointX, obelisks[0].ballOffsetPointY, obelisks[0].ballOffsetPointZ, obelisks[0].boxBounds[0], obelisks[0].boxBounds[1], obelisks[0].boxBounds[2]);
//			obelisk1.setRotationPoint(obelisks[0].rotationPointX, obelisks[0].rotationPointY, obelisks[0].rotationPointZ);
//			obelisk1.mirror = obelisks[0].mirror;
//			setRotation(obelisk1, obelisks[0].obeliskRotationX, obelisks[0].obeliskRotationY, obelisks[0].obeliskRotationZ);
//		}
//		
////		textureWidth = 16;
////		textureHeight = 16;
////
////		bigObelisk = new ModelRenderer(this, 0, 0);
////		bigObelisk.addBox(-3F, -13F, -3F, 6, 14, 6);
////		bigObelisk.setRotationPoint(0F, 24F, 0F);
////		bigObelisk.setTextureSize(16, 16);
////		bigObelisk.setTextureOffset(0, 0);
////		bigObelisk.mirror = true;
////		setRotation(bigObelisk, 0F, 0F, 0F);
//	}
//
//	@Override
//	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
//		super.render(entity, f, f1, f2, f3, f4, f5);
//		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
//		obelisk1.render(f5);
//		
//		switch (obelisks.length) {
//			case 5: obelisk5.render(f5);
//			case 4: obelisk4.render(f5);
//			case 3: obelisk3.render(f5);
//			case 2: obelisk2.render(f5);
//			default:obelisk1.render(f5);
//		}
//	}
//
//	private void setRotation(ModelRenderer model, float x, float y, float z) {
//		model.rotateAngleX = x;
//		model.rotateAngleY = y;
//		model.rotateAngleZ = z;
//	}
//
//	@Override
//	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
//		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
//	}
//}

package crazyores.packs.core.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTapaziteCrystal extends ModelBase
{
  //fields
    ModelRenderer bigObelisk;
    ModelRenderer bigObelisk2;
    ModelRenderer mediumObelisk;
    ModelRenderer mediumObelisk2;
    ModelRenderer smallObelisk;
    ModelRenderer smallObelisk2;
    ModelRenderer smallObelisk3;
  
  public ModelTapaziteCrystal()
  {
    textureWidth = 64;
    textureHeight = 32;
    
    bigObelisk = new ModelRenderer(this, 0, 0);
    bigObelisk.addBox(-2F, -9F, -2F, 4, 10, 4);
    bigObelisk.setRotationPoint(0F, 25F, 0F);
    bigObelisk.setTextureSize(64, 32);
    bigObelisk.mirror = true;
    setRotation(bigObelisk, 0.0F, 0.0F, 0.0F);
    
    
//      bigObelisk = new ModelRenderer(this, 15, 0);
//      bigObelisk.addBox(-2F, -9F, -2F, 4, 10, 4);
//      bigObelisk.setRotationPoint(1F, 25F, 0F);
//      bigObelisk.setTextureSize(64, 32);
//      bigObelisk.mirror = true;
//      setRotation(bigObelisk, 0.2974289F, -2.546735F, -0.2974289F);
//      
//      bigObelisk2 = new ModelRenderer(this, 0, 0);
//      bigObelisk2.addBox(-1.5F, -8F, -1.5F, 3, 8, 3);
//      bigObelisk2.setRotationPoint(-1F, 26F, 0F);
//      bigObelisk2.setTextureSize(64, 32);
//      bigObelisk2.mirror = true;
//      setRotation(bigObelisk2, 0.2974289F, 0.7435722F, -0.2974289F);
//      
//      mediumObelisk = new ModelRenderer(this, 0, 0);
//      mediumObelisk.addBox(-1F, -6F, -1F, 2, 7, 2);
//      mediumObelisk.setRotationPoint(-0.5F, 25F, -1F);
//      mediumObelisk.setTextureSize(64, 32);
//      mediumObelisk.mirror = true;
//      setRotation(mediumObelisk, -0.5576792F, -2.546735F, -0.3346075F);
//      
//      mediumObelisk2 = new ModelRenderer(this, 0, 0);
//      mediumObelisk2.addBox(-1F, -6F, -1F, 2, 7, 2);
//      mediumObelisk2.setRotationPoint(0F, 25F, 1F);
//      mediumObelisk2.setTextureSize(64, 32);
//      mediumObelisk2.mirror = true;
//      setRotation(mediumObelisk2, 0.7807508F, 2.472378F, -0.3346075F);
//      
//      smallObelisk = new ModelRenderer(this, 0, 0);
//      smallObelisk.addBox(-0.5F, -3F, -0.5F, 1, 4, 1);
//      smallObelisk.setRotationPoint(1F, 25F, -3F);
//      smallObelisk.setTextureSize(64, 32);
//      smallObelisk.mirror = true;
//      setRotation(smallObelisk, -0.2230717F, -2.360842F, -0.4461433F);
//      
//      smallObelisk2 = new ModelRenderer(this, 0, 0);
//      smallObelisk2.addBox(-0.5F, -3F, -0.5F, 1, 4, 1);
//      smallObelisk2.setRotationPoint(2F, 25F, 3F);
//      smallObelisk2.setTextureSize(64, 32);
//      smallObelisk2.mirror = true;
//      setRotation(smallObelisk2, -0.2602503F, 1.728805F, -0.7063936F);
//      
//      smallObelisk3 = new ModelRenderer(this, 0, 0);
//      smallObelisk3.addBox(-0.5F, -3F, -0.5F, 1, 4, 1);
//      smallObelisk3.setRotationPoint(-3F, 25F, -1.5F);
//      smallObelisk3.setTextureSize(64, 32);
//      smallObelisk3.mirror = true;
//      setRotation(smallObelisk3, -0.4833219F, -1.728805F, -0.4833219F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    bigObelisk.render(f5);
//    bigObelisk2.render(f5);
//    mediumObelisk.render(f5);
//    mediumObelisk2.render(f5);
//    smallObelisk.render(f5);
//    smallObelisk2.render(f5);
//    smallObelisk3.render(f5);
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
  }

}


package crazyores.packs.core.entity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import org.apache.logging.log4j.Level;

import crazyores.manager.util.CrazyOresLogger;
import crazyores.packs.core.model.ModelTapaziteCrystal;
import crazyores.packs.core.model.ModelTapaziteObeliskHelper;

public class TileEntityTapaziteCrystal extends TileEntity {
	
	private ModelTapaziteObeliskHelper obeliskProperties;
	private ModelTapaziteCrystal crystalModel;
//	private static int idCount = 0;
//	private int entityID;
//	
//	private int obeliskAmount;
//	private List<Integer> bounds = new ArrayList<>();
//	private List<Float> ballOffset = new ArrayList<>();
//	private List<Float> rotationPoint = new ArrayList<>();
//	private List<Float> obeliskRotation = new ArrayList<>();
	
	public TileEntityTapaziteCrystal() {
//		CrazyOresLogger.write(Level.INFO, "CREATING NEW TAPAZITE ENTITY.");
		this.createNewTileEntity();
	}
	
//	public TileEntityTapaziteCrystal(int id) {
//		CrazyOresLogger.write(Level.INFO, "CREATING OLD TAPAZITE ENTITY THAT HAS AN ID.");
//		
//		obeliskProperties = new ModelTapaziteObeliskHelper(obeliskAmount, bounds, ballOffset, rotationPoint, obeliskRotation);
//		crystalModel = new ModelTapaziteCrystal(obeliskProperties);
//	}
	
	private void createNewTileEntity() {
		obeliskProperties = new ModelTapaziteObeliskHelper();
		crystalModel = new ModelTapaziteCrystal(obeliskProperties);
//		entityID = idCount;
//		idCount++;
	}
	
//	private void setEntityID(int id) {
//		entityID = id;
//	}
//	
//	public int getEntityID() {
//		return entityID;
//	}
//	
//	public static int getLastEntityID() {
//		return idCount - 1;
//	}
	
//	@Override
//    public void writeToNBT(NBTTagCompound compound) {
//        super.writeToNBT(compound);
//        
//        CrazyOresLogger.write(Level.INFO, "WRITING NBT DATA!");
//        
//        for (int i = 0; i < crystalModel.obelisks.length; i++) {
//        	compound.setInteger("obeliskAmount", crystalModel.obelisks.length);
//        	
//        	compound.setInteger("boxBoundsX" + i, crystalModel.obelisks[i].boxBounds[0]);
//        	compound.setInteger("boxBoundsY" + i, crystalModel.obelisks[i].boxBounds[1]);
//        	compound.setInteger("boxBoundsZ" + i, crystalModel.obelisks[i].boxBounds[2]);
//        	
//        	compound.setFloat("ballOffsetPointX" + i, crystalModel.obelisks[i].ballOffsetPointX);
//        	compound.setFloat("ballOffsetPointY" + i, crystalModel.obelisks[i].ballOffsetPointY);
//        	compound.setFloat("ballOffsetPointZ" + i, crystalModel.obelisks[i].ballOffsetPointZ);
//        	
//        	compound.setFloat("rotationPointX" + i, crystalModel.obelisks[i].rotationPointX);
//        	compound.setFloat("rotationPointY" + i, crystalModel.obelisks[i].rotationPointY);
//        	compound.setFloat("rotationPointZ" + i, crystalModel.obelisks[i].rotationPointZ);
//        	
//        	compound.setFloat("obeliskRotationX" + i, crystalModel.obelisks[i].obeliskRotationX);
//        	compound.setFloat("obeliskRotationY" + i, crystalModel.obelisks[i].obeliskRotationY);
//        	compound.setFloat("obeliskRotationZ" + i, crystalModel.obelisks[i].obeliskRotationZ);
//        	
//        	compound.setBoolean("mirror" + i, crystalModel.obelisks[i].mirror);
//        }
//        compound.setInteger("crystalID", entityID);
//        compound.setInteger("totalIDs", idCount);
//    }
//	
//	@Override
//	public void readFromNBT(NBTTagCompound compound) {
//		super.readFromNBT(compound);
//		
//		CrazyOresLogger.write(Level.INFO, "READING NBT DATA!");
//		
////		obeliskProperties = new ModelTapaziteObeliskHelper(compound.getInteger("obeliskAmount"));
//		obeliskAmount = compound.getInteger("obeliskAmount");
//		for (int i = 0; i < obeliskAmount; i++) {
//			
//			bounds.add(compound.getInteger("boxBoundsX" + i));
//			bounds.add(compound.getInteger("boxBoundsY" + i));
//			bounds.add(compound.getInteger("boxBoundsZ" + i));
//			
//			ballOffset.add(compound.getFloat("ballOffsetPointX" + i));
//			ballOffset.add(compound.getFloat("ballOffsetPointY" + i));
//			ballOffset.add(compound.getFloat("ballOffsetPointZ" + i));
//			
//			rotationPoint.add(compound.getFloat("rotationPointX" + i));
//			rotationPoint.add(compound.getFloat("rotationPointY" + i));
//			rotationPoint.add(compound.getFloat("rotationPointZ" + i));
//			
//			obeliskRotation.add(compound.getFloat("obeliskRotationX" + i));
//			obeliskRotation.add(compound.getFloat("obeliskRotationY" + i));
//			obeliskRotation.add(compound.getFloat("obeliskRotationZ" + i));
////			obeliskProperties.loadObelisks(compound.getIntArray("boxBounds" + i), ballOffset, rotationPoint, obeliskRotation, compound.getBoolean("mirror" + i), i);
//		}
//		this.entityID = compound.getInteger("crystalID");
//		this.idCount = compound.getInteger("totalIDs");
//	}

	public void updateObelisk(TileEntityTapaziteCrystal entity) {
		this.obeliskProperties.updateObelisk();
		entity.setModel(new ModelTapaziteCrystal(obeliskProperties));
	}
	
	public ModelTapaziteCrystal getModel() {
		return crystalModel;
	}
	
	public void setModel(ModelTapaziteCrystal model) {
		this.crystalModel = model;
	}
	
	public ModelTapaziteObeliskHelper getObelisks() {
		return obeliskProperties;
	}
}

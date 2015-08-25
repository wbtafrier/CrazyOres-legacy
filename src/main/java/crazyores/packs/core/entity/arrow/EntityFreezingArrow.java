package crazyores.packs.core.entity.arrow;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import crazyores.packs.core.entity.FrozenEntity;
import crazyores.packs.core.event.FreezeEvent;
import crazyores.packs.core.item.EnumBowEnhancement;

public class EntityFreezingArrow extends CoreEntityArrow {

	private float freezeRadius;
	private float radiusBonus;
	
	private static final int FREEZE_TIME = 200;
	
	public EntityFreezingArrow(World world) {
        super(world);
        init();
    }

    public EntityFreezingArrow(World world, double x, double y, double z) {
        super(world, x, y, z);
        init();
    }
    
    public EntityFreezingArrow(World world, EntityLivingBase shootingEntity, float speed) {
      super(world, shootingEntity, speed);
      init();
	}

    public EntityFreezingArrow(World world, EntityLivingBase shootingEntity, float speed, EnumBowEnhancement enhancement) {
        super(world, shootingEntity, speed, enhancement);
        init();
    }
    
    public EntityFreezingArrow(World world, EntityLivingBase shootingEntity, double verticalOffset, float speed, EnumBowEnhancement enhancement) {
        super(world, shootingEntity, verticalOffset, speed, enhancement);
        init();
    }
    
    public EntityFreezingArrow(World world, EntityLivingBase shootingEntity, EntityLivingBase idk, float idk2, float idk3) {
        super(world, shootingEntity, idk, idk2, idk3);
        init();
    }
    
    private void init() {
    	radiusBonus = 1.0f;
    	freezeRadius = 3.0f;
    }
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if (!this.worldObj.isRemote) {
			
			if (this.getIsCritical()) {
				radiusBonus = 1.5f;
			}
			
			if (this.movingobjectposition != null && this.movingobjectposition.entityHit != null) {
            	int x = (int)this.movingobjectposition.entityHit.posX;
    			int y = (int)this.movingobjectposition.entityHit.posY;
    			int z = (int)this.movingobjectposition.entityHit.posZ;
    			freeze(x, y, z);
            }
			
			if (worldObj.getBlock((int)Math.round(posX), (int)Math.round(posY), (int)Math.round(posZ)).isAssociatedBlock(Blocks.water)) {
				freeze(posX, posY, posZ);
			}
			else if (inGround) {
				freeze(currentX, currentY, currentZ);
			}
		}
	}
	
	private void freeze(double posX, double posY, double posZ) {
		int curX = (int)Math.round(posX);
		int curY = (int)Math.round(posY);
		int curZ = (int)Math.round(posZ);
		int radius = Math.round(freezeRadius * radiusBonus);
		
		int y = curY;
		boolean isWater = false;
		
		Block b = worldObj.getBlock(curX, y, curZ);
		Block b2 = worldObj.getBlock(curX, y + 1, curZ);
		while (b.isAssociatedBlock(Blocks.water) || b.isAssociatedBlock(Blocks.flowing_water)) {
			y++;
			isWater = true;
			b = worldObj.getBlock(curX, y, curZ);
			b2 = worldObj.getBlock(curX, y + 1, curZ);
			System.out.println("WHILE LOOP: " + curX + " " + y + " " + curZ);
		}
		
		if (isWater) {
			for (int x = -radius + curX; x <= radius + curX; x++) {
				for (int z = -radius + curZ; z <= radius + curZ; z++) {
			
					Block aboveBlock = this.worldObj.getBlock(x, y, z);
					Block currentBlock = this.worldObj.getBlock(x, y - 1, z);
					
//					System.out.println("IF STATEMENT: " + x + " " + y + " " + z);
					if (worldObj.getBlock(x, y - 1, z).isAssociatedBlock(Blocks.water) || worldObj.getBlock(x, y - 1, z).isAssociatedBlock(Blocks.flowing_water)) {
						if (worldObj.getBlock(x, y, z).isAssociatedBlock(Blocks.air)) {
							if (rand.nextInt(this.getEnhancement().equals(EnumBowEnhancement.FIRE) ? 40 : 1) == 0) worldObj.setBlock(x, y - 1, z, Blocks.ice);
						}
						else if (rand.nextInt(this.getEnhancement().equals(EnumBowEnhancement.FIRE) ? 40 : 1) == 0) worldObj.setBlock(x, y, z, Blocks.ice);
					}
				}
			}
		}
		freezeEntities(curX, curY, curZ, radius);
	}
	
	private void freeze(int xCenter, int yCenter, int zCenter) {
		int radius = Math.round(freezeRadius * radiusBonus);
		
		for (int x = -radius + xCenter; x <= radius + xCenter; x++) {
			for (int y = -radius + yCenter; y <= radius + yCenter; y++) {
				for (int z = -radius + zCenter; z <= radius + zCenter; z++) {
					
					Block aboveBlock = this.worldObj.getBlock(x, y + 1, z);
					Block currentBlock = this.worldObj.getBlock(x, y, z);
					Block underBlock = this.worldObj.getBlock(x, y - 1, z);
					
					if ((currentBlock.isAssociatedBlock(Blocks.air) || currentBlock.isAssociatedBlock(Blocks.fire) || currentBlock.isAssociatedBlock(Blocks.tallgrass)) && underBlock.getMaterial().isSolid()) {
						if (rand.nextInt(this.getEnhancement().equals(EnumBowEnhancement.FIRE) ? 30 : 15) == 0) this.worldObj.setBlock(x, y, z, this.getEnhancement().equals(EnumBowEnhancement.FIRE) ? Blocks.flowing_water : Blocks.snow);
						else if (this.rand.nextInt(this.getEnhancement().equals(EnumBowEnhancement.FIRE) ? 40 : 20) == 0) this.worldObj.setBlock(x, y, z, this.getEnhancement().equals(EnumBowEnhancement.FIRE) ? Blocks.flowing_water : Blocks.ice);
						else if (this.rand.nextInt(this.getEnhancement().equals(EnumBowEnhancement.FIRE) ? 10 : 1) == 0) this.worldObj.setBlock(x, y, z, Blocks.snow_layer);
					}
				}
			}
		}
		freezeEntities(xCenter, yCenter, zCenter, radius);
	}
	
	private void freezeEntities(int xCenter, int yCenter, int zCenter, int radius) {
		this.setDead();
		
		List<EntityLivingBase> entitiesInRadius = worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(xCenter - radius, yCenter - radius, zCenter - radius, xCenter + radius, yCenter + radius, zCenter + radius));
		List<FrozenEntity> frozenEntities = new ArrayList<FrozenEntity>();
		
		for (EntityLivingBase e : entitiesInRadius) {
			frozenEntities.add(new FrozenEntity(e, this.getEnhancement().equals(EnumBowEnhancement.FIRE) ? FREEZE_TIME / 8 : FREEZE_TIME));
		}
		FreezeEvent.addEntitiesToList(frozenEntities);
	}
}

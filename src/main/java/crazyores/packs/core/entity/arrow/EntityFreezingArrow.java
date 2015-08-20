package crazyores.packs.core.entity.arrow;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import crazyores.packs.core.entity.FrozenEntity;
import crazyores.packs.core.event.FreezeEvent;
import crazyores.packs.core.item.EnumBowEnhancement;

public class EntityFreezingArrow extends CoreEntityArrow {

	private float freezeRadius;
	private float radiusBonus;
	
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
			
			if (this.inGround) {
				freeze(this.currentX, this.currentY, this.currentZ);
			}
		}
	}
	
	private void freeze(int xCenter, int yCenter, int zCenter) {
		int radius = Math.round(freezeRadius * radiusBonus);
		
		for (int x = -radius + xCenter; x <= radius + xCenter; x++) {
			for (int y = -radius + yCenter; y <= radius + yCenter; y++) {
				for (int z = -radius + zCenter; z <= radius + zCenter; z++) {
					
					if ((this.worldObj.getBlock(x, y, z).isAssociatedBlock(Blocks.air) || this.worldObj.getBlock(x, y, z).isAssociatedBlock(Blocks.fire)) && this.worldObj.getBlock(x, y - 1, z).getMaterial().isSolid()) {
						
						if (worldObj.rand.nextInt(20) == 0) this.worldObj.setBlock(x, y, z, Blocks.snow);
						else if (this.worldObj.rand.nextInt(25) == 0) this.worldObj.setBlock(x, y, z, Blocks.ice);
						else this.worldObj.setBlock(x, y, z, Blocks.snow_layer);
					}
				}
			}
		}
		
		List<EntityLivingBase> entitiesInRadius = worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(xCenter - radius, yCenter - radius, zCenter - radius, xCenter + radius, yCenter + radius, zCenter + radius));
		List<FrozenEntity> frozenEntities = new ArrayList<FrozenEntity>();
		
		for (EntityLivingBase e : entitiesInRadius) {
			frozenEntities.add(new FrozenEntity(e, 200));
		}
		
		FreezeEvent.addEntitiesToList(frozenEntities);
		
		this.setDead();
	}
}

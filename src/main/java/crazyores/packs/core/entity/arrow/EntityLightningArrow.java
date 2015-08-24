package crazyores.packs.core.entity.arrow;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.world.World;
import crazyores.packs.core.item.EnumBowEnhancement;

public class EntityLightningArrow extends CoreEntityArrow {

	private int lighteningStrikes;
	private boolean randomizeStrikes;
	
	public EntityLightningArrow(World world) {
        super(world);
        init();
    }

    public EntityLightningArrow(World world, double x, double y, double z) {
        super(world, x, y, z);
        init();
    }
    
    public EntityLightningArrow(World world, EntityLivingBase shootingEntity, float speed) {
      super(world, shootingEntity, speed);
      init();
	}

    public EntityLightningArrow(World world, EntityLivingBase shootingEntity, float speed, EnumBowEnhancement enhancement) {
        super(world, shootingEntity, speed, enhancement);
        init();
    }
    
    public EntityLightningArrow(World world, EntityLivingBase shootingEntity, double verticalOffset, float speed, EnumBowEnhancement enhancement) {
        super(world, shootingEntity, verticalOffset, speed, enhancement);
        init();
    }
    
    public EntityLightningArrow(World world, EntityLivingBase shootingEntity, EntityLivingBase idk, float idk2, float idk3) {
        super(world, shootingEntity, idk, idk2, idk3);
        init();
    }
    
    private void init() {
    	lighteningStrikes = 1;
    	randomizeStrikes = false;
//    	if (this.getEnhancement().equals(EnumBowEnhancement.IDK)) //DO SOMTHING;
    }
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if (!this.worldObj.isRemote) {
			
			if (this.getIsCritical()) {
				randomizeStrikes = true;
			}
			
			if (this.movingobjectposition != null && this.movingobjectposition.entityHit != null) {
				double x = this.movingobjectposition.entityHit.posX;
    			double y = this.movingobjectposition.entityHit.posY;
    			double z = this.movingobjectposition.entityHit.posZ;
				strike(x, y, z);
            }
			
			if (this.inGround) {
				strike(this.currentX, this.currentY, this.currentZ);
			}
		}
	}

	private void strike(double x, double y, double z) {
		if (randomizeStrikes) {
			randomizeStrikes = false;
			lighteningStrikes = this.worldObj.rand.nextInt(3) + 1;
		}
		
		for (int i = 0; i < lighteningStrikes; i++) {
			this.worldObj.addWeatherEffect(new EntityLightningBolt(this.worldObj, x + rand.nextDouble(), y, z + rand.nextDouble()));
		}
		
		if (this.getEnhancement().equals(EnumBowEnhancement.FIRE)) this.spreadHellBitches((int)x, (int)y, (int)z, 2, 4, false);
		
		this.setDead();
	}
}

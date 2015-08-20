package crazyores.packs.core.entity.arrow;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import crazyores.packs.core.config.COCoreConfigSettings;
import crazyores.packs.core.item.EnumBowEnhancement;

public class EntityExplosiveArrow extends CoreEntityArrow {

	private float explosionStrength;
	private float chargedBonus;
	
	public EntityExplosiveArrow(World world) {
        super(world);
        init();
    }

    public EntityExplosiveArrow(World world, double x, double y, double z) {
        super(world, x, y, z);
        init();
    }
    
    public EntityExplosiveArrow(World world, EntityLivingBase shootingEntity, float speed) {
      super(world, shootingEntity, speed);
      init();
  }

    public EntityExplosiveArrow(World world, EntityLivingBase shootingEntity, float speed, EnumBowEnhancement enhancement) {
        super(world, shootingEntity, speed, enhancement);
        init();
    }
    
    public EntityExplosiveArrow(World world, EntityLivingBase shootingEntity, EntityLivingBase idk, float idk2, float idk3) {
        super(world, shootingEntity, idk, idk2, idk3);
        init();
    }
    
    private void init() {
    	chargedBonus = 1.0f;
    	
    	if (this.getEnhancement().equals(EnumBowEnhancement.BOOSTER)) explosionStrength = 2.0f;
    	else if (this.getEnhancement().equals(EnumBowEnhancement.DUAL)) explosionStrength = 3.0f;
    	else explosionStrength = 3.0f;
    }
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if (!this.worldObj.isRemote) {
			
			if (this.getIsCritical()) {
				chargedBonus = 1.5f;
			}
			
			if (this.movingobjectposition != null && this.movingobjectposition.entityHit != null) {
            	double x = this.movingobjectposition.entityHit.posX;
    			double y = this.movingobjectposition.entityHit.posY;
    			double z = this.movingobjectposition.entityHit.posZ;
    			explode(x, y, z);
            }
			
			if (this.inGround) {
				explode(this.currentX, this.currentY, this.currentZ);
			}
		}
	}
	
	private void explode(double x, double y, double z) {
		this.worldObj.newExplosion(this, x, y, z, explosionStrength * chargedBonus, this.getEnhancement().equals(EnumBowEnhancement.FIRE) ? true : false, true);
		this.setDead();
	}
}

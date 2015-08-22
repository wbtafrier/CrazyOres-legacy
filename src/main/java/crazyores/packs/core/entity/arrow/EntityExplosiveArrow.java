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

	private static final int DEFAULT_RADIUS = 5;
	private static final float RADIUS_BONUS = 1.5f;
	
	public EntityExplosiveArrow(World world) {
        super(world);
    }

    public EntityExplosiveArrow(World world, double x, double y, double z) {
        super(world, x, y, z);
    }
    
    public EntityExplosiveArrow(World world, EntityLivingBase shootingEntity, float speed) {
      super(world, shootingEntity, speed);
  }

    public EntityExplosiveArrow(World world, EntityLivingBase shootingEntity, float speed, EnumBowEnhancement enhancement) {
        super(world, shootingEntity, speed, enhancement);
    }
    
    public EntityExplosiveArrow(World world, EntityLivingBase shootingEntity, EntityLivingBase idk, float idk2, float idk3) {
        super(world, shootingEntity, idk, idk2, idk3);
    }
    
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if (!this.worldObj.isRemote) {
			
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
		int radius = isCrit ? (int)(DEFAULT_RADIUS * RADIUS_BONUS) : DEFAULT_RADIUS;
		
		boolean isFireBow = this.getEnhancement().equals(EnumBowEnhancement.FIRE);
		this.worldObj.newExplosion(this, x, y, z, radius, isFireBow ? true : false, true);
		
		if (isFireBow) this.spreadHellBitches((int)x, (int)y, (int)z, radius, 4, 30);
		this.setDead();
	}
}

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
import net.minecraft.init.Blocks;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import crazyores.packs.core.item.EnumBowEnhancement;

public class EntityFlamingArrow extends CoreEntityArrow {

	public EntityFlamingArrow(World world) {
        super(world);
    }

    public EntityFlamingArrow(World world, double x, double y, double z) {
        super(world, x, y, z);
    }
    
    public EntityFlamingArrow(World world, EntityLivingBase shootingEntity, float speed) {
      super(world, shootingEntity, speed);
  }

    public EntityFlamingArrow(World world, EntityLivingBase shootingEntity, float speed, EnumBowEnhancement enhancement) {
        super(world, shootingEntity, speed, enhancement);
    }
    
    public EntityFlamingArrow(World world, EntityLivingBase shootingEntity, EntityLivingBase idk, float idk2, float idk3) {
        super(world, shootingEntity, idk, idk2, idk3);
    }

	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if (!this.isInWater()) {
			this.setFire(500);
		}

        if (movingobjectposition != null && this.currentBlock != null) {
            if (this.currentBlock.getMaterial() != Material.air) {
                this.currentBlock.onEntityCollidedWithBlock(this.worldObj, this.currentX, this.currentY, this.currentZ, this);
                
                if (this.isBurning()) {
                	
                	if (this.currentBlock.isFlammable(this.worldObj, this.currentX, this.currentY, this.currentZ, ForgeDirection.getOrientation(movingobjectposition.sideHit))) {
                		int hit = movingobjectposition.sideHit;
                		int x = this.currentX;
                		int y = this.currentY;
                		int z = this.currentZ;
                		
                		if (hit == 0) {
                            --y;
                        }

                        if (hit == 1) {
                            ++y;
                        }

                        if (hit == 2) {
                            --z;
                        }

                        if (hit == 3) {
                            ++z;
                        }

                        if (hit == 4) {
                            --x;
                        }

                        if (hit == 5) {
                            ++x;
                        }

                        if (this.worldObj.isAirBlock(x, y, z)) {
                            this.worldObj.setBlock(x, y, z, Blocks.fire);
                        }
                    }
            	}
            }
        }
	}
}

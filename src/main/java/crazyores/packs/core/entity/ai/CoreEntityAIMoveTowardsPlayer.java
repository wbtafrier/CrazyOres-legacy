package crazyores.packs.core.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import crazyores.packs.core.entity.golem.EntityGolems;

public class CoreEntityAIMoveTowardsPlayer extends EntityAIBase {
	
    private EntityGolems golem;
    private EntityPlayer player;
    private World world;
    private double speed;
    private PathNavigate petPathfinder;
    private int field_75343_h;
    float maxDist;
    float minDist;
    private boolean field_75344_i;
    private int followTime;

    public CoreEntityAIMoveTowardsPlayer(EntityGolems theGolem, double speed, float minDistance, float maxDistance) {
        this.golem = theGolem;
        this.world = theGolem.worldObj;
        this.speed = speed;
        this.petPathfinder = theGolem.getNavigator();
        this.minDist = minDistance;
        this.maxDist = maxDistance;
        this.setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        EntityPlayer p = this.world.getClosestPlayerToEntity(golem, maxDist);

        if (p == null) {
            return false;
        }
        else if (this.golem.getDistanceSqToEntity(p) < (double)(this.minDist * this.minDist)) {
            return false;
        }
        else if (this.golem.getRNG().nextInt(100) != 0) {
    		return false;
    	}
        else {
            this.player = p;
            return true;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting() {
        return this.followTime > 0;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        this.field_75343_h = 0;
        this.field_75344_i = this.golem.getNavigator().getAvoidsWater();
        this.golem.getNavigator().setAvoidsWater(true);
        this.followTime = 100;
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.player = null;
        this.petPathfinder.clearPathEntity();
        this.golem.getNavigator().setAvoidsWater(this.field_75344_i);
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        this.golem.getLookHelper().setLookPositionWithEntity(this.player, 10.0F, (float)this.golem.getVerticalFaceSpeed());
        --this.followTime;
        
        if (--this.field_75343_h <= 0)
        {
            this.field_75343_h = 10;

            if (!this.petPathfinder.tryMoveToEntityLiving(this.player, this.speed)) {
                if (!this.golem.getLeashed()) {
                    if (this.golem.getDistanceSqToEntity(this.player) >= 144.0D) {
                    	
                        int i = MathHelper.floor_double(this.player.posX) - 2;
                        int j = MathHelper.floor_double(this.player.posZ) - 2;
                        int k = MathHelper.floor_double(this.player.boundingBox.minY);

                        for (int l = 0; l <= 4; ++l) {
                            for (int i1 = 0; i1 <= 4; ++i1) {
                                if ((l < 1 || i1 < 1 || l > 3 || i1 > 3) && World.doesBlockHaveSolidTopSurface(this.world, i + l, k - 1, j + i1) && !this.world.getBlock(i + l, k, j + i1).isNormalCube() && !this.world.getBlock(i + l, k + 1, j + i1).isNormalCube()) {
                                    this.golem.setLocationAndAngles((double)((float)(i + l) + 0.5F), (double)k, (double)((float)(j + i1) + 0.5F), this.golem.rotationYaw, this.golem.rotationPitch);
                                    this.petPathfinder.clearPathEntity();
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
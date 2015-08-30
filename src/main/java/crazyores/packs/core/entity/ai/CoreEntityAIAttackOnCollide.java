package crazyores.packs.core.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class CoreEntityAIAttackOnCollide extends EntityAIBase {
	
    private World worldObj;
    private EntityCreature attacker;
    /** An amount of decrementing ticks that allows the entity to attack once the tick reaches 0. */
    private int attackTick;
    /** The speed with which the mob will approach the target */
    private double speedTowardsTarget;
    /** When true, the mob will continue chasing its target, even if it can't find a path to them right now. */
    private boolean longMemory;
    /** The PathEntity of our entity. */
    private PathEntity entityPathEntity;
    private Class classTarget;
    private int field_75445_i;
    private double xPos;
    private double yPos;
    private double zPos;

    private int failedPathFindingPenalty;

    public CoreEntityAIAttackOnCollide(EntityCreature creature, Class c, double speed, boolean hasLongMemory) {
        this(creature, speed, hasLongMemory);
        this.classTarget = c;
    }

    public CoreEntityAIAttackOnCollide(EntityCreature creature, double speed, boolean hasLongMemory) {
        this.attacker = creature;
        this.worldObj = creature.worldObj;
        this.speedTowardsTarget = speed;
        this.longMemory = hasLongMemory;
        this.setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();

        if (entitylivingbase == null) {
            return false;
        }
        else if (!entitylivingbase.isEntityAlive()) {
            return false;
        }
        else if (this.classTarget != null && !this.classTarget.isAssignableFrom(entitylivingbase.getClass())) {
            return false;
        }
        else {
            if (--this.field_75445_i <= 0) {
                this.entityPathEntity = this.attacker.getNavigator().getPathToEntityLiving(entitylivingbase);
                this.field_75445_i = 4 + this.attacker.getRNG().nextInt(7);
                return this.entityPathEntity != null;
            }
            else {
                return true;
            }
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting() {
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        return entitylivingbase == null ? false : (!entitylivingbase.isEntityAlive() ? false : (!this.longMemory ? !this.attacker.getNavigator().noPath() : this.attacker.isWithinHomeDistance(MathHelper.floor_double(entitylivingbase.posX), MathHelper.floor_double(entitylivingbase.posY), MathHelper.floor_double(entitylivingbase.posZ))));
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        this.attacker.getNavigator().setPath(this.entityPathEntity, this.speedTowardsTarget);
        this.field_75445_i = 0;
    }

    /**
     * Resets the task
     */
    public void resetTask() {
        this.attacker.getNavigator().clearPathEntity();
    }

    /**
     * Updates the task
     */
    public void updateTask() {
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        this.attacker.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
        double d0 = this.attacker.getDistanceSq(entitylivingbase.posX, entitylivingbase.boundingBox.minY, entitylivingbase.posZ);
        double d1 = (double)(this.attacker.width * 2.0F * this.attacker.width * 2.0F + entitylivingbase.width);
        --this.field_75445_i;

        if ((this.longMemory || this.attacker.getEntitySenses().canSee(entitylivingbase)) && this.field_75445_i <= 0 && (this.xPos == 0.0D && this.yPos == 0.0D && this.zPos == 0.0D || entitylivingbase.getDistanceSq(this.xPos, this.yPos, this.zPos) >= 1.0D || this.attacker.getRNG().nextFloat() < 0.05F)) {
            this.xPos = entitylivingbase.posX;
            this.yPos = entitylivingbase.boundingBox.minY;
            this.zPos = entitylivingbase.posZ;
            this.field_75445_i = failedPathFindingPenalty + 4 + this.attacker.getRNG().nextInt(7);

            if (this.attacker.getNavigator().getPath() != null) {
                PathPoint finalPathPoint = this.attacker.getNavigator().getPath().getFinalPathPoint();
                if (finalPathPoint != null && entitylivingbase.getDistanceSq(finalPathPoint.xCoord, finalPathPoint.yCoord, finalPathPoint.zCoord) < 1) {
                    failedPathFindingPenalty = 0;
                }
                else {
                    failedPathFindingPenalty += 10;
                }
            }
            else {
                failedPathFindingPenalty += 10;
            }

            if (d0 > 1024.0D) {
                this.field_75445_i += 10;
            }
            else if (d0 > 256.0D) {
                this.field_75445_i += 5;
            }

            if (!this.attacker.getNavigator().tryMoveToEntityLiving(entitylivingbase, this.speedTowardsTarget)) {
                this.field_75445_i += 15;
            }
        }

        this.attackTick = Math.max(this.attackTick - 1, 0);

//        if (this.worldObj.rand.nextInt(5) == 0 && d0 < 100 && this.attackTick <= 20 && this.attacker.onGround) {
//        	System.out.println("GROUND POUND!");
//        	this.attacker.motionY += 1.0f;
//        }
//        else 
        if (d0 <= d1 && this.attackTick <= 20) {
            this.attackTick = 20;

            if (this.attacker.getHeldItem() != null) {
                this.attacker.swingItem();
            }

            this.attacker.attackEntityAsMob(entitylivingbase);
        }
    }
}
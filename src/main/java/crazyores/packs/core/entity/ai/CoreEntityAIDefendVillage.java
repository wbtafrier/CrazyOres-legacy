package crazyores.packs.core.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.village.Village;
import crazyores.packs.core.entity.golem.CoreEntityGolem;

public class CoreEntityAIDefendVillage extends EntityAITarget {
	
    private CoreEntityGolem golem;
    /** The aggressor of the golem's village which is now the golem's attack target. */
    private EntityLivingBase villageAgressorTarget;

    public CoreEntityAIDefendVillage(CoreEntityGolem golemType) {
        super(golemType, false, true);
        this.golem = golemType;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        Village village = this.golem.getVillage();

        if (village == null) {
            return false;
        }
        else {
            this.villageAgressorTarget = village.findNearestVillageAggressor(this.golem);

            if (!this.isSuitableTarget(this.villageAgressorTarget, false)) {
                if (this.taskOwner.getRNG().nextInt(20) == 0) {
                    this.villageAgressorTarget = village.func_82685_c(this.golem);
                    return this.isSuitableTarget(this.villageAgressorTarget, false);
                }
                else {
                    return false;
                }
            }
            else {
                return true;
            }
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        this.golem.setAttackTarget(this.villageAgressorTarget);
        super.startExecuting();
    }
}
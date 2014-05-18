package crazyores_core.common.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.village.Village;

public class EntityAIDefendVillages extends EntityAITarget
{
    EntityGolems golem;

    /**
     * The aggressor of the iron golem's village which is now the golem's attack target.
     */
    EntityLivingBase villageAgressorTarget;

    public EntityAIDefendVillages(EntityGolems par1EntityGolems)
    {
        super(par1EntityGolems, false, true);
        this.golem = par1EntityGolems;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        Village village = this.golem.getVillage();

        if (village == null)
        {
            return false;
        }
        else
        {
            this.villageAgressorTarget = village.findNearestVillageAggressor(this.golem);

            if (!this.isSuitableTarget(this.villageAgressorTarget, false))
            {
                if (this.taskOwner.getRNG().nextInt(20) == 0)
                {
                    this.villageAgressorTarget = village.func_82685_c(this.golem);
                    return this.isSuitableTarget(this.villageAgressorTarget, false);
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return true;
            }
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.golem.setAttackTarget(this.villageAgressorTarget);
        super.startExecuting();
    }
}

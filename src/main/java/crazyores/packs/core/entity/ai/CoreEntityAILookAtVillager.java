package crazyores.packs.core.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.packs.core.entity.golem.EntityGolems;
import crazyores.packs.core.entity.golem.EntityCopperGolem;

public class CoreEntityAILookAtVillager extends EntityAIBase {
	
    private EntityGolems golem;
    private Entity entity;
    private static Class[] entityList = new Class[] {EntityVillager.class, EntityPlayer.class};
    private static Block[] flowers = new Block[] {Blocks.red_flower, Blocks.yellow_flower};
    private int lookTime;
    
    private Block flowerType;

    public CoreEntityAILookAtVillager(EntityGolems golem) {
        this.golem = golem;
        
        flowerType = flowers[golem.getRNG().nextInt(flowers.length)];
        this.setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
    	
        if (!this.golem.worldObj.isDaytime()) {
            return false;
        }
        else {
        	
        	if (golem instanceof EntityCopperGolem) {
        		
        		if (this.golem.getRNG().nextInt(30) != 0) {
    	            return false;
        		}
        		
        		Class c = entityList[golem.getRNG().nextInt(entityList.length)];
        		this.entity = this.golem.worldObj.findNearestEntityWithinAABB(c, this.golem.boundingBox.expand(6.0D, 2.0D, 6.0D), this.golem);
                return this.entity != null;
        	}
        	else {
        		if (this.golem.getRNG().nextInt(8000) != 0) {
    	            return false;
        		}
        		
        		this.entity = (EntityVillager)this.golem.worldObj.findNearestEntityWithinAABB(EntityVillager.class, this.golem.boundingBox.expand(6.0D, 2.0D, 6.0D), this.golem);
                return this.entity != null;
        	}
        }
    }
    
    @SideOnly(Side.CLIENT)
    public Block getBlockToHold() {
    	return flowerType;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting() {
        return this.lookTime > 0;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        this.golem.setHoldingRose(true);
        this.lookTime = this.golem.getHoldRoseTick();
    }

    /**
     * Resets the task
     */
    public void resetTask() {
        this.golem.setHoldingRose(false);
        this.entity = null;
    }

    /**
     * Updates the task
     */
    public void updateTask() {
        this.golem.getLookHelper().setLookPositionWithEntity(this.entity, 30.0F, 30.0F);
        --this.lookTime;
    }
}
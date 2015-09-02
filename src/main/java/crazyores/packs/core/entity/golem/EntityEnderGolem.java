package crazyores.packs.core.entity.golem;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.world.World;
import crazyores.packs.core.entity.ai.CoreEntityAIAttackOnCollide;
import crazyores.packs.core.entity.ai.CoreEntityAIDefendVillage;
import crazyores.packs.core.entity.ai.CoreEntityAILookAtVillager;
import crazyores.packs.core.entity.ai.GolemTargets;

public class EntityEnderGolem extends EntityGolems {

	public EntityEnderGolem(World world) {
		super(world, 0.8f, 3.0f, 2.0f + (world.rand.nextFloat() * 0.2f), EnumGolemType.ENDER);
	}
	
	public EntityEnderGolem(World world, float scale) {
		super(world, 0.8f, 3.0f, scale, EnumGolemType.ENDER);
	}
	
	@Override
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(560.0d);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25d);
    }

	@Override
	protected void setAbilities() {
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new CoreEntityAIAttackOnCollide(this, 1.0d, true));
        this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9d, 32.0f));
        this.tasks.addTask(3, new EntityAIMoveThroughVillage(this, 0.6d, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0d));
        this.tasks.addTask(5, new CoreEntityAILookAtVillager(this));
        this.tasks.addTask(6, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new CoreEntityAIDefendVillage(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, true, new GolemTargets(EnumGolemType.ENDER).mobSelector));
	}
//	protected boolean teleportRandomly(EntityLivingBase e) {
//        double d0 = e.posX + (this.rand.nextDouble() - 0.5D) * 64.0D;
//        double d1 = e.posY + (double)(this.rand.nextInt(64) - 32);
//        double d2 = e.posZ + (this.rand.nextDouble() - 0.5D) * 64.0D;
//        return this.teleportTo(e, d0, d1, d2);
//    }
//	
//	protected boolean teleportTo(EntityLivingBase e, double p_70825_1_, double p_70825_3_, double p_70825_5_) {
//        EnderTeleportEvent event = new EnderTeleportEvent(e, p_70825_1_, p_70825_3_, p_70825_5_, 0);
//        if (MinecraftForge.EVENT_BUS.post(event)) {
//            return false;
//        }
//        double d3 = e.posX;
//        double d4 = e.posY;
//        double d5 = e.posZ;
//        e.posX = event.targetX;
//        e.posY = event.targetY;
//        e.posZ = event.targetZ;
//        boolean flag = false;
//        int i = MathHelper.floor_double(e.posX);
//        int j = MathHelper.floor_double(e.posY);
//        int k = MathHelper.floor_double(e.posZ);
//
//        if (this.worldObj.blockExists(i, j, k)) {
//            boolean flag1 = false;
//
//            while (!flag1 && j > 0) {
//                Block block = this.worldObj.getBlock(i, j - 1, k);
//
//                if (block.getMaterial().blocksMovement()) {
//                    flag1 = true;
//                }
//                else {
//                    --e.posY;
//                    --j;
//                }
//            }
//
//            if (flag1) {
//                this.updateTeleport(e, e.posX, e.posY, e.posZ);
//                if (this.worldObj.getCollidingBoundingBoxes(e, e.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(e.boundingBox)) {
//                    flag = true;
//                }
//            }
//        }
//
//        if (!flag) {
//            this.updateTeleport(e, d3, d4, d5);
//            return false;
//        }
//        else {
//            short short1 = 128;
//
//            for (int l = 0; l < short1; ++l) {
//                double d6 = (double)l / ((double)short1 - 1.0D);
//                float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
//                float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
//                float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
//                double d7 = d3 + (e.posX - d3) * d6 + (this.rand.nextDouble() - 0.5D) * (double)e.width * 2.0D;
//                double d8 = d4 + (e.posY - d4) * d6 + this.rand.nextDouble() * (double)e.height;
//                double d9 = d5 + (e.posZ - d5) * d6 + (this.rand.nextDouble() - 0.5D) * (double)e.width * 2.0D;
//                this.worldObj.spawnParticle("portal", d7, d8, d9, (double)f, (double)f1, (double)f2);
//            }
//            this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
//            e.playSound("mob.endermen.portal", 1.0F, 1.0F);
//            return true;
//        }
//        
//    }
	
	protected void teleportEntity(EntityLivingBase entity) {

		if (!this.worldObj.isRemote) {
			if (rand.nextInt(2) == 0) entity.motionX += 2.8f + (rand.nextDouble());
		    else entity.motionX -= 2.8f + (rand.nextDouble());
		    
		    entity.motionY += 1.8f + (rand.nextDouble());
		    
		    if (rand.nextInt(2) == 0) entity.motionZ += 2.8f + (rand.nextDouble());
		    else entity.motionZ -= 2.8f + (rand.nextDouble());
		    
		    if (entity instanceof EntityPlayer)
		    	((EntityPlayerMP)entity).playerNetServerHandler.sendPacket(new S12PacketEntityVelocity(entity));
		}
	}
	
//	private void updateTeleport(EntityLivingBase e, double x, double y, double z) {
//		if (e instanceof EntityPlayer)
//			e.setPositionAndUpdate(x, y, z);
//		else
//			e.setPosition(x, y, z);
//			
//	}
}

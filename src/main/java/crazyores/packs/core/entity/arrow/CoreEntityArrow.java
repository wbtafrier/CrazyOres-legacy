package crazyores.packs.core.entity.arrow;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import cpw.mods.fml.common.registry.IThrowableEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.packs.core.item.CoreItems;
import crazyores.packs.core.item.EnumBowEnhancement;
import crazyores.packs.core.item.ConfusionBow;

public class CoreEntityArrow extends EntityArrow implements IProjectile, IThrowableEntity {

	private EnumBowEnhancement bowEnhancement = EnumBowEnhancement.NONE;
	protected boolean isCrit = false;
	
	protected MovingObjectPosition movingobjectposition;
	
	protected int currentX = -1;
    protected int currentY = -1;
    protected int currentZ = -1;
    protected Block currentBlock;
    protected int inData;
    protected boolean inGround;
    protected int ticksInGround;
    protected int ticksInAir;
    protected double damage = 2.0D;
    /** The amount of knockback an arrow applies when it hits a mob. */
    protected int knockbackStrength;

    public CoreEntityArrow(World world) {
        super(world);
    }

    public CoreEntityArrow(World world, double x, double y, double z) {
        super(world, x, y, z);
    }
    
    public CoreEntityArrow(World world, EntityLivingBase shootingEntity, float speed) {
      super(world, shootingEntity, speed);
    }
    
    public CoreEntityArrow(World world, EntityLivingBase shootingEntity, double verticalOffset, float speed, EnumBowEnhancement enhancement) {
        this(world, shootingEntity, speed);
        this.bowEnhancement = enhancement;
        this.posY += verticalOffset;
    }

    public CoreEntityArrow(World world, EntityLivingBase shootingEntity, float speed, EnumBowEnhancement enhancement) {
        this(world, shootingEntity, speed);
        this.bowEnhancement = enhancement;
    }
    
    public CoreEntityArrow(World world, EntityLivingBase shootingEntity, EntityLivingBase p_i1755_3_, float p_i1755_4_, float p_i1755_5_) {
        super(world, shootingEntity, p_i1755_3_, p_i1755_4_, p_i1755_5_);
    }
    
    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        super.onEntityUpdate();
        isCrit = false;
        
        if (this.bowEnhancement.equals(EnumBowEnhancement.FIRE)) {
        	if (!this.isInWater()) {
    			this.setFire(500);
    		}
        }
        
        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
            float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f) * 180.0D / Math.PI);
        }

        Block block = this.worldObj.getBlock(this.currentX, this.currentY, this.currentZ);

        if (block.getMaterial() != Material.air) {
            block.setBlockBoundsBasedOnState(this.worldObj, this.currentX, this.currentY, this.currentZ);
            AxisAlignedBB axisalignedbb = block.getCollisionBoundingBoxFromPool(this.worldObj, this.currentX, this.currentY, this.currentZ);

            if (axisalignedbb != null && axisalignedbb.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ))) {
                this.inGround = true;
            }
        }

        if (this.arrowShake > 0) {
            --this.arrowShake;
        }

        if (this.inGround) {
            int j = this.worldObj.getBlockMetadata(this.currentX, this.currentY, this.currentZ);

            if (block == this.currentBlock && j == this.inData) {
                ++this.ticksInGround;

                if (this.ticksInGround == 1200) {
                    this.setDead();
                }
            }
            else {
                this.inGround = false;
                this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
                this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
                this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        }
        else {
            ++this.ticksInAir;
            Vec3 vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            Vec3 vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            movingobjectposition = this.worldObj.func_147447_a(vec31, vec3, false, true, false);
            vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

            if (movingobjectposition != null) {
                vec3 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
            }

            Entity entity = null;
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
            double d0 = 0.0D;
            int i;
            float f1;

            for (i = 0; i < list.size(); ++i) {
                Entity entity1 = (Entity)list.get(i);

                if (entity1.canBeCollidedWith() && (entity1 != this.shootingEntity || this.ticksInAir >= 5)) {
                    f1 = 0.3F;
                    AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand((double)f1, (double)f1, (double)f1);
                    MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec31, vec3);

                    if (movingobjectposition1 != null) {
                        double d1 = vec31.distanceTo(movingobjectposition1.hitVec);

                        if (d1 < d0 || d0 == 0.0D) {
                            entity = entity1;
                            d0 = d1;
                        }
                    }
                }
            }

            if (entity != null) {
                movingobjectposition = new MovingObjectPosition(entity);
            }

            if (movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer) {
                EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.entityHit;

                if (entityplayer.capabilities.disableDamage || this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer)) {
                    movingobjectposition = null;
                }
            }

            float f2;
            float f4;

            if (movingobjectposition != null) {
                if (movingobjectposition.entityHit != null) {
                    f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    int k = MathHelper.ceiling_double_int((double)f2 * this.damage);

                    if (this.getIsCritical()) {
                    	isCrit = true;
                        k += this.rand.nextInt(k / 2 + 2);
                    }

                    DamageSource damagesource = null;

                    if (this.shootingEntity == null) {
                        damagesource = DamageSource.causeArrowDamage(this, this);
                    }
                    else {
                        damagesource = DamageSource.causeArrowDamage(this, this.shootingEntity);
                    }

                    if (this.isBurning() && !(movingobjectposition.entityHit instanceof EntityEnderman)) {
                        movingobjectposition.entityHit.setFire(5);
                    }

                    if (movingobjectposition.entityHit.attackEntityFrom(damagesource, (float)k)) {
                    	
                    	if (this.getEnhancement().equals(EnumBowEnhancement.POISON)) {
    						this.confuseEntities((int)entity.posX, (int)entity.posY, (int)entity.posZ, 5);
        				}
                    	
                        if (movingobjectposition.entityHit instanceof EntityLivingBase) {
                            EntityLivingBase entitylivingbase = (EntityLivingBase)movingobjectposition.entityHit;

                            if (!this.worldObj.isRemote) {
                                entitylivingbase.setArrowCountInEntity(entitylivingbase.getArrowCountInEntity() + 1);
                            }

                            if (this.knockbackStrength > 0) {
                                f4 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);

                                if (f4 > 0.0F) {
                                    movingobjectposition.entityHit.addVelocity(this.motionX * (double)this.knockbackStrength * 0.6000000238418579D / (double)f4, 0.1D, this.motionZ * (double)this.knockbackStrength * 0.6000000238418579D / (double)f4);
                                }
                            }

                            if (this.shootingEntity != null && this.shootingEntity instanceof EntityLivingBase) {
                                EnchantmentHelper.func_151384_a(entitylivingbase, this.shootingEntity);
                                EnchantmentHelper.func_151385_b((EntityLivingBase)this.shootingEntity, entitylivingbase);
                            }

                            if (this.shootingEntity != null && movingobjectposition.entityHit != this.shootingEntity && movingobjectposition.entityHit instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP) {
                                ((EntityPlayerMP)this.shootingEntity).playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(6, 0.0F));
                            }
                        }

                        this.playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));

                        if (!(movingobjectposition.entityHit instanceof EntityEnderman)) {
                            this.setDead();
                        }
                    }
                    else {
                        this.motionX *= -0.10000000149011612D;
                        this.motionY *= -0.10000000149011612D;
                        this.motionZ *= -0.10000000149011612D;
                        this.rotationYaw += 180.0F;
                        this.prevRotationYaw += 180.0F;
                        this.ticksInAir = 0;
                    }
                }
                else {
                    this.currentX = movingobjectposition.blockX;
                    this.currentY = movingobjectposition.blockY;
                    this.currentZ = movingobjectposition.blockZ;
                    this.currentBlock = this.worldObj.getBlock(this.currentX, this.currentY, this.currentZ);
                    this.inData = this.worldObj.getBlockMetadata(this.currentX, this.currentY, this.currentZ);
                    this.motionX = (double)((float)(movingobjectposition.hitVec.xCoord - this.posX));
                    this.motionY = (double)((float)(movingobjectposition.hitVec.yCoord - this.posY));
                    this.motionZ = (double)((float)(movingobjectposition.hitVec.zCoord - this.posZ));
                    f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    this.posX -= this.motionX / (double)f2 * 0.05000000074505806D;
                    this.posY -= this.motionY / (double)f2 * 0.05000000074505806D;
                    this.posZ -= this.motionZ / (double)f2 * 0.05000000074505806D;
                    this.playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
                    this.inGround = true;
                    this.arrowShake = 7;
                    this.setIsCritical(false);

                    if (this.currentBlock.getMaterial() != Material.air) {
                        this.currentBlock.onEntityCollidedWithBlock(this.worldObj, this.currentX, this.currentY, this.currentZ, this);
                    }
                }
            }

            if (this.getIsCritical()) {
                for (i = 0; i < 4; ++i) {
                    this.worldObj.spawnParticle("crit", this.posX + this.motionX * (double)i / 4.0D, this.posY + this.motionY * (double)i / 4.0D, this.posZ + this.motionZ * (double)i / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
                }
            }

            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

            for (this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f2) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) { ; }

            while (this.rotationPitch - this.prevRotationPitch >= 180.0F) {
                this.prevRotationPitch += 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw < -180.0F) {
                this.prevRotationYaw -= 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw >= 180.0F) {
                this.prevRotationYaw += 360.0F;
            }

            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
            float f3 = 0.99F;
            f1 = 0.05F;

            if (this.isInWater()) {
                for (int l = 0; l < 4; ++l) {
                    f4 = 0.25F;
                    this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f4, this.posY - this.motionY * (double)f4, this.posZ - this.motionZ * (double)f4, this.motionX, this.motionY, this.motionZ);
                }

                f3 = 0.8F;
            }

            if (this.isWet()) {
                this.extinguish();
            }

            this.motionX *= (double)f3;
            this.motionY *= (double)f3;
            this.motionZ *= (double)f3;
            this.motionY -= (double)f1;
            this.setPosition(this.posX, this.posY, this.posZ);
            this.func_145775_I();
            
            if (inGround) {
            	if (this.getEnhancement().equals(EnumBowEnhancement.POISON)) {
					this.confuseEntities(currentX, currentY, currentZ, 5);
					this.teleportPlayer((EntityLivingBase)this.getThrower());
					return;
				}
            }
        }
    }

    /**
     * Called by a player entity when they collide with an entity
     */
    @Override
    public void onCollideWithPlayer(EntityPlayer player) {
        if (!this.worldObj.isRemote && this.inGround && this.arrowShake <= 0) {
            boolean canPickUp = this.canBePickedUp == 1 || this.canBePickedUp == 2 && player.capabilities.isCreativeMode;

            if (this.canBePickedUp == 1) {
            	if ((this instanceof EntityFlamingArrow && !player.inventory.addItemStackToInventory(new ItemStack(CoreItems.flamingArrow, 1))) 
            	|| (this instanceof EntityExplosiveArrow && !player.inventory.addItemStackToInventory(new ItemStack(CoreItems.explosiveArrow, 1)))
            	|| (this instanceof EntityLightningArrow && !player.inventory.addItemStackToInventory(new ItemStack(CoreItems.lightningArrow, 1)))
            	|| (this instanceof EntityFreezingArrow && !player.inventory.addItemStackToInventory(new ItemStack(CoreItems.freezingArrow, 1)))) {
            		canPickUp = false;
            	}
            }

            if (canPickUp) {
                this.playSound("random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                player.onItemPickup(this, 1);
                this.setDead();
            }
        }
    }

    public EnumBowEnhancement getEnhancement() {
		return bowEnhancement;
	}

	@Override
	public Entity getThrower() {
		return shootingEntity;
	}

	@Override
	public void setThrower(Entity entity) {
		this.shootingEntity = entity;
	}

	protected void spreadHellBitches(int xCenter, int yCenter, int zCenter, int defaultRadius, int randFire, int randLava) {
		int radius = defaultRadius;
		
		for (int x = -radius + xCenter; x <= radius + xCenter; x++) {
			for (int y = -radius + yCenter; y <= radius + yCenter; y++) {
				for (int z = -radius + zCenter; z <= radius + zCenter; z++) {
					
					Block aboveBlock = this.worldObj.getBlock(x, y + 1, z);
					Block currentBlock = this.worldObj.getBlock(x, y, z);
					Block underBlock = this.worldObj.getBlock(x, y - 1, z);
					
					if (this.bowEnhancement.equals(EnumBowEnhancement.FIRE)) {
					
						if (currentBlock.isAssociatedBlock(Blocks.snow_layer)) {
							if (worldObj.rand.nextInt(isCrit ? 2 : 3) == 0) this.worldObj.setBlock(x, y, z, Blocks.air);
							continue;
						}
						else if (currentBlock.isAssociatedBlock(Blocks.snow) || currentBlock.isAssociatedBlock(Blocks.ice)) {
							if (worldObj.rand.nextInt(isCrit? 3 : 5) == 0) this.worldObj.setBlock(x, y, z, Blocks.flowing_water);
							continue;
						}
						else if (isCrit && currentBlock.isAssociatedBlock(Blocks.packed_ice)) {
							if (worldObj.rand.nextInt(5) == 0) this.worldObj.setBlock(x, y, z, Blocks.flowing_water);
							continue;
						}
					}
					
					if ((currentBlock.isAssociatedBlock(Blocks.air)) && underBlock.getMaterial().isSolid()) {
						if (randFire > 0 && worldObj.rand.nextInt(isCrit ? randFire / 2 : randFire) == 0) this.worldObj.setBlock(x, y, z, Blocks.fire);
						else if (randLava > 0 && this.worldObj.rand.nextInt(isCrit ? randLava / 2 : randLava) == 0) this.worldObj.setBlock(x, y, z, Blocks.flowing_lava);
					}
				}
			}
		}
		isCrit = false;
		this.setDead();
	}
	
	protected void spreadHellBitches(int xCenter, int yCenter, int zCenter, int defaultRadius, int randFire, boolean lava) {
		this.spreadHellBitches(xCenter, yCenter, zCenter, defaultRadius, randFire, -1);
	}
	
	protected void confuseEntities(int currX, int currY, int currZ, int radius) {
		
		if (!this.worldObj.isRemote) {
			List<EntityLivingBase> entitiesInRadius = worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(currX - radius, currY - radius, currZ - radius, currX + radius, currY + radius, currZ + radius));
			
			for (EntityLivingBase entity : entitiesInRadius) {
				Random rand = entity.getRNG();
				
				if (rand.nextInt(2) == 0) entity.motionX += 0.8f + (rand.nextDouble());
				else entity.motionX -= 0.8f + (rand.nextDouble());
				
				if (rand.nextInt(2) == 0) entity.motionY += 0.8f + (rand.nextDouble()) * (isCrit ? rand.nextInt(4) + 1 : rand.nextInt(2) + 1);
				else entity.motionY -= 0.8f + (rand.nextDouble()) * (isCrit ? 2 : 1);
				
				if (rand.nextInt(2) == 0) entity.motionZ += 0.8f + (rand.nextDouble());
				else entity.motionZ -= 0.8f + (rand.nextDouble());
				
				if (entity instanceof EntityPlayer)
					((EntityPlayerMP)entity).playerNetServerHandler.sendPacket(new S12PacketEntityVelocity(entity));
				
				entity.addPotionEffect(new PotionEffect(Potion.confusion.id, ConfusionBow.NAUSEA_EFFECT, 0));
			}
			this.setDead();
		}
	}
	
	protected void teleportPlayer(EntityLivingBase player) {

        if (!this.worldObj.isRemote) {
            if (player != null && player instanceof EntityPlayerMP) {
                EntityPlayerMP entityplayermp = (EntityPlayerMP)player;

                if (entityplayermp.playerNetServerHandler.func_147362_b().isChannelOpen() && entityplayermp.worldObj == this.worldObj) {
                    EnderTeleportEvent event = new EnderTeleportEvent(entityplayermp, this.posX, this.posY, this.posZ, 2.0F);
                    
                    if (!MinecraftForge.EVENT_BUS.post(event)) { // Don't indent to lower patch size
                    if (player.isRiding()) {
                    	player.mountEntity((Entity)null);
                    }

                    player.setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
                    player.fallDistance = 0.0F;
                    player.attackEntityFrom(DamageSource.fall, event.attackDamage);
                    }
                }
            }

            this.setDead();
        }
    }
}

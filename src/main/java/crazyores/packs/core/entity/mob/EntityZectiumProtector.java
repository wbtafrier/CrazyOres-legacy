package crazyores.packs.core.entity.mob;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.manager.pack.data.CrazyOresData;
import crazyores.packs.core.entity.EntityZectiumCore;
import crazyores.packs.core.item.CoreItems;

public class EntityZectiumProtector extends EntityFlying implements IMob {

	private static Random rand = new Random();
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity;
    /** Cooldown time between target loss and new target aquirement. */
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
	
    public EntityZectiumProtector(World world) {
		super(world);
		this.experienceValue = 10;
		this.dataWatcher.addObject(20, 1.0f);
		setScale(1.0f + (rand.nextFloat() * 0.5f));
		this.width = 1.2f;
		this.height = 3.5f;
	}
    
	@Override
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
    }
	
	@Override
	protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float p_70070_1_) {
        return 15728880;
    }
	
	@Override
	public float getBrightness(float p_70013_1_) {
        return 1.0F;
    }
	
	protected void updateEntityActionState() {
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        
        if (this.isWet()) {
            this.attackEntityFrom(DamageSource.drown, 1.0F);
        }

        this.despawnEntity();
        this.prevAttackCounter = this.attackCounter;
        double d0 = this.waypointX - this.posX;
        double d1 = this.waypointY - this.posY;
        double d2 = this.waypointZ - this.posZ;
        double d3 = d0 * d0 + d1 * d1 + d2 * d2;

        if (d3 < 1.0D || d3 > 3600.0D)
        {
            this.waypointX = this.posX + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 2.0F);
            this.waypointY = this.posY + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 2.0F);
            this.waypointZ = this.posZ + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 2.0F);
        }

        if (this.courseChangeCooldown-- <= 0)
        {
            this.courseChangeCooldown += this.rand.nextInt(5) + 2;
            d3 = (double)MathHelper.sqrt_double(d3);

            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3))
            {
                this.motionX += d0 / d3 * 0.1D;
                this.motionY += d1 / d3 * 0.1D;
                this.motionZ += d2 / d3 * 0.1D;
            }
            else
            {
                this.waypointX = this.posX;
                this.waypointY = this.posY;
                this.waypointZ = this.posZ;
            }
        }

        if (this.targetedEntity != null && this.targetedEntity.isDead)
        {
            this.targetedEntity = null;
        }

        if (this.targetedEntity == null || this.aggroCooldown-- <= 0)
        {
            this.targetedEntity = this.worldObj.getClosestVulnerablePlayerToEntity(this, 100.0D);

            if (this.targetedEntity != null)
            {
                this.aggroCooldown = 20;
            }
        }

        double d4 = 32.0D;

        if (this.targetedEntity != null && this.targetedEntity.getDistanceSqToEntity(this) < d4 * d4)
        {
            double d5 = this.targetedEntity.posX - this.posX;
            double d6 = this.targetedEntity.boundingBox.minY + (double)(this.targetedEntity.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
            double d7 = this.targetedEntity.posZ - this.posZ;
            this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(d5, d7)) * 180.0F / (float)Math.PI;

            if (this.canEntityBeSeen(this.targetedEntity)) {
                if (this.attackCounter == 2) {
                    this.playSound(CrazyOresData.corePackID + ":mob.zectiumProtector.shoot", getSoundVolume() * 4, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
                }

                ++this.attackCounter;

                if (this.attackCounter == 20)
                {
                    double d8 = 4.0D;
                    Vec3 vec3 = this.getLook(1.0F);
                    EntityZectiumCore zectiumCore = new EntityZectiumCore(this.worldObj, this.posX + vec3.xCoord * d8, this.posY + (double)(this.height / 2.0F), this.posZ + vec3.zCoord * d8);
                    
                    if (rand.nextInt(2) == 0) d5 += rand.nextDouble() * 2.0;
                    else d5 -= rand.nextDouble() * 2.0;
                    
                    if (rand.nextInt(2) == 0) d6 += rand.nextDouble() * 2.0;
                    else d6 -= rand.nextDouble() * 2.0;
                    	
                	if (rand.nextInt(2) == 0) d7 += rand.nextDouble() * 2.0;
                	else d7 -= rand.nextDouble() * 2.0;
                    
                	zectiumCore.motionX = (d5 / 5.0f);
                    zectiumCore.motionY = (d6 / 5.0f);
                    zectiumCore.motionZ = (d7 / 5.0f);
                    
                    this.worldObj.spawnEntityInWorld(zectiumCore);
                    this.attackCounter = -40;
                }
            }
            else if (this.attackCounter > 0)
            {
                --this.attackCounter;
            }
        }
        else
        {
            this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(this.motionX, this.motionZ)) * 180.0F / (float)Math.PI;

            if (this.attackCounter > 0)
            {
                --this.attackCounter;
            }
        }

//        if (!this.worldObj.isRemote)
//        {
//            byte b1 = this.dataWatcher.getWatchableObjectByte(16);
//            byte b0 = (byte)(this.attackCounter > 10 ? 1 : 0);
//
//            if (b1 != b0)
//            {
//                this.dataWatcher.updateObject(16, Byte.valueOf(b0));
//            }
//        }
    }

    /**
     * True if the ghast has an unobstructed line of travel to the waypoint.
     */
    private boolean isCourseTraversable(double p_70790_1_, double p_70790_3_, double p_70790_5_, double p_70790_7_)
    {
        double d4 = (this.waypointX - this.posX) / p_70790_7_;
        double d5 = (this.waypointY - this.posY) / p_70790_7_;
        double d6 = (this.waypointZ - this.posZ) / p_70790_7_;
        AxisAlignedBB axisalignedbb = this.boundingBox.copy();

        for (int i = 1; (double)i < p_70790_7_; ++i)
        {
            axisalignedbb.offset(d4, d5, d6);

            if (!this.worldObj.getCollidingBoundingBoxes(this, axisalignedbb).isEmpty())
            {
                return false;
            }
        }

        return true;
    }
	
	@Override
	protected void fall(float p_70069_1_) {}
	
	@Override
	protected void updateFallState(double p_70064_1_, boolean p_70064_3_) {}
	
	@Override
	protected Item getDropItem() {
        return CoreItems.zectiumCore;
    }
	
	@Override
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);
        int k;

        for (k = 0; k < j; ++k) {
            this.dropItem(CoreItems.zectiumCore, 1);
        }

        j = this.rand.nextInt(4) + this.rand.nextInt(1 + p_70628_2_);

        for (k = 0; k < j; ++k) {
            this.dropItem(CoreItems.zectiumIngot, 1);
        }
    }
	
	public void func_70844_e(boolean p_70844_1_) {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (p_70844_1_) {
            b0 = (byte)(b0 | 1);
        }
        else {
            b0 &= -2;
        }

        this.dataWatcher.updateObject(16, Byte.valueOf(b0));
    }
	
	public void setScale(float s) {
    	dataWatcher.updateObject(20, s);
    	updateSize();
    }
	
	public void updateSize() {
		setSize(width * getScale(), height * getScale());
	}
	
	public float getScale() {
    	return dataWatcher.getWatchableObjectFloat(20);
    }
	
	@Override
	public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_)
    {
        if (this.isInWater())
        {
            this.moveFlying(p_70612_1_, p_70612_2_, 0.02F);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.800000011920929D;
            this.motionY *= 0.800000011920929D;
            this.motionZ *= 0.800000011920929D;
        }
        else if (this.handleLavaMovement())
        {
            this.moveFlying(p_70612_1_, p_70612_2_, 0.02F);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.5D;
            this.motionY *= 0.5D;
            this.motionZ *= 0.5D;
        }
        else
        {
            float f2 = 0.91F;

            if (this.onGround)
            {
                f2 = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ)).slipperiness * 0.91F;
            }

            float f3 = 0.16277136F / (f2 * f2 * f2);
            this.moveFlying(p_70612_1_, p_70612_2_, this.onGround ? 0.1F * f3 : 0.02F);
            f2 = 0.91F;

            if (this.onGround)
            {
                f2 = this.worldObj.getBlock(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ)).slipperiness * 0.91F;
            }

            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= (double)f2;
            this.motionY *= (double)f2;
            this.motionZ *= (double)f2;
        }

        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d1 = this.posX - this.prevPosX;
        double d0 = this.posZ - this.prevPosZ;
        float f4 = MathHelper.sqrt_double(d1 * d1 + d0 * d0) * 4.0F;

        if (f4 > 1.0F)
        {
            f4 = 1.0F;
        }

        this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
        this.limbSwing += this.limbSwingAmount;
    }
	
	@Override
	public boolean getCanSpawnHere() {
        return this.rand.nextInt(20) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && super.getCanSpawnHere();
    }
	
	@Override
	public boolean isOnLadder() {
        return false;
    }
	
	@Override
	protected String getLivingSound() {
        return CrazyOresData.corePackID + ":mob.zectiumProtector.moan";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound() {
        return CrazyOresData.corePackID + ":mob.zectiumProtector.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound() {
        return CrazyOresData.corePackID + ":mob.zectiumProtector.death";
    }
}

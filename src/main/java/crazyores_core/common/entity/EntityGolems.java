package crazyores_core.common.entity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.village.Village;
import net.minecraft.world.World;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores_core.common.core.COLogger;

public class EntityGolems extends EntityGolem
{
    /** deincrements, and a distance-to-home check is done at 0 */
    private int homeCheckTimer;
    Village villageObj;
    private int attackTimer;
    private Item drop;
    
    protected String name = "null";

    public EntityGolems(World par1World)
    {
        super(par1World);
        this.applyUniqueProperties();
        this.getNavigator().setAvoidsWater(true);
        
		if (this.getName().equals("foolsRuby")) {
			this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.2D, true));
			this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 1.2D, 16.0F));
			this.tasks.addTask(6, new EntityAIWander(this, 0.9D));
		}
		else {
			this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 0.9D, true));
			this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9D, 16.0F));
			this.tasks.addTask(6, new EntityAIWander(this, 0.6D));
		}
        
        this.tasks.addTask(3, new EntityAIMoveThroughVillage(this, 0.6D, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(5, new EntityAILookAtVillagers(this));

        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIDefendVillages(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityLivingBase.class, 0, false, true, IGolemTarget.golemTargets));
        if (this.getName().equals("demonite")) {
        	this.isImmuneToFire = true;
        }
    }
    
    public EntityGolems(World par1World, Item d)
    {
        this(par1World);
        this.drop = d;
    }

    @Override
    public boolean canAttackClass(Class cl)
    {
    	return EntityGhast.class != cl;
    }
    
    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }

    @Override
    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    @Override
    /**
     * main AI tick function, replaces updateEntityActionState
     */
    protected void updateAITick()
    {
        if (--this.homeCheckTimer <= 0)
        {
            this.homeCheckTimer = 70 + this.rand.nextInt(50);
            this.villageObj = this.worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ), 32);

            if (this.villageObj == null)
            {
                this.detachHome();
            }
            else
            {
                ChunkCoordinates chunkcoordinates = this.villageObj.getCenter();
                this.setHomeArea(chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ, (int)((float)this.villageObj.getVillageRadius() * 0.6F));
            }
        }

        super.updateAITick();
    }
    
    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
    }

    @Override
    /**
     * Decrements the entity's air supply when underwater
     */
    protected int decreaseAirSupply(int par1)
    {
        return par1;
    }

    @Override
    protected void collideWithEntity(Entity par1Entity)
    {
        if (IGolemTarget.golemTargets.isEntityApplicable(par1Entity) && this.getRNG().nextInt(20) == 0)
        {
            this.setAttackTarget((EntityLivingBase)par1Entity);
        }

        super.collideWithEntity(par1Entity);
    }

    @Override
    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (this.attackTimer > 0)
        {
            --this.attackTimer;
        }
        
        if (this.getName().equals("demonite"))
        {
        	if (this.isWet())
        	{
        		this.entityToAttack = null;
        		this.attackEntityFrom(DamageSource.drown, 1.0F);
        	}
        }

        if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(5) == 0)
        {
            int i = MathHelper.floor_double(this.posX);
            int j = MathHelper.floor_double(this.posY - 0.20000000298023224D - (double)this.yOffset);
            int k = MathHelper.floor_double(this.posZ);
            Block l = this.worldObj.getBlock(i, j, k);

            if (l.getMaterial() != Material.air)
            {
                this.worldObj.spawnParticle("tilecrack_" + l + "_" + this.worldObj.getBlockMetadata(i, j, k), this.posX + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, this.boundingBox.minY + 0.1D, this.posZ + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D, ((double)this.rand.nextFloat() - 0.5D) * 4.0D);
            }
        }
    }

//    @Override
//    /**
//     * Returns true if this entity can attack entities of the specified class.
//     */
//    public boolean canAttackClass(Class par1Class)
//    {
//        return this.isPlayerCreated() && EntityPlayer.class.isAssignableFrom(par1Class) ? false : super.canAttackClass(par1Class);
//    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setBoolean("PlayerCreated", this.isPlayerCreated());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setPlayerCreated(par1NBTTagCompound.getBoolean("PlayerCreated"));
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity)
    {
        this.attackTimer = 10;
        this.worldObj.setEntityState(this, (byte)4);
        
        int damage = 0;
        
        if (this.getName().equals("foolsRuby"))
        {
        	damage = 2;
        }
        else if (this.getName().equals("copper"))
        {
        	damage = 8 + rand.nextInt(15);
        }
        else if (this.getName().equals("sapphire"))
        {
        	damage = 11 + rand.nextInt(15);
        }
        else if (this.getName().equals("adamite"))
        {
        	damage = 15 + rand.nextInt(15);
        }
        else if (this.getName().equals("ruby"))
        {
        	damage = 19 + rand.nextInt(15);
        }
        else if (this.getName().equals("demonite"))
        {
        	par1Entity.setFire(100);
        	damage = 10 + rand.nextInt(15);
        }
        else if (this.getName().equals("zectium"))
        {
        	damage = 25 + rand.nextInt(15);
        }
        else if (this.getName().equals("tapazite"))
        {
        	damage = 30 + rand.nextInt(15);
        }
        else if (this.getName().equals("crystal"))
        {
        	damage = 34 + rand.nextInt(15);
        }
        else if (this.getName().equals("osmonium"))
        {
        	damage = 39 + rand.nextInt(15);
        }
        else if (this.getName().equals("starconium"))
        {
        	damage = 50 + rand.nextInt(15);
        }
        else
        {
        	COLogger.log(Level.FATAL, "A golem attacked something, but the golem wasn't registered! Please inform the mod developers of this error!");
        }
        
        boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(damage));

        if (flag)
        {
            par1Entity.motionY += 0.4000000059604645D;
        }

        this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
        return flag;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void handleHealthUpdate(byte par1)
    {
        if (par1 == 4)
        {
            this.attackTimer = 10;
            this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
        }
        else
        {
            super.handleHealthUpdate(par1);
        }
    }

    public Village getVillage()
    {
        return this.villageObj;
    }

    @SideOnly(Side.CLIENT)
    public int getAttackTimer()
    {
        return this.attackTimer;
    }
    
    protected String getLivingSound()
    {
        return null;
    }

    @Override
    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.irongolem.hit";
    }

    @Override
    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.irongolem.death";
    }

    @Override
    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void func_145780_a(int par1, int par2, int par3, Block par4)
    {
        this.playSound("mob.irongolem.walk", 1.0F, 1.0F);
    }

    @Override
    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean par1, int par2)
    {
        int j = this.rand.nextInt(3);
        int k;

        k = 3 + j;

        for (int l = 0; l < k; ++l)
        {
            this.dropItem(this.drop, 1);
        }
    }

    public boolean isPlayerCreated()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void setPlayerCreated(boolean par1)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (par1)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -2)));
        }
    }

    @Override
    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource par1DamageSource)
    {
        if (!this.isPlayerCreated() && this.attackingPlayer != null && this.villageObj != null)
        {
            this.villageObj.setReputationForPlayer(this.attackingPlayer.getCommandSenderName(), -5);
        }

        super.onDeath(par1DamageSource);
    }
    
    public void setName(String n)
	 {
		 this.name = n;
	 }
	 
	 public String getName()
	 {
		 return this.name;
	 }
	 
	 protected void applyUniqueProperties() {}
}

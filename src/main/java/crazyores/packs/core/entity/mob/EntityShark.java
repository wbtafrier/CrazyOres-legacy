package crazyores.packs.core.entity.mob;

import java.util.List;
import java.util.Random;

import crazyores.packs.core.item.CoreItems;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public abstract class EntityShark extends EntityMob {
	protected static Random rand = new Random();
	protected EnumSharkType type = EnumSharkType.GREAT_WHITE;
	
	private double topJawRotation;
	private double bottomJawRotation;
	
    private int aggroCooldown;
	
    private double waypointX;
    private double waypointY;
    private double waypointZ;
    
    private boolean attacking;
    private float speed;
    
    private float radius;
    
	private int courseChangeCooldown;
	
	public EntityShark(World world, EnumSharkType sharkType, float scale, float r, float s) {
		super(world);
		type = sharkType;
		this.dataWatcher.addObject(20, 1.0f);
		this.width = 2.0f;
		this.height = 1.5f;
		this.setScale(scale);
        this.experienceValue = 10;
        radius = r;
        speed = s;
	}
	
	@Override
	protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }
	
	@Override
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(26.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0D);
    }
	
	public static enum EnumSharkType {
		GREAT_WHITE,
		ADAMITE;
	}
	
	public EnumSharkType getType() {
		return type;
	}
	
	@Override
	protected void fall(float var1) {}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer player) {
//		player.attackEntityFrom(DamageSource.causeMobDamage(this), (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue());
    }
	
	@Override
	public void onLivingUpdate() {
		
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }

        this.despawnEntity();
        
        if (this.inWater) {
	        if (this.entityToAttack != null && (this.entityToAttack.isInWater() || this.entityToAttack.isRiding()) && this.entityToAttack.getDistanceSqToEntity(this) < radius * radius) {
	        	attacking = true;
	            double d5 = this.entityToAttack.posX - this.posX;
	            double d6 = this.entityToAttack.boundingBox.minY + (double)(this.entityToAttack.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
	            double d7 = this.entityToAttack.posZ - this.posZ;
	            this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(d5, d7)) * 180.0F / (float)Math.PI;
	            
	            if (this.canEntityBeSeen(entityToAttack)) {
                
	                waypointX = entityToAttack.posX;
                	waypointY = entityToAttack.posY;
                	waypointZ = entityToAttack.posZ;
	
                	if (this.entityToAttack.getDistanceSqToEntity(this) <= 6.0f * 6.0f) {
                		
                		topJawRotation = MathHelper.clamp_double(topJawRotation - Math.toRadians(1.5f), Math.toRadians(-20f), 0.0f);
                		bottomJawRotation = MathHelper.clamp_double(bottomJawRotation + Math.toRadians(3.0f), 0.0f, Math.toRadians(40f));
                	}
                	else {
                		closeMouth();
                	}
	            }
	            else {
	            	closeMouth();
	            }
	        }
	        else {
	            this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(this.motionX, this.motionZ)) * 180.0F / (float)Math.PI;
	            closeMouth();
	        }
	        
        	double d0 = this.waypointX - this.posX;
            double d1 = this.waypointY - this.posY;
            double d2 = this.waypointZ - this.posZ;
            double d3 = d0 * d0 + d1 * d1 + d2 * d2;

	        if ((d3 < 1.0D || d3 > 3600.0D) && !attacking) {
	            this.waypointX = (this.posX + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 5.0F));
	            this.waypointY = (this.posY + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 5.0F));
	            this.waypointZ = (this.posZ + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 5.0F));
	        }
	
	        if (this.courseChangeCooldown-- <= 0 || this.attacking) {
	            this.courseChangeCooldown += this.rand.nextInt(5) + 2;
	            d3 = (double)MathHelper.sqrt_double(d3);
	
	            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3)  || this.attacking) {
	            	
	            	if (!this.worldObj.isRemote) {
	            		
		            	this.motionX += d0 / d3 * speed;
		                this.motionY += d1 / d3 * speed;
		                this.motionZ += d2 / d3 * speed;
		                
		                this.waypointX = (this.posX + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F));
			            this.waypointY = (this.posY + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 1.0F));
			            this.waypointZ = (this.posZ + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F));
	            	}
	            }
	            else if (!attacking) {
	                this.waypointX = this.posX;
	                this.waypointY = this.posY;
	                this.waypointZ = this.posZ;
	            }
	        }
	
	        if (this.entityToAttack != null && this.entityToAttack.isDead) {
	            this.entityToAttack = null;
	            attacking = false;
	        }
	
	        if (this.entityToAttack == null || this.aggroCooldown-- <= 0)
	        {
	            this.entityToAttack = this.worldObj.getClosestVulnerablePlayerToEntity(this, radius);
	            
	            if (this.entityToAttack == null) {
	            	this.entityToAttack = findClosestEdibleEntity();
	            }
	
	            if (this.entityToAttack != null)
	            {
	                this.aggroCooldown = 20;
	            }
	        }
	
        }
        else {
            if (!this.worldObj.isRemote) {
                this.motionX = 0.0D;
                this.motionY -= 0.08D;
                this.motionY *= 0.9800000190734863D;
                this.motionZ = 0.0D;
            }
        }
        
        if (this.getHealth() > 0.0f) {
	        AxisAlignedBB axisalignedbb = null;
	
	        if (this.ridingEntity != null && !this.ridingEntity.isDead)
	        {
	            axisalignedbb = this.boundingBox.func_111270_a(this.ridingEntity.boundingBox).expand(1.0D, 0.0D, 1.0D);
	        }
	        else
	        {
	            axisalignedbb = this.boundingBox.expand(1.0D, 0.5D, 1.0D);
	        }
	
	        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, axisalignedbb);
	
	        if (list != null)
	        {
	            for (int i = 0; i < list.size(); ++i)
	            {
	                Entity entity = (Entity)list.get(i);
	
	                if (!entity.isDead && (entity instanceof EntityPlayer || entity instanceof EntitySheep || entity instanceof EntityHorse || entity instanceof EntityPig || entity instanceof EntityChicken || entity instanceof EntityCow || entity instanceof EntityVillager))
	                {
	                	if (!(entity instanceof EntityPlayer && entity.ridingEntity instanceof EntityBoat)) {
	                		entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue());
	                	}
	                }
	            }
	        }
		}
	
        super.onLivingUpdate();
    }
	
	private EntityLivingBase findClosestEdibleEntity() {
		
		if (worldObj.loadedEntityList != null && worldObj.loadedEntityList.size() > 0) {
			float closest = Float.MAX_VALUE;
			float nextAnimal;
			EntityLivingBase animal = null;
			
			for (int i = 1; i < this.worldObj.loadedEntityList.size(); i++) {
				Object e = worldObj.loadedEntityList.get(i);
				
	        	if (e instanceof EntitySheep || e instanceof EntityHorse || e instanceof EntityPig || e instanceof EntityChicken || e instanceof EntityCow || e instanceof EntityVillager) {
	        		nextAnimal = ((Entity)worldObj.loadedEntityList.get(i)).getDistanceToEntity(this);
	        		
	        		if (nextAnimal < closest) {
	        			closest = nextAnimal;
	        			animal = ((EntityLivingBase)worldObj.loadedEntityList.get(i));
	        		}
	        	}
	    	}
			return animal;
		}
		else
			return null;
	}
	
	private void closeMouth() {
		if (topJawRotation < 0.0d || bottomJawRotation > 0.0d){
    		topJawRotation = MathHelper.clamp_double(topJawRotation + Math.toRadians(1.5f), Math.toRadians(-20f), 0.0f);
    		bottomJawRotation = MathHelper.clamp_double(bottomJawRotation - Math.toRadians(3.0f), 0.0f, Math.toRadians(40f));
    	}
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

            Block b = this.worldObj.getBlock((int)d4, (int)d5, (int)d6);
//            if (!this.worldObj.getCollidingBoundingBoxes(this, axisalignedbb).isEmpty() || !b.isAssociatedBlock(Blocks.water) || b.isAssociatedBlock(Blocks.flowing_water)) {
            if (!this.worldObj.getCollidingBoundingBoxes(this, axisalignedbb).isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    protected void updateEntityActionState() {}
	
//	@Override
//	public boolean isInWater() {
//        return this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D), Material.water, this);
//    }
	
	@Override
	protected boolean canTriggerWalking() {
        return false;
    }
	
	@Override
	public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_) {
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
    }
	
//	@Override
//	public boolean getCanSpawnHere() {
//        return this.posY > 10.0D && this.posY < 63.0D && this.worldObj.checkNoEntityCollision(this.boundingBox) && super.getCanSpawnHere();
//    }
	
	@Override
	public boolean getCanSpawnHere() {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.rand.nextInt(5) == 0 && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && ((this.worldObj.getBlock((int)posX, (int)posY, (int)posZ).isAssociatedBlock(Blocks.water) || this.worldObj.getBlock((int)posX, (int)posY, (int)posZ).isAssociatedBlock(Blocks.flowing_water)));
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
	
	public boolean canBreatheUnderwater() {
        return true;
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    @Override
    protected boolean canDespawn() {
        return true;
    }

    /**
     * Get the experience points the entity currently has.
     */
    @Override
    protected int getExperiencePoints(EntityPlayer p_70693_1_)
    {
        return 1 + this.worldObj.rand.nextInt(3);
    }

    /**
     * Gets called every tick from main Entity class
     */
    @Override
    public void onEntityUpdate()
    {
        int i = this.getAir();
        super.onEntityUpdate();

        if (this.isEntityAlive() && !this.isInWater()) {
            --i;
            this.setAir(i);

            if (this.getAir() == -20) {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.drown, 2.0F);
            }
        }
        else {
            this.setAir(300);
        }
    }
    
    @Override
    protected Item getDropItem() {
        return CoreItems.rawSharkMeat;
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected abstract void dropFewItems(boolean p_70628_1_, int p_70628_2_);
    
    public double getTopJawRotation() {
    	return topJawRotation;
    }
    
    public double getBottomJawRotation() {
    	return bottomJawRotation;
    }
}

package crazyores.packs.core.entity.golem;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.village.Village;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.packs.core.block.CoreBlocks;
import crazyores.packs.core.item.CoreItems;

public abstract class EntityGolems extends EntityGolem {

	protected int homeCheckTimer;
	protected int attackTimer;
	protected int holdRoseTick;
	protected Village village;
	
	protected EnumGolemType type;
	
	public EntityGolems(World world, float w, float h, EnumGolemType golemType) {
		super(world);
		type = golemType;
		this.dataWatcher.addObject(20, 1.0f);
		this.dataWatcher.addObject(21, w);
        this.dataWatcher.addObject(22, h);
        setScale(1.0f + (world.rand.nextFloat() * 0.2f));
		setAbilities();
	}
	
	public EntityGolems(World world, float w, float h, float s, EnumGolemType golemType) {
		super(world);
		type = golemType;
		this.dataWatcher.addObject(20, 1.0f);
		this.dataWatcher.addObject(21, w);
        this.dataWatcher.addObject(22, h);
        setScale(s);
		setAbilities();
	}
	
	protected abstract void setAbilities();
	
	@Override
	protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }
	
	@Override
	public boolean isAIEnabled() {
        return true;
    }
	
	@Override
	protected void updateAITick() {
        if (--this.homeCheckTimer <= 0) {
            this.homeCheckTimer = 70 + this.rand.nextInt(50);
            this.village = this.worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ), 32);

            if (this.village == null) {
                this.detachHome();
            }
            else {
                ChunkCoordinates chunkcoordinates = this.village.getCenter();
                this.setHomeArea(chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ, (int)((float)this.village.getVillageRadius() * 0.6F));
            }
        }

        super.updateAITick();
    }
	
	//TODO:OVERRIDE THIS IN ALL GOLEM CLASSES
	@Override
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }
	
	@Override
	protected int decreaseAirSupply(int amount) {
        return amount;
    }
	
	//TODO:OVERRIDE THIS IN ALL GOLEM CLASSES
	@Override
	protected void collideWithEntity(Entity entity) {
        if (entity instanceof IMob && this.getRNG().nextInt(20) == 0) {
            this.setAttackTarget((EntityLivingBase)entity);
        }

        super.collideWithEntity(entity);
    }
	
	/**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
	@Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        updateSize();
        
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }

        if (this.holdRoseTick > 0) {
            --this.holdRoseTick;
        }

        if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(5) == 0) {
            int i = MathHelper.floor_double(this.posX);
            int j = MathHelper.floor_double(this.posY - 0.20000000298023224D - (double)this.yOffset);
            int k = MathHelper.floor_double(this.posZ);
            Block block = this.worldObj.getBlock(i, j, k);

            if (block.getMaterial() != Material.air) {
                this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_" + this.worldObj.getBlockMetadata(i, j, k), this.posX + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, this.boundingBox.minY + 0.1D, this.posZ + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D, ((double)this.rand.nextFloat() - 0.5D) * 4.0D);
            }
        }
    }
	
	/**
     * Returns true if this entity can attack entities of the specified class.
     */
	//TODO: OVERRIDE FOR GOLEM CLASSES
	@Override
	public boolean canAttackClass(Class c) {
		if (this.type.equals(EnumGolemType.COPPER))
			return this.isPlayerCreated() && EntityPlayer.class.isAssignableFrom(c) ? false : super.canAttackClass(c);
		else
			return true;
    }
	
	/**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
	@Override
    public void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
        nbt.setBoolean("PlayerCreated", this.isPlayerCreated());
        nbt.setFloat("Width", this.getWidth());
        nbt.setFloat("Height", this.getHeight());
        nbt.setFloat("Scale", getScale());
    }
	
	/**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
	@Override
    public void readEntityFromNBT(NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);
        this.setPlayerCreated(nbt.getBoolean("PlayerCreated"));
        this.setWidth(nbt.getFloat("Width"));
        this.setHeight(nbt.getFloat("Height"));
        this.setScale(nbt.getFloat("Scale"));
    }
	
	//TODO: OVERRIDE IN GOLEM CLASSES
	@Override
	public boolean attackEntityAsMob(Entity entity) {
        this.attackTimer = 10;
        this.worldObj.setEntityState(this, (byte)4);
        
        int damage = 0;
        
        if (this.type.equals(EnumGolemType.FOOLS_RUBY)) {
        	damage = 2;
        }
        else if (this.type.equals(EnumGolemType.COPPER)) {
        	damage = 8 + rand.nextInt(15);
        }
        else if (this.type.equals(EnumGolemType.SAPPHIRE)) {
        	damage = 11 + rand.nextInt(15);
        }
        else if (this.type.equals(EnumGolemType.ADAMITE)) {
        	damage = 15 + rand.nextInt(15);
        }
        else if (this.type.equals(EnumGolemType.RUBY)) {
        	damage = 19 + rand.nextInt(15);
        }
        else if (this.type.equals(EnumGolemType.DEMONITE)) {
        	entity.setFire(20);
        	damage = 10 + rand.nextInt(15);
        }
        else if (this.type.equals(EnumGolemType.ZECTIUM)) {
        	damage = 25 + rand.nextInt(15);
        }
        else if (this.type.equals(EnumGolemType.TAPAZITE)) {
        	damage = 30 + rand.nextInt(15);
        }
        else if (this.type.equals(EnumGolemType.OSMONIUM)) {
        	damage = 39 + rand.nextInt(15);
        }
        else if (this.type.equals(EnumGolemType.STARCONIUM)) {
        	damage = 50 + rand.nextInt(15);
        }
        else if (this.type.equals(EnumGolemType.ENDER)) {
        	damage = 60 + rand.nextInt(15);
        }
        
        boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), damage);

        if (flag) {
        	entity.motionY += 0.4000000059604645D * (1 + type.ordinal() * 0.2);
        }

        this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
        return flag;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte b) {
        if (b == 4) {
            this.attackTimer = 10;
            this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
        }
        else if (b == 11) {
            this.holdRoseTick = 400;
        }
        else {
            super.handleHealthUpdate(b);
        }
    }
	
	public Village getVillage() {
        return this.village;
    }

    @SideOnly(Side.CLIENT)
    public int getAttackTimer() {
        return this.attackTimer;
    }

    public void setHoldingRose(boolean shouldHoldRose) {
        this.holdRoseTick = shouldHoldRose ? 400 : 0;
        this.worldObj.setEntityState(this, (byte)11);
    }
    
    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound() {
        return "mob.irongolem.hit";
    }
 
    /**
     * Returns the sound this mob makes on death.
     */
    @Override
    protected String getDeathSound() {
        return "mob.irongolem.death";
    }
    
    @Override
    protected void func_145780_a(int x, int y, int z, Block block) {
        this.playSound("mob.irongolem.walk", 1.0F, 1.0F);
    }
    
    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    @Override
    protected void dropFewItems(boolean recentlyHit, int lootingLevel) {
    	int j = this.rand.nextInt(3);
        int k;

        if (this instanceof EntityCopperGolem) {
        	j += 1;
	        for (k = 0; k < j; ++k) {
	            this.func_145778_a(Item.getItemFromBlock(Blocks.red_flower), 1, 0.0F);
	        }
        }
        
        if (this instanceof EntityFoolsRubyGolem) {
        	int drops = (int)this.getScale() * (7 + rand.nextInt(2));
        	for (int i = 0; i < drops; i++) {
        		this.dropItem(CoreItems.foolsRubyMush, 1);
        	}
        }

        k = 4 + this.rand.nextInt(4);

        for (int l = 0; l < k; ++l) {
        	if (this instanceof EntityCopperGolem)
        		this.dropItem(CoreItems.copperIngot, 1);
        	else if (this instanceof EntitySapphireGolem)
        		this.dropItem(CoreItems.sapphireGem, 1);
        	else if (this instanceof EntityAdamiteGolem)
        		this.dropItem(CoreItems.adamiteShard, 1);
        	else if (this instanceof EntityRubyGolem)
        		this.dropItem(CoreItems.rubyGem, 1);
        	else if (this instanceof EntityZectiumGolem)
        		this.dropItem(CoreItems.zectiumIngot, 1);
        	else if (this instanceof EntityTapaziteGolem)
        		this.dropItem(CoreItems.tapaziteObelisk, 1);
        	else if (this instanceof EntityOsmoniumGolem)
        		this.dropItem(CoreItems.osmoniumIngot, 1);
        	else if (this instanceof EntityStarconiumGolem)
        		this.dropItem(CoreItems.starconiumGem, 1);
        	else if (this instanceof EntityDemoniteGolem)
        		this.dropItem(CoreItems.demoniteOrb, 1);
        	else if (this instanceof EntityEnderGolem)
        		this.dropItem(CoreItems.enderGem, 1);
        }
        
        k = 1 + rand.nextInt(2);
        
        for (int l = 0; l < k; ++l) {
        	if (this instanceof EntityCopperGolem)
        		this.dropItem(Item.getItemFromBlock(CoreBlocks.copperBlock), 1);
        	else if (this instanceof EntitySapphireGolem)
        		this.dropItem(Item.getItemFromBlock(CoreBlocks.sapphireBlock), 1);
        	else if (this instanceof EntityAdamiteGolem)
        		this.dropItem(Item.getItemFromBlock(CoreBlocks.adamiteBlock), 1);
        	else if (this instanceof EntityRubyGolem)
        		this.dropItem(Item.getItemFromBlock(CoreBlocks.rubyBlock), 1);
        	else if (this instanceof EntityZectiumGolem)
        		this.dropItem(Item.getItemFromBlock(CoreBlocks.zectiumBlock), 1);
        	else if (this instanceof EntityTapaziteGolem)
        		this.dropItem(Item.getItemFromBlock(CoreBlocks.tapaziteBlock), 1);
        	else if (this instanceof EntityOsmoniumGolem)
        		this.dropItem(Item.getItemFromBlock(CoreBlocks.osmoniumBlock), 1);
        	else if (this instanceof EntityStarconiumGolem)
        		this.dropItem(Item.getItemFromBlock(CoreBlocks.starconiumBlock), 1);
        	else if (this instanceof EntityDemoniteGolem)
        		this.dropItem(Item.getItemFromBlock(CoreBlocks.demoniteBlock), 1);
        	else if (this instanceof EntityEnderGolem)
        		this.dropItem(Item.getItemFromBlock(CoreBlocks.enderBlock), 1);
        }
    }
    
    public int getHoldRoseTick() {
        return this.holdRoseTick;
    }
    
    public boolean isPlayerCreated() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }
    
    public void setPlayerCreated(boolean b) {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (b) {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
        }
        else {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -2)));
        }
    }
    
    /**
     * Called when the mob's health reaches 0.
     */
    @Override
    public void onDeath(DamageSource source) {
        if (!this.isPlayerCreated() && this.attackingPlayer != null && this.village != null) {
            this.village.setReputationForPlayer(this.attackingPlayer.getCommandSenderName(), -5);
        }
        super.onDeath(source);
    }
    
    public void setScale(float s) {
    	dataWatcher.updateObject(20, s);
    	updateSize();
    }
    
    public void setWidth(float w) {
    	dataWatcher.updateObject(21, w);
    }
    
    public void setHeight(float h) {
    	dataWatcher.updateObject(22, h);
    }
    
    public float getWidth() {
    	return dataWatcher.getWatchableObjectFloat(21);
    }
    
    public float getHeight() {
    	return dataWatcher.getWatchableObjectFloat(22);
    }
    
    public float getScale() {
    	return dataWatcher.getWatchableObjectFloat(20);
    }

    
	public void updateSize() {
		setSize(getWidth() * getScale(), getHeight() * getScale());
	}
}

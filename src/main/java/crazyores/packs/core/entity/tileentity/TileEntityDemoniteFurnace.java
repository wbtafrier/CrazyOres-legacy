package crazyores.packs.core.entity.tileentity;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.packs.core.block.BlockDemoniteFurnace;
import crazyores.packs.core.block.CoreBlocks;
import crazyores.packs.core.item.CoreItems;
import crazyores.packs.core.recipe.DemoniteFurnaceRecipes;

public class TileEntityDemoniteFurnace extends TileEntity implements ISidedInventory {

	private Random rand = new Random();
	private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides = new int[] {1};
    
    public int overHeat = 0;
    public int heatUpAmount = 50;
    public int timeAlive = 0;
    public int smeltingSpeed = 150;
    
    public static final int MAX_HEAT = 10000;
    public static final int NO_RETURN = MAX_HEAT - 2000;
    public static final int MAX_TIME_ALIVE = 2000;
    public static final int MAX_HEAT_UP_INCREMENT = 100;
    public static final int MAX_SMELTING_SPEED = 600;
    
	/*
	 * slot 0 = cook1 slot
	 * slot 1 = cook2 slot
	 * slot 2 = fuel slot
	 * slot 3 = result slot
	 */
    private ItemStack[] furnaceItemStacks = new ItemStack[4];
    
    /** The number of ticks that the furnace will keep burning */
    public int furnaceBurnTime;
    
    /** The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for */
    public int currentItemBurnTime;
    
    /** The number of ticks that the current item has been cooking for */
    public int furnaceCookTime;
    private String customName;

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory() {
        return this.furnaceItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int slot) {
        return this.furnaceItemStacks[slot];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int starSlot, int endSlot) {
        if (this.furnaceItemStacks[starSlot] != null) {
            ItemStack itemstack;

            if (this.furnaceItemStacks[starSlot].stackSize <= endSlot) {
                itemstack = this.furnaceItemStacks[starSlot];
                this.furnaceItemStacks[starSlot] = null;
                return itemstack;
            }
            else {
                itemstack = this.furnaceItemStacks[starSlot].splitStack(endSlot);

                if (this.furnaceItemStacks[starSlot].stackSize == 0) {
                    this.furnaceItemStacks[starSlot] = null;
                }

                return itemstack;
            }
        }
        else {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int slot) {
        if (this.furnaceItemStacks[slot] != null) {
            ItemStack itemstack = this.furnaceItemStacks[slot];
            this.furnaceItemStacks[slot] = null;
            return itemstack;
        }
        else {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int slot, ItemStack stack) {
        this.furnaceItemStacks[slot] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
        	stack.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory
     */
    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.customName : "container.demonite_furnace";
    }

    /**
     * Returns if the inventory is named
     */
    public boolean hasCustomInventoryName() {
        return this.customName != null && this.customName.length() > 0;
    }

    public void setCustomName(String name) {
        this.customName = name;
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.furnaceItemStacks.length) {
                this.furnaceItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.furnaceBurnTime = nbt.getShort("BurnTime");
        this.furnaceCookTime = nbt.getShort("CookTime");
        this.overHeat = nbt.getShort("OverHeat");
        
        this.timeAlive = nbt.getInteger("TimeAlive");
        this.heatUpAmount = nbt.getShort("HeatUpAmount");
        this.smeltingSpeed = nbt.getShort("SmeltingSpeed");
        
        this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[2]);

        if (nbt.hasKey("CustomName", 8)) {
            this.customName = nbt.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        NBTTagList nbttaglist = new NBTTagList();
        
        nbt.setTag("Items", nbttaglist);
        for (int i = 0; i < this.furnaceItemStacks.length; ++i) {
            if (this.furnaceItemStacks[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.furnaceItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }
        
        nbt.setShort("BurnTime", (short)this.furnaceBurnTime);
        nbt.setShort("CookTime", (short)this.furnaceCookTime);
        nbt.setShort("OverHeat", (short)this.overHeat);
        
        nbt.setInteger("TimeAlive", this.timeAlive);
        nbt.setShort("HeatUpAmount", (short)this.heatUpAmount);
        nbt.setShort("SmeltingSpeed", (short)this.smeltingSpeed);
        
        if (this.hasCustomInventoryName()) {
        	nbt.setString("CustomName", this.customName);
        }
    }

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    public int getInventoryStackLimit() {
        return 64;
    }

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int progress) {
        return this.furnaceCookTime * progress / smeltingSpeed;
    }

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int timeRemaining) {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = 200;
        }
        
        int i = this.furnaceBurnTime * timeRemaining / this.currentItemBurnTime;
//        System.out.println(i);
        return i;
    }
    
    @SideOnly(Side.CLIENT)
    public int getAgeTimeScaled(int age) {
//    	System.out.println("AGE: " + (int)(((float)this.timeAlive) / (float)MAX_TIME_ALIVE * age));
    	return (int)(((float)this.timeAlive) / (float)MAX_TIME_ALIVE * age);
    }
    
    @SideOnly(Side.CLIENT)
    public int getWarmthTimeScaled(int warmth) {
//    	System.out.println("WARMTH: " + (int)(((float)this.overHeat) / (float)MAX_HEAT * warmth));
    	return (int)(((float)this.overHeat) / (float)MAX_HEAT * warmth);
    }

    /**
     * DemoniteFurnace isBurning
     */
    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }

    public void updateEntity() {
    	boolean update = false;
    	boolean flag = this.furnaceBurnTime > 0;
    	
    	if (worldObj.isRemote) {
    		this.spawnSmokeParticles(worldObj, xCoord, yCoord, zCoord);
    	}
    	
    	int coolingAmount = getCoolingAmount(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		
		if (this.furnaceBurnTime > 0) {
			--this.furnaceBurnTime;
    		
//			System.out.println("OVERHEAT: " + overHeat);
//			System.out.println("COOLING AMOUNT: " + coolingAmount);
			
            if (overHeat > 0 && rand.nextInt(overHeat) > MAX_HEAT / 10) {
            	timeAlive = MathHelper.clamp_int(timeAlive + 1, 0, MAX_TIME_ALIVE);
            	
            	if (timeAlive % (MAX_TIME_ALIVE / 50) == 0) {
//            		System.out.println("SMELTING SPEED: " + smeltingSpeed + " | HEAT UP AMOUNT: " + heatUpAmount);
            		smeltingSpeed = MathHelper.clamp_int(smeltingSpeed + 9, 0, MAX_SMELTING_SPEED);
            		heatUpAmount = MathHelper.clamp_int(heatUpAmount + 1, 0, MAX_HEAT_UP_INCREMENT);
            	}
            }
            
            overHeat = MathHelper.clamp_int((overHeat + heatUpAmount) - coolingAmount, 0, MAX_HEAT);
        }
		else {
    		if (coolingAmount >= 0) overHeat = MathHelper.clamp_int(overHeat - coolingAmount, 0, MAX_HEAT);
    	}
		update = overHeat > 0;
    	
    	if (!this.worldObj.isRemote) {
    		
//        	System.out.println("TIME ALIVE: " + timeAlive);
//        	System.out.println("HEATUP AMOUNT: " + heatUpAmount);
//        	System.out.println("TIME ALIVE: " + timeAlive);
//        	System.out.println("SMELTING SPEED: " + smeltingSpeed);
    		updateSurroundingBlocks(worldObj, xCoord, yCoord, zCoord);
    		
        	if (overHeat >= MAX_HEAT /*|| timeAlive >= MAX_TIME_ALIVE*/) {
        		worldObj.newExplosion(null, xCoord, yCoord, zCoord, BlockDemoniteFurnace.EXPLOSION_STRENGTH, true, true);
        	}
    		
	        if (this.furnaceBurnTime != 0 || this.furnaceItemStacks[2] != null && this.furnaceItemStacks[0] != null && this.furnaceItemStacks[1] != null) {
	        	if (this.furnaceBurnTime == 0 && this.canSmelt()) {
	                this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[2]);
	
	                if (this.furnaceBurnTime > 0) {
	                    update = true;
	
	                    if (this.furnaceItemStacks[2] != null) {
	                        --this.furnaceItemStacks[2].stackSize;
	
	                        if (this.furnaceItemStacks[2].stackSize == 0) {
	                            this.furnaceItemStacks[2] = furnaceItemStacks[2].getItem().getContainerItem(furnaceItemStacks[2]);
	                        }
	                    }
	                }
	            }
	
	            if (this.isBurning() && this.canSmelt()) {
	                ++this.furnaceCookTime;
	
	                if (this.furnaceCookTime == smeltingSpeed) {
	                    this.furnaceCookTime = 0;
	                    this.smeltItem();
	                    update = true;
	                }
	            }
	            else {
	                this.furnaceCookTime = 0;
	            }
	        }
	
	        if (flag != this.furnaceBurnTime > 0) {
	            update = true;
	            BlockDemoniteFurnace.updateBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	        }
    	}
	        
        if (update) {
        	this.markDirty();
        }
    }
    
    private int getCoolingAmount(World world, int x, int y, int z) {
    	Block block;
    	int amount = 0;
    	int demonditeFurnaceCounter = 0;
    	
    	for (int xOffset = -1; xOffset < 2; xOffset++) {
    		for (int yOffset = -1; yOffset < 2; yOffset++) {
    			for (int zOffset = -1; zOffset < 2; zOffset++) {
    				block = world.getBlock(x + xOffset, y + yOffset, z + zOffset);
    				
    				if (demonditeFurnaceCounter == 0 && block.isAssociatedBlock(CoreBlocks.demoniteFurnaceLit)) {
    					demonditeFurnaceCounter++;
    					continue;
    				}
    				else {
    					int a = getAmount(block);
    					amount += (xOffset == 0 && yOffset == -1 && zOffset == 0) ? a * 2 : a;
    				}
    			}
    		}
    	}
    	return amount;
    }
    
    private void updateSurroundingBlocks(World world, int x, int y, int z) {
    	
    	if (overHeat < 100) return;
    	
    	if (rand.nextInt(overHeat >= NO_RETURN ? 100 : (MAX_HEAT - overHeat) / 2) < 50) {
    		
    		if (overHeat >= NO_RETURN) {
        		Block b = world.getBlock(x, y + 1, z);
        		
        		if (b.isAssociatedBlock(Blocks.ice) || b.isAssociatedBlock(Blocks.snow) || b.isAssociatedBlock(Blocks.packed_ice)) {
        			world.setBlock(x, y + 1, z, Blocks.water);
        			return;
        		}
        		else if (b.isAssociatedBlock(Blocks.snow_layer)) {
        			world.setBlock(x, y + 1, z, Blocks.air);
        			return;
        		}
        	}
    		
			int randX = rand.nextInt(3) - 1;
    		int randY = rand.nextInt(3) - 1;
    		int randZ = rand.nextInt(3) - 1;
//    		System.out.println("MELTING BLOCK AT: (" + x + randX + ", " + y + randY + ", " + z + randZ + ")");
    		
			Block b = world.getBlock(x + randX, y + randY, z + randZ);
			
			if (b.isAssociatedBlock(Blocks.ice) || b.isAssociatedBlock(Blocks.snow)) {
				world.setBlock(x + randX, y + randY, z + randZ, Blocks.water);
			}
			else if (b.isAssociatedBlock(Blocks.snow_layer)) {
				world.setBlock(x + randX, y + randY, z + randZ, Blocks.air);
    			return;
    		}
    	}
    }
    
    private int getAmount(Block b) {
    	if (b.isAssociatedBlock(CoreBlocks.demoniteFurnaceLit)) return -40;
    	else if (b.isAssociatedBlock(Blocks.lava) || b.isAssociatedBlock(Blocks.flowing_lava)) return -20;
    	else if (b.isAssociatedBlock(Blocks.fire)) return -10;
    	else if (b.isAssociatedBlock(Blocks.water) || b.isAssociatedBlock(Blocks.flowing_water) || b.isAssociatedBlock(Blocks.snow_layer)) return 2;
    	else if (b.isAssociatedBlock(Blocks.snow)) return 3;
    	else if (b.isAssociatedBlock(Blocks.ice)) return 4;
    	else if (b.isAssociatedBlock(Blocks.packed_ice)) return 5;
    	else return 0;
    }
    
    @SideOnly(Side.CLIENT)
    private void spawnSmokeParticles(World world, int x, int y, int z) {
		
    	int metadata = world.getBlockMetadata(x, y, z);
    	
    	float xOffset = x;
    	float yOffset = y;
    	float zOffset = z;
    	int particleAmount = (overHeat / 400);
    	
    	final int HELL_FIRE = 5;
    	
    	//Facing towards the negative z axis
    	if (metadata == 2) {
    		
    		if (overHeat > NO_RETURN) {
    			for (int i = 0; i < particleAmount; i++) {
        			xOffset = x + (rand.nextFloat() * 0.5f);
            		zOffset = z + rand.nextFloat();
            		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, -0.02D, 0.2D, 0.0D);
            		
            		if (rand.nextInt(HELL_FIRE) == 0) {
            			xOffset = x + (rand.nextFloat() * 0.5f);
                		zOffset = z + rand.nextFloat();
            			world.spawnParticle("flame", (float)xOffset, (float)yOffset, (float)zOffset, -0.02D, 0.2D, 0.0D);
            		}
            		
            		xOffset = x + rand.nextFloat();
            		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, 0.0D, 0.2D, 0.02D);
            		
            		if (rand.nextInt(HELL_FIRE) == 0) {
            			xOffset = x + rand.nextFloat();
            			world.spawnParticle("flame", (float)xOffset, (float)yOffset, (float)zOffset, 0.0D, 0.2D, 0.02D);
            		}
            		
            		xOffset = x + (1 - (rand.nextFloat() * 0.5f));
            		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, 0.02D, 0.2D, 0.0D);
        		
            		if (rand.nextInt(HELL_FIRE) == 0) {
            			xOffset = x + (1 - (rand.nextFloat() * 0.5f));
                		world.spawnParticle("flame", (float)xOffset, (float)yOffset, (float)zOffset, 0.02D, 0.2D, 0.0D);
            		}
            		
        		}
    		}
    		else {
    			for (int i = 0; i < particleAmount; i++) {
        			xOffset = x + (rand.nextFloat() * 0.5f);
            		zOffset = z + rand.nextFloat();
            		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, -0.05D - (overHeat / (MAX_HEAT * 2)), 0.0D, 0.0D);
            		
            		xOffset = x + rand.nextFloat();
            		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, 0.0D, 0.0D, 0.05D + (overHeat / (MAX_HEAT * 2)));
            		
            		xOffset = x + (1 - (rand.nextFloat() * 0.5f));
            		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, 0.05D + (overHeat / (MAX_HEAT * 2)), 0.0D, 0.0D);
        		}
    		}
    	}
    	//Facing towards the positive z axis
    	else if (metadata == 3) {
    		
			if (overHeat > NO_RETURN) {
    			for (int i = 0; i < particleAmount; i++) {
        			xOffset = x + (rand.nextFloat() * 0.5f);
            		zOffset = z + rand.nextFloat();
            		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, -0.02D, 0.2D, 0.0D);
            		
            		if (rand.nextInt(HELL_FIRE) == 0) {
            			xOffset = x + (rand.nextFloat() * 0.5f);
                		zOffset = z + rand.nextFloat();
            			world.spawnParticle("flame", (float)xOffset, (float)yOffset, (float)zOffset, -0.02D, 0.2D, 0.0D);
            		}
            		
            		xOffset = x + rand.nextFloat();
            		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, 0.0D, 0.2D, -0.02D);
            		
            		if (rand.nextInt(HELL_FIRE) == 0) {
            			xOffset = x + rand.nextFloat();
            			world.spawnParticle("flame", (float)xOffset, (float)yOffset, (float)zOffset, 0.0D, 0.2D, -0.02D);
            		}
            		
            		xOffset = x + (1 - (rand.nextFloat() * 0.5f));
            		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, 0.02D, 0.2D, 0.0D);
        		
            		if (rand.nextInt(HELL_FIRE) == 0) {
            			xOffset = x + (1 - (rand.nextFloat() * 0.5f));
                		world.spawnParticle("flame", (float)xOffset, (float)yOffset, (float)zOffset, 0.02D, 0.2D, 0.0D);
            		}
        		}
    		}
    		else {
    			for (int i = 0; i < particleAmount; i++) {
    				
    				xOffset = x + (rand.nextFloat() * 0.5f);
            		zOffset = z + rand.nextFloat();
            		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, -0.05D - (overHeat / (MAX_HEAT * 2)), 0.0D, 0.0D);
    				
    				xOffset = x + rand.nextFloat();
    				world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, 0.0D, 0.0D, -0.05D - (overHeat / (MAX_HEAT * 2)));
    				
    				xOffset = x + (1 - (rand.nextFloat() * 0.5f));
            		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, 0.05D + (overHeat / (MAX_HEAT * 2)), 0.0D, 0.0D);
        		}
    		}
    	}
    	//Facing towards the negative x axis       
    	else if (metadata == 4) {
    		if (overHeat > NO_RETURN) {
    			for (int i = 0; i < particleAmount; i++) {
    				
    				xOffset = x + rand.nextFloat();
            		zOffset = z + (rand.nextFloat() * 0.5f);
            		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, 0.0D, 0.2D, -0.02D);
            		
            		if (rand.nextInt(HELL_FIRE) == 0) {
            			xOffset = x + rand.nextFloat();
                		zOffset = z + (rand.nextFloat() * 0.5f);
                		world.spawnParticle("flame", (float)xOffset, (float)yOffset, (float)zOffset, 0.0D, 0.2D, -0.02D);
            		}
            		
            		zOffset = z + rand.nextFloat();
    				world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, 0.02D, 0.2D, 0.0D);
            		
    				if (rand.nextInt(HELL_FIRE) == 0) {
    					zOffset = z + rand.nextFloat();
        				world.spawnParticle("flame", (float)xOffset, (float)yOffset, (float)zOffset, 0.02D, 0.2D, 0.0D);
            		}
    				
            		xOffset = x + rand.nextFloat();
            		zOffset = z + (1 - (rand.nextFloat() * 0.5f));
            		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, 0.0D, 0.2D, 0.02D);
            		
            		if (rand.nextInt(HELL_FIRE) == 0) {
            			xOffset = x + rand.nextFloat();
                		zOffset = z + (1 - (rand.nextFloat() * 0.5f));
                		world.spawnParticle("flame", (float)xOffset, (float)yOffset, (float)zOffset, 0.0D, 0.2D, 0.02D);
            		}
        		}
    		}
    		else {
    			for (int i = 0; i < particleAmount; i++) {
    				
    				xOffset = x + rand.nextFloat();
            		zOffset = z + (rand.nextFloat() * 0.5f);
            		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, 0.0D, 0.0D, -0.05D - (overHeat / (MAX_HEAT * 2)));
            		
            		zOffset = z + rand.nextFloat();
    				world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, 0.05D + (overHeat / (MAX_HEAT * 2)), 0.0D, 0.0D);
            		
            		xOffset = x + rand.nextFloat();
            		zOffset = z + (1 - (rand.nextFloat() * 0.5f));
            		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, 0.0D, 0.0D, 0.05D + (overHeat / (MAX_HEAT * 2)));
        		}
    		}
    	}
    	//Facing towards the positive x axis
    	else if (metadata == 5) {
    		if (overHeat > NO_RETURN) {
    			
				for (int i = 0; i < particleAmount; i++) {
					
					xOffset = x + rand.nextFloat();
	        		zOffset = z + (rand.nextFloat() * 0.5f);
	        		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, 0.0D, 0.2D, -0.02D);
	        		
	        		if (rand.nextInt(HELL_FIRE) == 0) {
	        			xOffset = x + rand.nextFloat();
	            		zOffset = z + (rand.nextFloat() * 0.5f);
	            		world.spawnParticle("flame", (float)xOffset, (float)yOffset, (float)zOffset, 0.0D, 0.2D, -0.02D);
	        		}
	        		
	        		zOffset = z + rand.nextFloat();
					world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, -0.02D, 0.2D, 0.0D);
	        		
					if (rand.nextInt(HELL_FIRE) == 0) {
						zOffset = z + rand.nextFloat();
	    				world.spawnParticle("flame", (float)xOffset, (float)yOffset, (float)zOffset, -0.02D, 0.2D, 0.0D);
	        		}
					
	        		xOffset = x + rand.nextFloat();
	        		zOffset = z + (1 - (rand.nextFloat() * 0.5f));
	        		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, 0.0D, 0.2D, 0.02D);
	        		
	        		if (rand.nextInt(HELL_FIRE) == 0) {
	        			xOffset = x + rand.nextFloat();
	            		zOffset = z + (1 - (rand.nextFloat() * 0.5f));
	            		world.spawnParticle("flame", (float)xOffset, (float)yOffset, (float)zOffset, 0.0D, 0.2D, 0.02D);
	        		}
	    		}
			}
			else {
				for (int i = 0; i < particleAmount; i++) {
					
					xOffset = x + rand.nextFloat();
	        		zOffset = z + (rand.nextFloat() * 0.5f);
	        		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, 0.0D, 0.0D, -0.05D - (overHeat / (MAX_HEAT * 2)));
	        		
	        		zOffset = z + rand.nextFloat();
					world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, -0.05D - (overHeat / (MAX_HEAT * 2)), 0.0D, 0.0D);
	        		
	        		xOffset = x + rand.nextFloat();
	        		zOffset = z + (1 - (rand.nextFloat() * 0.5f));
	        		world.spawnParticle("smoke", (float)xOffset, (float)yOffset, (float)zOffset, 0.0D, 0.0D, 0.05D + (overHeat / (MAX_HEAT * 2)));
	    		}
			}
    	}
    }

    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt() {
        if (this.furnaceItemStacks[0] == null || this.furnaceItemStacks[1] == null) {
        	return false;
        }
        else {
            ItemStack itemstack = DemoniteFurnaceRecipes.instance().getSmeltingResult(this.furnaceItemStacks[0], this.furnaceItemStacks[1]);
            
            if (itemstack == null) {
            	return false;
            }
            if (this.furnaceItemStacks[3] == null) {
            	return true;
            }
            if (!this.furnaceItemStacks[3].isItemEqual(itemstack)) {
            	return false;
            }
            int result = furnaceItemStacks[3].stackSize + itemstack.stackSize;
            
            return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[3].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack itemstack = DemoniteFurnaceRecipes.instance().getSmeltingResult(this.furnaceItemStacks[0], this.furnaceItemStacks[1]);

            if (this.furnaceItemStacks[3] == null) {
                this.furnaceItemStacks[3] = itemstack.copy();
            }
            else if (this.furnaceItemStacks[3].isItemEqual(itemstack)) {
                this.furnaceItemStacks[3].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.furnaceItemStacks[0].stackSize;
            if (this.furnaceItemStacks[0].stackSize <= 0) {
                this.furnaceItemStacks[0] = null;
            }
            
            --this.furnaceItemStacks[1].stackSize;
            if (this.furnaceItemStacks[1].stackSize <= 0) {
                this.furnaceItemStacks[1] = null;
            }
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack stack) {
        if (stack == null) {
            return 0;
        }
        else {
            Item item = stack.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab) {
                    return 150;
                }

                if (block.getMaterial() == Material.wood) {
                    return 300;
                }

                if (block == Blocks.coal_block) {
                    return 16000;
                }
            }

            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(stack);
        }
    }

    public static boolean isItemFuel(ItemStack stack){
        /**
         * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
         * fuel
         */
        return getItemBurnTime(stack) > 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {}

    public void closeInventory() {}
    
    @Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tagCompound = new NBTTagCompound();
		writeToNBT(tagCompound);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tagCompound);
	}
    
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		NBTTagCompound tag = pkt.func_148857_g();
		readFromNBT(tag);
	}
    
    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return slot == 3 ? false : (slot == 2 ? isItemFuel(stack) : true);
    }

    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     */
    public int[] getAccessibleSlotsFromSide(int idk) {
        return idk == 0 ? slotsBottom : (idk == 1 ? slotsTop : slotsSides);
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return this.isItemValidForSlot(p_102007_1_, p_102007_2_);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return p_102008_3_ != 0 || p_102008_1_ != 1 || p_102008_2_.getItem() == Items.bucket || p_102008_2_.getItem() == CoreItems.copperBucketEmpty;
    }
}

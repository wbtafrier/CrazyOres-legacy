package crazyores_core.common.tileentity;

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
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores_core.common.blocks.BlockDemoniteFurnace;

public class TileEntityDemoniteFurnace extends TileEntity implements ISidedInventory
{
	private static final int[] field_102010_d = new int[] {0};
    private static final int[] field_102011_e = new int[] {2, 1};
    private static final int[] field_102009_f = new int[] {1};
    
	public int[] size = new int[] {1};
	
    public ItemStack[] demonitefurnaceItemStacks = new ItemStack[4];
    public int demonitefurnaceBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int demonitefurnaceCookTime = 0;
    private String customName;
    
    public TileEntityDemoniteFurnace(){

    }
    
    public int getSizeInventory()
    {
        return this.demonitefurnaceItemStacks.length;
    }
    
    public ItemStack getStackInSlot(int par1)
    {
        return this.demonitefurnaceItemStacks[par1];
    }
    
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.demonitefurnaceItemStacks[par1] != null)
        {
            ItemStack var3;

            if (this.demonitefurnaceItemStacks[par1].stackSize <= par2)
            {
                var3 = this.demonitefurnaceItemStacks[par1];
                this.demonitefurnaceItemStacks[par1] = null;
                return var3;
            }
            else
            {
                var3 = this.demonitefurnaceItemStacks[par1].splitStack(par2);

                if (this.demonitefurnaceItemStacks[par1].stackSize == 0)
                {
                    this.demonitefurnaceItemStacks[par1] = null;
                }

                return var3;
            }
        }
        else
        {
            return null;
        }
    }
    
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.demonitefurnaceItemStacks[par1] != null)
        {
            ItemStack var2 = this.demonitefurnaceItemStacks[par1];
            this.demonitefurnaceItemStacks[par1] = null;
            return var2;
        }
        else
        {
            return null;
        }
    }
    
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.demonitefurnaceItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }
    
    /**
     * If this returns false, the inventory name will be used as an unlocalized name, and translated into the player's
     * language. Otherwise it will be used directly.
     */
    public boolean isInvNameLocalized()
    {
        return this.customName != null && this.customName.length() > 0;
    }

    /**
     * Sets the custom display name to use when opening a GUI linked to this tile entity.
     */
    public void setGuiDisplayName(String par1Str)
    {
        this.customName = par1Str;
    }
    
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items", 10);
        this.demonitefurnaceItemStacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.getCompoundTagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.demonitefurnaceItemStacks.length)
            {
                this.demonitefurnaceItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.demonitefurnaceBurnTime = par1NBTTagCompound.getShort("BurnTime");
        this.demonitefurnaceCookTime = par1NBTTagCompound.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.demonitefurnaceItemStacks[2]);
        
        if (par1NBTTagCompound.hasKey("CustomName"))
        {
            this.customName = par1NBTTagCompound.getString("CustomName");
        }
    }
    
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("BurnTime", (short)this.demonitefurnaceBurnTime);
        par1NBTTagCompound.setShort("CookTime", (short)this.demonitefurnaceCookTime);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.demonitefurnaceItemStacks.length; ++var3)
        {
            if (this.demonitefurnaceItemStacks[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.demonitefurnaceItemStacks[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        par1NBTTagCompound.setTag("Items", var2);
        
        if (this.isInvNameLocalized())
        {
            par1NBTTagCompound.setString("CustomName", this.customName);
        }
    }
    
    public int getInventoryStackLimit()
    {
        return 64;
    }
    
    /**
     * Return true if item is a fuel source (getItemBurnTime() > 0).
     */
    public static boolean isItemFuel(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }
    
    public int getCookProgressScaled(int par1)
    {
        return this.demonitefurnaceCookTime * par1 / 200;
    }
    
    public int getBurnTimeRemainingScaled(int par1)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 200;
        }

        return this.demonitefurnaceBurnTime * par1 / this.currentItemBurnTime;
    }
    
    public boolean isBurning()
    {
        return this.demonitefurnaceBurnTime > 0;
    }
    
    public void updateEntity()
    {
        boolean var1 = this.demonitefurnaceBurnTime > 0;
        boolean var2 = false;

        if (this.demonitefurnaceBurnTime > 0)
        {
            --this.demonitefurnaceBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.demonitefurnaceBurnTime == 0 && this.canSmelt())
            {
                this.currentItemBurnTime = this.demonitefurnaceBurnTime = getItemBurnTime(this.demonitefurnaceItemStacks[2]);

                if (this.demonitefurnaceBurnTime > 0)
                {
                    var2 = true;

                    if (this.demonitefurnaceItemStacks[2] != null)
                    {
                        --this.demonitefurnaceItemStacks[2].stackSize;

                        if (this.demonitefurnaceItemStacks[2].stackSize == 0)
                        {
                            this.demonitefurnaceItemStacks[2] = this.demonitefurnaceItemStacks[2].getItem().getContainerItem(demonitefurnaceItemStacks[2]);
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt())
            {
                ++this.demonitefurnaceCookTime;

                if (this.demonitefurnaceCookTime == 200)
                {
                    this.demonitefurnaceCookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            }
            else
            {
                this.demonitefurnaceCookTime = 0;
            }

            if (var1 != this.demonitefurnaceBurnTime > 0)
            {
                var2 = true;
                BlockDemoniteFurnace.updateDemoniteFurnaceBlockState(this.demonitefurnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (var2)
        {
            this.markDirty();
        }
    }
    
    public boolean canSmelt()
    {
        if (this.demonitefurnaceItemStacks[0] == null || this.demonitefurnaceItemStacks[1] == null)
        {
            return false;
        }
        else
        {
            ItemStack var1 = DemoniteFurnaceRecipes.smelting().getSmeltingResult(this.demonitefurnaceItemStacks[0], this.demonitefurnaceItemStacks[1]);
            if (var1 == null) return false;
            if (this.demonitefurnaceItemStacks[3] == null) return true;
            if (!this.demonitefurnaceItemStacks[3].isItemEqual(var1)) return false;
            int result = demonitefurnaceItemStacks[3].stackSize + var1.stackSize;
            return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
        }
    }
    
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack var1 = DemoniteFurnaceRecipes.smelting().getSmeltingResult(this.demonitefurnaceItemStacks[0], this.demonitefurnaceItemStacks[1]);

            if (this.demonitefurnaceItemStacks[3] == null)
            {
                this.demonitefurnaceItemStacks[3] = var1.copy();
            }
            else if (this.demonitefurnaceItemStacks[3].isItemEqual(var1))
            {
                this.demonitefurnaceItemStacks[3].stackSize += var1.stackSize;
            }

            --this.demonitefurnaceItemStacks[0].stackSize;

            if (this.demonitefurnaceItemStacks[0].stackSize <= 0)
            {
                this.demonitefurnaceItemStacks[0] = null;
            }
            
            --this.demonitefurnaceItemStacks[1].stackSize;

            if (this.demonitefurnaceItemStacks[1].stackSize <= 0)
            {
                this.demonitefurnaceItemStacks[1] = null;
            }
        }
    }
    
    public static int getItemBurnTime(ItemStack par0ItemStack)
    {
        if (par0ItemStack == null)
        {
            return 0;
        }
        else
        {
            Item var2 = par0ItemStack.getItem();

            if (par0ItemStack.getItem() instanceof ItemBlock && Block.getBlockFromItem(var2) != Blocks.air)
            {
                Block var3 = Block.getBlockFromItem(var2);

                if (var3 == Blocks.wooden_slab)
                {
                    return 150;
                }

                if (var3.getMaterial() == Material.wood)
                {
                    return 300;
                }
                
                if (var3 == Blocks.coal_block)
                {
                    return 16000;
                }
            }
            if (var2 instanceof ItemTool && ((ItemTool) var2).getToolMaterialName().equals("WOOD")) return 200;
            if (var2 instanceof ItemSword && ((ItemSword) var2).getToolMaterialName().equals("WOOD")) return 200;
            if (var2 instanceof ItemHoe && ((ItemHoe) var2).getToolMaterialName().equals("WOOD")) return 200;
            if (var2 == Items.stick) return 100;
            if (var2 == Items.coal) return 1600;
            if (var2 == Items.lava_bucket) return 20000;
            if (var2 == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (var2 == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(par0ItemStack);
        }
    }
    
    public static boolean func_52005_b(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }
    
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }
    
    public void openChest() {}

    public void closeChest() {}

    public int[] getSizeInventorySide(int side)
    {
        return size;
    }

	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}

	public int[] getAccessibleSlotsFromSide(int var1) {
		return var1 == 0 ? field_102011_e : (var1 == 1 ? field_102010_d : field_102009_f);
	}

	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return this.isItemValidForSlot(i, itemstack);
	}

	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return j != 0 || i != 1 || itemstack.getItem() == Items.bucket;
	}

	@Override
	public String getInventoryName()
	{
		return this.hasCustomInventoryName() ? this.customName : ContainerNames.DEMONITE_FURNACE_UNLOCALIZED;
	}

	@Override
	public boolean hasCustomInventoryName() 
	{
		return this.customName != null && this.customName.length() > 0;
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}
}

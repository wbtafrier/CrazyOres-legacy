package crazyores_core.common.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores_core.client.gui.SlotDemoniteFurnace;

public class ContainerDemoniteFurnace extends Container
{
	private TileEntityDemoniteFurnace furnace;
	private int lastCookTime;
	private int lastBurnTime;
	private int lastItemBurnTime;

	public static final int INPUT_1 = 0, INPUT_2 = 1, FUEL = 2, OUTPUT = 3;

	public ContainerDemoniteFurnace(InventoryPlayer inventoryPlayer, TileEntityDemoniteFurnace par2TileEntityFurnace)
	{
		this.furnace = par2TileEntityFurnace;
		// CUSTOM SLOTS
		this.addSlotToContainer(new Slot(par2TileEntityFurnace, INPUT_1, 56, 17));
		this.addSlotToContainer(new Slot(par2TileEntityFurnace, INPUT_2, 33, 17));
		this.addSlotToContainer(new Slot(par2TileEntityFurnace, FUEL, 45, 53));
		this.addSlotToContainer(new SlotDemoniteFurnace(inventoryPlayer.player, par2TileEntityFurnace, OUTPUT, 116, 35));
		int i;

		// PLAYER'S INVENTORY (3*9 = 27 slots added here with index starting at OUTPUT+1 and ending at OUTPUT+27)
		for (i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		// ACTION BAR (9 more slots added here, index starts at OUTPUT+27+1 and ends at OUTPUT+27+1+9)
		for (i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting par1ICrafting)
	{
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, INPUT_1, this.furnace.demonitefurnaceCookTime);
		par1ICrafting.sendProgressBarUpdate(this, INPUT_2, this.furnace.demonitefurnaceCookTime);
		par1ICrafting.sendProgressBarUpdate(this, FUEL, this.furnace.demonitefurnaceBurnTime);
		par1ICrafting.sendProgressBarUpdate(this, OUTPUT, this.furnace.currentItemBurnTime);
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i)
		{
			ICrafting icrafting = (ICrafting)this.crafters.get(i);

			if (this.lastCookTime != this.furnace.demonitefurnaceCookTime)
			{
				icrafting.sendProgressBarUpdate(this, INPUT_1, this.furnace.demonitefurnaceCookTime);
			}

			if (this.lastCookTime != this.furnace.demonitefurnaceCookTime)
			{
				icrafting.sendProgressBarUpdate(this, INPUT_2, this.furnace.demonitefurnaceCookTime);
			}

			if (this.lastBurnTime != this.furnace.demonitefurnaceBurnTime)
			{
				icrafting.sendProgressBarUpdate(this, FUEL, this.furnace.demonitefurnaceBurnTime);
			}

			if (this.lastItemBurnTime != this.furnace.currentItemBurnTime)
			{
				icrafting.sendProgressBarUpdate(this, OUTPUT, this.furnace.currentItemBurnTime);
			}
		}

		this.lastCookTime = this.furnace.demonitefurnaceCookTime;
		this.lastBurnTime = this.furnace.demonitefurnaceBurnTime;
		this.lastItemBurnTime = this.furnace.currentItemBurnTime;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2)
	{
		if (par1 == INPUT_1)
		{
			this.furnace.demonitefurnaceCookTime = par2;
		}

		if (par1 == INPUT_2)
		{
			this.furnace.demonitefurnaceCookTime = par2;
		}

		if (par1 == FUEL)
		{
			this.furnace.demonitefurnaceBurnTime = par2;
		}

		if (par1 == OUTPUT)
		{
			this.furnace.currentItemBurnTime = par2;
		}
	}

	public boolean canInteractWith(EntityPlayer par1EntityPlayer)
	{
		return this.furnace.isUseableByPlayer(par1EntityPlayer);
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	 */
	 public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	 {
		 ItemStack itemstack = null;
		 Slot slot = (Slot)this.inventorySlots.get(par2);

		 if (slot != null && slot.getHasStack())
		 {
			 ItemStack itemstack1 = slot.getStack();
			 itemstack = itemstack1.copy();

			 // If itemstack is in Output stack
			 if (par2 == OUTPUT)
			 {
				 // try to place in player inventory / action bar; add 36+1 because mergeItemStack uses < index,
				 // so the last slot in the inventory won't get checked if you don't add 1
				 if (!this.mergeItemStack(itemstack1, OUTPUT + 1, OUTPUT + 36 + 1, true))
				 {
					 return null;
				 }

				 slot.onSlotChange(itemstack1, itemstack);
			 }
			 // itemstack is in player inventory, try to place in appropriate furnace slot
			 else if (par2 != FUEL && par2 != INPUT_1 && par2 != INPUT_2)
			 {
				 // if it can be smelted, place in the input slots
				 if (DemoniteFurnaceRecipes.smelting().getSmeltingResult(itemstack1, itemstack1) != null)
				 {
					 // try to place in either Input slot; add 1 to final input slot because mergeItemStack uses < index
					 if (!this.mergeItemStack(itemstack1, INPUT_1, INPUT_2 + 1, false))
					 {
						 return null;
					 }
				 }
				 // if it's an energy source, place in Fuel slot
				 else if (TileEntityDemoniteFurnace.isItemFuel(itemstack1))
				 {
					 if (!this.mergeItemStack(itemstack1, FUEL, FUEL + 1, false))
					 {
						 return null;
					 }
				 }
				 // item in player's inventory, but not in action bar
				 else if (par2 >= OUTPUT+1 && par2 < OUTPUT+28)
				 {
					 // place in action bar
					 if (!this.mergeItemStack(itemstack1, OUTPUT+28, OUTPUT+37, false))
					 {
						 return null;
					 }
				 }
				 // item in action bar - place in player inventory
				 else if (par2 >= OUTPUT+28 && par2 < OUTPUT+37 && !this.mergeItemStack(itemstack1, OUTPUT+1, OUTPUT+28, false))
				 {
					 return null;
				 }
			 }
			 // In one of the infuser slots; try to place in player inventory / action bar
			 else if (!this.mergeItemStack(itemstack1, OUTPUT+1, OUTPUT+37, false))
			 {
				 return null;
			 }

			 if (itemstack1.stackSize == 0)
			 {
				 slot.putStack((ItemStack)null);
			 }
			 else
			 {
				 slot.onSlotChanged();
			 }

			 if (itemstack1.stackSize == itemstack.stackSize)
			 {
				 return null;
			 }

			 slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
		 }
		 return itemstack;
	 }
}
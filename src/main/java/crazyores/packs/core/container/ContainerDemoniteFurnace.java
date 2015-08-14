package crazyores.packs.core.container;

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
import crazyores.packs.core.entity.tileentity.TileEntityDemoniteFurnace;
import crazyores.packs.core.recipe.DemoniteFurnaceRecipes;

public class ContainerDemoniteFurnace extends Container {

	private TileEntityDemoniteFurnace tileFurnace;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;
    private int lastOverHeat;
    private int lastTimeAlive;
    private int lastHeatUpAmount;
    
    private final int INPUT_1 = 0, INPUT_2 = 1, FUEL = 2, OUTPUT = 3;

    public ContainerDemoniteFurnace(InventoryPlayer inventory, TileEntityDemoniteFurnace furnace) {
        this.tileFurnace = furnace;
        this.addSlotToContainer(new Slot(furnace, INPUT_1, 33, 17));
        this.addSlotToContainer(new Slot(furnace, INPUT_2, 56, 17));
        this.addSlotToContainer(new Slot(furnace, FUEL, 45, 53));
        this.addSlotToContainer(new SlotDemoniteFurnace(inventory.player, furnace, OUTPUT, 116, 35));
        int i;

        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        
        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting crafting) {
        super.addCraftingToCrafters(crafting);
        crafting.sendProgressBarUpdate(this, 0, this.tileFurnace.furnaceCookTime);
        crafting.sendProgressBarUpdate(this, 1, this.tileFurnace.furnaceBurnTime);
        crafting.sendProgressBarUpdate(this, 2, this.tileFurnace.currentItemBurnTime);
//        crafting.sendProgressBarUpdate(this, 3, this.tileFurnace.overHeat);
//        crafting.sendProgressBarUpdate(this, 4, this.tileFurnace.timeAlive);
//        crafting.sendProgressBarUpdate(this, 5, this.tileFurnace.heatUpAmount);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastCookTime != this.tileFurnace.furnaceCookTime) {
                icrafting.sendProgressBarUpdate(this, 0, this.tileFurnace.furnaceCookTime);
            }

            if (this.lastBurnTime != this.tileFurnace.furnaceBurnTime) {
                icrafting.sendProgressBarUpdate(this, 1, this.tileFurnace.furnaceBurnTime);
            }

            if (this.lastItemBurnTime != this.tileFurnace.currentItemBurnTime) {
                icrafting.sendProgressBarUpdate(this, 2, this.tileFurnace.currentItemBurnTime);
            }
            
//            if (this.lastOverHeat != this.tileFurnace.overHeat) {
//                icrafting.sendProgressBarUpdate(this, 3, this.tileFurnace.overHeat);
//            }
//            
//            if (this.lastTimeAlive != this.tileFurnace.timeAlive) {
//                icrafting.sendProgressBarUpdate(this, 4, this.tileFurnace.timeAlive);
//            }
//            
//            if (this.lastHeatUpAmount != this.tileFurnace.heatUpAmount) {
//                icrafting.sendProgressBarUpdate(this, 5, this.tileFurnace.heatUpAmount);
//            }
        }

        this.lastCookTime = this.tileFurnace.furnaceCookTime;
        this.lastBurnTime = this.tileFurnace.furnaceBurnTime;
        this.lastItemBurnTime = this.tileFurnace.currentItemBurnTime;
//        this.lastOverHeat = this.tileFurnace.overHeat;
//        this.lastTimeAlive = this.tileFurnace.timeAlive;
//        this.lastHeatUpAmount = this.tileFurnace.heatUpAmount;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int p_75137_1_, int p_75137_2_) {
        if (p_75137_1_ == 0) {
            this.tileFurnace.furnaceCookTime = p_75137_2_;
        }

        if (p_75137_1_ == 1) {
            this.tileFurnace.furnaceBurnTime = p_75137_2_;
        }

        if (p_75137_1_ == 2) {
            this.tileFurnace.currentItemBurnTime = p_75137_2_;
        }
        
//        if (p_75137_1_ == 3) {
//            this.tileFurnace.overHeat = p_75137_2_;
//        }
//        
//        if (p_75137_1_ == 4) {
//            this.tileFurnace.timeAlive = p_75137_2_;
//        }
//        
//        if (p_75137_1_ == 5) {
//            this.tileFurnace.heatUpAmount = p_75137_2_;
//        }
    }

    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return this.tileFurnace.isUseableByPlayer(p_75145_1_);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotIndex);
        
        System.out.println(slotIndex);
        
        if (slot != null && slot.getHasStack()) {
            ItemStack stackFromSlot = slot.getStack();
            itemstack = stackFromSlot.copy();

            if (slotIndex == OUTPUT) {
                if (!this.mergeItemStack(stackFromSlot, OUTPUT + 1, 40, true)) {
                    return null;
                }
                slot.onSlotChange(stackFromSlot, itemstack);
            }
            else if (slotIndex != INPUT_1 && slotIndex != INPUT_2 && slotIndex != FUEL) {
            	
                if (DemoniteFurnaceRecipes.instance().canBeSmelted(stackFromSlot)) {
                	
                    if (!this.mergeItemStack(stackFromSlot, INPUT_1, FUEL, false)) {
                        return null;
                    }
                }
                else if (TileEntityDemoniteFurnace.isItemFuel(stackFromSlot)) {
                    if (!this.mergeItemStack(stackFromSlot, FUEL, OUTPUT, false)) {
                        return null;
                    }
                }
                else if (slotIndex >= OUTPUT && slotIndex < 30) {
                    if (!this.mergeItemStack(stackFromSlot, 30, 39, false)) {
                        return null;
                    }
                }
                else if (slotIndex >= 30 && slotIndex < 39 && !this.mergeItemStack(stackFromSlot, OUTPUT + 1, 30, false)) {
                	return null;
                }
            }
            else if (!this.mergeItemStack(stackFromSlot, OUTPUT + 1, 39, false)) {
            	return null;
            }

            if (stackFromSlot.stackSize == 0) {
                slot.putStack((ItemStack)null);
            }
            else {
                slot.onSlotChanged();
            }

            if (stackFromSlot.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, stackFromSlot);
        }

        return itemstack;
    }
}

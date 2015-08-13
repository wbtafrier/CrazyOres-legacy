package crazyores.packs.core.container;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import crazyores.packs.core.recipe.DemoniteFurnaceRecipes;

public class SlotDemoniteFurnace extends Slot {

	private EntityPlayer thePlayer;
    private int field_75228_b;

    public SlotDemoniteFurnace(EntityPlayer player, IInventory inventory, int index, int xPos, int yPos) {
        super(inventory, index, xPos, yPos);
        this.thePlayer = player;
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    public boolean isItemValid(ItemStack stack) {
        return false;
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int amount) {
        if (this.getHasStack()) {
            this.field_75228_b += Math.min(amount, this.getStack().stackSize);
        }

        return super.decrStackSize(amount);
    }

    public void onPickupFromSlot(EntityPlayer player, ItemStack stack) {
        this.onCrafting(stack);
        super.onPickupFromSlot(player, stack);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
     * internal count then calls onCrafting(item).
     */
    protected void onCrafting(ItemStack p_75210_1_, int p_75210_2_) {
        this.field_75228_b += p_75210_2_;
        this.onCrafting(p_75210_1_);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
     */
    protected void onCrafting(ItemStack stack) {
        stack.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.field_75228_b);

        if (!this.thePlayer.worldObj.isRemote) {
            int i = this.field_75228_b;
            float f = DemoniteFurnaceRecipes.instance().getExperience(stack);
            int j;

            if (f == 0.0F) {
                i = 0;
            }
            else if (f < 1.0F) {
                j = MathHelper.floor_float((float)i * f);

                if (j < MathHelper.ceiling_float_int((float)i * f) && (float)Math.random() < (float)i * f - (float)j) {
                    ++j;
                }

                i = j;
            }

            while (i > 0) {
                j = EntityXPOrb.getXPSplit(i);
                i -= j;
                this.thePlayer.worldObj.spawnEntityInWorld(new EntityXPOrb(this.thePlayer.worldObj, this.thePlayer.posX, this.thePlayer.posY + 0.5D, this.thePlayer.posZ + 0.5D, j));
            }
        }

        this.field_75228_b = 0;

        FMLCommonHandler.instance().firePlayerSmeltedEvent(thePlayer, stack);

        if (stack.getItem() == Items.iron_ingot) {
            this.thePlayer.addStat(AchievementList.acquireIron, 1);
        }

        if (stack.getItem() == Items.cooked_fished) {
            this.thePlayer.addStat(AchievementList.cookFish, 1);
        }
    }
}

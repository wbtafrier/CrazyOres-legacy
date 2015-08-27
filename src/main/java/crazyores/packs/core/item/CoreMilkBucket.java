package crazyores.packs.core.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import crazyores.packs.core.tabs.CoreTabList;

public class CoreMilkBucket extends CoreItem {

	protected CoreMilkBucket(String unlocalizedName) {
		super(unlocalizedName);
		this.setMaxStackSize(1);
		this.setCreativeTab(CoreTabList.coreFoodTab);
	}

	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode)
        {
            --itemStack.stackSize;
        }

        if (!world.isRemote)
        {
            player.curePotionEffects(itemStack);
        }

        return itemStack.stackSize <= 0 ? new ItemStack(CoreItems.copperBucketEmpty) : itemStack;
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack itemStack) {
        return 32;
    }
	
	@Override
	public EnumAction getItemUseAction(ItemStack itemStack) {
        return EnumAction.drink;
    }

	@Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        return itemStack;
    }
}

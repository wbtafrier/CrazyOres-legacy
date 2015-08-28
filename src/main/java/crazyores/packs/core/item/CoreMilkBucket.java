package crazyores.packs.core.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import crazyores.manager.pack.COPackManager;
import crazyores.packs.core.tabs.CoreTabList;

public class CoreMilkBucket extends ItemBucketMilk {

	private String itemUnlocalizedName;
	
	protected CoreMilkBucket(String unlocalizedName) {
		this.setCreativeTab(CoreTabList.coreFoodTab);
		itemUnlocalizedName = unlocalizedName;
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
        	player.curePotionEffects(new ItemStack(Items.milk_bucket));
        }
        return super.onEaten(stack, world, player);
    }
	
	@Override
	public String getUnlocalizedName() {
		return itemUnlocalizedName;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
        return itemUnlocalizedName;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(String.format("%s%s%s", COPackManager.corePack.getPackID(), ":", this.getUnlocalizedName()));
    }
}

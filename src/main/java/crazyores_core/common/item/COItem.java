package crazyores_core.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores_core.common.tab.COTabList;
import crazyores_core.util.TextureManager;

/**
 * COItem is the big daddy for most of the Items in the Core.
 * @author ISQUISHALL and Andy608
 *
 */
public class COItem extends Item {

	/**
	 * This instance of COItem takes no arguments, but sets the CreativeTabs to COTabList.CO_MATERIALS by default.
	 */
	public COItem() {
		this(COTabList.CO_MATERIALS);
	}
	
	/**
	 * This instance of COItem requires one argument, setting the appropriate tab for the COItem.
	 * @param tab The CreativeTabs that this Item will be added to.
	 */
	public COItem(CreativeTabs tab) {
		super();
		this.setCreativeTab(tab);
	}
	
//THIS WILL BE CHANGED I WANT TO COME UP WITH NEW UNIQUE THINGS BEFORE IMPLEMENTING ALL OF THE OLD SPECIAL ABILITIES. ~Andrew
//	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase entityliving1)
//	{
//		if (this == ItemList.invisium_rod || this == ItemList.invisium_ingot
//			|| this == ItemList.invisium_arrow)
//		{
//			entityliving.addPotionEffect(new PotionEffect(Potion.invisibility.id, 1000, 1));
//			return true;
//		}
//		return false;
//	}
	
	@Override
	public String getUnlocalizedName() {
		return String.format("item.%s%s", TextureManager.RESOURCE_PREFIX, this.stripName(super.getUnlocalizedName()));
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return this.getUnlocalizedName();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		this.itemIcon = register.registerIcon(this.stripName(this.getUnlocalizedName()));
	}

	/**
	 * Removes the prefix of the default unlocalized name of a COItem leaving only its name.
	 * @param unlocalizedName The default unlocalized name of this Item
	 * @return a substring of the default unlocalized name
	 */
	public String stripName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
}

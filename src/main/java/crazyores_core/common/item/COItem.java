package crazyores_core.common.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import crazyores_core.common.core.ICOName;
import crazyores_core.common.tab.COTabList;
import crazyores_core.util.TextureManager;

/**
 * COItem is the big daddy for most of the Items in the Core.
 * @author ISQUISHALL and Andy608
 */
public class COItem extends Item implements ICOName {

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
	
	@Override
	public String getUnlocalizedName() {
		return String.format("item.%s%s", TextureManager.RESOURCE_PREFIX, this.parsePrefix(super.getUnlocalizedName(), '.'));
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return this.getUnlocalizedName();
	}

	@Override
	public String parsePrefix(String unlocalizedName, char lastPrefixChar) {
		return unlocalizedName.substring(unlocalizedName.indexOf(lastPrefixChar) + 1);
	}
	
	@Override
	public String getReadableName() {
		return this.parsePrefix(this.getUnlocalizedName(), ':');
	}
}

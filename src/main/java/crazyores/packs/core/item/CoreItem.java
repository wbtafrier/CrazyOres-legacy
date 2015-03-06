package crazyores.packs.core.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import crazyores.manager.support.IName;

public class CoreItem extends Item implements IName {

	public final String itemName;
	
	public CoreItem(String readableName, String unlocalizedName) {
		this.itemName = readableName;
		super.setUnlocalizedName(unlocalizedName);
		super.setTextureName(unlocalizedName);
	}
	
	public CoreItem(String readableName, String unlocalizedName, CreativeTabs tab) {
		this(readableName, unlocalizedName);
		super.setCreativeTab(tab);
	}
	
	public CoreItem(String readableName, String unlocalizedName, CreativeTabs tab, int maxStackSize) {
		this(readableName, unlocalizedName, tab);
		super.maxStackSize = maxStackSize;
	}

	@Override
	public String getReadableName() {
		return this.itemName;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item) {
		return super.getUnlocalizedName();
	}
}

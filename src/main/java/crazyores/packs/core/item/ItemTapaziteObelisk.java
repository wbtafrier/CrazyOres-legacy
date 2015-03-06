package crazyores.packs.core.item;

import net.minecraft.creativetab.CreativeTabs;

public class ItemTapaziteObelisk extends CoreItem {

	/**
	 * Constructor for the CoreItem class.
	 * @param itemReadableName
	 * @param unlocalizedName
	 */
	protected ItemTapaziteObelisk(String itemReadableName, String unlocalizedName) {
		super(itemReadableName, unlocalizedName);
	}
	
	/**
	 * Constructor for the CoreItem class.
	 * @param itemReadableName
	 * @param unlocalizedName
	 * @param tab
	 */
	protected ItemTapaziteObelisk(String itemReadableName, String unlocalizedName, CreativeTabs tab) {
		super(itemReadableName, unlocalizedName, tab);
	}
	
	/**
	 * Constructor for the CoreItem class.
	 * @param itemReadableName
	 * @param unlocalizedName
	 * @param tab
	 * @param maxStackSize
	 */
	protected ItemTapaziteObelisk(String itemReadableName, String unlocalizedName, CreativeTabs tab, int maxStackSize) {
		super(itemReadableName, unlocalizedName, tab, maxStackSize);
	}
}

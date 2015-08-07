package crazyores.packs.core.item;

import crazyores.manager.tabs.COTabList;
import net.minecraft.creativetab.CreativeTabs;

public class CoreOre extends CoreItem {

	private String oreDictionaryName;
	
	protected CoreOre(String unlocalizedName, String oreDictName) {
		super(unlocalizedName, COTabList.crazyOresItemsTab);
		oreDictionaryName = oreDictName;
	}
	
	public String getOreDictionaryName() {
		return oreDictionaryName;
	}
}

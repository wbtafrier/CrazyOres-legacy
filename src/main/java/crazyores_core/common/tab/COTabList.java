package crazyores_core.common.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import crazyores_core.common.item.ItemList;

/**
 * COTabList has a list of all the tabs created in the CO Core.
 * @author Andy608 and ISQUISHALL
 */
public class COTabList {
	
	/**
	 * CrazyOres Core Blocks tab.
	 */
	public static final CreativeTabs CO_BLOCKS = new CreativeTabs(TabNames.CO_BLOCKS) {
		@Override
		public Item getTabIconItem() {
			//TODO: Replace with Ender Block
			return Item.getItemFromBlock(Blocks.bedrock);
		}
	};
	
	/**
	 * CrazyOres Core Materials tab. Stores all ore drops, and other raw materials.
	 */
	public static final CreativeTabs CO_MATERIALS = new CreativeTabs(TabNames.CO_MATERIALS) {
		@Override
		public Item getTabIconItem() {
			return ItemList.invisium_ingot;
		}
	};
}
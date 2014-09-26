package crazyores_core.common.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import crazyores_core.common.block.BlockList;
import crazyores_core.common.block.BlockNames;

/**
 * COTabList has a list of all the tabs created in the CO Core.
 * @author Andy608 and ISQUISHALL
 */
public class COTabList {
	/**
	 * Creates the Blocks Tab
	 */
	public static final CreativeTabs CO_BLOCKS = new CreativeTabs(TabNames.CO_BLOCKS) {
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.bedrock);
		}
	};
}

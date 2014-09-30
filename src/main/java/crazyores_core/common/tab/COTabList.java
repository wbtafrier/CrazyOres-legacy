package crazyores_core.common.tab;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import crazyores_core.common.block.BlockList;
import crazyores_core.common.block.BlockNames;
import crazyores_core.util.TextureManager;

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
			return Item.getItemFromBlock(Blocks.bedrock);
		}
	};
	
	/**
	 * CrazyOres Core Materials tab. Stores all ore drops, and other raw materials.
	 */
	public static final CreativeTabs CO_MATERIALS = new CreativeTabs(TabNames.CO_MATERIALS) {
		@Override
		public Item getTabIconItem() {
			return Items.iron_ingot;
		}
	};
}
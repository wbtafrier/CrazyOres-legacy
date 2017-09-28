package crazyores.manager.tabs;

import crazyores.packs.core.block.CoreBlocks;
import crazyores.packs.core.item.CoreItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class CrazyOresTabs {
	
	//Generic Tab Names
	public static final String crazyOresBlocks = "crazyOresBlocks";
	public static final String crazyOresItems = "crazyOresItems";
	
	public static void initTabs() {
		createCrazyOresBlocksTab();
		createCrazyOresItemsTab();
	}
	
	public static void createCrazyOresBlocksTab() {
		COTabList.crazyOresBlocksTab = new CreativeTabs(crazyOresBlocks) {
			
			@Override
			public ItemStack getTabIconItem() {
				
				//TODO: Replace with a cool block from the core pack
				return new ItemStack(Item.getItemFromBlock(CoreBlocks.luminiteDiscoBlock));
			}
		};
	}
	
	public static void createCrazyOresItemsTab() {
		COTabList.crazyOresItemsTab = new CreativeTabs(crazyOresItems) {
			
			@Override
			public ItemStack getTabIconItem() {
				
				//TODO: Replace with a cool block from the core pack
				return new ItemStack(CoreItems.starconiumShard);
			}
		};
	}
}

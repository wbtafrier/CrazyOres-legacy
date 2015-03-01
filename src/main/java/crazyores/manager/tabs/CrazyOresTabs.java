package crazyores.manager.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public abstract class CrazyOresTabs {
	
	//Generic Tab Names
	public static final String defaultBlocks = "overworldBlocks";
	public static final String defaultItems = "overworldItems";
	
	public static void initTabs() {
		
		createDefaultBlocksTab();
		createDefaultItemsTab();
	}
	
	public static void createDefaultBlocksTab() {
		COTabList.defaultBlocksTab = new CreativeTabs(defaultBlocks) {
			
			@Override
			public Item getTabIconItem() {
				
				//TODO: Replace with a cool block from the core pack
				return Item.getItemFromBlock(Blocks.cobblestone);
			}
		};
	}
	
	public static void createDefaultItemsTab() {
		COTabList.defaultItemsTab = new CreativeTabs(defaultItems) {
			
			@Override
			public Item getTabIconItem() {
				
				//TODO: Replace with a cool block from the core pack
				return Item.getItemFromBlock(Blocks.cactus);
			}
		};
	}
}

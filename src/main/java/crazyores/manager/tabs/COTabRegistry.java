package crazyores.manager.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import crazyores.manager.config.COConfigSettings;
import crazyores.packs.core.tabs.CoreTabs;

public abstract class COTabRegistry {
	
	private static CreativeTabs defaultBlocksTab;
	private static CreativeTabs defaultItemsTab;
	
	public static void initTabs() {
		
		createDefaultBlocksTab();
		createDefaultItemsTab();
		
		if (COConfigSettings.isCoreActivated()) {
			CoreTabs.initCoreTabs();
		}
		
		if (COConfigSettings.isFoodsActivated()) {
		}
	}
	
	public static void createDefaultBlocksTab() {
		defaultBlocksTab = new CreativeTabs(COTabNames.defaultBlocks) {
			
			@Override
			public Item getTabIconItem() {
				
				//TODO: Replace with a cool block from the core pack
				return Item.getItemFromBlock(Blocks.cobblestone);
			}
		};
	}
	
	public static void createDefaultItemsTab() {
		defaultItemsTab = new CreativeTabs(COTabNames.defaultItems) {
			
			@Override
			public Item getTabIconItem() {
				
				//TODO: Replace with a cool block from the core pack
				return Item.getItemFromBlock(Blocks.cactus);
			}
		};
	}
}

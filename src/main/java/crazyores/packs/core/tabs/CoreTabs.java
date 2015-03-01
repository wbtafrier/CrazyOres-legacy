package crazyores.packs.core.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import crazyores.manager.tabs.COTabList;

public class CoreTabs {

	
	//Core Tab Names
	public static final String dreamStateTerrain = "dreamstateTerrain";
	public static final String dreamStateItems = "dreamstateItems";
	
	public static void initCoreTabs() {
		createDreamStateTerrainTab();
		createDreamStateItemsTab();
	}
	
	public static void createDreamStateTerrainTab() {
		COTabList.dreamStateTerrainTab = new CreativeTabs(dreamStateTerrain) {
			
			@Override
			public Item getTabIconItem() {
				
				//TODO: Replace with a cool block from the core pack
				return Item.getItemFromBlock(Blocks.grass);
			}
		};
	}
	
	public static void createDreamStateItemsTab() {
		COTabList.dreamStateItemsTab = new CreativeTabs(dreamStateItems) {
			
			@Override
			public Item getTabIconItem() {
				
				//TODO: Replace with a cool item from the core pack
				return Item.getItemFromBlock(Blocks.brick_block);
			}
		};
	}
}

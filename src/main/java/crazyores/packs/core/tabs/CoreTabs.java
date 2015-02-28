package crazyores.packs.core.tabs;

import crazyores.manager.config.COConfigSettings;
import crazyores.manager.tabs.COTabNames;
import crazyores.manager.tabs.COTabRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CoreTabs extends COTabRegistry {

	private static CreativeTabs dreamStateTerrainTab;
	private static CreativeTabs dreamStateItemsTab;
	
	public static void initCoreTabs() {
		createDreamStateTerrainTab();
		createDreamStateItemsTab();
	}
	
	public static void createDreamStateTerrainTab() {
		dreamStateTerrainTab = new CreativeTabs(COTabNames.dreamStateTerrain) {
			
			@Override
			public Item getTabIconItem() {
				
				//TODO: Replace with a cool block from the core pack
				return Item.getItemFromBlock(Blocks.grass);
			}
		};
	}
	
	public static void createDreamStateItemsTab() {
		dreamStateItemsTab = new CreativeTabs(COTabNames.dreamStateItems) {
			
			@Override
			public Item getTabIconItem() {
				
				//TODO: Replace with a cool item from the core pack
				return Item.getItemFromBlock(Blocks.brick_block);
			}
		};
	}
}

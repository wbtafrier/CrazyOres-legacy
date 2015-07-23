package crazyores.packs.core.tabs;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import crazyores.manager.tabs.COTabList;

public class CoreTabs {

	//Core Tab Names
	public static final String crazyOresTools = "crazyOresTools";
	
	public static void initCoreTabs() {
		createCrazyOresToolsTab();
	}
	
	public static void createCrazyOresToolsTab() {
		CoreTabList.crazyOresArmorTab = new CreativeTabs(crazyOresTools) {
			
			@Override
			public Item getTabIconItem() {
				
				//TODO: Replace with a cool block from the core pack
				return Items.diamond_axe;
			}
		};
	}
}

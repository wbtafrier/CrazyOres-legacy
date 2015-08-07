package crazyores.packs.core.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import crazyores.packs.core.item.CoreItems;

public class CoreTabs {

	//Core Tab Names
	public static final String coreToolsTab = "crazyOresTools";
	public static final String coreArmorTab = "crazyOresArmor";
	
	public static void initCoreTabs() {
		createCoreToolsTab();
		createCoreArmorTab();
	}
	
	public static void createCoreToolsTab() {
		CoreTabList.coreToolsTab = new CreativeTabs(coreToolsTab) {
			
			@Override
			public Item getTabIconItem() {
				
				//TODO: Replace with a cool block from the core pack
				return CoreItems.starconiumPickaxe;
			}
		};
	}
	
	public static void createCoreArmorTab() {
		CoreTabList.coreArmorTab = new CreativeTabs(coreArmorTab) {
			
			@Override
			public Item getTabIconItem() {
				
				//TODO: Replace with a cool block from the core pack
				return CoreItems.enderChestplate;
			}
		};
	}
}

package crazyores.packs.core.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import crazyores.packs.core.item.CoreItems;

public class CoreTabs {

	//Core Tab Names
	public static final String coreToolsTab = "crazyOresTools";
	public static final String coreArmorTab = "crazyOresArmor";
	public static final String coreWeaponsTab = "crazyOresWeapons";
	public static final String coreFoodTab = "crazyOresFood";
	
	public static void initCoreTabs() {
		createCoreToolsTab();
		createCoreArmorTab();
		createCoreWeaponsTab();
		createCoreFoodTab();
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
	
	public static void createCoreWeaponsTab() {
		CoreTabList.coreWeaponsTab = new CreativeTabs(coreWeaponsTab) {
			
			@Override
			public Item getTabIconItem() {
				
				//TODO: Replace with a cool block from the core pack
				return CoreItems.swiftBow;
			}
		};
	}
	
	public static void createCoreFoodTab() {
		CoreTabList.coreFoodTab = new CreativeTabs(coreFoodTab) {
			
			@Override
			public Item getTabIconItem() {
				
				//TODO: Replace with a cool block from the core pack
				return CoreItems.birthdayCake;
			}
		};
	}
}

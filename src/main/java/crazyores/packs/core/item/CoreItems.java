package crazyores.packs.core.item;

import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.manager.tabs.COTabList;
import net.minecraft.item.Item;

public class CoreItems {

	public static Item tapaziteObelisk;
	
	public static void initItems() {
		initOverworldItems();
	}
	
	private static void initOverworldItems() {
		tapaziteObelisk = new CoreItem("Tapazite Obelisk", "tapazite_obelisk", COTabList.defaultItemsTab); registerItem(tapaziteObelisk);
	}
	
	public static void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
	
}

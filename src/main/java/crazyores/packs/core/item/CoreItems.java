package crazyores.packs.core.item;

import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.manager.tabs.COTabList;
import net.minecraft.item.Item;

public class CoreItems {

	public static Item tapaziteObelisk;
	
	public static void initItems() {
		initOverworldItems();
	}
	
	public static void initOverworldItems() {
		tapaziteObelisk = new ItemTapaziteObelisk("Tapazite Obelisk", "tapazite_obelisk", COTabList.defaultItemsTab); registerItem(tapaziteObelisk);
	}
	
	private static void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
}

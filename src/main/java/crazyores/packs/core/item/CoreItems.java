package crazyores.packs.core.item;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.manager.tabs.COTabList;

public class CoreItems {

	public static Item tapaziteObelisk;
	public static Item tapaziteDust;
	
	public static void initItems() {
		initOverworldItems();
	}
	
	public static void initOverworldItems() {
		tapaziteObelisk = new ItemTapaziteObelisk("tapazite_obelisk", COTabList.crazyOresItemsTab); registerItem(tapaziteObelisk);
		tapaziteDust = new CoreItem("tapazite_dust", COTabList.crazyOresItemsTab); registerItem(tapaziteDust);
	}
	
	private static void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
}

package crazyores.packs.core.recipe;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.packs.core.item.CoreItems;

public class CoreFuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		
		if (fuel.getItem() != null) {
			if (fuel.getItem().equals(CoreItems.meteoriteCoal)) return 3200;
			else if (fuel.getItem().equals(CoreItems.meteoriteGem)) return 6400;
		}
		return 0;
	}
	
	public static void initFuels() {
		GameRegistry.registerFuelHandler(new CoreFuelHandler());
	}
}

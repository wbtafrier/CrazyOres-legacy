package crazyores_core.common.core;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;
import crazyores_core.common.items.ItemList;

public class FurnaceFuel implements IFuelHandler
{
	ItemList il;
	public int getBurnTime(ItemStack fuel)
	{
		if (fuel.getItem() == il.experium_orb)
			return 1000;
		if (fuel.getItem() == il.meteorite_coal)
			return 3200;
		if (fuel.getItem() == il.meteorite_gem)
			return 6400;
		if (fuel.getItem() == il.copper_bucket_lava)
			return 20000;
		if (fuel.getItem() == il.starconium_shard)
			return 12800;
		else
			return 0;
	}
}

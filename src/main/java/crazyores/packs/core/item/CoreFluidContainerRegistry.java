package crazyores.packs.core.item;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class CoreFluidContainerRegistry {
	
	public static final ItemStack EMPTY_COPPER_BUCKET = new ItemStack(CoreItems.copperBucketEmpty);
	
	public static void registerFluidContainers() {
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.WATER, new ItemStack(CoreItems.copperBucketWater), EMPTY_COPPER_BUCKET);
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.LAVA, new ItemStack(CoreItems.copperBucketLava), EMPTY_COPPER_BUCKET);
	}
}

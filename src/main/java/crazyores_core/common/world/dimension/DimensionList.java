package crazyores_core.common.world.dimension;

import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;

public class DimensionList {
	
	public static final int dreamStateDimID = DimensionManager.getNextFreeDimId();
	
	public static void initDimension() {
		registerDimension(dreamStateDimID, DreamStateWorldProvider.class, true);
	}
	
	public static void registerDimension(int dimensionID, Class<? extends WorldProvider> dimensionClass, boolean keepLoaded) {
		DimensionManager.registerProviderType(dimensionID, dimensionClass, keepLoaded);
		DimensionManager.registerDimension(dimensionID, dimensionID);
	}
}

package crazyores.packs.core.util;

import java.io.File;

import net.minecraft.util.ResourceLocation;
import crazyores.manager.pack.COPackManager;

public class CoreResourceLoader {
	
	private static String s = File.separator;
	
	public static final ResourceLocation tapaziteCrystalImage = 
		(new ResourceLocation(COPackManager.corePack.getPackID() + ":textures" + s + "models" + s + "tapazite_crystal_model.png"));
}

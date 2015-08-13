package crazyores.packs.core.util;

import java.io.File;

import net.minecraft.util.ResourceLocation;
import crazyores.manager.pack.COPackManager;

public class CoreResourceLoader {
	
	private static String sep = File.separator;
	
	public static final ResourceLocation TAPAZITE_CRYSTAL_IMAGE = new ResourceLocation(COPackManager.corePack.getPackID() + ":textures" + sep + "models" + sep + "tapazite_crystal_model.png");
	public static final ResourceLocation DEMONITE_FURNACE_GUI_IMAGE = new ResourceLocation(COPackManager.corePack.getPackID() + ":textures" + sep + "gui" + sep + "demonite_furnace_gui.png");
}

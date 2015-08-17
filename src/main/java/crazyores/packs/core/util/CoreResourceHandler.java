package crazyores.packs.core.util;

import java.io.File;

import net.minecraft.util.ResourceLocation;
import crazyores.manager.pack.COPackManager;

public class CoreResourceHandler {
	
	private static String sep = File.separator;
	
	public static final ResourceLocation UNKNOWN_IMAGE = new ResourceLocation(COPackManager.corePack.getPackID() + ":textures" + sep + "models" + sep + "unknown_image.png");
	public static final ResourceLocation TAPAZITE_CRYSTAL_IMAGE = new ResourceLocation(COPackManager.corePack.getPackID() + ":textures" + sep + "models" + sep + "tapazite_crystal_model.png");
	public static final ResourceLocation DEMONITE_FURNACE_GUI_IMAGE = new ResourceLocation(COPackManager.corePack.getPackID() + ":textures" + sep + "gui" + sep + "demonite_furnace_gui.png");
	
	private static final String golemPath = COPackManager.corePack.getPackID() + ":textures" + sep + "models" + sep + "mobs" + sep + "golems" + sep;
	public static final ResourceLocation COPPER_GOLEM_IMAGE = new ResourceLocation(golemPath + "copper_golem.png");
	public static final ResourceLocation SAPPHIRE_GOLEM_IMAGE = new ResourceLocation(golemPath + "sapphire_golem.png");
	public static final ResourceLocation ADAMITE_GOLEM_IMAGE = new ResourceLocation(golemPath + "adamite_golem.png");
	public static final ResourceLocation RUBY_GOLEM_IMAGE = new ResourceLocation(golemPath + "ruby_golem.png");
	public static final ResourceLocation FOOLS_RUBY_GOLEM_IMAGE = new ResourceLocation(golemPath + "fools_ruby_golem.png");
	public static final ResourceLocation ZECTIUM_GOLEM_IMAGE = new ResourceLocation(golemPath + "zectium_golem.png");
	public static final ResourceLocation TAPAZITE_GOLEM_IMAGE = new ResourceLocation(golemPath + "tapazite_golem.png");
	public static final ResourceLocation OSMONIUM_GOLEM_IMAGE = new ResourceLocation(golemPath + "osmonium_golem.png");
	public static final ResourceLocation STARCONIUM_GOLEM_IMAGE = new ResourceLocation(golemPath + "starconium_golem.png");
	public static final ResourceLocation DEMONITE_GOLEM_IMAGE = new ResourceLocation(golemPath + "demonite_golem.png");
	public static final ResourceLocation ENDER_GOLEM_IMAGE = new ResourceLocation(golemPath + "ender_golem.png");
}

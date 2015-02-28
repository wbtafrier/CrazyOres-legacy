package crazyores.manager.config;

import java.io.File;

import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import crazyores.manager.util.COPackManager;
import crazyores.manager.util.CrazyOresData;
import crazyores.manager.util.CrazyOresLogger;
import crazyores.packs.core.config.COCoreConfigLoader;

public abstract class COConfigManager {

	public static Configuration config;
	public static final String fileLocation = File.separator + "crazyores-config" + File.separator;
	private static final String LOAD_PACK_CATEGORY = StatCollector.translateToLocal("config.category.loadPacks");
	
	public static void init(FMLPreInitializationEvent event) {
		
		config = new Configuration(new File(event.getSuggestedConfigurationFile().getParentFile() + fileLocation + "crazyores_main.cfg"));
		CrazyOresLogger.write(CrazyOresData.COPrefix, Level.INFO, "Loading Main CrazyOres Configuration file.");
		
		try {	
			config.load();
			config.addCustomCategoryComment(LOAD_PACK_CATEGORY, "Will load the pack into your game. | false: Will not load the pack into your game.");
			
			/** Loading packs into the game **/
			if (Loader.isModLoaded(CrazyOresData.foodsPackID)) {
				COConfigSettings.isFoodsInstalled = config.get(LOAD_PACK_CATEGORY, StatCollector.translateToLocal("config.node.installFoodsPack"), true).getBoolean(true);
			}
			
			CrazyOresLogger.write(CrazyOresData.COPrefix, Level.INFO, "CrazyOres Main config file loaded successfully.");
		} 
		catch(Exception e) {
			CrazyOresLogger.write(CrazyOresData.COPrefix, Level.WARN, "Uh oh, something went wrong with the config file. Saving any changes...");
		} 
		finally {
			if (config.hasChanged()) {
				config.save();
			}
		}
		
		if (COConfigSettings.isCoreActivated()) {
			COCoreConfigLoader.initCore(event);
		}
		
		if (COConfigSettings.isFoodsActivated()) {
//			COFoodsConfig.initFoods(event);
		}
	}
}

package crazyores.manager.config;

import java.io.File;

import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;

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
		
		if (COPackManager.isCoreInstalled()) {
			COCoreConfigLoader.initCore(event);
		}
		
		if (COPackManager.isFoodsInstalled()) {
//			COFoodsConfig.initFoods(event);
		}
		
		config = new Configuration(new File(event.getSuggestedConfigurationFile().getParentFile() + fileLocation + "crazyores_main.cfg"));
		CrazyOresLogger.write(CrazyOresData.COPrefix, Level.INFO, "Loading Base CrazyOres Configuration file.");

		
		try {
			config.load();
			
			/** Things related to CrazyOres overall go here. **/
			
			CrazyOresLogger.write(CrazyOresData.COPrefix, Level.INFO, "CrazyOres config file successfully loaded.");
		} 
		catch(Exception e) {
			CrazyOresLogger.write(CrazyOresData.COPrefix, Level.WARN, "Uh oh, something went wrong with the config file. Saving any changes...");
		} 
		finally {
			if (config.hasChanged()) {
				config.save();
			}
		}
	}
	
}

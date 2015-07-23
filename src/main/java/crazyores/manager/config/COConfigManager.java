package crazyores.manager.config;

import java.io.File;

import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import crazyores.manager.pack.data.CrazyOresData;
import crazyores.manager.util.CrazyOresLogger;
import crazyores.packs.core.config.COCoreConfigLoader;

public abstract class COConfigManager {

	public static Configuration config;
	public static final String fileLocation = File.separator + "crazyores-config" + File.separator;
	
	public static void init(FMLPreInitializationEvent event) {
		
		config = new Configuration(new File(event.getSuggestedConfigurationFile().getParentFile() + fileLocation + "crazyores_main.cfg"));
		CrazyOresLogger.write(null, Level.INFO, "Loading Main CrazyOres Configuration file.");
		
		try {	
			config.load();
			
			CrazyOresLogger.write(null, Level.INFO, "CrazyOres Main config file loaded successfully.");
		} 
		catch(Exception e) {
			CrazyOresLogger.write(null, Level.WARN, "Uh oh, something went wrong with the config file. Saving any changes...");
		}
		finally {
			if (config.hasChanged()) {
				config.save();
			}
		}
		
		if (Loader.isModLoaded(CrazyOresData.corePackID)) {
			COCoreConfigLoader.initCore(event);
		}
		
		if (Loader.isModLoaded(CrazyOresData.foodsPackID)) {
//			COFoodsConfig.initFoods(event);
		}
	}
}

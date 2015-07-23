package crazyores.packs.core.config;

import java.io.File;

import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import crazyores.manager.config.COConfigManager;
import crazyores.manager.pack.data.CrazyOresData;
import crazyores.manager.util.CrazyOresLogger;

public class COCoreConfigLoader extends COConfigManager {

	private static final String LOAD_ORE_GEN_CATEGORY = StatCollector.translateToLocal("config.category.oreGeneration");
	
	public static void initCore(FMLPreInitializationEvent event) {
		
		config = new Configuration(new File(event.getSuggestedConfigurationFile().getParentFile() + fileLocation + CrazyOresData.corePackID + ".cfg"));
		
		try {
			config.load();
			
			config.addCustomCategoryComment(LOAD_ORE_GEN_CATEGORY, "true: Will generate the ore. | false: Will not generate the ore.");
			
			/** Ore generation config **/
			COCoreConfigSettings.generateTapaziteStalagmite = config.get(LOAD_ORE_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateTapaziteStalagmite"), true).getBoolean(true);
			COCoreConfigSettings.generateTapaziteStalactite = config.get(LOAD_ORE_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateTapaziteStalactite"), true).getBoolean(true);			
			
			CrazyOresLogger.write(null, Level.INFO, "CrazyOres Core config file loaded successfully.");
		} 
		catch(Exception e) {
			CrazyOresLogger.write(null, Level.WARN, "Uh oh, something went wrong with the config file. Saving any changes...");
		} 
		finally {
			if (config.hasChanged()) {
				config.save();
			}
		}
	}
}

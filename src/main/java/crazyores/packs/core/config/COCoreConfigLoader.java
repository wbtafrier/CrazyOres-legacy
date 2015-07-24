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
	private static final String LOAD_MISC_CATEGORY = StatCollector.translateToLocal("config.category.miscSettings");
	
	public static void initCore(FMLPreInitializationEvent event) {
		
		config = new Configuration(new File(event.getSuggestedConfigurationFile().getParentFile() + fileLocation + CrazyOresData.corePackID + ".cfg"));
		
		try {
			config.load();
			
			config.addCustomCategoryComment(LOAD_ORE_GEN_CATEGORY, "true: Will generate the ore. | false: Will not generate the ore.");
			
			/** Ore generation config **/
			COCoreConfigSettings.generateTapaziteOre = config.get(LOAD_ORE_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateTapaziteOre"), true).getBoolean(true);
			
			COCoreConfigSettings.generateMeteoriteOre = config.get(LOAD_ORE_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateMeteoriteOre"), true).getBoolean(true);
			COCoreConfigSettings.generateCopperOre = config.get(LOAD_ORE_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateCopperOre"), true).getBoolean(true);
			COCoreConfigSettings.generateSapphireOre = config.get(LOAD_ORE_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateSapphireOre"), true).getBoolean(true);
			COCoreConfigSettings.generateAdamiteOre = config.get(LOAD_ORE_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateAdamiteOre"), true).getBoolean(true);
			COCoreConfigSettings.generateRubyOre = config.get(LOAD_ORE_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateRubyOre"), true).getBoolean(true);
			COCoreConfigSettings.generateFoolsRubyOre = config.get(LOAD_ORE_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateFoolsRubyOre"), true).getBoolean(true);
			COCoreConfigSettings.generateZectiumOre = config.get(LOAD_ORE_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateZectiumOre"), true).getBoolean(true);
			COCoreConfigSettings.generateOsmoniumOre = config.get(LOAD_ORE_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateOsmoniumOre"), true).getBoolean(true);
			COCoreConfigSettings.generateStarconiumOre = config.get(LOAD_ORE_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateStarconiumOre"), true).getBoolean(true);
			COCoreConfigSettings.generateExperiumOre = config.get(LOAD_ORE_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateExperiumOre"), true).getBoolean(true);
			
			COCoreConfigSettings.generateDemoniteOre = config.get(LOAD_ORE_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateDemoniteOre"), true).getBoolean(true);
			COCoreConfigSettings.generateInvisiumOre = config.get(LOAD_ORE_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateInvisiumOre"), true).getBoolean(true);
			COCoreConfigSettings.generateDarkstoneOre = config.get(LOAD_ORE_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateDarkstoneOre"), true).getBoolean(true);
			COCoreConfigSettings.generateLuminiteOre = config.get(LOAD_ORE_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateLuminiteOre"), true).getBoolean(true);
			
			
			config.addCustomCategoryComment(LOAD_MISC_CATEGORY, "true: Enables the setting. | false: Disables the setting.");
			
			COCoreConfigSettings.zectiumCoreExplodes = config.get(LOAD_MISC_CATEGORY, StatCollector.translateToLocal("config.node.zectiumCoreExplodes"), true).getBoolean(true);
			
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

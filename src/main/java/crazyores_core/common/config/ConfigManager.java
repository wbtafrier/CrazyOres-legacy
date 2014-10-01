package crazyores_core.common.config;
import org.apache.logging.log4j.Level;

import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import crazyores_core.common.core.COLogger;
/**
 * ConfigManager manages all of the CrazyOres Core's configuration files.
 * @author Andy608 and ISQUISHALL
 */
public class ConfigManager {
	
	private static final String WORLD_GEN_CATEGORY = StatCollector.translateToLocal("config.category.worldGeneration");
	
	public static void writeFiles(FMLPreInitializationEvent event) {
		// Creates main CO Core Configuration file.
		Configuration configFile = new Configuration(event.getSuggestedConfigurationFile());
		COLogger.write(Level.INFO, "Loading CrazyOres Core main configuration file...");
		configFile.load();
		
		/** Ore Generation **/	
		CoreSettings.generateOres = configFile.get(WORLD_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateAllOres"), true, StatCollector.translateToLocal("config.comment.generateAllOres")).getBoolean(true);
		CoreSettings.foolsRubyGen = configFile.get(WORLD_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateFoolsRubyOre"), true, StatCollector.translateToLocal("config.comment.generateFoolsRubyOre")).getBoolean(true);
		CoreSettings.meteoriteGen = configFile.get(WORLD_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateMeteoriteOre"), true, StatCollector.translateToLocal("config.comment.generateMeteoriteOre")).getBoolean(true);
		CoreSettings.copperGen = configFile.get(WORLD_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateCopperOre"), true, StatCollector.translateToLocal("config.comment.generateCopperOre")).getBoolean(true);
		CoreSettings.experiumGen = configFile.get(WORLD_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateExperiumOre"), true, StatCollector.translateToLocal("config.comment.generateExperiumOre")).getBoolean(true);
		CoreSettings.sapphireGen = configFile.get(WORLD_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateSapphireOre"), true, StatCollector.translateToLocal("config.comment.generateSapphireOre")).getBoolean(true);
		CoreSettings.adamiteGen = configFile.get(WORLD_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateAdamiteOre"), true, StatCollector.translateToLocal("config.comment.generateAdamiteOre")).getBoolean(true);
		CoreSettings.invisiumGen = configFile.get(WORLD_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateInvisiumOre"), true, StatCollector.translateToLocal("config.comment.generateInvisiumOre")).getBoolean(true);
		CoreSettings.rubyGen = configFile.get(WORLD_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateRubyOre"), true, StatCollector.translateToLocal("config.comment.generateRubyOre")).getBoolean(true);
		CoreSettings.darkstoneGen = configFile.get(WORLD_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateDarkstone"), true, StatCollector.translateToLocal("config.comment.generateDarkstone")).getBoolean(true);
		CoreSettings.zectiumGen = configFile.get(WORLD_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateZectiumOre"), true, StatCollector.translateToLocal("config.comment.generateZectiumOre")).getBoolean(true);
		CoreSettings.luminiteGen = configFile.get(WORLD_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateLuminiteOre"), true, StatCollector.translateToLocal("config.comment.generateLuminiteOre")).getBoolean(true);
		CoreSettings.tapaziteGen = configFile.get(WORLD_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateTapaziteOre"), true, StatCollector.translateToLocal("config.comment.generateTapaziteOre")).getBoolean(true);
		CoreSettings.demoniteGen = configFile.get(WORLD_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateDemoniteOre"), true, StatCollector.translateToLocal("config.comment.generateDemoniteOre")).getBoolean(true);
		CoreSettings.osmoniumGen = configFile.get(WORLD_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateOsmoniumOre"), true, StatCollector.translateToLocal("config.comment.generateOsmoniumOre")).getBoolean(true);
		CoreSettings.starconiumGen = configFile.get(WORLD_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateStarconiumOre"), true, StatCollector.translateToLocal("config.comment.generateStarconiumOre")).getBoolean(true);
		CoreSettings.enderGen = configFile.get(WORLD_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateEnderOre"), true, StatCollector.translateToLocal("config.comment.generateEnderOre")).getBoolean(true);
		CoreSettings.ultraGen = configFile.get(WORLD_GEN_CATEGORY, StatCollector.translateToLocal("config.node.generateUltraOre"), true, StatCollector.translateToLocal("config.comment.generateUltraOre")).getBoolean(true);
		
		configFile.save();
		COLogger.write(Level.INFO, "CrazyOres Core main configuration file successfully loaded!");
	}
}
package crazyores_core.common.config;
import org.apache.logging.log4j.Level;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import crazyores_core.common.core.COLogger;
/**
 * ConfigManager manages all of the CrazyOres Core's configuration files.
 * @author Andy608 and ISQUISHALL
 */
public class ConfigManager {
	
	private static final String WORLD_GEN_CATEGORY = "WORLD_GENERATION";
	
	public static void writeFiles(FMLPreInitializationEvent event) {
		// Creates main CO Core Configuration file.
		Configuration configFile = new Configuration(event.getSuggestedConfigurationFile());
		COLogger.write(Level.INFO, "Loading CrazyOres Core main configuration file...");
		configFile.load();
		
		//TODO: Add comments "When set to true, all CO ores will be generated in new chunks. Set to false to stop CO ores from spawning in new chunks."
		
		/** Ore Generation **/	
		CoreSettings.generateOres = configFile.get(WORLD_GEN_CATEGORY, "GenerateOres", true).getBoolean(true);
		CoreSettings.copperGen = configFile.get(WORLD_GEN_CATEGORY, "GenerateCopperOre", true).getBoolean(true);
		CoreSettings.sapphireGen = configFile.get(WORLD_GEN_CATEGORY, "GenerateSapphireOre", true).getBoolean(true);
		CoreSettings.adamiteGen = configFile.get(WORLD_GEN_CATEGORY, "GenerateAdamiteOre", true).getBoolean(true);
		CoreSettings.meteoriteGen = configFile.get(WORLD_GEN_CATEGORY, "GenerateMeteoriteOre", true).getBoolean(true);
		CoreSettings.rubyGen = configFile.get(WORLD_GEN_CATEGORY, "GenerateRubyOre", true).getBoolean(true);
		CoreSettings.foolsRubyGen = configFile.get(WORLD_GEN_CATEGORY, "GenerateFoolsRubyOre", true).getBoolean(true);
		CoreSettings.zectiumGen = configFile.get(WORLD_GEN_CATEGORY, "GenerateZectiumOre", true).getBoolean(true);
		CoreSettings.tapaziteGen = configFile.get(WORLD_GEN_CATEGORY, "GenerateTapaziteOre", true).getBoolean(true);
		CoreSettings.crystalGen = configFile.get(WORLD_GEN_CATEGORY, "GenerateCrystalOre", true).getBoolean(true);
		CoreSettings.osmoniumGen = configFile.get(WORLD_GEN_CATEGORY, "GenerateOsmoniumOre", true).getBoolean(true);
		CoreSettings.starconiumGen = configFile.get(WORLD_GEN_CATEGORY, "GenerateStarconiumOre", true).getBoolean(true);
		CoreSettings.demoniteGen = configFile.get(WORLD_GEN_CATEGORY, "GenerateDemoniteStone", true).getBoolean(true);
		CoreSettings.experiumGen = configFile.get(WORLD_GEN_CATEGORY, "GenerateExperiumOre", true).getBoolean(true);
		CoreSettings.invisiumGen = configFile.get(WORLD_GEN_CATEGORY, "GenerateInvisiumOre", true).getBoolean(true);
		CoreSettings.darkStoneGen = configFile.get(WORLD_GEN_CATEGORY, "GenerateDarkStone", true).getBoolean(true);
		CoreSettings.luminiteGen = configFile.get(WORLD_GEN_CATEGORY, "GenerateLuminiteOre", true).getBoolean(true);
		CoreSettings.enderGen = configFile.get(WORLD_GEN_CATEGORY, "GenerateEnderOre", true).getBoolean(true);
		CoreSettings.ultraGen = configFile.get(WORLD_GEN_CATEGORY, "GenerateUltraOre", true).getBoolean(true);
		
		configFile.save();
		COLogger.write(Level.INFO, "CrazyOres Core main configuration file successfully loaded!");
	}
}
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
	
	private static final String WORLDGENCATEGORY = "WORLD_GENERATION";
	
	public static void writeFiles(FMLPreInitializationEvent event) {
		// Creates main CO Core Configuration file.
		Configuration configFile = new Configuration(event.getSuggestedConfigurationFile());
		COLogger.write(Level.INFO, "Loading CrazyOres Core main configuration file...");
		configFile.load();
		
		//TODO: Add comments "When set to true, all CO ores will be generated in new chunks. Set to false to stop CO ores from spawning in new chunks."
		
		/** Ore Generation **/	
		CoreSettings.generateOres = configFile.get(WORLDGENCATEGORY, "GenerateOres", true).getBoolean(true);
		CoreSettings.copperGen = configFile.get(WORLDGENCATEGORY, "GenerateCopperOre", true).getBoolean(true);
		CoreSettings.sapphireGen = configFile.get(WORLDGENCATEGORY, "GenerateSapphireOre", true).getBoolean(true);
		CoreSettings.adamiteGen = configFile.get(WORLDGENCATEGORY, "GenerateAdamiteOre", true).getBoolean(true);
		CoreSettings.meteoriteGen = configFile.get(WORLDGENCATEGORY, "GenerateMeteoriteOre", true).getBoolean(true);
		CoreSettings.rubyGen = configFile.get(WORLDGENCATEGORY, "GenerateRubyOre", true).getBoolean(true);
		CoreSettings.foolsRubyGen = configFile.get(WORLDGENCATEGORY, "GenerateFoolsRubyOre", true).getBoolean(true);
		CoreSettings.zectiumGen = configFile.get(WORLDGENCATEGORY, "GenerateZectiumOre", true).getBoolean(true);
		CoreSettings.tapaziteGen = configFile.get(WORLDGENCATEGORY, "GenerateTapaziteOre", true).getBoolean(true);
		CoreSettings.crystalGen = configFile.get(WORLDGENCATEGORY, "GenerateCrystalOre", true).getBoolean(true);
		CoreSettings.osmoniumGen = configFile.get(WORLDGENCATEGORY, "GenerateOsmoniumOre", true).getBoolean(true);
		CoreSettings.starconiumGen = configFile.get(WORLDGENCATEGORY, "GenerateStarconiumOre", true).getBoolean(true);
		CoreSettings.demoniteGen = configFile.get(WORLDGENCATEGORY, "GenerateDemoniteStone", true).getBoolean(true);
		CoreSettings.experiumGen = configFile.get(WORLDGENCATEGORY, "GenerateExperiumOre", true).getBoolean(true);
		CoreSettings.invisiumGen = configFile.get(WORLDGENCATEGORY, "GenerateInvisiumOre", true).getBoolean(true);
		CoreSettings.darkStoneGen = configFile.get(WORLDGENCATEGORY, "GenerateDarkStone", true).getBoolean(true);
		CoreSettings.luminiteGen = configFile.get(WORLDGENCATEGORY, "GenerateLuminiteOre", true).getBoolean(true);
		CoreSettings.enderGen = configFile.get(WORLDGENCATEGORY, "GenerateEnderOre", true).getBoolean(true);
		CoreSettings.ultraGen = configFile.get(WORLDGENCATEGORY, "GenerateUltraOre", true).getBoolean(true);
		
		configFile.save();
		COLogger.write(Level.INFO, "CrazyOres Core main configuration file successfully loaded!");
	}
}

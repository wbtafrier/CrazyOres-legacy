package crazyores_core.common.config;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigManager {
	
	public static void writeFiles(FMLPreInitializationEvent event) {
		Configuration configFile = new Configuration(event.getSuggestedConfigurationFile());
	}
	
}

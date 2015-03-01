package crazyores.manager.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import crazyores.manager.pack.COPackManager;
import crazyores.manager.pack.data.CrazyOresData;
import crazyores.manager.support.AbstractPack;


public abstract class CrazyOresLogger {

	private static Logger crazyOresLogger;
	
	/**
	 * Using this method will write a message using the default CrazyOres logger with this heading: [CrazyOres]
	 */
	public static void write(Level level, String message) {
		crazyOresLogger = LogManager.getLogger(CrazyOresData.COPrefix);
		crazyOresLogger.log(level, message);
	}
	
	/**
	 * Checks what pack the logger should display as and then writes the message under that pack in the console.
	 * @param pack is the CrazyOres pack the logger should display as.
	 * @param level is the Level type to use ie: Level.INFO
	 * @param message is the message that should be displayed in the console.
	 */
	public static void write(AbstractPack pack, Level level, String message) {
		
		if (pack != null) {
			
			for (AbstractPack p : COPackManager.getActivePacks()) {
				if (pack.getFullPackName().equalsIgnoreCase(p.getFullPackName())) {
					crazyOresLogger = LogManager.getLogger(pack.getFullPackName());
					crazyOresLogger.log(level, message);
					return;
				}
			}
			crazyOresLogger.log(Level.WARN, "No active packs were found under the name: " + pack.getFullPackName() + " in the active packs list. Using default CrazyOres Logger.");
		}
		CrazyOresLogger.write(level, message);
	}
	
	/**
	 * Outputs all of the loaded packs in order once they are all loaded.
	 */
	public static void outputLoadedPacks() {
		for (AbstractPack p : COPackManager.getActivePacks()) {
			crazyOresLogger = LogManager.getLogger(p.getFullPackName());
			crazyOresLogger.log(Level.INFO, p.getFullPackName() + " has finished loading. Enjoy!");
		}
	}
}
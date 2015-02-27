package crazyores.manager.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.util.Color;


public abstract class CrazyOresLogger {

	private static Logger crazyOresLogger;
	
	/**
	 * Used if the pack entered is null.
	 * Writing null is discouraged but, if done, will use the standard logger - [CrazyOres]
	 */
	private static void setDefaultLogger() {
		crazyOresLogger = LogManager.getLogger(CrazyOresData.COPrefix);
		crazyOresLogger.log(Level.WARN, "Setting the Logger to the Default logger! Is this what you wanted?");
	}
	
	/**
	 * Checks what pack the logger should display as and then writes the message under that pack in the console.
	 * @param pack is the CrazyOres pack the logger should display as.
	 * @param level is the Level type to use ie: Level.INFO
	 * @param message is the message that should be displayed in the console.
	 */
	public static void write(String pack, Level level, String message) {
		
		if (pack != null) {
			if (pack.equalsIgnoreCase(CrazyOresData.COPrefix)) {
				crazyOresLogger = LogManager.getLogger(pack);
				crazyOresLogger.log(level, message);
				return;
			}
			
			for (String s : COPackManager.getActivePacks()) {
				if (pack.equalsIgnoreCase(s)) {
					crazyOresLogger = LogManager.getLogger(pack);
					crazyOresLogger.log(level, message);
					return;
				}
			}
		}
		CrazyOresLogger.setDefaultLogger();
	}
	
	/**
	 * Outputs all of the loaded packs in order once they are all loaded.
	 */
	public static void outputLoadedPacks() {
		for (String pack : COPackManager.getActivePacks()) {
			crazyOresLogger = LogManager.getLogger(pack);
			crazyOresLogger.log(Level.INFO, pack + " has finished loading. Enjoy!");
		}
	}
}
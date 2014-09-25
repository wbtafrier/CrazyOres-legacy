package crazyores_core.common.core;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * COLogger writes all CrazyOres related messages to the console.
 * @author Andy608 and ISQUISHALL
 */
public class COLogger {
	private static Logger COLogger = LogManager.getLogger(COData.MOD_NAME);
	
	/**
	 * Calls the log method for COLogger.
	 * @param l - The level of severity for the log.
	 * @param s - The actual message.
	 */
	public static void write(Level l, String s) {
		COLogger.log(l, s);
	}
}
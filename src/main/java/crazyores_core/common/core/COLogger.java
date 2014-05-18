package crazyores_core.common.core;



import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.FMLLog;

public class COLogger 
{
	private static Logger COLogger = LogManager.getLogger(COData.modName);
	
	
	public static void log(Level lev, String str)
	{
		COLogger.log(lev, str);
	}
}

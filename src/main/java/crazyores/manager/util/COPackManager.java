package crazyores.manager.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.Loader;

/**
 * In this class we will check to see which packs are installed and if they are, load them into the game.
 * @author Andy608 and ISQUISHALL
 */
public class COPackManager {
	
	//List of packs installed that can be iterated through
	private static List<String> crazyOresPackNames = new ArrayList<>();
	
	//Booleans to check if a pack is installed
	private static boolean isCoreInstalled = false;
	private static boolean isFoodsInstalled = false;
	

	/**
	 * Loads all of the installed packs and their data.
	 */
	public static void loadPackData() {

		if (Loader.isModLoaded(CrazyOresData.crazyOresCoreID)) {
			crazyOresPackNames.add(CrazyOresData.crazyOresCoreName);
			isCoreInstalled = true;
		}

		if (Loader.isModLoaded(CrazyOresData.crazyOresFoodsID)) {
			crazyOresPackNames.add(CrazyOresData.crazyOresFoodsName);
			isFoodsInstalled = true;
		}
		
		COPackManager.loadLoggers();
	}
	
	private static void loadLoggers() {
		for (String s : crazyOresPackNames) {
			CrazyOresLogger.write(s, Level.INFO, s + " is recognized! Loading up...");
		}
	}
	
	/**
	 * Returns a list of all the packs currently installed in the users game.
	 * @return crazyOresPackNames : A list of all the loaded packs.
	 */
	public static List<String> getActivePacks() {
		return crazyOresPackNames;
	}
	
	public static boolean isCoreInstalled() {
		return isCoreInstalled;
	}
	
	public static boolean isFoodsInstalled() {
		return isFoodsInstalled;
	}
}

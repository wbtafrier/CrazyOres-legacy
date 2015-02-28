package crazyores.manager.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.Loader;
import crazyores.manager.config.COConfigSettings;

/**
 * In this class we will check to see which packs are installed and if they are, load them into the game.
 * @author Andy608 and ISQUISHALL
 */
public class COPackManager {
	
	//List of packs installed that can be iterated through
	private static List<String> crazyOresPackNames = new ArrayList<>();
	
	/**
	 * Loads all of the installed packs and their data.
	 */
	public static void loadPackData() {

		if (Loader.isModLoaded(CrazyOresData.corePackID) && COConfigSettings.isCoreActivated()) {
			crazyOresPackNames.add(CrazyOresData.coreFullPackName);
		}

		if (Loader.isModLoaded(CrazyOresData.foodsPackID) && COConfigSettings.isFoodsActivated()) {
			crazyOresPackNames.add(CrazyOresData.foodsFullPackName);
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
}
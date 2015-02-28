package crazyores.manager.pack;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.Loader;
import crazyores.manager.config.COConfigSettings;
import crazyores.manager.pack.data.CorePackData;
import crazyores.manager.pack.data.FoodsPackData;
import crazyores.manager.util.CrazyOresLogger;
import crazyores.manager.util.Pack;

/**
 * In this class we will check to see which packs are installed and if they are, load them into the game.
 * @author Andy608 and ISQUISHALL
 */
public class COPackManager {
	
	//List of all the pack instances
	public static final Pack corePack = new CorePackData();
	public static final Pack foodsPack = new FoodsPackData();
	
	//List of packs installed that can be iterated through
	private static List<Pack> crazyOresPackNames = new ArrayList<>();
	
	/**
	 * Loads all of the installed packs and their data.
	 */
	public static void loadPackData() {

		if (Loader.isModLoaded(corePack.getPackID()) && COConfigSettings.isCoreActivated()) {
			crazyOresPackNames.add(corePack);
		}

		if (Loader.isModLoaded(foodsPack.getPackID()) && COConfigSettings.isFoodsActivated()) {
			try {
				crazyOresPackNames.add(foodsPack);
			}
			catch (Exception e) {
				CrazyOresLogger.write(Level.ERROR, "CrazyOres was unable to load the " + foodsPack.getFullPackName() + " addon.");
				e.printStackTrace();
			}
		}
		
		COPackManager.loadLoggers();
	}
	
	private static void loadLoggers() {
		for (Pack pack : crazyOresPackNames) {
			CrazyOresLogger.write(pack, Level.INFO, pack.getFullPackName() + " is recognized! Loading up...");
		}
	}
	
	/**
	 * Returns a list of all the packs currently installed in the users game.
	 * @return crazyOresPackNames : A list of all the loaded packs.
	 */
	public static List<Pack> getActivePacks() {
		return crazyOresPackNames;
	}
}
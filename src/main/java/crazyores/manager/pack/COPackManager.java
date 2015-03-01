package crazyores.manager.pack;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.Loader;
import crazyores.manager.pack.data.CorePackData;
import crazyores.manager.pack.data.FoodsPackData;
import crazyores.manager.support.AbstractPack;
import crazyores.manager.tabs.CrazyOresTabs;
import crazyores.manager.util.CrazyOresLogger;
import crazyores.packs.core.block.CoreBlocks;
import crazyores.packs.core.tabs.CoreTabs;

/**
 * In this class we will check to see which packs are installed and if they are, load them into the game.
 * @author Andy608 and ISQUISHALL
 */
public class COPackManager {
	
	//List of all the pack instances
	public static final AbstractPack corePack = new CorePackData();
	public static final AbstractPack foodsPack = new FoodsPackData();
	
	//List of packs installed that can be iterated through
	private static List<AbstractPack> crazyOresPackNames = new ArrayList<>();
	
	/**
	 * Loads all of the installed packs and their data.
	 */
	public static void loadPackData() {

		CrazyOresTabs.initTabs();
		
		if (Loader.isModLoaded(corePack.getPackID())) {
			crazyOresPackNames.add(corePack);
			CoreTabs.initCoreTabs();
			CoreBlocks.initBlocks();
		}

		if (Loader.isModLoaded(foodsPack.getPackID())) {
			try {
				crazyOresPackNames.add(foodsPack);
//				FoodsTabs.initFoodsTabs();
			}
			catch (Exception e) {
				CrazyOresLogger.write(Level.ERROR, "CrazyOres was unable to load the " + foodsPack.getFullPackName() + " addon.");
				e.printStackTrace();
			}
		}
		
		COPackManager.loadLoggers();
	}
	
	private static void loadLoggers() {
		for (AbstractPack pack : crazyOresPackNames) {
			CrazyOresLogger.write(pack, Level.INFO, pack.getFullPackName() + " is recognized! Loading up...");
		}
	}
	
	/**
	 * Returns a list of all the packs currently installed in the users game.
	 * @return crazyOresPackNames : A list of all the loaded packs.
	 */
	public static List<AbstractPack> getActivePacks() {
		return crazyOresPackNames;
	}
}
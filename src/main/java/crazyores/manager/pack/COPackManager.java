package crazyores.manager.pack;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.Loader;
import crazyores.manager.pack.data.CorePackData;
import crazyores.manager.pack.data.FoodsPackData;
import crazyores.manager.support.AbstractPack;
import crazyores.manager.tabs.CrazyOresTabs;
import crazyores.manager.util.CrazyOresLogger;
import crazyores.packs.core.block.CoreBlocks;
import crazyores.packs.core.entity.CoreEntityRegistry;
import crazyores.packs.core.event.CoreEventManager;
import crazyores.packs.core.event.TapaziteObeliskEvent;
import crazyores.packs.core.item.CoreItems;
import crazyores.packs.core.tabs.CoreTabs;
import crazyores.packs.core.util.CoreHarvestLevels;
import crazyores.packs.core.world.generate.CoreLootHandler;

/**
 * In this class we will check to see which packs are installed and if they are, load them into the game.
 * @author Andy608 and ISQUISHALL
 */
public class COPackManager {
	
	//List of all the pack instances
	public static final AbstractPack corePack = new CorePackData();
	public static final AbstractPack foodsPack = new FoodsPackData();
	
	//List of packs installed that can be iterated through
	private static List<AbstractPack> crazyOresPackNames = new ArrayList<AbstractPack>();
	
	/**
	 * Loads all of the installed packs and their data.
	 */
	public static void init() {

		CrazyOresTabs.initTabs();
		
		if (Loader.isModLoaded(corePack.getPackID())) {
			crazyOresPackNames.add(corePack);
			CoreTabs.initCoreTabs();
			CoreBlocks.initBlocks();
			CoreItems.initItems();
			CoreLootHandler.initLoot();
			CoreHarvestLevels.setHarvestLevels();
			CoreEventManager.registerEvents();
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
	
	public static void postInit() {
		if (Loader.isModLoaded(corePack.getPackID())) {
		}
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
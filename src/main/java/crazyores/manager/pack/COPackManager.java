package crazyores.manager.pack;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.manager.pack.data.CorePackData;
import crazyores.manager.pack.data.FoodsPackData;
import crazyores.manager.support.AbstractPack;
import crazyores.manager.tabs.CrazyOresTabs;
import crazyores.manager.util.CrazyOresLogger;
import crazyores.manager.world.generate.Generate;
import crazyores.packs.core.block.CoreBlocks;
import crazyores.packs.core.entity.CoreEntityRegistry;
import crazyores.packs.core.event.CoreEventManager;
import crazyores.packs.core.gui.CoreGuiRegistry;
import crazyores.packs.core.item.CoreFluidContainerRegistry;
import crazyores.packs.core.item.CoreItems;
import crazyores.packs.core.recipe.CoreFuelHandler;
import crazyores.packs.core.recipe.CoreRecipes;
import crazyores.packs.core.tabs.CoreTabs;
import crazyores.packs.core.util.CoreHarvestLevels;
import crazyores.packs.core.world.generate.CoreLootHandler;
import crazyores.packs.core.world.generate.GenerateStructures;

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
	public static void preInit() {

		CrazyOresTabs.initTabs();
		
		if (Loader.isModLoaded(corePack.getPackID())) {
			crazyOresPackNames.add(corePack);
			CoreTabs.initCoreTabs();
			CoreBlocks.initBlocks();
			CoreItems.initItems();
			CoreFuelHandler.initFuels();
			CoreHarvestLevels.setHarvestLevels();
			CoreEventManager.registerEvents();
			NetworkRegistry.INSTANCE.registerGuiHandler(corePack.getPackID(), new CoreGuiRegistry());
			CoreFluidContainerRegistry.registerFluidContainers();
		}

		COPackManager.loadLoggers();
	}
	
	public static void init() {
		CoreEntityRegistry.registerCoreEntities();
		CoreEntityRegistry.registerDispenserBehaviors();
		CoreEntityRegistry.registerCoreTileEntities();
		CoreLootHandler.initLoot();
		GameRegistry.registerWorldGenerator(new Generate(), 0);
		CoreRecipes.initCraftingRecipes();
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
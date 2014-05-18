package crazyores_core.common.core;

import net.minecraftforge.oredict.OreDictionary;
import crazyores_core.common.blocks.BlockList;
import crazyores_core.common.items.ItemList;

public class Dictionary 
{
	public static void registerItems(ItemList il)
	{
		OreDictionary.registerOre("ingotCopper", il.adamite_rod);
		OreDictionary.registerOre("ingotCopper", il.copper_ingot);
		OreDictionary.registerOre("gemSapphire", il.sapphire_gem);
		OreDictionary.registerOre("shardAdamite", il.adamite_shard);
		OreDictionary.registerOre("coalMeteorite", il.meteorite_coal);
		OreDictionary.registerOre("gemMeteorite", il.meteorite_gem);
		OreDictionary.registerOre("gemRuby", il.ruby_gem);
		OreDictionary.registerOre("gemFoolsRuby", il.fools_ruby_gem);
		OreDictionary.registerOre("ingotZectium", il.zectium_ingot);
		OreDictionary.registerOre("gemTapazite", il.tapazite_gem);
		OreDictionary.registerOre("shardCrystal", il.crystal_shard);
		OreDictionary.registerOre("ingotOsmonium", il.osmonium_ingot);
		OreDictionary.registerOre("gemStarconium", il.starconium_gem);
		OreDictionary.registerOre("orbDemonite", il.demonite_orb);
		OreDictionary.registerOre("gemEnder", il.ender_gem);
		OreDictionary.registerOre("ingotInvisium", il.invisium_ingot);
		OreDictionary.registerOre("ingotDarkstone", il.darkstone_ingot);
		OreDictionary.registerOre("crystalWhiteLuminite", il.white_luminite_crystal);
//		OreDictionary.registerOre("crystalRedLuminite", il.red_luminite_crystal);
//		OreDictionary.registerOre("crystalOrangeLuminite", il.orange_luminite_crystal);
//		OreDictionary.registerOre("crystalYellowLuminite", il.yellow_luminite_crystal);
//		OreDictionary.registerOre("crystalGreenLuminite", il.green_luminite_crystal);
//		OreDictionary.registerOre("crystalBlueLuminite", il.blue_luminite_crystal);
//		OreDictionary.registerOre("crystalPurpleLuminite", il.purple_luminite_crystal);

	}
}

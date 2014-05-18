package crazyores_core.common.core;

import net.minecraftforge.oredict.OreDictionary;
import crazyores_core.common.blocks.BlockList;
import crazyores_core.common.items.ItemList;

public class Dictionary 
{
	public static void registerBlocks(BlockList bl)
	{
		OreDictionary.registerOre("oreCopper", bl.copper_ore);
		OreDictionary.registerOre("oreSapphire", bl.sapphire_ore);
		OreDictionary.registerOre("oreAdamite", bl.adamite_ore);
		OreDictionary.registerOre("oreMeteorite", bl.meteorite_ore);
		OreDictionary.registerOre("oreRuby", bl.ruby_ore);
		OreDictionary.registerOre("oreFoolsRuby", bl.fools_ruby_ore);
		OreDictionary.registerOre("oreZectium", bl.zectium_ore);
		OreDictionary.registerOre("oreTapazite", bl.tapazite_ore);
		OreDictionary.registerOre("oreCrystal", bl.crystal_ore);
		OreDictionary.registerOre("oreOsmonium", bl.osmonium_ore);
		OreDictionary.registerOre("oreStarconium", bl.starconium_ore);
		OreDictionary.registerOre("oreDemonite", bl.demonite_stone);
		OreDictionary.registerOre("oreInvisium", bl.invisium_ore);
		OreDictionary.registerOre("oreDarkStone", bl.darkstone);
		OreDictionary.registerOre("oreLuminite", bl.luminite_ore);
		OreDictionary.registerOre("oreEnder", bl.ender_ore);
	}
	
	public static void registerItems(ItemList il)
	{
		OreDictionary.registerOre("copperIngot", il.copper_ingot);
		OreDictionary.registerOre("sapphireGem", il.sapphire_gem);
		OreDictionary.registerOre("adamiteShard", il.adamite_shard);
		OreDictionary.registerOre("meteoriteCoal", il.meteorite_coal);
		OreDictionary.registerOre("meteoriteGem", il.meteorite_gem);
		OreDictionary.registerOre("rubyGem", il.ruby_gem);
		OreDictionary.registerOre("foolsRubyGem", il.fools_ruby_gem);
		OreDictionary.registerOre("zectiumIngot", il.zectium_ingot);
		OreDictionary.registerOre("tapaziteGem", il.tapazite_gem);
		OreDictionary.registerOre("crystalShard", il.crystal_shard);
		OreDictionary.registerOre("osmoniumIngot", il.osmonium_ingot);
		OreDictionary.registerOre("starconiumGem", il.starconium_gem);
		OreDictionary.registerOre("demoniteOrb", il.demonite_orb);
		OreDictionary.registerOre("enderGem", il.ender_gem);
		OreDictionary.registerOre("invisiumIngot", il.invisium_ingot);
		OreDictionary.registerOre("darkStoneIngot", il.darkstone_ingot);
		OreDictionary.registerOre("whiteLuminiteCrystal", il.white_luminite_crystal);
//		OreDictionary.registerOre("redLuminiteCrystal", il.red_luminite_crystal);
//		OreDictionary.registerOre("orangeLuminiteCrystal", il.orange_luminite_crystal);
//		OreDictionary.registerOre("yellowLuminiteCrystal", il.yellow_luminite_crystal);
//		OreDictionary.registerOre("greenLuminiteCrystal", il.green_luminite_crystal);
//		OreDictionary.registerOre("blueLuminiteCrystal", il.blue_luminite_crystal);
//		OreDictionary.registerOre("purpleLuminiteCrystal", il.purple_luminite_crystal);

	}
}

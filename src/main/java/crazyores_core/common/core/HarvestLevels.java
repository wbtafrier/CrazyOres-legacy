package crazyores_core.common.core;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import crazyores_core.common.blocks.BlockList;
import crazyores_core.common.items.ItemList;

public class HarvestLevels 
{
	/**
	 * This method changes the harvest levels of all tools, so they are in the correct tiers. **NEEDS MAJOR HELP
	 * @param bl static instance of BlockList, to make our lives easier.
	 */
	public static void addBlockHarvestLevels(BlockList bl)
	{	
		/** Tool Ranks **/
		Items.golden_pickaxe.setHarvestLevel("pickaxe",  0);
		Items.wooden_pickaxe.setHarvestLevel("pickaxe",  0);
		
		Items.stone_pickaxe.setHarvestLevel("pickaxe",  1);
		
		ItemList.meteorite_pickaxe.setHarvestLevel("pickaxe",  2);
		ItemList.copper_pickaxe.setHarvestLevel("pickaxe",  2);
		
		ItemList.invisium_pickaxe.setHarvestLevel("pickaxe",  3);
		Items.iron_pickaxe.setHarvestLevel("pickaxe",  3);
		
		ItemList.sapphire_pickaxe.setHarvestLevel("pickaxe",  4);
		ItemList.adamite_pickaxe.setHarvestLevel("pickaxe",  4);
		
		ItemList.ruby_pickaxe.setHarvestLevel("pickaxe",  5);
		
		Items.diamond_pickaxe.setHarvestLevel("pickaxe",  6);
		
		ItemList.zectium_pickaxe.setHarvestLevel("pickaxe",  7);
		
		ItemList.tapazite_pickaxe.setHarvestLevel("pickaxe",  8);
		
		ItemList.crystal_pickaxe.setHarvestLevel("pickaxe",  9);
		
		ItemList.osmonium_pickaxe.setHarvestLevel("pickaxe", 10);
		ItemList.ender_pickaxe.setHarvestLevel("pickaxe", 10);
		ItemList.starconium_pickaxe.setHarvestLevel("pickaxe", 10);
		
		ItemList.starconium_sledgehammer.setHarvestLevel("pickaxe", 11);

		/** Block Harvests **/
		bl.fools_ruby_ore.setHarvestLevel("pickaxe",  0);
		bl.fools_ruby_block.setHarvestLevel("pickaxe",  0);
		bl.fools_ruby_golem_head.setHarvestLevel("pickaxe", 0);
		Blocks.coal_ore.setHarvestLevel("pickaxe",  0);
		Blocks.gold_ore.setHarvestLevel("pickaxe",  0);
		//coal/gold blocks?
		
		Blocks.lapis_ore.setHarvestLevel("pickaxe",  1);
		//lapis block?
		bl.meteorite_ore.setHarvestLevel("pickaxe",  1);
		bl.meteorite_block.setHarvestLevel("pickaxe",  1);
		bl.glowing_meteorite_block.setHarvestLevel("pickaxe",  1);
		bl.experium_ore.setHarvestLevel("pickaxe",  1);
		bl.experium_block.setHarvestLevel("pickaxe",  1);
		bl.copper_ore.setHarvestLevel("pickaxe",  1);
		bl.copper_block.setHarvestLevel("pickaxe",  1);
		bl.copper_golem_head.setHarvestLevel("pickaxe",  1);
		
		Blocks.iron_ore.setHarvestLevel("pickaxe",  2);
		//iron block?
		bl.darkstone.setHarvestLevel("pickaxe",  2);
		
		bl.sapphire_ore.setHarvestLevel("pickaxe",  3);
		bl.sapphire_block.setHarvestLevel("pickaxe",  3);
		bl.sapphire_golem_head.setHarvestLevel("pickaxe",  3);
		bl.adamite_ore.setHarvestLevel("pickaxe",  3);
		bl.adamite_golem_head.setHarvestLevel("pickaxe",  3);
		bl.adamite_block.setHarvestLevel("pickaxe",  3);
		Blocks.quartz_ore.setHarvestLevel("pickaxe",  3);
		//quartz block?
		Blocks.redstone_ore.setHarvestLevel("pickaxe",  3);
		Blocks.lit_redstone_ore.setHarvestLevel("pickaxe",  3);
		//redstone block?
		Blocks.emerald_ore.setHarvestLevel("pickaxe",  3);
		//emerald block?
		bl.luminite_ore.setHarvestLevel("pickaxe",  3);
		bl.invisium_ore.setHarvestLevel("pickaxe",  3);
		bl.invisium_block.setHarvestLevel("pickaxe",  3);
		
		bl.ruby_ore.setHarvestLevel("pickaxe",  4);
		bl.ruby_block.setHarvestLevel("pickaxe",  4);
		bl.ruby_golem_head.setHarvestLevel("pickaxe",  4);
		
		Blocks.diamond_ore.setHarvestLevel("pickaxe", 5);
		//diamond block?
		
		//obsidian? HELLO?????
		
		bl.zectium_ore.setHarvestLevel("pickaxe",  6);
		bl.zectium_block.setHarvestLevel("pickaxe",  6);
		bl.zectium_golem_head.setHarvestLevel("pickaxe",  6);
		bl.demonite_stone.setHarvestLevel("pickaxe",  6);
		bl.demonite_block.setHarvestLevel("pickaxe",  6);
		bl.refined_demonite_block.setHarvestLevel("pickaxe",  6);
		bl.demonite_golem_head.setHarvestLevel("pickaxe",  6);
		bl.demonite_furnace.setHarvestLevel("pickaxe",  6);
		bl.lit_demonite_furnace.setHarvestLevel("pickaxe",  6);
		
		bl.tapazite_ore.setHarvestLevel("pickaxe",  7);
		bl.tapazite_block.setHarvestLevel("pickaxe",  7);
		// golem head?
		
		bl.crystal_ore.setHarvestLevel("pickaxe",  8);
		bl.crystal_block.setHarvestLevel("pickaxe",  8);
		bl.crystal_golem_head.setHarvestLevel("pickaxe",  8);
		
		bl.osmonium_ore.setHarvestLevel("pickaxe",  9);
		bl.osmonium_block.setHarvestLevel("pickaxe",  9);
		// golem head?
		
		bl.ender_ore.setHarvestLevel("pickaxe", 10);
		bl.ender_block.setHarvestLevel("pickaxe", 10);
		bl.starconium_ore.setHarvestLevel("pickaxe", 10);
		bl.starconium_block.setHarvestLevel("pickaxe", 10);
		bl.starconium_golem_head.setHarvestLevel("pickaxe", 10);
		
		bl.ultra_ore.setHarvestLevel("pickaxe", 11);
		bl.ultra_block.setHarvestLevel("pickaxe", 11);
	}
}

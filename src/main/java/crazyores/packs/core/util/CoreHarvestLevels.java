package crazyores.packs.core.util;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.relauncher.ReflectionHelper;
import crazyores.packs.core.block.CoreBlocks;

public class CoreHarvestLevels {

	private static final String PICKAXE = "pickaxe";
	
	/** Tools Strength**/
  /*                       addToolMaterial(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability);*/
  /*public static final ItemTool.ToolMaterial woodEnum = 			EnumHelper.addToolMaterial("WOOD", 			 0,   59,  2.0f, 0.0f, 15);*/
  /*public static final ItemTool.ToolMaterial goldEnum =	 		EnumHelper.addToolMaterial("GOLD", 			 0,   32, 12.0f, 0.0f, 22);*/
  /*public static final ItemTool.ToolMaterial stoneEnum = 			EnumHelper.addToolMaterial("STONE", 		 1,  131,  4.0f, 1.0f,  5);*/
	public static final ItemTool.ToolMaterial COPPER = 				EnumHelper.addToolMaterial("COPPER", 		 2,  446,  5.0f, 1.0f, 14);
	public static final ItemTool.ToolMaterial METEORITE = 			EnumHelper.addToolMaterial("METEORITE", 	 2,  331,  4.0f, 1.0f, 20);
  /*public static final ItemTool.ToolMaterial ironEnum = 			EnumHelper.addToolMaterial("IRON", 			 3, 250,   6.0f, 2.0f, 14);*/
	public static final ItemTool.ToolMaterial ADAMITE = 			EnumHelper.addToolMaterial("ADAMITE", 		 4,  861,  8.0f, 2.0f, 12);
	public static final ItemTool.ToolMaterial SAPPHIRE = 			EnumHelper.addToolMaterial("SAPPHIRE", 		 5,  601,  7.0f, 2.0f, 13);
	public static final ItemTool.ToolMaterial RUBY = 				EnumHelper.addToolMaterial("RUBY", 			 6, 1011,  8.5f, 3.0f, 12);
	/*public static final ItemTool.ToolMaterial diamondEnum = 		EnumHelper.addToolMaterial("EMERALD", 		 7, 1561,  8.0f, 3.0f, 10);*/
	public static final ItemTool.ToolMaterial INVISIUM = 			EnumHelper.addToolMaterial("INVISIUM", 		 8,  538,  6.0f, 0.0f, 12);
	public static final ItemTool.ToolMaterial ZECTIUM = 			EnumHelper.addToolMaterial("ZECTIUM", 		 8, 1701, 10.0f, 4.0f,  9);
	public static final ItemTool.ToolMaterial TAPAZITE = 			EnumHelper.addToolMaterial("TAPAZITE", 		 9,  612, 12.0f, 3.0f, 10);
	public static final ItemTool.ToolMaterial OSMONIUM = 			EnumHelper.addToolMaterial("OSMONIUM", 		10, 2381, 20.0f, 4.0f,  7);
	
	public static final ItemTool.ToolMaterial STARCONIUM = 			EnumHelper.addToolMaterial("STARCONIUM", 	11, 3001, 16.0f, 8.0f,  6);
	public static final ItemTool.ToolMaterial STARCONIUM_HAMMER =	EnumHelper.addToolMaterial("STARHAMMER", 	12, 1066, 65.0f, 8.0f,  6);
	
	public static final ItemTool.ToolMaterial ENDER = 				EnumHelper.addToolMaterial("ENDER", 		13, 2239, 15.0f, 7.0f,  6);
	
	public static void setHarvestLevels() {
		
		new ForgeHooks();
		
		//Override current enums
		ReflectionHelper.setPrivateValue(ToolMaterial.class, ToolMaterial.WOOD, 0, 5);
		ReflectionHelper.setPrivateValue(ToolMaterial.class, ToolMaterial.GOLD, 0, 5);
		ReflectionHelper.setPrivateValue(ToolMaterial.class, ToolMaterial.STONE, 1, 5);
		ReflectionHelper.setPrivateValue(ToolMaterial.class, ToolMaterial.IRON, 3, 5);
		ReflectionHelper.setPrivateValue(ToolMaterial.class, ToolMaterial.EMERALD, 7, 5);
		
		//Update block harvest levels
		Blocks.obsidian.setHarvestLevel(PICKAXE, 7);
		
		Blocks.coal_block.setHarvestLevel(PICKAXE, 0);
		Blocks.coal_ore.setHarvestLevel(PICKAXE, 0);
		
		CoreBlocks.diagonalBrick.setHarvestLevel(PICKAXE, 0);
		CoreBlocks.diagonalBrickStairs.setHarvestLevel(PICKAXE, 0);
		
		CoreBlocks.lightenedBrick.setHarvestLevel(PICKAXE, 0);
		CoreBlocks.lightenedBrickStairs.setHarvestLevel(PICKAXE, 0);
		CoreBlocks.diagonalLightenedBrick.setHarvestLevel(PICKAXE, 0);
		CoreBlocks.diagonalLightenedBrickStairs.setHarvestLevel(PICKAXE, 0);
		
		Blocks.gold_block.setHarvestLevel(PICKAXE, 2);
		Blocks.gold_ore.setHarvestLevel(PICKAXE, 2);
		
		Blocks.iron_block.setHarvestLevel(PICKAXE, 2);
		Blocks.iron_bars.setHarvestLevel(PICKAXE, 2);
		Blocks.iron_door.setHarvestLevel(PICKAXE, 2);
		Blocks.iron_ore.setHarvestLevel(PICKAXE, 2);
		
		Blocks.emerald_block.setHarvestLevel(PICKAXE, 3);
		Blocks.emerald_ore.setHarvestLevel(PICKAXE, 3);
		
		Blocks.redstone_block.setHarvestLevel(PICKAXE, 3);
		Blocks.redstone_ore.setHarvestLevel(PICKAXE, 3);
		Blocks.lit_redstone_ore.setHarvestLevel(PICKAXE, 3);
		
		Blocks.lapis_block.setHarvestLevel(PICKAXE, 3);
		Blocks.lapis_ore.setHarvestLevel(PICKAXE, 3);
		
		Blocks.diamond_block.setHarvestLevel(PICKAXE, 6);
		Blocks.diamond_ore.setHarvestLevel(PICKAXE, 6);
		
		Blocks.quartz_block.setHarvestLevel(PICKAXE, 3);
		Blocks.quartz_ore.setHarvestLevel(PICKAXE, 3);
		Blocks.quartz_stairs.setHarvestLevel(PICKAXE, 3);
		
//		//CrazyOres Harvest Levels
		CoreBlocks.copperOre.setHarvestLevel(PICKAXE, 1);
		CoreBlocks.copperBlock.setHarvestLevel(PICKAXE, 1);
		CoreBlocks.copperGolemHead.setHarvestLevel(PICKAXE, 1);
		
		CoreBlocks.meteoriteOre.setHarvestLevel(PICKAXE, 2);
		CoreBlocks.meteoriteBlock.setHarvestLevel(PICKAXE, 2);
		
		CoreBlocks.adamiteOre.setHarvestLevel(PICKAXE, 3);
		CoreBlocks.adamiteBlock.setHarvestLevel(PICKAXE, 3);
		CoreBlocks.adamiteGolemHead.setHarvestLevel(PICKAXE, 3);
		
		CoreBlocks.adamiteBrick.setHarvestLevel(PICKAXE, 3);
		CoreBlocks.diagonalAdamiteBrick.setHarvestLevel(PICKAXE, 3);
		CoreBlocks.adamiteBrickStairs.setHarvestLevel(PICKAXE, 3);
		CoreBlocks.diagonalAdamiteBrickStairs.setHarvestLevel(PICKAXE, 3);
		
		CoreBlocks.adamiteSharkSpawner.setHarvestLevel(PICKAXE, 3);
		CoreBlocks.greatWhiteSharkSpawner.setHarvestLevel(PICKAXE, 3);
		
		CoreBlocks.sapphireOre.setHarvestLevel(PICKAXE, 4);
		CoreBlocks.sapphireBlock.setHarvestLevel(PICKAXE, 4);
		CoreBlocks.sapphireGolemHead.setHarvestLevel(PICKAXE, 4);
		
		CoreBlocks.rubyOre.setHarvestLevel(PICKAXE, 5);
		CoreBlocks.rubyBlock.setHarvestLevel(PICKAXE, 5);
		CoreBlocks.rubyGolemHead.setHarvestLevel(PICKAXE, 5);
		
		CoreBlocks.invisiumOre.setHarvestLevel(PICKAXE, 7);
		CoreBlocks.invisiumBlock.setHarvestLevel(PICKAXE, 7);
		
		CoreBlocks.zectiumOre.setHarvestLevel(PICKAXE, 7);
		CoreBlocks.zectiumBlock.setHarvestLevel(PICKAXE, 7);
		CoreBlocks.zectiumGolemHead.setHarvestLevel(PICKAXE, 7);
		
		CoreBlocks.reinforcedBrick.setHarvestLevel(PICKAXE, 7);
		CoreBlocks.diagonalReinforcedBrick.setHarvestLevel(PICKAXE, 7);
		CoreBlocks.reinforcedBrickStairs.setHarvestLevel(PICKAXE, 7);
		CoreBlocks.diagonalReinforcedBrickStairs.setHarvestLevel(PICKAXE, 7);
		CoreBlocks.reinforcedChest.setHarvestLevel(PICKAXE, 7);
		
		CoreBlocks.zectiumProtectorSpawner.setHarvestLevel(PICKAXE, 7);
		
		CoreBlocks.tapaziteBlock.setHarvestLevel(PICKAXE, 8);
		CoreBlocks.tapaziteGolemHead.setHarvestLevel(PICKAXE, 8);
		CoreBlocks.tapaziteGolemHead.setHarvestLevel(PICKAXE, 8);
		
		CoreBlocks.osmoniumOre.setHarvestLevel(PICKAXE, 9);
		CoreBlocks.osmoniumBlock.setHarvestLevel(PICKAXE, 9);
		CoreBlocks.osmoniumGolemHead.setHarvestLevel(PICKAXE, 9);
		
		CoreBlocks.starconiumOre.setHarvestLevel(PICKAXE, 10);
		CoreBlocks.starconiumBlock.setHarvestLevel(PICKAXE, 10);
		CoreBlocks.starconiumGolemHead.setHarvestLevel(PICKAXE, 10);
		
		CoreBlocks.enderOre.setHarvestLevel(PICKAXE, 12);
		CoreBlocks.enderBlock.setHarvestLevel(PICKAXE, 12);
		CoreBlocks.enderGolemHead.setHarvestLevel(PICKAXE, 12);
		
		CoreBlocks.demoniteOre.setHarvestLevel(PICKAXE, 9);
		CoreBlocks.demoniteBlock.setHarvestLevel(PICKAXE, 9);
		CoreBlocks.demoniteFurnace.setHarvestLevel(PICKAXE, 9);
		CoreBlocks.demoniteFurnaceLit.setHarvestLevel(PICKAXE, 9);
		CoreBlocks.demoniteGolemHead.setHarvestLevel(PICKAXE, 9);
		
		CoreBlocks.luminiteOre.setHarvestLevel(PICKAXE, 6);
		CoreBlocks.luminiteDiscoBlock.setHarvestLevel(PICKAXE, 6);
		CoreBlocks.luminiteStorageBlock.setHarvestLevel(PICKAXE, 6);
		CoreBlocks.experiumOre.setHarvestLevel(PICKAXE, 6);
		CoreBlocks.experiumBlock.setHarvestLevel(PICKAXE, 6);
		
		CoreBlocks.darkstoneOre.setHarvestLevel(PICKAXE, 6);
		CoreBlocks.darkstoneBrick.setHarvestLevel(PICKAXE, 6);
		CoreBlocks.darkstoneBrickStairs.setHarvestLevel(PICKAXE, 6);
		CoreBlocks.diagonalDarkstoneBrick.setHarvestLevel(PICKAXE, 6);
		CoreBlocks.diagonalDarkstoneBrickStairs.setHarvestLevel(PICKAXE, 6);
	}
}

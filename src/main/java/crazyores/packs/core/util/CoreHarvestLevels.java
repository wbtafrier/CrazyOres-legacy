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
//	public static final ItemTool.ToolMaterial STONE_DRILL = 		EnumHelper.addToolMaterial("STONEDRILL",	 0, 2000, 20.0f, 2.0f, 10);
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
	public static final ItemTool.ToolMaterial TAPAZITE = 			EnumHelper.addToolMaterial("TAPAZITE", 		 9,  612,  5.0f, 3.0f, 10);
	public static final ItemTool.ToolMaterial OSMONIUM = 			EnumHelper.addToolMaterial("OSMONIUM", 		10, 2581, 10.0f, 4.0f,  7);
	
	public static final ItemTool.ToolMaterial STARCONIUM = 			EnumHelper.addToolMaterial("STARCONIUM", 	11, 3001, 16.0f, 8.0f,  6);
	public static final ItemTool.ToolMaterial STARCONIUM_HAMMER =	EnumHelper.addToolMaterial("STARHAMMER", 	12, 1066, 65.0f, 8.0f,  6);
	
	public static final ItemTool.ToolMaterial ENDER = 				EnumHelper.addToolMaterial("ENDER", 		13, 2239, 15.0f, 7.0f,  6);
	
	/** Armor Strength**/
	public static ItemArmor.ArmorMaterial COPPER_ARMOR = 			EnumHelper.addArmorMaterial("COPPER", 			14, new int[]	{1,  5,  3, 1}, 	14);
	public static ItemArmor.ArmorMaterial METEORITE_ARMOR = 		EnumHelper.addArmorMaterial("METEORITE", 		 5, new int[]	{1,  3,  2, 1}, 	20);//Immune to lava and fire
	public static ItemArmor.ArmorMaterial SAPPHIRE_ARMOR = 			EnumHelper.addArmorMaterial("SAPPHIRE", 		17, new int[]	{2,  6,  4, 2}, 	13);
	public static ItemArmor.ArmorMaterial INVISIUM_ARMOR = 			EnumHelper.addArmorMaterial("INVISIUM", 		10, new int[]	{1,  4,  3, 1}, 	10);//Gives the player the Invisium Effect
	public static ItemArmor.ArmorMaterial ADAMITE_ARMOR = 			EnumHelper.addArmorMaterial("ADAMITE", 			21, new int[]	{2,  5,  4, 2}, 	13);//Can stay underwater longer
	public static ItemArmor.ArmorMaterial RUBY_ARMOR = 				EnumHelper.addArmorMaterial("RUBY", 			25, new int[]	{3,  7,  5, 3}, 	12);
	public static ItemArmor.ArmorMaterial ZECTIUM_ARMOR = 			EnumHelper.addArmorMaterial("ZECTIUM", 			38, new int[]	{4,  9,  7, 4}, 	 9);
	public static ItemArmor.ArmorMaterial TAPAZITE_ARMOR = 			EnumHelper.addArmorMaterial("TAPAZITE", 		42, new int[]	{5, 10,  8, 5}, 	 8);//Is Blast resistant, but makes you walk slower
	public static ItemArmor.ArmorMaterial OSMONIUM_ARMOR = 			EnumHelper.addArmorMaterial("OSMONIUM", 		48, new int[]	{3,  6,  5, 3}, 	 7);//Makes you faster, but is not as protective
	public static ItemArmor.ArmorMaterial ENDER_ARMOR = 			EnumHelper.addArmorMaterial("ENDER", 			43, new int[]	{2,  4,  3, 2}, 	 6);//Is fall damage proof
	public static ItemArmor.ArmorMaterial STARCONIUM_ARMOR = 		EnumHelper.addArmorMaterial("STARCONIUM", 		53, new int[]	{8, 13, 11, 8}, 	 6);
	
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
		
		CoreBlocks.meteoriteOre.setHarvestLevel(PICKAXE, 2);
		CoreBlocks.meteoriteBlock.setHarvestLevel(PICKAXE, 2);
		
		CoreBlocks.adamiteOre.setHarvestLevel(PICKAXE, 3);
		CoreBlocks.adamiteBlock.setHarvestLevel(PICKAXE, 3);
		
		CoreBlocks.sapphireOre.setHarvestLevel(PICKAXE, 4);
		CoreBlocks.sapphireBlock.setHarvestLevel(PICKAXE, 4);
		
		CoreBlocks.rubyOre.setHarvestLevel(PICKAXE, 5);
		CoreBlocks.rubyBlock.setHarvestLevel(PICKAXE, 5);
		
		CoreBlocks.invisiumOre.setHarvestLevel(PICKAXE, 7);
		CoreBlocks.invisiumBlock.setHarvestLevel(PICKAXE, 7);
		
		CoreBlocks.zectiumOre.setHarvestLevel(PICKAXE, 7);
		CoreBlocks.zectiumBlock.setHarvestLevel(PICKAXE, 7);
		
		CoreBlocks.osmoniumOre.setHarvestLevel(PICKAXE, 9);
		CoreBlocks.osmoniumBlock.setHarvestLevel(PICKAXE, 9);
		
		CoreBlocks.starconiumOre.setHarvestLevel(PICKAXE, 10);
		CoreBlocks.starconiumBlock.setHarvestLevel(PICKAXE, 10);
		
		CoreBlocks.enderOre.setHarvestLevel(PICKAXE, 12);
		CoreBlocks.enderBlock.setHarvestLevel(PICKAXE, 12);
		
		CoreBlocks.demoniteOre.setHarvestLevel(PICKAXE, 9);
		CoreBlocks.demoniteBlock.setHarvestLevel(PICKAXE, 9);
		CoreBlocks.demoniteFurnace.setHarvestLevel(PICKAXE, 9);
		CoreBlocks.demoniteFurnaceLit.setHarvestLevel(PICKAXE, 9);
		
		CoreBlocks.luminiteOre.setHarvestLevel(PICKAXE, 6);
		CoreBlocks.darkstoneOre.setHarvestLevel(PICKAXE, 6);
	}
}

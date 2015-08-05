package crazyores.packs.core.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.manager.tabs.COTabList;

public class CoreBlocks {

	public static Block tapaziteLightSource;
	
	//Overworld Ores
	public static Block tapaziteStalagmite;
	public static Block tapaziteStalactite;
	
	public static Block copperOre;
	public static Block meteoriteOre;
	public static Block adamiteOre;
	public static Block sapphireOre;
	public static Block rubyOre;
	public static Block foolsRubyOre;
	public static Block zectiumOre;
	public static Block osmoniumOre;
	public static Block starconiumOre;
	public static Block experiumOre;
	
	//Nether Ores
	public static Block demoniteOre;
	public static Block invisiumOre;
	
	//Ender Ores
	//TODO: Add the Ender Ores.
	public static Block enderOre;
//	public static Block ultraOre;
	
	public static Block darkstoneOre;
	public static Block luminiteOre;
	
	//Overworld Blocks
	public static Block copperBlock;
	public static Block meteoriteBlock;
	public static Block adamiteBlock;
	public static Block sapphireBlock;
	public static Block rubyBlock;
	public static Block foolsRubyBlock;
	public static Block zectiumBlock;
	public static Block tapaziteBlock;
	public static Block osmoniumBlock;
	public static Block starconiumBlock;
	public static Block experiumBlock;
	
	//Nether Blocks
	public static Block demoniteBlock;
	public static Block invisiumBlock;
	
	//Ender Blocks
	//TODO: Add the Ender Blocks.
	public static Block enderBlock;
//	public static Block ultraBlock;
	
//	public static Block darkstoneBlock;
//	public static Block luminiteBlock;
	
	public static void initBlocks() {
		initOverworldBlocks();
	}
	
	public static void initOverworldBlocks() {
		tapaziteLightSource = new BlockLightSource("tapazite_light_source", Material.air, 0.75F, 1.2F, 3.0F); registerBlock(tapaziteLightSource);
		tapaziteStalagmite = new BlockTapaziteStalagmite("tapazite_stalagmite", Block.soundTypeGlass, 0.5F, 2.0F).setCreativeTab(COTabList.crazyOresBlocksTab); registerBlock(tapaziteStalagmite, ItemBlockTapaziteStalagmite.class);
		tapaziteStalactite = new BlockTapaziteStalactite("tapazite_stalactite", Block.soundTypeGlass, 0.5F, 2.0F).setCreativeTab(COTabList.crazyOresBlocksTab); registerBlock(tapaziteStalactite, ItemBlockTapaziteStalactite.class);
		
		copperOre = new BlockOre("copper_ore", Material.rock, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(copperOre);
		meteoriteOre = new BlockOre("meteorite_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f, 0.8f); registerBlock(meteoriteOre);
		adamiteOre = new BlockOre("adamite_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f, 0.7f); registerBlock(adamiteOre);
		sapphireOre = new BlockOre("sapphire_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(sapphireOre);
		rubyOre = new BlockOre("ruby_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(rubyOre);
		foolsRubyOre = new BlockOre("fools_ruby_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(foolsRubyOre);
		zectiumOre = new BlockOre("zectium_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(zectiumOre);
		osmoniumOre = new BlockOre("osmonium_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(osmoniumOre);
		starconiumOre = new BlockOre("starconium_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(starconiumOre);
		experiumOre = new BlockOre("experium_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(experiumOre);
		
		demoniteOre = new BlockOre("demonite_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(demoniteOre);
		invisiumOre = new BlockOre("invisium_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(invisiumOre);
		
		//Should be in the decorations pack
		darkstoneOre = new BlockOre("darkstone_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(darkstoneOre);
		luminiteOre = new BlockOre("luminite_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(luminiteOre);
		
		enderOre = new BlockOre("ender_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(enderOre);
		
		
		//Storage Blocks
		copperBlock = new CoreBlock("copper_block", Material.rock, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(copperBlock);
		meteoriteBlock = new CoreBlock("meteorite_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f, 0.8f); registerBlock(meteoriteBlock);
		adamiteBlock = new CoreBlock("adamite_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f, 0.7f); registerBlock(adamiteBlock);
		sapphireBlock = new CoreBlock("sapphire_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(sapphireBlock);
		rubyBlock = new CoreBlock("ruby_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(rubyBlock);
		foolsRubyBlock = new CoreBlock("fools_ruby_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(foolsRubyBlock);
		zectiumBlock = new CoreBlock("zectium_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(zectiumBlock);
		tapaziteBlock = new CoreBlock("tapazite_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(tapaziteBlock);
		osmoniumBlock = new CoreBlock("osmonium_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(osmoniumBlock);
		starconiumBlock = new CoreBlock("starconium_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(starconiumBlock);
		experiumBlock = new CoreBlock("experium_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(experiumBlock);
		
		demoniteBlock = new CoreBlock("demonite_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(demoniteBlock);
		invisiumBlock = new CoreBlock("invisium_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(invisiumBlock);
		
		//Should be in the decorations pack
//		darkstoneBlock = new CoreBlock("darkstone_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(darkstoneBlock);
//		luminiteBlock = new CoreBlock("luminite_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(luminiteBlock);
		
		enderBlock = new CoreBlock("ender_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(enderBlock);
	}
	
	/**
	 * Registers all core blocks with forge.
	 */
	private static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}
	
	/**
	 * Registers all core metadata blocks with forge.
	 */
	private static void registerBlock(Block block, Class itemBlockClass) {
		GameRegistry.registerBlock(block, itemBlockClass, block.getUnlocalizedName());
	}
}

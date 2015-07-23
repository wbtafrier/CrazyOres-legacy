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
	
	public static Block meteoriteOre;
	public static Block copperOre;
	public static Block sapphireOre;
	public static Block adamiteOre;
	public static Block rubyOre;
	public static Block foolsRubyOre;
	public static Block zectiumOre;
	public static Block osmoniumOre;
	public static Block starconiumOre;
	public static Block experiumOre;
	
	//Nether Ores
	public static Block demoniteOre;
	public static Block invisiumOre;
	
	public static Block darkstoneOre;
	public static Block luminiteOre;
	
	public static void initBlocks() {
		initOverworldBlocks();
	}
	
	public static void initOverworldBlocks() {
		tapaziteLightSource = new BlockLightSource("tapazite_light_source", Material.air, 0.75F, 1.2F, 3.0F); registerBlock(tapaziteLightSource);
		tapaziteStalagmite = new BlockTapaziteStalagmite("tapazite_stalagmite", Block.soundTypeGlass, 0.5F, 2.0F).setCreativeTab(COTabList.crazyOresBlocksTab); registerBlock(tapaziteStalagmite, ItemBlockTapaziteStalagmite.class);
		tapaziteStalactite = new BlockTapaziteStalactite("tapazite_stalactite", Block.soundTypeGlass, 0.5F, 2.0F).setCreativeTab(COTabList.crazyOresBlocksTab); registerBlock(tapaziteStalactite, ItemBlockTapaziteStalactite.class);
		
		meteoriteOre = new BlockOre("meteorite_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(meteoriteOre);
		copperOre = new BlockOre("copper_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(copperOre);
		sapphireOre = new BlockOre("sapphire_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(sapphireOre);
		adamiteOre = new BlockOre("adamite_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(adamiteOre);
		rubyOre = new BlockOre("ruby_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(rubyOre);
		foolsRubyOre = new BlockOre("fools_ruby_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(foolsRubyOre);
		zectiumOre = new BlockOre("zectium_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(zectiumOre);
		osmoniumOre = new BlockOre("osmonium_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(osmoniumOre);
		starconiumOre = new BlockOre("starconium_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(starconiumOre);
		experiumOre = new BlockOre("experium_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(experiumOre);
		
		demoniteOre = new BlockOre("demonite_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(demoniteOre);
		invisiumOre = new BlockOre("invisium_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(invisiumOre);
		
		//Should be in the decorations pack
		darkstoneOre = new BlockOre("darkstone", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(darkstoneOre);
		luminiteOre = new BlockOre("luminite_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(luminiteOre);
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

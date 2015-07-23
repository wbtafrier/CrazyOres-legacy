package crazyores.packs.core.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.manager.tabs.COTabList;

public class CoreBlocks {

	public static Block tapaziteLightSource;
	
	public static Block tapaziteStalagmite;
	public static Block tapaziteStalactite;
	
	public static Block meteoriteOre;
	public static Block copperOre;
	public static Block sapphireOre;
	public static Block adamiteOre;
	public static Block rubyOre;
	public static Block zectiumOre;
	public static Block osmoniumOre;
	public static Block starconiumOre;
	
	public static void initBlocks() {
		initOverworldBlocks();
	}
	
	public static void initOverworldBlocks() {
		tapaziteLightSource = new BlockLightSource("tapazite_light_source", Material.air, 0.75F, 1.2F, 3.0F); registerBlock(tapaziteLightSource);
		tapaziteStalagmite = new BlockTapaziteStalagmite("tapazite_stalagmite", Block.soundTypeGlass, 0.5F, 2.0F).setCreativeTab(COTabList.crazyOresBlocksTab); registerBlock(tapaziteStalagmite, ItemBlockTapaziteStalagmite.class);
		tapaziteStalactite = new BlockTapaziteStalactite("tapazite_stalactite", Block.soundTypeGlass, 0.5F, 2.0F).setCreativeTab(COTabList.crazyOresItemsTab); registerBlock(tapaziteStalactite, ItemBlockTapaziteStalactite.class);
		
//		String unlocalizedName, Material blockMaterial, CreativeTabs tab, SoundType soundType, float hardness, float resistance
		
		meteoriteOre = new BlockOre("meteorite_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(meteoriteOre);
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

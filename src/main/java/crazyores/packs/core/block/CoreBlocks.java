package crazyores.packs.core.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.manager.tabs.COTabList;
import crazyores.manager.util.CrazyOresLogger;
import crazyores.packs.core.tabs.CoreTabs;

public class CoreBlocks {

	public static Block lightSource;
	
	public static Block tapaziteStalagmite;
	public static Block tapaziteStalactite;
	
	public static void initBlocks() {
		initOverworldBlocks();
		initDreamStateBlocks();
	}
	
	public static void initOverworldBlocks() {
		tapaziteStalagmite = new BlockTapaziteStalagmite("Tapazite Crystal", "tapazite_stalagmite", Block.soundTypeGlass, 0.5F, 2.0F).setCreativeTab(COTabList.defaultBlocksTab); registerBlock(tapaziteStalagmite, ItemBlockTapaziteStalagmite.class);
		tapaziteStalactite = new BlockTapaziteStalactite("Tapazite Crystal", "tapazite_stalactite", Block.soundTypeGlass, 0.5F, 2.0F).setCreativeTab(COTabList.defaultBlocksTab); registerBlock(tapaziteStalactite, ItemBlockTapaziteStalactite.class);
	}
	
	private static void initDreamStateBlocks() {
		
		//Steep Hills
		lightSource = new BlockLightSource("Light Source", "light_source", Material.air, 1.2F, 3.0F); registerBlock(lightSource);
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

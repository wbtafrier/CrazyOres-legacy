package crazyores.packs.core.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.manager.tabs.COTabList;
import crazyores.manager.util.CrazyOresLogger;
import crazyores.packs.core.tabs.CoreTabs;

public class CoreBlocks {

	//DreamState Blocks
	public static Block foolsRubyStorage;
	public static Block tapaziteCrystal;
	
	public static void initBlocks() {
		initOverworldBlocks();
		initDreamStateBlocks();
	}
	
	public static void initOverworldBlocks() {
		tapaziteCrystal = new BlockTapaziteCrystal("Tapazite Crystal", "tapazite_crystal", Material.glass, Block.soundTypeGlass, 4.0F, 2.0F).setCreativeTab(COTabList.defaultBlocksTab); registerBlock(tapaziteCrystal);
	}
	
	private static void initDreamStateBlocks() {
		
		//Steep Hills
		foolsRubyStorage = new CoreBlock("Fool's Ruby Storage Block", "fools_ruby_storage_block", Material.iron, COTabList.dreamStateTerrainTab, Block.soundTypeStone, 1.2F, 3.0F); registerBlock(foolsRubyStorage);
	}
	
	/**
	 * Registers all core blocks with forge.
	 */
	private static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}
}

package crazyores_core.common.block;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import crazyores_core.common.core.COData;

/**
 * BlockList initializes and registers all of the blocks in the CrazyOres Core.
 * @author Andy608 and ISQUISHALL
 */
@GameRegistry.ObjectHolder(COData.MOD_ID)
public class BlockList {
	
	public static ArrayList<Block> block_list = new ArrayList<>();
	
	public static final Block fools_ruby_ore = new Ore().setHardness(3F).setResistance(5F);
	public static final Block meteorite_ore = new Ore().setHardness(3F).setResistance(5F);
	public static final Block copper_ore = new Ore().setHardness(3F).setResistance(5F);
	public static final Block experium_ore = new Ore().setHardness(3F).setResistance(5F);
	public static final Block sapphire_ore = new Ore().setHardness(3F).setResistance(5F);
	public static final Block adamite_ore = new Ore().setHardness(3F).setResistance(5F);
	public static final Block invisium_ore = new Ore().setHardness(3F).setResistance(5F);
	public static final Block ruby_ore = new Ore().setHardness(3F).setResistance(5F);
	public static final Block darkstone = new Ore().setHardness(3F).setResistance(5F);
	public static final Block zectium_ore = new Ore().setHardness(3F).setResistance(5F);
	public static final Block tapazite_ore = new Ore().setHardness(3F).setResistance(5F);
	public static final Block demonite_ore = new Ore().setHardness(3F).setResistance(5F);
	public static final Block osmonium_ore = new Ore().setHardness(3F).setResistance(5F);
	public static final Block starconium_ore = new Ore().setHardness(3F).setResistance(5F);
	public static final Block ender_ore = new Ore().setHardness(3F).setResistance(5F);
	public static final Block ultra_ore = new Ore().setHardness(3F).setResistance(5F);

	public static final Block fools_ruby_storage_block = new COBlock().setHardness(3F).setResistance(9F);
	public static final Block meteorite_storage_block = new COBlock().setHardness(3F).setResistance(9F);
	public static final Block copper_storage_block = new COBlock().setHardness(3F).setResistance(9F);
	public static final Block experium_storage_block = new COBlock().setHardness(3F).setResistance(9F);
	public static final Block sapphire_storage_block = new COBlock().setHardness(3F).setResistance(9F);
	public static final Block adamite_storage_block = new COBlock().setHardness(3F).setResistance(9F);
	public static final Block invisium_storage_block = new COBlock().setHardness(3F).setResistance(9F);
	public static final Block ruby_storage_block = new COBlock().setHardness(3F).setResistance(9F);
	public static final Block darkstone_storage_block = new COBlock().setHardness(3F).setResistance(9F);
	public static final Block zectium_storage_block = new COBlock().setHardness(3F).setResistance(9F);
	
	public static final Block tapazite_storage_block = new COBlock().setHardness(3F).setResistance(9F);
	public static final Block demonite_storage_block = new COBlock().setHardness(3F).setResistance(9F);
	public static final Block osmonium_storage_block = new COBlock().setHardness(3F).setResistance(9F);
	public static final Block starconium_storage_block = new COBlock().setHardness(3F).setResistance(9F);
	public static final Block ender_storage_block = new COBlock().setHardness(3F).setResistance(9F);
	public static final Block ultra_storage_block = new COBlock().setHardness(3F).setResistance(9F);
	
	/**
	 * Initialization of all CO Core Blocks.
	 */
	public static void blockInitialization() {
		
		registerAndNameBlock(fools_ruby_ore, BlockNames.FOOLS_RUBY_ORE);
		registerAndNameBlock(meteorite_ore, BlockNames.METEORITE_ORE);
		registerAndNameBlock(copper_ore, BlockNames.COPPER_ORE);
		registerAndNameBlock(experium_ore, BlockNames.EXPERIUM_ORE);
		registerAndNameBlock(sapphire_ore, BlockNames.SAPPHIRE_ORE);
		registerAndNameBlock(adamite_ore, BlockNames.ADAMITE_ORE);
		registerAndNameBlock(invisium_ore, BlockNames.INVISIUM_ORE);
		registerAndNameBlock(ruby_ore, BlockNames.RUBY_ORE);
		registerAndNameBlock(darkstone, BlockNames.DARKSTONE);
		registerAndNameBlock(zectium_ore, BlockNames.ZECTIUM_ORE);
		registerAndNameBlock(tapazite_ore, BlockNames.TAPAZITE_ORE);
		registerAndNameBlock(demonite_ore, BlockNames.DEMONITE_ORE);
		registerAndNameBlock(osmonium_ore, BlockNames.OSMONIUM_ORE);
		registerAndNameBlock(starconium_ore, BlockNames.STARCONIUM_ORE);
		registerAndNameBlock(ender_ore, BlockNames.ENDER_ORE);
		registerAndNameBlock(ultra_ore, BlockNames.ULTRA_ORE);
		
		registerAndNameBlock(fools_ruby_storage_block, BlockNames.FOOLS_RUBY_STORAGE_BLOCK);
		registerAndNameBlock(meteorite_storage_block, BlockNames.METEORITE_STORAGE_BLOCK);
		registerAndNameBlock(copper_storage_block, BlockNames.COPPER_STORAGE_BLOCK);
		registerAndNameBlock(experium_storage_block, BlockNames.EXPERIUM_STORAGE_BLOCK);
		registerAndNameBlock(sapphire_storage_block, BlockNames.SAPPHIRE_STORAGE_BLOCK);
		registerAndNameBlock(adamite_storage_block, BlockNames.ADAMITE_STORAGE_BLOCK);
		registerAndNameBlock(invisium_storage_block, BlockNames.INVISIUM_STORAGE_BLOCK);
		registerAndNameBlock(ruby_storage_block, BlockNames.RUBY_STORAGE_BLOCK);
		registerAndNameBlock(darkstone_storage_block, BlockNames.DARKSTONE_STORAGE_BLOCK);
		registerAndNameBlock(zectium_storage_block, BlockNames.ZECTIUM_STORAGE_BLOCK);
		registerAndNameBlock(tapazite_storage_block, BlockNames.TAPAZITE_STORAGE_BLOCK);
		registerAndNameBlock(demonite_storage_block, BlockNames.DEMONITE_STORAGE_BLOCK);
		registerAndNameBlock(osmonium_storage_block, BlockNames.OSMONIUM_STORAGE_BLOCK);
		registerAndNameBlock(starconium_storage_block, BlockNames.STARCONIUM_STORAGE_BLOCK);
		registerAndNameBlock(ender_storage_block, BlockNames.ENDER_STORAGE_BLOCK);
		registerAndNameBlock(ultra_storage_block, BlockNames.ULTRA_STORAGE_BLOCK);

	}
	
	/**
	 * Registers and sets the unlocalized name of a CO Block.
	 * @param block: The Block to be registered and named.
	 * @param blockName: The name of the Block as a String.
	 */
	public static void registerAndNameBlock(Block block, String blockName) {
		block.setUnlocalizedName(blockName);
		GameRegistry.registerBlock(block, blockName);
		block_list.add(block);
	}
}
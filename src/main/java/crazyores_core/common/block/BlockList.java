package crazyores_core.common.block;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores_core.common.core.COData;
import crazyores_core.common.tab.COTabList;

/**
 * BlockList initializes and registers all of the blocks in the CrazyOres Core.
 * @author Andy608 and ISQUISHALL
 */
@GameRegistry.ObjectHolder(COData.MOD_ID)
public class BlockList {
	
	public static final Block fools_ruby_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone);
	public static final Block meteorite_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone);
	public static final Block copper_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone);
	public static final Block sapphire_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone);
	public static final Block adamite_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone);
	public static final Block ruby_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone);
	public static final Block zectium_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone);
	public static final Block tapazite_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone);
	public static final Block crystal_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone);
	public static final Block osmonium_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone);
	public static final Block starconium_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone);
	public static final Block experium_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone);
	public static final Block demonite_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone);
	public static final Block invisium_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone);
	public static final Block ender_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone);
	public static final Block ultra_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone);
	public static final Block luminite_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone);
	public static final Block darkstone = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone);

	/**
	 * Initialization of all CO Core Blocks.
	 */
	public static void blockInitialization() {
		registerAndNameBlock(fools_ruby_ore, BlockNames.FOOLS_RUBY_ORE);
		registerAndNameBlock(meteorite_ore, BlockNames.METEORITE_ORE);
		registerAndNameBlock(copper_ore, BlockNames.COPPER_ORE);
		registerAndNameBlock(sapphire_ore, BlockNames.SAPPHIRE_ORE);
		registerAndNameBlock(adamite_ore, BlockNames.ADAMITE_ORE);
		registerAndNameBlock(ruby_ore, BlockNames.RUBY_ORE);
		registerAndNameBlock(zectium_ore, BlockNames.ZECTIUM_ORE);
		registerAndNameBlock(tapazite_ore, BlockNames.TAPAZITE_ORE);
		registerAndNameBlock(crystal_ore, BlockNames.CRYSTAL_ORE);
		registerAndNameBlock(osmonium_ore, BlockNames.OSMONIUM_ORE);
		registerAndNameBlock(starconium_ore, BlockNames.STARCONIUM_ORE);
		registerAndNameBlock(experium_ore, BlockNames.EXPERIUM_ORE);
		registerAndNameBlock(demonite_ore, BlockNames.DEMONITE_ORE);
		registerAndNameBlock(invisium_ore, BlockNames.INVISIUM_ORE);
		registerAndNameBlock(ender_ore, BlockNames.ENDER_ORE);
		registerAndNameBlock(ultra_ore, BlockNames.ULTRA_ORE);
		registerAndNameBlock(luminite_ore, BlockNames.LUMINITE_ORE);
		registerAndNameBlock(darkstone, BlockNames.DARKSTONE);
	}
	
	/**
	 * Registers and sets the unlocalized name of a CO Block.
	 * @param block The Block to be registered and named. 
	 * @param blockName The name of the Block as a String.
	 */
	public static void registerAndNameBlock(Block block, String blockName) {
		block.setBlockName(blockName);
		GameRegistry.registerBlock(block, blockName);
	}
}
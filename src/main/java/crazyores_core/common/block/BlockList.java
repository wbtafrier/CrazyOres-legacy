package crazyores_core.common.block;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores_core.common.core.COData;
import crazyores_core.common.tab.COTabList;

/**
 * BlockList initializes and registers all of the blocks in the CrazyOres Core.
 * @author Andy608 and ISQUISHALL
 */
@GameRegistry.ObjectHolder(COData.MOD_ID)
public class BlockList {
	
	public static final Block foolsRubyOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(BlockNames.FOOLS_RUBY_ORE);
	public static final Block meteoriteOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(BlockNames.METEORITE_ORE);
	public static final Block copperOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(BlockNames.COPPER_ORE);
	public static final Block sapphireOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(BlockNames.SAPPHIRE_ORE);
	public static final Block adamiteOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(BlockNames.ADAMITE_ORE);
	public static final Block rubyOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(BlockNames.RUBY_ORE);
	public static final Block zectiumOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(BlockNames.ZECTIUM_ORE);
	public static final Block tapaziteOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(BlockNames.TAPAZITE_ORE);
	public static final Block crystalOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(BlockNames.CRYSTAL_ORE);
	public static final Block osmoniumOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(BlockNames.OSMONIUM_ORE);
	public static final Block starconiumOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(BlockNames.STARCONIUM_ORE);
	public static final Block experiumOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(BlockNames.EXPERIUM_ORE);
	public static final Block demoniteOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(BlockNames.DEMONITE_ORE);
	public static final Block invisiumOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(BlockNames.INVISIUM_ORE);
	public static final Block enderOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(BlockNames.ENDER_ORE);
	public static final Block ultraOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(BlockNames.ULTRA_ORE);
	public static final Block luminiteOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(BlockNames.LUMINITE_ORE);
	public static final Block darkstoneOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(BlockNames.DARKSTONE);

	public static void blockInitialization() {
		GameRegistry.registerBlock(foolsRubyOre, BlockNames.FOOLS_RUBY_ORE);
		GameRegistry.registerBlock(meteoriteOre, BlockNames.METEORITE_ORE);
		GameRegistry.registerBlock(copperOre, BlockNames.COPPER_ORE);
		GameRegistry.registerBlock(sapphireOre, BlockNames.SAPPHIRE_ORE);
		GameRegistry.registerBlock(adamiteOre, BlockNames.ADAMITE_ORE);
		GameRegistry.registerBlock(rubyOre, BlockNames.RUBY_ORE);
		GameRegistry.registerBlock(zectiumOre, BlockNames.ZECTIUM_ORE);
		GameRegistry.registerBlock(tapaziteOre, BlockNames.TAPAZITE_ORE);
		GameRegistry.registerBlock(crystalOre, BlockNames.CRYSTAL_ORE);
		GameRegistry.registerBlock(osmoniumOre, BlockNames.OSMONIUM_ORE);
		GameRegistry.registerBlock(starconiumOre, BlockNames.STARCONIUM_ORE);
		GameRegistry.registerBlock(experiumOre, BlockNames.EXPERIUM_ORE);
		GameRegistry.registerBlock(demoniteOre, BlockNames.DEMONITE_ORE);
		GameRegistry.registerBlock(invisiumOre, BlockNames.INVISIUM_ORE);
		GameRegistry.registerBlock(enderOre, BlockNames.ENDER_ORE);
		GameRegistry.registerBlock(ultraOre, BlockNames.ULTRA_ORE);
		GameRegistry.registerBlock(luminiteOre, BlockNames.LUMINITE_ORE);
		GameRegistry.registerBlock(darkstoneOre, BlockNames.DARKSTONE);
	}
}
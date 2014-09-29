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
	
	//Short hand
	private static BlockNames bn;
	private static GameRegistry gr;

	public static final Block foolsRubyOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.FOOLS_RUBY_ORE);
	public static final Block meteoriteOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.METEORITE_ORE);
	public static final Block copperOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.COPPER_ORE);
	public static final Block sapphireOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.SAPPHIRE_ORE);
	public static final Block adamiteOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.ADAMITE_ORE);
	public static final Block rubyOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.RUBY_ORE);
	public static final Block zectiumOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.ZECTIUM_ORE);
	public static final Block tapaziteOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.TAPAZITE_ORE);
	public static final Block crystalOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.CRYSTAL_ORE);
	public static final Block osmoniumOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.OSMONIUM_ORE);
	public static final Block starconiumOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.STARCONIUM_ORE);
	public static final Block experiumOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.EXPERIUM_ORE);
	public static final Block demoniteOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.DEMONITE_ORE);
	public static final Block invisiumOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.INVISIUM_ORE);
	public static final Block enderOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.ENDER_ORE);
	public static final Block ultraOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.ULTRA_ORE);
	public static final Block luminiteOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.LUMINITE_ORE);
	public static final Block darkstoneOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.DARKSTONE);

	public static void blockInitialization() {
		gr.registerBlock(foolsRubyOre, bn.FOOLS_RUBY_ORE);
		gr.registerBlock(meteoriteOre, bn.METEORITE_ORE);
		gr.registerBlock(copperOre, bn.COPPER_ORE);
		gr.registerBlock(sapphireOre, bn.SAPPHIRE_ORE);
		gr.registerBlock(adamiteOre, bn.ADAMITE_ORE);
		gr.registerBlock(rubyOre, bn.RUBY_ORE);
		gr.registerBlock(zectiumOre, bn.ZECTIUM_ORE);
		gr.registerBlock(tapaziteOre, bn.TAPAZITE_ORE);
		gr.registerBlock(crystalOre, bn.CRYSTAL_ORE);
		gr.registerBlock(osmoniumOre, bn.OSMONIUM_ORE);
		gr.registerBlock(starconiumOre, bn.STARCONIUM_ORE);
		gr.registerBlock(experiumOre, bn.EXPERIUM_ORE);
		gr.registerBlock(demoniteOre, bn.DEMONITE_ORE);
		gr.registerBlock(invisiumOre, bn.INVISIUM_ORE);
		gr.registerBlock(enderOre, bn.ENDER_ORE);
		gr.registerBlock(ultraOre, bn.ULTRA_ORE);
		gr.registerBlock(luminiteOre, bn.LUMINITE_ORE);
		gr.registerBlock(darkstoneOre, bn.DARKSTONE);
	}
}
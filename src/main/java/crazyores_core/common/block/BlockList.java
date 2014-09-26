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

	public static final Block copperOre = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockName(bn.COPPER_ORE);
	
	public static void blockInitialization() {
		GameRegistry.registerBlock(copperOre, bn.COPPER_ORE);
	}
}
package crazyores.packs.core.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.manager.tabs.COTabList;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;


public class CoreGlass extends CoreBlock {

	private boolean isAlpha;
	
	protected CoreGlass(String unlocalizedName, boolean alpha, float hardness, float resistance) {
		super(unlocalizedName, Material.glass, hardness, resistance);
		this.setStepSound(Block.soundTypeGlass);
		this.setCreativeTab(COTabList.crazyOresBlocksTab);
		isAlpha = alpha;
	}
	
	@Override
	public int quantityDropped(Random rand) {
        return 0;
    }

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
	@Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return isAlpha ? 1 : 0;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
	@Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    /**
     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
     */
	@Override
    protected boolean canSilkHarvest() {
        return true;
    }
	
	@Override
	public boolean isOpaqueCube() {
        return false;
    }
	
	/**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
	@Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
        Block block = world.getBlock(x, y, z);

        if (this == Blocks.glass || this == CoreBlocks.reinforcedGlass || this == CoreBlocks.smoothReinforcedGlass || this == CoreBlocks.luminiteStorageBlock) {
            if (world.getBlockMetadata(x, y, z) != world.getBlockMetadata(x - Facing.offsetsXForSide[side], y - Facing.offsetsYForSide[side], z - Facing.offsetsZForSide[side])) {
                return true;
            }

            if (block == CoreBlocks.reinforcedGlass || block == CoreBlocks.smoothReinforcedGlass) {
                return false;
            }
        }
        return block == this ? false : super.shouldSideBeRendered(world, x, y, z, side);
    }
}

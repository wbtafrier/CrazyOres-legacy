package crazyores_core.common.block;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import crazyores_core.common.core.COLogger;
import crazyores_core.common.tab.COTabList;
import crazyores_core.util.TextureManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

/**
 * COBlock is the big daddy for all of the blocks in the Core.
 * @author Andy608 and ISQUISHALL
 */
public class LuminiteBlock extends COBlock {
	
	/**
	 * Private variables.
	 */
	@SideOnly(Side.CLIENT)
	private IIcon[] blockTexture;
	
	/**
	 * Constructor: Default Constructor
	 */
	public LuminiteBlock() {
		super(Material.glass);
		this.setStepSound(Block.soundTypeGlass);
	}
	
	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}
	
	/**
	 * Adds the luminite blocks to the game.
	 */
	@Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
		for (int metadata = 0; metadata < BlockNames.LUMINITE_BLOCKS.length; metadata++) {
			list.add(new ItemStack(item, 1, metadata));
		}
	}

	/**
	 * Sets the image name for the block.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
		this.blockTexture = new IIcon[BlockNames.LUMINITE_BLOCKS.length];
		
		for (int i = 0; i < BlockNames.LUMINITE_BLOCKS.length; i++) {
			this.blockTexture[i] = iconRegister.registerIcon(String.format("%s_%s", stripName(this.getUnlocalizedName()), BlockNames.LUMINITE_BLOCKS[i]));
		}
	}
	
	/**
	 * Sets the icon to the appropriate luminite block.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		//clamp_int sends in metadata amount, lowest limit, highest limit, and returns the highest limit if metadata goes over it.
		metadata = MathHelper.clamp_int(metadata, 0, BlockNames.LUMINITE_BLOCKS.length - 1);
		return this.blockTexture[metadata];
	}
	
	
	
	 /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }
    
    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube() {
        return false;
    }
    
    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock() {
        return false;
    }
	
	/**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
    {
        Block block = blockAccess.getBlock(x, y, z);

        if (this == Blocks.glass || this == BlockList.luminite_storage_blocks)
        {
            if (blockAccess.getBlockMetadata(x, y, z) != blockAccess.getBlockMetadata(x - Facing.offsetsXForSide[side], y - Facing.offsetsYForSide[side], z - Facing.offsetsZForSide[side]))
            {
                return true;
            }

            if (block == this)
            {
                return false;
            }
        }
        //LOOK OVER THIS RETURN STATEMENT. I REPLACED A PARAMETER FROM BlockBreakable WITH THE PARAM TRUE. IT WORKS BUT I'M NOT SURE IF IT WILL ALWAYS WORK.
        return true && block == this ? false : super.shouldSideBeRendered(blockAccess, x, y, z, side);
    }
}

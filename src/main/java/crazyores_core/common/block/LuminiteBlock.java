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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

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
}

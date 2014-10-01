package crazyores_core.common.block;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import crazyores_core.common.tab.COTabList;
import crazyores_core.util.TextureManager;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Ore has the properties for all of the ore blocks in the CO Core.
 * @author Andy608 and ISQUISHALL
 */
public class Ore extends BlockOre {
	/**
	 * Default constructor.
	 */
	public Ore() {
		super();
		this.setStepSound(Block.soundTypeStone);
		this.setCreativeTab(COTabList.CO_BLOCKS);
	}
    
	/**
	 * Item drop method for all of the Ores.
	 * @return The specific item that should drop for the ore.
	 */
	public Item getItemDropped(int metaData, Random rand, int fortuneLevel) {
		return this.isAssociatedBlock(BlockList.copper_ore) ? Item.getItemFromBlock(this) : Item.getItemFromBlock(this);
	}

	/**
	 * @return the name of the block for the language file and textures.
	 */
	@Override
	public String getUnlocalizedName() {
		return String.format("tile.%s%s", TextureManager.RESOURCE_PREFIX, this.stripName(super.getUnlocalizedName()));
	}
	
	/**
	 * Sets the image name for the block.
	 */
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(String.format("%s", this.stripName(this.getUnlocalizedName())));
	}
	
	/**
	 * Takes in a string (unlocalizedName()).
	 * @return the name of the block without the 'tile.'
	 */
	public String stripName(String name) {
		return name.substring(name.indexOf(".") + 1);
	}
}
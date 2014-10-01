package crazyores_core.common.block;
import crazyores_core.common.tab.COTabList;
import crazyores_core.util.TextureManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * COBlock is the big daddy for all of the blocks in the Core.
 * @author Andy608 and ISQUISHALL
 */
public class COBlock extends Block {
	
	/**
	 * Constructor: Default Constructor
	 */
	public COBlock() {
		this(Material.rock);
	}
	/**
	 * Constructor: Takes in a material.
	 * Sets the material for the block and sets the creative tab to DecorationBlock.
	 */
	public COBlock(Material m) {
		super(m);
		this.setStepSound(Block.soundTypeMetal);
		this.setCreativeTab(COTabList.CO_BLOCKS);
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
		this.blockIcon = iconRegister.registerIcon(String.format("%s", stripName(this.getUnlocalizedName())));
	}
	
	/**
	 * Takes in a string (unlocalizedName()).
	 * @return the name of the block without the 'tile.'
	 */
	public String stripName(String name) {
		return name.substring(name.indexOf(".") + 1);
	}
}
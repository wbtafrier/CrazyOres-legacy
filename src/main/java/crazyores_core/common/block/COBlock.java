package crazyores_core.common.block;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import crazyores_core.common.tab.COTabList;
import crazyores_core.util.TextureManager;

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
		return String.format("tile.%s%s", TextureManager.RESOURCE_PREFIX, this.parsePrefix(super.getUnlocalizedName(), '.'));
	}
	
	public String parsePrefix(String unlocalizedName, char lastPrefixChar) {
		return unlocalizedName.substring(unlocalizedName.indexOf(lastPrefixChar) + 1);
	}
	
	public String getReadableName() {
		return this.parsePrefix(this.getUnlocalizedName(), ':');
	}
}
package crazyores_core.common.block;
import org.apache.logging.log4j.Level;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import crazyores_core.common.core.COLogger;
import crazyores_core.common.tab.COTabList;
import crazyores_core.util.ICOName;
import crazyores_core.util.TextureManager;

/**
 * COBlock is the big daddy for all of the blocks in the Core.
 * @author Andy608 and ISQUISHALL
 */
public class COBlock extends Block implements ICOName {
	
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
	
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        return this.blockIcon;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(String.format("%s%s", TextureManager.RESOURCE_PREFIX, this.parsePrefix(this.getReadableName(), '.')));
    }
	
	@Override
	public String parsePrefix(String unlocalizedName, char lastPrefixChar) {
		return unlocalizedName.substring(unlocalizedName.indexOf(lastPrefixChar) + 1);
	}
	
	@Override
	public String getReadableName() {
		return this.parsePrefix(super.getUnlocalizedName(), ':');
	}
}
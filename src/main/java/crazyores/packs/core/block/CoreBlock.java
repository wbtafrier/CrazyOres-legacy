package crazyores.packs.core.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.support.IBlock;
import crazyores.manager.support.IName;

public class CoreBlock extends Block implements IBlock, IName {

	public final String blockName;
	public final String blockUnlocalizedName;
	
	/**
	 * Constructor for the CoreBlock class.
	 * @param blockReadableName
	 * @param blockUnlocalizedName
	 * @param blockMaterial
	 * @param soundType
	 * @param hardness
	 * @param resistance
	 */
	protected CoreBlock(String blockReadableName, String unlocalizedName, Material blockMaterial, Block.SoundType soundType, float hardness, float resistance) {
		super(blockMaterial);
		
		this.blockName = blockReadableName;
		this.blockUnlocalizedName = unlocalizedName;
		super.setBlockName(blockName);
        super.setStepSound(soundType);
        super.setHardness(hardness);
        super.setResistance(resistance);
	}
	
	
	/**
	 * Constructor for the CoreBlock class.
	 * @param blockReadableName
	 * @param blockUnlocalizedName
	 * @param blockMaterial
	 * @param tab
	 * @param soundType
	 * @param hardness
	 * @param resistance
	 */
	protected CoreBlock(String blockReadableName, String unlocalizedName, Material blockMaterial, CreativeTabs tab, Block.SoundType soundType, float hardness, float resistance) {
		this(blockReadableName, unlocalizedName, blockMaterial, soundType, hardness, resistance);
		super.setCreativeTab(tab);
	}
	
	@Override
	public String getUnlocalizedName() {
		return blockUnlocalizedName;
	}
	
	@Override
	public String parsePrefix(String unlocalizedName, char lastPrefixChar) {
		return unlocalizedName.substring(unlocalizedName.indexOf(lastPrefixChar) + 1);
	}

	@Override
	public String getReadableName() {
		return blockName;
	}

	@Override
	public int getBlockMetadata() {
		return 0;
	}

	@Override
	public Material getBlockMaterial() {
		return super.getMaterial();
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(String.format("%s%s%s", COPackManager.corePack.getPackID(), ":", this.getUnlocalizedName()));
	}

	@Override
	public IIcon getIcon(int side, int metadata) {
		return this.blockIcon;
	}
}

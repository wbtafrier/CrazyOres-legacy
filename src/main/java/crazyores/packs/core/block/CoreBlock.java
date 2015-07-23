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

	public final String blockUnlocalizedName;
	
	/**
	 * Constructor for the CoreBlock class.
	 * @param blockUnlocalizedName
	 * @param blockMaterial
	 * @param soundType
	 * @param hardness
	 * @param resistance
	 */
	protected CoreBlock(String unlocalizedName, Material blockMaterial, float hardness, float resistance) {
		super(blockMaterial);
		
		this.blockUnlocalizedName = unlocalizedName;
        super.setHardness(hardness);
        super.setResistance(resistance);
	}
	
	/**
	 * Constructor for the CoreBlock class.
	 * @param blockReadableName
	 * @param blockUnlocalizedName
	 * @param blockMaterial
	 * @param soundType
	 * @param hardness
	 * @param resistance
	 */
	protected CoreBlock(String unlocalizedName, Material blockMaterial, Block.SoundType soundType, float hardness, float resistance) {
		this(unlocalizedName, blockMaterial, hardness, resistance);
        super.setStepSound(soundType);
	}
	
	/**
	 * Constructor for the CoreBlock class.
	 * @param blockUnlocalizedName
	 * @param blockMaterial
	 * @param tab
	 * @param soundType
	 * @param hardness
	 * @param resistance
	 */
	protected CoreBlock(String unlocalizedName, Material blockMaterial, CreativeTabs tab, Block.SoundType soundType, float hardness, float resistance) {
		this(unlocalizedName, blockMaterial, soundType, hardness, resistance);
		super.setCreativeTab(tab);
	}
	
	@Override
	public String getUnlocalizedName() {
		return blockUnlocalizedName;
	}

	@Override
	public Material getBlockMaterial() {
		return super.getMaterial();
	}
}

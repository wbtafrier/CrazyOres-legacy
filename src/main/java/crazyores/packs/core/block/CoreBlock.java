package crazyores.packs.core.block;

import crazyores.manager.pack.COPackManager;
import crazyores.manager.support.IBlock;
import crazyores.manager.support.IName;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class CoreBlock extends Block implements IBlock, IName {

	public final String blockUnlocalizedName;
	private String oreDictionaryName;
	
	protected CoreBlock(String unlocalizedName, Material blockMaterial) {
		super(blockMaterial);
		this.blockUnlocalizedName = unlocalizedName;
	}
	
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
	protected CoreBlock(String unlocalizedName, Material blockMaterial, SoundType soundType, float hardness, float resistance) {
		this(unlocalizedName, blockMaterial, hardness, resistance);
        super.setSoundType(soundType);
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
	protected CoreBlock(String unlocalizedName, Material blockMaterial, CreativeTabs tab, SoundType soundType, float hardness, float resistance) {
		this(unlocalizedName, blockMaterial, soundType, hardness, resistance);
		super.setCreativeTab(tab);
	}
	
	protected CoreBlock(String unlocalizedName, Material blockMaterial, CreativeTabs tab, SoundType soundType, float hardness, float resistance, float lightLevel) {
		this(unlocalizedName, blockMaterial, tab, soundType, hardness, resistance);
		super.setLightLevel(lightLevel);
	}
	
	protected CoreBlock setOreDictionaryName(String oreDictName) {
		if (this.oreDictionaryName == null) {
			this.oreDictionaryName = oreDictName;
		}
		return this;
	}
	
	public String getOreDictionaryName() {
		return oreDictionaryName;
	}
	
	@Override
	public String getUnlocalizedName() {
		return blockUnlocalizedName;
	}
	
	@Override
	public Material getBlockMaterial() {
		return this.blockMaterial;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(String.format("%s%s%s", COPackManager.corePack.getPackID(), ":", this.blockUnlocalizedName));
	}

	@Override
	public IIcon getIcon(int side, int metadata) {
		return this.blockIcon;
	}
}

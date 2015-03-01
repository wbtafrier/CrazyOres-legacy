package crazyores.packs.core.block;

import net.minecraft.block.Block.SoundType;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.support.IBlock;
import crazyores.manager.support.IName;
import crazyores.packs.core.entity.TileEntityTapaziteCrystal;

public class BlockTapaziteCrystal extends BlockContainer implements IBlock, IName {

	public final String blockName;
	public final String blockUnlocalizedName;
	
	protected BlockTapaziteCrystal(String blockReadableName, String unlocalizedName, Material blockMaterial, SoundType soundType, float hardness, float resistance) {
		super(blockMaterial);
		super.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 1.0F, 0.8F);
		
		this.blockName = blockReadableName;
		this.blockUnlocalizedName = unlocalizedName;
		super.setBlockName(blockName);
        super.setStepSound(soundType);
        super.setHardness(hardness);
        super.setResistance(resistance);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityTapaziteCrystal();
	}
	
	@Override
	public boolean isOpaqueCube() {
        return false;
    }
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public String getUnlocalizedName() {
		return blockUnlocalizedName;
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
	public String parsePrefix(String unlocalizedName, char lastPrefixChar) {
		return unlocalizedName.substring(unlocalizedName.indexOf(lastPrefixChar) + 1);
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

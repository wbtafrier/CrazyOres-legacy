package crazyores.packs.core.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.support.IBlock;
import crazyores.manager.support.IName;
import crazyores.packs.core.entity.TileEntityTapaziteCrystal;
import crazyores.packs.core.model.ModelTapaziteCrystal;

public class BlockTapaziteCrystal extends BlockContainer implements IBlock, IName {

	public final String blockName;
	public final String blockUnlocalizedName;
	private static Random rand = new Random();
	public List<TileEntityTapaziteCrystal> crystalsInWorld;
	public List<ModelTapaziteCrystal> crystalModels;
	
	protected BlockTapaziteCrystal(String blockReadableName, String unlocalizedName, Material blockMaterial, SoundType soundType, float hardness, float resistance) {
		super(blockMaterial);
		super.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 1.0F, 0.8F);
		
		this.setTickRandomly(true);
		this.blockName = blockReadableName;
		this.blockUnlocalizedName = unlocalizedName;
		super.setBlockName(blockName);
        super.setStepSound(soundType);
        super.setHardness(hardness);
        super.setResistance(resistance);
        crystalsInWorld = new ArrayList<>();
	}
	
	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
        super.updateTick(world, x, y, z, rand);
        
        for (int i = 0; i < crystalsInWorld.size(); i++) {
        	crystalsInWorld.get(i).updateObelisk(crystalsInWorld.get(i));
        }
        
//        if (world.getBlockLightValue(x, y + 1, z) >= 9)
//        {
//            int l = world.getBlockMetadata(x, y, z);
//
//            if (l < 7)
//            {
//                float f = rand.nextInt(10) + 1;
//
//                if (rand.nextInt((int)(25.0F / f) + 1) == 0)
//                {
//                    ++l;
////                    world.setBlockMetadataWithNotify(x, y, z, l, 2);
//                }
//            }
//        }
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		crystalsInWorld.add(new TileEntityTapaziteCrystal());
		return crystalsInWorld.get(crystalsInWorld.size() - 1);
//		return new TileEntityTapaziteCrystal();
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
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
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

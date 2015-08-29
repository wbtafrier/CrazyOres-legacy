package crazyores.packs.core.block;

import java.util.Random;

import crazyores.manager.pack.COPackManager;
import crazyores.packs.core.entity.tileentity.TileEntityDemoniteFurnace;
import crazyores.packs.core.entity.tileentity.TileEntityLuminiteDisco;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockLuminiteDisco extends CoreGlass implements ITileEntityProvider {

	private Random rand = new Random();
	
	protected BlockLuminiteDisco(String unlocalizedName, float hardness, float resistance, float lightLevel) {
		super(unlocalizedName, true, hardness, resistance);
		this.setLightLevel(lightLevel);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
        return new TileEntityLuminiteDisco();
    }
	
	public static void updateBlockState(World world, int x, int y, int z, short textureIndex) {
//		int metadata = world.getBlockMetadata(x, y, z);
//		TileEntity tileentity = world.getTileEntity(x, y, z);
//		
//		isFurnaceUpdating = true;
//		if (stillBurning) world.setBlock(x, y, z, CoreBlocks.demoniteFurnaceLit);
//		else world.setBlock(x, y, z, CoreBlocks.demoniteFurnace);
//		isFurnaceUpdating = false;
//		
//		world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
//
//		if (tileentity != null) {
//			tileentity.validate();
//			world.setTileEntity(x, y, z, tileentity);
//		}
		
//		System.out.println("HELLO: " + textureIndex);
//		TileEntity tileEntity = world.getTileEntity(x, y, z);
		
//		if (tileEntity instanceof TileEntityLuminiteDisco) {
//			System.out.println("Updating texture!");
//			world.setBlock(x, y, z, CoreBlocks.luminiteStorageBlock, textureIndex, 2);
//			world.setBlockMetadataWithNotify(x, y, z, textureIndex, 2);
//		}
			
//		if (tileEntity != null) {
//			tileEntity.validate();
//			world.setTileEntity(x, y, z, tileEntity);
//		}
		
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		
		world.setBlock(x, y, z, CoreBlocks.luminiteStorageBlock, textureIndex, 2);
		world.setBlockMetadataWithNotify(x, y, z, textureIndex, 2);

		if (tileEntity != null) {
			tileEntity.validate();
			world.setTileEntity(x, y, z, tileEntity);
		}
    }
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
//        TileEntityLuminiteDisco tileEntity = (TileEntityLuminiteDisco)world.getTileEntity(x, y, z);
//        
//        System.out.println("WHY DONT YOU REMOVE");
//        if (tileEntity != null) {
//        	System.out.println("IM TRYING");
//        	world.removeTileEntity(x, y, z);
//        }
//        super.breakBlock(world, x, y, z, block, metadata);
		
		TileEntityLuminiteDisco tileEntity = (TileEntityLuminiteDisco)world.getTileEntity(x, y, z);
        
        if (tileEntity != null) {
            world.func_147453_f(x, y, z, block);
        }
        super.breakBlock(world, x, y, z, block, metadata);
    }
	
	
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = CoreBlocks.luminiteStorageBlock.getIcon(0, rand.nextInt(BlockLuminiteStorage.LUMINITE_STORAGE_BLOCK_SUBTYPES.length - 2) + 1);
	}

	@Override
	public IIcon getIcon(int side, int metadata) {
		return this.blockIcon;
	}
}

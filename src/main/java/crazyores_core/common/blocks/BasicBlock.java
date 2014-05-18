package crazyores_core.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import crazyores_core.common.core.COData;
import crazyores_core.common.core.COSettings;
import crazyores_core.common.items.ItemList;
import crazyores_core.common.tabs.TabList;

public class BasicBlock extends Block
{
	
	public BasicBlock(Material material) 
	{
        super(material);
        this.setCreativeTab(TabList.COBlocks);
	}
	
	@Override
    public Item getItemDropped(int i, Random rand, int y)
    {
    	if (this.isAssociatedBlock(BlockList.experium_block))
    	{
    		return ItemList.experium_orb;
    	}
    	else if (this.isAssociatedBlock(BlockList.fools_ruby_block))
    	{
    		return ItemList.fools_ruby_mush;
    	}
    	return Item.getItemFromBlock(this);
    }
    
//	@Override
//	/**
//	 * Called whenever the block is added into the world. Args: world, x, y, z
//	 */
//	public void onBlockAdded(World par1World, int x, int y, int z)
//	{
//		if (COSettings.toggleDebug)
//		{
//			//TODO: Remove debugging only
//			if (this.isAssociatedBlock(BlockList.sapphire_block))
//			{
//				for (int i = -2; i < 3; i++)
//				{
//					if (par1World.getBlock(x + i, y, z) == Blocks.grass || par1World.getBlock(x + i, y, z) == Blocks.dirt) {
//						par1World.setBlock(x + i, y, z, Blocks.air, 0, 2);
//						par1World.setBlock(x + i, y - 1, z, Blocks.grass, 0, 2);
//					}
//					
//					for (int j = -2; j < 3; j++)
//					{
//						if (par1World.getBlock(x + i, y, z + j) == Blocks.grass || par1World.getBlock(x + i, y, z + j) == Blocks.dirt) {
//							par1World.setBlock(x + i, y, z + j, Blocks.air, 0, 2);
//							par1World.setBlock(x + i, y - 1, z + j, Blocks.grass, 0, 2);
//						}
//						
//		//				for (int k = -8; k < 7; k++)
//		//				{
//		//					if (par1World.getBlock(x + i, y + k, z + j) == Blocks.tallgrass || par1World.getBlock(x + i, y + k, z + j) == Blocks.double_plant) {
//		//						par1World.setBlock(x + i, y + k, z + j, Blocks.air, 0, 2);
//		//					}
//		//				}
//					}
//				}
//			}
//			else
//			{
//				for (int i = -2; i < 3; i++)
//				{
//					if (par1World.getBlock(x + i, y, z) == Blocks.air || par1World.getBlock(x + i, y, z) == Blocks.dirt) {
//						par1World.setBlock(x + i, y, z, Blocks.grass, 0, 2);
//					}
//					
//					for (int k = 1; k < 11; k++)
//					{
//						if (par1World.getBlock(x + i, y - k, z) != Blocks.dirt) {
//							par1World.setBlock(x + i, y - k, z, Blocks.dirt, 0, 2);
//						}
//					}
//					
//					for (int j = -2; j < 3; j++)
//					{
//						if (par1World.getBlock(x + i, y, z + j) == Blocks.air || par1World.getBlock(x + i, y, z + j) == Blocks.dirt) {
//							par1World.setBlock(x + i, y, z + j, Blocks.grass, 0, 2);
//							
//							for (int k = 1; k < 11; k++)
//							{
//								if (par1World.getBlock(x + i, y - k, z + j) != Blocks.dirt) {
//									par1World.setBlock(x + i, y - k, z + j, Blocks.dirt, 0, 2);
//								}
//							}
//						}
//						
//		//				for (int k = -8; k < 7; k++)
//		//				{
//		//					if (par1World.getBlock(x + i, y + k, z + j) == Blocks.tallgrass || par1World.getBlock(x + i, y + k, z + j) == Blocks.double_plant) {
//		//						par1World.setBlock(x + i, y + k, z + j, Blocks.air, 0, 2);
//		//					}
//		//				}
//					}
//				}
//			}
//			
//			par1World.setBlock(x, y, z, Blocks.grass, 0, 2);
//		}
//	}
	
	@Override
    public int quantityDropped(Random rand)
    {
    	if (this.isAssociatedBlock(BlockList.experium_block))
    	{
    		return rand.nextInt(5) + 1;
    	}
    	else if (this.isAssociatedBlock(BlockList.fools_ruby_block))
    	{
    		return rand.nextInt(9) + 1;
    	}
		return 1;
    }
}
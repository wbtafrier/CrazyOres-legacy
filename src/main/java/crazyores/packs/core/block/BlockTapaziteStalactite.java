package crazyores.packs.core.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import crazyores.manager.util.CrazyOresLogger;
import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockTapaziteStalactite extends BlockTapaziteCrystal {
	
	public BlockTapaziteStalactite(String blockReadableName, String unlocalizedName, SoundType soundType, float hardness, float resistance) {
		super(blockReadableName, unlocalizedName, soundType, hardness, resistance);
		this.setBlockBounds(0.2F, 0.7F, 0.2F, 0.8F, 1.0F, 0.8F);
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		return world.getBlock(x, y + 1, z).isAssociatedBlock(Blocks.stone);
    }
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.getBlock(x, y + 1, z).isAssociatedBlock(Blocks.stone) &&
				world.getBlock(x, y - 1, z).isAir(world, x, y - 1, z);
    }
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {

		CrazyOresLogger.write(Level.INFO, "BLOCK LIGHT LEVEL: " + world.getBlockLightValue(x, y - 1, z));
        if (world.getBlockLightValue(x, y - 1, z) <= 5) {
        	
            int metadata = world.getBlockMetadata(x, y, z);

            if (metadata < ItemBlockTapaziteStalactite.maxMetadata) {
                float f = this.growMultiplier(world, x, y, z);

                if (rand.nextInt((int)(15.0F / f) + 1) == 0) {
                	
                	CrazyOresLogger.write(Level.INFO, "I'm growing! Tapazite Crystal grew at coords: x: " + x + ", y: " + y + ", z: " + z);
                    metadata++;
                    world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
                }
                
                if (rand.nextInt((int)(10F / f) + 1) == 0) {
                	
                	CrazyOresLogger.write(Level.INFO, "TRYING TO GROW: x: " + x + ", y: " + y + ", z: " + z);
                	
                	int xDir = rand.nextInt(2);
                	int zDir = rand.nextInt(2);
                	
                	int[] randBlockCoord = new int[3];
                	randBlockCoord[1] = y;
                	if (xDir == 0 && zDir == 0) {
                		randBlockCoord[0] = x + rand.nextInt(3);
                		randBlockCoord[2] = z + rand.nextInt(3);
                	}
                	else if (xDir == 1 && zDir == 0) {
                		randBlockCoord[0] = x - rand.nextInt(3);
                		randBlockCoord[2] =	z + rand.nextInt(3);
                	}
                	else if (xDir == 0 && zDir == 1) {
                		randBlockCoord[0] =	x + rand.nextInt(3);
                		randBlockCoord[2] =	z - rand.nextInt(3);
            		}
                	else if (xDir == 1 && zDir == 1) {
                		randBlockCoord[0] = x - rand.nextInt(3);
                		randBlockCoord[2] = z - rand.nextInt(3);
            		}
                	
                	test:
                	for (int xx = 0; xx < 3; xx++) {
                		for (int zz = 0; zz < 3; zz++) {
                		
                			int testX = randBlockCoord[0] + xx;
                			int testZ = randBlockCoord[2] + zz;

                			if (world.getBlock(testX, randBlockCoord[1], testZ).isAir(world, testX, randBlockCoord[1], testZ) &&
                					world.getBlock(testX, randBlockCoord[1] + 1, testZ).isAssociatedBlock(Blocks.stone)) {

                				metadata = rand.nextInt(5);
                				world.setBlock(testX, randBlockCoord[1], testZ, this);
                				world.setBlockMetadataWithNotify(testX, randBlockCoord[1], testZ, metadata, 2);
                				CrazyOresLogger.write(Level.INFO, "Omg I randomly spawned! at coords: x: " + x + ", y: " + y + ", z: " + z);
                				break test;
                			}
                		}
                	}
                }
            }
        }
    }
	
	@Override
	protected float growMultiplier(World world, int x, int y, int z) {
		
        float f = 1.0F;
        Block block = world.getBlock(x, y, z - 1);
        Block block1 = world.getBlock(x, y, z + 1);
        Block block2 = world.getBlock(x - 1, y, z);
        Block block3 = world.getBlock(x + 1, y, z);
        Block block4 = world.getBlock(x - 1, y, z - 1);
        Block block5 = world.getBlock(x + 1, y, z - 1);
        Block block6 = world.getBlock(x + 1, y, z + 1);
        Block block7 = world.getBlock(x - 1, y, z + 1);
        
        //if x axis has the same block
        boolean flag = block2 == this || block3 == this;
        
        //if z axis has the same block
        boolean flag1 = block == this || block1 == this;
        
        //if diagnols are the same block
        boolean flag2 = block4 == this || block5 == this || block6 == this || block7 == this;

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = z - 1; j <= z + 1; ++j) 
            {
                float f1 = 0.0F;

                if (world.getBlock(i, y + 1, j).isAssociatedBlock(Blocks.stone)) {
                    f1 = 1.0F;

                    CrazyOresLogger.write(Level.INFO, "I'm stone!");
                    
                    //If cool crystal mob guy is around 
//                    if (world.getBlock(i, y - 1, j).isFertile(world,i, y - 1, j)) {
//                        f1 = 5.0F;
//                    }
                }

                if (i != x || j != z) {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        if (flag2 || flag && flag1) {
            f /= 2.0F;
        }

        
        CrazyOresLogger.write(Level.INFO, "THIS IS THE F VARIABLE: " + f);
        return f;
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
		for (int metadata = 0; metadata < ItemBlockTapaziteStalactite.maxMetadata; metadata++) {
			list.add(new ItemStack(item, 1, metadata));
		}
	}
	
	@Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        int count = quantityDropped(metadata, fortune, world.rand);
        for(int i = 0; i < count; i++) {
            Item item = getItemDropped(metadata, world.rand, fortune);
            if (item != null) {
                ret.add(new ItemStack(item, 1, damageDropped(metadata)));
            }
        }
        
        if (metadata >= ItemBlockTapaziteStalactite.maxMetadata) {
            
        	for (int i = 0; i < 3 + fortune; i++) {
        		
                if (world.rand.nextInt(15) <= metadata) {
                    ret.add(new ItemStack(this.getItemDropped(), 1, 0));
                }
            }
        }
        return ret;
    }
}

package crazyores.packs.core.block;

import static net.minecraftforge.common.EnumPlantType.Cave;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.ForgeEventFactory;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.support.IBlock;
import crazyores.manager.support.IName;
import crazyores.manager.tabs.COTabList;
import crazyores.manager.util.CrazyOresLogger;
import crazyores.packs.core.entity.tileentity.TileEntityTapaziteCrystal;

public abstract class BlockTapaziteCrystal extends BlockBush implements ITileEntityProvider, IBlock, IName {

	public final String blockName;
	public final String blockUnlocalizedName;
	
	protected BlockTapaziteCrystal(String blockReadableName, String unlocalizedName, SoundType soundType, float hardness, float resistance) {
		super(Material.glass);
		
		this.isBlockContainer = true;
		this.setTickRandomly(true);
		this.setLightLevel(0.3F);
		this.setLightOpacity(0);
		
		this.blockName = blockReadableName;
		this.blockUnlocalizedName = unlocalizedName;
		this.setCreativeTab(COTabList.defaultBlocksTab);
		super.setBlockName(blockName);
        super.setStepSound(soundType);
        super.setHardness(hardness);
        super.setResistance(resistance);
	}
	
	public boolean correctLightingForGrowth(World world, int x, int y, int z) {
		
		if (world.getBlockLightValue(x, y + 1, z) <= 8 && world.getBlockLightValue(x, y - 1, z) <= 8 && world.getBlockLightValue(x + 1, y, z) <= 8 &&
			world.getBlockLightValue(x - 1, y, z) <= 8 && world.getBlockLightValue(x, y, z + 1) <= 8 &&
			world.getBlockLightValue(x, y, z - 1) <= 8 && world.getBlockLightValue(x + 1, y, z + 1) <= 8 &&
			world.getBlockLightValue(x + 1, y, z - 1) <= 8 && world.getBlockLightValue(x - 1, y, z + 1) <= 8 &&
			world.getBlockLightValue(x - 1, y, z - 1) <= 8) {
			return true;
		}
		return false;
	}
	
	public void spawnRandomCrystal(World world, int x, int y, int z, Random rand, int metadata) {
		int xDir = rand.nextInt(2);
		int yDir = rand.nextInt(2);
		int zDir = rand.nextInt(2);

		int[] randBlockCoord = new int[3];
		
		if (xDir == 0 && yDir == 0 && zDir == 0) {
			randBlockCoord[0] = x + rand.nextInt(3); randBlockCoord[1] = y + rand.nextInt(3); randBlockCoord[2] = z + rand.nextInt(3);
		}
		else if (xDir == 1 && yDir == 0 && zDir == 0) {
			randBlockCoord[0] = x - rand.nextInt(3); randBlockCoord[1] = y + rand.nextInt(3); randBlockCoord[2] = z + rand.nextInt(3);
		}
		else if (xDir == 0 && yDir == 1 && zDir == 0) {
			randBlockCoord[0] = x + rand.nextInt(3); randBlockCoord[1] = y - rand.nextInt(3); randBlockCoord[2] = z + rand.nextInt(3);
		}
		else if (xDir == 0 && yDir == 0 && zDir == 1) {
			randBlockCoord[0] = x + rand.nextInt(3); randBlockCoord[1] = y + rand.nextInt(3); randBlockCoord[2] = z - rand.nextInt(3);
		}
		else if (xDir == 1 && yDir == 0 && zDir == 1) {
			randBlockCoord[0] = x - rand.nextInt(3); randBlockCoord[1] = y + rand.nextInt(3); randBlockCoord[2] = z - rand.nextInt(3);
		}
		else if (xDir == 1 && yDir == 1 && zDir == 0) {
			randBlockCoord[0] = x - rand.nextInt(3); randBlockCoord[1] = y - rand.nextInt(3); randBlockCoord[2] = z + rand.nextInt(3);
		}
		else if (xDir == 0 && yDir == 1 && zDir == 1) {
			randBlockCoord[0] = x + rand.nextInt(3); randBlockCoord[1] = y - rand.nextInt(3); randBlockCoord[2] = z - rand.nextInt(3);
		}
		else if (xDir == 1 && yDir == 1 && zDir == 1) {
			randBlockCoord[0] = x - rand.nextInt(3); randBlockCoord[1] = y - rand.nextInt(3); randBlockCoord[2] = z - rand.nextInt(3);
		}

		test:
		for (int xx = 0; xx < 3; xx++) {
			for (int yy = 0; yy < 3; yy++) {
				for (int zz = 0; zz < 3; zz++) {

					int testX = randBlockCoord[0] + xx;
					int testY = randBlockCoord[1] + yy;
					int testZ = randBlockCoord[2] + zz;

					if (world.getBlock(testX, testY, testZ).isAir(world, testX, testY, testZ) && 
							world.getBlock(testX, testY - 1, testZ).isAir(world, testX, testY - 1, testZ) &&
							world.getBlock(testX, testY + 1, testZ).isAssociatedBlock(Blocks.stone)) {
						
						metadata = 0;
						world.setBlock(testX, testY, testZ, CoreBlocks.tapaziteStalactite);
						world.setBlockMetadataWithNotify(testX, testY, testZ, metadata, 2);
						CrazyOresLogger.write(Level.INFO, "Omg I randomly spawned! at coords: x: " + x + ", y: " + y + ", z: " + z);
						break test;
					}
					if (world.getBlock(testX, testY, testZ).isAir(world, testX, testY, testZ) &&
							world.getBlock(testX, testY + 1, testZ).isAir(world, testX, testY + 1, testZ) &&
							world.getBlock(testX, testY - 1, testZ).isAssociatedBlock(Blocks.stone)) {

						metadata = 0;
						world.setBlock(testX, testY, testZ, CoreBlocks.tapaziteStalagmite);
						world.setBlockMetadataWithNotify(testX, testY, testZ, metadata, 2);
						CrazyOresLogger.write(Level.INFO, "Omg I randomly spawned! at coords: x: " + x + ", y: " + y + ", z: " + z);
						break test;
					}
				}
			}
		}
	}
	
	public void growCrystal(World world, int x, int y, int z, int metadata) {
		CrazyOresLogger.write(Level.INFO, "I'm growing! Tapazite Crystal grew at coords: x: " + x + ", y: " + y + ", z: " + z);
        metadata++;
        world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
	}
	
	@Override
	public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata) {
        return false;
    }
	
	@Override
	protected boolean canPlaceBlockOn(Block block) {
        return block == Blocks.stone;
    }
	
	@Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		 return Cave;
    }
	
	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        this.checkAndDropBlock(world, x, y, z);
    }
	
	@Override
	protected void checkAndDropBlock(World world, int x, int y, int z) {
		
		if (!this.canBlockStay(world, x, y, z)) {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlock(x, y, z, getBlockById(0), 0, 2);
        }
	}
	
	@Override
	public abstract boolean canBlockStay(World world, int x, int y, int z);
	
	//Will be used to spawn particles
//	@Override
//	@SideOnly(Side.CLIENT)
//    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
//		
//	}
	
	@Override
	public abstract void updateTick(World world, int x, int y, int z, Random rand);
	
	protected abstract float growMultiplier(World world, int x, int y, int z);
	
	public Item obeliskDrop() {
//		return CoreItems.tapaziteObelisk;
		return Items.apple;
	}
	
	public Item tapaziteDust() {
//		return CoreItems.tapaziteDust;
		return Items.baked_potato;
	}

//	@Override
//    public Item getItemDropped(int metadata, Random rand, int fortune) {
//		return metadata < 2 ? this.tapaziteDust() : this.obeliskDrop();
//    }
//	
	@Override
    public int quantityDropped(int metadata, int fortune, Random rand) {
		return metadata < 2 ? rand.nextInt(3) + 1 : metadata < 7 ? rand.nextInt(4) + 1 : rand.nextInt(5) + 1;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z) {
		return this.tapaziteDust();
    }
	
	@Override
	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
        
		if (!world.isRemote) {
            ArrayList<ItemStack> items = this.getDrops(world, x, y, z, p_149690_5_, p_149690_7_);
            p_149690_6_ = ForgeEventFactory.fireBlockHarvesting(items, world, this, x, y, z, p_149690_5_, p_149690_7_, p_149690_6_, false, harvesters.get());

            for (ItemStack item : items) {
                if (world.rand.nextFloat() <= p_149690_6_) {
                    this.dropBlockAsItem(world, x, y, z, item);
                }
            }
        }
    }
	
	@Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        Random rand = new Random();
        
        if (metadata < 2) {
            
        	for (int i = 0; i < this.quantityDropped(metadata, fortune, rand); i++) {
        		ret.add(new ItemStack(this.tapaziteDust(), 1, 0));
        	}
        }
        else if (metadata < 7) {
        	for (int i = 0; i < this.quantityDropped(metadata, fortune, rand); i++) {
        		
        		int r = rand.nextInt(2);
        		if (r == 0)
        			ret.add(new ItemStack(this.tapaziteDust(), 1, 0));
        		else
        			ret.add(new ItemStack(this.obeliskDrop(), 1, 0));
        	}
        }
        else {
        	for (int i = 0; i < this.quantityDropped(metadata, fortune, rand); i++) {
        		ret.add(new ItemStack(this.obeliskDrop(), 1, 0));
        	}
        }
        return ret;
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityTapaziteCrystal();
	}
	
	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public abstract void getSubBlocks(Item item, CreativeTabs creativeTabs, List list);
	
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
	
//	@Override
//	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
//        return super.getSelectedBoundingBoxFromPool(world, x, y, z);
//    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    @Override
    public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
        super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
    }

    @Override
    public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
        super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
        p_149749_1_.removeTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);
    }

    @Override
    public boolean onBlockEventReceived(World p_149696_1_, int p_149696_2_, int p_149696_3_, int p_149696_4_, int p_149696_5_, int p_149696_6_) {
        super.onBlockEventReceived(p_149696_1_, p_149696_2_, p_149696_3_, p_149696_4_, p_149696_5_, p_149696_6_);
        TileEntity tileentity = p_149696_1_.getTileEntity(p_149696_2_, p_149696_3_, p_149696_4_);
        return tileentity != null ? tileentity.receiveClientEvent(p_149696_5_, p_149696_6_) : false;
    }
}

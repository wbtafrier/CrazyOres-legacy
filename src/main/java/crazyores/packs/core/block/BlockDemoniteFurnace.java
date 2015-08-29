package crazyores.packs.core.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.support.IName;
import crazyores.manager.tabs.COTabList;
import crazyores.packs.core.entity.tileentity.TileEntityDemoniteFurnace;
import crazyores.packs.core.entity.tileentity.TileEntityLuminiteDisco;
import crazyores.packs.core.item.CoreItems;

public class BlockDemoniteFurnace extends BlockContainer implements IName {

	private final Random rand = new Random();
	public final String blockUnlocalizedName;
	public final String textureName;
	private boolean flaming;
	private static boolean isFurnaceUpdating;
	public static final float EXPLOSION_STRENGTH = 7.0f;
	
	@SideOnly(Side.CLIENT)
    private IIcon topIcon;
    @SideOnly(Side.CLIENT)
    private IIcon frontIcon;
	
	protected BlockDemoniteFurnace(String unlocalizedName, boolean isFlaming, float hardness, float resistance) {
		super(Material.iron);
		
		flaming = isFlaming;
		textureName = "demonite_furnace";
		this.blockUnlocalizedName = unlocalizedName;
		this.setHardness(hardness);
		this.setResistance(resistance);
		if (!flaming) this.setCreativeTab(COTabList.crazyOresBlocksTab);
		this.setStepSound(Block.soundTypeMetal);
	}

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		return Item.getItemFromBlock(CoreBlocks.demoniteBlock);
	}
	
	@Override
    public int quantityDropped(Random rand) {
		return rand.nextInt(4) + 1;
    }
	
	@Override
	public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
        super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
        this.getDirection(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
    }
	
	private void getDirection(World world, int x, int y, int z) {
        if (!world.isRemote) {
            Block block = world.getBlock(x, y, z - 1);
            Block block1 = world.getBlock(x, y, z + 1);
            Block block2 = world.getBlock(x - 1, y, z);
            Block block3 = world.getBlock(x + 1, y, z);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j()) {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j()) {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j()) {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j()) {
                b0 = 4;
            }
            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float d, float f, float k) {
        if (world.isRemote) {
            return true;
        }
        else {
            TileEntityDemoniteFurnace demoniteFurnace = (TileEntityDemoniteFurnace)world.getTileEntity(x, y, z);
            if (demoniteFurnace != null) {
            	player.openGui(COPackManager.corePack.getPackID(), 0, world, x, y, z);
            }
            return true;
        }
    }

	public static void updateBlockState(boolean stillBurning, World world, int x, int y, int z) {
		int metadata = world.getBlockMetadata(x, y, z);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		
		isFurnaceUpdating = true;
		if (stillBurning) world.setBlock(x, y, z, CoreBlocks.demoniteFurnaceLit);
		else world.setBlock(x, y, z, CoreBlocks.demoniteFurnace);
		isFurnaceUpdating = false;
		
		world.setBlockMetadataWithNotify(x, y, z, metadata, 2);

		if (tileentity != null) {
			tileentity.validate();
			world.setTileEntity(x, y, z, tileentity);
		}
    }
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityDemoniteFurnace();
    }
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0) {
        	world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (l == 1) {
        	world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (l == 2) {
        	world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (l == 3) {
        	world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }

        if (stack.hasDisplayName()) {
            ((TileEntityDemoniteFurnace)world.getTileEntity(x, y, z)).setCustomName(stack.getDisplayName());
        }
    }
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
        if (!isFurnaceUpdating) {
            TileEntityDemoniteFurnace demoniteFurnace = (TileEntityDemoniteFurnace)world.getTileEntity(x, y, z);
            
            if (demoniteFurnace != null) {
                for (int i1 = 0; i1 < demoniteFurnace.getSizeInventory(); ++i1) {
                    ItemStack itemstack = demoniteFurnace.getStackInSlot(i1);

                    if (itemstack != null) {
                        float f = rand.nextFloat() * 0.8F + 0.1F;
                        float f1 = rand.nextFloat() * 0.8F + 0.1F;
                        float f2 = rand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0) {
                            int j1 = rand.nextInt(21) + 10;

                            if (j1 > itemstack.stackSize) {
                                j1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= j1;
                            EntityItem entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound()) {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (double)((float)rand.nextGaussian() * f3);
                            entityitem.motionY = (double)((float)rand.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = (double)((float)rand.nextGaussian() * f3);
                            world.spawnEntityInWorld(entityitem);
                        }
                    }
                }
                world.func_147453_f(x, y, z, block);
                
                if (demoniteFurnace.overHeat > demoniteFurnace.NO_RETURN) {
                	world.newExplosion(null, x, y, z, EXPLOSION_STRENGTH, true, true);
                }
                
            }
        }
        super.breakBlock(world, x, y, z, block, metadata);
    }
	
	@Override
	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion exp) {
        if (!world.isRemote) {
        	world.newExplosion(null, x, y, z, EXPLOSION_STRENGTH, true, true);
        }
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
        if (flaming) {
            int l = world.getBlockMetadata(x, y, z);
            float f = (float)x + 0.5F;
            float f1 = (float)y + 0.0F + rand.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)z + 0.5F;
            float f3 = 0.52F;
            float f4 = rand.nextFloat() * 0.6F - 0.3F;

            if (l == 4) {
            	world.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 5) {
            	world.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 2) {
            	world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 3) {
            	world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            	world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            }
        }
    }
	
	@Override
	public boolean hasComparatorInputOverride() {
        return true;
    }
	
	@Override
	public int getComparatorInputOverride(World world, int x, int y, int z, int idk) {
        return Container.calcRedstoneFromInventory((IInventory)world.getTileEntity(x, y, z));
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z) {
        return Item.getItemFromBlock(CoreBlocks.demoniteFurnace);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.blockIcon = icon.registerIcon(String.format("%s%s%s", COPackManager.corePack.getPackID(), ":", textureName + "_side"));
		this.frontIcon = icon.registerIcon(String.format("%s%s%s", COPackManager.corePack.getPackID(), ":", textureName + (flaming ? "_on" : "_off")));
		this.topIcon = icon.registerIcon(String.format("%s%s%s", COPackManager.corePack.getPackID(), ":", textureName + "_top"));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
		return metadata == 0 && side == 3 ? frontIcon : (side == 1 ? topIcon : (side == 0 ? topIcon : (side != metadata ? this.blockIcon : frontIcon)));
    }
	
	@Override
	public String getUnlocalizedName() {
		return blockUnlocalizedName;
	}
}

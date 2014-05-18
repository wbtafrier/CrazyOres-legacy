package crazyores_core.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores_core.common.core.COData;
import crazyores_core.common.core.CrazyOres;
import crazyores_core.common.core.GuiList;
import crazyores_core.common.tileentity.TileEntityDemoniteFurnace;

public class BlockDemoniteFurnace extends BlockContainer
{
	/**
	 * Is the random generator used by demonitefurnace to drop the inventory contents in random directions.
	 */
	public Random demonitefurnaceRand = new Random();

	/** True if this is an active demonitefurnace, false if idle */
	public final boolean isActive;

	/**
	 * This flag is used to prevent the demonitefurnace inventory to be dropped upon block removal, is used internally when the
	 * demonitefurnace block changes from idle to active and vice-versa.
	 */
	public static boolean keepDemoniteFurnaceInventory = false;
	@SideOnly(Side.CLIENT)
	private IIcon furnaceIconTop;
	@SideOnly(Side.CLIENT)
	private IIcon furnaceIconFront;
	@SideOnly(Side.CLIENT)
	private IIcon side3;

	public BlockDemoniteFurnace(boolean par2)
	{
		super(Material.rock);
		this.isActive = par2;
	}

	@Override
	
	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType()
	{
		return 0;
	}

	@Override
	
	/**
	 * Is this block (a) opaque and (B) a full 1m cube? This determines whether or not to render the shared face of two
	 * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override

	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock()
	{
		return true;
	}

	@Override

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(BlockList.demonite_furnace);
	}

	@Override
	
	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);
	}

	/**
	 * set a blocks direction
	 */
	public void setDefaultDirection(World par1World, int par2, int par3, int par4)
	{
		if (!par1World.isRemote)
		{
			Block block = par1World.getBlock(par2, par3, par4 - 1);
			Block block1 = par1World.getBlock(par2, par3, par4 + 1);
			Block block2 = par1World.getBlock(par2 - 1, par3, par4);
			Block block3 = par1World.getBlock(par2 + 1, par3, par4);
			byte var9 = 3;

			if (block.func_149730_j() && !block1.func_149730_j())
			{
				var9 = 3;
			}

			if (block1.func_149730_j() && !block.func_149730_j())
			{
				var9 = 2;
			}

			if (block2.func_149730_j() && !block3.func_149730_j())
			{
				var9 = 5;
			}

			if (block3.func_149730_j() && !block2.func_149730_j())
			{
				var9 = 4;
			}

			par1World.setBlockMetadataWithNotify(par2, par3, par4, var9, 2);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public IIcon getIcon(int par1, int par2)
	{
//		return par1 == 1 ? this.furnaceIconTop : (par1 == 0 ? this.furnaceIconTop : (par1 != par2 ? this.blockIcon : this.furnaceIconFront));
		return par2 == 0 && par1 == 3 ? this.furnaceIconFront : (par1 == 0 ? this.furnaceIconTop : (par1 == 1 ? this.furnaceIconTop : (par1 != par2 ? this.blockIcon : this.furnaceIconFront)));
//		if (par1 == 0 && par2 == 3)
//		{
//			return furnaceIconFront;
//		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.side3 = par1IconRegister.registerIcon(BlockNames.DEMONITE_FURNACE_SIDE_PATH);
		this.blockIcon = par1IconRegister.registerIcon(BlockNames.DEMONITE_FURNACE_SIDE_PATH);
		this.furnaceIconFront = par1IconRegister.registerIcon(this.isActive ? (BlockNames.LIT_DEMONITE_FURNACE_PATH) : (BlockNames.DEMONITE_FURNACE_PATH));
		this.furnaceIconTop = par1IconRegister.registerIcon(BlockNames.DEMONITE_FURNACE_TOP_PATH);
	}

	@SideOnly(Side.CLIENT)
	@Override

	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (this.isActive)
		{
			int var6 = par1World.getBlockMetadata(par2, par3, par4);
			float var7 = (float)par2 + 0.5F;
			float var8 = (float)par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
			float var9 = (float)par4 + 0.5F;
			float var10 = 0.52F;
			float var11 = par5Random.nextFloat() * 0.6F - 0.3F;

			if (var6 == 4)
			{
				par1World.spawnParticle("smoke", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
			}
			else if (var6 == 5)
			{
				par1World.spawnParticle("smoke", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
			}
			else if (var6 == 2)
			{
				par1World.spawnParticle("smoke", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
			}
			else if (var6 == 3)
			{
				par1World.spawnParticle("smoke", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Override

	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		if (par1World.isRemote)
		{
			return true;
		}
		else
		{
			TileEntityDemoniteFurnace var10 = (TileEntityDemoniteFurnace)par1World.getTileEntity(par2, par3, par4);

			if (var10 != null)
			{
				par5EntityPlayer.openGui(CrazyOres.instance, GuiList.DEMONITE_FURNACE_GUI_ID, par1World, par2, par3, par4);
			}

			return true;
		}
	}

	/**
	 * Update which block ID the demonitefurnace is using depending on whether or not it is burning
	 */
	public static void updateDemoniteFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
	{
		int var5 = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity var6 = par1World.getTileEntity(par2, par3, par4);
		keepDemoniteFurnaceInventory = true;

		if (par0)
		{
			par1World.setBlock(par2, par3, par4, BlockList.lit_demonite_furnace);
		}
		else
		{
			par1World.setBlock(par2, par3, par4, BlockList.demonite_furnace);
		}

		keepDemoniteFurnaceInventory = false;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, var5, 2);

		if (var6 != null)
		{
			var6.validate();
			par1World.setTileEntity(par2, par3, par4, var6);
		}
	}
	
	@Override

	/**
	 * each class overrdies this to return a new <className>
	 */
	public TileEntity createNewTileEntity(World par1World, int par2)
	{
		return new TileEntityDemoniteFurnace();
	}

	@Override
	
	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int var6 = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (var6 == 0)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
		}

		if (var6 == 1)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
		}

		if (var6 == 2)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
		}

		if (var6 == 3)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
		}

		if (par6ItemStack.hasDisplayName())
		{
			((TileEntityDemoniteFurnace)par1World.getTileEntity(par2, par3, par4)).setGuiDisplayName(par6ItemStack.getDisplayName());
		}
	}

	@Override
	
	/**
	 * ejects contained items into the world, and notifies neighbours of an update, as appropriate
	 */
	public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
	{
		if (!keepDemoniteFurnaceInventory)
		{
			TileEntityDemoniteFurnace var7 = (TileEntityDemoniteFurnace)par1World.getTileEntity(par2, par3, par4);

			if (var7 != null)
			{
				for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
				{
					ItemStack var9 = var7.getStackInSlot(var8);

					if (var9 != null)
					{
						float var10 = this.demonitefurnaceRand.nextFloat() * 0.8F + 0.1F;
						float var11 = this.demonitefurnaceRand.nextFloat() * 0.8F + 0.1F;
						float var12 = this.demonitefurnaceRand.nextFloat() * 0.8F + 0.1F;

						while (var9.stackSize > 0)
						{
							int var13 = this.demonitefurnaceRand.nextInt(21) + 10;

							if (var13 > var9.stackSize)
							{
								var13 = var9.stackSize;
							}

							var9.stackSize -= var13;
							EntityItem var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.getItem(), var13, var9.getItemDamage()));

							if (var9.hasTagCompound())
							{
								var14.getEntityItem().setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
							}

							float var15 = 0.05F;
							var14.motionX = (double)((float)this.demonitefurnaceRand.nextGaussian() * var15);
							var14.motionY = (double)((float)this.demonitefurnaceRand.nextGaussian() * var15 + 0.2F);
							var14.motionZ = (double)((float)this.demonitefurnaceRand.nextGaussian() * var15);
							par1World.spawnEntityInWorld(var14);
						}
					}
				}
			}
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	@Override
	public boolean hasComparatorInputOverride()
	{
		return false;
	}

	@Override
	public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5)
	{
		return Container.calcRedstoneFromInventory((IInventory)par1World.getTileEntity(par2, par3, par4));
	}

	@SideOnly(Side.CLIENT)
	@Override
	
	/**
	 * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
	 */
	public Item getItem(World par1World, int par2, int par3, int par4)
	{
		return Item.getItemFromBlock(BlockList.demonite_furnace);
	}
}

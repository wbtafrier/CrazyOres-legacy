package crazyores_core.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores_core.common.entity.EntityAdamiteGolem;
import crazyores_core.common.entity.EntityCopperGolem;
import crazyores_core.common.entity.EntityCrystalGolem;
import crazyores_core.common.entity.EntityDemoniteGolem;
import crazyores_core.common.entity.EntityFoolsRubyGolem;
import crazyores_core.common.entity.EntityOsmoniumGolem;
import crazyores_core.common.entity.EntityRubyGolem;
import crazyores_core.common.entity.EntitySapphireGolem;
import crazyores_core.common.entity.EntityStarconiumGolem;
import crazyores_core.common.entity.EntityTapaziteGolem;
import crazyores_core.common.entity.EntityZectiumGolem;
import crazyores_core.common.tabs.TabList;

public class GolemHead extends BlockDirectional
{

	public boolean blockType;

	private IIcon[] tops = new IIcon[4];
	
	@SideOnly(Side.CLIENT)
	private IIcon face;
	
	private Item drop;
	private Block baseBlock;


	public GolemHead(Material material)
	{
		super(material);
		this.setTickRandomly(true);
		this.setCreativeTab(TabList.COBlocks);
	}

	public GolemHead(Material material, Item d, Block base)
	{
		this(material);
		this.drop = d;
		this.baseBlock = base;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getCorrectRotation(int meta)
	{
		return this.tops[meta];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return par1 == 1 ? this.getCorrectRotation(par2) : (par1 == 0 ? this.getCorrectRotation(par2) : (par2 == 2 && par1 == 2 ? this.face : (par2 == 3 && par1 == 5 ? this.face : (par2 == 0 && par1 == 3 ? this.face : (par2 == 1 && par1 == 4 ? this.face : this.blockIcon)))));
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World par1World, int x, int y, int z)
	{
		super.onBlockAdded(par1World, x, y, z);
		
		if (par1World.getBlock(x, y - 1, z) == baseBlock && par1World.getBlock(x, y - 2, z) == baseBlock)
		{	
			boolean arm1 = par1World.getBlock(x - 1, y - 1, z) == baseBlock && par1World.getBlock(x + 1, y - 1, z) == baseBlock;
			boolean arm2 = par1World.getBlock(x, y - 1, z - 1) == baseBlock && par1World.getBlock(x, y - 1, z + 1) == baseBlock;			
			boolean fools_ruby = this.isAssociatedBlock(BlockList.fools_ruby_golem_head);
			
			if (arm1 || arm2 || fools_ruby)
			{
				par1World.setBlock(x, y, z, Blocks.air, 0, 2);
				par1World.setBlock(x, y - 1, z, Blocks.air, 0, 2);
				par1World.setBlock(x, y - 2, z, Blocks.air, 0, 2);

				if (arm1 && !fools_ruby)
				{
					par1World.setBlock(x - 1, y - 1, z, Blocks.air, 0, 2);
					par1World.setBlock(x + 1, y - 1, z, Blocks.air, 0, 2);
				}
				else if (arm2 && !fools_ruby)
				{
					par1World.setBlock(x, y - 1, z - 1, Blocks.air, 0, 2);
					par1World.setBlock(x, y - 1, z + 1, Blocks.air, 0, 2);
				}

				if (this.baseBlock.isAssociatedBlock(BlockList.copper_block))
				{
					EntityCopperGolem entitycoppergolems = new EntityCopperGolem(par1World);
					entitycoppergolems.setPlayerCreated(true);
					entitycoppergolems.setLocationAndAngles((double)x + 0.5D, (double)y - 1.95D, (double)z + 0.5D, 0.0F, 0.0F);
					par1World.spawnEntityInWorld(entitycoppergolems);
				}
				else if (this.baseBlock.isAssociatedBlock(BlockList.sapphire_block))
				{
					EntitySapphireGolem entitysapphiregolems = new EntitySapphireGolem(par1World);
					entitysapphiregolems.setPlayerCreated(true);
					entitysapphiregolems.setLocationAndAngles((double)x + 0.5D, (double)y - 1.95D, (double)z + 0.5D, 0.0F, 0.0F);
					par1World.spawnEntityInWorld(entitysapphiregolems);
				}
				else if (this.baseBlock.isAssociatedBlock(BlockList.adamite_block))
				{
					EntityAdamiteGolem entityadamitegolems = new EntityAdamiteGolem(par1World);
					entityadamitegolems.setPlayerCreated(true);
					entityadamitegolems.setLocationAndAngles((double)x + 0.5D, (double)y - 1.95D, (double)z + 0.5D, 0.0F, 0.0F);
					par1World.spawnEntityInWorld(entityadamitegolems);
				}
				else if (this.baseBlock.isAssociatedBlock(BlockList.ruby_block))
				{
					EntityRubyGolem entityrubygolems = new EntityRubyGolem(par1World);
					entityrubygolems.setPlayerCreated(true);
					entityrubygolems.setLocationAndAngles((double)x + 0.5D, (double)y - 1.95D, (double)z + 0.5D, 0.0F, 0.0F);
					par1World.spawnEntityInWorld(entityrubygolems);
				}
				else if (this.baseBlock.isAssociatedBlock(BlockList.fools_ruby_block))
				{
					EntityFoolsRubyGolem entityfoolsrubygolems = new EntityFoolsRubyGolem(par1World);
					entityfoolsrubygolems.setPlayerCreated(true);
					entityfoolsrubygolems.setLocationAndAngles((double)x + 0.5D, (double)y - 1.95D, (double)z + 0.5D, 0.0F, 0.0F);
					par1World.spawnEntityInWorld(entityfoolsrubygolems);
				}
				else if (this.baseBlock.isAssociatedBlock(BlockList.zectium_block))
				{
					EntityZectiumGolem entityzectiumgolems = new EntityZectiumGolem(par1World);
					entityzectiumgolems.setPlayerCreated(true);
					entityzectiumgolems.setLocationAndAngles((double)x + 0.5D, (double)y - 1.95D, (double)z + 0.5D, 0.0F, 0.0F);
					par1World.spawnEntityInWorld(entityzectiumgolems);
				}
				else if (this.baseBlock.isAssociatedBlock(BlockList.tapazite_block))
				{
					EntityTapaziteGolem entitytapazitegolems = new EntityTapaziteGolem(par1World);
					entitytapazitegolems.setPlayerCreated(true);
					entitytapazitegolems.setLocationAndAngles((double)x + 0.5D, (double)y - 1.95D, (double)z + 0.5D, 0.0F, 0.0F);
					par1World.spawnEntityInWorld(entitytapazitegolems);
				}
				else if (this.baseBlock.isAssociatedBlock(BlockList.crystal_block))
				{
					EntityCrystalGolem entitycrystalgolems = new EntityCrystalGolem(par1World);
					entitycrystalgolems.setPlayerCreated(true);
					entitycrystalgolems.setLocationAndAngles((double)x + 0.5D, (double)y - 1.95D, (double)z + 0.5D, 0.0F, 0.0F);
					par1World.spawnEntityInWorld(entitycrystalgolems);
				}
				else if (this.baseBlock.isAssociatedBlock(BlockList.osmonium_block))
				{
					EntityOsmoniumGolem entityosmoniumgolems = new EntityOsmoniumGolem(par1World);
					entityosmoniumgolems.setPlayerCreated(true);
					entityosmoniumgolems.setLocationAndAngles((double)x + 0.5D, (double)y - 1.95D, (double)z + 0.5D, 0.0F, 0.0F);
					par1World.spawnEntityInWorld(entityosmoniumgolems);
				}
				else if (this.baseBlock.isAssociatedBlock(BlockList.demonite_block))
				{
					EntityDemoniteGolem entitydemonitegolems = new EntityDemoniteGolem(par1World);
					entitydemonitegolems.setPlayerCreated(true);
					entitydemonitegolems.setLocationAndAngles((double)x + 0.5D, (double)y - 1.95D, (double)z + 0.5D, 0.0F, 0.0F);
					par1World.spawnEntityInWorld(entitydemonitegolems);
				}
				else if (this.baseBlock.isAssociatedBlock(BlockList.starconium_block))
				{
					EntityStarconiumGolem entitystarconiumgolems = new EntityStarconiumGolem(par1World);
					entitystarconiumgolems.setPlayerCreated(true);
					entitystarconiumgolems.setLocationAndAngles((double)x + 0.5D, (double)y - 1.95D, (double)z + 0.5D, 0.0F, 0.0F);
					par1World.spawnEntityInWorld(entitystarconiumgolems);
				}
				for (int i1 = 0; i1 < 120; ++i1)
				{
					par1World.spawnParticle("snowballpoof", (double)x + par1World.rand.nextDouble(), (double)(y - 2) + par1World.rand.nextDouble() * 3.9D, (double)z + par1World.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}

				par1World.notifyBlockChange(x, y, z, Blocks.air);
				par1World.notifyBlockChange(x, y - 1, z, Blocks.air);
				par1World.notifyBlockChange(x, y - 2, z, Blocks.air);

				if (arm1 && !fools_ruby)
				{
					par1World.notifyBlockChange(x - 1, y - 1, z, Blocks.air);
					par1World.notifyBlockChange(x + 1, y - 1, z, Blocks.air);
				}
				else if (arm2 && !fools_ruby)
				{
					par1World.notifyBlockChange(x, y - 1, z - 1, Blocks.air);
					par1World.notifyBlockChange(x, y - 1, z + 1, Blocks.air);
				}
			}
		}
	}

	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		String un = this.getUnlocalizedName();
		
		this.face = par1IconRegister.registerIcon(un.substring(5, un.length()) + "_front");
		
		for (int i = 0; i < tops.length; i++)
		{
			this.tops[i] = par1IconRegister.registerIcon(un.substring(5, un.length()) + "_top_" + i);
		}
		
		this.blockIcon = par1IconRegister.registerIcon(un.substring(5, un.length()) + "_back");
	}
}

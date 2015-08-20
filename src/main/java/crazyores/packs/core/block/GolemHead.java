package crazyores.packs.core.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.manager.pack.COPackManager;
import crazyores.packs.core.entity.golem.EntityGolems;
import crazyores.packs.core.entity.golem.EntityAdamiteGolem;
import crazyores.packs.core.entity.golem.EntityCopperGolem;
import crazyores.packs.core.entity.golem.EntityDemoniteGolem;
import crazyores.packs.core.entity.golem.EntityEnderGolem;
import crazyores.packs.core.entity.golem.EntityFoolsRubyGolem;
import crazyores.packs.core.entity.golem.EntityOsmoniumGolem;
import crazyores.packs.core.entity.golem.EntityRubyGolem;
import crazyores.packs.core.entity.golem.EntitySapphireGolem;
import crazyores.packs.core.entity.golem.EntityStarconiumGolem;
import crazyores.packs.core.entity.golem.EntityTapaziteGolem;
import crazyores.packs.core.entity.golem.EntityZectiumGolem;
import crazyores.packs.core.entity.golem.EnumGolemType;
import crazyores.packs.core.util.CoreResourceHandler;

public class GolemHead extends CoreBlock {

	private String textureName;
	private EnumGolemType golemType;
	
    private IIcon[] topIcon = new IIcon[4];
    @SideOnly(Side.CLIENT)
    private IIcon frontIcon;
	
	protected GolemHead(String unlocalizedName, EnumGolemType type, Material blockMaterial, CreativeTabs tab, SoundType soundType, float hardness, float resistance) {
		super(unlocalizedName, blockMaterial, tab, soundType, hardness, resistance);
		golemType = type;
		textureName = golemType.getName() + "_head";
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		
		for (EnumGolemType t : EnumGolemType.values()) {
			
			if (golemType.equals(t)) {
				
				if (this.isAssociatedBlock(CoreBlocks.foolsRubyGolemHead)) {
					float start = 0.4f;
					float inc = 0.3f;
					int counter = 0;
					
					while (world.getBlock(x, y - (counter + 1), z).isAssociatedBlock(t.getBodyBlock())) {
						counter++;
					}
					
					if (counter >= 1) {
						spawnGolem(world, x, y, z, new EntityFoolsRubyGolem(world, ((float)counter * inc + start) + (-0.05f + world.rand.nextFloat() * 0.2f)), counter, true);
					}
					return;
				}
				
				if (world.getBlock(x, y - 1, z).isAssociatedBlock(t.getBodyBlock()) && world.getBlock(x, y - 2, z).isAssociatedBlock(t.getBodyBlock())) {
				
					boolean hasArmsOnXAxis = world.getBlock(x - 1, y - 1, z).isAssociatedBlock(t.getBodyBlock()) && world.getBlock(x + 1, y - 1, z).isAssociatedBlock(t.getBodyBlock());
					boolean hasArmsOnZAxis = world.getBlock(x, y - 1, z - 1).isAssociatedBlock(t.getBodyBlock()) && world.getBlock(x, y - 1, z + 1).isAssociatedBlock(t.getBodyBlock());
					
					if (hasArmsOnXAxis || hasArmsOnZAxis) {
						
						if (this.isAssociatedBlock(CoreBlocks.copperGolemHead))
							spawnGolem(world, x, y, z, new EntityCopperGolem(world), 2, hasArmsOnXAxis);
						else if (this.isAssociatedBlock(CoreBlocks.sapphireGolemHead))
							spawnGolem(world, x, y, z, new EntitySapphireGolem(world), 2 , hasArmsOnXAxis);
						else if (this.isAssociatedBlock(CoreBlocks.adamiteGolemHead))
							spawnGolem(world, x, y, z, new EntityAdamiteGolem(world), 2, hasArmsOnXAxis);
						else if (this.isAssociatedBlock(CoreBlocks.rubyGolemHead))
							spawnGolem(world, x, y, z, new EntityRubyGolem(world), 2, hasArmsOnXAxis);
						else if (this.isAssociatedBlock(CoreBlocks.zectiumGolemHead))
							spawnGolem(world, x, y, z, new EntityZectiumGolem(world), 2, hasArmsOnXAxis);
						else if (this.isAssociatedBlock(CoreBlocks.tapaziteGolemHead))
							spawnGolem(world, x, y, z, new EntityTapaziteGolem(world), 2, hasArmsOnXAxis);
						else if (this.isAssociatedBlock(CoreBlocks.osmoniumGolemHead))
							spawnGolem(world, x, y, z, new EntityOsmoniumGolem(world), 2, hasArmsOnXAxis);
						else if (this.isAssociatedBlock(CoreBlocks.starconiumGolemHead))
							spawnGolem(world, x, y, z, new EntityStarconiumGolem(world), 2, hasArmsOnXAxis);
						else if (this.isAssociatedBlock(CoreBlocks.demoniteGolemHead))
							spawnGolem(world, x, y, z, new EntityDemoniteGolem(world), 2, hasArmsOnXAxis);
						else if (this.isAssociatedBlock(CoreBlocks.enderGolemHead))
							spawnGolem(world, x, y, z, new EntityEnderGolem(world), 2, hasArmsOnXAxis);
						else
							return;
					}
				}
			}
		}
	}
	
	private void spawnGolem(World world, int x, int y, int z, EntityGolems golem, int blocksTall, boolean hasArmsOnXAxis) {
		setAirBlocks(world, x, y, z, blocksTall, hasArmsOnXAxis);
		
		golem.setPlayerCreated(true);
		golem.setLocationAndAngles((double)x + 0.5d, (double)y - (blocksTall) + 0.05d, z, 0.0f, 0.0f);
        world.spawnEntityInWorld(golem);
        notifyBlockChange(world, x, y, z, blocksTall, hasArmsOnXAxis);
	}
	
	/**
	 * Sets the golem blocks to air. If clearXAxis is false, clears the z axis.
	 */
	private void setAirBlocks(World world, int x, int y, int z, int blocksTall, boolean clearXAxis) {
		
		for (int i = 0; i <= blocksTall; i++)
			world.setBlock(x, y - i, z, Blocks.air);
		
		if (this.isAssociatedBlock(CoreBlocks.foolsRubyGolemHead)) {
			return;
		}
		else {
			
			if (clearXAxis) {
				world.setBlock(x - 1, y - 1, z, Blocks.air);
				world.setBlock(x + 1, y - 1, z, Blocks.air);
			}
			else {
				world.setBlock(x, y - 1, z - 1, Blocks.air);
				world.setBlock(x, y - 1, z + 1, Blocks.air);
			}
		}
	}
	
	private void notifyBlockChange(World world, int x, int y, int z, int blocksTall, boolean xAxis) {
		
		for (int i = 0; i <= blocksTall; i++)
			world.notifyBlockChange(x, y - i, z, Blocks.air);
		
		if (this.isAssociatedBlock(CoreBlocks.foolsRubyGolemHead)) {
			return;
		}
		else {
			if (xAxis) {
				world.notifyBlockChange(x - 1, y - 1, z, Blocks.air);
				world.notifyBlockChange(x + 1, y - 1, z, Blocks.air);
			}
			else {
				world.notifyBlockChange(x, y - 1, z - 1, Blocks.air);
				world.notifyBlockChange(x, y - 1, z + 1, Blocks.air);
			}
		}
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        int metadata = determineOrientation(world, x, y, z, entity);
        world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.blockIcon = icon.registerIcon(String.format("%s%s%s", COPackManager.corePack.getPackID(), ":", textureName + "_side"));
		this.frontIcon = icon.registerIcon(String.format("%s%s%s", COPackManager.corePack.getPackID(), ":", textureName + "_front"));
		
		for (int i = 0; i < 4; i++)
			this.topIcon[i] = icon.registerIcon(String.format("%s%s%s", COPackManager.corePack.getPackID(), ":", textureName + "_top_" + i));
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getRotatedIcon(int meta) {
		
		switch (meta) {
		case 2: return this.topIcon[0];
		case 3: return this.topIcon[2];
		case 4: return this.topIcon[3];
		default: case 5: return this.topIcon[1];
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
		
		if (metadata == 0 && side == 3) return this.frontIcon;
		if (metadata == 0 && side == 1) return this.topIcon[2];
		
		int k = getBlockOrientation(metadata);
		return side == k ? this.frontIcon : side == 0 || side == 1 ? this.getRotatedIcon(metadata) : this.blockIcon;
    }
	
	public static int determineOrientation(World p_150071_0_, int x, int y, int z, EntityLivingBase entity) {
        int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        return l == 0 ? 2 : (l == 1 ? 5 : (l == 2 ? 3 : (l == 3 ? 4 : 0)));
    }
	
	public static int getBlockOrientation(int p_150076_0_) {
        return p_150076_0_ & 7;
    }
}

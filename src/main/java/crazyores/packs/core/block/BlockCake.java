package crazyores.packs.core.block;

import java.util.Random;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import crazyores.manager.pack.COPackManager;
import crazyores.packs.core.item.CoreItems;
import crazyores.packs.core.tabs.CoreTabList;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCake extends CoreBlock {

	@SideOnly(Side.CLIENT)
    private IIcon innerIcon;
    @SideOnly(Side.CLIENT)
    private IIcon topIcon;
    @SideOnly(Side.CLIENT)
    private IIcon bottomIcon;
    
    private String blockName;
    private int slices;
    
	protected BlockCake(String unlocalizedName, String type, int slices) {
		super(unlocalizedName, Material.CAKE);
		this.setHardness(0.5f);
		this.setStepSound(soundTypeCloth);
		blockName = type + "_cake";
		this.setTickRandomly(true);
		this.slices = slices;
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
        int l = blockAccess.getBlockMetadata(x, y, z);
        float f = 0.0625F;
//        float f1 = (float)(1 + l * 2) / 16.0F;
        float slice = 14f / slices;
        float f1 = (float)(1 + slice * l) / 16f;
        float f2 = 0.5F;
        this.setBlockBounds(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
    }
	
	@Override
	public void setBlockBoundsForItemRender() {
        float f = 0.0625F;
        float f1 = 0.5F;
        this.setBlockBounds(f, 0.0F, f, 1.0F - f, f1, 1.0F - f);
    }
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        int l = world.getBlockMetadata(x, y, z);
        float f = 0.0625F;
//        float f1 = (float)(1 + l * 2) / 16.0F;
        
        float slice = 14f / slices;
        float f1 = (float)(1 + slice * l) / 16f;
        float f2 = 0.5F;
        return AxisAlignedBB.getBoundingBox((double)((float)x + f1), (double)y, (double)((float)z + f), (double)((float)(x + 1) - f), (double)((float)y + f2 - f), (double)((float)(z + 1) - f));
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
        int l = world.getBlockMetadata(x, y, z);
        float f = 0.0625F;
//        float f1 = (float)(1 + l * 2) / 16.0F;
        float slice = 14f / slices;
        float f1 = (float)(1 + slice * l) / 16f;
        float f2 = 0.5F;
        return AxisAlignedBB.getBoundingBox((double)((float)x + f1), (double)y, (double)((float)z + f), (double)((float)(x + 1) - f), (double)((float)y + f2), (double)((float)(z + 1) - f));
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        return side == 1 ? this.topIcon : (side == 0 ? this.bottomIcon : (metadata > 0 && side == 4 ? this.innerIcon : this.blockIcon));
    }

	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
		this.topIcon = iconRegister.registerIcon(String.format("%s%s%s", COPackManager.corePack.getPackID(), ":", blockName + "_top"));
		
        this.blockIcon = iconRegister.registerIcon(String.format("%s%s%s", COPackManager.corePack.getPackID(), ":", blockName + "_side"));
        this.innerIcon = iconRegister.registerIcon(String.format("%s%s%s", COPackManager.corePack.getPackID(), ":", blockName + "_inner"));
        this.bottomIcon = iconRegister.registerIcon(String.format("%s%s%s", COPackManager.corePack.getPackID(), ":", "vanilla_cake_bottom"));
    }
	
	@Override
	public boolean renderAsNormalBlock() {
        return false;
    }
	
	@Override
	public boolean isOpaqueCube() {
        return false;
    }
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        this.updateCake(world, x, y, z, player);
        return true;
    }
	
	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
        this.updateCake(world, x, y, z, player);
    }
	
	private void updateCake(World world, int x, int y, int z, EntityPlayer player) {
		if (player.canEat(false)) {
        	player.getFoodStats().addStats(2, 0.1F);
            
            int l = world.getBlockMetadata(x, y, z) + 1;
            
        	if (l >= slices)
        		world.setBlockToAir(x, y, z);
        	else
        		world.setBlockMetadataWithNotify(x, y, z, l, 2);
		}
    }
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return !super.canPlaceBlockAt(world, x, y, z) ? false : this.canBlockStay(world, x, y, z);
    }
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if (!this.canBlockStay(world, x, y, z)) {
            world.setBlockToAir(x, y, z);
        }
    }
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
        return world.getBlock(x, y - 1, z).getMaterial().isSolid();
    }
	
	@Override
	public int quantityDropped(Random rand) {
        return 0;
    }
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return null;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z) {
		Block b = world.getBlock(x, y, z);
		
		if (b.isAssociatedBlock(CoreBlocks.chocolateCake)) {
			return CoreItems.chocolateCake;
		}
		else if (b.isAssociatedBlock(CoreBlocks.strawberryCake)) {
			return CoreItems.strawberryCake;
		}
		else if (b.isAssociatedBlock(CoreBlocks.birthdayCake)) {
			return CoreItems.birthdayCake;
		}
		return null;
    }
}


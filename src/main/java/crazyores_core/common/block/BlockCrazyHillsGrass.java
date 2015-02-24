package crazyores_core.common.block;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores_core.common.tab.COTabList;
import crazyores_core.util.ICOName;
import crazyores_core.util.TextureManager;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCrazyHillsGrass extends COBlock {

    @SideOnly(Side.CLIENT)
    private IIcon sideTexture;
    @SideOnly(Side.CLIENT)
    private IIcon snowSideTexture;
	
	protected BlockCrazyHillsGrass() {
		super(Material.grass);
		this.setStepSound(Block.soundTypeGrass);
		this.setTickRandomly(true);
        this.setCreativeTab(COTabList.CO_BLOCKS);
	}
	
	/**
     * Ticks the block if it's been scheduled
     */
	@Override
    public void updateTick(World world, int x, int y, int z, Random random) {
       
		if (!world.isRemote)  {
            if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2) {
            	world.setBlock(x, y, z, BlockList.crazyhills_dirt);
            }
            else if (world.getBlockLightValue(x, y + 1, z) >= 9) {
            	
            	for (int l = 0; l < 4; ++l) {
                    int newX = x + random.nextInt(3) - 1;
                    int newZ = z + random.nextInt(3) - 1;

                    if (world.getBlock(newX, y, newZ) == BlockList.crazyhills_dirt && 
                    	world.getBlockLightValue(newX, y + 1, newZ) >= 3 && 
                    	world.getBlockLightOpacity(newX, y + 1, newZ) <= 2) {
                    	
                    	world.setBlock(newX, y, newZ, BlockList.crazyhills_grass);
                    }
                }
            }
        }
    }
	
	@Override
	public Item getItemDropped(int metaData, Random rand, int fortuneLevel) {
        return BlockList.crazyhills_dirt.getItemDropped(0, rand, fortuneLevel);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        return side == 1 ? this.sideTexture : (side == 0 ? BlockList.crazyhills_dirt.getBlockTextureFromSide(side) : this.blockIcon);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(String.format("%s%s%s", TextureManager.RESOURCE_PREFIX, TextureManager.DREAMSTATE_PREFIX, this.parsePrefix(this.getReadableName(), '.')) + "_side");
        this.sideTexture = iconRegister.registerIcon(String.format("%s%s%s", TextureManager.RESOURCE_PREFIX, TextureManager.DREAMSTATE_PREFIX, this.parsePrefix(this.getReadableName(), '.')) + "_top");
        this.snowSideTexture = iconRegister.registerIcon(String.format("%s%s%s", TextureManager.RESOURCE_PREFIX, TextureManager.DREAMSTATE_PREFIX, this.parsePrefix(this.getReadableName(), '.')) + "_side_snowed");
    }
}

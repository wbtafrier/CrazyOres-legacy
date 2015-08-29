package crazyores.packs.core.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.support.IName;
import crazyores.manager.tabs.COTabList;

public class BlockLuminiteStorage extends CoreGlass implements IName {
	
	public static final String[] LUMINITE_STORAGE_BLOCK_SUBTYPES = new String[] {"white", "red", "orange", "yellow", "green", "cyan", "blue", "purple", "pink", "black"};
	
	/**
	 * Private variables.
	 */
	@SideOnly(Side.CLIENT)
	private IIcon[] blockTexture;
	
	/**
	 * Constructor: Default Constructor
	 */
	public BlockLuminiteStorage(String unlocalizedName, float hardness, float resistance) {
		super(unlocalizedName, true, hardness, resistance);
		this.setLightLevel(0.8f);
	}
	
	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}
	
	/**
	 * Adds the luminite blocks to the game.
	 */
	@Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
		for (int metadata = 0; metadata < LUMINITE_STORAGE_BLOCK_SUBTYPES.length; metadata++) {
			list.add(new ItemStack(item, 1, metadata));
		}
	}

	/**
	 * Sets the image name for the block.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockTexture = new IIcon[LUMINITE_STORAGE_BLOCK_SUBTYPES.length];
		
		for (int i = 0; i < LUMINITE_STORAGE_BLOCK_SUBTYPES.length; i++) {
			this.blockTexture[i] = iconRegister.registerIcon((String.format("%s%s%s_%s", COPackManager.corePack.getPackID(), ":", this.blockUnlocalizedName, LUMINITE_STORAGE_BLOCK_SUBTYPES[i])));
		}
	}
	
	/**
	 * Sets the icon to the appropriate luminite block.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		//clamp_int sends in metadata amount, lowest limit, highest limit, and returns the highest limit if metadata goes over it.
		metadata = MathHelper.clamp_int(metadata, 0, LUMINITE_STORAGE_BLOCK_SUBTYPES.length - 1);
		return this.blockTexture[metadata];
	}
}

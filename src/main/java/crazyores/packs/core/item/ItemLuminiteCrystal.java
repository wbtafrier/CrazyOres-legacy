package crazyores.packs.core.item;

import java.util.List;

import javax.swing.Icon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.tabs.COTabList;
import crazyores.packs.core.block.BlockLuminiteStorage;

public class ItemLuminiteCrystal extends CoreItem {

	public static final String[] LUMINITE_CRYSTAL_SUBTYPES = new String[] {"white", "red", "orange", "yellow", "green", "cyan", "blue", "purple", "pink", "black"};
	
	/**
	 * Private variables.
	 */
	@SideOnly(Side.CLIENT)
	private IIcon[] itemTexture;
	
	public ItemLuminiteCrystal(String unlocalizedName) {
		super(unlocalizedName);
		this.setHasSubtypes(true);
		this.setCreativeTab(COTabList.crazyOresItemsTab);
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
	    for (int metadata = 0; metadata < LUMINITE_CRYSTAL_SUBTYPES.length; metadata++) {
	        list.add(new ItemStack(item, 1, metadata));
	    }
	}
	
	/**
	 * Sets the image name for the block.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemTexture = new IIcon[LUMINITE_CRYSTAL_SUBTYPES.length];
		
		for (int i = 0; i < LUMINITE_CRYSTAL_SUBTYPES.length; i++) {
			this.itemTexture[i] = iconRegister.registerIcon((String.format("%s%s%s_%s", COPackManager.corePack.getPackID(), ":", this.itemUnlocalizedName, LUMINITE_CRYSTAL_SUBTYPES[i])));
		}
	}
	
	/**
	 * Sets the icon to the appropriate luminite block.
	 */
	@Override
	public IIcon getIconFromDamage(int metadata) {
		return itemTexture[metadata];
	}
	
	@Override
	public int getMetadata(int damageValue) {
		damageValue = MathHelper.clamp_int(damageValue, 0, LUMINITE_CRYSTAL_SUBTYPES.length - 1);
		return damageValue;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return super.getUnlocalizedName() + "_" + LUMINITE_CRYSTAL_SUBTYPES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, LUMINITE_CRYSTAL_SUBTYPES.length - 1)];
	}	
}

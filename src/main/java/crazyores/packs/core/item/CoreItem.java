package crazyores.packs.core.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.support.IName;

public class CoreItem extends Item implements IName {

	public String itemUnlocalizedName;
	
	/**
	 * Constructor for the CoreItem class.
	 * @param unlocalizedName
	 */
	protected CoreItem(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
	}
	
	/**
	 * Constructor for the CoreItem class.
	 * @param unlocalizedName
	 * @param tab
	 */
	protected CoreItem(String unlocalizedName, CreativeTabs tab) {
		this(unlocalizedName);
		super.setCreativeTab(tab);
	}
	
	/**
	 * Constructor for the CoreItem class.
	 * @param unlocalizedName
	 * @param tab
	 * @param maxStackSize
	 */
	protected CoreItem(String unlocalizedName, CreativeTabs tab, int maxStackSize) {
		this(unlocalizedName, tab);
		super.setMaxStackSize(maxStackSize);
	}

	@Override
	public Item setUnlocalizedName(String unlocalizedName) {
		this.itemUnlocalizedName = unlocalizedName;
        return this;
    }
	
	@Override
	public String getUnlocalizedName() {
		return itemUnlocalizedName;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
        return itemUnlocalizedName;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(String.format("%s%s%s", COPackManager.corePack.getPackID(), ":", this.getUnlocalizedName()));
    }
}

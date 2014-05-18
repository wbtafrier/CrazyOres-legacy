package crazyores_core.common.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores_core.common.items.ItemList;

public class COWeaponTab extends CreativeTabs 
{	
	public COWeaponTab(int par1, String par2Str)
	{
		super(par1, par2Str);
	}
	
	@SideOnly(Side.CLIENT)
    public Item getTabIconItem() 
	{
        return ItemList.adamite_sword;
    }

}

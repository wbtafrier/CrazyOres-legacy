package crazyores_core.common.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores_core.common.blocks.BlockList;

public class COBlockTab extends CreativeTabs 
{	
	public COBlockTab(int par1, String par2Str)
	{
		super(par1, par2Str);
	}
	
	@SideOnly(Side.CLIENT)
    public Item getTabIconItem() 
	{
        return Item.getItemFromBlock(BlockList.ender_block);
    }

}

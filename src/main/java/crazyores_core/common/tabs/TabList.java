package crazyores_core.common.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores_core.common.blocks.BlockList;
import crazyores_core.common.core.COData;
import crazyores_core.common.items.ItemList;

public class TabList 
{
	public static final String CO_PREFIX = COData.modID + "_";
	
	public static final CreativeTabs COBlocks = new CreativeTabs(CreativeTabs.getNextID(), CO_PREFIX + "blocks")
	{
		@SideOnly(Side.CLIENT)
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(BlockList.meteorite_ore);
        }
	};
	
	public static final CreativeTabs COMaterials = new CreativeTabs(CreativeTabs.getNextID(), CO_PREFIX + "materials")
	{
		@SideOnly(Side.CLIENT)
	    public Item getTabIconItem() 
		{
	        return ItemList.copper_ingot;
	    }
	};
	
	public static final CreativeTabs COCombat = new CreativeTabs(CreativeTabs.getNextID(), CO_PREFIX + "combat")
	{

		@SideOnly(Side.CLIENT)
	    public Item getTabIconItem() 
		{
	        return ItemList.adamite_sword;
	    }
	};
	
	public static final CreativeTabs COArmor = new CreativeTabs(CreativeTabs.getNextID(), CO_PREFIX + "armor")
	{
		@SideOnly(Side.CLIENT)
	    public Item getTabIconItem() 
		{
	        return ItemList.zectium_chestplate;
	    }
	};
	
	public static final CreativeTabs COTools = new CreativeTabs(CreativeTabs.getNextID(), CO_PREFIX + "tools")
	{
		@SideOnly(Side.CLIENT)
	    public Item getTabIconItem() 
		{
	        return ItemList.osmonium_pickaxe;
	    }
	};
	
	public static final CreativeTabs COMisc = new CreativeTabs(CreativeTabs.getNextID(), CO_PREFIX + "misc")
	{
		@SideOnly(Side.CLIENT)
	    public Item getTabIconItem() 
		{
	        return ItemList.copper_bucket_lava;
	    }
	};
}

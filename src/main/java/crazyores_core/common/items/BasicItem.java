package crazyores_core.common.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import crazyores_core.common.core.COData;
import crazyores_core.common.tabs.TabList;

public class BasicItem extends Item 
{
	
	private static String oreDictName = null;
	
	public BasicItem() 
	{
		this(TabList.COMaterials);
	}
	
	public BasicItem(CreativeTabs tab) 
	{
		super();
		this.setCreativeTab(tab);
	}
	
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase entityliving1)
	{
		if (this == ItemList.invisium_rod || this == ItemList.invisium_ingot
			|| this == ItemList.invisium_arrow)
		{
			entityliving.addPotionEffect(new PotionEffect(Potion.invisibility.id, 1000, 1));
			return true;
		}
		return false;
	}
	
	public void setOreDictName(String s) {
		this.oreDictName = s;
	}
	
	public String getOreDictName() {
		return this.oreDictName;
	}
}

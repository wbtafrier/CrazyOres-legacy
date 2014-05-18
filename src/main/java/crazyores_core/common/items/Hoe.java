package crazyores_core.common.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import crazyores_core.common.core.COData;
import crazyores_core.common.tabs.TabList;

public class Hoe extends ItemHoe
{
	public Hoe(ItemTool.ToolMaterial toolType) 
	{
		super(toolType);
		this.setCreativeTab(TabList.COTools);
	}
	
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase entityliving1)
	{
		if (this == ItemList.meteorite_hoe)
		{
			entityliving.setFire(8);
			itemstack.damageItem(2, entityliving1);
			return true;
		}
		else if(this == ItemList.invisium_hoe)
		{
			entityliving.addPotionEffect(new PotionEffect(Potion.invisibility.id, 1000, 1));
			itemstack.damageItem(2, entityliving1);
			return true;
		}
		return super.hitEntity(itemstack, entityliving, entityliving1);
	}
	
}

package crazyores_core.common.items;


import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import crazyores_core.common.core.COData;
import crazyores_core.common.tabs.TabList;

public class Armor extends ItemArmor
{
	public boolean invisium = false;

	public Armor(ItemArmor.ArmorMaterial par2ArmorMaterial, int par3, int par4) 
	{
		super(par2ArmorMaterial, par3, par4);
		this.setCreativeTab(TabList.COArmor);
	}

	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type)
	{
		if (itemstack.getItem() == ItemList.meteorite_helmet || itemstack.getItem() == ItemList.meteorite_chestplate || itemstack.getItem() == ItemList.meteorite_boots)
		{
			return COData.modID + ":" + "textures/armor/Meteorite_1.png";
		}
		if (itemstack.getItem() == ItemList.meteorite_leggings)
		{
			return COData.modID + ":" + "textures/armor/Meteorite_2.png";
		}
		if (itemstack.getItem() == ItemList.copper_helmet || itemstack.getItem() == ItemList.copper_chestplate || itemstack.getItem() == ItemList.copper_boots)
		{
			return COData.modID + ":" + "textures/armor/Copper_1.png";
		}
		if (itemstack.getItem() == ItemList.copper_leggings)
		{
			return COData.modID + ":" + "textures/armor/Copper_2.png";
		}
		if (itemstack.getItem() == ItemList.sapphire_helmet || itemstack.getItem() == ItemList.sapphire_chestplate || itemstack.getItem() == ItemList.sapphire_boots)
		{
			return COData.modID + ":" + "textures/armor/Sapphire_1.png";
		}
		if (itemstack.getItem() == ItemList.sapphire_leggings)
		{
			return COData.modID + ":" + "textures/armor/Sapphire_2.png";
		}
		if (itemstack.getItem() == ItemList.invisium_helmet || itemstack.getItem() == ItemList.invisium_chestplate || itemstack.getItem() == ItemList.invisium_boots)
		{
//			if (!this.invisium)
				return COData.modID + ":" + "textures/armor/Invisium_1.png";
//			else if (invisium)
//				return COData.modID + ":" + "textures/armor/Invisium_3.png";
		}
		if (itemstack.getItem() == ItemList.invisium_leggings)
		{
//			if (!this.invisium)
				return COData.modID + ":" + "textures/armor/Invisium_2.png";
//			else if (invisium)
//				return COData.modID + ":" + "textures/armor/Invisium_3.png";
		}
		if (itemstack.getItem() == ItemList.adamite_helmet || itemstack.getItem() == ItemList.adamite_chestplate || itemstack.getItem() == ItemList.adamite_boots)
		{
			return COData.modID + ":" + "textures/armor/Adamite_1.png";
		}
		if (itemstack.getItem() == ItemList.adamite_leggings)
		{
			return COData.modID + ":" + "textures/armor/Adamite_2.png";
		}
		if (itemstack.getItem() == ItemList.ruby_helmet || itemstack.getItem() == ItemList.ruby_chestplate || itemstack.getItem() == ItemList.ruby_boots)
		{
			return COData.modID + ":" + "textures/armor/Ruby_1.png";
		}
		if (itemstack.getItem() == ItemList.ruby_leggings)
		{
			return COData.modID + ":" + "textures/armor/Ruby_2.png";
		}
		if (itemstack.getItem() == ItemList.zectium_helmet || itemstack.getItem() == ItemList.zectium_chestplate || itemstack.getItem() == ItemList.zectium_boots)
		{
			return COData.modID + ":" + "textures/armor/Zectium_1.png";
		}
		if (itemstack.getItem() == ItemList.zectium_leggings)
		{
			return COData.modID + ":" + "textures/armor/Zectium_2.png";
		}
		if (itemstack.getItem() == ItemList.tapazite_helmet || itemstack.getItem() == ItemList.tapazite_chestplate || itemstack.getItem() == ItemList.tapazite_boots)
		{
			return COData.modID + ":" + "textures/armor/Tapazite_1.png";
		}
		if (itemstack.getItem() == ItemList.tapazite_leggings)
		{
			return COData.modID + ":" + "textures/armor/Tapazite_2.png";
		}
		if (itemstack.getItem() == ItemList.crystal_helmet || itemstack.getItem() == ItemList.crystal_chestplate || itemstack.getItem() == ItemList.crystal_boots)
		{
			return COData.modID + ":" + "textures/armor/Crystal_1.png";
		}
		if (itemstack.getItem() == ItemList.crystal_leggings)
		{
			return COData.modID + ":" + "textures/armor/Crystal_2.png";
		}
		if (itemstack.getItem() == ItemList.osmonium_helmet || itemstack.getItem() == ItemList.osmonium_chestplate || itemstack.getItem() == ItemList.osmonium_boots)
		{
			return COData.modID + ":" + "textures/armor/Osmonium_1.png";
		}
		if (itemstack.getItem() == ItemList.osmonium_leggings)
		{
			return COData.modID + ":" + "textures/armor/Osmonium_2.png";
		}
		if (itemstack.getItem() == ItemList.starconium_helmet || itemstack.getItem() == ItemList.starconium_chestplate || itemstack.getItem() == ItemList.starconium_boots)
		{
			return COData.modID + ":" + "textures/armor/Starconium_1.png";
		}
		if (itemstack.getItem() == ItemList.starconium_leggings)
		{
			return COData.modID + ":" + "textures/armor/Starconium_2.png";
		}
		if (itemstack.getItem() == ItemList.ender_helmet || itemstack.getItem() == ItemList.ender_chestplate || itemstack.getItem() == ItemList.ender_boots)
		{
			return COData.modID + ":" + "textures/armor/Ender_1.png";
		}
		if (itemstack.getItem() == ItemList.ender_leggings)
		{
			return COData.modID + ":" + "textures/armor/Ender_2.png";
		}
		return COData.modID + ":" + "textures/armor/Copper_1.png";
	}
	
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase entityliving1)
	{
		if(this == ItemList.invisium_helmet || this == ItemList.invisium_chestplate || this == ItemList.invisium_leggings || this == ItemList.invisium_boots)
		{
			entityliving.addPotionEffect(new PotionEffect(Potion.invisibility.id, 1000, 1));
		}
		return false;
	}

	public void setInvisiumEffect(boolean effect)
	{
		this.invisium = effect;
	}

	public boolean getInvisiumEffect()
	{
		return this.invisium;
	}

}

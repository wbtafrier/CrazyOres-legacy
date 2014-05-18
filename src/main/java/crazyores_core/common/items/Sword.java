package crazyores_core.common.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import crazyores_core.common.core.COData;
import crazyores_core.common.tabs.TabList;

public class Sword extends ItemSword
{
	public Sword(ItemTool.ToolMaterial toolType) 
	{
		super(toolType);
		this.setCreativeTab(TabList.COCombat);
	}

	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase entityliving1)
	{
		if (this == ItemList.meteorite_sword)
		{
			entityliving.setFire(8);
			itemstack.damageItem(1, entityliving1);
			return true;
		}
		else if(this == ItemList.invisium_sword)
		{
			entityliving.addPotionEffect(new PotionEffect(Potion.invisibility.id, 1000, 1));
			itemstack.damageItem(1, entityliving1);
			return true;
		}
		return super.hitEntity(itemstack, entityliving, entityliving1);
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if (this == ItemList.meteorite_sword)
		{
			if (par7 == 0)
			{
				--par5;
			}

			if (par7 == 1)
			{
				++par5;
			}

			if (par7 == 2)
			{
				--par6;
			}

			if (par7 == 3)
			{
				++par6;
			}

			if (par7 == 4)
			{
				--par4;
			}

			if (par7 == 5)
			{
				++par4;
			}

			if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
			{
				if (par3World.isAirBlock(par4, par5, par6))
				{
					par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
					par3World.setBlock(par4, par5, par6, Blocks.fire);
				}

				par1ItemStack.damageItem(1, par2EntityPlayer);
				return true;
			}
		}
		return super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10);
	}

}

package crazyores.packs.core.item;

import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.support.IName;
import crazyores.packs.core.tabs.CoreTabList;

public class CorePickaxe extends ItemPickaxe implements IName {
	
	public String itemUnlocalizedName;

	protected CorePickaxe(String unlocalizedName, ToolMaterial toolMaterial) {
		super(toolMaterial);
		itemUnlocalizedName = unlocalizedName;
		setCreativeTab(CoreTabList.crazyOresToolsTab);
//		ReflectionHelper.setPrivateValue(ItemTool.class, this, "hammer", 5);
	}
	
	@Override
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase entityliving1)
	{
		if (this == CoreItems.meteoritePickaxe)
		{
			entityliving.setFire(8);
			itemstack.damageItem(2, entityliving1);
			return true;
		}
//		else if(this == CoreItems.invisium_pickaxe)
//		{
//			entityliving.addPotionEffect(new PotionEffect(Potion.invisibility.id, 1000, 1));
//			itemstack.damageItem(2, entityliving1);
//			return true;
//		}
		return super.hitEntity(itemstack, entityliving, entityliving1);
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (this == CoreItems.meteoritePickaxe) {
			if (par7 == 0) {
				--par5;
			}

			if (par7 == 1) {
				++par5;
			}

			if (par7 == 2) {
				--par6;
			}

			if (par7 == 3) {
				++par6;
			}

			if (par7 == 4) {
				--par4;
			}

			if (par7 == 5) {
				++par4;
			}

			if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
				if (par3World.isAirBlock(par4, par5, par6)) {
					par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
					par3World.setBlock(par4, par5, par6, Blocks.fire);
				}
				par1ItemStack.damageItem(1, par2EntityPlayer);
				return true;
			}
		}
		return super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10);
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

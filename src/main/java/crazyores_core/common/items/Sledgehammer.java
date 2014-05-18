package crazyores_core.common.items;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import crazyores_core.common.core.COData;
import crazyores_core.common.tabs.TabList;

public class Sledgehammer extends ItemTool
{

	public static Set blocksEffectiveAgainst = Block.blockRegistry.getKeys();

	public Sledgehammer(float i, Item.ToolMaterial toolmaterial)
	{

		super(i, toolmaterial, blocksEffectiveAgainst);
		toolMaterial = toolmaterial;
		maxStackSize = 1;
		setMaxDamage(toolmaterial.getMaxUses());
		weaponDamage = 4 + toolmaterial.getDamageVsEntity();
		this.setCreativeTab(TabList.COTools);
	}
	
	@Override
	public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
        return this.efficiencyOnProperMaterial;
    }

	@Override
	public boolean func_150897_b(Block block)
	{
		if (block != Blocks.leaves && block != Blocks.snow)
		{
			return true;
		}
		return false;
	}

	private float weaponDamage;

	@Override
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entitylivingbase, EntityLivingBase entitylivingbase1)
	{
		itemstack.damageItem(1, entitylivingbase1);
		return true;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack itemstack, World world, Block i, int j, int k, int l, EntityLivingBase entitylivingbase)
	{
		itemstack.damageItem(2, entitylivingbase);
		return true;
	}

	@Override
	public boolean isFull3D()
	{
		return true;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack itemstack)
	{
		return EnumAction.block;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemstack)
	{
		return 0x11940;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		entityplayer.setItemInUse(itemstack, getMaxItemUseDuration(itemstack));
		return itemstack;
	}

	@Override
	public int getItemEnchantability()
	{
		return toolMaterial.getEnchantability();
	}

}

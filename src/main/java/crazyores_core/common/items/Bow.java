package crazyores_core.common.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores_core.common.core.COData;
import crazyores_core.common.entity.EntityAdamiteArrow;
import crazyores_core.common.entity.EntityArrows;
import crazyores_core.common.entity.EntityCopperArrow;
import crazyores_core.common.entity.EntityCrystalArrow;
import crazyores_core.common.entity.EntityEnderArrow;
import crazyores_core.common.entity.EntityInvisiumArrow;
import crazyores_core.common.entity.EntityMeteoriteArrow;
import crazyores_core.common.entity.EntityOsmoniumArrow;
import crazyores_core.common.entity.EntityRubyArrow;
import crazyores_core.common.entity.EntitySapphireArrow;
import crazyores_core.common.entity.EntityStarconiumArrow;
import crazyores_core.common.entity.EntityTapaziteArrow;
import crazyores_core.common.entity.EntityZectiumArrow;
import crazyores_core.common.tabs.TabList;

public class Bow extends Item
{
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	public Bow(int damage)
	{
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(damage);
		this.setCreativeTab(TabList.COCombat);
	}
	
	public boolean isFull3D()
	{
		return true;
	}

	/**
	 * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
	 */
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
	{
		int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

		ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
		{
			return;
		}
		j = event.charge;

		boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

		float f = (float)j / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;

		if ((double)f < 0.1D)
		{
			return;
		}

		if (f > 1.0F)
		{
			f = 1.0F;
		}
		
		EntityArrows entityArrow = new EntityArrows(par2World, par3EntityPlayer, f * 2.0F);
		
		if ((flag || par3EntityPlayer.inventory.hasItem(ItemList.starconium_arrow))
				&& this == ItemList.starconium_bow)
		{
			
			EntityStarconiumArrow starconium = new EntityStarconiumArrow(par2World, par3EntityPlayer, f * 2.0F); 

			entityArrow = this.createArrow(par1ItemStack, par2World, par3EntityPlayer, f, 
					starconium, false);
			
			if (flag)
			{
				entityArrow.canBePickedUp = 2;
			}
			else
			{
				par3EntityPlayer.inventory.consumeInventoryItem(ItemList.starconium_arrow);
			}

			if (!par2World.isRemote)
			{
				par2World.spawnEntityInWorld(entityArrow);
			}
		}
		else if ((flag || par3EntityPlayer.inventory.hasItem(ItemList.ender_arrow))
				&& (this == ItemList.starconium_bow || this == ItemList.ender_bow))
		{
			
			EntityEnderArrow ender = new EntityEnderArrow(par2World, par3EntityPlayer, f * 2.0F); 

			entityArrow = this.createArrow(par1ItemStack, par2World, par3EntityPlayer, f, 
					ender, false);
			
			if (flag)
			{
				entityArrow.canBePickedUp = 2;
			}
			else
			{
				par3EntityPlayer.inventory.consumeInventoryItem(ItemList.ender_arrow);
			}

			if (!par2World.isRemote)
			{
				par2World.spawnEntityInWorld(entityArrow);
			}
		}
		else if ((flag || par3EntityPlayer.inventory.hasItem(ItemList.osmonium_arrow))
				&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
					|| this == ItemList.osmonium_bow))
		{
			
			EntityOsmoniumArrow osmonium = new EntityOsmoniumArrow(par2World, par3EntityPlayer, f * 2.0F); 

			entityArrow = this.createArrow(par1ItemStack, par2World, par3EntityPlayer, f, 
					osmonium, false);
			
			if (flag)
			{
				entityArrow.canBePickedUp = 2;
			}
			else
			{
				par3EntityPlayer.inventory.consumeInventoryItem(ItemList.osmonium_arrow);
			}

			if (!par2World.isRemote)
			{
				par2World.spawnEntityInWorld(entityArrow);
			}
		}
		else if ((flag || par3EntityPlayer.inventory.hasItem(ItemList.crystal_arrow))
				&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
					|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow))
		{
			EntityCrystalArrow crystal = new EntityCrystalArrow(par2World, par3EntityPlayer, f * 2.0F);

			entityArrow = this.createArrow(par1ItemStack, par2World, par3EntityPlayer, f, 
					crystal, false);
			
			if (flag)
			{
				entityArrow.canBePickedUp = 2;
			}
			else
			{
				par3EntityPlayer.inventory.consumeInventoryItem(ItemList.crystal_arrow);
			}

			if (!par2World.isRemote)
			{
				par2World.spawnEntityInWorld(entityArrow);
			}
		}
		else if ((flag || par3EntityPlayer.inventory.hasItem(ItemList.tapazite_arrow))
				&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
					|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow
					|| this == ItemList.tapazite_bow))
		{
			EntityTapaziteArrow tapazite = new EntityTapaziteArrow(par2World, par3EntityPlayer, f * 2.0F);

			entityArrow = this.createArrow(par1ItemStack, par2World, par3EntityPlayer, f, 
					tapazite, false);
			
			if (flag)
			{
				entityArrow.canBePickedUp = 2;
			}
			else
			{
				par3EntityPlayer.inventory.consumeInventoryItem(ItemList.tapazite_arrow);
			}

			if (!par2World.isRemote)
			{
				par2World.spawnEntityInWorld(entityArrow);
			}
		}
		else if ((flag || par3EntityPlayer.inventory.hasItem(ItemList.zectium_arrow))
				&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
					|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow
					|| this == ItemList.tapazite_bow || this == ItemList.zectium_bow))
		{
			
			EntityZectiumArrow zectium = new EntityZectiumArrow(par2World, par3EntityPlayer, f * 2.0F);

			entityArrow = this.createArrow(par1ItemStack, par2World, par3EntityPlayer, f, 
					zectium, false);
			
			if (flag)
			{
				entityArrow.canBePickedUp = 2;
			}
			else
			{
				par3EntityPlayer.inventory.consumeInventoryItem(ItemList.zectium_arrow);
			}

			if (!par2World.isRemote)
			{
				par2World.spawnEntityInWorld(entityArrow);
			}
		}
		else if ((flag || par3EntityPlayer.inventory.hasItem(ItemList.ruby_arrow))
				&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
						|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow
						|| this == ItemList.tapazite_bow || this == ItemList.zectium_bow
						|| this == ItemList.ruby_bow))
		{
			
			EntityRubyArrow ruby = new EntityRubyArrow(par2World, par3EntityPlayer, f * 2.0F);

			entityArrow = this.createArrow(par1ItemStack, par2World, par3EntityPlayer, f, 
					ruby, false);
			
			if (flag)
			{
				entityArrow.canBePickedUp = 2;
			}
			else
			{
				par3EntityPlayer.inventory.consumeInventoryItem(ItemList.ruby_arrow);
			}

			if (!par2World.isRemote)
			{
				par2World.spawnEntityInWorld(entityArrow);
			}
		}
		else if ((flag || par3EntityPlayer.inventory.hasItem(ItemList.adamite_arrow))
				&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
						|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow
						|| this == ItemList.tapazite_bow || this == ItemList.zectium_bow
						|| this == ItemList.ruby_bow || this == ItemList.adamite_bow))
		{
			
			EntityAdamiteArrow adamite = new EntityAdamiteArrow(par2World, par3EntityPlayer, f * 2.0F);

			entityArrow = this.createArrow(par1ItemStack, par2World, par3EntityPlayer, f, 
					adamite, false);
			
			if (flag)
			{
				entityArrow.canBePickedUp = 2;
			}
			else
			{
				par3EntityPlayer.inventory.consumeInventoryItem(ItemList.adamite_arrow);
			}

			if (!par2World.isRemote)
			{
				par2World.spawnEntityInWorld(entityArrow);
			}
		}
		else if ((flag || par3EntityPlayer.inventory.hasItem(ItemList.sapphire_arrow))
				&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
					|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow
					|| this == ItemList.tapazite_bow || this == ItemList.zectium_bow
					|| this == ItemList.ruby_bow || this == ItemList.adamite_bow
					|| this == ItemList.sapphire_bow))
		{
			
			EntitySapphireArrow sapphire = new EntitySapphireArrow(par2World, par3EntityPlayer, f * 2.0F);

			entityArrow = this.createArrow(par1ItemStack, par2World, par3EntityPlayer, f, 
					sapphire, false);
			
			if (flag)
			{
				entityArrow.canBePickedUp = 2;
			}
			else
			{
				par3EntityPlayer.inventory.consumeInventoryItem(ItemList.sapphire_arrow);
			}

			if (!par2World.isRemote)
			{
				par2World.spawnEntityInWorld(entityArrow);
			}
		}
		else if ((flag || par3EntityPlayer.inventory.hasItem(ItemList.invisium_arrow))
				&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
					|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow
					|| this == ItemList.tapazite_bow || this == ItemList.zectium_bow
					|| this == ItemList.ruby_bow || this == ItemList.adamite_bow
					|| this == ItemList.sapphire_bow || this == ItemList.invisium_bow))
		{
			
			EntityInvisiumArrow invisium = new EntityInvisiumArrow(par2World, par3EntityPlayer, f * 2.0F);

			entityArrow = this.createArrow(par1ItemStack, par2World, par3EntityPlayer, f, 
					invisium, false);
			
			if (flag)
			{
				entityArrow.canBePickedUp = 2;
			}
			else
			{
				par3EntityPlayer.inventory.consumeInventoryItem(ItemList.invisium_arrow);
			}

			if (!par2World.isRemote)
			{
				par2World.spawnEntityInWorld(entityArrow);
			}
		}
		else if ((flag || par3EntityPlayer.inventory.hasItem(ItemList.copper_arrow))
				&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
						|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow
						|| this == ItemList.tapazite_bow || this == ItemList.zectium_bow
						|| this == ItemList.ruby_bow || this == ItemList.adamite_bow
						|| this == ItemList.sapphire_bow || this == ItemList.invisium_bow
						|| this == ItemList.copper_bow))
		{
			
			EntityCopperArrow copper = new EntityCopperArrow(par2World, par3EntityPlayer, f * 2.0F);

			entityArrow = this.createArrow(par1ItemStack, par2World, par3EntityPlayer, f, 
					copper, false);
			
			if (flag)
			{
				entityArrow.canBePickedUp = 2;
			}
			else
			{
				par3EntityPlayer.inventory.consumeInventoryItem(ItemList.copper_arrow);
			}

			if (!par2World.isRemote)
			{
				par2World.spawnEntityInWorld(entityArrow);
			}
		}
		else if ((flag || par3EntityPlayer.inventory.hasItem(ItemList.meteorite_arrow))
				&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
						|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow
						|| this == ItemList.tapazite_bow || this == ItemList.zectium_bow
						|| this == ItemList.ruby_bow || this == ItemList.adamite_bow
						|| this == ItemList.sapphire_bow || this == ItemList.invisium_bow 
						|| this == ItemList.copper_bow || this == ItemList.meteorite_bow))
		{
			
			EntityMeteoriteArrow meteorite = new EntityMeteoriteArrow(par2World, par3EntityPlayer, f * 2.0F);

			entityArrow = this.createArrow(par1ItemStack, par2World, par3EntityPlayer, f, 
					meteorite, true);
			
			if (flag)
			{
				entityArrow.canBePickedUp = 2;
			}
			else
			{
				par3EntityPlayer.inventory.consumeInventoryItem(ItemList.meteorite_arrow);
			}

			if (!par2World.isRemote)
			{
				par2World.spawnEntityInWorld(entityArrow);
			}
		}
		else if ((flag || par3EntityPlayer.inventory.hasItem(Items.arrow))
				&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
						|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow
						|| this == ItemList.tapazite_bow || this == ItemList.zectium_bow
						|| this == ItemList.ruby_bow || this == ItemList.adamite_bow
						|| this == ItemList.sapphire_bow || this == ItemList.invisium_bow
						|| this == ItemList.copper_bow || this == ItemList.meteorite_bow))
		{
            EntityArrow entityarrow = new EntityArrow(par2World, par3EntityPlayer, f * 2.0F);

            if (f == 1.0F)
            {
                entityarrow.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

            if (k > 0)
            {
                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

            if (l > 0)
            {
                entityarrow.setKnockbackStrength(l);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
            {
                entityarrow.setFire(100);
            }

            par1ItemStack.damageItem(1, par3EntityPlayer);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (flag)
            {
                entityarrow.canBePickedUp = 2;
            }
            else
            {
                par3EntityPlayer.inventory.consumeInventoryItem(Items.arrow);
            }

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(entityarrow);
            }
		}
	}
	
	private EntityArrows createArrow(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, float f, EntityArrows entityArrow, boolean meteorite)
	{
		if (f == 1.0F)
		{
			entityArrow.setIsCritical(true);
		}

		int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

		if (k > 0)
		{
			entityArrow.setDamage(entityArrow.getDamage() + (double)k * 0.5D + 0.5D);
		}

		int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

		if (l > 0)
		{
			entityArrow.setKnockbackStrength(l);
		}

		if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0 || meteorite)
		{
			entityArrow.setFire(100);
		}

		par1ItemStack.damageItem(1, par3EntityPlayer);
		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
		return entityArrow;
	}

	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		return par1ItemStack;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 72000;
	}

	/**
	 * returns the action that specifies what animation to play when the items is being used
	 */
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.bow;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
		{
			return event.result;
		}
		
		boolean flag = par3EntityPlayer.capabilities.isCreativeMode;

		if (flag ||
			(par3EntityPlayer.inventory.hasItem(ItemList.starconium_arrow)
			&& this == ItemList.starconium_bow)
			
			|| (par3EntityPlayer.inventory.hasItem(ItemList.ender_arrow)
			&& (this == ItemList.starconium_bow || this == ItemList.ender_bow))
			
			|| (par3EntityPlayer.inventory.hasItem(ItemList.osmonium_arrow)
			&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
			|| this == ItemList.osmonium_bow))
			
			|| (par3EntityPlayer.inventory.hasItem(ItemList.crystal_arrow)
			&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
			|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow))
			
			|| (par3EntityPlayer.inventory.hasItem(ItemList.tapazite_arrow)
			&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
			|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow
			|| this == ItemList.tapazite_bow))
			
			|| (par3EntityPlayer.inventory.hasItem(ItemList.zectium_arrow)
			&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
			|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow
			|| this == ItemList.tapazite_bow || this == ItemList.zectium_bow))
			
			|| (par3EntityPlayer.inventory.hasItem(ItemList.ruby_arrow)
			&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
			|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow
			|| this == ItemList.tapazite_bow || this == ItemList.zectium_bow
			|| this == ItemList.ruby_bow))
			
			|| (par3EntityPlayer.inventory.hasItem(ItemList.adamite_arrow)
			&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
			|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow
			|| this == ItemList.tapazite_bow || this == ItemList.zectium_bow
			|| this == ItemList.ruby_bow || this == ItemList.adamite_bow))
			
			|| (par3EntityPlayer.inventory.hasItem(ItemList.sapphire_arrow)
			&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
			|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow
			|| this == ItemList.tapazite_bow || this == ItemList.zectium_bow
			|| this == ItemList.ruby_bow || this == ItemList.adamite_bow
			|| this == ItemList.sapphire_bow))
			
			|| (par3EntityPlayer.inventory.hasItem(ItemList.invisium_arrow)
			&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
			|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow
			|| this == ItemList.tapazite_bow || this == ItemList.zectium_bow
			|| this == ItemList.ruby_bow || this == ItemList.adamite_bow
			|| this == ItemList.sapphire_bow || this == ItemList.invisium_bow))
			
			|| (par3EntityPlayer.inventory.hasItem(ItemList.copper_arrow)
			&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
			|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow
			|| this == ItemList.tapazite_bow || this == ItemList.zectium_bow
			|| this == ItemList.ruby_bow || this == ItemList.adamite_bow
			|| this == ItemList.sapphire_bow || this == ItemList.invisium_bow
			|| this == ItemList.copper_bow))
			
			|| (par3EntityPlayer.inventory.hasItem(ItemList.meteorite_arrow)
			&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
			|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow
			|| this == ItemList.tapazite_bow || this == ItemList.zectium_bow
			|| this == ItemList.ruby_bow || this == ItemList.adamite_bow
			|| this == ItemList.sapphire_bow || this == ItemList.invisium_bow
			|| this == ItemList.copper_bow || this == ItemList.meteorite_bow))
			
			|| (par3EntityPlayer.inventory.hasItem(Items.arrow)
			&& (this == ItemList.starconium_bow || this == ItemList.ender_bow
			|| this == ItemList.osmonium_bow || this == ItemList.crystal_bow
			|| this == ItemList.tapazite_bow || this == ItemList.zectium_bow
			|| this == ItemList.ruby_bow || this == ItemList.adamite_bow
			|| this == ItemList.sapphire_bow || this == ItemList.invisium_bow 
			|| this == ItemList.copper_bow || this == ItemList.meteorite_bow)))
		{
			par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		}

		return par1ItemStack;
	}
	
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase entityliving1)
	{
		if (this == ItemList.meteorite_bow)
		{
			entityliving.setFire(8);
			itemstack.damageItem(2, entityliving1);
			return true;
		}
		else if(this == ItemList.invisium_bow)
		{
			entityliving.addPotionEffect(new PotionEffect(Potion.invisibility.id, 1000, 1));
			itemstack.damageItem(2, entityliving1);
			return true;
		}
		return super.hitEntity(itemstack, entityliving, entityliving1);
	}

	/**
	 * Return the enchantability factor of the item, most of the time is based on material.
	 */
	public int getItemEnchantability()
	{
		return 1;
	}

	private IIcon[] Texture = new IIcon[4];
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister)

	{
		itemIcon = iconRegister.registerIcon(this.getIconString() + "_0");
		for (int N = 0; N < 4; N++)
		{
			this.Texture[N] = iconRegister.registerIcon(this.getIconString() + "_" + N);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		if(player.getItemInUse() == null) return this.itemIcon;
		int Pulling = stack.getMaxItemUseDuration() - useRemaining;
		if (Pulling >= 18)
		{
			return Texture[3];
		}
		else if (Pulling > 13)
		{
			return Texture[2];
		}
		else if (Pulling > 0)
		{
			return Texture[1];
		}              
		return Texture[0];
	}

	@SideOnly(Side.CLIENT)
	/**
	 * used to cycle through icons based on their used duration, i.e. for the bow
	 */
	public IIcon getItemIconForUseDuration(int par1)
	{
		return this.iconArray[par1];
	}
}

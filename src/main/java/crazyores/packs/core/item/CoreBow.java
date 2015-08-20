package crazyores.packs.core.item;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.support.IName;
import crazyores.packs.core.entity.arrow.CoreEntityArrow;
import crazyores.packs.core.entity.arrow.EntityElectricArrow;
import crazyores.packs.core.entity.arrow.EntityExplosiveArrow;
import crazyores.packs.core.entity.arrow.EntityFlamingArrow;
import crazyores.packs.core.entity.arrow.EntityFreezingArrow;
import crazyores.packs.core.entity.arrow.EntityVanillaArrow;
import crazyores.packs.core.tabs.CoreTabList;

public class CoreBow extends ItemBow implements IName {

	public static final String[] bowPullIconNameArray = new String[] {"1", "2", "3"};
    @SideOnly(Side.CLIENT)
	protected IIcon[] iconArray;
	public String itemUnlocalizedName;
	
	private int enchantibility = 1;
	
	protected CoreBow(String unlocalizedName, int maxUses, int enchantibility) {
		this.setUnlocalizedName(unlocalizedName);
		setCreativeTab(CoreTabList.coreToolsTab);
		this.maxStackSize = 1;
		this.setMaxDamage(maxUses);
		this.enchantibility = enchantibility;
	}
	
	@Override
	public boolean isFull3D() {
		return true;
	}
	
	/**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
	@Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int itemInUseCount) {
        int j = (this.getMaxItemUseDuration(stack) - itemInUseCount);

        ArrowLooseEvent event = new ArrowLooseEvent(player, stack, j);
        MinecraftForge.EVENT_BUS.post(event);
       
        if (event.isCanceled()) {
            return;
        }
        
        j = event.charge;

        boolean arrowsAvailable = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;

        List<Item> arrows = new ArrayList<Item>();
        for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
        	
        	if (player.inventory.getStackInSlot(i) == null) continue;
        	
        	Item item = player.inventory.getStackInSlot(i).getItem();
        	if (item.equals(Items.arrow) || item.equals(CoreItems.freezingArrow) || item.equals(CoreItems.explosiveArrow) || item.equals(CoreItems.flamingArrow) || item.equals(CoreItems.electricArrow)) {
        		if (!arrows.contains(item)) {
        			arrows.add(item);
        		}
        	}
        }
        
        if (arrowsAvailable || arrows.size() > 0) {
        	Item arrow = Items.arrow;
        	if (arrows.size() > 0) {
        		int index = Item.itemRand.nextInt(arrows.size());
        		arrow = arrows.get(index);
        	}
        	
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D) {
                return;
            }

            if (f > 1.0F) {
                f = 1.0F;
            }

            CoreEntityArrow entityArrow = null;
            
            if (arrow.equals(CoreItems.flamingArrow)) {
            	entityArrow = new EntityFlamingArrow(world, player, f, getBowEnhancement());
            }
            else if (arrow.equals(CoreItems.freezingArrow)) {
            	entityArrow = new EntityFreezingArrow(world, player, f, getBowEnhancement());
            }
            else if (arrow.equals(CoreItems.explosiveArrow)) {
            	entityArrow = new EntityExplosiveArrow(world, player, f, getBowEnhancement());
            }
            else if (arrow.equals(CoreItems.electricArrow)) {
            	entityArrow = new EntityElectricArrow(world, player, f, getBowEnhancement());
            }
            else {
            	entityArrow = new EntityVanillaArrow(world, player, f, getBowEnhancement());
            }

            if (f == 1.0F) {
                entityArrow.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);

            if (k > 0) {
                entityArrow.setDamage(entityArrow.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);

            if (l > 0) {
                entityArrow.setKnockbackStrength(l);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0) {
                entityArrow.setFire(100);
            }

            stack.damageItem(1, player);
            world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (arrowsAvailable) {
                entityArrow.canBePickedUp = 2;
            }
            else {
                player.inventory.consumeInventoryItem(arrow);
            }

            if (!world.isRemote) {
                world.spawnEntityInWorld(entityArrow);
            }
        }
    }
	
	/**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
	@Override
    public int getItemEnchantability() {
        return enchantibility;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister registry) {
        this.itemIcon = registry.registerIcon(COPackManager.corePack.getPackID() + ":" + this.getUnlocalizedName() + "_0");
        this.iconArray = new IIcon[bowPullIconNameArray.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = registry.registerIcon(COPackManager.corePack.getPackID() + ":" + this.getUnlocalizedName() + "_" + bowPullIconNameArray[i]);
        }
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
		if (player.getItemInUse() == null) {
			return this.itemIcon;
		}
		
		int duration = stack.getMaxItemUseDuration() - useRemaining;
		
		if (duration >= 18) {
			return this.iconArray[2];
		}
		else if (duration > 13) {
			return this.iconArray[1];
		}
		else if (duration > 0) {
			return this.iconArray[0];
		}
		return this.itemIcon;
	}

    /**
     * used to cycle through icons based on their used duration, i.e. for the bow
     */
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(int stage) {
        return this.iconArray[stage];
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
	
	public EnumBowEnhancement getBowEnhancement() {
		return EnumBowEnhancement.NONE;
	}
}

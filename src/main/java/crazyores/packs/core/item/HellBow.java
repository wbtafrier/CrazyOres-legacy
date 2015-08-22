package crazyores.packs.core.item;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.packs.core.entity.arrow.CoreEntityArrow;
import crazyores.packs.core.entity.arrow.EntityExplosiveArrow;
import crazyores.packs.core.entity.arrow.EntityFlamingArrow;
import crazyores.packs.core.entity.arrow.EntityFreezingArrow;
import crazyores.packs.core.entity.arrow.EntityLightningArrow;
import crazyores.packs.core.entity.arrow.EntityVanillaArrow;

public class HellBow extends CoreBow {

	public static final float PULL_BACK_SPEED_REDUCTION = 0.7f;
	
	protected HellBow(String unlocalizedName, int maxUses, int enchantability) {
		super(unlocalizedName, maxUses, enchantability);
	}
	
	@Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int itemInUseCount) {
        int j = (int)((this.getMaxItemUseDuration(stack) - itemInUseCount) * PULL_BACK_SPEED_REDUCTION);

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
        	if (item.equals(Items.arrow) || item.equals(CoreItems.freezingArrow) || item.equals(CoreItems.explosiveArrow) || item.equals(CoreItems.flamingArrow) || item.equals(CoreItems.lightningArrow)) {
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
            	entityArrow = new EntityFlamingArrow(world, player, f * 2.0f, getBowEnhancement());
            }
            else if (arrow.equals(CoreItems.freezingArrow)) {
            	entityArrow = new EntityFreezingArrow(world, player, f * 2.0f, getBowEnhancement());
            }
            else if (arrow.equals(CoreItems.explosiveArrow)) {
            	entityArrow = new EntityExplosiveArrow(world, player, f * 2.0f, getBowEnhancement());
            }
            else if (arrow.equals(CoreItems.lightningArrow)) {
            	entityArrow = new EntityLightningArrow(world, player, f * 2.0f, getBowEnhancement());
            }
            else {
            	entityArrow = new EntityVanillaArrow(world, player, f * 2.0f, getBowEnhancement());
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
	
	
	@Override
	public EnumBowEnhancement getBowEnhancement() {
		return EnumBowEnhancement.FIRE;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
		if (player.getItemInUse() != null && stack.getItem() == this) {
			int duration = (int)((stack.getMaxItemUseDuration() - useRemaining) * PULL_BACK_SPEED_REDUCTION);

            if (duration >= 18) {
                return this.getItemIconForUseDuration(2);
            }

            if (duration > 13) {
                return this.getItemIconForUseDuration(1);
            }

            if (duration > 0) {
                return this.getItemIconForUseDuration(0);
            }
        }
		return itemIcon;
	}
}

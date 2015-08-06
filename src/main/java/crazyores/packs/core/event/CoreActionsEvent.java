package crazyores.packs.core.event;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import crazyores.packs.core.item.CoreArmor;
import crazyores.packs.core.item.CoreItems;

public class CoreActionsEvent {
	
	private static Random eventRand = new Random();
	
	@SubscribeEvent
	public void invisiumEvent(LivingEvent event) {
		
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entity;
			ItemStack[] armor = player.inventory.armorInventory;
			
			
			boolean isFullArmorSet = true;
			for (int slot = 0; slot < armor.length; slot++) {
				if (armor[slot] == null) {
					isFullArmorSet = false;
					break;
				}
			}
			
			if (isFullArmorSet) {
				if (armor[0].getItem().equals(CoreItems.invisiumBoots) && armor[1].getItem().equals(CoreItems.invisiumLeggings) && armor[2].getItem().equals(CoreItems.invisiumChestplate) && armor[3].getItem().equals(CoreItems.invisiumHelmet)) {
					
					if (event instanceof PlayerInteractEvent) {
						PlayerInteractEvent interactEvent = (PlayerInteractEvent)event;
					
						if (!interactEvent.action.equals(PlayerInteractEvent.Action.RIGHT_CLICK_AIR) && !interactEvent.action.equals(PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK))
							return;
						
						for (int i = 0; i < armor.length; i++) {
							CoreArmor slot = (CoreArmor)armor[i].getItem();
							
							if (!slot.getInvisiumEffect()) {
								slot.setInvisiumEffect(true, player);
							}
							else if (slot.getInvisiumEffect()) {
								slot.setInvisiumEffect(false, player);
							}
						}
					}
				}
				else if (armor[0].getItem().equals(CoreItems.adamiteBoots) && armor[1].getItem().equals(CoreItems.adamiteLeggings) && armor[2].getItem().equals(CoreItems.adamiteChestplate) && armor[3].getItem().equals(CoreItems.adamiteHelmet)) {
					if (player.isInWater()) {
						player.setAir(300);
					}
				}
				else if (armor[0].getItem().equals(CoreItems.enderBoots) && armor[1].getItem().equals(CoreItems.enderLeggings) && armor[2].getItem().equals(CoreItems.enderChestplate) && armor[3].getItem().equals(CoreItems.enderHelmet)) {
					if (event instanceof LivingHurtEvent) {
						LivingHurtEvent hurtEvent = (LivingHurtEvent)event;
						DamageSource damage = hurtEvent.source;
						
						System.out.println("FALL DAMAGE");
						
						if (damage.damageType.equals(DamageSource.fall.damageType)) {
						
							System.out.println("BITCHTIT");
							
							float preAmount = hurtEvent.ammount;
							int armorDamage = MathHelper.floor_float(preAmount);
							
							if ((damage.getDamageType().equals(DamageSource.outOfWorld.damageType))) {
								hurtEvent.ammount = 4;
							}
							else {
								hurtEvent.ammount = 0;
							}
							
							for (int i = 0; i < armor.length; i++) {
								player.inventory.damageArmor(armorDamage);
							}
						}
					}
				}
			}
		}
	}
}

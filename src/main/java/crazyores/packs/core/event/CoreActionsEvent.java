package crazyores.packs.core.event;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import crazyores.packs.core.item.CoreArmor;
import crazyores.packs.core.item.CoreItems;

public class CoreActionsEvent {
	
	private static Random eventRand = new Random();
	
	@SubscribeEvent
	public void armorEvent(LivingEvent event) {
		
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
				else if (armor[0].getItem().equals(CoreItems.zectiumBoots) && armor[1].getItem().equals(CoreItems.zectiumLeggings) && armor[2].getItem().equals(CoreItems.zectiumChestplate) && armor[3].getItem().equals(CoreItems.zectiumHelmet)) {
				
					if (event instanceof LivingAttackEvent) {
						LivingAttackEvent hurtEvent = (LivingAttackEvent)event;
						DamageSource damage = hurtEvent.source;
						
						if (damage.isExplosion()) {
						
							System.out.println("HELLO");
							
							float preAmount = hurtEvent.ammount;
							int armorDamage = MathHelper.floor_float(preAmount);
							
							for (int i = 0; i < armor.length; i++) {
								player.inventory.damageArmor(armorDamage / 2.0f);
							}
							
							player.capabilities.setPlayerWalkSpeed(0.09f);
							event.setCanceled(true);
						}
					}
					
				}
				else if (armor[0].getItem().equals(CoreItems.meteoriteBoots) && armor[1].getItem().equals(CoreItems.meteoriteLeggings) && armor[2].getItem().equals(CoreItems.meteoriteChestplate) && armor[3].getItem().equals(CoreItems.meteoriteHelmet)) {
					
					if (event instanceof LivingAttackEvent) {
						LivingAttackEvent hurtEvent = (LivingAttackEvent)event;
						DamageSource damage = hurtEvent.source;
						
						if (damage.damageType.equals(DamageSource.inFire.damageType) || damage.damageType.equals(DamageSource.onFire.damageType) || damage.damageType.equals(DamageSource.lava.damageType)) {
						
							float preAmount = hurtEvent.ammount;
							int armorDamage = MathHelper.floor_float(preAmount);
							
							for (int i = 0; i < armor.length; i++) {
								
								if (i == 0) {
									System.out.println(armor[i].getItemDamage());
								}
								
								if (eventRand.nextInt(1000) == 0) {
									player.inventory.damageArmor(armorDamage);
								}
							}
							
							event.setCanceled(true);
						}
					}
				}
				else if (armor[0].getItem().equals(CoreItems.enderBoots) && armor[1].getItem().equals(CoreItems.enderLeggings) && armor[2].getItem().equals(CoreItems.enderChestplate) && armor[3].getItem().equals(CoreItems.enderHelmet)) {
					
					
					if (event instanceof LivingHurtEvent) {
						LivingHurtEvent hurtEvent = (LivingHurtEvent)event;
						DamageSource damage = hurtEvent.source;
						
						if (damage.damageType.equals(DamageSource.fall.damageType)) {
						
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
				else if (armor[0].getItem().equals(CoreItems.osmoniumBoots) && armor[1].getItem().equals(CoreItems.osmoniumLeggings) && armor[2].getItem().equals(CoreItems.osmoniumChestplate) && armor[3].getItem().equals(CoreItems.osmoniumHelmet)) {
					player.capabilities.setPlayerWalkSpeed(0.2f);
				}
			}
			else {
				player.capabilities.setPlayerWalkSpeed(0.1f);
			}
		}
	}
	
	@SubscribeEvent
	public void playerInteracted(Event event) {
		
		if (event instanceof PlayerInteractEvent) {
			PlayerInteractEvent playerEvent = (PlayerInteractEvent)event;
			
			EntityPlayer player = playerEvent.entityPlayer;
			
			if (player.getCurrentEquippedItem() != null) {
				Item item = player.getCurrentEquippedItem().getItem();
				
				if (item != null && item.equals(CoreItems.meteoriteAxe)) {
					
					if (playerEvent.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
						System.out.println("HELLO!");
					}
				}
			}
			
		}
		
	}
}

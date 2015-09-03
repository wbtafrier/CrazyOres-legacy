package crazyores.packs.core.event;

import java.util.Random;
import java.util.UUID;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import crazyores.packs.core.entity.golem.EntityGolems;
import crazyores.packs.core.entity.golem.EntityZectiumGolem;
import crazyores.packs.core.entity.mob.EntityZectiumProtector;
import crazyores.packs.core.item.CoreArmor;
import crazyores.packs.core.item.CoreItems;

public class CoreActionsEvent {
	
	private static Random eventRand = new Random();
	public static final AttributeModifier slowness = (new AttributeModifier(UUID.fromString("7107DE5E-7CE8-4030-940E-514C1F160892"), "potion.moveArmorSlowdown", -0.1D, 2));
	public static final AttributeModifier speed = (new AttributeModifier(UUID.fromString("7107DE5E-7CE8-4030-940E-514C1F160893"), "potion.moveArmorSpeed", 0.2D, 2));
	
	@SubscribeEvent
	public void armorEvent(LivingEvent event) {
		if (event instanceof LivingAttackEvent && (event.entity instanceof EntityZectiumProtector || event.entity instanceof EntityGolems)) {
			LivingAttackEvent hurtEvent = (LivingAttackEvent)event;
			DamageSource damage = hurtEvent.source;
			
			if (damage.isExplosion()) {
				if ((event.entity instanceof EntityZectiumProtector)) {
					event.setCanceled(true);
					return;
				}
				else if (event.entity instanceof EntityGolems) {
					if (((EntityGolems)event.entity).groundPound() || event.entity instanceof EntityZectiumGolem) {
						event.setCanceled(true);
						return;
					}
				}
			}
		}
		else if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entity;
			ItemStack[] armor = player.inventory.armorInventory;
			
			boolean isFullArmorSet = true;
			for (int slot = 0; slot < armor.length; slot++) {
				if (armor[slot] == null || !(armor[slot].getItem() instanceof CoreArmor)) {
					isFullArmorSet = false;
					break;
				}
			}
			IAttributeInstance instance = event.entityLiving.getEntityAttribute(SharedMonsterAttributes.movementSpeed);

			if (isFullArmorSet) {
				
				if (armor[0].getItem().equals(CoreItems.invisiumBoots) && armor[1].getItem().equals(CoreItems.invisiumLeggings) && armor[2].getItem().equals(CoreItems.invisiumChestplate) && armor[3].getItem().equals(CoreItems.invisiumHelmet)) {
					
					if (player != null && !player.worldObj.isRemote) {
						if (player.getActivePotionEffect(Potion.invisibility) == null || player.getActivePotionEffect(Potion.invisibility).getDuration() < INVISIBILITY_DURATION) {
							setInvisible(player);
						}
					}
				}
				else if (armor[0].getItem().equals(CoreItems.adamiteBoots) && armor[1].getItem().equals(CoreItems.adamiteLeggings) && armor[2].getItem().equals(CoreItems.adamiteChestplate) && armor[3].getItem().equals(CoreItems.adamiteHelmet)) {
					if (player.isInWater()) {
						player.setAir(300);
					}
				}
				else if (armor[0].getItem().equals(CoreItems.zectiumBoots) && armor[1].getItem().equals(CoreItems.zectiumLeggings) && armor[2].getItem().equals(CoreItems.zectiumChestplate) && armor[3].getItem().equals(CoreItems.zectiumHelmet)) {
				
					if (instance.getModifier(slowness.getID()) == null) {
						instance.applyModifier(slowness);
					}
					
					if (event instanceof LivingAttackEvent) {
						LivingAttackEvent hurtEvent = (LivingAttackEvent)event;
						DamageSource damage = hurtEvent.source;
						
						if (damage.isExplosion()) {
						
							float preAmount = hurtEvent.ammount;
							int armorDamage = MathHelper.floor_float(preAmount);
							
							for (int i = 0; i < armor.length; i++) {
								player.inventory.damageArmor(armorDamage / 2.0f);
							}
							
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
					
					if(instance.getModifier(speed.getID()) == null) {
						instance.applyModifier(speed);
					}
				}
			}
			else {
				
				if(instance.getModifier(speed.getID()) != null) {
					instance.removeModifier(speed);
				}
				
				if (instance.getModifier(slowness.getID()) != null) {
					instance.removeModifier(slowness);
				}
			}
		}
		else if (event instanceof LivingSetAttackTargetEvent) {
			LivingSetAttackTargetEvent attackEvent = (LivingSetAttackTargetEvent)event;
			if (attackEvent.target != null && attackEvent.target instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)attackEvent.target;
				ItemStack[] armor = player.inventory.armorInventory;
				if (player.isInvisible() && armor[0].getItem().equals(CoreItems.invisiumBoots) && armor[1].getItem().equals(CoreItems.invisiumLeggings) && armor[2].getItem().equals(CoreItems.invisiumChestplate) && armor[3].getItem().equals(CoreItems.invisiumHelmet)) {
					((EntityLiving) attackEvent.entity).setAttackTarget(null);
				}
			}
		}
	}
	
	private static final int INVISIBILITY_DURATION = 2;
	public void setInvisible(EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(Potion.invisibility.getId(), INVISIBILITY_DURATION, -1));
	}
}
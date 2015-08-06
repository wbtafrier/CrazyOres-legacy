package crazyores.packs.core.event;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import crazyores.packs.core.item.CoreItems;
import crazyores.packs.core.util.CoreEffectUtil;

public class CoreActionsEvent {
	
	private List<PotionData> activeEffects = new ArrayList<PotionData>();
	
	@SubscribeEvent
	public synchronized void updateEffects(PlayerEvent e) {
		for (int i = 0; i < activeEffects.size(); i++) {
			System.out.println(activeEffects.get(i).getEffect().getDuration());
			
			if (activeEffects.get(i).getEntity() instanceof EntityLivingBase)
				activeEffects.get(i).getEffect().onUpdate((EntityLivingBase)activeEffects.get(i).getEntity());
			else  {
				System.out.println("WUT");
				activeEffects.get(i).duration--;
			}
			
			if (activeEffects.get(i).getEffect().getDuration() <= 0) {
				activeEffects.get(i).getEntity().setInvisible(false);
				activeEffects.remove(i);
				System.out.println("REMOVED POTION");
				
				for (int j = i; j < activeEffects.size(); j++) {
					activeEffects.get(j).index--;
					System.out.println("SUBTRACTING INDEXS");
				}
			}
		}
	}
	
	@SubscribeEvent
	public synchronized void onHitEntity(LivingAttackEvent e) {
		
		if (e.source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)e.source.getEntity();
			if (player.getCurrentEquippedItem() != null) {
				
				Item item = player.getCurrentEquippedItem().getItem();
				if (item != null && (item.equals(CoreItems.invisiumIngot) || item.equals(CoreItems.invisiumPickaxe) || 
						item.equals(CoreItems.invisiumAxe) || item.equals(CoreItems.invisiumShovel) || item.equals(CoreItems.invisiumSword) || item.equals(CoreItems.invisiumHoe))) {
					
					e.entity.setInvisible(true);
					addEffect(new PotionData(e.entityLiving, new PotionEffect(Potion.invisibility.id, CoreEffectUtil.getEffectLength(player, CoreEffectUtil.EnumEffectType.INVISIUM), 1), activeEffects.size()));
					System.out.println(e.entityLiving.getEntityId() + ": ADDED NEW POTION!");
				}
			}
		}
	}
	
	@SubscribeEvent
	public synchronized void onRightClickEntity(EntityInteractEvent e) {
		System.out.println("ENTITY INTERACT EVENT");
		EntityPlayer player = e.entityPlayer;
		
		if (player.getCurrentEquippedItem() != null) {
			Item item = player.getCurrentEquippedItem().getItem();
			if (item != null && item.equals(CoreItems.invisiumWand)) {
				System.out.println("OMG 1");
				e.target.setInvisible(true);
				addEffect(new PotionData(e.target, new PotionEffect(Potion.invisibility.id, CoreEffectUtil.getEffectLength(player, CoreEffectUtil.EnumEffectType.INVISIUM), 1), activeEffects.size()));
			}
		}
	}
	
	@SubscribeEvent
	public synchronized void onRightClickAirEvent(PlayerInteractEvent e) {
		
		System.out.println("PLAYER INTERACT EVENT");
		EntityPlayer player = e.entityPlayer;
		
		if (player.getCurrentEquippedItem() != null) {
			Item item = player.getCurrentEquippedItem().getItem();
			if (item != null && item.equals(CoreItems.invisiumWand)) {
				
				if (e.action == PlayerInteractEvent.Action.RIGHT_CLICK_AIR) {
					System.out.println("OMG 2");
					player.setInvisible(true);
					addEffect(new PotionData(player, new PotionEffect(Potion.invisibility.id, CoreEffectUtil.getEffectLength(player, CoreEffectUtil.EnumEffectType.INVISIUM), 1), activeEffects.size()));
				}
			}
		}
	}
	
	private synchronized void addEffect(PotionData data) {
		for (int i = 0; i < activeEffects.size(); i++) {
			if (activeEffects.get(i).equals(data)) {
				return;
			}
		}
		
		activeEffects.add(data);
	}
}

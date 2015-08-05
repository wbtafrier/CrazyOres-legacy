package crazyores.packs.core.event;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import crazyores.packs.core.item.CoreItems;

public class CoreActionsEvent {
	
	private List<PotionData> activePotionEffects = new ArrayList<PotionData>();
	
	@SubscribeEvent
	public void updatePotions(PlayerEvent e) {
		for (int i = 0; i < activePotionEffects.size(); i++) {
			activePotionEffects.get(i).getEffect().onUpdate(activePotionEffects.get(i).getEntity());
			if (activePotionEffects.get(i).getEffect().getDuration() <= 0) {
				activePotionEffects.get(i).getEntity().setInvisible(false);
				activePotionEffects.remove(i);
				System.out.println("REMOVED POTION");
				
				for (int j = i; j < activePotionEffects.size(); j++) {
					activePotionEffects.get(j).index--;
					System.out.println("SUBTRACTING INDEXS");
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onHitEntity(LivingAttackEvent e) {
		
		if (e.source.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)e.source.getEntity();
			if (player.getCurrentEquippedItem() != null) {
				
				Item item = player.getCurrentEquippedItem().getItem();
				if (item.equals(CoreItems.invisiumPickaxe) /*|| item.equals(CoreItems.invisiumAxe) etc*/) {
					e.entity.setInvisible(true);
					activePotionEffects.add(new PotionData(e.entityLiving, new PotionEffect(Potion.invisibility.id, 100, 1), activePotionEffects.size()));
					System.out.println(e.entityLiving.getEntityId() + ": ADDED NEW POTION!");
				}
			}
		}
	}
}

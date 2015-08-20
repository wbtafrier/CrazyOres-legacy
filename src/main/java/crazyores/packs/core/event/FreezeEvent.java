package crazyores.packs.core.event;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.passive.EntitySheep;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import crazyores.packs.core.entity.FrozenEntity;

public class FreezeEvent {

	private static List<FrozenEntity> frozenEntities = new ArrayList<FrozenEntity>();
	
	@SubscribeEvent
	public void freezeEvent(TickEvent.ServerTickEvent event) {
		
		for (int i = 0; i < frozenEntities.size(); i++) {
			FrozenEntity frozenEntity = frozenEntities.get(i);
			EntityLivingBase entity = frozenEntity.getEntity();
			
			if (entity != null && entity.worldObj != null)
				entity = (EntityLivingBase) entity.worldObj.getEntityByID(frozenEntity.getEntity().getEntityId());
			
			
			if (entity != null && frozenEntity.hasTicksLeft()) {
				frozenEntity.update();
				
//				System.out.println(frozenEntity.getTicks());
				
				System.out.println(entity.motionX + " " + entity.motionY + " " + entity.motionZ);
				
			}
			else {
				System.out.println("REMOVING ENTITY FROM LIST!!");
				if (entity != null && frozenEntity.isSlow()) {
					System.out.println("REMOVING");
					frozenEntity.applyModifier(false);
				}
				frozenEntities.remove(i);
				i--;
			}
		}
	}
	
	public static void addEntitiesToList(List<FrozenEntity> newEntities) {
		for (FrozenEntity e : newEntities) {
			for (FrozenEntity f : frozenEntities) {
				if (e.getEntity().isEntityEqual(f.getEntity())) {
					System.out.println("ENTITIES ARE EQUAL");
					return;
				}
			}
			
			System.out.println("ADDED ENTITY TO THE LIST!!");
			frozenEntities.add(e);
			
			if (e.getEntity() != null && !e.isSlow()) {
				System.out.println("ADDING");
				e.applyModifier(true);
			}
		}
	}
}

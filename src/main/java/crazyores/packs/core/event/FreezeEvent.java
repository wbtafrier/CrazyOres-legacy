package crazyores.packs.core.event;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraftforge.event.entity.living.LivingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.packs.core.entity.FrozenEntity;

public class FreezeEvent {

	public static List<FrozenEntity> frozenEntities = new ArrayList<FrozenEntity>();
	
	@SubscribeEvent
	public void freezeEvent(TickEvent.ServerTickEvent event) {
		
		for (int i = 0; i < frozenEntities.size(); i++) {
			FrozenEntity frozenEntity = frozenEntities.get(i);
			EntityLivingBase entity = frozenEntity.getEntity();
			
			if (entity != null && entity.worldObj != null)
				entity = (EntityLivingBase) entity.worldObj.getEntityByID(frozenEntity.getEntity().getEntityId());
			
			
			if (entity != null && frozenEntity.hasTicksLeft()) {
				frozenEntity.update();
			}
			else {
//				System.out.println("REMOVING ENTITY FROM LIST!!");
				if (entity != null) {
					frozenEntity.applyModifier(false);
				}
				frozenEntities.remove(i);
				i--;
			}
		}
	}
	
	@SubscribeEvent
	public void updateFreezeEvent(LivingEvent event) {
		
		if (!event.entity.worldObj.isRemote) {
			
			IAttributeInstance instance = event.entityLiving.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
			
			boolean isEntityInList = false;
			
			for (int i = 0; i < FreezeEvent.frozenEntities.size(); i++) {
				if (event.entityLiving.isEntityEqual(FreezeEvent.frozenEntities.get(i).getEntity())) {
					isEntityInList = true;
				}
			}
			
			if (!isEntityInList && instance.getModifier(FrozenEntity.slowness.getID()) != null) {
//				System.out.println("REMOVE SLOWNESS fhnejkfbglbgibi");
				instance.removeModifier(FrozenEntity.slowness);
			}
		}
	}
	
	
	public static void addEntitiesToList(List<FrozenEntity> newEntities) {
		for (FrozenEntity e : newEntities) {
			for (FrozenEntity f : frozenEntities) {
				if (e.getEntity().isEntityEqual(f.getEntity())) {
//					System.out.println("ENTITIES ARE EQUAL");
					return;
				}
			}
			
//			System.out.println("ADDED ENTITY TO THE LIST!!");
			frozenEntities.add(e);
			
			if (e.getEntity() != null && e.getEntity().getEntityAttribute(SharedMonsterAttributes.movementSpeed).getModifier(FrozenEntity.slowness.getID()) == null) {
//				System.out.println("ADDING");
				e.applyModifier(true);
			}
		}
	}
}
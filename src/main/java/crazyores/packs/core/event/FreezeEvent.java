package crazyores.packs.core.event;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import crazyores.packs.core.entity.FrozenEntity;

public class FreezeEvent {

	private List<FrozenEntity> frozenEntities = new ArrayList<FrozenEntity>();
	
	@SubscribeEvent
	public void freezeEvent(TickEvent.WorldTickEvent event) {
		
		for (FrozenEntity frozenEntity : frozenEntities) {
			
			Entity entity = event.world.getEntityByID(frozenEntity.getEntityID());
			
			entity.motionX = 0;
			entity.motionY = 0;
			entity.motionZ = 0;
			
			
		}
	}
}

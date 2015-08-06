package crazyores.packs.core.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;

public class PotionData {

	private Entity affectedEntity;
	private PotionEffect effect;
	public int index;
	public int duration;
	
	public PotionData(Entity target, PotionEffect pe, int i) {
		affectedEntity = target;
		effect = pe;
		index = i;
		
		if (!(target instanceof EntityLivingBase)) {
			duration = pe.getDuration();
		}
	}
	
	public Entity getEntity() {
		return affectedEntity;
	}
	
	public PotionEffect getEffect() {
		return effect;
	}
}

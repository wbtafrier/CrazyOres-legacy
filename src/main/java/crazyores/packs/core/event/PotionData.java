package crazyores.packs.core.event;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;

public class PotionData {

	private EntityLivingBase affectedEntity;
	private PotionEffect effect;
	public int index;
	
	public PotionData(EntityLivingBase e, PotionEffect pe, int i) {
		affectedEntity = e;
		effect = pe;
		index = i;
	}
	
	public EntityLivingBase getEntity() {
		return affectedEntity;
	}
	
	public PotionEffect getEffect() {
		return effect;
	}
}

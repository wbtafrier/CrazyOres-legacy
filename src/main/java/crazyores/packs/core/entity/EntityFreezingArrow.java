package crazyores.packs.core.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import crazyores.packs.core.item.EnumBowEnhancement;

public class EntityFreezingArrow extends CoreEntityArrow {

	public EntityFreezingArrow(World world, EntityLivingBase shootingEntity, float speed, EnumBowEnhancement enhancement) {
		super(world, shootingEntity, speed, enhancement);
	}

}

package crazyores.packs.core.entity.arrow;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import crazyores.packs.core.item.EnumBowEnhancement;

public class EntityElectricArrow extends CoreEntityArrow {

	public EntityElectricArrow(World world, EntityLivingBase shootingEntity, float speed, EnumBowEnhancement enhancement) {
		super(world, shootingEntity, speed, enhancement);
	}

}

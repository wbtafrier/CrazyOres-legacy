package crazyores.packs.core.entity.arrow;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import crazyores.packs.core.item.EnumBowEnhancement;

public class EntityVanillaArrow extends CoreEntityArrow {

	public EntityVanillaArrow(World world, EntityLivingBase shootingEntity, float speed, EnumBowEnhancement enhancement) {
		super(world, shootingEntity, speed, enhancement);
	}
	
	public EntityVanillaArrow(World world, EntityLivingBase shootingEntity, double verticalOffset, float speed, EnumBowEnhancement enhancement) {
        super(world, shootingEntity, verticalOffset, speed, enhancement);
    }
}

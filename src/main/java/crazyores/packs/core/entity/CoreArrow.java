package crazyores.packs.core.entity;

import crazyores.packs.core.item.BowEnhancements;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;

public class CoreArrow extends EntityArrow {

	private int bowEnhancement = -1;
	
	public CoreArrow(World world, EntityLivingBase shootingEntity, float speed)
    {
        super(world, shootingEntity, speed);
    }
	
	public CoreArrow(World world, EntityLivingBase shootingEntity, float speed, int enhancement)
    {
        this(world, shootingEntity, speed);
        this.bowEnhancement = enhancement;
    }
	
	static class Flaming extends CoreArrow {
		public Flaming(World world, EntityLivingBase shootingEntity, float speed) {
			super(world, shootingEntity, speed);
		}
	}
	
	static class Explosive extends CoreArrow {
		public Explosive(World world, EntityLivingBase shootingEntity, float speed) {
			super(world, shootingEntity, speed);
		}
	}
	
	static class Freezing extends CoreArrow {
		public Freezing(World world, EntityLivingBase shootingEntity, float speed) {
			super(world, shootingEntity, speed);
		}
	}
	
	static class Electric extends CoreArrow {
		public Electric(World world, EntityLivingBase shootingEntity, float speed) {
			super(world, shootingEntity, speed);
		}
	}
}

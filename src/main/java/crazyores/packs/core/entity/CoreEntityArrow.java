package crazyores.packs.core.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;
import crazyores.packs.core.item.EnumBowEnhancement;

public class CoreEntityArrow extends EntityArrow {

	private EnumBowEnhancement bowEnhancement = EnumBowEnhancement.NONE;
	
	public CoreEntityArrow(World world, EntityLivingBase shootingEntity, float speed) {
        super(world, shootingEntity, speed);
    }
	
	public CoreEntityArrow(World world, EntityLivingBase shootingEntity, float speed, EnumBowEnhancement enhancement) {
        this(world, shootingEntity, speed);
        this.bowEnhancement = enhancement;
    }
}

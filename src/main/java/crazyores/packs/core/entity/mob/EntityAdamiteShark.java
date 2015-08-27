package crazyores.packs.core.entity.mob;

import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.world.World;
import crazyores.packs.core.entity.mob.EntityShark.EnumSharkType;

public class EntityAdamiteShark extends EntityShark {

	public EntityAdamiteShark(World world) {
		super(world, EnumSharkType.ADAMITE, 0.5f + (rand.nextFloat() * 0.2f), 16f);
	}
}

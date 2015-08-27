package crazyores.packs.core.entity.mob;

import crazyores.packs.core.entity.mob.EntityShark.EnumSharkType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityGreatWhiteShark extends EntityShark {

	public EntityGreatWhiteShark(World world) {
		super(world, EnumSharkType.GREAT_WHITE, 1.0f + (rand.nextFloat() * 0.2f), 32f);
	}
}

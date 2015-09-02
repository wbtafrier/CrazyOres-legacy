package crazyores.packs.core.entity.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import crazyores.packs.core.entity.golem.EntityDemoniteGolem;
import crazyores.packs.core.entity.golem.EnumGolemType;
import crazyores.packs.core.entity.mob.EntityZectiumProtector;

public class GolemTargets implements IAnimals {
	
	private EnumGolemType golemType;
	
	public GolemTargets(EnumGolemType t) {
		golemType = t;
	}
	
	public IEntitySelector mobSelector = new IEntitySelector() {
		
		@Override
        public boolean isEntityApplicable(Entity target) {
				
			if (golemType.equals(EnumGolemType.DEMONITE)) {
				return !(target instanceof EntityDemoniteGolem || target instanceof EntityGhast || target instanceof EntityMagmaCube || target instanceof EntityPigZombie || target instanceof EntityZectiumProtector) && (target instanceof IMob || target instanceof EntityGolem);
			}
			else if (golemType.equals(EnumGolemType.ENDER)) {
				return !(target instanceof IMob || target instanceof EntityZectiumProtector || target instanceof EntityCreeper) && target instanceof EntityLivingBase;
			}
            return target instanceof IMob && !(target instanceof EntityZectiumProtector);
        }
    };
}

package crazyores.packs.core.entity.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IAnimals;
import crazyores.packs.core.entity.golem.EntityDemoniteGolem;
import crazyores.packs.core.entity.golem.EntityGolems;
import crazyores.packs.core.entity.golem.EnumGolemType;

public class GolemTargets implements IAnimals {
	
	private EnumGolemType golemType;
	
	public GolemTargets(EnumGolemType t) {
		golemType = t;
	}
	
	public IEntitySelector mobSelector = new IEntitySelector() {
		
		@Override
        public boolean isEntityApplicable(Entity target) {
				
			if (golemType.equals(EnumGolemType.DEMONITE)) {
				return !(target instanceof EntityDemoniteGolem || target instanceof EntityGhast || target instanceof EntityMagmaCube || target instanceof EntityPigZombie) && (target instanceof IMob || target instanceof EntityGolems);
			}
			else if (golemType.equals(EnumGolemType.ENDER)) {
				return !(target instanceof EntityEnderman) && target instanceof IMob;
			}
            return target instanceof IMob;
        }
    };
}

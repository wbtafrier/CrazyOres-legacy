package crazyores.packs.core.entity.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IAnimals;
import crazyores.packs.core.entity.golem.EnumGolemType;

public class GolemTargets implements IAnimals {
	
	private EnumGolemType golemType;
	
	public GolemTargets(EnumGolemType t) {
		golemType = t;
	}
	
	public IEntitySelector mobSelector = new IEntitySelector() {
		
		@Override
        public boolean isEntityApplicable(Entity entity) {
        	
        	if (golemType.equals(EnumGolemType.COPPER))
        		return (entity instanceof IMob);
			
            return entity instanceof IMob;
        }
    };
}

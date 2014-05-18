package crazyores_core.common.entity;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;

public interface IGolemTarget extends IAnimals {

	IEntitySelector golemTargets = new IEntitySelector() {

		@Override
		public boolean isEntityApplicable(Entity target) {
			return target instanceof IMob || target instanceof EntityPlayer || target instanceof EntityCreeper;
		}
		
	};
	
}

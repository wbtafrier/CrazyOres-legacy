package crazyores.packs.core.entity.mob;

import net.minecraft.init.Items;
import net.minecraft.world.World;
import crazyores.packs.core.item.CoreItems;

public class EntityAdamiteShark extends EntityShark {

	public EntityAdamiteShark(World world) {
		super(world, EnumSharkType.ADAMITE, 0.5f + (rand.nextFloat() * 0.2f), 16f, 0.15f);
	}

	@Override
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j = this.rand.nextInt(4);
        int k;

        for (k = 0; k < j; ++k) {
            this.dropItem(Items.fish, 1);
        }

        j = this.rand.nextInt(3) + 2;

        for (k = 0; k < j; ++k) {
            this.dropItem(CoreItems.rawSharkMeat, 1);
        }
		
	}
}

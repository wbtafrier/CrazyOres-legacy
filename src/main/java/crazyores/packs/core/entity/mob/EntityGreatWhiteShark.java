package crazyores.packs.core.entity.mob;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import crazyores.packs.core.item.CoreItems;

public class EntityGreatWhiteShark extends EntityShark {

	public EntityGreatWhiteShark(World world) {
		super(world, EnumSharkType.GREAT_WHITE, 1.0f + (world.rand.nextFloat() * 0.2f), 32f, 0.07f);
	}

	@Override
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j = this.rand.nextInt(8);
        int k;

        for (k = 0; k < j; ++k) {
            this.dropItem(Items.fish, 1);
        }

        j = this.rand.nextInt(6) + 2;

        for (k = 0; k < j; ++k) {
            this.dropItem(CoreItems.rawSharkMeat, 1);
        }
	}
	
	@Override
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(26.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0D);
    }
}

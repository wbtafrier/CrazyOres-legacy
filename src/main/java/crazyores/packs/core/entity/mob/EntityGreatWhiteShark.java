package crazyores.packs.core.entity.mob;

import crazyores.packs.core.entity.mob.EntityShark.EnumSharkType;
import crazyores.packs.core.item.CoreItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityGreatWhiteShark extends EntityShark {

	public EntityGreatWhiteShark(World world) {
		super(world, EnumSharkType.GREAT_WHITE, 1.0f + (rand.nextFloat() * 0.2f), 32f, 0.07f);
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
}

package crazyores.packs.core.item;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ConfusionBow extends CoreBow {

	public static final int NAUSEA_EFFECT = 200;
	
	protected ConfusionBow(String unlocalizedName, int maxUses, int enchantibility) {
		super(unlocalizedName, maxUses, enchantibility);
	}
	
	@Override
	public EnumBowEnhancement getBowEnhancement() {
		return EnumBowEnhancement.POISON;
	}
}

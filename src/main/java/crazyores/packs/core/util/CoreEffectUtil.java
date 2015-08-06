package crazyores.packs.core.util;

import net.minecraft.entity.player.EntityPlayer;

public class CoreEffectUtil {

	public enum EnumEffectType {
		INVISIUM,
		TAPAZITE,
		ENDER;
	}
	
	private static final float multiplier = 1.0f;
	
	public static int getEffectLength(EntityPlayer player, EnumEffectType type) {
		
		switch (type) {
		case INVISIUM: {
	//		if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(CoreItems.invisiumHelmet)) {
	//			multiplier += 1.0f;
	//		}
	//		else if (player.getCurrentArmor(1) != null && player.getCurrentArmor(0).getItem().equals(CoreItems.invisiumChestplate)) {
	//			multiplier += 2.5f;
	//		}
			break;
		}
		case ENDER: {
			break;
		}
		case TAPAZITE: {
			break;
		}
		default:
			break;
		}
		
		System.out.println(multiplier);
		return (int)(multiplier * 100);
	}
	
	public static boolean isWearingFullArmor(EntityPlayer player, EnumEffectType type) {
		return true;
	}
}

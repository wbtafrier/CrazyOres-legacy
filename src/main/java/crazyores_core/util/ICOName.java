package crazyores_core.util;

import net.minecraft.item.ItemStack;

public interface ICOName {
	
	/**
	 * Comments coming soon.
	 */
	String getUnlocalizedName();
	
	/**
	 * Comments coming soon.
	 */
	String parsePrefix(String unlocalizedName, char lastPrefixChar);
	
	/**
	 * Comments coming soon.
	 */
	String getReadableName();
}

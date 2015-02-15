package crazyores_core.common.core;

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

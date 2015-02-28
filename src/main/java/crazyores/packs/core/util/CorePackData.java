package crazyores.packs.core.util;

import net.minecraft.util.EnumChatFormatting;
import crazyores.manager.util.CrazyOresData;
import crazyores.manager.util.Pack;

public class CorePackData extends Pack {
	
	/**
	 * Pack constructor. Sets all the variables neccessary for a pack.
	 * @param fullName is the name of the pack and the prefix. ie: CrazyOres Core
	 * @param name is the name of the pack. ie: Core
	 * @param version is the version number of the pack in String form ie: 2.0
	 * @param ID is the id of the pack. ie: crazyores_core
	 * @param color is the color of the pack that will be displayed in the chat window.
	 */
	public CorePackData() {
		super(CrazyOresData.COPrefix + " Core", "Core", "2.0", "crazyores_core", EnumChatFormatting.AQUA);
	}
}

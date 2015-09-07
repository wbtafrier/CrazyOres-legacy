package crazyores.manager.pack.data;

import net.minecraft.util.EnumChatFormatting;
import crazyores.manager.support.AbstractPack;

public class CorePackData extends AbstractPack {
	
	/**
	 * Pack constructor. Sets all the variables necessary for a pack.
	 * @param fullName is the name of the pack and the prefix. ie: CrazyOres Core
	 * @param name is the name of the pack. ie: Core
	 * @param version is the version number of the pack in String form ie: 2.0
	 * @param ID is the id of the pack. ie: crazyores_core
	 * @param color is the color of the pack that will be displayed in the chat window.
	 */
	public CorePackData() {
		super(CrazyOresData.COPrefix, CrazyOresData.COPrefix, CrazyOresData.corePackVersion, CrazyOresData.corePackID, EnumChatFormatting.AQUA);
		
		
	}
}

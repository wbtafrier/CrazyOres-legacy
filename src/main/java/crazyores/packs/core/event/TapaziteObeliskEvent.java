package crazyores.packs.core.event;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import crazyores.packs.core.item.CoreItems;

public class TapaziteObeliskEvent {

	public ArrayList<ObeliskPlayerData> obeliskData = new ArrayList<ObeliskPlayerData>();
	
	@SubscribeEvent
	public void onObeliskHeld(PlayerEvent e) {
		if (e.entityPlayer != null) {
			if (e.entityPlayer.getCurrentEquippedItem() != null && e.entityPlayer.getCurrentEquippedItem().getItem().equals(CoreItems.tapaziteObelisk)) {
				for (int i = 0; i < obeliskData.size(); i++) {
					if (obeliskData.get(i).player.equals(e.entityPlayer)) {
						break;
					}
					
					if (i == (obeliskData.size() - 1)) {
						ObeliskPlayerData opd = new ObeliskPlayerData(e.entityPlayer, 1, 1, 1);
						obeliskData.add(opd);
						System.out.println("Hi " + e.entityPlayer.getCommandSenderName());
					}
				}
			}
			else {
				for (int i = 0; i < obeliskData.size(); i++) {
					if (obeliskData.get(i).equals(e.entityPlayer)) {
						obeliskData.remove(i);
						System.out.println("Bye " + e.entityPlayer.getCommandSenderName());
					}
				}
			}
		}
	}
}

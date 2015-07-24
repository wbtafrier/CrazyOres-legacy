package crazyores.packs.core.event;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import crazyores.packs.core.item.CoreItems;

public class TapaziteObeliskEvent {

	public static ArrayList<ObeliskPlayerData> obeliskData = new ArrayList<ObeliskPlayerData>();
	
	@SubscribeEvent
	public void onObeliskHeld(PlayerEvent e) {
		if (e.entityPlayer != null) {
			if (e.entityPlayer.getCurrentEquippedItem() != null && e.entityPlayer.getCurrentEquippedItem().getItem().equals(CoreItems.tapaziteObelisk)) {
				if (obeliskData.size() == 0) {
					System.out.println("Hi " + e.entityPlayer.getCommandSenderName());
					obeliskData.add(new ObeliskPlayerData(e.entityPlayer));
				}
				else {
					for (int i = 0; i < obeliskData.size(); i++) {
						if (obeliskData.get(i).player.equals(e.entityPlayer)) {
							break;
						}
						if (i == (obeliskData.size() - 1)) {
							ObeliskPlayerData opd = new ObeliskPlayerData(e.entityPlayer);
							System.out.println("Hi " + e.entityPlayer.getCommandSenderName());
							obeliskData.add(opd);
						}
					}
				}
				
				for (ObeliskPlayerData opd : obeliskData) {
					opd.updatePlayerPosition();
					opd.updateBlock();
					opd.updateLightPosition();
					opd.updateYPos();
				}
			}
			else {
				for (int i = 0; i < obeliskData.size(); i++) {
					if (obeliskData.get(i).player.equals(e.entityPlayer)) {
						obeliskData.get(i).updateBlock();
						obeliskData.remove(i);
						System.out.println("Bye " + e.entityPlayer.getCommandSenderName());
					}
				}
			}
		}
	}
}

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
	public synchronized void onObeliskHeld(PlayerEvent e) {
		if (e.entityPlayer != null) {
			if (e.entityPlayer.getCurrentEquippedItem() != null && e.entityPlayer.getCurrentEquippedItem().getItem().equals(CoreItems.tapaziteObelisk)) {
				if (obeliskData.size() == 0) {
					addPlayer(e);
				}
				else {
					for (int i = 0; i < obeliskData.size(); i++) {
						if (obeliskData.get(i).player.equals(e.entityPlayer)) {
							break;
						}
						if (i == (obeliskData.size() - 1)) {
							addPlayer(e);
						}
					}
				}
				
				for (int i = 0; i < obeliskData.size(); i++) {
					if (obeliskData.get(i).needsUpdate()) {
//						System.out.println("UPDATE");
						update(i);
					}
				}
			}
			else {
				for (int i = 0; i < obeliskData.size(); i++) {
					if (obeliskData.get(i).player.equals(e.entityPlayer)) {
						obeliskData.get(i).updateBlock();
						obeliskData.remove(i);
//						System.out.println("Bye " + e.entityPlayer.getCommandSenderName());
					}
				}
			}
		}
	}
	
	private synchronized void addPlayer(PlayerEvent e) {
		ObeliskPlayerData opd = new ObeliskPlayerData(e.entityPlayer);
//		System.out.println("Hi " + e.entityPlayer.getCommandSenderName());
		obeliskData.add(opd);
		update(obeliskData.size() - 1);
	}
	
	private synchronized void update(int index) {
		obeliskData.get(index).updatePlayerPosition();
		obeliskData.get(index).updateBlock();
		obeliskData.get(index).updateLightPosition();
		obeliskData.get(index).updatePosition();
	}
}

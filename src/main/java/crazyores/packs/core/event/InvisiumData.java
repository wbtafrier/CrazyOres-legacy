package crazyores.packs.core.event;

import java.util.ArrayList;

import crazyores.packs.core.item.CoreArmor;
import net.minecraft.entity.player.EntityPlayer;

public class InvisiumData {

	public static ArrayList<InvisiumData> invisiumData = new ArrayList<InvisiumData>();
	private EntityPlayer player;
	private int counter;
	
	public InvisiumData(EntityPlayer p) {
		player = p;
		
		if (hasEffect(p)) return;
		growList();
	}
	
	public static boolean hasEffect(EntityPlayer p) {
		for (InvisiumData d : invisiumData) {
			if (d.player.equals(p)) {
				System.out.println("1");
				return true;
			}
		}
		System.out.println("2");
		return false;
	}
	
	public static void removeEffect(EntityPlayer p) {
		for (int i = 0; i < invisiumData.size(); i++) {
			if (invisiumData.get(i).equals(p)) {
				
				for (int j = 0; j < p.inventory.armorInventory.length; j++) {
					CoreArmor slot = (CoreArmor)p.inventory.armorInventory[j].getItem();
					slot.setInvisiumEffect(false);
				}
				
				invisiumData.remove(i);
				break;
			}
		}
	}
	
	private void growList() {
		System.out.println("3");
		if (counter != 60) return;
		else counter = 0;
		System.out.println("4");
		
		invisiumData.add(this);
		
		for (int i = 0; i < player.inventory.armorInventory.length; i++) {
			CoreArmor slot = (CoreArmor)player.inventory.armorInventory[i].getItem();
			slot.setInvisiumEffect(true);
			System.out.println("5");
		}
	}
	
	public void updateCounter() {
		System.out.println("6");
		if (hasEffect(player)) {
			System.out.println();
			System.out.println("INCREMENTING TO: " + counter);
			counter = counter == 60 ? 60 : counter + 1;
		}
	}
}

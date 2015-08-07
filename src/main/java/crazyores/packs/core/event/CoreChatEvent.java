package crazyores.packs.core.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import crazyores.manager.pack.COPackManager;

public class CoreChatEvent {

	@SubscribeEvent
	public void onBadMineEvent(BreakEvent e) {
		
		EntityPlayer player = e.getPlayer();
		if (player != null && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() != null) {
			Item item = player.getCurrentEquippedItem().getItem();
			if (item instanceof ItemPickaxe) {
				if (item.getHarvestLevel(player.getCurrentEquippedItem(), "pickaxe") < e.block.getHarvestLevel(0)) {
					
					String pickaxe = player.getCurrentEquippedItem().getDisplayName();
					String block = (new ItemStack(e.block)).getDisplayName();
					player.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA + COPackManager.corePack.getFullPackName() + EnumChatFormatting.RESET + " Uh oh! " + isAorAn(true, pickaxe) + " " + pickaxe
							+ " is unable to mine " + isAorAn(false, block) + " " + block + ". To learn more about the mining system, go to: http://www.ascottwebdesign.com/dreamstone/"));
				}
			}
		}
	}
	
	private String[] vowels = new String[] { "a", "e", "i", "o", "u" };
	private String isAorAn(boolean uppercase, String nextWord) {
		for (int i = 0; i < vowels.length; i++) {
			if (nextWord.substring(0, 1).equalsIgnoreCase(vowels[i])) {
				return uppercase ? "An" : "an";
			}
		}
		return uppercase ? "A" : "a";
	}
}

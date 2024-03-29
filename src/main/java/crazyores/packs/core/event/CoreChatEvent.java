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
import crazyores.packs.core.block.BlockOre;
import crazyores.packs.core.block.BlockTapaziteCrystal;
import crazyores.packs.core.block.CoreBlock;
import crazyores.packs.core.block.CoreGlass;
import crazyores.packs.core.block.CoreStairs;
import crazyores.packs.core.item.CorePickaxe;

public class CoreChatEvent {

	@SubscribeEvent
	public void onBadMineEvent(BreakEvent e) {
		
		EntityPlayer player = e.getPlayer();
		if (player != null && !player.capabilities.isCreativeMode && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() != null && e.block != null) {
			Item item = player.getCurrentEquippedItem().getItem();
			if (item instanceof CorePickaxe || e.block instanceof CoreBlock || e.block instanceof BlockTapaziteCrystal || e.block instanceof CoreStairs) {
				if (!(e.block instanceof CoreGlass) && e.block != null) {
					if (item.getHarvestLevel(player.getCurrentEquippedItem(), "pickaxe") < e.block.getHarvestLevel(e.blockMetadata)) {
						
						String pickaxe = player.getCurrentEquippedItem().getDisplayName();
						
						ItemStack s = new ItemStack(e.block, 0, e.blockMetadata);
						String block = null;
						
						if (s != null) {
							block = (new ItemStack(e.block, 0, e.blockMetadata)).getDisplayName();
						}
						
						if (block == null) {
							block = "this block";
						}
						
						player.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA + COPackManager.corePack.getFullPackName() + EnumChatFormatting.RESET + " Uh oh! " + isAorAn(true, pickaxe) + " " + pickaxe
								+ " is unable to mine " + isAorAn(false, block) + " " + block + ". To learn more about the CrazyOres tier system, go to:"));
						player.addChatMessage(new ChatComponentText("http://tinyurl.com/nvgxgya"));
					}
				}
			}
		}
	}
	
	private String[] vowels = new String[] { "a", "e", "i", "o", "u" };
	private String isAorAn(boolean uppercase, String nextWord) {
		for (int i = 0; i < vowels.length; i++) {
			if (nextWord.substring(0, 1).equalsIgnoreCase(vowels[i])) {
				return uppercase ? "An" : "an";			}
		}
		return uppercase ? "A" : "a";
	}
}

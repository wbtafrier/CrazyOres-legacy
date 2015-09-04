package crazyores.packs.core.event;

import java.util.ArrayList;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import crazyores.packs.core.block.BlockTapaziteCrystal;
import crazyores.packs.core.item.CoreSledgehammer;

public class TapaziteCrystalEvent {
	
	@SubscribeEvent
	public void tapaziteBreak(BreakEvent e) {
		EntityPlayer player = e.getPlayer();
		if (player != null && !player.capabilities.isCreativeMode) {
			Item item = player.getCurrentEquippedItem() == null ? null : player.getCurrentEquippedItem().getItem();
			if (e.block instanceof BlockTapaziteCrystal) {
				if (item == null || (item instanceof ItemPickaxe && item.getHarvestLevel(player.getCurrentEquippedItem(), "pickaxe") < e.block.getHarvestLevel(0)) || (!(item instanceof ItemPickaxe) && !(item instanceof CoreSledgehammer))) {
					BlockTapaziteCrystal crystal = (BlockTapaziteCrystal)e.block;
					ArrayList<ItemStack> drops = crystal.getDustDrops(e.world, e.x, e.y, e.z, e.blockMetadata, EnchantmentHelper.getFortuneModifier(player));
					crystal.dropItems(e.world, e.x, e.y, e.z, drops);
				}
			}
		}
	}
}

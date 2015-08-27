package crazyores.packs.core.event;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import crazyores.packs.core.item.CoreItems;

public class CoreBucketEvent {
	
	@SubscribeEvent
	public void bucketClick(PlayerInteractEvent event) {
		if (event != null && !event.world.isRemote && event.action.equals(PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)) {
			if (event.entityPlayer != null && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem().equals(CoreItems.copperBucketWater)) {
				Block block = event.world.getBlock(event.x, event.y, event.z);
				if (block != null && block instanceof BlockCauldron) {
					BlockCauldron cauldron = (BlockCauldron)block;
					int meta = event.world.getBlockMetadata(event.x, event.y, event.z);
					int water = cauldron.func_150027_b(meta);
					if (water < 3) {
						if (!event.entityPlayer.capabilities.isCreativeMode)
                        {
							event.entityPlayer.inventory.setInventorySlotContents(event.entityPlayer.inventory.currentItem, new ItemStack(CoreItems.copperBucketEmpty));
                        }

                        cauldron.func_150024_a(event.world, event.x, event.y, event.z, 3);
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void milkCow(EntityInteractEvent event) {
		if (event != null && event.entityPlayer != null && event.target != null) {
			if (event.target instanceof EntityCow) {
				ItemStack itemStack = event.entityPlayer.inventory.getCurrentItem();
				if (itemStack != null && itemStack.getItem().equals(CoreItems.copperBucketEmpty) && !event.entityPlayer.capabilities.isCreativeMode) {
                	if (itemStack.stackSize-- == 1)
                    {
                        event.entityPlayer.inventory.setInventorySlotContents(event.entityPlayer.inventory.currentItem, new ItemStack(CoreItems.copperBucketMilk));
                    }
                    else if (!event.entityPlayer.inventory.addItemStackToInventory(new ItemStack(CoreItems.copperBucketMilk)))
                    {
                    	event.entityPlayer.dropPlayerItemWithRandomChoice(new ItemStack(CoreItems.copperBucketMilk, 1, 0), false);
                    }
				}
			}
		}
	}
}

package crazyores.packs.core.item;

import java.util.Random;

import crazyores.packs.core.config.COCoreConfigSettings;
import crazyores.packs.core.entity.EntityZectiumCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemZectiumCore extends CoreItem {

	private Random itemRand = new Random();
	
	protected ItemZectiumCore(String unlocalizedName, CreativeTabs tab, int maxStackSize) {
		super(unlocalizedName, tab, maxStackSize);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
			if (!player.capabilities.isCreativeMode) {
				--stack.stackSize;
			}
			
			world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if (!world.isRemote) {
				world.spawnEntityInWorld(new EntityZectiumCore(world, player));
			}
		return stack;
	}
}

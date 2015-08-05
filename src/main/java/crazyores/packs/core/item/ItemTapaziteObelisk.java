package crazyores.packs.core.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.apache.logging.log4j.Level;

import crazyores.manager.util.CrazyOresLogger;
import crazyores.packs.core.block.CoreBlocks;

public class ItemTapaziteObelisk extends CoreItem {

	/**
	 * Constructor for the CoreItem class.
	 * @param unlocalizedName
	 */
	protected ItemTapaziteObelisk(String unlocalizedName) {
		super(unlocalizedName);
	}
	
	/**
	 * Constructor for the CoreItem class.
	 * @param unlocalizedName
	 * @param tab
	 */
	protected ItemTapaziteObelisk(String unlocalizedName, CreativeTabs tab) {
		super(unlocalizedName, tab);
	}
	
	@Override
	public void onUpdate(ItemStack item, World world, Entity entity, int par4, boolean isHolding) {
		
	}
}

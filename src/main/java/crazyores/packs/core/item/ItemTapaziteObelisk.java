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

	public double lightX;
	public double lightY;
	public double lightZ;
	
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
	   
		if (entity instanceof EntityPlayerMP) {
			
			if (isHolding && ((EntityPlayerMP)entity).getCurrentEquippedItem() == item) {
				
				if (lightX != entity.posX || lightY != entity.posY || lightZ != entity.posZ) {
					
					if (world.getBlock((int)lightX, (int)lightY, (int)lightZ).isAssociatedBlock(CoreBlocks.tapaziteLightSource)) {
						world.setBlock((int)lightX, (int)lightY, (int)lightZ, Blocks.air);
					}
					
					this.updateLightPosition(entity, entity.posX, entity.posY, entity.posZ);
					
					
					for (int y = 0; y < 3; y++) {
						if (world.getBlock((int)lightX, (int)lightY + y, (int)lightZ).isAir(world, (int)lightX, (int)lightY + y, (int)lightZ)) {
							this.lightY += y;
							this.setLightBlock(world);
							break;
						}
					}
				}
			}
			else if (world.getBlock((int)lightX, (int)lightY, (int)lightZ).isAssociatedBlock(CoreBlocks.tapaziteLightSource)){
				world.setBlock((int)lightX, (int)lightY, (int)lightZ, Blocks.air);
			}
		}
	}
	
	public void updateLightPosition(Entity entity, double x, double y, double z) {
		lightX = entity.posX;
		lightY = entity.posY;
		lightZ = entity.posZ;
	}
	
	public void setLightBlock(World world) {
		world.setBlock((int)lightX, (int)lightY, (int)lightZ, CoreBlocks.tapaziteLightSource);
	}
}

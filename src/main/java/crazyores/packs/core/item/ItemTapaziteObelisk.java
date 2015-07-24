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

	private int lightX;
	private int lightY;
	private int lightZ;
	
	private int playerPosX;
	private int playerPosY;
	private int playerPosZ;
	
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
			if (((EntityPlayerMP)entity).getCurrentEquippedItem() == item) {
				
				playerPosX = (int)entity.posX;
				playerPosY = (int)entity.posY;
				playerPosZ = (int)entity.posZ;
				
				
//				System.out.println("ENTITY: " + entity.posX + ", " + entity.posY + ", " + entity.posZ);
//				System.out.println("ENTITY: " + playerPosX  + ", " + playerPosY  + ", " + playerPosZ);
//				System.out.println("LIGHT: "  + lightX      + ", " + lightY      + ", " + lightZ);
					
				
				if (world.getBlock((int)lightX, (int)lightY, (int)lightZ).isAssociatedBlock(CoreBlocks.tapaziteLightSource)) {
					world.setBlock((int)lightX, (int)lightY, (int)lightZ, Blocks.air);
				}
				updateLightPosition(entity);
				
				for (int y = 0; y < 3; y++) {
					if (world.getBlock((int)lightX, (int)lightY + y, (int)lightZ).isAir(world, (int)lightX, (int)lightY + y, (int)lightZ)) {
						this.lightY += y;
						this.setLightBlock(world);
						break;
					}
				}
			}
			else {
				world.setBlock((int)lightX, (int)lightY, (int)lightZ, Blocks.air);
			}
		}
	}
	
	private void updateLightPosition(Entity entity) {
		if (playerPosX < 0) lightX = playerPosX - 1;
		else lightX = playerPosX;
		lightY = playerPosY;
		if (playerPosZ < 0) lightZ = playerPosZ - 1;
		else lightZ = playerPosZ;
	}
	
	public void setLightBlock(World world) {
		world.setBlock((int)lightX, (int)lightY, (int)lightZ, CoreBlocks.tapaziteLightSource);
	}
}

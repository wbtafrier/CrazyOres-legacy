package crazyores.packs.core.event;

import crazyores.packs.core.block.CoreBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class ObeliskPlayerData {
	
	protected EntityPlayer player;
	
	protected double playerPosX;
	protected double playerPosY;
	protected double playerPosZ;
	
	protected double lightX;
	protected double lightY;
	protected double lightZ;
	
	protected ObeliskPlayerData(EntityPlayer p) {
		player = p;
		updatePlayerPosition();
		updateLightPosition();
		updateBlock();
	}
	
	public void updatePlayerPosition() {
		playerPosX = (int) player.posX;
		playerPosY = (int) player.posY;
		playerPosZ = (int) player.posZ;
	}
	
	public void updateLightPosition() {
		if (playerPosX < 0) lightX = playerPosX - 1;
		else lightX = playerPosX;
		lightY = playerPosY;
		if (playerPosZ < 0) lightZ = playerPosZ - 1;
		else lightZ = playerPosZ;
	}
	
	public void updateBlock() {
		World world = player.worldObj;
		
		if (world.getBlock((int)lightX, (int)lightY, (int)lightZ).isAssociatedBlock(CoreBlocks.tapaziteLightSource)) {
			world.setBlock((int)lightX, (int)lightY, (int)lightZ, Blocks.air);
		}
	}
	
	public void updateYPos() {
		World world = player.worldObj;
		
		for (int y = 0; y < 3; y++) {
			if (world.getBlock((int)lightX, (int)lightY + y, (int)lightZ).isAir(world, (int)lightX, (int)lightY + y, (int)lightZ)) {
				this.lightY += y;
				this.setLightBlock(world);
				break;
			}
		}
	}
	
	public void setLightBlock(World world) {
		world.setBlock((int)lightX, (int)lightY, (int)lightZ, CoreBlocks.tapaziteLightSource);
	}
	
	public EntityPlayer getPlayer() {
		return player;
	}
}

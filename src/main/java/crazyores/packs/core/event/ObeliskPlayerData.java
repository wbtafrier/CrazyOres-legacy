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
	
	public synchronized void updatePlayerPosition() {
		playerPosX = (int) player.posX;
		playerPosY = (int) player.posY;
		playerPosZ = (int) player.posZ;
	}
	
	public synchronized void updateLightPosition() {
		if (playerPosX < 0) lightX = playerPosX - 1;
		else lightX = playerPosX;
		lightY = playerPosY;
		if (playerPosZ < 0) lightZ = playerPosZ - 1;
		else lightZ = playerPosZ;
	}
	
	public synchronized boolean needsUpdate() {
		return ((int)playerPosX != (int)player.posX) || ((int)playerPosY != (int)player.posY) || ((int)playerPosZ != (int)player.posZ);
	}
	
	public synchronized void updateBlock() {
		World world = player.worldObj;
		
		for (int x = -1; x <= 1; x++)
			if (world.getBlock((int)(lightX) + x, (int)(lightY), (int)(lightZ)).isAssociatedBlock(CoreBlocks.tapaziteLightSource))
				world.setBlock((int)(lightX) + x, (int)lightY, (int)lightZ, Blocks.air);
		
		for (int y = -1; y <= 1; y++)
			if (world.getBlock((int)(lightX), (int)(lightY) + y, (int)(lightZ)).isAssociatedBlock(CoreBlocks.tapaziteLightSource))
				world.setBlock((int)lightX, (int)(lightY) + y, (int)lightZ, Blocks.air);
		
		for (int z = -1; z <= 1; z++)
			if (world.getBlock((int)(lightX), (int)(lightY), (int)(lightZ) + z).isAssociatedBlock(CoreBlocks.tapaziteLightSource))
				world.setBlock((int)lightX, (int)(lightY), (int)(lightZ) + z, Blocks.air);
		
//		if (world.getBlock((int)lightX, (int)lightY, (int)lightZ).isAssociatedBlock(CoreBlocks.tapaziteLightSource)) {
//			world.setBlock((int)lightX, (int)lightY, (int)lightZ, Blocks.air);
//		}
	}
	
	public synchronized void updateYPos() {
		World world = player.worldObj;
		
		for (int y = 0; y < 3; y++) {
			if (world.getBlock((int)lightX, (int)lightY + y, (int)lightZ).isAir(world, (int)lightX, (int)lightY + y, (int)lightZ)) {
				this.lightY += y;
				this.setLightBlock(world);
				break;
			}
		}
	}
	
	public synchronized void setLightBlock(World world) {
		world.setBlock((int)lightX, (int)lightY, (int)lightZ, CoreBlocks.tapaziteLightSource);
	}
	
	public synchronized EntityPlayer getPlayer() {
		return player;
	}
}

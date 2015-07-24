package crazyores.packs.core.event;

import net.minecraft.entity.player.EntityPlayer;

public class ObeliskPlayerData {
	protected EntityPlayer player;
	protected int lightX;
	protected int lightY;
	protected int lightZ;
	
	protected ObeliskPlayerData(EntityPlayer p, int x, int y, int z) {
		this.player = p;
		this.lightX = x;
		this.lightY = y;
		this.lightZ = z;
	}
}

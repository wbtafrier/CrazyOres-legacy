package crazyores.packs.core.entity.tileentity;

import java.util.Random;

import crazyores.packs.core.block.BlockLuminiteDisco;
import crazyores.packs.core.block.BlockLuminiteStorage;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLuminiteDisco extends TileEntity {

	private static Random rand = new Random();
	
	private short luminiteType;
	
	public TileEntityLuminiteDisco() {
		super();
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.luminiteType = nbt.getShort("type");
    }

	@Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setShort("type", this.luminiteType);
    }
	
	@Override
	public void updateEntity() {
		
		boolean update = false;
		
		if (!this.worldObj.isRemote) {
			if (rand.nextInt(30) == 0) {
				updateType();
				BlockLuminiteDisco.updateBlockState(this.worldObj, this.xCoord, this.yCoord, this.zCoord, luminiteType);
				update = true;
			}
		}
		
		if (update) {
			this.markDirty();
		}
	}
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tagCompound = new NBTTagCompound();
		writeToNBT(tagCompound);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tagCompound);
	}
    
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		NBTTagCompound tag = pkt.func_148857_g();
		readFromNBT(tag);
	}
	
	public void updateType() {
		if (this.worldObj != null && !this.worldObj.isRemote) {
			luminiteType = (short)(rand.nextInt(BlockLuminiteStorage.LUMINITE_STORAGE_BLOCK_SUBTYPES.length - 2) + 1);
			System.out.println("changing color to " + luminiteType + "!");
		}
	}
	
	public short getLuminiteType() {
		return luminiteType;
	}
}

package crazyores.packs.core.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import crazyores.packs.core.container.ContainerDemoniteFurnace;
import crazyores.packs.core.entity.tileentity.TileEntityDemoniteFurnace;

public class CoreGuiRegistry implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		
		if (tileEntity instanceof TileEntityDemoniteFurnace) {
			return new ContainerDemoniteFurnace(player.inventory, (TileEntityDemoniteFurnace)tileEntity);
		}
        return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		
		if (tileEntity instanceof TileEntityDemoniteFurnace) {
			return new GuiDemoniteFurnace(player.inventory, (TileEntityDemoniteFurnace)tileEntity);
		}
        return null;
	}
}

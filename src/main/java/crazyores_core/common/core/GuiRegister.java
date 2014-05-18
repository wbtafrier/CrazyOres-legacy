package crazyores_core.common.core;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import crazyores_core.client.gui.GuiDemoniteFurnace;
import crazyores_core.common.tileentity.ContainerDemoniteFurnace;
import crazyores_core.common.tileentity.TileEntityDemoniteFurnace;

/**
 * Where GUIs and Containers are created and sent back to the block. Container is made in the server to store the contents,
 * while a GUI is made in client to display it.
 * 
 * @author ISQUISHALL
 *
 */
public class GuiRegister implements IGuiHandler
{
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == GuiList.DEMONITE_FURNACE_GUI_ID)
		{
			return new ContainerDemoniteFurnace(player.inventory, (TileEntityDemoniteFurnace) world.getTileEntity(x, y, z));
		}
		return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == GuiList.DEMONITE_FURNACE_GUI_ID)
		{
			return new GuiDemoniteFurnace(player.inventory, (TileEntityDemoniteFurnace) world.getTileEntity(x, y, z));
		}
		return null;
	}

}

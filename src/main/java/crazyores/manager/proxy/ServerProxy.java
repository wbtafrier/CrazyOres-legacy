package crazyores.manager.proxy;

import java.io.File;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ServerProxy implements IProxy {

	@Override
	public void renderEntities() {}

	@Override
	public File getMinecraftDir() {
		return FMLCommonHandler.instance().getMinecraftServerInstance().getFile("");
	}

	@Override
	public void registerProxyEvents() {}
}

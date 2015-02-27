package crazyores.manager.proxy;

import java.io.File;

import cpw.mods.fml.common.FMLCommonHandler;

public class ServerProxy implements IProxy {

	@Override
	public void renderEntities() {}

	@Override
	public void registerTileEntites() {}

	@Override
	public File getMinecraftDir() {
		return FMLCommonHandler.instance().getMinecraftServerInstance().getFile("");
	}
}

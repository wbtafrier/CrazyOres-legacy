package crazyores_core.proxy;

import java.io.File;

import cpw.mods.fml.common.FMLCommonHandler;

/**
 * ServerProxy holds all server exclusive methods.
 * @author Andy608 and ISQUISHALL
 */
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

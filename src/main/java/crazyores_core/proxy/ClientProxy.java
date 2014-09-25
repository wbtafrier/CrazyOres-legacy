package crazyores_core.proxy;

import java.io.File;

/**
 * ClientProxy holds all client exclusive methods.
 * @author Andy608 and ISQUISHALL
 */
public class ClientProxy implements IProxy {
	
	@Override
	public void renderEntities() {}

	@Override
	public void registerTileEntites() {}

	@Override
	public File getMinecraftDir() {
		return null;
	}
}

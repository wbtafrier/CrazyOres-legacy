package crazyores.manager.proxy;

import java.io.File;

/**
 * An interface that contains all methods related to server and clientside specifics.
 * @author Andy608 and ISQUISHALL
 */
public interface IProxy {

	/** 
	 * @clientside
	 * Assigns all entity classes to their respective render classes.
	 */
	public abstract void renderEntities();
	
	/**	 
	 * Registers all Tile Entities into the {@link cpw.mods.fml.client.registry.RenderingRegistry}.
	 */
	public abstract void registerTileEntites();
	
	/**
	 * Retrieves Minecraft main file directory. Used for creating custom mod directories/files.
	 * @return instance of a File containing the path of the main Minecraft directory
	 */
	public abstract File getMinecraftDir();
}

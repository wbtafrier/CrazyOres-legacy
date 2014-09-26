package crazyores_core.proxy;
import java.io.File;

/**
 * IProxy is an interface that contains all the methods necessary for serverside and clientside specifics.
 * @author Andy608 and ISQUISHALL
 */
public interface IProxy {
	/** 
	 * Assigns all entity classes to their respective render classes. - clientside
	 * @return void
	 */
	public abstract void renderEntities();
	
	/**
	 * Retrieves Minecraft main file directory. Used for creating custom mod directories/files.
	 * @return instance of a File containing the path of the main Minecraft directory
	 */
	public abstract File getMinecraftDir();
	
	/**
	 * Registers all Tile Entities into the {@link cpw.mods.fml.client.registry.RenderingRegistry}.
	 * @return void
	 */
	public abstract void registerTileEntites();
}
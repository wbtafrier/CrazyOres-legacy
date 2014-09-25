package crazyores_core.proxy;
import java.io.File;

/**
 * IProxy is an interface that contains all the methods necessary for serverside and clientside specifics.
 * @author Andy608 and ISQUISHALLs
 */
public interface IProxy {
	/** 
	 * Assigns all entity classes to their respective render classes. - clientside 
	 * @return void.
	 */
	public abstract void renderEntities();
	
	/**
	 * TODO:Finish writing definition
	 */
	public abstract void registerTileEntites();
}

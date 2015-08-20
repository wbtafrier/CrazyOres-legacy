package crazyores.manager.proxy;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ObfuscationReflectionHelper;

/**
 * An interface that contains all methods related to server and clientside specifics.
 * @author Andy608 and ISQUISHALL
 */
public interface IProxy {

	public abstract void registerProxyEvents();
	
	/** 
	 * @clientside
	 * Assigns all entity classes to their respective render classes.
	 */
	public abstract void renderEntities();
	
	/**
	 * Retrieves Minecraft main file directory. Used for creating custom mod directories/files.
	 * @return instance of a File containing the path of the main Minecraft directory
	 */
	public abstract File getMinecraftDir();
}

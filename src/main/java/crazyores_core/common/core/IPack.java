package crazyores_core.common.core;
import net.minecraft.util.EnumChatFormatting;

/**
 * An interface for dealing with the packs for CrazyOres.
 * @author ISQUISHALL and Andy608
 */

public interface IPack {
	/**
	 * Retrieves the name of the expansion pack.
	 * @returns the name of the expansion pack.
	 */
	public String getPackName();
	
	/**
	 * Retrieves the expansion packs color code to be used for ingame chat messages.
	 * @returns the expansion pack color represented by a constant from EnumChatFormatting.
	 */
	public EnumChatFormatting getPackColor();
	
	/**
	 * Retrieves the expansion pack prefix for ingame chat messgaes.
	 * @returns the expansion pack prefix.
	 */
	public String getPackChatPrefix();
}

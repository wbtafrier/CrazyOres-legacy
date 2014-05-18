package crazyores_core.common.core;

import net.minecraft.util.EnumChatFormatting;

/**
 * An interface for all main expansion pack files to implement. Kind of like a registration for expansion packs.
 * @author ISQUISHALL
 *
 */
public interface IPack
{
	/**
	 * Retrieves the name of the expansion pack.
	 * @return The name of the expansion pack.
	 */
	public String getPackName();
	
	/**
	 * Retrieves the expansion packs color code to be used in chat messages.
	 * @return The expansion pack color represented by a constant in EnumChatFormatting.
	 */
	public EnumChatFormatting getPackColor();
	
	/**
	 * Retrieves the expansion pack header or prefix to chat messages.
	 * @return The expansion pack header (should be prefaced with the pack color and end with a reset).
	 */
	public String getPackChatHeader();
}

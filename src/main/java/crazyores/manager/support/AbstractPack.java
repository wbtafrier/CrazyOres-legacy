package crazyores.manager.support;
import net.minecraft.util.text.TextFormatting;

public abstract class AbstractPack {
	
	private final String fullPackName;
	private final String packName;
	private final String packVersion;
	private final String packID;
	private final TextFormatting packColor;
	
	/**
	 * Pack constructor. Sets all the variables neccessary for a pack.
	 * @param fullName is the name of the pack and the prefix. ie: CrazyOres Core
	 * @param name is the name of the pack. ie: Core
	 * @param version is the version number of the pack in String form ie: 2.0
	 * @param ID is the id of the pack. ie: crazyores_core
	 * @param color is the color of the pack that will be displayed in the chat window.
	 */
	public AbstractPack(String fullName, String name, String version, String ID, TextFormatting color) {
		fullPackName = fullName;
		packName = name;
		packVersion = version;
		packID = ID;
		packColor = color;
	}
	
	/**
	 * Retrieves the full name of the expansion pack.
	 * @return the full name of the expansion pack. ie: "CrazyOres Core"
	 */
	public final String getFullPackName() {
		return fullPackName;
	}
	
	/**
	 * Retrieves the name of the expansion pack.
	 * @return the name of the expansion pack. ie: "Core"
	 */
	public final String getPackName() {
		return packName;
	}
	
	/**
	 * Retrieves the pack ID.
	 * @return returns the pack ID.
	 */
	public final String getPackID() {
		return packID;
	}
	
	/**
	 * Retrieves the pack version.
	 * @return the version of the pack.
	 */
	public final String getPackVersion() {
		return packVersion;
	}
	
	/**
	 * Retrieves the pack color.
	 * @return the color for the pack to be displayed in the chat.
	 */
	public final TextFormatting getPackChatColor() {
		return packColor;
	}
}
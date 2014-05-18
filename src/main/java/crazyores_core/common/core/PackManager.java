package crazyores_core.common.core;

/**
 * This class keeps track of what expansion packs are installed. ONLY mess with the values if an expansion is being enabled or disabled. 
 * @author ISQUISHALL
 *
 */
public class PackManager
{
	/** CrazyOres Core installed? (Obviously) **/
	public static boolean coreInstalled = true;
	
	/**Ultra Expansion Pack - Gives CrazyOres a full experience and a new goal for players to reach. **/
	public static boolean ultraPackInstalled = false;
	
	/** Edibles Expansion Pack - Adds all kinds of foods and drinks to CrazyOres, so players can get a real taste of the mod. **/
	public static boolean ediblesPackInstalled = false;
	
	/** Nature Expansion Pack - Gives the player a new feeling of their world with new plants, animals, and biomes. **/
	public static boolean naturePackInstalled = false;
	
	/** Evil Expansion Pack - Allows for brave and daring players to see the dark side of CrazyOres. **/
	public static boolean evilPackInstalled = false;
	
	/** Decoration Expansion Pack - Gives the player new blocks to make their creations even prettier. **/
	public static boolean decorationPackInstalled = false;
	
	/** Mechanical Expansion Pack - Allows the player to make new gizmos and machines to improve their creations. **/
	public static boolean mechanicalPackInstalled = false;
	
	/** Explosions Expansion Pack - Gives the player to have a blast with new, dangerous nukes and other items. **/
	public static boolean explosionsPackInstalled = false;
	
	/** Water Expansion Pack - Allows the player to explore the sea and sea new areas in the ocean that they have never seen before. **/
	public static boolean waterPackInstalled = false;
	
	/** Weapons Expansion Pack - Gives the player a shot at making new guns and weapons. **/
	public static boolean weaponsPackInstalled = false;
}

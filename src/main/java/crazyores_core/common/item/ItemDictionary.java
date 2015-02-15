package crazyores_core.common.item;

import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.oredict.OreDictionary;

/**
 * ItemDictionary registers all CO Items to the Ore Dictionary in order to enable better compatibility between mods, and stores their Dictionary names.
 * @author ISQUISHALL and Andy608
 */
public class ItemDictionary {
	
	public static final String GEM_FOOLS_RUBY = "gemFoolsRuby";
	public static final String COAL_METEORITE = "coalMeteorite";
	public static final String GEM_METEORITE = "gemMeteorite";
	public static final String INGOT_COPPER = "ingotCopper";
	public static final String ORB_EXPERIUM = "orbExperium";
	public static final String ORB_XP = "orbXP";
	public static final String ORB_EXPERIENCE = "orbExperience";
	public static final String GEM_SAPPHIRE = "gemSapphire";
	public static final String SHARD_ADAMITE = "shardAdamite";
	public static final String INGOT_INVISIUM = "ingotInvisium";
	public static final String GEM_RUBY = "gemRuby";
	public static final String INGOT_DARKSTONE = "ingotDarkstone";
	public static final String INGOT_ZECTIUM = "ingotZectium";
	public static final String GEM_TAPAZITE = "gemTapazite";
	public static final String ORB_DEMONITE = "orbDemonite";
	public static final String INGOT_OSMONIUM = "ingotOsmonium";
	public static final String GEM_STARCONIUM = "gemStarconium";
	public static final String GEM_ENDER = "gemEnder";
	public static final String GEM_ULTRA = "gemUltra";
	
	public static final String MUSH_FOOLS_RUBY = "mushFoolsRuby";
	public static final String SHARD_STARCONIUM = "shardStarconium";
	
	/**
	 * Registers all CO Items to the Ore Dictionary using compatible names.
	 */
	public static void registerItemsToOreDictionary() {
		OreDictionary.registerOre(GEM_FOOLS_RUBY, ItemList.fools_ruby_gem);
		OreDictionary.registerOre(COAL_METEORITE, ItemList.meteorite_coal);
		OreDictionary.registerOre(GEM_METEORITE, ItemList.meteorite_gem);
		OreDictionary.registerOre(INGOT_COPPER, ItemList.copper_ingot);
		OreDictionary.registerOre(ORB_EXPERIUM, ItemList.experium_orb);
		OreDictionary.registerOre(ORB_XP, ItemList.experium_orb);
		OreDictionary.registerOre(ORB_EXPERIENCE, ItemList.experium_orb);
		OreDictionary.registerOre(GEM_SAPPHIRE, ItemList.sapphire_gem);
		OreDictionary.registerOre(SHARD_ADAMITE, ItemList.adamite_shard);
		OreDictionary.registerOre(INGOT_INVISIUM, ItemList.invisium_ingot);
		OreDictionary.registerOre(GEM_RUBY, ItemList.ruby_gem);
		OreDictionary.registerOre(INGOT_DARKSTONE, ItemList.darkstone_ingot);
		OreDictionary.registerOre(INGOT_ZECTIUM, ItemList.zectium_ingot);
		OreDictionary.registerOre(GEM_TAPAZITE, ItemList.tapazite_gem);
		OreDictionary.registerOre(ORB_DEMONITE, ItemList.demonite_orb);
		OreDictionary.registerOre(INGOT_OSMONIUM, ItemList.osmonium_ingot);
		OreDictionary.registerOre(GEM_STARCONIUM, ItemList.starconium_gem);
		OreDictionary.registerOre(GEM_ENDER, ItemList.ender_gem);
		OreDictionary.registerOre(GEM_ULTRA, ItemList.ultra_gem);
		
		OreDictionary.registerOre(MUSH_FOOLS_RUBY, ItemList.fools_ruby_mush);
		OreDictionary.registerOre(SHARD_STARCONIUM, ItemList.starconium_shard);
	}
}

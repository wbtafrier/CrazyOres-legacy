package crazyores_core.common.block;

import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.oredict.OreDictionary;

/**
 * BlockDictionary registers all CO Blocks to the Ore Dictionary in order to enable better compatibility between mods, and stores their Dictionary names.
 * @author ISQUISHALL and Andy608
 */
public class BlockDictionary {
	
	public static final String ORE_FOOLS_RUBY = "oreFoolsRuby";
	public static final String ORE_METEORITE = "oreMeteorite";
	public static final String ORE_COPPER = "oreCopper";
	public static final String ORE_EXPERIUM = "oreExperium";
	public static final String ORE_XP = "oreXP";
	public static final String ORE_EXPERIENCE = "oreExperience";
	public static final String ORE_SAPPHIRE = "oreSapphire";
	public static final String ORE_ADAMITE = "oreAdamite";
	public static final String ORE_INVISIUM = "oreInvisium";
	public static final String ORE_RUBY = "oreRuby";
	public static final String ORE_DARKSTONE = "oreDarkstone";
	public static final String ORE_ZECTIUM = "oreZectium";
	public static final String ORE_TAPAZITE = "oreTapazite";
	public static final String ORE_DEMONITE = "oreDemonite";
	public static final String ORE_OSMONIUM = "oreOsmonium";
	public static final String ORE_STARCONIUM = "oreStarconium";
	public static final String ORE_ENDER = "oreEnder";
	public static final String ORE_ULTRA = "oreUltra";

	public static final String BLOCK_STORAGE_FOOLS_RUBY = "blockStorageFoolsRuby";
	public static final String BLOCK_STORAGE_METEORITE = "blockStorageMeteorite";
	public static final String BLOCK_STORAGE_COPPER = "blockStorageCopper";
	public static final String BLOCK_STORAGE_EXPERIUM = "blockStorageExperium";
	public static final String BLOCK_STORAGE_XP = "blockStorageXP";
	public static final String BLOCK_STORAGE_EXPERIENCE = "blockStorageExperience";
	public static final String BLOCK_STORAGE_SAPPHIRE = "blockStorageSapphire";
	public static final String BLOCK_STORAGE_ADAMITE = "blockStorageAdamite";
	public static final String BLOCK_STORAGE_INVISIUM = "blockStorageInvisium";
	public static final String BLOCK_STORAGE_RUBY = "blockStorageRuby";
	public static final String BLOCK_STORAGE_DARKSTONE = "blockStorageDarkstone";
	public static final String BLOCK_STORAGE_ZECTIUM = "blockStorageZectium";
	public static final String BLOCK_STORAGE_TAPAZITE = "blockStorageTapazite";
	public static final String BLOCK_STORAGE_DEMONITE = "blockStorageDemonite";
	public static final String BLOCK_STORAGE_OSMONIUM = "blockStorageOsmonium";
	public static final String BLOCK_STORAGE_STARCONIUM = "blockStorageStarconium";
	public static final String BLOCK_STORAGE_ENDER = "blockStorageEnder";
	public static final String BLOCK_STORAGE_ULTRA = "blockStorageUltra";
	
	/**
	 * Registers all CO Blocks to the Ore Dictionary using compatible names.
	 */
	public static void registerBlocksToOreDictionary() {
		OreDictionary.registerOre(ORE_FOOLS_RUBY, BlockList.fools_ruby_ore);
		OreDictionary.registerOre(ORE_METEORITE, BlockList.meteorite_ore);
		OreDictionary.registerOre(ORE_COPPER, BlockList.copper_ore);
		OreDictionary.registerOre(ORE_EXPERIUM, BlockList.experium_ore);
		OreDictionary.registerOre(ORE_XP, BlockList.experium_ore);
		OreDictionary.registerOre(ORE_EXPERIENCE, BlockList.experium_ore);
		OreDictionary.registerOre(ORE_SAPPHIRE, BlockList.sapphire_ore);
		OreDictionary.registerOre(ORE_ADAMITE, BlockList.adamite_ore);
		OreDictionary.registerOre(ORE_INVISIUM, BlockList.invisium_ore);
		OreDictionary.registerOre(ORE_RUBY, BlockList.ruby_ore);
		OreDictionary.registerOre(ORE_DARKSTONE, BlockList.darkstone);
		OreDictionary.registerOre(ORE_ZECTIUM, BlockList.zectium_ore);
		OreDictionary.registerOre(ORE_TAPAZITE, BlockList.tapazite_ore);
		OreDictionary.registerOre(ORE_DEMONITE, BlockList.demonite_ore);
		OreDictionary.registerOre(ORE_OSMONIUM, BlockList.osmonium_ore);
		OreDictionary.registerOre(ORE_STARCONIUM, BlockList.starconium_ore);
		OreDictionary.registerOre(ORE_ENDER, BlockList.ender_ore);
		OreDictionary.registerOre(ORE_ULTRA, BlockList.ultra_ore);
	
		OreDictionary.registerOre(BLOCK_STORAGE_FOOLS_RUBY, BlockList.fools_ruby_storage_block);
		OreDictionary.registerOre(BLOCK_STORAGE_METEORITE, BlockList.meteorite_storage_block);
		OreDictionary.registerOre(BLOCK_STORAGE_COPPER, BlockList.copper_storage_block);
		OreDictionary.registerOre(BLOCK_STORAGE_EXPERIUM, BlockList.experium_storage_block);
		OreDictionary.registerOre(BLOCK_STORAGE_XP, BlockList.experium_storage_block);
		OreDictionary.registerOre(BLOCK_STORAGE_EXPERIENCE, BlockList.experium_storage_block);
		OreDictionary.registerOre(BLOCK_STORAGE_SAPPHIRE, BlockList.sapphire_storage_block);
		OreDictionary.registerOre(BLOCK_STORAGE_ADAMITE, BlockList.adamite_storage_block);
		OreDictionary.registerOre(BLOCK_STORAGE_INVISIUM, BlockList.invisium_storage_block);
		OreDictionary.registerOre(BLOCK_STORAGE_RUBY, BlockList.ruby_storage_block);
		OreDictionary.registerOre(BLOCK_STORAGE_DARKSTONE, BlockList.darkstone_storage_block);
		OreDictionary.registerOre(BLOCK_STORAGE_ZECTIUM, BlockList.zectium_storage_block);
		OreDictionary.registerOre(BLOCK_STORAGE_TAPAZITE, BlockList.tapazite_storage_block);
		OreDictionary.registerOre(BLOCK_STORAGE_DEMONITE, BlockList.demonite_storage_block);
		OreDictionary.registerOre(BLOCK_STORAGE_OSMONIUM, BlockList.osmonium_storage_block);
		OreDictionary.registerOre(BLOCK_STORAGE_STARCONIUM, BlockList.starconium_storage_block);
		OreDictionary.registerOre(BLOCK_STORAGE_ENDER, BlockList.ender_storage_block);
		OreDictionary.registerOre(BLOCK_STORAGE_ULTRA, BlockList.ultra_storage_block);
	}
}

package crazyores_core.common.block;

import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.oredict.OreDictionary;

/**
 * BlockDictionary registers all CO Blocks to the Ore Dictionary in order to enable better compatibility between mods, and stores their Dictionary names.
 * @author ISQUISHALL and Andy608
 */
public class BlockDictionary {
	
	public static String ORE_FOOLS_RUBY = "oreFoolsRuby";
	public static String ORE_METEORITE = "oreMeteorite";
	public static String ORE_COPPER = "oreCopper";
	public static String ORE_EXPERIUM = "oreExperium";
	public static String ORE_XP = "oreXP";
	public static String ORE_EXPERIENCE = "oreExperience";
	public static String ORE_SAPPHIRE = "oreSapphire";
	public static String ORE_ADAMITE = "oreAdamite";
	public static String ORE_INVISIUM = "oreInvisium";
	public static String ORE_RUBY = "oreRuby";
	public static String ORE_DARKSTONE = "oreDarkstone";
	public static String ORE_ZECTIUM = "oreZectium";
	public static String ORE_LUMINITE = "oreLuminite";
	public static String ORE_TAPAZITE = "oreTapazite";
	public static String ORE_DEMONITE = "oreDemonite";
	public static String ORE_OSMONIUM = "oreOsmonium";
	public static String ORE_STARCONIUM = "oreStarconium";
	public static String ORE_ENDER = "oreEnder";
	public static String ORE_ULTRA = "oreUltra";
	
	public static String[] BLOCKS_LUMINITE = {"blockWhiteLuminite", "blockRedLuminite", "blockOrangeLuminite", 
		"blockYellowLuminite", "blockGreenLuminitie", "blockBlueLuminite", "blockPurpleLuminite", "blockBlackLuminite"};
	
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
		OreDictionary.registerOre(ORE_LUMINITE, BlockList.luminite_ore);
		OreDictionary.registerOre(ORE_TAPAZITE, BlockList.tapazite_ore);
		OreDictionary.registerOre(ORE_DEMONITE, BlockList.demonite_ore);
		OreDictionary.registerOre(ORE_OSMONIUM, BlockList.osmonium_ore);
		OreDictionary.registerOre(ORE_STARCONIUM, BlockList.starconium_ore);
		OreDictionary.registerOre(ORE_ENDER, BlockList.ender_ore);
		OreDictionary.registerOre(ORE_ULTRA, BlockList.ultra_ore);
		
		for (int metadata = 0; metadata < BLOCKS_LUMINITE.length; metadata++) {
			metadata = MathHelper.clamp_int(metadata, 0, BLOCKS_LUMINITE.length - 1);
			OreDictionary.registerOre(BLOCKS_LUMINITE[metadata], new ItemStack(BlockList.luminite_block, 1, metadata));
		}
	}
}

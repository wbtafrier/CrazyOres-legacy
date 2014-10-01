package crazyores_core.common.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores_core.common.core.COData;

/**
 * ItemList initializes and registers all of the items in the CrazyOres Core.
 * @author Andy608 and ISQUISHALL
 */
@GameRegistry.ObjectHolder(COData.MOD_ID)
public class ItemList {

	/**
	 * Meteorite Coal. A unique form of Coal dropped 80% of the time by Meteorite Ore. Used to smelt in a Furnace or Demonite Furnace.
	 */
	public static final Item meteoriteCoal = new COItem();
	public static final Item meteoriteGem = new COItem();
	public static final Item copperIngot = new COItem();
	public static final Item sapphireGem = new COItem();
	public static final Item adamiteShard = new COItem();
	public static final Item rubyGem = new COItem();
	public static final Item foolsRubyGem = new COItem();
	public static final Item zectiumIngot = new COItem();
	public static final Item tapaziteGem = new COItem();
	public static final Item crystalShard = new COItem();
	public static final Item osmoniumIngot = new COItem();
	public static final Item starconiumGem = new COItem();
	public static final Item demoniteOrb = new COItem();
	public static final Item experiumOrb = new COItem();
	public static final Item enderGem = new COItem();
	public static final Item darkstoneIngot = new COItem();
	public static final Item invisiumIngot = new COItem();
	public static final Item ultraGem = new COItem();
	public static final Item whiteLuminiteCrystal = new COItem();
	
	/**
	 * Initialization of all CO Core Items.
	 */
	public static void itemInitialization() {
		registerAndNameItem(meteoriteCoal, ItemNames.METEORITE_COAL);
		registerAndNameItem(meteoriteGem, ItemNames.METEORITE_GEM);
		registerAndNameItem(copperIngot, ItemNames.COPPER_INGOT);
		registerAndNameItem(sapphireGem, ItemNames.SAPPHIRE_GEM);
		registerAndNameItem(adamiteShard, ItemNames.ADAMITE_SHARD);
		registerAndNameItem(rubyGem, ItemNames.RUBY_GEM);
		registerAndNameItem(foolsRubyGem, ItemNames.FOOLS_RUBY_GEM);
		registerAndNameItem(zectiumIngot, ItemNames.ZECTIUM_INGOT);
		registerAndNameItem(tapaziteGem, ItemNames.TAPAZITE_GEM);
		registerAndNameItem(crystalShard, ItemNames.CRYSTAL_SHARD);
		registerAndNameItem(osmoniumIngot, ItemNames.OSMONIUM_INGOT);
		registerAndNameItem(starconiumGem, ItemNames.STARCONIUM_GEM);
		registerAndNameItem(demoniteOrb, ItemNames.DEMONITE_ORB);
		registerAndNameItem(experiumOrb, ItemNames.EXPERIUM_ORB);
		registerAndNameItem(enderGem, ItemNames.ENDER_GEM);
		registerAndNameItem(darkstoneIngot, ItemNames.DARKSTONE_INGOT);
		registerAndNameItem(invisiumIngot, ItemNames.INVISIUM_INGOT);
		registerAndNameItem(ultraGem, ItemNames.ULTRA_GEM);
		registerAndNameItem(whiteLuminiteCrystal, ItemNames.WHITE_LUMINITE_CRYSTAL);
	}
	
	/**
	 * Registers and sets the unlocalized name of a CO Item.
	 * @param item The Item to be registered and named. 
	 * @param itemName The name of the Item as a String.
	 */
	public static void registerAndNameItem(Item item, String itemName) {
		item.setUnlocalizedName(itemName);
		GameRegistry.registerItem(item, itemName);
	}
}

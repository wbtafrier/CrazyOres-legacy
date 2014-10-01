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

	public static final Item fools_ruby_gem = new COItem();
	public static final Item meteorite_coal = new COItem();
	public static final Item meteorite_gem = new COItem();
	public static final Item copper_ingot = new COItem();
	public static final Item experium_orb = new COItem();
	public static final Item sapphire_gem = new COItem();
	public static final Item adamite_shard = new COItem();
	public static final Item invisium_ingot = new COItem();
	public static final Item ruby_gem = new COItem();
	public static final Item darkstone_ingot = new COItem();
	public static final Item zectium_ingot = new COItem();
	public static final Item white_luminite_crystal = new COItem();
	public static final Item tapazite_gem = new COItem();
	public static final Item demonite_orb = new COItem();
	public static final Item osmonium_ingot = new COItem();
	public static final Item starconium_gem = new COItem();
	public static final Item ender_gem = new COItem();
	public static final Item ultra_gem = new COItem();
	
	/**
	 * Initialization of all CO Core Items.
	 */
	public static void itemInitialization() {
		registerAndNameItem(fools_ruby_gem, ItemNames.FOOLS_RUBY_GEM);
		registerAndNameItem(meteorite_coal, ItemNames.METEORITE_COAL);
		registerAndNameItem(meteorite_gem, ItemNames.METEORITE_GEM);
		registerAndNameItem(copper_ingot, ItemNames.COPPER_INGOT);
		registerAndNameItem(experium_orb, ItemNames.EXPERIUM_ORB);
		registerAndNameItem(sapphire_gem, ItemNames.SAPPHIRE_GEM);
		registerAndNameItem(adamite_shard, ItemNames.ADAMITE_SHARD);
		registerAndNameItem(invisium_ingot, ItemNames.INVISIUM_INGOT);
		registerAndNameItem(ruby_gem, ItemNames.RUBY_GEM);
		registerAndNameItem(darkstone_ingot, ItemNames.DARKSTONE_INGOT);
		registerAndNameItem(zectium_ingot, ItemNames.ZECTIUM_INGOT);
		registerAndNameItem(white_luminite_crystal, ItemNames.WHITE_LUMINITE_CRYSTAL);
		registerAndNameItem(tapazite_gem, ItemNames.TAPAZITE_GEM);
		registerAndNameItem(demonite_orb, ItemNames.DEMONITE_ORB);
		registerAndNameItem(osmonium_ingot, ItemNames.OSMONIUM_INGOT);
		registerAndNameItem(starconium_gem, ItemNames.STARCONIUM_GEM);
		registerAndNameItem(ender_gem, ItemNames.ENDER_GEM);
		registerAndNameItem(ultra_gem, ItemNames.ULTRA_GEM);
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

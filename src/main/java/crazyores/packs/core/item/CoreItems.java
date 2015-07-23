package crazyores.packs.core.item;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.manager.tabs.COTabList;

public class CoreItems {

	/** ORE DROPS **/
	public static Item meteoriteCoal;
	public static Item meteoriteGem;
	public static Item copperIngot;
	public static Item sapphireGem;
	public static Item adamiteShard;
	public static Item rubyGem;
	public static Item foolsRubyGem;
	public static Item zectiumIngot;
	public static Item tapaziteObelisk;
	public static Item tapaziteDust;
	public static Item osmoniumIngot;
	public static Item starconiumGem;
	public static Item foolsRubyMush;
	public static Item demoniteOrb;
	public static Item experiumOrb;
	public static Item enderGem;
	public static Item darkstoneIngot;
	public static Item invisiumIngot;
	public static Item ultraGem;
	public static Item whiteLuminiteCrystal;
	
	
	/** Pickaxe List **/
	public static Item meteoritePickaxe;
	public static Item copperPickaxe;
	public static Item sapphirePickaxe;
	public static Item adamitePickaxe;
	public static Item rubyPickaxe;
	public static Item zectiumPickaxe;
	public static Item tapazitePickaxe;
	public static Item osmoniumPickaxe;
	public static Item starconiumPickaxe;
	public static Item invisiumPickaxe;
	public static Item enderPickaxe;
	
	/** Axe List **/
	public static Item meteoriteAxe;
	public static Item copperAxe;
	public static Item sapphireAxe;
	public static Item adamiteAxe;
	public static Item rubyAxe;
	public static Item zectiumAxe;
	public static Item tapaziteAxe;
	public static Item osmoniumAxe;
	public static Item starconiumAxe;
	public static Item invisiumAxe;
	public static Item enderAxe;
	
	/** Shovel List **/
	public static Item meteoriteShovel;
	public static Item copperShovel;
	public static Item sapphireShovel;
	public static Item adamiteShovel;
	public static Item rubyShovel;
	public static Item zectiumShovel;
	public static Item tapaziteShovel;
	public static Item osmoniumShovel;
	public static Item starconiumShovel;
	public static Item invisiumShovel;
	public static Item enderShovel;
	
	/** Sword List **/
	public static Item meteoriteSword;
	public static Item copperSword;
	public static Item sapphireSword;
	public static Item adamiteSword;
	public static Item rubySword;
	public static Item zectiumSword;
	public static Item tapaziteSword;
	public static Item osmoniumSword;
	public static Item starconiumSword;
	public static Item invisiumSword;
	public static Item enderSword;
	
	/** Hoe List **/
	public static Item meteoriteHoe;
	public static Item copperHoe;
	public static Item sapphireHoe;
	public static Item adamiteHoe;
	public static Item rubyHoe;
	public static Item zectiumHoe;
	public static Item tapaziteHoe;
	public static Item osmoniumHoe;
	public static Item starconiumHoe;
	public static Item invisiumHoe;
	public static Item enderHoe;
	
	/** Hammer List **/
	public static Item starconiumSledgehammer;
	
	/** Helmet List **/
	public static Item copperHelmet;
	public static Item sapphireHelmet;
	public static Item adamiteHelmet;
	public static Item meteoriteHelmet;
	public static Item rubyHelmet;
	public static Item zectiumHelmet;
	public static Item tapaziteHelmet;
	public static Item osmoniumHelmet;
	public static Item starconiumHelmet;
	public static Item invisiumHelmet;
	public static Item enderHelmet;
	
	/** Chestplate List **/
	public static Item copperChestplate;
	public static Item sapphireChestplate;
	public static Item adamiteChestplate;
	public static Item meteoriteChestplate;
	public static Item rubyChestplate;
	public static Item zectiumChestplate;
	public static Item tapaziteChestplate;
	public static Item osmoniumChestplate;
	public static Item starconiumChestplate;
	public static Item invisiumChestplate;
	public static Item enderChestplate;
	
	/** Legging List **/
	public static Item copperLeggings;
	public static Item sapphireLeggings;
	public static Item adamiteLeggings;
	public static Item meteoriteLeggings;
	public static Item rubyLeggings;
	public static Item zectiumLeggings;
	public static Item tapaziteLeggings;
	public static Item osmoniumLeggings;
	public static Item starconiumLeggings;
	public static Item invisiumLeggings;
	public static Item enderLeggings;
	
	/** Boot List **/
	public static Item copperBoots;	
	public static Item sapphireBoots;
	public static Item adamiteBoots;
	public static Item meteoriteBoots;
	public static Item rubyBoots;
	public static Item zectiumBoots;
	public static Item tapaziteBoots;
	public static Item osmoniumBoots;
	public static Item starconiumBoots;
	public static Item invisiumBoots;
	public static Item enderBoots;
	
	/** Bucket List **/
	public static Item copperBucketEmpty;
	public static Item copperBucketWater;
	public static Item copperBucketLava;
	
	/** Items List **/
	public static Item starconiumShard;
	
	/** Rod List **/
	public static Item copperRod;
	public static Item sapphireRod;
	public static Item adamiteRod;
	public static Item meteoriteRod;
	public static Item rubyRod;
	public static Item zectiumRod;
	public static Item tapaziteRod;
	public static Item osmoniumRod;
	public static Item starconiumRod;
	public static Item invisiumRod;
	public static Item enderRod;
	
	/** Bow List **/
	public static Item meteoriteBow;
	public static Item copperBow;
	public static Item invisiumBow;
	public static Item sapphireBow;
	public static Item adamiteBow;
	public static Item rubyBow;
	public static Item zectiumBow;
	public static Item tapaziteBow;
	public static Item osmoniumBow;
	public static Item enderBow;
	public static Item starconiumBow;
	
	/** Arrow List **/
	public static Item meteoriteArrow;
	public static Item copperArrow;
	public static Item invisiumArrow;
	public static Item sapphireArrow;
	public static Item adamiteArrow;
	public static Item rubyArrow;
	public static Item zectiumArrow;
	public static Item tapaziteArrow;
	public static Item osmoniumArrow;
	public static Item enderArrow;
	public static Item starconiumArrow;
	
	public static void initItems() {
		meteoriteCoal = new CoreItem("meteorite_coal", COTabList.crazyOresItemsTab); registerItem(meteoriteCoal);
		meteoriteGem = new CoreItem("meteorite_gem", COTabList.crazyOresItemsTab); registerItem(meteoriteGem);
		copperIngot = new CoreItem("copper_ingot", COTabList.crazyOresItemsTab); registerItem(copperIngot);
		sapphireGem = new CoreItem("sapphire_gem", COTabList.crazyOresItemsTab); registerItem(sapphireGem);
		adamiteShard = new CoreItem("adamite_shard", COTabList.crazyOresItemsTab); registerItem(adamiteShard);
		rubyGem = new CoreItem("ruby_gem", COTabList.crazyOresItemsTab); registerItem(rubyGem);
		foolsRubyGem = new CoreItem("fools_ruby_gem", COTabList.crazyOresItemsTab); registerItem(foolsRubyGem);
		zectiumIngot = new CoreItem("zectium_ingot", COTabList.crazyOresItemsTab); registerItem(zectiumIngot);
		tapaziteObelisk = new ItemTapaziteObelisk("tapazite_obelisk", COTabList.crazyOresItemsTab); registerItem(tapaziteObelisk);
		/** TODO: ADD TEXTURE **/ tapaziteDust = new CoreItem("tapazite_dust", COTabList.crazyOresItemsTab); registerItem(tapaziteDust);
		osmoniumIngot = new CoreItem("osmonium_ingot", COTabList.crazyOresItemsTab); registerItem(osmoniumIngot);
		starconiumGem = new CoreItem("starconium_gem", COTabList.crazyOresItemsTab); registerItem(starconiumGem);
		foolsRubyMush = new CoreItem("fools_ruby_mush", COTabList.crazyOresItemsTab); registerItem(foolsRubyMush);
		demoniteOrb = new CoreItem("demonite_orb", COTabList.crazyOresItemsTab); registerItem(demoniteOrb);
		experiumOrb = new CoreItem("experium_orb", COTabList.crazyOresItemsTab); registerItem(experiumOrb);
		enderGem = new CoreItem("ender_gem", COTabList.crazyOresItemsTab); registerItem(enderGem);
		darkstoneIngot = new CoreItem("darkstone_ingot", COTabList.crazyOresItemsTab); registerItem(darkstoneIngot);
		invisiumIngot = new CoreItem("invisium_ingot", COTabList.crazyOresItemsTab); registerItem(invisiumIngot);
		ultraGem = new CoreItem("ultra_gem", COTabList.crazyOresItemsTab); registerItem(ultraGem);
		whiteLuminiteCrystal = new CoreItem("white_luminite_crystal", COTabList.crazyOresItemsTab); registerItem(whiteLuminiteCrystal);
	}
	
	private static void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
}

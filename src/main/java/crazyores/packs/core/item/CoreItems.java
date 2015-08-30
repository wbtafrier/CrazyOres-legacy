package crazyores.packs.core.item;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.manager.tabs.COTabList;
import crazyores.packs.core.block.CoreBlocks;
import crazyores.packs.core.tabs.CoreTabList;
import crazyores.packs.core.util.CoreHarvestLevels;

public class CoreItems {
	
	//Overworld ore drops
	public static Item copperIngot;
	
	public static Item meteoriteCoal;
	public static Item meteoriteGem;
	
	public static Item adamiteShard;
	public static Item sapphireGem;
	public static Item rubyGem;
	
	public static Item foolsRubyGem;
	public static Item foolsRubyMush;
	
	public static Item zectiumIngot;
	public static Item tapaziteObelisk;
	public static Item tapaziteDust;
	public static Item osmoniumIngot;
	public static Item starconiumGem;
	public static Item starconiumShard;
	public static Item experiumOrb;
	
	//Nether ore drops
	public static Item demoniteOrb;
	public static Item invisiumIngot;
	
	public static Item darkstoneIngot;
	
	//Ender ore drops
	public static Item enderGem;
	public static Item ultraGem;
	
	//Items
	public static Item zectiumCore;

	//Pickaxes
	public static Item copperPickaxe;
	public static Item meteoritePickaxe;
	public static Item adamitePickaxe;
	public static Item sapphirePickaxe;
	public static Item rubyPickaxe;
	public static Item zectiumPickaxe;
	public static Item tapazitePickaxe;
	public static Item osmoniumPickaxe;
	public static Item starconiumPickaxe;
	public static Item invisiumPickaxe;
	public static Item enderPickaxe;
	
	/** Axe List **/
	public static Item copperAxe;
	public static Item meteoriteAxe;
	public static Item adamiteAxe;
	public static Item sapphireAxe;
	public static Item rubyAxe;
	public static Item zectiumAxe;
	public static Item tapaziteAxe;
	public static Item osmoniumAxe;
	public static Item starconiumAxe;
	public static Item invisiumAxe;
	public static Item enderAxe;

	/** Shovel List **/
 	public static Item copperShovel;
	public static Item meteoriteShovel;
	public static Item adamiteShovel;
	public static Item sapphireShovel;
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

	/** Bucket List **/
	public static Item copperBucketEmpty;
	public static Item copperBucketWater;
	public static Item copperBucketLava;
	public static Item copperBucketMilk;
	
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

	//Cake!
	public static Item chocolateCake;
	public static Item strawberryCake;
	public static Item birthdayCake;
	
	//Custom Spawn Eggs
	public static Item zectiumProtectorEgg;
	public static Item greatWhiteSharkEgg;
	public static Item adamiteSharkEgg;
	
	/** Rod List **/
/*
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
*/
	
	/** Bow List **/

	public static Item swiftBow;
	public static Item hellBow;
	public static Item dualShotBow;
	public static Item confusionBow;
	
	/** Arrow List **/
	
	public static Item flamingArrow;
	public static Item explosiveArrow;
	public static Item freezingArrow;
	public static Item lightningArrow;
	
	/** ArrowHead List **/
	
	public static Item flamingArrowHead;
	public static Item explosiveArrowHead;
	public static Item freezingArrowHead;
	public static Item lightningArrowHead;

	public static Item rawSharkMeat;
	public static Item cookedSharkMeat;
	
	public static Item luminiteCrystal;
	
	public static void initItems() {
		initOreDrops();
//		initRods();
		initTools();
		initArmor();
		initBowsArrows();
		initSpawnEggs();
		initFood();
		
		//Items
		zectiumCore = new ItemZectiumCore("zectium_core", COTabList.crazyOresItemsTab, 32); registerItem(zectiumCore);
		
	}
	
	private static void initOreDrops() {
		//Overworld ore drops
		copperIngot = new CoreOre("copper_ingot", "ingotCopper"); registerItem(copperIngot);
		meteoriteCoal = new CoreOre("meteorite_coal", "coalMeteorite"); registerItem(meteoriteCoal);
		meteoriteGem = new CoreOre("meteorite_gem", "gemMeteorite"); registerItem(meteoriteGem);
		adamiteShard = new CoreOre("adamite_shard", "shardAdamite"); registerItem(adamiteShard);
		sapphireGem = new CoreOre("sapphire_gem", "gemSapphire"); registerItem(sapphireGem);
		rubyGem = new CoreOre("ruby_gem", "gemRuby"); registerItem(rubyGem);
		foolsRubyGem = new CoreOre("fools_ruby_gem", "gemFoolsRuby"); registerItem(foolsRubyGem);
		foolsRubyMush = new CoreOre("fools_ruby_mush", "mushFoolsRuby"); registerItem(foolsRubyMush);
		zectiumIngot = new CoreOre("zectium_ingot", "ingotZectium"); registerItem(zectiumIngot);
		tapaziteObelisk = new CoreOre("tapazite_obelisk", "obeliskTapazite"); registerItem(tapaziteObelisk);
		tapaziteDust = new CoreOre("tapazite_dust", "dustTapazite"); registerItem(tapaziteDust);
		osmoniumIngot = new CoreOre("osmonium_ingot", "ingotOsmonium"); registerItem(osmoniumIngot);
		starconiumGem = new CoreOre("starconium_gem", "gemStarconium"); registerItem(starconiumGem);
		starconiumShard = new CoreOre("starconium_shard", "shardStarconium"); registerItem(starconiumShard);
		experiumOrb = new CoreOre("experium_orb", "orbExperium"); registerItem(experiumOrb);
		
		//Nether ore drops
		demoniteOrb = new CoreOre("demonite_orb", "orbDemonite"); registerItem(demoniteOrb);
		invisiumIngot = new CoreOre("invisium_ingot", "ingotInvisium"); registerItem(invisiumIngot);
		
		//Should be in the decorations pack
		darkstoneIngot = new CoreOre("darkstone_bar", "ingotDarkstone"); registerItem(darkstoneIngot);
		
		//Ender ore drops
		enderGem = new CoreOre("ender_gem", "gemEnder"); registerItem(enderGem);
		ultraGem = new CoreOre("ultra_gem", "gemUltra"); registerItem(ultraGem);
		
		luminiteCrystal = new ItemLuminiteCrystal("luminite_crystal"); registerItem(luminiteCrystal);
	}
	
//	private static void initRods() {
//		copperRod = new CoreItem("copper_rod", COTabList.crazyOresItemsTab); registerItem(copperRod);
//		meteoriteRod = new CoreItem("meteorite_rod", COTabList.crazyOresItemsTab); registerItem(meteoriteRod);
//		adamiteRod = new CoreItem("adamite_rod", COTabList.crazyOresItemsTab); registerItem(adamiteRod);
//		sapphireRod = new CoreItem("sapphire_rod", COTabList.crazyOresItemsTab); registerItem(sapphireRod);
//		rubyRod = new CoreItem("ruby_rod", COTabList.crazyOresItemsTab); registerItem(rubyRod);
//		zectiumRod = new CoreItem("zectium_rod", COTabList.crazyOresItemsTab); registerItem(zectiumRod);
//		tapaziteRod = new CoreItem("tapazite_rod", COTabList.crazyOresItemsTab); registerItem(tapaziteRod);
//		osmoniumRod = new CoreItem("osmonium_rod", COTabList.crazyOresItemsTab); registerItem(osmoniumRod);
//		starconiumRod = new CoreItem("starconium_rod", COTabList.crazyOresItemsTab); registerItem(starconiumRod);
//		invisiumRod = new CoreItem("invisium_rod", COTabList.crazyOresItemsTab); registerItem(invisiumRod);
//		enderRod = new CoreItem("ender_rod", COTabList.crazyOresItemsTab); registerItem(enderRod);
//	}
	
	private static void initBowsArrows() {
		swiftBow = new SwiftBow("swift_bow", 540, 10); registerItem(swiftBow);
		hellBow = new HellBow("hell_bow", 366, 10); registerItem(hellBow);
		dualShotBow = new DualBow("dual_shot_bow", 410, 10); registerItem(dualShotBow);
		confusionBow = new ConfusionBow("confusion_bow", 300, 10); registerItem(confusionBow);
		
		flamingArrow = new CoreItem("flaming_arrow", CoreTabList.coreWeaponsTab); registerItem(flamingArrow);
		explosiveArrow = new CoreItem("explosive_arrow", CoreTabList.coreWeaponsTab); registerItem(explosiveArrow);
		lightningArrow = new CoreItem("lightning_arrow", CoreTabList.coreWeaponsTab); registerItem(lightningArrow);
		freezingArrow = new CoreItem("frozen_arrow", CoreTabList.coreWeaponsTab); registerItem(freezingArrow);
		
		flamingArrowHead = new CoreItem("flaming_arrow_head", CoreTabList.coreWeaponsTab); registerItem(flamingArrowHead);
		explosiveArrowHead = new CoreItem("explosive_arrow_head", CoreTabList.coreWeaponsTab); registerItem(explosiveArrowHead);
		freezingArrowHead = new CoreItem("frozen_arrow_head", CoreTabList.coreWeaponsTab); registerItem(freezingArrowHead);
		lightningArrowHead = new CoreItem("lightning_arrow_head", CoreTabList.coreWeaponsTab); registerItem(lightningArrowHead);
	}
	
	private static void initTools() {
		
		copperPickaxe = new CorePickaxe("copper_pickaxe", CoreHarvestLevels.COPPER); registerItem(copperPickaxe);
		copperAxe = new CoreAxe("copper_axe", CoreHarvestLevels.COPPER); registerItem(copperAxe);
		copperShovel = new CoreShovel("copper_shovel", CoreHarvestLevels.COPPER); registerItem(copperShovel);
		copperSword = new CoreSword("copper_sword", CoreHarvestLevels.COPPER); registerItem(copperSword);
		copperHoe = new CoreHoe("copper_hoe", CoreHarvestLevels.COPPER); registerItem(copperHoe);
		
		meteoritePickaxe = new CorePickaxe("meteorite_pickaxe", CoreHarvestLevels.METEORITE); registerItem(meteoritePickaxe);
		meteoriteAxe = new CoreAxe("meteorite_axe", CoreHarvestLevels.METEORITE); registerItem(meteoriteAxe);
		meteoriteShovel = new CoreShovel("meteorite_shovel", CoreHarvestLevels.METEORITE); registerItem(meteoriteShovel);
		meteoriteSword = new CoreSword("meteorite_sword", CoreHarvestLevels.METEORITE); registerItem(meteoriteSword);
		meteoriteHoe = new CoreHoe("meteorite_hoe", CoreHarvestLevels.METEORITE); registerItem(meteoriteHoe);
		
		adamitePickaxe = new CorePickaxe("adamite_pickaxe", CoreHarvestLevels.ADAMITE); registerItem(adamitePickaxe);
		adamiteAxe = new CoreAxe("adamite_axe", CoreHarvestLevels.ADAMITE); registerItem(adamiteAxe);
		adamiteShovel = new CoreShovel("adamite_shovel", CoreHarvestLevels.ADAMITE); registerItem(adamiteShovel);
		adamiteSword = new CoreSword("adamite_sword", CoreHarvestLevels.ADAMITE); registerItem(adamiteSword);
		adamiteHoe = new CoreHoe("adamite_hoe", CoreHarvestLevels.ADAMITE); registerItem(adamiteHoe);
		
		sapphirePickaxe = new CorePickaxe("sapphire_pickaxe", CoreHarvestLevels.SAPPHIRE); registerItem(sapphirePickaxe);
		sapphireAxe = new CoreAxe("sapphire_axe", CoreHarvestLevels.SAPPHIRE); registerItem(sapphireAxe);
		sapphireShovel = new CoreShovel("sapphire_shovel", CoreHarvestLevels.SAPPHIRE); registerItem(sapphireShovel);
		sapphireSword = new CoreSword("sapphire_sword", CoreHarvestLevels.SAPPHIRE); registerItem(sapphireSword);
		sapphireHoe = new CoreHoe("sapphire_hoe", CoreHarvestLevels.SAPPHIRE); registerItem(sapphireHoe);
		
		rubyPickaxe = new CorePickaxe("ruby_pickaxe", CoreHarvestLevels.RUBY); registerItem(rubyPickaxe);
		rubyAxe = new CoreAxe("ruby_axe", CoreHarvestLevels.RUBY); registerItem(rubyAxe);
		rubyShovel = new CoreShovel("ruby_shovel", CoreHarvestLevels.RUBY); registerItem(rubyShovel);
		rubySword = new CoreSword("ruby_sword", CoreHarvestLevels.RUBY); registerItem(rubySword);
		rubyHoe = new CoreHoe("ruby_hoe", CoreHarvestLevels.RUBY); registerItem(rubyHoe);
		
		zectiumPickaxe = new CorePickaxe("zectium_pickaxe", CoreHarvestLevels.ZECTIUM); registerItem(zectiumPickaxe);
		zectiumAxe = new CoreAxe("zectium_axe", CoreHarvestLevels.ZECTIUM); registerItem(zectiumAxe);
		zectiumShovel = new CoreShovel("zectium_shovel", CoreHarvestLevels.ZECTIUM); registerItem(zectiumShovel);
		zectiumSword = new CoreSword("zectium_sword", CoreHarvestLevels.ZECTIUM); registerItem(zectiumSword);
		zectiumHoe = new CoreHoe("zectium_hoe", CoreHarvestLevels.ZECTIUM); registerItem(zectiumHoe);
		
		tapazitePickaxe = new CorePickaxe("tapazite_pickaxe", CoreHarvestLevels.TAPAZITE); registerItem(tapazitePickaxe);
		tapaziteAxe = new CoreAxe("tapazite_axe", CoreHarvestLevels.TAPAZITE); registerItem(tapaziteAxe);
		tapaziteShovel = new CoreShovel("tapazite_shovel", CoreHarvestLevels.TAPAZITE); registerItem(tapaziteShovel);
		tapaziteSword = new CoreSword("tapazite_sword", CoreHarvestLevels.TAPAZITE); registerItem(tapaziteSword);
		tapaziteHoe = new CoreHoe("tapazite_hoe", CoreHarvestLevels.TAPAZITE); registerItem(tapaziteHoe);
		
		osmoniumPickaxe = new CorePickaxe("osmonium_pickaxe", CoreHarvestLevels.OSMONIUM); registerItem(osmoniumPickaxe);
		osmoniumAxe = new CoreAxe("osmonium_axe", CoreHarvestLevels.OSMONIUM); registerItem(osmoniumAxe);
		osmoniumShovel = new CoreShovel("osmonium_shovel", CoreHarvestLevels.OSMONIUM); registerItem(osmoniumShovel);
		osmoniumSword = new CoreSword("osmonium_sword", CoreHarvestLevels.OSMONIUM); registerItem(osmoniumSword);
		osmoniumHoe = new CoreHoe("osmonium_hoe", CoreHarvestLevels.OSMONIUM); registerItem(osmoniumHoe);
		
		starconiumPickaxe = new CorePickaxe("starconium_pickaxe", CoreHarvestLevels.STARCONIUM); registerItem(starconiumPickaxe);
		starconiumAxe = new CoreAxe("starconium_axe", CoreHarvestLevels.STARCONIUM); registerItem(starconiumAxe);
		starconiumShovel = new CoreShovel("starconium_shovel", CoreHarvestLevels.STARCONIUM); registerItem(starconiumShovel);
		starconiumSword = new CoreSword("starconium_sword", CoreHarvestLevels.STARCONIUM); registerItem(starconiumSword);
		starconiumHoe = new CoreHoe("starconium_hoe", CoreHarvestLevels.STARCONIUM); registerItem(starconiumHoe);
		
		starconiumSledgehammer = new CoreSledgehammer("starconium_sledgehammer", CoreHarvestLevels.STARCONIUM_HAMMER); registerItem(starconiumSledgehammer);
		
		invisiumPickaxe = new CorePickaxe("invisium_pickaxe", CoreHarvestLevels.INVISIUM); registerItem(invisiumPickaxe);
		invisiumAxe = new CoreAxe("invisium_axe", CoreHarvestLevels.INVISIUM); registerItem(invisiumAxe);
		invisiumShovel = new CoreShovel("invisium_shovel", CoreHarvestLevels.INVISIUM); registerItem(invisiumShovel);
		invisiumSword = new CoreSword("invisium_sword", CoreHarvestLevels.INVISIUM); registerItem(invisiumSword);
		invisiumHoe = new CoreHoe("invisium_hoe", CoreHarvestLevels.INVISIUM); registerItem(invisiumHoe);
		
		enderPickaxe = new CorePickaxe("ender_pickaxe", CoreHarvestLevels.ENDER); registerItem(enderPickaxe);
		enderAxe = new CoreAxe("ender_axe", CoreHarvestLevels.ENDER); registerItem(enderAxe);
		enderShovel = new CoreShovel("ender_shovel", CoreHarvestLevels.ENDER); registerItem(enderShovel);
		enderSword = new CoreSword("ender_sword", CoreHarvestLevels.ENDER); registerItem(enderSword);
		enderHoe = new CoreHoe("ender_hoe", CoreHarvestLevels.ENDER); registerItem(enderHoe);
		
		copperBucketEmpty = (new CoreBucket("copper_bucket_empty", Blocks.air)).setMaxStackSize(32); registerItem(copperBucketEmpty);
		copperBucketWater = (new CoreBucket("copper_bucket_water", Blocks.flowing_water)).setContainerItem(copperBucketEmpty); registerItem(copperBucketWater);
		copperBucketLava = (new CoreBucket("copper_bucket_lava", Blocks.flowing_lava)).setContainerItem(copperBucketEmpty); registerItem(copperBucketLava); 
		copperBucketMilk = (new CoreMilkBucket("copper_bucket_milk")).setContainerItem(copperBucketEmpty); registerItem(copperBucketMilk);
	}
	
	private static void initArmor() {
		
		copperHelmet = new CoreArmor("copper_helmet", CoreArmor.COPPER_ARMOR, 4, 0); registerItem(copperHelmet);
		copperChestplate = new CoreArmor("copper_chestplate", CoreArmor.COPPER_ARMOR, 4, 1); registerItem(copperChestplate);
		copperLeggings = new CoreArmor("copper_leggings", CoreArmor.COPPER_ARMOR, 4, 2); registerItem(copperLeggings);
		copperBoots = new CoreArmor("copper_boots", CoreArmor.COPPER_ARMOR, 4, 3); registerItem(copperBoots);
		
		meteoriteHelmet = new CoreArmor("meteorite_helmet", CoreArmor.METEORITE_ARMOR, 4, 0); registerItem(meteoriteHelmet);
		meteoriteChestplate = new CoreArmor("meteorite_chestplate", CoreArmor.METEORITE_ARMOR, 4, 1); registerItem(meteoriteChestplate);
		meteoriteLeggings = new CoreArmor("meteorite_leggings", CoreArmor.METEORITE_ARMOR, 4, 2); registerItem(meteoriteLeggings);
		meteoriteBoots = new CoreArmor("meteorite_boots", CoreArmor.METEORITE_ARMOR, 4, 3); registerItem(meteoriteBoots);
		
		adamiteHelmet = new CoreArmor("adamite_helmet", CoreArmor.ADAMITE_ARMOR, 4, 0); registerItem(adamiteHelmet);
		adamiteChestplate = new CoreArmor("adamite_chestplate", CoreArmor.ADAMITE_ARMOR, 4, 1); registerItem(adamiteChestplate);
		adamiteLeggings = new CoreArmor("adamite_leggings", CoreArmor.ADAMITE_ARMOR, 4, 2); registerItem(adamiteLeggings);
		adamiteBoots = new CoreArmor("adamite_boots", CoreArmor.ADAMITE_ARMOR, 4, 3); registerItem(adamiteBoots);
		
		sapphireHelmet = new CoreArmor("sapphire_helmet", CoreArmor.SAPPHIRE_ARMOR, 4, 0); registerItem(sapphireHelmet);
		sapphireChestplate = new CoreArmor("sapphire_chestplate", CoreArmor.SAPPHIRE_ARMOR, 4, 1); registerItem(sapphireChestplate);
		sapphireLeggings = new CoreArmor("sapphire_leggings", CoreArmor.SAPPHIRE_ARMOR, 4, 2); registerItem(sapphireLeggings);
		sapphireBoots = new CoreArmor("sapphire_boots", CoreArmor.SAPPHIRE_ARMOR, 4, 3); registerItem(sapphireBoots);
		
		rubyHelmet = new CoreArmor("ruby_helmet", CoreArmor.RUBY_ARMOR, 4, 0); registerItem(rubyHelmet);
		rubyChestplate = new CoreArmor("ruby_chestplate", CoreArmor.RUBY_ARMOR, 4, 1); registerItem(rubyChestplate);
		rubyLeggings = new CoreArmor("ruby_leggings", CoreArmor.RUBY_ARMOR, 4, 2); registerItem(rubyLeggings);
		rubyBoots = new CoreArmor("ruby_boots", CoreArmor.RUBY_ARMOR, 4, 3); registerItem(rubyBoots);
		
		zectiumHelmet = new CoreArmor("zectium_helmet", CoreArmor.ZECTIUM_ARMOR, 4, 0); registerItem(zectiumHelmet);
		zectiumChestplate = new CoreArmor("zectium_chestplate", CoreArmor.ZECTIUM_ARMOR, 4, 1); registerItem(zectiumChestplate);
		zectiumLeggings = new CoreArmor("zectium_leggings", CoreArmor.ZECTIUM_ARMOR, 4, 2); registerItem(zectiumLeggings);
		zectiumBoots = new CoreArmor("zectium_boots", CoreArmor.ZECTIUM_ARMOR, 4, 3); registerItem(zectiumBoots);
		
		tapaziteHelmet = new CoreArmor("tapazite_helmet", CoreArmor.TAPAZITE_ARMOR, 4, 0); registerItem(tapaziteHelmet);
		tapaziteChestplate = new CoreArmor("tapazite_chestplate", CoreArmor.TAPAZITE_ARMOR, 4, 1); registerItem(tapaziteChestplate);
		tapaziteLeggings = new CoreArmor("tapazite_leggings", CoreArmor.TAPAZITE_ARMOR, 4, 2); registerItem(tapaziteLeggings);
		tapaziteBoots = new CoreArmor("tapazite_boots", CoreArmor.TAPAZITE_ARMOR, 4, 3); registerItem(tapaziteBoots);
		
		osmoniumHelmet = new CoreArmor("osmonium_helmet", CoreArmor.OSMONIUM_ARMOR, 4, 0); registerItem(osmoniumHelmet);
		osmoniumChestplate = new CoreArmor("osmonium_chestplate", CoreArmor.OSMONIUM_ARMOR, 4, 1); registerItem(osmoniumChestplate);
		osmoniumLeggings = new CoreArmor("osmonium_leggings", CoreArmor.OSMONIUM_ARMOR, 4, 2); registerItem(osmoniumLeggings);
		osmoniumBoots = new CoreArmor("osmonium_boots", CoreArmor.OSMONIUM_ARMOR, 4, 3); registerItem(osmoniumBoots);
		
		starconiumHelmet = new CoreArmor("starconium_helmet", CoreArmor.STARCONIUM_ARMOR, 4, 0); registerItem(starconiumHelmet);
		starconiumChestplate = new CoreArmor("starconium_chestplate", CoreArmor.STARCONIUM_ARMOR, 4, 1); registerItem(starconiumChestplate);
		starconiumLeggings = new CoreArmor("starconium_leggings", CoreArmor.STARCONIUM_ARMOR, 4, 2); registerItem(starconiumLeggings);
		starconiumBoots = new CoreArmor("starconium_boots", CoreArmor.STARCONIUM_ARMOR, 4, 3); registerItem(starconiumBoots);
		
		invisiumHelmet = new CoreArmor("invisium_helmet", CoreArmor.INVISIUM_ARMOR, 4, 0); registerItem(invisiumHelmet);
		invisiumChestplate = new CoreArmor("invisium_chestplate", CoreArmor.INVISIUM_ARMOR, 4, 1); registerItem(invisiumChestplate);
		invisiumLeggings = new CoreArmor("invisium_leggings", CoreArmor.INVISIUM_ARMOR, 4, 2); registerItem(invisiumLeggings);
		invisiumBoots = new CoreArmor("invisium_boots", CoreArmor.INVISIUM_ARMOR, 4, 3); registerItem(invisiumBoots);
		
		enderHelmet = new CoreArmor("ender_helmet", CoreArmor.ENDER_ARMOR, 4, 0); registerItem(enderHelmet);
		enderChestplate = new CoreArmor("ender_chestplate", CoreArmor.ENDER_ARMOR, 4, 1); registerItem(enderChestplate);
		enderLeggings = new CoreArmor("ender_leggings", CoreArmor.ENDER_ARMOR, 4, 2); registerItem(enderLeggings);
		enderBoots = new CoreArmor("ender_boots", CoreArmor.ENDER_ARMOR, 4, 3); registerItem(enderBoots);
	}
	
	private static void initSpawnEggs() {
		zectiumProtectorEgg = new CoreSpawnEgg("zectium_protector_egg", "zectium_protector", 0x4FAD18, 0x81D045); registerItem(zectiumProtectorEgg);
		greatWhiteSharkEgg = new CoreSpawnEgg("great_white_shark_egg", "great_white_shark", 0xCBCBCB, 0x656982); registerItem(greatWhiteSharkEgg);
		adamiteSharkEgg = new CoreSpawnEgg("adamite_shark_egg", "adamite_shark", 0xF3F06D, 0xFFFFC1); registerItem(adamiteSharkEgg);
	}
	
	private static void initFood() {
		chocolateCake = new ItemCake("chocolate_cake_placer", CoreBlocks.chocolateCake, 1); registerItem(chocolateCake);
		strawberryCake = new ItemCake("strawberry_cake_placer", CoreBlocks.strawberryCake, 1); registerItem(strawberryCake);
		birthdayCake = new ItemCake("birthday_cake_placer", CoreBlocks.birthdayCake, 1); registerItem(birthdayCake);
		
		rawSharkMeat = new CoreFood("raw_shark_meat", 3, 0.1f, false); registerItem(rawSharkMeat);
		cookedSharkMeat = new CoreFood("cooked_shark_meat", 9, 0.6f, false); registerItem(cookedSharkMeat);
	}
	
	private static void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName());
		if (item instanceof CoreOre) {
			CoreOre ore = (CoreOre)item;
			OreDictionary.registerOre(ore.getOreDictionaryName(), new ItemStack(item, 1, OreDictionary.WILDCARD_VALUE));
		}
	}
}

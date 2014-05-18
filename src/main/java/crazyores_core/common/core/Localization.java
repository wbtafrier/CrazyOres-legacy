package crazyores_core.common.core;

import cpw.mods.fml.common.registry.LanguageRegistry;
import crazyores_core.common.blocks.BlockList;
import crazyores_core.common.items.ItemList;

public class Localization 
{
//	public static void addBlockNames(BlockList bl)
//	{	
//		/** Ores **/
//		LanguageRegistry.addName(bl.meteorite_ore, "Meteorite Ore");
//		LanguageRegistry.addName(bl.copper_ore, "Copper Ore");
//		LanguageRegistry.addName(bl.sapphire_ore, "Sapphire Ore");
//		LanguageRegistry.addName(bl.adamite_ore, "Adamite Ore");
//		LanguageRegistry.addName(bl.ruby_ore, "Ruby Ore");
//		LanguageRegistry.addName(bl.fools_ruby_ore, "Fool's Ruby Ore");
//		LanguageRegistry.addName(bl.zectium_ore, "Zectium Ore");
//		LanguageRegistry.addName(bl.tapazite_ore, "Tapazite Ore");
//		LanguageRegistry.addName(bl.crystalOre, "Crystal Ore");
//		LanguageRegistry.addName(bl.osmoniumOre, "Osmonium Ore");
//		LanguageRegistry.addName(bl.starconiumOre, "Starconium Ore");
//		LanguageRegistry.addName(bl.xpOre, "Experium Ore");
//		LanguageRegistry.addName(bl.demoniteStone, "Demonite Stone");
//		LanguageRegistry.addName(bl.invisiumOre, "Invisium Ore");
//		LanguageRegistry.addName(bl.darkStone, "Darkstone");
//		LanguageRegistry.addName(bl.luminiteOre, "Luminite Ore");
//		LanguageRegistry.addName(bl.enderOre, "Ender Ore");
//		LanguageRegistry.addName(bl.ultraOre, "Ultra Ore");
//
//		/** Storage Blocks **/
//		LanguageRegistry.addName(bl.copperBlock, "Copper Block");
//		LanguageRegistry.addName(bl.sapphireBlock, "Sapphire Block");
//		LanguageRegistry.addName(bl.adamiteBlock, "Adamite Block");
//		LanguageRegistry.addName(bl.meteoriteBlock, "Meteorite Block");
//		LanguageRegistry.addName(bl.meteoriteBlockGlowing, "Glowing Meteorite Block");
//		LanguageRegistry.addName(bl.rubyBlock, "Ruby Block");
//		LanguageRegistry.addName(bl.foolsRubyBlock, "Fool's Ruby Block");
//		LanguageRegistry.addName(bl.zectiumBlock, "Zectium Block");
//		LanguageRegistry.addName(bl.tapaziteBlock, "Tapazite Block");
//		LanguageRegistry.addName(bl.crystalBlock, "Crystal Block");
//		LanguageRegistry.addName(bl.osmoniumBlock, "Osmonium Block");
//		LanguageRegistry.addName(bl.starconiumBlock, "Starconium Block"); 
//		LanguageRegistry.addName(bl.demoniteBlock, "Demonite Block"); 
//		LanguageRegistry.addName(bl.refinedDemoniteBlock, "Refined Demonite Block"); 
//		LanguageRegistry.addName(bl.invisiumBlock, "Invisium Block");
//		LanguageRegistry.addName(bl.enderBlock, "Ender Block");
//		LanguageRegistry.addName(bl.xpBlock, "Experium Block");
//		LanguageRegistry.addName(bl.ultraBlock, "Ultra Block");
//		
//		/** Demonite Furnace **/
//		LanguageRegistry.addName(bl.demoniteFurnaceIdle, "Demonite Furnace");
//		LanguageRegistry.addName(bl.demoniteFurnaceActive, "Demonite Furnace");
//		
//		/** Golem Heads **/
//		LanguageRegistry.addName(bl.copperGolemHead, "Copper Golem Head");
//		LanguageRegistry.addName(bl.sapphireGolemHead, "Sapphire Golem Head");
//		LanguageRegistry.addName(bl.adamiteGolemHead, "Adamite Golem Head");
//		LanguageRegistry.addName(bl.rubyGolemHead, "Ruby Golem Head");
//		LanguageRegistry.addName(bl.foolsRubyGolemHead, "Fool's Ruby Golem Head");
//		LanguageRegistry.addName(bl.zectiumGolemHead, "Zectium Golem Head");
//		LanguageRegistry.addName(bl.tapaziteGolemHead, "Tapazite Golem Head");
//		LanguageRegistry.addName(bl.crystalGolemHead, "Crystal Golem Head");
//		LanguageRegistry.addName(bl.osmoniumGolemHead, "Osmonium Golem Head");
//		LanguageRegistry.addName(bl.starconiumGolemHead, "Starconium Golem Head");
//		LanguageRegistry.addName(bl.demoniteGolemHead, "Demonite Golem Head");
//	}
//
//	public static void addItemNames(ItemList il)
//	{
//
//		/** Items **/
//		LanguageRegistry.addName(il.copperIngot, "Copper Ingot");
//		LanguageRegistry.addName(il.sapphireGem, "Sapphire Gem");
//		LanguageRegistry.addName(il.adamiteShard, "Adamite Shard");
//		LanguageRegistry.addName(il.meteoriteCoal, "Meteorite Coal");
//		LanguageRegistry.addName(il.meteoriteGem, "Meteorite Gem");
//		LanguageRegistry.addName(il.rubyGem, "Ruby Gem");
//		LanguageRegistry.addName(il.foolsRubyGem, "Fools Ruby Gem");
//		LanguageRegistry.addName(il.zectiumIngot, "Zectium Ingot");
//		LanguageRegistry.addName(il.tapaziteGem, "Tapazite Gem");
//		LanguageRegistry.addName(il.crystalShard, "Crystal Shard");
//		LanguageRegistry.addName(il.osmoniumIngot, "Osmonium Ingot");
//		LanguageRegistry.addName(il.starconiumGem, "Starconium Gem");
//		LanguageRegistry.addName(il.demoniteOrb, "Demonite Orb");
//		LanguageRegistry.addName(il.xpOrb, "Experience Orb");
//		LanguageRegistry.addName(il.enderGem, "Ender Gem");
//		LanguageRegistry.addName(il.darkStoneIngot, "Darkstone Ingot");
//		LanguageRegistry.addName(il.invisiumIngot, "Invisium Ingot");
//		LanguageRegistry.addName(il.ultraGem, "Ultra Gem");
//		LanguageRegistry.addName(il.whiteLuminiteCrystal, "White Luminite Crystal");
//		
//		
//		LanguageRegistry.addName(il.copperRod, "Copper Rod");
//		LanguageRegistry.addName(il.sapphireRod, "Sapphire Rod");
//		LanguageRegistry.addName(il.adamiteRod, "Adamite Rod");
//		LanguageRegistry.addName(il.meteoriteRod, "Meteorite Rod");
//		LanguageRegistry.addName(il.rubyRod, "Ruby Rod");
//		LanguageRegistry.addName(il.zectiumRod, "Zectium Rod");
//		LanguageRegistry.addName(il.tapaziteRod, "Tapazite Rod");
//		LanguageRegistry.addName(il.crystalRod, "Crystal Rod");
//		LanguageRegistry.addName(il.osmoniumRod, "Osmonium Rod");
//		LanguageRegistry.addName(il.starconiumRod, "Starconium Rod");
//		LanguageRegistry.addName(il.invisiumRod, "Invisium Rod");
//		LanguageRegistry.addName(il.enderRod, "Ender Rod");
//		LanguageRegistry.addName(il.starconiumShard, "Starconium Shard");
//		LanguageRegistry.addName(il.foolsRubyMush, "Fool's Ruby Mush");
//		LanguageRegistry.addName(il.copperBucketEmpty, "Copper Bucket");
//		LanguageRegistry.addName(il.copperBucketWater, "Water Bucket");
//		LanguageRegistry.addName(il.copperBucketLava, "Lava Bucket");
//		LanguageRegistry.addName(il.meteoriteArrow, "Meteorite Arrow");
//		LanguageRegistry.addName(il.copperArrow, "Copper Arrow");
//		LanguageRegistry.addName(il.invisiumArrow, "Invisium Arrow");
//		LanguageRegistry.addName(il.sapphireArrow, "Sapphire Arrow");
//		LanguageRegistry.addName(il.adamiteArrow, "Adamite Arrow");
//		LanguageRegistry.addName(il.rubyArrow, "Ruby Arrow");
//		LanguageRegistry.addName(il.zectiumArrow, "Zectium Arrow");
//		LanguageRegistry.addName(il.tapaziteArrow, "Tapazite Arrow");
//		LanguageRegistry.addName(il.crystalArrow, "Crystal Arrow");
//		LanguageRegistry.addName(il.osmoniumArrow, "Osmonium Arrow");
//		LanguageRegistry.addName(il.enderArrow, "Ender Arrow");
//		LanguageRegistry.addName(il.starconiumArrow, "Starconium Arrow");
//		
//		
//		
//		/** Bows **/
//		LanguageRegistry.addName(il.meteoriteBow, "Meteorite Bow");
//		LanguageRegistry.addName(il.copperBow, "Copper Bow");
//		LanguageRegistry.addName(il.invisiumBow, "Invisium Bow");
//		LanguageRegistry.addName(il.sapphireBow, "Sapphire Bow");
//		LanguageRegistry.addName(il.adamiteBow, "Adamite Bow");
//		LanguageRegistry.addName(il.rubyBow, "Ruby Bow");
//		LanguageRegistry.addName(il.zectiumBow, "Zectium Bow");
//		LanguageRegistry.addName(il.tapaziteBow, "Tapazite Bow");
//		LanguageRegistry.addName(il.crystalBow, "Crystal Bow");
//		LanguageRegistry.addName(il.osmoniumBow, "Osmonium Bow");
//		LanguageRegistry.addName(il.enderBow, "Ender Bow");
//		LanguageRegistry.addName(il.starconiumBow, "Starconium Bow");
//
//		/** Tools **/
//		LanguageRegistry.addName(il.copperPickaxe, "Copper Pickaxe");
//		LanguageRegistry.addName(il.copperAxe,     "Copper Axe");
//		LanguageRegistry.addName(il.copperShovel,  "Copper Shovel");
//		LanguageRegistry.addName(il.copperSword,   "Copper Sword");
//		LanguageRegistry.addName(il.copperHoe,     "Copper Hoe");
//		
//		LanguageRegistry.addName(il.sapphirePickaxe, "Sapphire Pickaxe");
//		LanguageRegistry.addName(il.sapphireAxe,     "Sapphire Axe");
//		LanguageRegistry.addName(il.sapphireShovel,  "Sapphire Shovel");
//		LanguageRegistry.addName(il.sapphireSword,   "Sapphire Sword");
//		LanguageRegistry.addName(il.sapphireHoe,     "Sapphire Hoe");
//		
//		LanguageRegistry.addName(il.invisiumPickaxe, "Invisium Pickaxe");
//		LanguageRegistry.addName(il.invisiumAxe,     "Invisium Axe");
//		LanguageRegistry.addName(il.invisiumShovel,  "Invisium Shovel");
//		LanguageRegistry.addName(il.invisiumSword,   "Invisium Sword");
//		LanguageRegistry.addName(il.invisiumHoe,     "Invisium Hoe");
//		
//		LanguageRegistry.addName(il.adamitePickaxe, "Adamite Pickaxe");
//		LanguageRegistry.addName(il.adamiteAxe,     "Adamite Axe");
//		LanguageRegistry.addName(il.adamiteShovel,  "Adamite Shovel");
//		LanguageRegistry.addName(il.adamiteSword,   "Adamite Sword");
//		LanguageRegistry.addName(il.adamiteHoe,     "Adamite Hoe");
//		
//		LanguageRegistry.addName(il.meteoritePickaxe, "Meteorite Pickaxe");
//		LanguageRegistry.addName(il.meteoriteAxe,     "Meteorite Axe");
//		LanguageRegistry.addName(il.meteoriteShovel,  "Meteorite Shovel");
//		LanguageRegistry.addName(il.meteoriteSword,   "Meteorite Sword");
//		LanguageRegistry.addName(il.meteoriteHoe,     "Meteorite Hoe");
//		
//		LanguageRegistry.addName(il.rubyPickaxe, "Ruby Pickaxe");
//		LanguageRegistry.addName(il.rubyAxe,     "Ruby Axe");
//		LanguageRegistry.addName(il.rubyShovel,  "Ruby Shovel");
//		LanguageRegistry.addName(il.rubySword,   "Ruby Sword");
//		LanguageRegistry.addName(il.rubyHoe,     "Ruby Hoe");
//		
//		LanguageRegistry.addName(il.zectiumPickaxe, "Zectium Pickaxe");
//		LanguageRegistry.addName(il.zectiumAxe,     "Zectium Axe");
//		LanguageRegistry.addName(il.zectiumShovel,  "Zectium Shovel");
//		LanguageRegistry.addName(il.zectiumSword,   "Zectium Sword");
//		LanguageRegistry.addName(il.zectiumHoe,     "Zectium Hoe");
//		
//		LanguageRegistry.addName(il.tapazitePickaxe, "Tapazite Pickaxe");
//		LanguageRegistry.addName(il.tapaziteAxe,     "Tapazite Axe");
//		LanguageRegistry.addName(il.tapaziteShovel,  "Tapazite Shovel");
//		LanguageRegistry.addName(il.tapaziteSword,   "Tapazite Sword");
//		LanguageRegistry.addName(il.tapaziteHoe,     "Tapazite Hoe");
//		
//		LanguageRegistry.addName(il.crystalPickaxe, "Crystal Pickaxe");
//		LanguageRegistry.addName(il.crystalAxe,     "Crystal Axe");
//		LanguageRegistry.addName(il.crystalShovel,  "Crystal Shovel");
//		LanguageRegistry.addName(il.crystalSword,   "Crystal Sword");
//		LanguageRegistry.addName(il.crystalHoe,     "Crystal Hoe");
//		
//		LanguageRegistry.addName(il.osmoniumPickaxe, "Osmonium Pickaxe");
//		LanguageRegistry.addName(il.osmoniumAxe,     "Osmonium Axe");
//		LanguageRegistry.addName(il.osmoniumShovel,  "Osmonium Shovel");
//		LanguageRegistry.addName(il.osmoniumSword,   "Osmonium Sword");
//		LanguageRegistry.addName(il.osmoniumHoe,     "Osmonium Hoe");
//		
//		LanguageRegistry.addName(il.enderPickaxe, "Ender Pickaxe");
//		LanguageRegistry.addName(il.enderAxe,     "Ender Axe");
//		LanguageRegistry.addName(il.enderShovel,  "Ender Shovel");
//		LanguageRegistry.addName(il.enderSword,   "Ender Sword");
//		LanguageRegistry.addName(il.enderHoe,     "Ender Hoe");
//		
//		LanguageRegistry.addName(il.starconiumPickaxe, "Starconium Pickaxe");
//		LanguageRegistry.addName(il.starconiumAxe,     "Starconium Axe");
//		LanguageRegistry.addName(il.starconiumShovel,  "Starconium Shovel");
//		LanguageRegistry.addName(il.starconiumSword,   "Starconium Sword");
//		LanguageRegistry.addName(il.starconiumHoe,     "Starconium Hoe");
//		
//		LanguageRegistry.addName(il.starconiumHammer,  "Starconium Sledgehammer");
//
//		/** Armor **/
//		LanguageRegistry.addName(il.copperHelmet,     "Copper Helmet");
//		LanguageRegistry.addName(il.copperChestplate, "Copper Chestplate");
//		LanguageRegistry.addName(il.copperLeggings,   "Copper Leggings");
//		LanguageRegistry.addName(il.copperBoots,      "Copper Boots");
//		LanguageRegistry.addName(il.sapphireHelmet,     "Sapphire Helmet");
//		LanguageRegistry.addName(il.sapphireChestplate, "Sapphire Chestplate");
//		LanguageRegistry.addName(il.sapphireLeggings,   "Sapphire Leggings");
//		LanguageRegistry.addName(il.sapphireBoots,      "Sapphire Boots");
//		LanguageRegistry.addName(il.invisiumHelmet,     "Invisium Helmet");
//		LanguageRegistry.addName(il.invisiumChestplate, "Invisium Chestplate");
//		LanguageRegistry.addName(il.invisiumLeggings,   "Invisium Leggings");
//		LanguageRegistry.addName(il.invisiumBoots,      "Invisium Boots");
//		LanguageRegistry.addName(il.adamiteHelmet,     "Adamite Helmet");
//		LanguageRegistry.addName(il.adamiteChestplate,     "Adamite Chestplate");
//		LanguageRegistry.addName(il.adamiteLeggings,     "Adamite Leggings");
//		LanguageRegistry.addName(il.adamiteBoots,     "Adamite Boots");
//		LanguageRegistry.addName(il.meteoriteHelmet,     "Meteorite Helmet");
//		LanguageRegistry.addName(il.meteoriteChestplate, "Meteorite Chestplate");
//		LanguageRegistry.addName(il.meteoriteLeggings,   "Meteorite Leggings");
//		LanguageRegistry.addName(il.meteoriteBoots,      "Meteorite Boots");
//		LanguageRegistry.addName(il.rubyHelmet,     "Ruby Helmet");
//		LanguageRegistry.addName(il.rubyChestplate, "Ruby Chestplate");
//		LanguageRegistry.addName(il.rubyLeggings,   "Ruby Leggings");
//		LanguageRegistry.addName(il.rubyBoots,      "Ruby Boots");
//		LanguageRegistry.addName(il.zectiumHelmet,     "Zectium Helmet");
//		LanguageRegistry.addName(il.zectiumChestplate, "Zectium Chestplate");
//		LanguageRegistry.addName(il.zectiumLeggings,   "Zectium Leggings");
//		LanguageRegistry.addName(il.zectiumBoots,      "Zectium Boots");
//		LanguageRegistry.addName(il.tapaziteHelmet,     "Tapazite Helmet");
//		LanguageRegistry.addName(il.tapaziteChestplate,     "Tapazite Chestplate");
//		LanguageRegistry.addName(il.tapaziteLeggings,     "Tapazite Leggings");
//		LanguageRegistry.addName(il.tapaziteBoots,     "Tapazite Boots");
//		LanguageRegistry.addName(il.crystalHelmet,     "Crystal Helmet");
//		LanguageRegistry.addName(il.crystalChestplate, "Crystal Chestplate");
//		LanguageRegistry.addName(il.crystalLeggings,   "Crystal Leggings");
//		LanguageRegistry.addName(il.crystalBoots,      "Crystal Boots");
//		LanguageRegistry.addName(il.osmoniumHelmet,     "Osmonium Helmet");
//		LanguageRegistry.addName(il.osmoniumChestplate,     "Osmonium Chestplate");
//		LanguageRegistry.addName(il.osmoniumLeggings,     "Osmonium Leggings");
//		LanguageRegistry.addName(il.osmoniumBoots,     "Osmonium Boots");
//		LanguageRegistry.addName(il.enderHelmet,     "Ender Helmet");
//		LanguageRegistry.addName(il.enderChestplate, "Ender Chestplate");
//		LanguageRegistry.addName(il.enderLeggings,   "Ender Leggings");
//		LanguageRegistry.addName(il.enderBoots,      "Ender Boots");
//		LanguageRegistry.addName(il.starconiumHelmet,     "Starconium Helmet");
//		LanguageRegistry.addName(il.starconiumChestplate, "Starconium Chestplate");
//		LanguageRegistry.addName(il.starconiumLeggings,   "Starconium Leggings");
//		LanguageRegistry.addName(il.starconiumBoots,      "Starconium Boots");
//
//	}
//
//	public static void stringsToTranslate()
//	{
//		LanguageRegistry.instance().addStringLocalization("itemGroup.CrazyOresArmor", "CO Armor");
//		LanguageRegistry.instance().addStringLocalization("itemGroup.CrazyOresBlocks", "CO Blocks");
//		LanguageRegistry.instance().addStringLocalization("itemGroup.CrazyOresMaterials", "CO Materials");
//		LanguageRegistry.instance().addStringLocalization("itemGroup.CrazyOresMisc", "CO Misc");
//		LanguageRegistry.instance().addStringLocalization("itemGroup.CrazyOresTools", "CO Tools");
//		LanguageRegistry.instance().addStringLocalization("itemGroup.CrazyOresWeapons", "CO Weapons");
//		LanguageRegistry.instance().addStringLocalization("death.attack.MeteoriteArrow", "%1$s was shot by %2$s with a Meteorite Arrow");
//		LanguageRegistry.instance().addStringLocalization("death.attack.CopperArrow", "%1$s was shot by %2$s with a Copper Arrow");
//		LanguageRegistry.instance().addStringLocalization("death.attack.InvisiumArrow", "%1$s was shot by %2$s with a Invisium Arrow");
//		LanguageRegistry.instance().addStringLocalization("death.attack.SapphireArrow", "%1$s was shot by %2$s with a Sapphire Arrow");
//		LanguageRegistry.instance().addStringLocalization("death.attack.AdamiteArrow", "%1$s was shot by %2$s with a Adamite Arrow");
//		LanguageRegistry.instance().addStringLocalization("death.attack.RubyArrow", "%1$s was shot by %2$s with a Ruby Arrow");
//		LanguageRegistry.instance().addStringLocalization("death.attack.ZectiumArrow", "%1$s was shot by %2$s with a Zectium Arrow");
//		LanguageRegistry.instance().addStringLocalization("death.attack.TapaziteArrow", "%1$s was shot by %2$s with a Tapazite Arrow");
//		LanguageRegistry.instance().addStringLocalization("death.attack.CrystalArrow", "%1$s was shot by %2$s with a Crystal Arrow");
//		LanguageRegistry.instance().addStringLocalization("death.attack.OsmoniumArrow", "%1$s was shot by %2$s with a Osmonium Arrow");
//		LanguageRegistry.instance().addStringLocalization("death.attack.EnderArrow", "%1$s was shot by %2$s with a Ender Arrow");
//		LanguageRegistry.instance().addStringLocalization("death.attack.StarconiumArrow", "%1$s was shot by %2$s with a Starconium Arrow");
//	}
}

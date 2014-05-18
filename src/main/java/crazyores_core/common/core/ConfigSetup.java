package crazyores_core.common.core;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import crazyores_core.common.blocks.BlockList;
import crazyores_core.common.items.ItemList;

public class ConfigSetup 
{
	private static final String WORLDGENCATEGORY = "WORLD_GENERATION";
	private static BlockList bl;
	private static ItemList il;

	public static void writeFile(FMLPreInitializationEvent event)
	{
		Configuration configFile = new Configuration(event.getSuggestedConfigurationFile());
		configFile.load();

		/** Block Tab **/
//		bl.meteorite_oreID = configFile.getBlock("MeteoriteOreID", 2300).getInt();
//		bl.copper_oreID = configFile.getBlock("CopperOreID", 2301).getInt();
//		bl.sapphire_oreID = configFile.getBlock("SapphireOreID", 2302).getInt();
//		bl.adamite_oreID = configFile.getBlock("AdamiteOreID", 2303).getInt();
//		bl.ruby_oreID = configFile.getBlock("RubyOreID", 2304).getInt();
//		bl.fools_ruby_oreID = configFile.getBlock("FoolsRubyOreID", 2305).getInt();
//		bl.zectium_oreID = configFile.getBlock("ZectiumOreID", 2306).getInt();
//		bl.tapazite_oreID = configFile.getBlock("TapaziteOreID", 2307).getInt();
//		bl.crystalOreID = configFile.getBlock("CrystalOreID", 2308).getInt();
//		bl.osmoniumOreID = configFile.getBlock("OsmoniumOreID", 2309).getInt();
//		bl.starconiumOreID = configFile.getBlock("StarconiumOreID", 2310).getInt();
//		bl.xpOreID = configFile.getBlock("ExperiumOreID", 2311).getInt();
//		bl.demoniteStoneID = configFile.getBlock("DemoniteStoneID", 2312).getInt();
//		bl.invisiumOreID = configFile.getBlock("InvisiumOreID", 2313).getInt();
//		bl.darkStoneID = configFile.getBlock("DarkStoneID", 2314).getInt();
//		bl.luminiteOreID = configFile.getBlock("LuminiteOreID", 2315).getInt();
//		bl.enderOreID = configFile.getBlock("EnderOreID", 2316).getInt();
//		bl.ultraOreID = configFile.getBlock("UltraOreID", 2317).getInt();
//		bl.meteoriteBlockID = configFile.getBlock("MeteoriteBlockID", 2318).getInt();
//		bl.meteoriteBlockGlowingID = configFile.getBlock("GlowingMeteoriteBlockID", 2319).getInt();
//		bl.copperBlockID = configFile.getBlock("CopperBlockID", 2320).getInt();
//		bl.sapphireBlockID = configFile.getBlock("SapphireBlockID", 2321).getInt();
//		bl.adamiteBlockID = configFile.getBlock("AdamiteBlockID", 2322).getInt();
//		bl.rubyBlockID = configFile.getBlock("RubyBlockID", 2323).getInt();
//		bl.foolsRubyBlockID = configFile.getBlock("FoolsRubyBlockID", 2324).getInt();
//		bl.zectiumBlockID = configFile.getBlock("ZectiumBlockID", 2325).getInt();
//		bl.tapaziteBlockID = configFile.getBlock("TapaziteBlockID", 2326).getInt();
//		bl.crystalBlockID = configFile.getBlock("CrystalBlockID", 2327).getInt();
//		bl.osmoniumBlockID = configFile.getBlock("OsmoniumBlockID", 2328).getInt();
//		bl.starconiumBlockID = configFile.getBlock("StarconiumBlockID", 2329).getInt();
//		bl.xpBlockID = configFile.getBlock("ExperiumBlockID", 2330).getInt();
//		bl.demoniteBlockID = configFile.getBlock("DemoniteBlockID", 2331).getInt();
//		bl.refinedDemoniteBlockID = configFile.getBlock("RefinedDemoniteBlockID", 2332).getInt();
//		bl.invisiumBlockID = configFile.getBlock("InvisiumBlockID", 2333).getInt();
//		bl.enderBlockID = configFile.getBlock("EnderBlockID", 2334).getInt();
//		bl.ultraBlockID = configFile.getBlock("UltraBlockID", 2335).getInt();
//		bl.copperGolemHeadID = configFile.getBlock("CopperGolemHeadID", 2336).getInt();
//		bl.sapphireGolemHeadID = configFile.getBlock("SapphireGolemHeadID", 2337).getInt();
//		bl.adamiteGolemHeadID = configFile.getBlock("AdamiteGolemHeadID", 2338).getInt();
//		bl.rubyGolemHeadID = configFile.getBlock("RubyGolemHeadID", 2339).getInt();
//		bl.foolsRubyGolemHeadID = configFile.getBlock("FoolsRubyGolemHeadID", 2340).getInt();
//		bl.zectiumGolemHeadID = configFile.getBlock("ZectiumGolemHeadID", 2341).getInt();
//		bl.tapaziteGolemHeadID = configFile.getBlock("TapaziteGolemHeadID", 2342).getInt();
//		bl.crystalGolemHeadID = configFile.getBlock("CrystalGolemHeadID", 2343).getInt();
//		bl.osmoniumGolemHeadID = configFile.getBlock("OsmoniumGolemHeadID", 2344).getInt();
//		bl.starconiumGolemHeadID = configFile.getBlock("StarconiumGolemHeadID", 2345).getInt();
//		bl.demoniteGolemHeadID = configFile.getBlock("DemoniterGolemHeadID", 2346).getInt();
//		bl.demoniteFurnaceIdleID = configFile.getBlock("DemoniteFurnaceIdle", 2347).getInt();
//		bl.demoniteFurnaceActiveID = configFile.getBlock("DemoniteFurnaceActive", 2348).getInt();
//
//		/** Item Tab **/	
//		il.meteoriteCoalID = configFile.getItem("MeteoriteCoalID", 15651).getInt();
//		il.meteoriteGemID = configFile.getItem("MeteoriteGemID", 15652).getInt();
//		il.copperIngotID = configFile.getItem("CopperIngotID", 15653).getInt();
//		il.sapphireGemID = configFile.getItem("SapphireGemID", 15654).getInt();
//		il.adamiteShardID = configFile.getItem("AdamiteShardID", 15655).getInt();
//		il.rubyGemID = configFile.getItem("RubyGemID", 15656).getInt();
//		il.foolsRubyGemID = configFile.getItem("FoolsRubyGemID", 15657).getInt();
//		il.zectiumIngotID = configFile.getItem("ZectiumIngotID", 15658).getInt();
//		il.tapaziteGemID = configFile.getItem("TapaziteGemID", 15659).getInt();
//		il.crystalShardID = configFile.getItem("CrystalShardID", 15660).getInt();
//		il.osmoniumIngotID = configFile.getItem("OsmoniumIngotID", 15661).getInt();
//		il.starconiumGemID = configFile.getItem("StarconiumGemID", 15662).getInt();
//		il.xpOrbID = configFile.getItem("ExperienceOrbID", 15663).getInt();
//		il.demoniteOrbID = configFile.getItem("DemoniteOrbID", 15664).getInt();
//		il.enderGemID = configFile.getItem("EnderGemID", 15665).getInt();
//		il.invisiumIngotID = configFile.getItem("InvisiumIngotID", 15666).getInt();
//		il.darkStoneIngotID = configFile.getItem("DarkStoneIngotID", 15667).getInt();
//		il.ultraGemID = configFile.getItem("UltraGemID", 15668).getInt();
//		il.whiteLuminiteCrystalID = configFile.getItem("WhiteLuminiteCrystalID", 15669).getInt();
//		il.starconiumShardID = configFile.getItem("StarconiumShardID", 15670).getInt();
//		il.foolsRubyMushID = configFile.getItem("FoolsRubyMushID", 15671).getInt();
//		il.meteoriteRodID = configFile.getItem("MeteoriteRodID", 15672).getInt();
//		il.copperRodID = configFile.getItem("CopperRodID", 15673).getInt();
//		il.sapphireRodID = configFile.getItem("SapphireRodID", 15674).getInt();
//		il.adamiteRodID = configFile.getItem("AdamiteRodID", 15675).getInt();
//		il.rubyRodID = configFile.getItem("RubyRodID", 15676).getInt();
//		il.zectiumRodID = configFile.getItem("ZectiumRodID", 15677).getInt();
//		il.tapaziteRodID = configFile.getItem("TapaziteRodID", 15678).getInt();
//		il.crystalRodID = configFile.getItem("CrystalRodID", 15679).getInt();
//		il.osmoniumRodID = configFile.getItem("OsmoniumRodID", 15680).getInt();
//		il.starconiumRodID = configFile.getItem("StarconiumRodID", 15681).getInt();
//		il.invisiumRodID = configFile.getItem("InvisiumRodID", 15682).getInt();
//		il.enderRodID = configFile.getItem("EnderRodID", 15683).getInt();
//
//
//		/** Tools Tab **/
//		il.meteoritePickaxeID = configFile.getItem("MeteoritePickaxeID", 15684).getInt();
//		il.meteoriteAxeID = configFile.getItem("MeteoriteAxeID", 15685).getInt();
//		il.meteoriteShovelID = configFile.getItem("MeteoriteShovelID", 15686).getInt();
//		il.meteoriteHoeID = configFile.getItem("MeteoriteHoeID", 15687).getInt();		
//		il.copperPickaxeID = configFile.getItem("CopperPickaxeID", 15688).getInt();
//		il.copperAxeID = configFile.getItem("CopperAxeID", 15689).getInt();
//		il.copperShovelID = configFile.getItem("CopperShovelID", 15690).getInt();
//		il.copperHoeID = configFile.getItem("CopperHoeID", 15691).getInt();
//		il.sapphirePickaxeID = configFile.getItem("SapphirePickaxeID", 15692).getInt();
//		il.sapphireAxeID = configFile.getItem("SapphireAxeID", 15693).getInt();
//		il.sapphireShovelID = configFile.getItem("SapphireShovelID", 15694).getInt();
//		il.sapphireHoeID = configFile.getItem("SapphireHoeID", 15695).getInt();
//		il.adamitePickaxeID = configFile.getItem("AdamitePickaxeID", 15696).getInt();
//		il.adamiteAxeID = configFile.getItem("AdamiteAxeID", 15697).getInt();
//		il.adamiteShovelID = configFile.getItem("AdamiteShovelID", 15698).getInt();
//		il.adamiteHoeID = configFile.getItem("AdamiteHoeID", 15699).getInt();
//		il.rubyPickaxeID = configFile.getItem("RubyPickaxeID", 15700).getInt();
//		il.rubyAxeID = configFile.getItem("RubyAxeID", 15701).getInt();
//		il.rubyShovelID = configFile.getItem("RubyShovelID", 15702).getInt();
//		il.rubyHoeID = configFile.getItem("RubyHoeID", 15703).getInt();
//		il.zectiumPickaxeID = configFile.getItem("ZectiumPickaxeID", 15704).getInt();
//		il.zectiumAxeID = configFile.getItem("ZectiumAxeID", 15705).getInt();
//		il.zectiumShovelID = configFile.getItem("ZectiumShovelID", 15706).getInt();
//		il.zectiumHoeID = configFile.getItem("ZectiumHoeID", 15707).getInt();
//		il.tapazitePickaxeID = configFile.getItem("TapazitePickaxeID", 15708).getInt();
//		il.tapaziteAxeID = configFile.getItem("TapaziteAxeID", 15709).getInt();
//		il.tapaziteShovelID = configFile.getItem("TapaziteShovelID", 15710).getInt();
//		il.tapaziteHoeID = configFile.getItem("TapaziteHoeID", 15711).getInt();
//		il.crystalPickaxeID = configFile.getItem("CrystalPickaxeID", 15712).getInt();
//		il.crystalAxeID = configFile.getItem("CrystalAxeID", 15713).getInt();
//		il.crystalShovelID = configFile.getItem("CrystalShovelID", 15714).getInt();
//		il.crystalHoeID = configFile.getItem("CrystalHoeID", 15716).getInt();
//		il.osmoniumPickaxeID = configFile.getItem("OsmoniumPickaxeID", 15717).getInt();
//		il.osmoniumAxeID = configFile.getItem("OsmoniumAxeID", 15718).getInt();
//		il.osmoniumShovelID = configFile.getItem("OsmoniumShovelID", 15719).getInt();
//		il.osmoniumHoeID = configFile.getItem("OsmoniumHoeID", 15720).getInt();
//		il.starconiumPickaxeID = configFile.getItem("StarconiumPickaxeID", 15721).getInt();
//		il.starconiumAxeID = configFile.getItem("StarconiumAxeID", 15722).getInt();
//		il.starconiumShovelID = configFile.getItem("StarconiumShovelID", 15723).getInt();
//		il.starconiumHoeID = configFile.getItem("StarconiumHoeID", 15724).getInt();
//		il.starconiumHammerID = configFile.getItem("StarconiumHammerID", 15725).getInt();		
//		il.invisiumPickaxeID = configFile.getItem("InvisiumPickaxeID", 15726).getInt();
//		il.invisiumAxeID = configFile.getItem("InvisiumAxeID", 15727).getInt();
//		il.invisiumShovelID = configFile.getItem("InvisiumShovelID", 15728).getInt();
//		il.invisiumHoeID = configFile.getItem("InvisiumHoeID", 15730).getInt();
//		il.enderPickaxeID = configFile.getItem("EnderPickaxeID", 15731).getInt();
//		il.enderAxeID = configFile.getItem("EnderAxeID", 15732).getInt();
//		il.enderShovelID = configFile.getItem("EnderShovelID", 15733).getInt();
//		il.enderHoeID = configFile.getItem("EnderHoeID", 15735).getInt();
//
//		/** Weapons Tab **/
//		il.meteoriteSwordID = configFile.getItem("MeteoriteSwordID", 15736).getInt();
//		il.meteoriteBowID = configFile.getItem("MeteoriteBowID", 15737).getInt();
//		il.meteoriteArrowID = configFile.getItem("MeteoriteArrowID", 15738).getInt();
//		il.copperSwordID = configFile.getItem("CopperSwordID", 15739).getInt();
//		il.copperBowID = configFile.getItem("CopperBowID", 15740).getInt();
//		il.copperArrowID = configFile.getItem("CopperArrowID", 15741).getInt();
//		il.sapphireSwordID = configFile.getItem("SapphireSwordID", 15742).getInt();
//		il.sapphireBowID = configFile.getItem("SapphireBowID", 15743).getInt();
//		il.sapphireArrowID = configFile.getItem("SapphireArrowID", 15744).getInt();
//		il.adamiteSwordID = configFile.getItem("AdamiteSwordID", 15745).getInt();
//		il.adamiteBowID = configFile.getItem("AdamiteBowID", 15746).getInt();
//		il.adamiteArrowID = configFile.getItem("AdamiteArrowID", 15747).getInt();
//		il.rubySwordID = configFile.getItem("RubySwordID", 15748).getInt();
//		il.rubyBowID = configFile.getItem("RubyBowID", 15749).getInt();
//		il.rubyArrowID = configFile.getItem("RubyArrowID", 15750).getInt();
//		il.zectiumSwordID = configFile.getItem("ZectiumSwordID", 15751).getInt();
//		il.zectiumBowID = configFile.getItem("ZectiumBowID", 15752).getInt();
//		il.zectiumArrowID = configFile.getItem("ZectiumArrowID", 15753).getInt();
//		il.tapaziteSwordID = configFile.getItem("TapaziteSwordID", 15754).getInt();
//		il.tapaziteBowID = configFile.getItem("TapaziteBowID", 15755).getInt();
//		il.tapaziteArrowID = configFile.getItem("TapaziteArrowID", 15756).getInt();
//		il.crystalSwordID = configFile.getItem("CrystalSwordID", 15757).getInt();
//		il.crystalBowID = configFile.getItem("CrystalBowID", 15758).getInt();
//		il.crystalArrowID = configFile.getItem("CrystalArrowID", 15759).getInt();
//		il.osmoniumSwordID = configFile.getItem("OsmoniumSwordID", 15760).getInt();
//		il.osmoniumBowID = configFile.getItem("OsmoniumBowID", 15761).getInt();
//		il.osmoniumArrowID = configFile.getItem("OsmoniumArrowID", 15762).getInt();
//		il.starconiumSwordID = configFile.getItem("StarconiumSwordID", 15763).getInt();
//		il.starconiumBowID = configFile.getItem("StarconiumBowID", 15764).getInt();
//		il.starconiumArrowID = configFile.getItem("StarconiumArrowID", 15765).getInt();
//		il.invisiumSwordID = configFile.getItem("InvisiumSwordID", 15766).getInt();
//		il.invisiumBowID = configFile.getItem("InvisiumBowID", 15767).getInt();
//		il.invisiumArrowID = configFile.getItem("InvisiumArrowID", 15768).getInt();
//		il.enderSwordID = configFile.getItem("EnderSwordID", 15769).getInt();
//		il.enderBowID = configFile.getItem("EnderBowID", 15770).getInt();
//		il.enderArrowID = configFile.getItem("EnderArrowID", 15771).getInt();
//
//		/** Misc Tab **/
//		il.copperBucketEmptyID = configFile.getItem("EmptyCopperBucketID", 15772).getInt();
//		il.copperBucketWaterID = configFile.getItem("WaterCopperBucketID", 15773).getInt();
//		il.copperBucketLavaID = configFile.getItem("LavaCopperBucketID", 15774).getInt();
//
//
//		/** Armor Tab **/
//		il.meteoriteHelmetID = configFile.getItem("MeteoriteHelmetID", 15775).getInt();
//		il.meteoriteChestplateID = configFile.getItem("MeteoriteChestplateID", 15776).getInt();
//		il.meteoriteLeggingsID = configFile.getItem("MeteoriteLeggingsID", 15777).getInt();
//		il.meteoriteBootsID = configFile.getItem("MetetoriteBootsID", 15778).getInt();		
//		il.copperHelmetID = configFile.getItem("CopperHelmetID", 15779).getInt();
//		il.copperChestplateID = configFile.getItem("CopperChestplateID", 15780).getInt();
//		il.copperLeggingsID = configFile.getItem("CopperLeggingsID", 15781).getInt();
//		il.copperBootsID = configFile.getItem("CopperBootsID", 15782).getInt();		
//		il.sapphireHelmetID = configFile.getItem("SapphireHelmetID", 15783).getInt();
//		il.sapphireChestplateID = configFile.getItem("SapphireChestplateID", 15784).getInt();
//		il.sapphireLeggingsID = configFile.getItem("SapphireLeggingsID", 15785).getInt();
//		il.sapphireBootsID = configFile.getItem("SapphireBootsID", 15786).getInt();		
//		il.adamiteHelmetID = configFile.getItem("AdamiteHelmetID", 15787).getInt();
//		il.adamiteChestplateID = configFile.getItem("AdamiteChestplateID", 15788).getInt();
//		il.adamiteLeggingsID = configFile.getItem("AdamiteLeggingsID", 15789).getInt();
//		il.adamiteBootsID = configFile.getItem("AdamiteBootsID", 15790).getInt();		
//		il.rubyHelmetID = configFile.getItem("RubyHelmetID", 15791).getInt();
//		il.rubyChestplateID = configFile.getItem("RubyChestplateID", 15792).getInt();
//		il.rubyLeggingsID = configFile.getItem("RubyLeggingsID", 15793).getInt();
//		il.rubyBootsID = configFile.getItem("RubyBootsID", 15794).getInt();		
//		il.zectiumHelmetID = configFile.getItem("ZectiumHelmetID", 15795).getInt();
//		il.zectiumChestplateID = configFile.getItem("ZectiumChestplateID", 15796).getInt();
//		il.zectiumLeggingsID = configFile.getItem("ZectiumLeggingsID", 15797).getInt();
//		il.zectiumBootsID = configFile.getItem("ZectiumBootsID", 15798).getInt();		
//		il.tapaziteHelmetID = configFile.getItem("TapaziteHelmetID", 15799).getInt();
//		il.tapaziteChestplateID = configFile.getItem("TapaziteChestplateID", 15800).getInt();
//		il.tapaziteLeggingsID = configFile.getItem("TapaziteLeggingsID", 15801).getInt();
//		il.tapaziteBootsID = configFile.getItem("TapaziteBootsID", 15802).getInt();		
//		il.crystalHelmetID = configFile.getItem("CrystalHelmetID", 15803).getInt();
//		il.crystalChestplateID = configFile.getItem("CrystalChestplateID", 15804).getInt();
//		il.crystalLeggingsID = configFile.getItem("CrystalLeggingsID", 15805).getInt();
//		il.crystalBootsID = configFile.getItem("CrystalBootsID", 15806).getInt();	
//		il.osmoniumHelmetID = configFile.getItem("OsmoniumHelmetID", 15807).getInt();
//		il.osmoniumChestplateID = configFile.getItem("OsmoniumChestplateID", 15808).getInt();
//		il.osmoniumLeggingsID = configFile.getItem("OsmoniumLeggingsID", 15809).getInt();
//		il.osmoniumBootsID = configFile.getItem("OsmoniumBootsID", 15810).getInt();	
//		il.starconiumHelmetID = configFile.getItem("StarconiumHelmetID", 15811).getInt();
//		il.starconiumChestplateID = configFile.getItem("StarconiumChestplateID", 15812).getInt();
//		il.starconiumLeggingsID = configFile.getItem("StarconiumLeggingsID", 15813).getInt();
//		il.starconiumBootsID = configFile.getItem("StarconiumBootsID", 15814).getInt();
//		il.invisiumHelmetID = configFile.getItem("InvisiumHelmetID", 15815).getInt();
//		il.invisiumChestplateID = configFile.getItem("InvisiumChestplateID", 15816).getInt();
//		il.invisiumLeggingsID = configFile.getItem("InvisiumLeggingsID", 15817).getInt();
//		il.invisiumBootsID = configFile.getItem("InvisiumBootsID", 15818).getInt();		
//		il.enderHelmetID = configFile.getItem("EnderHelmetID", 15819).getInt();
//		il.enderChestplateID = configFile.getItem("EnderChestplateID", 15820).getInt();
//		il.enderLeggingsID = configFile.getItem("EnderLeggingsID", 15821).getInt();
//		il.enderBootsID = configFile.getItem("EnderBootsID", 15822).getInt();

		/** Ore Generation **/	
		COSettings.generateOres = configFile.get(WORLDGENCATEGORY, "GenerateOres", true).getBoolean(true);
		COSettings.copperGen = configFile.get(WORLDGENCATEGORY, "GenerateCopperOre", true).getBoolean(true);
		COSettings.sapphireGen = configFile.get(WORLDGENCATEGORY, "GenerateSapphireOre", true).getBoolean(true);
		COSettings.adamiteGen = configFile.get(WORLDGENCATEGORY, "GenerateAdamiteOre", true).getBoolean(true);
		COSettings.meteoriteGen = configFile.get(WORLDGENCATEGORY, "GenerateMeteoriteOre", true).getBoolean(true);
		COSettings.rubyGen = configFile.get(WORLDGENCATEGORY, "GenerateRubyOre", true).getBoolean(true);
		COSettings.foolsRubyGen = configFile.get(WORLDGENCATEGORY, "GenerateFoolsRubyOre", true).getBoolean(true);
		COSettings.zectiumGen = configFile.get(WORLDGENCATEGORY, "GenerateZectiumOre", true).getBoolean(true);
		COSettings.tapaziteGen = configFile.get(WORLDGENCATEGORY, "GenerateTapaziteOre", true).getBoolean(true);
		COSettings.crystalGen = configFile.get(WORLDGENCATEGORY, "GenerateCrystalOre", true).getBoolean(true);
		COSettings.osmoniumGen = configFile.get(WORLDGENCATEGORY, "GenerateOsmoniumOre", true).getBoolean(true);
		COSettings.starconiumGen = configFile.get(WORLDGENCATEGORY, "GenerateStarconiumOre", true).getBoolean(true);
		COSettings.demoniteGen = configFile.get(WORLDGENCATEGORY, "GenerateDemoniteStone", true).getBoolean(true);
		COSettings.experiumGen = configFile.get(WORLDGENCATEGORY, "GenerateExperiumOre", true).getBoolean(true);
		COSettings.invisiumGen = configFile.get(WORLDGENCATEGORY, "GenerateInvisiumOre", true).getBoolean(true);
		COSettings.darkStoneGen = configFile.get(WORLDGENCATEGORY, "GenerateDarkStone", true).getBoolean(true);
		COSettings.luminiteGen = configFile.get(WORLDGENCATEGORY, "GenerateLuminiteOre", true).getBoolean(true);
		COSettings.enderGen = configFile.get(WORLDGENCATEGORY, "GenerateEnderOre", true).getBoolean(true);
		COSettings.ultraGen = configFile.get(WORLDGENCATEGORY, "GenerateUltraOre", true).getBoolean(true);


		COSettings.diamondGen = configFile.get(WORLDGENCATEGORY, "DiamondGenerationOverride", true).getBoolean(true);
		COSettings.goldGen = configFile.get(WORLDGENCATEGORY, "GoldGenerationOverride", true).getBoolean(true);
		
//		COSettings.invisiumEffect = configFile.get(Configuration.CATEGORY_GENERAL, "InvisiumArmorEffectOn", true).getBoolean(true);

		configFile.save();
	}
}

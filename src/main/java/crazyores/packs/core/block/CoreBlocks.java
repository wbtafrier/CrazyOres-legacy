package crazyores.packs.core.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.manager.tabs.COTabList;
import crazyores.packs.core.entity.golem.EnumGolemType;
import crazyores.packs.core.tabs.CoreTabList;

public class CoreBlocks {

	public static Block tapaziteLightSource;
	
	//Overworld Ores
	public static Block tapaziteStalagmite;
	public static Block tapaziteStalactite;
	
	public static Block copperOre;
	public static Block meteoriteOre;
	public static Block adamiteOre;
	public static Block sapphireOre;
	public static Block rubyOre;
	public static Block foolsRubyOre;
	public static Block zectiumOre;
	public static Block osmoniumOre;
	public static Block starconiumOre;
	public static Block experiumOre;
	
	//Nether Ores
	public static Block demoniteOre;
	public static Block invisiumOre;
	
	//Ender Ores
	//TODO: Add the Ender Ores.
	public static Block enderOre;
//	public static Block ultraOre;
	
	public static Block darkstoneOre;
	public static Block luminiteOre;
	
	//Overworld Blocks
	public static Block copperBlock;
	public static Block meteoriteBlock;
	public static Block adamiteBlock;
	public static Block sapphireBlock;
	public static Block rubyBlock;
	public static Block foolsRubyBlock;
	public static Block zectiumBlock;
	public static Block tapaziteBlock;
	public static Block osmoniumBlock;
	public static Block starconiumBlock;
	public static Block experiumBlock;
	
	public static Block copperGolemHead;
	public static Block adamiteGolemHead;
	public static Block sapphireGolemHead;
	public static Block rubyGolemHead;
	public static Block foolsRubyGolemHead;
	public static Block zectiumGolemHead;
	public static Block tapaziteGolemHead;
	public static Block osmoniumGolemHead;
	public static Block starconiumGolemHead;
	
	public static Block demoniteGolemHead;
	public static Block enderGolemHead;
	
	//Nether Blocks
	public static Block demoniteBlock;
	public static Block invisiumBlock;
	
	public static Block demoniteFurnace;
	public static Block demoniteFurnaceLit;
	
	//Ender Blocks
	public static Block enderBlock;
//	public static Block ultraBlock;
	
//	public static Block darkstoneBlock;
//	public static Block luminiteBlock;
	
	
	//Decoration Blocks
	
	//Cake!
	public static Block chocolateCake;
	public static Block strawberryCake;
	public static Block birthdayCake;
	
	//Spawners
	public static Block zectiumProtectorSpawner;
	public static Block greatWhiteSharkSpawner;
	public static Block adamiteSharkSpawner;
	
	//Materials
	public static Block reinforcedGlass;
	public static Block smoothReinforcedGlass;
	
	public static Block reinforcedBrick;
	public static Block reinforcedBrickStairs;
	
	public static Block diagonalReinforcedBrick;
	public static Block diagonalReinforcedBrickStairs;
	
	public static Block diagonalBrick;
	public static Block diagonalBrickStairs;
	
	public static Block adamiteBrick;
	public static Block adamiteBrickStairs;
	
	public static Block diagonalAdamiteBrick;
	public static Block diagonalAdamiteBrickStairs;
	
	public static Block lightenedBrick;
	public static Block lightenedBrickStairs;
	
	public static Block diagonalLightenedBrick;
	public static Block diagonalLightenedBrickStairs;
	
	public static void initBlocks() {
		tapaziteLightSource = new BlockLightSource("tapazite_light_source", Material.air, 0.75F, 1.2F, 3.0F); registerBlock(tapaziteLightSource);
		tapaziteStalagmite = new BlockTapaziteStalagmite("tapazite_stalagmite", Block.soundTypeGlass, 0.5F, 2.0F).setCreativeTab(COTabList.crazyOresBlocksTab); registerBlock(tapaziteStalagmite, ItemBlockTapaziteStalagmite.class);
		tapaziteStalactite = new BlockTapaziteStalactite("tapazite_stalactite", Block.soundTypeGlass, 0.5F, 2.0F).setCreativeTab(COTabList.crazyOresBlocksTab); registerBlock(tapaziteStalactite, ItemBlockTapaziteStalactite.class);
		
		copperOre = new BlockOre("copper_ore", Material.rock, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(copperOre);
		meteoriteOre = new BlockOre("meteorite_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f, 0.8f); registerBlock(meteoriteOre);
		adamiteOre = new BlockOre("adamite_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f, 0.7f); registerBlock(adamiteOre);
		sapphireOre = new BlockOre("sapphire_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(sapphireOre);
		rubyOre = new BlockOre("ruby_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(rubyOre);
		foolsRubyOre = new BlockOre("fools_ruby_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(foolsRubyOre);
		zectiumOre = new BlockOre("zectium_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(zectiumOre);
		osmoniumOre = new BlockOre("osmonium_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(osmoniumOre);
		starconiumOre = new BlockOre("starconium_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(starconiumOre);
		experiumOre = new BlockOre("experium_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(experiumOre);
		
		demoniteOre = new BlockOre("demonite_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(demoniteOre);
		invisiumOre = new BlockOre("invisium_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(invisiumOre);
		
		//Should be in the decorations pack
		darkstoneOre = new BlockOre("darkstone_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(darkstoneOre);
		luminiteOre = new BlockOre("luminite_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(luminiteOre);
		
		enderOre = new BlockOre("ender_ore", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f); registerBlock(enderOre);
		
		
		//Storage Blocks
		copperBlock = (new CoreBlock("copper_block", Material.rock, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f)).setOreDictionaryName("blockCopper"); registerBlock(copperBlock);
		meteoriteBlock = (new CoreBlock("meteorite_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f, 0.8f)).setOreDictionaryName("blockMeteorite"); registerBlock(meteoriteBlock);
		adamiteBlock = (new CoreBlock("adamite_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f, 0.7f)).setOreDictionaryName("blockAdamite"); registerBlock(adamiteBlock);
		sapphireBlock = (new CoreBlock("sapphire_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f)).setOreDictionaryName("blockSapphire"); registerBlock(sapphireBlock);
		rubyBlock = (new CoreBlock("ruby_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f)).setOreDictionaryName("blockRuby"); registerBlock(rubyBlock);
		foolsRubyBlock = (new CoreBlock("fools_ruby_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f)).setOreDictionaryName("blockFoolsRuby"); registerBlock(foolsRubyBlock);
		zectiumBlock = (new CoreBlock("zectium_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f)).setOreDictionaryName("blockZectium"); registerBlock(zectiumBlock);
		tapaziteBlock = (new CoreBlock("tapazite_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f)).setOreDictionaryName("blockTapazite"); registerBlock(tapaziteBlock);
		osmoniumBlock = (new CoreBlock("osmonium_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f)).setOreDictionaryName("blockOsmonium"); registerBlock(osmoniumBlock);
		starconiumBlock = (new CoreBlock("starconium_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f)).setOreDictionaryName("blockStarconium"); registerBlock(starconiumBlock);
		experiumBlock = (new CoreBlock("experium_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f)).setOreDictionaryName("blockExperium"); registerBlock(experiumBlock);
		
		demoniteBlock = (new CoreBlock("demonite_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f)).setOreDictionaryName("blockDemonite"); registerBlock(demoniteBlock);
		invisiumBlock = (new CoreBlock("invisium_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f)).setOreDictionaryName("blockInvisium"); registerBlock(invisiumBlock);
		
		//Should be in the decorations pack
//		darkstoneBlock = (new CoreBlock("darkstone_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f)).setOreDictionaryName("blockDarkstone"); registerBlock(darkstoneBlock);
//		luminiteBlock = (new CoreBlock("luminite_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f)).setOreDictionaryName("blockLuminite"); registerBlock(luminiteBlock);
		
		enderBlock = (new CoreBlock("ender_block", Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeStone, 3.0f, 5.0f)).setOreDictionaryName("blockEnder"); registerBlock(enderBlock);
		
		demoniteFurnace = new BlockDemoniteFurnace("demonite_furnace", false, 16.0f, 2.0f); registerBlock(demoniteFurnace);
		demoniteFurnaceLit = new BlockDemoniteFurnace("demonite_furnace_lit", true, 16.0f, 2.0f); registerBlock(demoniteFurnaceLit);
		
		//Golem heads
		copperGolemHead = new GolemHead("copper_head", EnumGolemType.COPPER, Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeMetal, 3.0f, 5.0f); registerBlock(copperGolemHead);
		sapphireGolemHead = new GolemHead("sapphire_head", EnumGolemType.SAPPHIRE, Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeMetal, 3.0f, 5.0f); registerBlock(sapphireGolemHead);
		adamiteGolemHead = new GolemHead("adamite_head", EnumGolemType.ADAMITE, Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeMetal, 3.0f, 5.0f, 0.7f); registerBlock(adamiteGolemHead);
		rubyGolemHead = new GolemHead("ruby_head", EnumGolemType.RUBY, Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeMetal, 3.0f, 5.0f); registerBlock(rubyGolemHead);
		foolsRubyGolemHead = new GolemHead("fools_ruby_head", EnumGolemType.FOOLS_RUBY, Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeMetal, 3.0f, 5.0f); registerBlock(foolsRubyGolemHead);
		zectiumGolemHead = new GolemHead("zectium_head", EnumGolemType.ZECTIUM, Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeMetal, 3.0f, 5.0f); registerBlock(zectiumGolemHead);
		tapaziteGolemHead = new GolemHead("tapazite_head", EnumGolemType.TAPAZITE, Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeMetal, 3.0f, 5.0f); registerBlock(tapaziteGolemHead);
		osmoniumGolemHead = new GolemHead("osmonium_head", EnumGolemType.OSMONIUM, Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeMetal, 3.0f, 5.0f); registerBlock(osmoniumGolemHead);
		starconiumGolemHead = new GolemHead("starconium_head", EnumGolemType.STARCONIUM, Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeMetal, 3.0f, 5.0f); registerBlock(starconiumGolemHead);
		
		demoniteGolemHead = new GolemHead("demonite_head", EnumGolemType.DEMONITE, Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeMetal, 3.0f, 5.0f); registerBlock(demoniteGolemHead);
		enderGolemHead = new GolemHead("ender_head", EnumGolemType.ENDER, Material.iron, COTabList.crazyOresBlocksTab, Block.soundTypeMetal, 3.0f, 5.0f); registerBlock(enderGolemHead);
	
		chocolateCake = new BlockCake("chocolate_cake", "chocolate", 8); registerBlock(chocolateCake);
		strawberryCake = new BlockCake("strawberry_cake", "strawberry", 10); registerBlock(strawberryCake);
		birthdayCake = new BlockCake("birthday_cake", "birthday", 12); registerBlock(birthdayCake);
		
		greatWhiteSharkSpawner = new CoreSpawner("great_white_shark_spawner", "great_white_shark", CoreTabList.coreMobsTab, Block.soundTypePiston, 6.0f, 5.0f); registerBlock(greatWhiteSharkSpawner);
		zectiumProtectorSpawner = new CoreSpawner("zectium_protector_spawner", "zectium_protector", CoreTabList.coreMobsTab, Block.soundTypePiston, 10.0f, 100f); registerBlock(zectiumProtectorSpawner);
		adamiteSharkSpawner = new CoreSpawner("adamite_shark_spawner", "adamite_shark", CoreTabList.coreMobsTab, Block.soundTypePiston, 6.0f, 5.0f, 0.7f); registerBlock(adamiteSharkSpawner);
		
		reinforcedGlass = new CoreGlass("reinforced_glass", true, 1.0f, 100.0f); registerBlock(reinforcedGlass);
		smoothReinforcedGlass = new CoreGlass("smooth_reinforced_glass", true, 1.0f, 100.0f); registerBlock(smoothReinforcedGlass);
		
		
		reinforcedBrick = new CoreBlock("reinforced_brick", Material.rock, COTabList.crazyOresBlocksTab, Block.soundTypePiston, 4.0f, 100.0f); registerBlock(reinforcedBrick);
		reinforcedBrickStairs = new CoreStairs("reinforced_brick_stairs", reinforcedBrick, 4.0f, 100.0f); registerBlock(reinforcedBrickStairs);
		
		diagonalReinforcedBrick = new CoreBlock("diagonal_reinforced_brick", Material.rock, COTabList.crazyOresBlocksTab, Block.soundTypePiston, 4.0f, 100.0f); registerBlock(diagonalReinforcedBrick);
		diagonalReinforcedBrickStairs = new CoreStairs("diagonal_reinforced_brick_stairs", diagonalReinforcedBrick, 4.0f, 100.0f); registerBlock(diagonalReinforcedBrickStairs);
		
		diagonalBrick = new CoreBlock("diagonal_brick", Material.rock, COTabList.crazyOresBlocksTab, Block.soundTypePiston, 2.0f, 10.0f); registerBlock(diagonalBrick);
		diagonalBrickStairs = new CoreStairs("diagonal_brick_stairs", diagonalBrick, 2.0f, 10.0f); registerBlock(diagonalBrickStairs);
		
		adamiteBrick = new CoreBlock("adamite_brick", Material.rock, COTabList.crazyOresBlocksTab, Block.soundTypePiston, 3.0f, 10.0f, 0.7f); registerBlock(adamiteBrick);
		adamiteBrickStairs = new CoreStairs("adamite_brick_stairs", adamiteBrick, 3.0f, 10.0f, 0.7f); registerBlock(adamiteBrickStairs);
		
		diagonalAdamiteBrick = new CoreBlock("diagonal_adamite_brick", Material.rock, COTabList.crazyOresBlocksTab, Block.soundTypePiston, 3.0f, 10.0f, 0.7f); registerBlock(diagonalAdamiteBrick);
		diagonalAdamiteBrickStairs = new CoreStairs("diagonal_adamite_brick_stairs", diagonalAdamiteBrick, 3.0f, 10.0f, 0.7f); registerBlock(diagonalAdamiteBrickStairs);
		
		
		lightenedBrick = new CoreBlock("lightened_brick", Material.rock, COTabList.crazyOresBlocksTab, Block.soundTypePiston, 2.0f, 10.0f); registerBlock(lightenedBrick);
		lightenedBrickStairs = new CoreStairs("lightened_brick_stairs", lightenedBrick, 2.0f, 10.0f); registerBlock(lightenedBrickStairs);
		
		diagonalLightenedBrick = new CoreBlock("diagonal_lightened_brick", Material.rock, COTabList.crazyOresBlocksTab, Block.soundTypePiston, 2.0f, 10.0f); registerBlock(diagonalLightenedBrick);
		diagonalLightenedBrickStairs = new CoreStairs("diagonal_lightened_brick_stairs", diagonalLightenedBrick, 2.0f, 10.0f); registerBlock(diagonalLightenedBrickStairs);
	}
	
	/**
	 * Registers all core blocks with forge.
	 */
	private static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
		if (block instanceof CoreBlock) {
			CoreBlock coreBlock = (CoreBlock)block;
			if (coreBlock.getOreDictionaryName() != null && !coreBlock.getOreDictionaryName().isEmpty()) {
				OreDictionary.registerOre(coreBlock.getOreDictionaryName(), new ItemStack(block, 1, OreDictionary.WILDCARD_VALUE));
			}
		}
	}
	
	/**
	 * Registers all core metadata blocks with forge.
	 */
	private static void registerBlock(Block block, Class itemBlockClass) {
		GameRegistry.registerBlock(block, itemBlockClass, block.getUnlocalizedName());
		if (block instanceof CoreBlock) {
			CoreBlock coreBlock = (CoreBlock)block;
			if (coreBlock.getOreDictionaryName() != null && !coreBlock.getOreDictionaryName().isEmpty()) {
				OreDictionary.registerOre(coreBlock.getOreDictionaryName(), new ItemStack(block, 1, OreDictionary.WILDCARD_VALUE));
			}
		}
	}
}

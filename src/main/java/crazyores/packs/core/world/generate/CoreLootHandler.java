package crazyores.packs.core.world.generate;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import crazyores.packs.core.item.CoreItems;

public class CoreLootHandler {
	
	public static final String ZECTIUM_DUNGEON = "zectiumDungeon";
	public static final String ADAMITE_DUNGEON = "adamiteDungeon";
	
	public static void initLoot() {
		
//		MINESHAFT_CORRIDOR
//	    PYRAMID_DESERT_CHEST
//	    PYRAMID_JUNGLE_CHEST
//	    PYRAMID_JUNGLE_DISPENSER
//	    STRONGHOLD_CORRIDOR
//	    STRONGHOLD_LIBRARY 
//	    STRONGHOLD_CROSSING 
//	    VILLAGE_BLACKSMITH 
//	    BONUS_CHEST
//	    DUNGEON_CHEST 
		
		ChestGenHooks mineshaft = ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR);
		mineshaft.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.copperIngot), 0, 1, 8));
		mineshaft.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.sapphireGem), 0, 1, 6));
		mineshaft.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.rubyGem), 0, 2, 4));
		mineshaft.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.foolsRubyGem), 0, 4, 10));
		mineshaft.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumIngot), 0, 1, 1));
		mineshaft.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.tapaziteObelisk), 0, 1, 2));
		mineshaft.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.osmoniumIngot), 0, 1, 1));
		mineshaft.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.starconiumGem), 0, 1, 1));
		
		ChestGenHooks pyramidDesert = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST);
		pyramidDesert.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.copperIngot), 0, 1, 8));
		pyramidDesert.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.sapphireGem), 0, 1, 6));
		pyramidDesert.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.rubyGem), 0, 2, 4));
		pyramidDesert.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.foolsRubyGem), 0, 4, 10));
		pyramidDesert.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumIngot), 0, 1, 1));
		pyramidDesert.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.tapaziteObelisk), 0, 1, 2));
		pyramidDesert.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.osmoniumIngot), 0, 1, 1));
		pyramidDesert.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.starconiumGem), 0, 1, 1));
		
		ChestGenHooks pyramidJungleChest = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST);
		pyramidJungleChest.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.copperIngot), 0, 1, 8));
		pyramidJungleChest.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.sapphireGem), 0, 1, 6));
		pyramidJungleChest.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.rubyGem), 0, 2, 4));
		pyramidJungleChest.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.foolsRubyGem), 0, 4, 10));
		pyramidJungleChest.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumIngot), 0, 1, 1));
		pyramidJungleChest.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.tapaziteObelisk), 0, 1, 2));
		pyramidJungleChest.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.osmoniumIngot), 0, 1, 1));
		pyramidJungleChest.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.starconiumGem), 0, 1, 1));
		
		ChestGenHooks pyramidJungleDispenser = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER);
		pyramidJungleDispenser.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.copperIngot), 0, 1, 8));
		pyramidJungleDispenser.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.sapphireGem), 0, 1, 6));
		pyramidJungleDispenser.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.rubyGem), 0, 2, 4));
		pyramidJungleDispenser.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.foolsRubyGem), 0, 4, 10));
		pyramidJungleDispenser.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumIngot), 0, 1, 1));
		pyramidJungleDispenser.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.tapaziteObelisk), 0, 1, 2));
		pyramidJungleDispenser.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.osmoniumIngot), 0, 1, 1));
		pyramidJungleDispenser.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.starconiumGem), 0, 1, 1));
		
		ChestGenHooks strongHoldCorridor = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR);
		strongHoldCorridor.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.copperIngot), 0, 1, 8));
		strongHoldCorridor.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.sapphireGem), 0, 1, 6));
		strongHoldCorridor.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.rubyGem), 0, 2, 4));
		strongHoldCorridor.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.foolsRubyGem), 0, 4, 10));
		strongHoldCorridor.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumIngot), 0, 1, 1));
		strongHoldCorridor.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.tapaziteObelisk), 0, 1, 2));
		strongHoldCorridor.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.osmoniumIngot), 0, 1, 1));
		strongHoldCorridor.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.starconiumGem), 0, 1, 1));
		
		ChestGenHooks strongHoldLibrary = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY);
		strongHoldLibrary.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.copperIngot), 0, 1, 8));
		strongHoldLibrary.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.sapphireGem), 0, 1, 6));
		strongHoldLibrary.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.rubyGem), 0, 2, 4));
		strongHoldLibrary.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.foolsRubyGem), 0, 4, 10));
		strongHoldLibrary.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumIngot), 0, 1, 2));
		strongHoldLibrary.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.tapaziteObelisk), 0, 1, 2));
		strongHoldLibrary.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.osmoniumIngot), 0, 1, 2));
		strongHoldLibrary.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.starconiumGem), 0, 2, 2));
		
		ChestGenHooks strongHoldCrossing = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING);
		strongHoldCrossing.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.copperIngot), 0, 1, 8));
		strongHoldCrossing.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.sapphireGem), 0, 1, 6));
		strongHoldCrossing.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.rubyGem), 0, 2, 4));
		strongHoldCrossing.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.foolsRubyGem), 0, 4, 10));
		strongHoldCrossing.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumIngot), 0, 1, 2));
		strongHoldCrossing.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.tapaziteObelisk), 0, 1, 1));
		strongHoldCrossing.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.osmoniumIngot), 0, 1, 1));
		strongHoldCrossing.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.starconiumGem), 0, 1, 1));
		
		ChestGenHooks blackSmith = ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH);
		blackSmith.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.copperIngot), 0, 1, 8));
		blackSmith.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.sapphireGem), 0, 1, 6));
		blackSmith.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.rubyGem), 0, 2, 4));
		blackSmith.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.foolsRubyGem), 0, 4, 10));
		blackSmith.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumIngot), 0, 1, 2));
		blackSmith.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.tapaziteObelisk), 0, 1, 1));
		blackSmith.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.osmoniumIngot), 0, 1, 1));
		blackSmith.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.starconiumGem), 0, 1, 1));
		
		ChestGenHooks bonusChest = ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST);
		bonusChest.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.copperIngot), 0, 1, 8));
		bonusChest.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.foolsRubyGem), 0, 4, 10));
		
		ChestGenHooks dungeonChest = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.copperIngot), 0, 1, 8));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.sapphireGem), 0, 1, 6));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.rubyGem), 0, 2, 4));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.foolsRubyGem), 0, 4, 10));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumIngot), 0, 1, 2));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.tapaziteObelisk), 0, 1, 1));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.osmoniumIngot), 0, 1, 1));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.starconiumGem), 0, 1, 1));
		
		ChestGenHooks zectiumDungeon = ChestGenHooks.getInfo(ZECTIUM_DUNGEON);
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.bread),					0, 3, 15));
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.diamond),					0, 1,  2));
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumCore),			0, 3, 32));		
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumIngot),		0, 2, 40));		
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumLeggings),		0, 1,  5));		
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumChestplate),	0, 1,  3));		
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumHelmet),		0, 1,  4));		
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumBoots),		0, 1,  4));		
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.starconiumGem),		0, 1,  2));	
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.starconiumShard),		0, 1,  1));
		
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_blocks),			0, 1,  1));
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_cat),				0, 1,  1));
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_chirp),			0, 1,  1));
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_far),				0, 1,  1));
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_mall),				0, 1,  1));
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_mellohi),			0, 1,  1));
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_stal),				0, 1,  1));
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_strad),			0, 1,  1));
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_wait),				0, 1,  1));
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_ward),				0, 1,  1));
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_11),				0, 1,  1));
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_13),				0, 1,  1));
		
		zectiumDungeon.setMin(3);																							
		zectiumDungeon.setMax(7);
		
		ChestGenHooks adamiteDungeon = ChestGenHooks.getInfo(ADAMITE_DUNGEON);
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.fish),					0, 3, 15));
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.diamond),					0, 1, 3));
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.adamiteShard),		0, 2, 25));	
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.adamiteLeggings),		0, 1,  5));	
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.adamiteChestplate),	0, 1,  3));	
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.adamiteHelmet),		0, 1,  4));	
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.adamiteBoots),		0, 1,  4));	
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.starconiumGem),		0, 1,  2));	
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.starconiumShard),		0, 1,  1));
		
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_blocks),			0, 1,  1));
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_cat),				0, 1,  1));
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_chirp),			0, 1,  1));
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_far),				0, 1,  1));
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_mall),				0, 1,  1));
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_mellohi),			0, 1,  1));
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_stal),				0, 1,  1));
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_strad),			0, 1,  1));
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_wait),				0, 1,  1));
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_ward),				0, 1,  1));
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_11),				0, 1,  1));
		adamiteDungeon.addItem(new WeightedRandomChestContent(new ItemStack(Items.record_13),				0, 1,  1));
		
		adamiteDungeon.setMin(3);																							
		adamiteDungeon.setMax(7);
	}
}

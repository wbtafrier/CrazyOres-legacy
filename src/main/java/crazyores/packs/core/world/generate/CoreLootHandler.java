package crazyores.packs.core.world.generate;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import crazyores.packs.core.item.CoreItems;

public class CoreLootHandler {
	
	public static final String ZECTIUM_DUNGEON = "zectiumDungeon";
	
	public static void initLoot() {
		
//		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.starconiumGem), 1, 3, 100));
//		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(yourItem),1,6,50));
//		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(yourItem),1,3,5));
//		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(yourItem),1,5,8));
//		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(yourItem),1,1,1));
		
		
		ChestGenHooks zectiumDungeon = ChestGenHooks.getInfo(ZECTIUM_DUNGEON);
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumCore),			1, 5, 32));		//	32
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumIngot),		1, 2, 50));		//	50
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumLeggings),		0, 1,  5));		//	5
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumChestplate),	0, 1,  3));		//	3
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumHelmet),		0, 1,  4));		//	4
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.zectiumBoots),		0, 1,  4));		//	4
		zectiumDungeon.addItem(new WeightedRandomChestContent(new ItemStack(CoreItems.starconiumShard),		0, 1,  2));		//	2
		zectiumDungeon.setMin(3);																							//	100
		zectiumDungeon.setMax(7);
	}
}

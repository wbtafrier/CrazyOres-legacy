package crazyores_core.common.core;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores_core.common.blocks.BlockList;
import crazyores_core.common.items.ItemList;

public class SmeltingRecipes 
{
	public static void registerSmeltingRecipes()
	{
		GameRegistry.addSmelting(BlockList.copper_ore, new ItemStack(ItemList.copper_ingot), 0.6F); 
		GameRegistry.addSmelting(BlockList.sapphire_ore, new ItemStack(ItemList.sapphire_gem), 0.75F);
    	GameRegistry.addSmelting(BlockList.meteorite_ore, new ItemStack(ItemList.meteorite_coal), 0.3F);
    	GameRegistry.addSmelting(BlockList.experium_ore, new ItemStack(ItemList.experium_orb), 0.3F);
		GameRegistry.addSmelting(BlockList.adamite_ore, new ItemStack(ItemList.adamite_shard), 0.78F);
    	GameRegistry.addSmelting(BlockList.ruby_ore, new ItemStack(ItemList.ruby_gem), 0.8F);
    	GameRegistry.addSmelting(BlockList.fools_ruby_ore, new ItemStack(ItemList.fools_ruby_mush), 0.1F);
    	GameRegistry.addSmelting(BlockList.zectium_ore, new ItemStack(ItemList.zectium_ingot), 2.0F);
    	GameRegistry.addSmelting(BlockList.tapazite_ore, new ItemStack(ItemList.tapazite_gem), 2.7F);
    	GameRegistry.addSmelting(BlockList.crystal_ore, new ItemStack(ItemList.crystal_shard), 3.5F);
    	GameRegistry.addSmelting(BlockList.osmonium_ore, new ItemStack(ItemList.osmonium_ingot), 4.2F);
    	GameRegistry.addSmelting(BlockList.starconium_ore, new ItemStack(ItemList.starconium_gem), 5.0F);
    	GameRegistry.addSmelting(BlockList.demonite_stone, new ItemStack(ItemList.demonite_orb, 3), 1.0F);
    	GameRegistry.addSmelting(BlockList.ender_ore, new ItemStack(ItemList.ender_gem), 2.0F);
    	GameRegistry.addSmelting(BlockList.luminite_ore, new ItemStack(ItemList.white_luminite_crystal), 0.4F);
    	GameRegistry.addSmelting(BlockList.darkstone, new ItemStack(ItemList.darkstone_ingot), 1.1F);
    	GameRegistry.addSmelting(BlockList.invisium_ore, new ItemStack(ItemList.invisium_ingot), 1.3F);
    	GameRegistry.addSmelting(BlockList.ultra_ore, new ItemStack(ItemList.ultra_gem), 4.0F);
	}
}
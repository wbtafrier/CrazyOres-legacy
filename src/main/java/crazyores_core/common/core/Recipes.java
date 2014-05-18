package crazyores_core.common.core;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores_core.common.blocks.BlockList;
import crazyores_core.common.items.ItemList;

public class Recipes 
{
	private static BlockList bl;
	private static ItemList il;
	
	public static void craftingRecipes()
	{
		/** Tools **/
        GameRegistry.addRecipe(new ItemStack(il.copper_pickaxe, 1), new Object[] { "###", " X "," X ", 'X', Items.stick, '#', il.copper_ingot });
        GameRegistry.addRecipe(new ItemStack(il.copper_axe, 1), new Object[] { " ##", " X#"," X ", 'X', Items.stick, '#', il.copper_ingot });
        GameRegistry.addRecipe(new ItemStack(il.copper_axe, 1), new Object[] { "## ", "#X "," X ", 'X', Items.stick, '#', il.copper_ingot });
        GameRegistry.addRecipe(new ItemStack(il.copper_shovel, 1), new Object[] { "#", "X", "X", 'X', Items.stick, '#', il.copper_ingot });
        GameRegistry.addRecipe(new ItemStack(il.copper_sword, 1), new Object[] { "#", "#", "X", 'X', Items.stick, '#', il.copper_ingot });
        GameRegistry.addRecipe(new ItemStack(il.copper_hoe, 1), new Object[] { " ##", " X ", " X ", 'X', Items.stick, '#', il.copper_ingot });
        GameRegistry.addRecipe(new ItemStack(il.copper_hoe, 1), new Object[] { "## ", " X ", " X ", 'X', Items.stick, '#', il.copper_ingot });
        
        GameRegistry.addRecipe(new ItemStack(il.sapphire_pickaxe, 1), new Object[] { "###", " X "," X ", 'X', Items.stick, '#', il.sapphire_gem });
        GameRegistry.addRecipe(new ItemStack(il.sapphire_axe, 1), new Object[] { " ##", " X#", " X ", 'X', Items.stick, '#', il.sapphire_gem });
        GameRegistry.addRecipe(new ItemStack(il.sapphire_axe, 1), new Object[] { "## ", "#X ", " X ", 'X', Items.stick, '#', il.sapphire_gem });
        GameRegistry.addRecipe(new ItemStack(il.sapphire_shovel, 1), new Object[] { "#", "X", "X", 'X', Items.stick, '#', il.sapphire_gem });
        GameRegistry.addRecipe(new ItemStack(il.sapphire_sword, 1), new Object[] { "#", "#", "X", 'X', Items.stick, '#', il.sapphire_gem });
        GameRegistry.addRecipe(new ItemStack(il.sapphire_hoe, 1), new Object[] { " ##", " X ", " X ", 'X', Items.stick, '#', il.sapphire_gem });
        GameRegistry.addRecipe(new ItemStack(il.sapphire_hoe, 1), new Object[] { "## ", " X ", " X ", 'X', Items.stick, '#', il.sapphire_gem });
        
        GameRegistry.addRecipe(new ItemStack(il.invisium_pickaxe, 1), new Object[] { "###", " X "," X ", 'X', Items.stick, '#', il.invisium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.invisium_axe, 1), new Object[] { " ##", " X#", " X ", 'X', Items.stick, '#', il.invisium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.invisium_axe, 1), new Object[] { "## ", "#X ", " X ", 'X', Items.stick, '#', il.invisium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.invisium_shovel, 1), new Object[] { "#", "X", "X", 'X', Items.stick, '#', il.invisium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.invisium_sword, 1), new Object[] { "#", "#", "X", 'X', Items.stick, '#', il.invisium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.invisium_hoe, 1), new Object[] { " ##", " X ", " X ", 'X', Items.stick, '#', il.invisium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.invisium_hoe, 1), new Object[] { "## ", " X ", " X ", 'X', Items.stick, '#', il.invisium_ingot });
        
        GameRegistry.addRecipe(new ItemStack(il.adamite_pickaxe, 1), new Object[] { "###", " X "," X ", 'X', Items.stick, '#', il.adamite_shard });
        GameRegistry.addRecipe(new ItemStack(il.adamite_axe, 1), new Object[] { " ##", " X#"," X ", 'X', Items.stick, '#', il.adamite_shard });
        GameRegistry.addRecipe(new ItemStack(il.adamite_axe, 1), new Object[] { "## ", "#X "," X ", 'X', Items.stick, '#', il.adamite_shard });
        GameRegistry.addRecipe(new ItemStack(il.adamite_shovel, 1), new Object[] { "#", "X", "X", 'X', Items.stick, '#', il.adamite_shard });
        GameRegistry.addRecipe(new ItemStack(il.adamite_sword, 1), new Object[] { "#", "#", "X", 'X', Items.stick, '#', il.adamite_shard });
        GameRegistry.addRecipe(new ItemStack(il.adamite_hoe, 1), new Object[] { " ##", " X ", " X ", 'X', Items.stick, '#', il.adamite_shard });
        GameRegistry.addRecipe(new ItemStack(il.adamite_hoe, 1), new Object[] { "## ", " X ", " X ", 'X', Items.stick, '#', il.adamite_shard });
        
        GameRegistry.addRecipe(new ItemStack(il.meteorite_pickaxe, 1), new Object[] { "###", " X "," X ", 'X', Items.stick, '#', il.meteorite_gem });
        GameRegistry.addRecipe(new ItemStack(il.meteorite_axe, 1), new Object[] { " ##", " X#", " X ", 'X', Items.stick, '#', il.meteorite_gem });
        GameRegistry.addRecipe(new ItemStack(il.meteorite_axe, 1), new Object[] { "## ", "#X ", " X ", 'X', Items.stick, '#', il.meteorite_gem });
        GameRegistry.addRecipe(new ItemStack(il.meteorite_shovel, 1), new Object[] { "#", "X", "X", 'X', Items.stick, '#', il.meteorite_gem });
        GameRegistry.addRecipe(new ItemStack(il.meteorite_sword, 1), new Object[] { "#", "#", "X", 'X', Items.stick, '#', il.meteorite_gem });
        GameRegistry.addRecipe(new ItemStack(il.meteorite_hoe, 1), new Object[] { " ##", " X ", " X ", 'X', Items.stick, '#', il.meteorite_gem });
        GameRegistry.addRecipe(new ItemStack(il.meteorite_hoe, 1), new Object[] { "## ", " X ", " X ", 'X', Items.stick, '#', il.meteorite_gem });
        
        GameRegistry.addRecipe(new ItemStack(il.ruby_pickaxe, 1), new Object[] { "###", " X "," X ", 'X', Items.stick, '#', il.ruby_gem });
        GameRegistry.addRecipe(new ItemStack(il.ruby_axe, 1), new Object[] { " ##", " X#", " X ", 'X', Items.stick, '#', il.ruby_gem });
        GameRegistry.addRecipe(new ItemStack(il.ruby_axe, 1), new Object[] { "## ", "#X ", " X ", 'X', Items.stick, '#', il.ruby_gem });
        GameRegistry.addRecipe(new ItemStack(il.ruby_shovel, 1), new Object[] { "#", "X", "X", 'X', Items.stick, '#', il.ruby_gem });
        GameRegistry.addRecipe(new ItemStack(il.ruby_sword, 1), new Object[] { "#", "#", "X", 'X', Items.stick, '#', il.ruby_gem });
        GameRegistry.addRecipe(new ItemStack(il.ruby_hoe, 1), new Object[] { " ##", " X ", " X ", 'X', Items.stick, '#', il.ruby_gem });
        GameRegistry.addRecipe(new ItemStack(il.ruby_hoe, 1), new Object[] { "## ", " X ", " X ", 'X', Items.stick, '#', il.ruby_gem });
        
        GameRegistry.addRecipe(new ItemStack(il.zectium_pickaxe, 1), new Object[] { "###", " X "," X ", 'X', Items.stick, '#', il.zectium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.zectium_axe, 1), new Object[] { " ##", " X#", " X ", 'X', Items.stick, '#', il.zectium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.zectium_axe, 1), new Object[] { "## ", "#X ", " X ", 'X', Items.stick, '#', il.zectium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.zectium_shovel, 1), new Object[] { "#", "X", "X", 'X', Items.stick, '#', il.zectium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.zectium_sword, 1), new Object[] { "#", "#", "X", 'X', Items.stick, '#', il.zectium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.zectium_hoe, 1), new Object[] { " ##", " X ", " X ", 'X', Items.stick, '#', il.zectium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.zectium_hoe, 1), new Object[] { "## ", " X ", " X ", 'X', Items.stick, '#', il.zectium_ingot });
        
        GameRegistry.addRecipe(new ItemStack(il.tapazite_pickaxe, 1), new Object[] { "###", " X "," X ", 'X', Items.stick, '#', il.tapazite_gem });
        GameRegistry.addRecipe(new ItemStack(il.tapazite_axe, 1), new Object[] { " ##", " X#"," X ", 'X', Items.stick, '#', il.tapazite_gem });
        GameRegistry.addRecipe(new ItemStack(il.tapazite_axe, 1), new Object[] { "## ", "#X "," X ", 'X', Items.stick, '#', il.tapazite_gem });
        GameRegistry.addRecipe(new ItemStack(il.tapazite_shovel, 1), new Object[] { "#", "X", "X", 'X', Items.stick, '#', il.tapazite_gem });
        GameRegistry.addRecipe(new ItemStack(il.tapazite_sword, 1), new Object[] { "#", "#", "X", 'X', Items.stick, '#', il.tapazite_gem });
        GameRegistry.addRecipe(new ItemStack(il.tapazite_hoe, 1), new Object[] { " ##", " X ", " X ", 'X', Items.stick, '#', il.tapazite_gem });
        GameRegistry.addRecipe(new ItemStack(il.tapazite_hoe, 1), new Object[] { "## ", " X ", " X ", 'X', Items.stick, '#', il.tapazite_gem });
        
        GameRegistry.addRecipe(new ItemStack(il.crystal_pickaxe, 1), new Object[] { "###", " X "," X ", 'X', Items.stick, '#', il.crystal_shard });
        GameRegistry.addRecipe(new ItemStack(il.crystal_axe, 1), new Object[] { " ##", " X#", " X ", 'X', Items.stick, '#', il.crystal_shard });
        GameRegistry.addRecipe(new ItemStack(il.crystal_axe, 1), new Object[] { "## ", "#X ", " X ", 'X', Items.stick, '#', il.crystal_shard });
        GameRegistry.addRecipe(new ItemStack(il.crystal_shovel, 1), new Object[] { "#", "X","X", 'X', Items.stick, '#', il.crystal_shard });
        GameRegistry.addRecipe(new ItemStack(il.crystal_sword, 1), new Object[] { "#", "#","X", 'X', Items.stick, '#', il.crystal_shard });
        GameRegistry.addRecipe(new ItemStack(il.crystal_hoe, 1), new Object[] { " ##", " X ", " X ", 'X', Items.stick, '#', il.crystal_shard });
        GameRegistry.addRecipe(new ItemStack(il.crystal_hoe, 1), new Object[] { "## ", " X ", " X ", 'X', Items.stick, '#', il.crystal_shard });
        
        GameRegistry.addRecipe(new ItemStack(il.osmonium_pickaxe, 1), new Object[] { "###", " X "," X ", 'X', Items.stick, '#', il.osmonium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.osmonium_axe, 1), new Object[] { " ##", " X#"," X ", 'X', Items.stick, '#', il.osmonium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.osmonium_axe, 1), new Object[] { "## ", "#X "," X ", 'X', Items.stick, '#', il.osmonium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.osmonium_shovel, 1), new Object[] { "#", "X", "X", 'X', Items.stick, '#', il.osmonium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.osmonium_sword, 1), new Object[] { "#", "#", "X", 'X', Items.stick, '#', il.osmonium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.osmonium_hoe, 1), new Object[] { " ##", " X ", " X ", 'X', Items.stick, '#', il.osmonium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.osmonium_hoe, 1), new Object[] { "## ", " X ", " X ", 'X', Items.stick, '#', il.osmonium_ingot });
        
        GameRegistry.addRecipe(new ItemStack(il.starconium_pickaxe, 1), new Object[] { "###", " X "," X ", 'X', Items.stick, '#', il.starconium_gem });
        GameRegistry.addRecipe(new ItemStack(il.starconium_axe, 1), new Object[] { " ##", " X#", " X ", 'X', Items.stick, '#', il.starconium_gem });
        GameRegistry.addRecipe(new ItemStack(il.starconium_axe, 1), new Object[] { "## ", "#X ", " X ", 'X', Items.stick, '#', il.starconium_gem });
        GameRegistry.addRecipe(new ItemStack(il.starconium_shovel, 1), new Object[] { "#", "X", "X", 'X', Items.stick, '#', il.starconium_gem });
        GameRegistry.addRecipe(new ItemStack(il.starconium_sword, 1), new Object[] { "#", "#", "X", 'X', Items.stick, '#', il.starconium_gem });
        GameRegistry.addRecipe(new ItemStack(il.starconium_hoe, 1), new Object[] { " ##", " X ", " X ", 'X', Items.stick, '#', il.starconium_gem });
        GameRegistry.addRecipe(new ItemStack(il.starconium_hoe, 1), new Object[] { "## ", " X ", " X ", 'X', Items.stick, '#', il.starconium_gem });
        GameRegistry.addRecipe(new ItemStack(il.starconium_sledgehammer, 1), new Object[] { "###", "###", " X ", 'X', Items.stick, '#', il.starconium_gem });
        
        GameRegistry.addRecipe(new ItemStack(il.ender_pickaxe, 1), new Object[] { "###", " X "," X ", 'X', Items.stick, '#', il.ender_gem });
        GameRegistry.addRecipe(new ItemStack(il.ender_axe, 1), new Object[] { " ##", " X#", " X ", 'X', Items.stick, '#', il.ender_gem });
        GameRegistry.addRecipe(new ItemStack(il.ender_axe, 1), new Object[] { "## ", "#X ", " X ", 'X', Items.stick, '#', il.ender_gem });
        GameRegistry.addRecipe(new ItemStack(il.ender_shovel, 1), new Object[] { "#", "X", "X", 'X', Items.stick, '#', il.ender_gem });
        GameRegistry.addRecipe(new ItemStack(il.ender_sword, 1), new Object[] { "#", "#", "X", 'X', Items.stick, '#', il.ender_gem });
        GameRegistry.addRecipe(new ItemStack(il.ender_hoe, 1), new Object[] { " ##", " X ", " X ", 'X', Items.stick, '#', il.ender_gem });
        GameRegistry.addRecipe(new ItemStack(il.ender_hoe, 1), new Object[] { "## ", " X ", " X ", 'X', Items.stick, '#', il.ender_gem });
        
        /** Items **/
        GameRegistry.addRecipe(new ItemStack(Blocks.torch, 16), new Object[] { "X", "I", 'X', il.meteorite_coal, 'I', Items.stick});
        GameRegistry.addRecipe(new ItemStack(Blocks.torch, 32), new Object[] { "X", "I", 'X', il.meteorite_gem, 'I', Items.stick});
        GameRegistry.addRecipe(new ItemStack(il.copper_bucket_empty, 1), new Object[] { "X X", " X ", 'X', il.copper_ingot});
        GameRegistry.addRecipe(new ItemStack(il.starconium_shard, 1), new Object[] { "XXX", "X#X", "XXX", 'X', il.starconium_gem, '#', il.crystal_shard });
        GameRegistry.addRecipe(new ItemStack(il.copper_rod, 4), new Object [] { "X", "X", 'X', il.copper_ingot });
        GameRegistry.addRecipe(new ItemStack(il.sapphire_rod, 4), new Object [] { "X", "X", 'X', il.sapphire_gem });
        GameRegistry.addRecipe(new ItemStack(il.meteorite_rod, 4), new Object [] { "X", "X", 'X', il.meteorite_gem });
        GameRegistry.addRecipe(new ItemStack(il.ruby_rod, 4), new Object [] { "X", "X", 'X', il.ruby_gem });
        GameRegistry.addRecipe(new ItemStack(il.zectium_rod, 4), new Object [] { "X", "X", 'X', il.zectium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.crystal_rod, 4), new Object [] { "X", "X", 'X', il.crystal_shard });
        GameRegistry.addRecipe(new ItemStack(il.starconium_rod, 4), new Object [] { "X", "X", 'X', il.starconium_gem });
        GameRegistry.addRecipe(new ItemStack(il.invisium_rod, 4), new Object [] { "X", "X", 'X', il.invisium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.ender_rod, 4), new Object [] { "X", "X", 'X', il.ender_gem });
        GameRegistry.addRecipe(new ItemStack(il.adamite_rod, 4), new Object [] { "X", "X", 'X', il.adamite_shard });
        GameRegistry.addRecipe(new ItemStack(il.tapazite_rod, 4), new Object [] { "X", "X", 'X', il.tapazite_gem });
        GameRegistry.addRecipe(new ItemStack(il.osmonium_rod, 4), new Object [] { "X", "X", 'X', il.osmonium_ingot });
        
        /** Shapeless **/
        GameRegistry.addShapelessRecipe(new ItemStack(Items.experience_bottle, 1), il.experium_orb, Items.glass_bottle);
        GameRegistry.addShapelessRecipe(new ItemStack(il.meteorite_arrow, 1), il.meteorite_coal, Items.arrow);
        GameRegistry.addShapelessRecipe(new ItemStack(il.copper_arrow, 1), il.copper_ingot, Items.arrow);
        GameRegistry.addShapelessRecipe(new ItemStack(il.invisium_arrow, 1), il.invisium_ingot, Items.arrow);
        GameRegistry.addShapelessRecipe(new ItemStack(il.sapphire_arrow, 1), il.sapphire_gem, Items.arrow);
        GameRegistry.addShapelessRecipe(new ItemStack(il.adamite_arrow, 1), il.adamite_shard, Items.arrow);
        GameRegistry.addShapelessRecipe(new ItemStack(il.ruby_arrow, 1), il.ruby_gem, Items.arrow);
        GameRegistry.addShapelessRecipe(new ItemStack(il.zectium_arrow, 1), il.zectium_ingot, Items.arrow);
        GameRegistry.addShapelessRecipe(new ItemStack(il.tapazite_arrow, 1), il.tapazite_gem, Items.arrow);
        GameRegistry.addShapelessRecipe(new ItemStack(il.crystal_arrow, 1), il.crystal_shard, Items.arrow);
        GameRegistry.addShapelessRecipe(new ItemStack(il.osmonium_arrow, 1), il.osmonium_ingot, Items.arrow);
        GameRegistry.addShapelessRecipe(new ItemStack(il.ender_arrow, 1), il.ender_gem, Items.arrow);
        GameRegistry.addShapelessRecipe(new ItemStack(il.starconium_arrow, 1), il.starconium_gem, Items.arrow);
        
        /** Demonite Furnace Recipe **/
        GameRegistry.addRecipe(new ItemStack(bl.refined_demonite_block, 1), new Object [] { "XXX", "X X", "XXX", 'X', bl.demonite_block});
        GameRegistry.addRecipe(new ItemStack(bl.demonite_furnace, 1), new Object [] { "XXX", "X#X", "XXX", 'X', bl.refined_demonite_block, '#', il.starconium_shard});
        
        /** _arrows **/
        GameRegistry.addRecipe(new ItemStack(il.meteorite_arrow, 4), new Object [] { "#", "I", "X", '#', il.meteorite_coal, 'I', Items.stick, 'X', Items.feather});
        GameRegistry.addRecipe(new ItemStack(il.copper_arrow, 4), new Object [] { "#", "I", "X", '#', il.copper_ingot, 'I', Items.stick, 'X', Items.feather});
        GameRegistry.addRecipe(new ItemStack(il.invisium_arrow, 4), new Object [] { "#", "I", "X", '#', il.invisium_ingot, 'I', Items.stick, 'X', Items.feather});
        GameRegistry.addRecipe(new ItemStack(il.sapphire_arrow, 4), new Object [] { "#", "I", "X", '#', il.sapphire_gem, 'I', Items.stick, 'X', Items.feather});
        GameRegistry.addRecipe(new ItemStack(il.adamite_arrow, 4), new Object [] { "#", "I", "X", '#', il.adamite_shard, 'I', Items.stick, 'X', Items.feather});
        GameRegistry.addRecipe(new ItemStack(il.ruby_arrow, 4), new Object [] { "#", "I", "X", '#', il.ruby_gem, 'I', Items.stick, 'X', Items.feather});
        GameRegistry.addRecipe(new ItemStack(il.zectium_arrow, 4), new Object [] { "#", "I", "X", '#', il.zectium_ingot, 'I', Items.stick, 'X', Items.feather});
        GameRegistry.addRecipe(new ItemStack(il.tapazite_arrow, 4), new Object [] { "#", "I", "X", '#', il.tapazite_gem, 'I', Items.stick, 'X', Items.feather});
        GameRegistry.addRecipe(new ItemStack(il.crystal_arrow, 4), new Object [] { "#", "I", "X", '#', il.crystal_shard, 'I', Items.stick, 'X', Items.feather});
        GameRegistry.addRecipe(new ItemStack(il.osmonium_arrow, 4), new Object [] { "#", "I", "X", '#', il.osmonium_ingot, 'I', Items.stick, 'X', Items.feather});
        GameRegistry.addRecipe(new ItemStack(il.ender_arrow, 4), new Object [] { "#", "I", "X", '#', il.ender_gem, 'I', Items.stick, 'X', Items.feather});
        GameRegistry.addRecipe(new ItemStack(il.starconium_arrow, 4), new Object [] { "#", "I", "X", '#', il.starconium_gem, 'I', Items.stick, 'X', Items.feather});
        
        /** _bows **/
        GameRegistry.addRecipe(new ItemStack(il.meteorite_bow, 1), new Object[] { "X# ","X #","X# ", 'X', Items.string, '#', il.meteorite_rod });
        GameRegistry.addRecipe(new ItemStack(il.copper_bow, 1), new Object[] { "X# ","X #","X# ", 'X', Items.string, '#', il.copper_rod });
        GameRegistry.addRecipe(new ItemStack(il.invisium_bow, 1), new Object[] { "X# ","X #","X# ", 'X', Items.string, '#', il.invisium_rod });
        GameRegistry.addRecipe(new ItemStack(il.sapphire_bow, 1), new Object[] { "X# ","X #","X# ", 'X', Items.string, '#', il.sapphire_rod });
        GameRegistry.addRecipe(new ItemStack(il.adamite_bow, 1), new Object[] { "X# ","X #","X# ", 'X', Items.string, '#', il.adamite_rod });
        GameRegistry.addRecipe(new ItemStack(il.ruby_bow, 1), new Object[] { "X# ","X #","X# ", 'X', Items.string, '#', il.ruby_rod });
        GameRegistry.addRecipe(new ItemStack(il.zectium_bow, 1), new Object[] { "X# ","X #","X# ", 'X', Items.string, '#', il.zectium_rod });
        GameRegistry.addRecipe(new ItemStack(il.tapazite_bow, 1), new Object[] { "X# ","X #","X# ", 'X', Items.string, '#', il.tapazite_rod });
        GameRegistry.addRecipe(new ItemStack(il.crystal_bow, 1), new Object[] { "X# ","X #","X# ", 'X', Items.string, '#', il.crystal_rod });
        GameRegistry.addRecipe(new ItemStack(il.osmonium_bow, 1), new Object[] { "X# ","X #","X# ", 'X', Items.string, '#', il.osmonium_rod });
        GameRegistry.addRecipe(new ItemStack(il.ender_bow, 1), new Object[] { "X# ","X #","X# ", 'X', Items.string, '#', il.ender_rod });
        GameRegistry.addRecipe(new ItemStack(il.starconium_bow, 1), new Object[] { "X# ","X #","X# ", 'X', Items.string, '#', il.starconium_rod });
        
        /** Golem Heads **/
        GameRegistry.addRecipe(new ItemStack(bl.copper_golem_head, 1), new Object [] { "XXX", "#X#", "XXX", '#', Items.redstone, 'X', il.copper_ingot});
        GameRegistry.addRecipe(new ItemStack(bl.sapphire_golem_head, 1), new Object [] { "XXX", "#X#", "XXX", '#', Items.redstone, 'X', il.sapphire_gem});
        GameRegistry.addRecipe(new ItemStack(bl.adamite_golem_head, 1), new Object [] { "XXX", "#X#", "XXX", '#', Items.redstone, 'X', il.adamite_shard});
        GameRegistry.addRecipe(new ItemStack(bl.ruby_golem_head, 1), new Object [] { "XXX", "#X#", "XXX", '#', Items.redstone, 'X', il.ruby_gem});
        GameRegistry.addRecipe(new ItemStack(bl.fools_ruby_golem_head, 1), new Object [] { "XXX", "#X#", "XXX", '#', Items.redstone, 'X', il.fools_ruby_gem});
        GameRegistry.addRecipe(new ItemStack(bl.zectium_golem_head, 1), new Object [] { "XXX", "#X#", "XXX", '#', Items.redstone, 'X', il.zectium_ingot});
        GameRegistry.addRecipe(new ItemStack(bl.tapazite_golem_head, 1), new Object [] { "XXX", "#X#", "XXX", '#', Items.redstone, 'X', il.tapazite_gem});
        GameRegistry.addRecipe(new ItemStack(bl.crystal_golem_head, 1), new Object [] { "XXX", "#X#", "XXX", '#', Items.redstone, 'X', il.crystal_shard});
        GameRegistry.addRecipe(new ItemStack(bl.osmonium_golem_head, 1), new Object [] { "XXX", "#X#", "XXX", '#', Items.redstone, 'X', il.osmonium_ingot});
        GameRegistry.addRecipe(new ItemStack(bl.starconium_golem_head, 1), new Object [] { "XXX", "#X#", "XXX", '#', Items.redstone, 'X', il.starconium_gem});
        GameRegistry.addRecipe(new ItemStack(bl.demonite_golem_head, 1), new Object [] { "XXX", "#X#", "XXX", '#', Items.redstone, 'X', il.demonite_orb});
        
        /** Armor **/
        GameRegistry.addRecipe(new ItemStack(il.copper_helmet, 1), new Object[] { "###", "# #", '#', il.copper_ingot });
        GameRegistry.addRecipe(new ItemStack(il.copper_chestplate, 1), new Object[] { "# #", "###", "###", '#', il.copper_ingot });
        GameRegistry.addRecipe(new ItemStack(il.copper_leggings, 1), new Object[] { "###", "# #", "# #", '#', il.copper_ingot });
        GameRegistry.addRecipe(new ItemStack(il.copper_boots, 1), new Object[] { "# #", "# #", '#', il.copper_ingot });
        GameRegistry.addRecipe(new ItemStack(il.sapphire_helmet, 1), new Object[] { "###", "# #", '#', il.sapphire_gem });
        GameRegistry.addRecipe(new ItemStack(il.sapphire_chestplate, 1), new Object[] { "# #", "###", "###", '#', il.sapphire_gem });
        GameRegistry.addRecipe(new ItemStack(il.sapphire_leggings, 1), new Object[] { "###", "# #", "# #", '#', il.sapphire_gem });
        GameRegistry.addRecipe(new ItemStack(il.sapphire_boots, 1), new Object[] { "# #", "# #", '#', il.sapphire_gem });
        GameRegistry.addRecipe(new ItemStack(il.invisium_helmet, 1), new Object[] { "###", "# #", '#', il.invisium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.invisium_chestplate, 1), new Object[] { "# #", "###", "###", '#', il.invisium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.invisium_leggings, 1), new Object[] { "###", "# #", "# #", '#', il.invisium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.invisium_boots, 1), new Object[] { "# #", "# #", '#', il.invisium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.adamite_helmet, 1), new Object[] { "###", "# #", '#', il.adamite_shard });
        GameRegistry.addRecipe(new ItemStack(il.adamite_chestplate, 1), new Object[] { "# #", "###", "###", '#', il.adamite_shard });
        GameRegistry.addRecipe(new ItemStack(il.adamite_leggings, 1), new Object[] { "###", "# #", "# #", '#', il.adamite_shard });
        GameRegistry.addRecipe(new ItemStack(il.adamite_boots, 1), new Object[] { "# #", "# #", '#', il.adamite_shard });
        GameRegistry.addRecipe(new ItemStack(il.meteorite_helmet, 1), new Object[] { "###", "# #", '#', il.meteorite_gem });
        GameRegistry.addRecipe(new ItemStack(il.meteorite_chestplate, 1), new Object[] { "# #", "###", "###", '#', il.meteorite_gem });
        GameRegistry.addRecipe(new ItemStack(il.meteorite_leggings, 1), new Object[] { "###", "# #", "# #", '#', il.meteorite_gem });
        GameRegistry.addRecipe(new ItemStack(il.meteorite_boots, 1), new Object[] { "# #", "# #", '#', il.meteorite_gem });
        GameRegistry.addRecipe(new ItemStack(il.ruby_helmet, 1), new Object[] { "###", "# #", '#', il.ruby_gem });
        GameRegistry.addRecipe(new ItemStack(il.ruby_chestplate, 1), new Object[] { "# #", "###", "###", '#', il.ruby_gem });
        GameRegistry.addRecipe(new ItemStack(il.ruby_leggings, 1), new Object[] { "###", "# #", "# #", '#', il.ruby_gem});
        GameRegistry.addRecipe(new ItemStack(il.ruby_boots, 1), new Object[] { "# #", "# #", '#', il.ruby_gem });
        GameRegistry.addRecipe(new ItemStack(il.zectium_helmet, 1), new Object[] { "###", "# #", '#', il.zectium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.zectium_chestplate, 1), new Object[] { "# #", "###", "###", '#', il.zectium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.zectium_leggings, 1), new Object[] { "###", "# #", "# #", '#', il.zectium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.zectium_boots, 1), new Object[] { "# #", "# #", '#', il.zectium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.tapazite_helmet, 1), new Object[] { "###", "# #", '#', il.tapazite_gem });
        GameRegistry.addRecipe(new ItemStack(il.tapazite_chestplate, 1), new Object[] { "# #", "###", "###", '#', il.tapazite_gem });
        GameRegistry.addRecipe(new ItemStack(il.tapazite_leggings, 1), new Object[] { "###", "# #", "# #", '#', il.tapazite_gem });
        GameRegistry.addRecipe(new ItemStack(il.tapazite_boots, 1), new Object[] { "# #", "# #", '#', il.tapazite_gem });
        GameRegistry.addRecipe(new ItemStack(il.crystal_helmet, 1), new Object[] { "###", "# #", '#', il.crystal_shard });
        GameRegistry.addRecipe(new ItemStack(il.crystal_chestplate, 1), new Object[] { "# #", "###", "###", '#', il.crystal_shard });
        GameRegistry.addRecipe(new ItemStack(il.crystal_leggings, 1), new Object[] { "###", "# #", "# #", '#', il.crystal_shard});
        GameRegistry.addRecipe(new ItemStack(il.crystal_boots, 1), new Object[] { "# #", "# #", '#', il.crystal_shard });
        GameRegistry.addRecipe(new ItemStack(il.osmonium_helmet, 1), new Object[] { "###", "# #", '#', il.osmonium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.osmonium_chestplate, 1), new Object[] { "# #", "###", "###", '#', il.osmonium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.osmonium_leggings, 1), new Object[] { "###", "# #", "# #", '#', il.osmonium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.osmonium_boots, 1), new Object[] { "# #", "# #", '#', il.osmonium_ingot });
        GameRegistry.addRecipe(new ItemStack(il.ender_helmet, 1), new Object[] { "###", "# #", '#', il.ender_gem });
        GameRegistry.addRecipe(new ItemStack(il.ender_chestplate, 1), new Object[] { "# #", "###", "###", '#', il.ender_gem });
        GameRegistry.addRecipe(new ItemStack(il.ender_leggings, 1), new Object[] { "###", "# #", "# #", '#', il.ender_gem});
        GameRegistry.addRecipe(new ItemStack(il.ender_boots, 1), new Object[] { "# #", "# #", '#', il.ender_gem });
        GameRegistry.addRecipe(new ItemStack(il.starconium_helmet, 1), new Object[] { "###", "# #", '#', il.starconium_gem });
        GameRegistry.addRecipe(new ItemStack(il.starconium_chestplate, 1), new Object[] { "# #", "###", "###", '#', il.starconium_gem });
        GameRegistry.addRecipe(new ItemStack(il.starconium_leggings, 1), new Object[] { "###", "# #", "# #", '#', il.starconium_gem});
        GameRegistry.addRecipe(new ItemStack(il.starconium_boots, 1), new Object[] { "# #", "# #", '#', il.starconium_gem });
        
        /** _gems --> _blocks **/
        GameRegistry.addRecipe(new ItemStack(bl.copper_block, 1), new Object[] { "XXX", "XXX", "XXX", 'X', il.copper_ingot});
        GameRegistry.addRecipe(new ItemStack(bl.sapphire_block, 1), new Object[] { "XXX", "XXX", "XXX", 'X', il.sapphire_gem});
        GameRegistry.addRecipe(new ItemStack(bl.adamite_block, 1), new Object[] { "XXX", "XXX", "XXX", 'X', il.adamite_shard});
        GameRegistry.addRecipe(new ItemStack(bl.meteorite_block, 1), new Object[] { "XXX", "XXX", "XXX", 'X', il.meteorite_gem});
        GameRegistry.addRecipe(new ItemStack(bl.glowing_meteorite_block, 1), new Object[] { "XXX", "X#X", "XXX", 'X', il.meteorite_gem, '#', Items.glowstone_dust});
        GameRegistry.addRecipe(new ItemStack(bl.ruby_block, 1), new Object[] { "XXX", "XXX", "XXX", 'X', il.ruby_gem});
        GameRegistry.addRecipe(new ItemStack(bl.fools_ruby_block, 1), new Object[] { "XXX", "XXX", "XXX", 'X', il.fools_ruby_gem});
        GameRegistry.addRecipe(new ItemStack(bl.zectium_block, 1), new Object[] { "XXX", "XXX", "XXX", 'X', il.zectium_ingot});
        GameRegistry.addRecipe(new ItemStack(bl.tapazite_block, 1), new Object[] { "XXX", "XXX", "XXX", 'X', il.tapazite_gem});
        GameRegistry.addRecipe(new ItemStack(bl.crystal_block, 1), new Object[] { "XXX", "XXX", "XXX", 'X', il.crystal_shard});
        GameRegistry.addRecipe(new ItemStack(bl.osmonium_block, 1), new Object[] { "XXX", "XXX", "XXX", 'X', il.osmonium_ingot});
        GameRegistry.addRecipe(new ItemStack(bl.starconium_block, 1), new Object[] { "XXX", "XXX", "XXX", 'X', il.starconium_gem}); 
        GameRegistry.addRecipe(new ItemStack(bl.demonite_block, 1), new Object[] { "XXX", "XXX", "XXX", 'X', il.demonite_orb}); 
        GameRegistry.addRecipe(new ItemStack(bl.invisium_block, 1), new Object[] { "XXX", "XXX", "XXX", 'X', il.invisium_ingot}); 
        GameRegistry.addRecipe(new ItemStack(bl.ender_block, 1), new Object[] { "XXX", "XXX", "XXX", 'X', il.ender_gem}); 
        GameRegistry.addRecipe(new ItemStack(bl.experium_block, 1), new Object[] { "XXX", "XXX", "XXX", 'X', il.experium_orb}); 
        GameRegistry.addRecipe(new ItemStack(bl.ultra_block, 1), new Object[] { "XXX", "XXX", "XXX", 'X', il.ultra_gem});
        
        /** _blocks --> _gems **/
        GameRegistry.addRecipe(new ItemStack(il.copper_ingot, 9), new Object[] { "X", 'X', bl.copper_block});
        GameRegistry.addRecipe(new ItemStack(il.sapphire_gem, 9), new Object[] { "X", 'X', bl.sapphire_block});
        GameRegistry.addRecipe(new ItemStack(il.adamite_shard, 9), new Object[] { "X", 'X', bl.adamite_block});
        GameRegistry.addRecipe(new ItemStack(il.meteorite_gem, 9), new Object[] { "X", 'X', bl.meteorite_block});
        GameRegistry.addRecipe(new ItemStack(il.ruby_gem, 9), new Object[] { "X", 'X', bl.ruby_block});
        GameRegistry.addRecipe(new ItemStack(il.fools_ruby_gem, 9), new Object[] { "X", 'X', bl.fools_ruby_block});
        GameRegistry.addRecipe(new ItemStack(il.zectium_ingot, 9), new Object[] { "X", 'X', bl.zectium_block});
        GameRegistry.addRecipe(new ItemStack(il.tapazite_gem, 9), new Object[] { "X", 'X', bl.tapazite_block});
        GameRegistry.addRecipe(new ItemStack(il.crystal_shard, 9), new Object[] { "X", 'X', bl.crystal_block});
        GameRegistry.addRecipe(new ItemStack(il.osmonium_ingot, 9), new Object[] { "X", 'X', bl.osmonium_block});
        GameRegistry.addRecipe(new ItemStack(il.starconium_gem, 9), new Object[] { "X", 'X', bl.starconium_block});
        GameRegistry.addRecipe(new ItemStack(il.demonite_orb, 9), new Object[] { "X", 'X', bl.demonite_block});
        GameRegistry.addRecipe(new ItemStack(il.invisium_ingot, 9), new Object[] { "X", 'X', bl.invisium_block});
        GameRegistry.addRecipe(new ItemStack(il.ender_gem, 9), new Object[] { "X", 'X', bl.ender_block});
        GameRegistry.addRecipe(new ItemStack(il.experium_orb, 9), new Object[] { "X", 'X', bl.experium_block});
        GameRegistry.addRecipe(new ItemStack(il.ultra_gem, 9), new Object[] { "X", 'X', bl.ultra_block});
	}
}

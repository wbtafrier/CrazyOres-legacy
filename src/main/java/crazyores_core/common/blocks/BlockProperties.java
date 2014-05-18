package crazyores_core.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores_core.common.core.COData;
import crazyores_core.common.items.ItemList;
import crazyores_core.common.tabs.TabList;

public class BlockProperties 
{	
	public static ItemList il;
	public static void setProperties(BlockList bl, BlockNames bn)
	{
		/** Ores **/
		bl.meteorite_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setLightLevel(0.5F).setBlockTextureName(bn.METEORITE_ORE_PATH).setBlockName(bn.METEORITE_ORE_PATH);
		bl.copper_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockTextureName(bn.COPPER_ORE_PATH).setBlockName(bn.COPPER_ORE_PATH);
		bl.sapphire_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockTextureName(bn.SAPPHIRE_ORE_PATH).setBlockName(bn.SAPPHIRE_ORE_PATH);
		bl.adamite_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockTextureName(bn.ADAMITE_ORE_PATH).setBlockName(bn.ADAMITE_ORE_PATH);
		bl.ruby_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockTextureName(bn.RUBY_ORE_PATH).setBlockName(bn.RUBY_ORE_PATH);
		bl.fools_ruby_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockTextureName(bn.FOOLS_RUBY_ORE_PATH).setBlockName(bn.FOOLS_RUBY_ORE_PATH);
		bl.experium_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockTextureName(bn.EXPERIUM_ORE_PATH).setBlockName(bn.EXPERIUM_ORE_PATH);
		bl.zectium_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockTextureName(bn.ZECTIUM_ORE_PATH).setBlockName(bn.ZECTIUM_ORE_PATH);
		bl.tapazite_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockTextureName(bn.TAPAZITE_ORE_PATH).setBlockName(bn.TAPAZITE_ORE_PATH);
		bl.crystal_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockTextureName(bn.CRYSTAL_ORE_PATH).setBlockName(bn.CRYSTAL_ORE_PATH);
		bl.osmonium_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockTextureName(bn.OSMONIUM_ORE_PATH).setBlockName(bn.OSMONIUM_ORE_PATH);
		bl.starconium_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockTextureName(bn.STARCONIUM_ORE_PATH).setBlockName(bn.STARCONIUM_ORE_PATH);
		bl.demonite_stone = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockTextureName(bn.DEMONITE_STONE_PATH).setBlockName(bn.DEMONITE_STONE_PATH);
		bl.invisium_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockTextureName(bn.INVISIUM_ORE_PATH).setBlockName(bn.INVISIUM_ORE_PATH);
		bl.darkstone = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockTextureName(bn.DARKSTONE_PATH).setBlockName(bn.DARKSTONE_PATH);
		bl.luminite_ore = new Ore().setHardness(3F).setResistance(5F).setLightLevel(0.5F).setStepSound(Block.soundTypeStone).setBlockTextureName(bn.LUMINITE_ORE_PATH).setBlockName(bn.LUMINITE_ORE_PATH);
		bl.ender_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockTextureName(bn.ENDER_ORE_PATH).setBlockName(bn.ENDER_ORE_PATH);
		bl.ultra_ore = new Ore().setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeStone).setBlockTextureName(bn.ULTRA_ORE_PATH).setBlockName(bn.ULTRA_ORE_PATH);
		
		/** Storage Blocks **/
		bl.copper_block = new BasicBlock(Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockTextureName(bn.COPPER_BLOCK_PATH).setBlockName(bn.COPPER_BLOCK_PATH);
		bl.sapphire_block = new BasicBlock(Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockTextureName(bn.SAPPHIRE_BLOCK_PATH).setBlockName(bn.SAPPHIRE_BLOCK_PATH);
		bl.adamite_block = new BasicBlock(Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockTextureName(bn.ADAMITE_BLOCK_PATH).setBlockName(bn.ADAMITE_BLOCK_PATH);
		bl.meteorite_block = new BasicBlock(Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockTextureName(bn.METEORITE_BLOCK_PATH).setBlockName(bn.METEORITE_BLOCK_PATH);
		bl.glowing_meteorite_block = new BasicBlock(Material.iron).setHardness(3F).setResistance(10F).setLightLevel(1.0F).setStepSound(Block.soundTypeMetal).setBlockTextureName(bn.GLOWING_METEORITE_BLOCK_PATH).setBlockName(bn.GLOWING_METEORITE_BLOCK_PATH);
		bl.ruby_block = new BasicBlock(Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockTextureName(bn.RUBY_BLOCK_PATH).setBlockName(bn.RUBY_BLOCK_PATH);
		bl.fools_ruby_block = new BasicBlock(Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockTextureName(bn.FOOLS_RUBY_BLOCK_PATH).setBlockName(bn.FOOLS_RUBY_BLOCK_PATH);
		bl.zectium_block = new BasicBlock(Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockTextureName(bn.ZECTIUM_BLOCK_PATH).setBlockName(bn.ZECTIUM_BLOCK_PATH);
		bl.tapazite_block = new BasicBlock(Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockTextureName(bn.TAPAZITE_BLOCK_PATH).setBlockName(bn.TAPAZITE_BLOCK_PATH);
		bl.crystal_block = new BasicBlock(Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockTextureName(bn.CRYSTAL_BLOCK_PATH).setBlockName(bn.CRYSTAL_BLOCK_PATH);
		bl.osmonium_block = new BasicBlock(Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockTextureName(bn.OSMONIUM_BLOCK_PATH).setBlockName(bn.OSMONIUM_BLOCK_PATH);
		bl.starconium_block = new BasicBlock(Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockTextureName(bn.STARCONIUM_BLOCK_PATH).setBlockName(bn.STARCONIUM_BLOCK_PATH);
		bl.demonite_block = new BasicBlock(Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockTextureName(bn.DEMONITE_BLOCK_PATH).setBlockName(bn.DEMONITE_BLOCK_PATH);
		bl.refined_demonite_block = new BasicBlock(Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockTextureName(bn.DEMONITE_FURNACE_TOP_PATH).setBlockName(bn.REFINED_DEMONITE_BLOCK_PATH);
		bl.invisium_block = new BasicBlock(Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockTextureName(bn.INVISIUM_BLOCK_PATH).setBlockName(bn.INVISIUM_BLOCK_PATH);
		bl.ender_block = new BasicBlock(Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockTextureName(bn.ENDER_BLOCK_PATH).setBlockName(bn.ENDER_BLOCK_PATH);
		bl.experium_block = new BasicBlock(Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockTextureName(bn.EXPERIUM_BLOCK_PATH).setBlockName(bn.EXPERIUM_BLOCK_PATH);
		bl.ultra_block = new BasicBlock(Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockTextureName(bn.ULTRA_BLOCK_PATH).setBlockName(bn.ULTRA_BLOCK_PATH);
		
		/** Golem Heads **/
		bl.copper_golem_head = new GolemHead(Material.iron, il.copper_ingot, bl.copper_block).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockName(bn.COPPER_GOLEM_HEAD_PATH);
		bl.sapphire_golem_head = new GolemHead(Material.iron, il.sapphire_gem, bl.sapphire_block).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockName(bn.SAPPHIRE_GOLEM_HEAD_PATH);
		bl.adamite_golem_head = new GolemHead(Material.iron, il.adamite_shard, bl.adamite_block).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockName(bn.ADAMITE_GOLEM_HEAD_PATH);
		bl.ruby_golem_head = new GolemHead(Material.iron, il.ruby_gem, bl.ruby_block).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockName(bn.RUBY_GOLEM_HEAD_PATH);
		bl.fools_ruby_golem_head = new GolemHead(Material.iron, il.fools_ruby_gem, bl.fools_ruby_block).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockName(bn.FOOLS_RUBY_GOLEM_HEAD_PATH);
		bl.zectium_golem_head = new GolemHead(Material.iron, il.zectium_ingot, bl.zectium_block).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockName(bn.ZECTIUM_GOLEM_HEAD_PATH);
		bl.tapazite_golem_head = new GolemHead(Material.iron, il.tapazite_gem, bl.tapazite_block).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockName(bn.TAPAZITE_GOLEM_HEAD_PATH);
		bl.crystal_golem_head = new GolemHead(Material.iron, il.crystal_shard, bl.crystal_block).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockName(bn.CRYSTAL_GOLEM_HEAD_PATH);
		bl.osmonium_golem_head = new GolemHead(Material.iron, il.osmonium_ingot, bl.osmonium_block).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockName(bn.OSMONIUM_GOLEM_HEAD_PATH);
		bl.starconium_golem_head = new GolemHead(Material.iron, il.starconium_gem, bl.starconium_block).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockName(bn.STARCONIUM_GOLEM_HEAD_PATH);
		bl.demonite_golem_head = new GolemHead(Material.iron, il.demonite_orb, bl.demonite_block).setHardness(3F).setResistance(10F).setStepSound(Block.soundTypeMetal).setBlockName(bn.DEMONITE_GOLEM_HEAD_PATH);

		/** Demonite Furnace **/
		bl.lit_demonite_furnace = new BlockDemoniteFurnace(true).setHardness(6F).setResistance(6F).setStepSound(Block.soundTypeMetal).setLightLevel(1F).setBlockName(bn.LIT_DEMONITE_FURNACE_PATH);
		bl.demonite_furnace = new BlockDemoniteFurnace(false).setHardness(6F).setResistance(6F).setStepSound(Block.soundTypeMetal).setBlockName(bn.DEMONITE_FURNACE_PATH).setCreativeTab(TabList.COBlocks);
	}

	public static void registerBlocks(BlockList bl, BlockNames bn)
	{
		/** Ores **/
		GameRegistry.registerBlock(bl.meteorite_ore, bn.METEORITE_ORE);
		GameRegistry.registerBlock(bl.copper_ore, bn.COPPER_ORE);
		GameRegistry.registerBlock(bl.sapphire_ore, bn.SAPPHIRE_ORE);
		GameRegistry.registerBlock(bl.adamite_ore, bn.ADAMITE_ORE);
		GameRegistry.registerBlock(bl.ruby_ore, bn.RUBY_ORE);
		GameRegistry.registerBlock(bl.fools_ruby_ore, bn.FOOLS_RUBY_ORE);
		GameRegistry.registerBlock(bl.zectium_ore, bn.ZECTIUM_ORE);
		GameRegistry.registerBlock(bl.tapazite_ore, bn.TAPAZITE_ORE);
		GameRegistry.registerBlock(bl.crystal_ore, bn.CRYSTAL_ORE);
		GameRegistry.registerBlock(bl.osmonium_ore, bn.OSMONIUM_ORE);
		GameRegistry.registerBlock(bl.starconium_ore, bn.STARCONIUM_ORE);
		GameRegistry.registerBlock(bl.experium_ore, bn.EXPERIUM_ORE);
		GameRegistry.registerBlock(bl.demonite_stone, bn.DEMONITE_STONE);
		GameRegistry.registerBlock(bl.invisium_ore, bn.INVISIUM_ORE);
		GameRegistry.registerBlock(bl.darkstone, bn.DARKSTONE);
		GameRegistry.registerBlock(bl.luminite_ore, bn.LUMINITE_ORE);
		GameRegistry.registerBlock(bl.ender_ore, bn.ENDER_ORE);
		GameRegistry.registerBlock(bl.ultra_ore, bn.ULTRA_ORE);
		
		/** Storage _blocks **/
		GameRegistry.registerBlock(bl.copper_block, bn.COPPER_BLOCK);
		GameRegistry.registerBlock(bl.sapphire_block, bn.SAPPHIRE_BLOCK);
		GameRegistry.registerBlock(bl.adamite_block, bn.ADAMITE_BLOCK);
		GameRegistry.registerBlock(bl.meteorite_block, bn.METEORITE_BLOCK);
		GameRegistry.registerBlock(bl.glowing_meteorite_block, bn.GLOWING_METEORITE_BLOCK);
		GameRegistry.registerBlock(bl.ruby_block, bn.RUBY_BLOCK);
		GameRegistry.registerBlock(bl.fools_ruby_block, bn.FOOLS_RUBY_BLOCK);
		GameRegistry.registerBlock(bl.zectium_block, bn.ZECTIUM_BLOCK);
		GameRegistry.registerBlock(bl.tapazite_block, bn.TAPAZITE_BLOCK);
		GameRegistry.registerBlock(bl.crystal_block, bn.CRYSTAL_BLOCK);
		GameRegistry.registerBlock(bl.osmonium_block, bn.OSMONIUM_BLOCK);
		GameRegistry.registerBlock(bl.starconium_block, bn.STARCONIUM_BLOCK);
		GameRegistry.registerBlock(bl.demonite_block, bn.DEMONITE_BLOCK);
		GameRegistry.registerBlock(bl.refined_demonite_block, bn.REFINED_DEMONITE_BLOCK);
		GameRegistry.registerBlock(bl.invisium_block, bn.INVISIUM_BLOCK);
		GameRegistry.registerBlock(bl.ender_block, bn.ENDER_BLOCK);
		GameRegistry.registerBlock(bl.experium_block, bn.EXPERIUM_BLOCK);
		GameRegistry.registerBlock(bl.ultra_block, bn.ULTRA_BLOCK);
		
		/** Golem Heads **/
		GameRegistry.registerBlock(bl.copper_golem_head, bn.COPPER_GOLEM_HEAD);
		GameRegistry.registerBlock(bl.sapphire_golem_head, bn.SAPPHIRE_GOLEM_HEAD);
		GameRegistry.registerBlock(bl.adamite_golem_head, bn.ADAMITE_GOLEM_HEAD);
		GameRegistry.registerBlock(bl.ruby_golem_head, bn.RUBY_GOLEM_HEAD);
		GameRegistry.registerBlock(bl.fools_ruby_golem_head, bn.FOOLS_RUBY_GOLEM_HEAD);
		GameRegistry.registerBlock(bl.zectium_golem_head, bn.ZECTIUM_GOLEM_HEAD);
		GameRegistry.registerBlock(bl.tapazite_golem_head, bn.TAPAZITE_GOLEM_HEAD);
		GameRegistry.registerBlock(bl.crystal_golem_head, bn.CRYSTAL_GOLEM_HEAD);
		GameRegistry.registerBlock(bl.osmonium_golem_head, bn.OSMONIUM_GOLEM_HEAD);
		GameRegistry.registerBlock(bl.starconium_golem_head, bn.STARCONIUM_GOLEM_HEAD);
		GameRegistry.registerBlock(bl.demonite_golem_head, bn.DEMONITE_GOLEM_HEAD);

		/** Demonite Furnace **/
		GameRegistry.registerBlock(bl.demonite_furnace, bn.DEMONITE_FURNACE);
		GameRegistry.registerBlock(bl.lit_demonite_furnace, bn.LIT_DEMONITE_FURNACE);
	}
}
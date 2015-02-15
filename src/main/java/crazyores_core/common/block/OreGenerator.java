package crazyores_core.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import crazyores_core.common.config.CoreSettings;

public class OreGenerator implements IWorldGenerator 
{ 
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGeneratorandom,  IChunkProvider chunkProvider)
	{
		switch (world.provider.getDimensionId())
		{
		case -1: generateNether(world, random, chunkX << 4, chunkZ << 4);
		case 0: generateSurface(world, random, chunkX << 4, chunkZ << 4);
		case 1: generateEnd(world, random, chunkX << 4, chunkZ << 4);
		}
	}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ)
	{
		if (CoreSettings.copperGen)
		{
			for (int i = 0; i < 30; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(100);
				int randPosZ = chunkZ + random.nextInt(16);  
				(new WorldGenMinable(BlockList.copper_ore.getDefaultState(), 8)).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
			}
		}
		if (CoreSettings.sapphireGen) 
		{
			for(int i = 0; i < 16; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(45);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.sapphire_ore.getDefaultState(), 5)).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
			}	
		}		
		if (CoreSettings.adamiteGen) 
		{
			for(int i = 0; i < 14; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(45);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.adamite_ore.getDefaultState(), 4)).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
			}
		}
		if (CoreSettings.meteoriteGen) 
		{
			for(int i = 0; i < 10; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(50);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.meteorite_ore.getDefaultState(), 5)).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
			}
		}
		if (CoreSettings.rubyGen) 
		{
			for(int i = 0; i < 12; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(40);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.ruby_ore.getDefaultState(), 4)).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
			}	
		}
		if (CoreSettings.foolsRubyGen) 
		{
			for(int i = 0; i < 18; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(45);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.fools_ruby_ore.getDefaultState(), 4)).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
			}
		}
//		if (CoreSettings.goldGen) 
//		{
//			for(int i = 0; i < 7; i++)
//			{
//				int randPosX = chunkX + random.nextInt(16);
//				int randPosY = random.nextInt(32);
//				int randPosZ = chunkZ + random.nextInt(16);
//				(new WorldGenMinable(Block.oreGold.getDefaultState(), 8)).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
//			}	
//		}
//		if (CoreSettings.diamondGen) 
//		{
//			for(int i = 0; i < 7; i++)
//			{
//				int randPosX = chunkX + random.nextInt(16);
//				int randPosY = random.nextInt(30);
//				int randPosZ = chunkZ + random.nextInt(16);
//				(new WorldGenMinable(Block.oreDiamond.getDefaultState(), 7)).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
//			}	
//		}
		if (CoreSettings.zectiumGen) 
		{
			for(int i = 0; i < 5; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(24);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.zectium_ore.getDefaultState(), 5)).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
			}	
		}
		if (CoreSettings.experiumGen) 
		{
			for(int i = 0; i < 4; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(23);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.experium_ore.getDefaultState(), 3)).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
			}	
		}
		if (CoreSettings.tapaziteGen) 
		{
			for(int i = 0; i < 4; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(21);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.tapazite_ore.getDefaultState(), 4)).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
			}	
		}
		if (CoreSettings.osmoniumGen) 
		{
			for(int i = 0; i < 2; i++)
			{
				int randPosX = chunkX + random.nextInt(16); 
				int randPosY = random.nextInt(15);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.osmonium_ore.getDefaultState(), 3)).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
			}
		}
		if (CoreSettings.starconiumGen)
		{
			for(int i = 0; i < 1; i++)
			{
				int randPosX = chunkX + random.nextInt(16); 
				int randPosY = random.nextInt(12);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.starconium_ore.getDefaultState(), 3)).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
			}
		}
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ)
	{
		if (CoreSettings.darkstoneGen) {
			for (int i = 0; i < 30; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(world.getHeight());
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.darkstone.getDefaultState(), 20, BlockHelper.forBlock(Blocks.netherrack))).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
			}
		}
		if (CoreSettings.demoniteGen) {
			for (int i = 0; i < 25; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(world.getHeight());
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.demonite_ore.getDefaultState(), 8, BlockHelper.forBlock(Blocks.netherrack))).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
			}
		}
//		if (CoreSettings.luminiteGen) {
//			for (int i = 0; i < 20; i++)
//			{
//				int randPosX = chunkX + random.nextInt(16);
//				int randPosY = random.nextInt(world.getHeight());
//				int randPosZ = chunkZ + random.nextInt(16);
//				(new WorldGenNether(BlockList.luminiteOre.getDefaultState(), 5)).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
//			}
//		}
		if (CoreSettings.invisiumGen) {
			for (int i = 0; i < 20; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(world.getHeight());
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.invisium_ore.getDefaultState(), 4, BlockHelper.forBlock(Blocks.netherrack))).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
			}
		}
	}
	
	public void generateEnd(World world, Random random, int chunkX, int chunkZ)
	{
		if (CoreSettings.enderGen) {
			for (int i = 0; i < 15; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(world.getHeight());
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.ender_ore.getDefaultState(), 6, BlockHelper.forBlock(Blocks.end_stone))).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
			}
		}
		
		if (CoreSettings.ultraGen) {
			for (int i = 0; i < 14; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(world.getHeight());
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.ultra_ore.getDefaultState(), 6, BlockHelper.forBlock(Blocks.end_stone))).generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
			}
		}
	}
}


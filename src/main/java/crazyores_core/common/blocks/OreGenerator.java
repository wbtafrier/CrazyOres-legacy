package crazyores_core.common.blocks;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import crazyores_core.common.core.COSettings;
import crazyores_core.common.core.CrazyOres;
import crazyores_core.common.misc.WorldGenEnd;
import crazyores_core.common.misc.WorldGenNether;

public class OreGenerator implements IWorldGenerator 
{
	public CrazyOres mod;

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGeneratorandom,  IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
		case -1: generateNether(world, random, chunkX << 4, chunkZ << 4);
		case 0: generateSurface(world, random, chunkX << 4, chunkZ << 4);
		case 1: generateEnd(world, random, chunkX << 4, chunkZ << 4);
		}
	}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ)
	{
		if (COSettings.copperGen)
		{
			for (int i = 0; i < 30; i++)
			{
				int Xcoord = chunkX + random.nextInt(16);
				int Ycoord = random.nextInt(100);
				int Zcoord = chunkZ + random.nextInt(16);  
				(new WorldGenMinable(BlockList.copper_ore, 8)).generate(world, random, Xcoord, Ycoord, Zcoord);
			}
		}
		if (COSettings.sapphireGen) 
		{
			for(int i = 0; i < 16; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(45);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.sapphire_ore, 5)).generate(world, random, randPosX,randPosY,randPosZ);
			}	
		}		
		if (COSettings.adamiteGen) 
		{
			for(int i = 0; i < 14; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(45);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.adamite_ore, 4)).generate(world, random, randPosX,randPosY,randPosZ);
			}
		}
		if (COSettings.meteoriteGen) 
		{
			for(int i = 0; i < 10; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(50);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.meteorite_ore, 5)).generate(world, random, randPosX,randPosY,randPosZ);
			}
		}
		if (COSettings.rubyGen) 
		{
			for(int i = 0; i < 12; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(40);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.ruby_ore, 4)).generate(world, random, randPosX,randPosY,randPosZ);
			}	
		}
		if (COSettings.foolsRubyGen) 
		{
			for(int i = 0; i < 18; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(45);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.fools_ruby_ore, 4)).generate(world, random, randPosX,randPosY,randPosZ);
			}
		}
		if (COSettings.goldGen) 
		{
			for(int i = 0; i < 7; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(32);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(Blocks.gold_ore, 8)).generate(world, random, randPosX,randPosY,randPosZ);
			}	
		}
		if (COSettings.diamondGen) 
		{
			for(int i = 0; i < 7; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(30);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(Blocks.diamond_ore, 7)).generate(world, random, randPosX,randPosY,randPosZ);
			}	
		}
		if (COSettings.zectiumGen) 
		{
			for(int i = 0; i < 5; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(24);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.zectium_ore, 5)).generate(world, random, randPosX,randPosY,randPosZ);
			}	
		}
		if (COSettings.experiumGen) 
		{
			for(int i = 0; i < 4; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(23);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.experium_ore, 3)).generate(world, random, randPosX,randPosY,randPosZ);
			}	
		}
		if (COSettings.tapaziteGen) 
		{
			for(int i = 0; i < 4; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(21);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.tapazite_ore, 4)).generate(world, random, randPosX,randPosY,randPosZ);
			}	
		}
		if (COSettings.crystalGen) 
		{
			for(int i = 0; i < 3; i++)
			{
				int randPosX = chunkX + random.nextInt(16); 
				int randPosY = random.nextInt(18);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.crystal_ore, 4)).generate(world, random, randPosX,randPosY,randPosZ);
			}
		}
		if (COSettings.osmoniumGen) 
		{
			for(int i = 0; i < 2; i++)
			{
				int randPosX = chunkX + random.nextInt(16); 
				int randPosY = random.nextInt(15);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.osmonium_ore, 3)).generate(world, random, randPosX,randPosY,randPosZ);
			}
		}
		if (COSettings.starconiumGen)
		{
			for(int i = 0; i < 1; i++)
			{
				int randPosX = chunkX + random.nextInt(16); 
				int randPosY = random.nextInt(12);
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenMinable(BlockList.starconium_ore, 3)).generate(world, random, randPosX,randPosY,randPosZ);
			}
		}
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ)
	{
		if (COSettings.darkStoneGen) {
			for (int i = 0; i < 30; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(world.getHeight());
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenNether(BlockList.darkstone, 20)).generate(world, random, randPosX, randPosY, randPosZ);
			}
		}
		if (COSettings.demoniteGen) {
			for (int i = 0; i < 25; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(world.getHeight());
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenNether(BlockList.demonite_stone, 8)).generate(world, random, randPosX, randPosY, randPosZ);
			}
		}
		if (COSettings.luminiteGen) {
			for (int i = 0; i < 20; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(world.getHeight());
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenNether(BlockList.luminite_ore, 5)).generate(world, random, randPosX, randPosY, randPosZ);
			}
		}
		if (COSettings.invisiumGen) {
			for (int i = 0; i < 20; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(world.getHeight());
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenNether(BlockList.invisium_ore, 4)).generate(world, random, randPosX, randPosY, randPosZ);
			}
		}
	}
	
	public void generateEnd(World world, Random random, int chunkX, int chunkZ)
	{
		if (COSettings.enderGen) {
			for (int i = 0; i < 15; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(world.getHeight());
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenEnd(BlockList.ender_ore, 6)).generate(world, random, randPosX, randPosY, randPosZ);
			}
		}
		
		if (COSettings.ultraGen) {
			for (int i = 0; i < 14; i++)
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosY = random.nextInt(world.getHeight());
				int randPosZ = chunkZ + random.nextInt(16);
				(new WorldGenEnd(BlockList.ultra_ore, 6)).generate(world, random, randPosX, randPosY, randPosZ);
			}
		}
	}
}

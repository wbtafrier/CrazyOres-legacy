package crazyores.packs.core.world.generate;

import java.util.Random;

import crazyores.packs.core.block.CoreBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class AdamiteDungeon extends CoreDungeon {

	private static final int DEFAULT_WIDTH = 16;
	
	public AdamiteDungeon(EnumDifficulty d) {
		super(EnumDungeonType.ADAMITE, d);
	}

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		
		if (!(world.getBiomeGenForCoords(x, z) != BiomeGenBase.deepOcean) || !(world.getBiomeGenForCoords(x, z) != BiomeGenBase.ocean)) {
			return debugFalse(world, x, y, z);
		}
		
		while (!world.getBlock(x, y, z).isAssociatedBlock(Blocks.water) || !world.getBlock(x, y, z).isAssociatedBlock(Blocks.flowing_water)) {
			y++;
			if (y > 30) return debugFalse(world, x, y, z);
		}
		
		System.out.println("SPAWNING ADAMITE DUNGEON");
		
		int xWidth = DEFAULT_WIDTH + rand.nextInt(10);
		int roomHeight = 8;
		int zWidth = DEFAULT_WIDTH + rand.nextInt(10);
		
		int rooms = rand.nextInt(5) + 2;
		for (int r = 0; r < rooms; r++) {
			addRoom(world, rand, x, y + (r * roomHeight), z, xWidth, zWidth);
		}
		
		return true;
	}
	
	private void addRoom(World world, Random rand, int x, int y, int z, int xWidth, int zWidth) {
		
		for (int xFloor = x; xFloor < x + xWidth; xFloor++) {
			for (int zFloor = z; zFloor < z + zWidth; zFloor++) {
				
				if (world.getBlock(xFloor, y, zFloor).isAssociatedBlock(Blocks.air)) {
					
					if ((xFloor < 2 || xFloor > x + xWidth - 2) && (zFloor < 2 || zFloor > z + zWidth - 2)) {
						world.setBlock(xFloor, y, zFloor, CoreBlocks.adamiteBrick);
					}
					else {
						world.setBlock(xFloor, y, zFloor, CoreBlocks.diagonalAdamiteBrick);
					}
				}
			}
		}
		
		for (int xWall = x; xWall < x + xWidth; xWall++) {
			for (int yPos = y; yPos < y; yPos++) {
				for (int zWall = z; zWall < z + zWidth; zWall++) {
					world.setBlock(xWall, yPos, zWall, Blocks.air);
					
					if ((xWall < 2 || xWall > x + xWidth - 2) && (zWall < 2 || zWall > z + zWidth - 2)) {
						setRandomBlock(world, rand, xWall, yPos, zWall, CoreBlocks.adamiteBrick, 0);
					}
				}
			}
		}
		
		for (int xCeiling = x; xCeiling < x + xWidth; xCeiling++) {
			for (int zCeiling = z; zCeiling < z + zWidth; zCeiling++) {
				
				if (world.getBlock(xCeiling, y, zCeiling).isAssociatedBlock(Blocks.air)) {
					world.setBlock(xCeiling, y, zCeiling, CoreBlocks.diagonalAdamiteBrick);
				}
			}
		}
	}
	
	private void setRandomBlock(World world, Random rand, int x, int y, int z, Block primaryBlock, int metadata) {
		if (rand.nextInt(2) == 0)
			world.setBlock(x, y, z, Blocks.air, 0, 2);
		else
			world.setBlock(x, y, z, primaryBlock, 0, 2);
	}
	
	private boolean debugFalse(World world, int x, int y, int z) {
		System.out.println("COULD NOT GENERATE IN BIOME: " + world.getBiomeGenForCoords(x, z) + " AT: (" + x + ", " + y + ", " + z + ")");
		return false;
	}
}

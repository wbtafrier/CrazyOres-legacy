package crazyores.manager.world.generate;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import crazyores.manager.pack.COPackManager;
import crazyores.packs.core.block.CoreBlocks;
import crazyores.packs.core.config.COCoreConfigSettings;

public class Generate implements IWorldGenerator {

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		this.generateCoreOres(world, rand, chunkX * 16, chunkZ * 16);
		
		if (Loader.isModLoaded(COPackManager.foodsPack.getPackID())) {
			//this.generateFoodsPackPlants(world, rand, chunkX, chunkZ);
		}
	}
	
	public void generateCoreOres(World world, Random rand, int x, int z) {
		
		switch(world.provider.dimensionId) {
		case -1: generateCoreNetherOres(world, rand, x, z); break;
		case 0: generateCoreSurfaceOres(world, rand, x, z); break;
		case 1: generateCoreEndOres(world, rand, x, z); break;
		}
	}
	
	private void generateCoreNetherOres(World world, Random rand, int x, int z) {
		if (COCoreConfigSettings.generateDemoniteOre) {
			generateOre(CoreBlocks.demoniteOre, Blocks.netherrack, world, rand, x, z, 8, 20, 0, 255);
		}
		
		if (COCoreConfigSettings.generateInvisiumOre) {
			generateOre(CoreBlocks.invisiumOre, Blocks.netherrack, world, rand, x, z, 8, 18, 0, 255);
		}
		
		if (COCoreConfigSettings.generateDarkstoneOre) {
		}
		
		if (COCoreConfigSettings.generateLuminiteOre) {
			generateOre(CoreBlocks.luminiteOre, Blocks.netherrack, world, rand, x, z, 4, 15, 0, 255);
		}
	}
	
	private void generateCoreSurfaceOres(World world, Random rand, int x, int z) {
		
		if (COCoreConfigSettings.generateTapaziteOre) {
			generateTapazite(CoreBlocks.tapaziteStalagmite, world, rand, x, z);
			generateTapazite(CoreBlocks.tapaziteStalactite, world, rand, x, z);
		}
		if (COCoreConfigSettings.generateMeteoriteOre) {
			generateOre(CoreBlocks.meteoriteOre, Blocks.stone, world, rand, x, z, 6, 25, 70, 255);
		}
		
		if (COCoreConfigSettings.generateCopperOre)
			generateOre(CoreBlocks.copperOre, Blocks.stone, world, rand, x, z, 8, 20, 0, 85);
		
		if (COCoreConfigSettings.generateAdamiteOre) {
			generateWaterOre(CoreBlocks.adamiteOre, world, rand, x, z, 2, 20, 0, 200);
		}
		
		if (COCoreConfigSettings.generateSapphireOre)
			generateOre(CoreBlocks.sapphireOre, Blocks.stone, world, rand, x, z, 8, 20, 0, 50);
		
		if (COCoreConfigSettings.generateRubyOre) {
			generateOre(CoreBlocks.rubyOre, Blocks.stone, world, rand, x, z, 8, 18, 0, 40);
		}
		
		if (COCoreConfigSettings.generateFoolsRubyOre) {
			generateOre(CoreBlocks.foolsRubyOre, Blocks.stone, world, rand, x, z, 8, 20, 0, 50);
		}
		
		if (COCoreConfigSettings.generateZectiumOre) {
			generateOre(CoreBlocks.zectiumOre, Blocks.stone, world, rand, x, z, 6, 4, 0, 24);
		}
		
		if (COCoreConfigSettings.generateOsmoniumOre) {
			generateOre(CoreBlocks.osmoniumOre, Blocks.stone, world, rand, x, z, 4, 3, 0, 20);
		}
		
		if (COCoreConfigSettings.generateStarconiumOre) {
			generateOre(CoreBlocks.starconiumOre, Blocks.stone, world, rand, x, z, 4, 1, 0, 12);
		}
		
		if (COCoreConfigSettings.generateExperiumOre) {
			generateOre(CoreBlocks.osmoniumOre, Blocks.stone, world, rand, x, z, 1, 4, 0, 30);
		}
	}
	
	private void generateCoreEndOres(World world, Random rand, int x, int z) {
		
	}
	
	/**
	* Adds an Ore Spawn to Minecraft. Simply register all Ores to spawn with this method in your Generation method in your IWorldGeneration extending Class
	*
	* @param The Block to spawn
	* @param The World to spawn in
	* @param A Random object for retrieving random positions within the world to spawn the Block
	* @param An int for passing the X-Coordinate for the Generation method
	* @param An int for passing the Z-Coordinate for the Generation method
	* @param An int for setting the maximum X-Coordinate values for spawning on the X-Axis on a Per-Chunk basis
	* @param An int for setting the maximum Z-Coordinate values for spawning on the Z-Axis on a Per-Chunk basis
	* @param An int for setting the maximum size of a vein
	* @param An int for the Number of chances available for the Block to spawn per-chunk
	* @param An int for the minimum Y-Coordinate height at which this block may spawn
	* @param An int for the maximum Y-Coordinate height at which this block may spawn
	**/
	private void generateOre(Block block, Block spawnInBlock, World world, Random rand, int blockXPos, int blockZPos, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
		
		int diffMinMax = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + rand.nextInt(16);
			int posY = minY + rand.nextInt(diffMinMax);
			int posZ = blockZPos + rand.nextInt(16);
			(new WorldGenMinable(block, maxVeinSize, spawnInBlock)).generate(world, rand, posX, posY, posZ);
//			System.out.println("SPAWN: " + posX + ", " + posY + ", " + posZ);
		}
	}
	
	private void generateWaterOre(Block spawnedBlock, World world, Random rand, int blockXPos, int blockZPos, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
		
		int diffMinMax = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + rand.nextInt(16);
			int posY = minY + rand.nextInt(diffMinMax);
			int posZ = blockZPos + rand.nextInt(16);
			(new WorldGenNearWater(spawnedBlock, maxVeinSize)).generate(world, rand, posX, posY, posZ);
//			for (int j = 1; j <= distAwayFromWater; j++) {
//				for (Block b : canSpawnInBlock) {
//					if (world.getBlock(posX, posY, posZ).isAssociatedBlock(b)
//					  && (world.getBlock(posX + j, posY, posZ).isAssociatedBlock(Blocks.water)
//					  ||  world.getBlock(posX - j, posY, posZ).isAssociatedBlock(Blocks.water)
//					  ||  world.getBlock(posX, posY + j, posZ).isAssociatedBlock(Blocks.water)
//					  ||  world.getBlock(posX, posY, posZ + j).isAssociatedBlock(Blocks.water)
//					  ||  world.getBlock(posX, posY, posZ - j).isAssociatedBlock(Blocks.water))) {
//						(new WorldGenNearWater(spawnedBlock, maxVeinSize)).generate(world, rand, posX, posY, posZ);
//						System.out.println("SPAWNED!" + posX + ", " + posY + ", " + posZ);
//						break;
//					}
//				}
//			}
		}
	}
	
	private void generateTapazite(Block block, World world, Random rand, int blockXPos, int blockZPos) {
		
		for (int i = 0; i < 256; i++) {
			
			int posX = blockXPos + rand.nextInt(16);
			int posY = rand.nextInt(35);
			int posZ = blockZPos + rand.nextInt(16);
			
			if (rand.nextInt(3) == 0) {
				if (block.equals(CoreBlocks.tapaziteStalagmite) && world.getBlock(posX, posY, posZ).isAir(world, posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ).isAssociatedBlock(Blocks.stone) && world.getBlock(posX, posY + 1, posZ).isAir(world, posX, posY + 1, posZ)) {
					world.setBlock(posX, posY, posZ, CoreBlocks.tapaziteStalagmite);
//					System.out.println("SPAWNED: " + posX + " ," +  posY + " ," + posZ);
					break;
				}
				else if (block.equals(CoreBlocks.tapaziteStalactite) && world.getBlock(posX, posY, posZ).isAir(world, posX, posY, posZ) && world.getBlock(posX, posY + 1, posZ).isAssociatedBlock(Blocks.stone) && world.getBlock(posX, posY - 1, posZ).isAir(world, posX, posY - 1, posZ)) {
					world.setBlock(posX, posY, posZ, CoreBlocks.tapaziteStalactite);
//					System.out.println("SPAWNED: " + posX + " ," +  posY + " ," + posZ);
					break;
				}
			}
		}
	}
}
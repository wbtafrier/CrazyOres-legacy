package crazyores.manager.world.generate;

import java.util.Random;

import org.apache.logging.log4j.Level;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.util.CrazyOresLogger;
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
		
//		if (COCoreConfigSettings.generateTapaziteStalagmite) {
////			CrazyOresLogger.write(Level.INFO, "GENERATING STALAGMITE!");
//			generateTapazite(world, rand, chunkX, chunkZ, x, y, z, 0);
//		}
//		
//		if (COCoreConfigSettings.generateTapaziteStalactite) {
////			CrazyOresLogger.write(Level.INFO, "GENERATING STALACTITE!");
//			generateTapazite(world, rand, chunkX, chunkZ, x, y, z, 1);
//		}
//		
//		if (COCoreConfigSettings.generateMeteoriteOre) {
//			generateMeteorite(world, rand, chunkX, chunkZ, x, y, z);
//		}
	}
	
	private void generateCoreNetherOres(World world, Random rand, int x, int z) {}
	
	private void generateCoreSurfaceOres(World world, Random rand, int x, int z) {
		
		if (COCoreConfigSettings.generateTapaziteStalagmite)
			generateTapazite(CoreBlocks.tapaziteStalagmite, world, rand, x, z);
		
		if (COCoreConfigSettings.generateTapaziteStalactite)
			generateTapazite(CoreBlocks.tapaziteStalactite, world, rand, x, z);
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
	private void generateOre(Block block, World world, Random rand, int blockXPos, int blockZPos, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
		
		int diffMinMax = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + rand.nextInt(16);
			int posY = minY + rand.nextInt(diffMinMax);
			int posZ = blockZPos + rand.nextInt(16);
			(new WorldGenMinable(block, maxVeinSize)).generate(world, rand, posX, posY, posZ);
		}
	}
	
	private void generateTapazite(Block block, World world, Random rand, int blockXPos, int blockZPos) {
		
//		int diffMinMax = maxY - minY;
//		for (int x = 0; x < chancesToSpawn; x++) {
//			int posX = blockXPos + rand.nextInt(maxX);
//			int posY = minY + rand.nextInt(diffMinMax);
//			int posZ = blockZPos + rand.nextInt(maxZ);
//			
//			if (block.equals(CoreBlocks.tapaziteStalagmite) && world.getBlock(posX, posY, posZ).isAir(world, posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ).isAssociatedBlock(Blocks.stone) && world.getBlock(posX, posY + 1, posZ).isAir(world, posX, posY + 1, posZ)) {
//				CrazyOresLogger.write(Level.DEBUG, "SPAWNED AT: " + posX + ", " + posY + ", " + posZ);
//				world.setBlock(posX, posY, posZ, block);
//			}
//			
//			if (block.equals(CoreBlocks.tapaziteStalactite) && world.getBlock(posX, posY, posZ).isAir(world, posX, posY, posZ) && world.getBlock(posX, posY + 1, posZ).isAssociatedBlock(Blocks.stone) && world.getBlock(posX, posY - 1, posZ).isAir(world, posX, posY - 1, posZ))
//				world.setBlock(posX, posY, posZ, block);
//		}
		
		for (int i = 0; i < 256; i++) {
			
			int posX = blockXPos + rand.nextInt(16);
			int posY = rand.nextInt(35);
			int posZ = blockZPos + rand.nextInt(16);
			
			if (rand.nextInt(3) == 0) {
				if (block.equals(CoreBlocks.tapaziteStalagmite) && world.getBlock(posX, posY, posZ).isAir(world, posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ).isAssociatedBlock(Blocks.stone) && world.getBlock(posX, posY + 1, posZ).isAir(world, posX, posY + 1, posZ)) {
					world.setBlock(posX, posY, posZ, CoreBlocks.tapaziteStalagmite);
					System.out.println("SPAWNED: " + posX + " ," +  posY + " ," + posZ);
					break;
				}
				else if (block.equals(CoreBlocks.tapaziteStalactite) && world.getBlock(posX, posY, posZ).isAir(world, posX, posY, posZ) && world.getBlock(posX, posY + 1, posZ).isAssociatedBlock(Blocks.stone) && world.getBlock(posX, posY - 1, posZ).isAir(world, posX, posY - 1, posZ)) {
					world.setBlock(posX, posY, posZ, CoreBlocks.tapaziteStalactite);
					System.out.println("SPAWNED: " + posX + " ," +  posY + " ," + posZ);
					break;
				}
			}
		}
	}
	
//	private void generateTapazite(World world, Random rand, int x, int z, int type) {
//		
//		int y = 0;
//		for (int i = 0; i < 256; i++) {
//			
//			x = x + rand.nextInt(16);
//			y = rand.nextInt(35);
//			z = z + rand.nextInt(16);
//			
//			if (rand.nextInt(3) == 0) {
//				if (type == 0 && world.getBlock(x, y, z).isAir(world, x, y, z) && world.getBlock(x, y - 1, z).isAssociatedBlock(Blocks.stone) && world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z)) {
//					world.setBlock(x, y, z, CoreBlocks.tapaziteStalagmite);
//					System.out.println("HELLO");
//					break;
//				}
//				else if (type == 1 && world.getBlock(x, y, z).isAir(world, x, y, z) && world.getBlock(x, y + 1, z).isAssociatedBlock(Blocks.stone) && world.getBlock(x, y - 1, z).isAir(world, x, y - 1, z)) {
//					world.setBlock(x, y, z, CoreBlocks.tapaziteStalactite);
//					System.out.println("HELLO");
//					break;
//				}
//			}
//		}
//	}
	
	private void generateMeteorite(World world, Random rand, int chunkX, int chunkZ, int x, int y, int z) {
		
		for (int i = 0; i < 256; i++) {
			
			x = chunkX + rand.nextInt(16);
			y = rand.nextInt(21) + 40;
			z = chunkZ + rand.nextInt(16);
		}
	}
}

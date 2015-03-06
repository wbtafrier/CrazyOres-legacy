package crazyores.manager.world.generate;

import java.util.Random;

import org.apache.logging.log4j.Level;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.util.CrazyOresLogger;
import crazyores.packs.core.block.BlockTapaziteCrystal;
import crazyores.packs.core.block.CoreBlocks;
import crazyores.packs.core.config.COCoreConfigSettings;

public class Generate implements IWorldGenerator {

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		this.generateCoreOres(world, rand, chunkX << 4, chunkZ << 4);
		
		if (Loader.isModLoaded(COPackManager.foodsPack.getPackID())) {
			//this.generateFoodsPackPlants(world, rand, chunkX << 4, chunkZ << 4);
		}
	}
	
	public void generateCoreOres(World world, Random rand, int chunkX, int chunkZ) {
		
		int x = 0;
		int y = 0;
		int z = 0;
		
		if (COCoreConfigSettings.generateTapaziteStalagmite) {
			CrazyOresLogger.write(Level.INFO, "GENERATING STALAGMITE!");
			generateTapazite(world, rand, chunkX, chunkZ, x, y, z, 0);
		}
		
		if (COCoreConfigSettings.generateTapaziteStalactite) {
			CrazyOresLogger.write(Level.INFO, "GENERATING STALACTITE!");
			generateTapazite(world, rand, chunkX, chunkZ, x, y, z, 1);
		}
	}
	
	private void generateTapazite(World world, Random rand, int chunkX, int chunkZ, int x, int y, int z, int type) {
		
		for (int i = 0; i < 256; i++) {
			
			x = chunkX + rand.nextInt(16);
			y = rand.nextInt(35);
			z = chunkZ + rand.nextInt(16);
			
			if (rand.nextInt(3) == 0) {
				if (type == 0 && world.getBlock(x, y, z).isAir(world, x, y, z) && world.getBlock(x, y - 1, z).isAssociatedBlock(Blocks.stone) && world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z)) {
					world.setBlock(x, y, z, CoreBlocks.tapaziteStalagmite);
					break;
				}
				else if (type == 1 && world.getBlock(x, y, z).isAir(world, x, y, z) && world.getBlock(x, y + 1, z).isAssociatedBlock(Blocks.stone) && world.getBlock(x, y - 1, z).isAir(world, x, y - 1, z)) {
					world.setBlock(x, y, z, CoreBlocks.tapaziteStalactite);
					break;
				}
			}
		}
	}
}

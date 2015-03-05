package crazyores.manager.world.generate;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class GenerateOres implements IWorldGenerator {

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		this.generateSurface(world, rand, chunkX << 4, chunkZ << 4);
	}
	
	public void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
		
		
	}
}

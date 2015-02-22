package crazyores_core.common.world.biome.decorator;

import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.*;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable;
import crazyores_core.common.block.BlockList;

public class DreamStateBiomeDecorator extends BiomeDecorator {
	
	public static World currentWorld;
	public static Random randomGenerator;
	public static int xCoordInChunk;
	public static int zCoordInChunk;
	/** True if decorator should generate surface lava & water */
	public static boolean generateLakes;
	/** How meny trees per chunk, set in each biome class **/
	public static int numTreesPerChunk;
	
	/**Dimension Trees **/
//	public static WorldGenDreamStateSmallTree smallTree;
	
	public DreamStateBiomeDecorator() {

		// TREES
//		smallTree = new WorldGenForestTrees(true);

		// generates lakes and lava lakes in dimension.
		generateLakes = true;
	}
	
	protected void generateDecorationsForBiome(BiomeGenBase biome) {
		DreamStateBiomeDecoratorHelper.decorateBiome(biome);
	}
}

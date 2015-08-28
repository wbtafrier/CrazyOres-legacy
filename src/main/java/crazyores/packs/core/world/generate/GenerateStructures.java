package crazyores.packs.core.world.generate;

import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.DUNGEON;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraftforge.event.terraingen.TerrainGen;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores.manager.world.generate.Generate;

public class GenerateStructures {
	
	public static void generateSurfaceStructures(World world, Random rand, int xChunk, int zChunk) {
		CoreDungeon.generate(world, rand, xChunk, zChunk);
	}
}

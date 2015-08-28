package crazyores.packs.core.world.generate;

import java.util.Random;

import org.apache.logging.log4j.Level;

import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;
import crazyores.manager.util.CrazyOresLogger;
import crazyores.packs.core.block.CoreSpawner;

public abstract class CoreDungeon extends WorldGenerator {

	private EnumDungeonType type;
	protected EnumDifficulty difficulty;

	public CoreDungeon(EnumDungeonType t, EnumDifficulty d) {
		type = t;
		difficulty = d;
	}
	
	public static void generate(World world, Random rand, int xChunk, int zChunk) {
		
		if (!world.isRemote) {
		
			int x = xChunk + rand.nextInt(16);
			int y;
			int z = zChunk + rand.nextInt(16);
			
			if ((rand.nextInt(40) == 0) && ((world.getBiomeGenForCoords(x, z) == BiomeGenBase.deepOcean) || (world.getBiomeGenForCoords(x, z) == BiomeGenBase.ocean) || (world.getBiomeGenForCoords(x, z) == BiomeGenBase.frozenOcean))) {
				new AdamiteDungeon(world.difficultySetting).generate(world, rand, x, 0, z);
			}
			else if (rand.nextInt(1200) == 0) {
				y = rand.nextInt(61) + 60;
				new ZectiumDungeon(world.difficultySetting).generate(world, rand, x, y, z);
			}
		}
	}
	
	@Override
	public abstract boolean generate(World world, Random rand, int x, int y, int z);
	
	
	public EnumDungeonType getDungeonType() {
		return type;
	}
	
	protected void spawnMobs(World world, int x, int y, int z, Random rand, CoreSpawner spawnerType) {
		world.setBlock(x, y, z, spawnerType, 0, 2);
	}
}

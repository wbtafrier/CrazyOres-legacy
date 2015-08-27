package crazyores.packs.core.world.generate;

import java.util.Random;

import org.apache.logging.log4j.Level;

import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
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
		
			int x = xChunk * rand.nextInt(16) + 8;
			int y = rand.nextInt(50) + 80;
			int z = zChunk * rand.nextInt(16) + 8;
			
			EnumDungeonType t = EnumDungeonType.values()[rand.nextInt(EnumDungeonType.values().length)];
			int genStructure = rand.nextInt(100);
			
	//		switch (t) {
	//		default: {
			if (genStructure == 0) {
				new ZectiumDungeon(world.difficultySetting).generate(world, rand, x, y, z);
	//			}
	//		}
	//		case TAPAZITE:
	//		case ADAMITE:
	//		case COPPER:
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
//        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(x, y, z);
//
//        if (tileentitymobspawner != null) {
//            tileentitymobspawner.func_145881_a().setEntityName(spawnerType.getEntityName());
//        }
//        else {
//            CrazyOresLogger.write(Level.WARN, "Failed to fetch mob spawner entity at (" + x + ", " + y + ", " + z + ")");
//        }
	}
}

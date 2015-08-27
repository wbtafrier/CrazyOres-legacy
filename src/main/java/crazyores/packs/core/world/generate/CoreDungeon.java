package crazyores.packs.core.world.generate;

import java.util.Random;

import org.apache.logging.log4j.Level;

import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
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
			
			EnumDungeonType t = EnumDungeonType.values()[rand.nextInt(EnumDungeonType.values().length)];
			t = EnumDungeonType.ADAMITE;
			
			if (t.equals(EnumDungeonType.ZECTIUM)) {
				int r = rand.nextInt(100);
				System.out.println(r);
				if (r == 0) {
					y = rand.nextInt(70) + 30;
					new ZectiumDungeon(world.difficultySetting).generate(world, rand, x, y, z);
				}
			}
			else if (t.equals(EnumDungeonType.ADAMITE)) {
				
				if (rand.nextInt(10) == 0) {
					new AdamiteDungeon(world.difficultySetting).generate(world, rand, x, 0, z);
				}
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

package crazyores.packs.core.world.generate;

import static net.minecraftforge.common.ChestGenHooks.DUNGEON_CHEST;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;
import crazyores.manager.pack.data.CrazyOresData;
import crazyores.packs.core.block.CoreBlocks;
import crazyores.packs.core.block.CoreSpawner;
import crazyores.packs.core.entity.mob.EntityZectiumProtector;

public class ZectiumDungeon extends CoreDungeon {

	private static final int DEFAULT_WIDTH = 11;
	private static final int DEFAULT_HEIGHT = 7;
	
	public ZectiumDungeon(EnumDifficulty d) {
		super(EnumDungeonType.ZECTIUM, d);
	}

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		
		if (!world.getBlock(x, y, z).isAssociatedBlock(Blocks.air)) {
			System.out.println("COULD NOT GENERATE AT: " + x + " " + y + " " + z);
			return false;
		}
		
		System.out.println("GENERATING: " + x + " " + y + " " + z);
		
		for (int xChunk = 0; xChunk < DEFAULT_WIDTH; xChunk++) {
			for (int yChunk = 0; yChunk < DEFAULT_HEIGHT; yChunk++) {
				for (int zChunk = 0; zChunk < DEFAULT_WIDTH; zChunk++) {

					if (xChunk == 0 && yChunk == 0 && zChunk == 0) {
						world.setBlock(x, y, z, CoreBlocks.diagonalReinforcedBrick, 0, 2);
					}
					else if (yChunk == 0) {
						setBlock(world, rand, x + xChunk, y + yChunk, z + zChunk, CoreBlocks.diagonalReinforcedBrick, 0);
					}
					else if (zChunk == 0) {
						setBlock(world, rand, x + xChunk, y + yChunk, z + zChunk, CoreBlocks.reinforcedBrick, 0);
					}
					else if (zChunk == DEFAULT_WIDTH - 1) {
						setBlock(world, rand, x + xChunk, y + yChunk, z + zChunk, CoreBlocks.reinforcedBrick, 0);
					}
					else if (xChunk == 0) {
						setBlock(world, rand, x + xChunk, y + yChunk, z + zChunk, CoreBlocks.reinforcedBrick, 0);
					}
					else if (xChunk == DEFAULT_WIDTH - 1) {
						setBlock(world, rand, x + xChunk, y + yChunk, z + zChunk, CoreBlocks.reinforcedBrick, 0);
					}
					else if (yChunk == DEFAULT_HEIGHT - 1) {
						setBlock(world, rand, x + xChunk, y + yChunk, z + zChunk, CoreBlocks.reinforcedBrick, 0);
					}
				}
			}
		}
		spawnChests(world, x, y, z, rand);
		spawnMobs(world, x + (DEFAULT_WIDTH / 2), y + 1, z + (DEFAULT_WIDTH / 2), rand, (CoreSpawner)CoreBlocks.zectiumProtectorSpawner);
		return true;
	}
	
	private void setBlock(World world, Random rand, int x, int y, int z, Block primaryBlock, int metadata) {
		if (rand.nextInt(3) == 0)
			world.setBlock(x, y, z, Blocks.air, 0, 2);
		else if (rand.nextInt(3) == 0)
			world.setBlock(x, y, z, Blocks.mossy_cobblestone, metadata, 2);
		else
			world.setBlock(x, y, z, primaryBlock, 0, 2);
	}
	
	private void spawnChests(World world, int x, int y, int z, Random rand) {
		
		int chestCounter = 0;
		while (chestCounter < 2) {
			
			int xPos = rand.nextInt(DEFAULT_WIDTH - 1) + 1;
			int zPos = rand.nextInt(DEFAULT_WIDTH - 1) + 1;
			
			if (world.getBlock(xPos + x, y, zPos + z).getMaterial().isSolid() && rand.nextInt(4) == 0) {
				chestCounter++;
				
				world.setBlock(xPos + x, y + 1, zPos + z, Blocks.chest, 0, 2);
				TileEntityChest tileEntityChest = (TileEntityChest)world.getTileEntity(xPos + x, y + 1, zPos + z);
			
				if (tileEntityChest != null) {
					 WeightedRandomChestContent.generateChestContents(rand, ChestGenHooks.getItems(CoreLootHandler.ZECTIUM_DUNGEON, rand), tileEntityChest, ChestGenHooks.getCount(CoreLootHandler.ZECTIUM_DUNGEON, rand));
				}
			}
		}
	}
}

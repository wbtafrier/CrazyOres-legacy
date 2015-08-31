package crazyores.packs.core.world.generate;

import java.util.Random;

import crazyores.packs.core.block.CoreBlocks;
import crazyores.packs.core.block.CoreSpawner;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.ChestGenHooks;

public class AdamiteDungeon extends CoreDungeon {

	private static final int DEFAULT_WIDTH = 12;
	
	public AdamiteDungeon(EnumDifficulty d) {
		super(EnumDungeonType.ADAMITE, d);
	}

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		
		if ((world.getBiomeGenForCoords(x, z) != BiomeGenBase.deepOcean) && (world.getBiomeGenForCoords(x, z) != BiomeGenBase.ocean) && (world.getBiomeGenForCoords(x, z) != BiomeGenBase.frozenOcean)) {
			return debugFalse(world, x, y, z);
		}
		
		if (world.getBlock(x, y, z).isAssociatedBlock(CoreBlocks.adamiteBrick)) return debugFalse(world, x, y, z);
		
		while (!world.getBlock(x, y, z).isAssociatedBlock(Blocks.water) && !world.getBlock(x, y, z).isAssociatedBlock(Blocks.flowing_water)) {
			y++;
			
			if (y > 50) return debugFalse(world, x, y, z);
		}
		
		int xWidth = DEFAULT_WIDTH + rand.nextInt(10);
		int roomHeight = 8;
		int zWidth = DEFAULT_WIDTH + rand.nextInt(10);
		
		if (!isGoodAreaToSpawn(world, x, y, z, xWidth, zWidth)) return debugFalse(world, x, y, z);
//		System.out.println("SPAWNING ADAMITE DUNGEON AT: " + x + " " + y + " " + z);
		
		fillGround(world, rand, x, y, z, xWidth, zWidth);
		
//		int rooms = rand.nextInt(5) + 2;
//		for (int r = 0; r < rooms; r++) {
//			if ((world.getBlock(x, y + ((r + 1) * roomHeight) + 5, z).isAssociatedBlock(Blocks.water) || world.getBlock(x, y + ((r + 1) * roomHeight) + 5, z).isAssociatedBlock(Blocks.flowing_water)) && (world.getBlock(x, y + (r * roomHeight) + 1, z).isAssociatedBlock(Blocks.water) || world.getBlock(x, y + (r * roomHeight) + 1, z).isAssociatedBlock(Blocks.flowing_water))) {
//				addRoom(world, rand, x, y + (r * roomHeight) + 1, z, xWidth, zWidth, roomHeight);
//			}
//		}
		
		return true;
	}
	
	private void fillGround(World world, Random rand, int x, int y, int z, int xWidth, int zWidth) {
		
		for (int xPos = 0; xPos < xWidth; xPos++) {
			for (int zPos = 0; zPos < zWidth; zPos++) {
				
				int yPos = y;
//				int lineCounter = 0;
				while (!world.getBlock(xPos + x, yPos, zPos + z).getMaterial().isSolid()) {
					
//					if (lineCounter % 5 == 0) {
//						world.setBlock(xPos + x, yPos, zPos + z, lineCounter > 0 ? CoreBlocks.diagonalAdamiteBrick : CoreBlocks.adamiteBrick);
//					}
//					else {
////						if ((xPos == -1 && zPos == -1) || (xPos == -1 && zPos == zWidth) || (xPos == xWidth && zPos == -1) || (xPos == xWidth && zPos == zWidth)) {
//							setRandomBlock(world, rand, xPos + x, yPos, zPos + z, CoreBlocks.adamiteBrick, 0, 3);
////							world.setBlock(xPos + x, yPos, zPos + z, CoreBlocks.adamiteBrick);
////						}
////						else {
////							world.setBlock(xPos + x, yPos, zPos + z, rand.nextInt(2) == 0 ? Blocks.mossy_cobblestone : Blocks.cobblestone);
////						}
//					}
					yPos--;
//					lineCounter++;
				}
				for (int i = 1; i <= 2; i++)
					setRandomBlock(world, rand, xPos + x, yPos + i, zPos + z, CoreBlocks.adamiteBrick, 0, 2);
			}
		}
		
		int spawnerCounter = world.difficultySetting.ordinal() + (rand.nextInt(2) + 1);
		int chestCounter = rand.nextInt(3) + 2;
		while (spawnerCounter > 0 || chestCounter > 0) {
			for (int xPos = 0; xPos < xWidth; xPos++) {
				for (int zPos = 0; zPos < zWidth; zPos++) {
					
					int yPos = y;
					while (!world.getBlock(xPos + x, yPos, zPos + z).getMaterial().isSolid()) {
						yPos--;
					}
					
					for (int xCheck = -1; xCheck < 2; xCheck++) {
						for (int yCheck = -1; yCheck < 2; yCheck++) {
							for (int zCheck = -1; zCheck < 2; zCheck++) {
								if (world.getBlock(xCheck + x + xPos, yCheck + yPos + 1, zCheck + z + zPos).isAssociatedBlock(CoreBlocks.adamiteSharkSpawner) ||
										world.getBlock(xCheck + x + xPos, yCheck + yPos + 1, zCheck + z + zPos).isAssociatedBlock(CoreBlocks.greatWhiteSharkSpawner) ||
										world.getBlock(xCheck + x + xPos, yCheck + yPos + 1, zCheck + z + zPos).isAssociatedBlock(Blocks.chest)) {
									continue;
								}
							}
						}
					}
					
					if (spawnerCounter > 0 && xPos == rand.nextInt(xWidth) && zPos == rand.nextInt(zWidth)) {
						
						spawnMobs(world, xPos + x, yPos + 1, zPos + z, rand,  rand.nextInt(3) == 0 ? (CoreSpawner)CoreBlocks.greatWhiteSharkSpawner : (CoreSpawner)CoreBlocks.adamiteSharkSpawner);
						spawnerCounter--;
					}
					
					if (chestCounter > 0 && xPos == rand.nextInt(xWidth) && zPos == rand.nextInt(zWidth)) {
						spawnChest(world, x + xPos, yPos + 1, z + zPos, rand);
//						System.out.println("FUCK THIS: " + (x + xPos) + " " + (yPos + 1) + " " + (z + zPos));
						chestCounter--;
					}
				}
			}
		}
	}
	
//	private void addRoom(World world, Random rand, int x, int y, int z, int xWidth, int zWidth, int yHeight) {
//		
//		for (int xPos = 0; xPos < xWidth; xPos++) {
//			for (int yPos = 0; yPos < yHeight; yPos++) {
//				for (int zPos = 0; zPos < zWidth; zPos++) {
//					
//					if ((xPos < 1 || xPos == xWidth - 1) || (zPos < 1 || zPos == zWidth - 1) || (yPos < 1 || yPos == yHeight - 1)) {
//						setRandomBlock(world, rand, xPos + x, yPos + y, zPos + z, CoreBlocks.adamiteBrick, 0, 2);
////						world.setBlock(xPos + x, yPos + y, zPos + z, CoreBlocks.adamiteBrick);
//					}
//					else {
//						world.setBlock(xPos + x, yPos + y, zPos + z, Blocks.flowing_water);
//					}
//				}
//			}
//		}
//	}
	
	private void setRandomSolidBlock(World world, Random rand, int x, int y, int z, Block primaryBlock, int metadata) {
		world.setBlock(x, y, z, rand.nextInt(3) == 0 ? Blocks.mossy_cobblestone : primaryBlock);
	}
	
	private void setRandomBlock(World world, Random rand, int x, int y, int z, Block primaryBlock, int metadata, int randomWater) {
		if (rand.nextInt(randomWater) == 0 || rand.nextInt(randomWater) == 0 || rand.nextInt(randomWater) == 0)
			world.setBlock(x, y, z, Blocks.flowing_water, 0, 2);
		else if (rand.nextInt(4) == 0)
			world.setBlock(x, y, z, Blocks.mossy_cobblestone, 0, 2);
		else
			world.setBlock(x, y, z, primaryBlock, 0, 2);
	}
	
	private boolean isGoodAreaToSpawn(World world, int x, int y, int z, int xWidth, int zWidth) {
		
		for (int xPos = 0; xPos < xWidth; xPos++) {
			for (int zPos = 0; zPos < zWidth; zPos++) {
				if (world.getBlock(xPos + x, y, zPos + z).getMaterial().isSolid())
					return false;
			}
		}
//		System.out.println("ADDING ADAMITE BRICK!");
		
		world.setBlock(x, y, z, CoreBlocks.adamiteBrick);
		return true;
	}
	
	private void spawnChest(World world, int x, int y, int z, Random rand) {
		
		world.setBlock(x, y, z, Blocks.chest, 0, 2);
		TileEntityChest tileEntityChest = (TileEntityChest)world.getTileEntity(x, y, z);
	
		if (tileEntityChest != null) {
			 WeightedRandomChestContent.generateChestContents(rand, ChestGenHooks.getItems(CoreLootHandler.ADAMITE_DUNGEON, rand), tileEntityChest, ChestGenHooks.getCount(CoreLootHandler.ADAMITE_DUNGEON, rand));
		}
	}
	
	private boolean debugFalse(World world, int x, int y, int z) {
//		System.out.println("COULD NOT GENERATE IN BIOME: " + world.getBiomeGenForCoords(x, z) + " AT: (" + x + ", " + y + ", " + z + ")");
		return false;
	}
}

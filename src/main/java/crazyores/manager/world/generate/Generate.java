package crazyores.manager.world.generate;

import java.util.Random;

import com.google.common.base.Predicate;

import crazyores.manager.pack.COPackManager;
import crazyores.packs.core.block.CoreBlocks;
import crazyores.packs.core.config.COCoreConfigSettings;
import crazyores.packs.core.world.generate.GenerateStructures;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Loader;

public class Generate implements IWorldGenerator {

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		this.generateCoreOres(world, rand, chunkX * 16, chunkZ * 16);
		
		if (Loader.isModLoaded(COPackManager.foodsPack.getPackID())) {
			//this.generateFoodsPackPlants(world, rand, chunkX, chunkZ);
		}
	}
	
	public void generateCoreOres(World world, Random rand, int x, int z) {
		
		switch(world.provider.getDimension()) {
		case -1: generateCoreNetherOres(world, rand, x, z); break;
		case 0: {
			generateCoreSurfaceOres(world, rand, x, z);
			GenerateStructures.generateSurfaceStructures(world, rand, x, z);
			break;
		}
		case 1: generateCoreEndOres(world, rand, x, z); break;
		}
	}
	
	private void generateCoreNetherOres(World world, Random rand, int x, int z) {
		if (COCoreConfigSettings.generateDemoniteOre) {
			generateOre(CoreBlocks.demoniteOre, new Generate.NetherPredicate(), world, rand, x, z, 8, 20, 0, 255);
		}
		
		if (COCoreConfigSettings.generateInvisiumOre) {
			generateOre(CoreBlocks.invisiumOre, new Generate.NetherPredicate(), world, rand, x, z, 8, 18, 0, 255);
		}
		
		if (COCoreConfigSettings.generateDarkstoneOre) {
			generateOre(CoreBlocks.darkstoneOre, new Generate.NetherPredicate(), world, rand, x, z, 8, 36, 0, 255);
		}
		
		if (COCoreConfigSettings.generateLuminiteOre) {
			generateOre(CoreBlocks.luminiteOre, new Generate.NetherPredicate(), world, rand, x, z, 4, 30, 0, 255);
		}
	}
	
	private void generateCoreSurfaceOres(World world, Random rand, int x, int z) {
		
		if (COCoreConfigSettings.generateTapaziteOre) {
			generateTapazite(CoreBlocks.tapaziteStalagmite, Blocks.AIR, world, rand, x, z);
			generateTapazite(CoreBlocks.tapaziteStalactite, Blocks.AIR, world, rand, x, z);
		}
		
		//vein size, chances to spawn, minY, maxY
		
		if (COCoreConfigSettings.generateCopperOre)
			generateOre(CoreBlocks.copperOre, world, rand, x, z, 8, 18, 0, 86);
		
		if (COCoreConfigSettings.generateMeteoriteOre)
			generateOre(CoreBlocks.meteoriteOre, world, rand, x, z, 6, 16, 70, 255);
		
		if (COCoreConfigSettings.generateAdamiteOre)
			generateWaterOre(CoreBlocks.adamiteOre, world, rand, x, z, 2, 10, 0, 255);
		
		if (COCoreConfigSettings.generateSapphireOre)
			generateOre(CoreBlocks.sapphireOre, world, rand, x, z, 6, 10, 0, 49);
		
		if (COCoreConfigSettings.generateRubyOre)
			generateOre(CoreBlocks.rubyOre, world, rand, x, z, 6, 8, 0, 41);
		
		if (COCoreConfigSettings.generateFoolsRubyOre)
			generateOre(CoreBlocks.foolsRubyOre, world, rand, x, z, 4, 20, 0, 50);
		
		if (COCoreConfigSettings.generateZectiumOre)
			generateOre(CoreBlocks.zectiumOre, world, rand, x, z, 6, 2, 0, 14);
		
		if (COCoreConfigSettings.generateOsmoniumOre)
			generateOre(CoreBlocks.osmoniumOre, world, rand, x, z, 4, 3, 95, 255);
		
		if (COCoreConfigSettings.generateStarconiumOre)
			generateOre(CoreBlocks.starconiumOre, world, rand, x, z, 4, 1, 0, 12);
		
		if (COCoreConfigSettings.generateExperiumOre)
			generateOre(CoreBlocks.experiumOre, world, rand, x, z, 2, 4, 0, 30);
	}
	
	private void generateCoreEndOres(World world, Random rand, int x, int z) {
		if (COCoreConfigSettings.generateEnderOre)
			generateOre(CoreBlocks.enderOre, new Generate.EnderPredicate(), world, rand, x, z, 8, 40, 0, 255);
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
	private void generateOre(Block block, Predicate<IBlockState> predicate, World world, Random rand, int blockXPos, int blockZPos, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
		
		int diffMinMax = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + rand.nextInt(16);
			int posY = minY + rand.nextInt(diffMinMax);
			int posZ = blockZPos + rand.nextInt(16);
			(new WorldGenMinable(block.getBlockState().getBaseState(), maxVeinSize, predicate)).generate(world, rand, new BlockPos(posX, posY, posZ));
		}
	}
	
	private void generateOre(Block block, World world, Random rand, int blockXPos, int blockZPos, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
		
		int diffMinMax = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + rand.nextInt(16);
			int posY = minY + rand.nextInt(diffMinMax);
			int posZ = blockZPos + rand.nextInt(16);
			(new WorldGenMinable(block.getBlockState().getBaseState(), maxVeinSize)).generate(world, rand, new BlockPos(posX, posY, posZ));
		}
	}
	
	private void generateWaterOre(Block spawnedBlock, World world, Random rand, int blockXPos, int blockZPos, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
		
		int diffMinMax = maxY - minY;
		for (int x = 0; x < chancesToSpawn; x++) {
			int posX = blockXPos + rand.nextInt(16);
			int posY = minY + rand.nextInt(diffMinMax);
			int posZ = blockZPos + rand.nextInt(16);
			(new WorldGenNearWater(spawnedBlock, maxVeinSize)).generate(world, rand, new BlockPos(posX, posY, posZ));
		}
	}
	
	private void generateTapazite(Block spawnedBlock, Block canSpawnInBlock, World world, Random rand, int blockXPos, int blockZPos) {
		
		for (int i = 0; i < 256; i++) {
			
			int posX = blockXPos + rand.nextInt(16);
			int posY = rand.nextInt(35);
			int posZ = blockZPos + rand.nextInt(16);
			
			if (rand.nextInt(6) == 0) {
				BlockPos currentBlockPos = new BlockPos(posX, posY, posZ);
				BlockPos aboveBlockPos = new BlockPos(posX, posY + 1, posZ);
				BlockPos belowBlockPos = new BlockPos(posX, posY - 1, posZ);
				
				
				if (spawnedBlock.equals(CoreBlocks.tapaziteStalagmite) 
						&& world.getBlockState(currentBlockPos).getBlock().isAir(world.getBlockState(currentBlockPos), world, currentBlockPos) 
						&& world.getBlockState(belowBlockPos).getBlock().isAssociatedBlock(Blocks.STONE) 
						&& world.getBlockState(aboveBlockPos).getBlock().isAir(world.getBlockState(aboveBlockPos), world, aboveBlockPos)) {
					world.setBlockState(currentBlockPos, CoreBlocks.tapaziteStalagmite.getDefaultState());
					break;
				}
				else if (spawnedBlock.equals(CoreBlocks.tapaziteStalactite) 
						&& world.getBlockState(currentBlockPos).getBlock().isAir(world.getBlockState(currentBlockPos), world, currentBlockPos)
						&& world.getBlockState(aboveBlockPos).getBlock().isAssociatedBlock(Blocks.STONE) 
						&& world.getBlockState(belowBlockPos).getBlock().isAir(world.getBlockState(aboveBlockPos), world, belowBlockPos)) {
					world.setBlockState(currentBlockPos, CoreBlocks.tapaziteStalactite.getDefaultState());
					break;
				}
			}
		}
	}
	
	static class NetherPredicate implements Predicate<IBlockState>
    {
        private NetherPredicate()
        {
        }

        public boolean apply(IBlockState p_apply_1_)
        {
        	if (p_apply_1_ != null && p_apply_1_.getBlock() == Blocks.NETHERRACK)
            {
                return true;
            }
        	else
        	{
        		return false;
        	}
        }
    }
	
	static class EnderPredicate implements Predicate<IBlockState>
    {
        private EnderPredicate()
        {
        }

        public boolean apply(IBlockState p_apply_1_)
        {
        	if (p_apply_1_ != null && p_apply_1_.getBlock() == Blocks.END_STONE)
            {
                return true;
            }
        	else
        	{
        		return false;
        	}
        }
    }
}

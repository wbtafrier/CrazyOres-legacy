package crazyores_core.common.world.biome.decorator;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import crazyores_core.common.block.BlockList;
import crazyores_core.common.world.biome.DreamStateBiomes;

public class DreamStateBiomeDecoratorHelper {
	
	public static WorldGenerator copperGen;
	
	protected static void decorateBiome(BiomeGenBase biome) {
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(DreamStateBiomeDecorator.currentWorld, DreamStateBiomeDecorator.randomGenerator, DreamStateBiomeDecorator.xCoordInChunk, DreamStateBiomeDecorator.zCoordInChunk));
        
		//perpere ores for generation
        initOres();
        
        //GenerateOres
        generateOreInBiome(biome);

        if(biome == DreamStateBiomes.dreamHillsBiome){
//            DreamStateBiomeDecorator.numTreesPerChunk = BiomeGenDreamHills.treesPerChunk;
//            int i = DreamStateBiomeDecorator.numTreesPerChunk;
//           
//            /** Chunk Postions **/
//            int chunkX;
//            int chunkZ;
//            int y;
//            
//            /** get blocks at the given locations **/
//            Block block;
//            Block blockA;
//            
//            /** Generates Small tree **/
//            for(int a = 0; a < i; ++a) {
//                if(i == DreamStateBiomeDecorator.randomGenerator.nextInt(8)){
//                    chunkX = DreamStateBiomeDecorator.xCoordInChunk + DreamStateBiomeDecorator.randomGenerator.nextInt(16) + 8;
//                    chunkZ = DreamStateBiomeDecorator.zCoordInChunk + DreamStateBiomeDecorator.randomGenerator.nextInt(16) + 8;
//                    y = DreamStateBiomeDecorator.currentWorld.getTopSolidOrLiquidBlock(chunkX, chunkZ);
//                    block = DreamStateBiomeDecorator.currentWorld.getBlock(chunkX, y, chunkZ);
//                    blockA = DreamStateBiomeDecorator.currentWorld.getBlock(chunkX, y - 1, chunkZ);
//                    if(block != Blocks.air || block != Blocks.water){
//                        if(blockA != Blocks.air || blockA != Blocks.water){
//                            DreamStateBiomeDecorator.smallTree.generate(DreamStateBiomeDecorator.currentWorld, DreamStateBiomeDecorator.randomGenerator, chunkX, y, chunkZ);
//                        }
//                    }
//                }
//                /** Generates Big tree **/
//                if(i == DreamStateBiomeDecorator.randomGenerator.nextInt(15)){
//                    chunkX = DreamStateBiomeDecorator.xCoordInChunk + DreamStateBiomeDecorator.randomGenerator.nextInt(16) + 8;
//                    chunkZ = DreamStateBiomeDecorator.zCoordInChunk + DreamStateBiomeDecorator.randomGenerator.nextInt(16) + 8;
//                    y = DreamStateBiomeDecorator.currentWorld.getTopSolidOrLiquidBlock(chunkX, chunkZ);
//                    block = DreamStateBiomeDecorator.currentWorld.getBlock(chunkX, y, chunkZ);
//                    blockA = DreamStateBiomeDecorator.currentWorld.getBlock(chunkX, y - 1, chunkZ);
//                    if(block != Blocks.air || block != Blocks.water){
//                        if(blockA != Blocks.air || blockA != Blocks.water){
//                            DreamStateBiomeDecorator.bigTree.generate(DreamStateBiomeDecorator.currentWorld, DreamStateBiomeDecorator.randomGenerator, chunkX, y, chunkZ);
//                        }
//                    }
//                }
//            }
        }
    }

    /**
     * Prepare ores for generation
     */
    private static void initOres() {
//        copperGen = new WorldGenMinable(BlockList.copper_ore, 13, BlockList.dream_state_stone);
        copperGen = new WorldGenMinable(BlockList.copper_ore, 13, BlockList.adamite_storage_block);

    }

    /**
     * Geberate Ores In a Biome
     * @param biome
     */
    private static void generateOreInBiome(BiomeGenBase biome){
        if(biome == DreamStateBiomes.dreamHillsBiome){
            genStandardOre(20, copperGen, 0, 96);
        }
    }

    /**
     * Generate ores in chunks.
     * @param spawnWeight
     * @param generatorToSpawn
     * @param minSpawnHeight
     * @param maxYSpawnHeight
     */
    private static void genStandardOre(int spawnWeight, WorldGenerator generatorToSpawn, int minSpawnHeight, int maxYSpawnHeight) {
        for (int l = 0; l < spawnWeight; ++l) {
            int i1 = DreamStateBiomeDecorator.xCoordInChunk + DreamStateBiomeDecorator.randomGenerator.nextInt(16);
            int j1 = DreamStateBiomeDecorator.randomGenerator.nextInt(maxYSpawnHeight - minSpawnHeight) + minSpawnHeight;
            int k1 = DreamStateBiomeDecorator.zCoordInChunk + DreamStateBiomeDecorator.randomGenerator.nextInt(16);
            generatorToSpawn.generate(DreamStateBiomeDecorator.currentWorld, DreamStateBiomeDecorator.randomGenerator, i1, j1, k1);
        }
    }
	
}

package crazyores_core.common.world.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import crazyores_core.common.block.BlockList;
import crazyores_core.common.world.biome.decorator.DreamStateBiomeDecorator;

public class DreamStateBiomes extends BiomeGenBase {

	public static final BiomeGenBase dreamHillsBiome = new BiomeGenDreamHills(76).setColor(0).setBiomeName("Dream Hills Biome");
	
	public DreamStateBiomes(int biomeID) {
		super(biomeID);
		this.theBiomeDecorator = new DreamStateBiomeDecorator();
	}
	
	public static void registerBiomesInDictionary() {
		BiomeDictionary.registerBiomeType(dreamHillsBiome, Type.HILLS);
		BiomeDictionary.registerAllBiomes();
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random rand) {
		if (rand.nextInt(6) == 0) {
//			return new WorldGenTallGrass(BlockList.dream_state_tall_grass, 0);
			return new WorldGenTallGrass(Blocks.tallgrass, 2);

		}
		return new WorldGenTallGrass(Blocks.tallgrass, 1);
	}
	
	@Override
    public void genTerrainBlocks(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
        this.generateBiomeTerrain(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
    }
	
	/**
     * Replaces custom Stone to allow top/filler blocks to work in dimension.
     * 
     * @param world
     * @param random
     * @param replacableBlock
     * @param aByte
     * @param x
     * @param y
     * @param z
     */
    public void generateBiomeTerrain(World world, Random random, Block[] replacableBlock, byte[] aByte, int x, int y, double z)
    {
        Block block = this.topBlock;
        byte b0 = (byte) (this.field_150604_aj & 255);
        Block block1 = this.fillerBlock;
        int k = -1;
        int l = (int) (z / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        int i1 = x & 15;
        int j1 = y & 15;
        int k1 = replacableBlock.length / 256;
        for (int l1 = 255; l1 >= 0; --l1)
        {
            int i2 = (j1 * 16 + i1) * k1 + l1;

            if (l1 <= 0 + random.nextInt(5))
            {
//                replacableBlock[i2] = BlockList.dream_state_bed_rock;
                replacableBlock[i2] = Blocks.bedrock;
            }
            else
            {
                Block block2 = replacableBlock[i2];

                if (block2 != null && block2.getMaterial() != Material.air)
                {
//                    if (block2 == BlockList.dream_state_stone)
                    if (block2 == BlockList.adamite_storage_block)
                    {
                        if (k == -1)
                        {
                            if (l <= 0)
                            {
                                block = null;
                                b0 = 0;
//                                block1 = BlockList.dream_state_stone;
                                block1 = BlockList.adamite_storage_block;
                            }
                            else if (l1 >= 59 && l1 <= 64)
                            {
                                block = this.topBlock;
                                b0 = (byte) (this.field_150604_aj & 255);
                                block1 = this.fillerBlock;
                            }

                            if (l1 < 63 && (block == null || block.getMaterial() == Material.air))
                            {
                                if (this.getFloatTemperature(x, l1, y) < 0.15F)
                                {
//                                    block = BlockList.dream_state_ice;
                                    block = Blocks.ice;

                                    b0 = 0;
                                }
                                else
                                {
//                                    block = BlockList.dream_state_water;
                                    block = Blocks.water;
                                    b0 = 0;
                                }
                            }

                            k = l;

                            if (l1 >= 62)
                            {
                                replacableBlock[i2] = block;
                                aByte[i2] = b0;
                            }
                            else if (l1 < 56 - l)
                            {
                                block = null;
//                                block1 = BlockList.dream_state_stone;
//                                replacableBlock[i2] = BlockList.dream_state_gravel;
                                block1 = BlockList.adamite_storage_block;
                                replacableBlock[i2] = BlockList.zectium_storage_block;
                            }
                            else
                            {
                                replacableBlock[i2] = block1;
                            }
                        }
                        else if (k > 0)
                        {
                            --k;
                            replacableBlock[i2] = block1;

//                            if (k == 0 && block1 == BlockList.dream_state_sand)
                                if (k == 0 && block1 == BlockList.fools_ruby_storage_block)

                            {
                                k = random.nextInt(4) + Math.max(0, l1 - 63);
//                                block1 = BlockList.dream_state_stone_stone;
                                block1 = BlockList.ruby_storage_block;

                            }
                        }
                    }
                }
                else
                {
                    k = -1;
                }
            }
        }
    }
}

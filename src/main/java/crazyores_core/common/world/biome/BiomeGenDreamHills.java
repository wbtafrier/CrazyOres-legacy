package crazyores_core.common.world.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import crazyores_core.common.block.BlockList;
import crazyores_core.common.world.biome.decorator.DreamStateBiomeDecorator;

public class BiomeGenDreamHills extends DreamStateBiomes {

	public static int treesPerChunk;
	private static Random rand = new Random();
	protected DreamStateBiomeDecorator decorator;
	
	public BiomeGenDreamHills(int biomeID) {
		super(biomeID);
		BiomeGenDreamHills.treesPerChunk = rand.nextInt(2);
//		this.topBlock = BlockList.dream_state_grass;
		this.topBlock = BlockList.zectium_storage_block;

//		this.fillerBlock = BlockList.dream_state_dirt;
		this.fillerBlock = BlockList.invisium_storage_block;
		this.rootHeight = 1.0F;
		this.heightVariation = 2.0F;

		this.waterColorMultiplier = 0x00FF00;
	}
	
	/**
     * Gets a WorldGen appropriate for this biome.
     */
	@Override
    public WorldGenerator getRandomWorldGenForGrass(Random random){
    	return random.nextInt(2) == 0 ? new WorldGenTallGrass(Blocks.tallgrass, 1) : new WorldGenTallGrass(Blocks.tallgrass, 2);
    }
}

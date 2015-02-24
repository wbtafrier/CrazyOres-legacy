package crazyores_core.common.world.biome;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import crazyores_core.common.block.BlockList;
import crazyores_core.common.world.biome.decorator.DreamStateBiomeDecorator;

public abstract class DreamStateBiomes extends BiomeGenBase {

	public static final BiomeGenBase crazyHillsBiome = new BiomeGenCrazyHills(76).setColor(0).setBiomeName("Crazy Hills");
	
	public DreamStateBiomes(int biomeID) {
		super(biomeID);
		this.theBiomeDecorator = new DreamStateBiomeDecorator();
	}
	
	public static void registerBiomesInDictionary() {
		BiomeDictionary.registerBiomeType(crazyHillsBiome, Type.HILLS);
		BiomeDictionary.registerAllBiomes();
	}
}

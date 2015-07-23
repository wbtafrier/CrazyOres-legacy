package crazyores.packs.core.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.manager.util.CrazyOresLogger;

public class BlockTapaziteStalagmite extends BlockTapaziteCrystal {

	public BlockTapaziteStalagmite(String unlocalizedName, SoundType soundType, float hardness, float resistance) {
		super(unlocalizedName, soundType, hardness, resistance);
		this.setBlockBounds(0.03F, 0.0F, 0.03F, 0.97F, 0.2F, 0.97F);
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		
		return world.getBlock(x, y - 1, z).isAssociatedBlock(Blocks.stone);
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.getBlock(x, y - 1, z).isAssociatedBlock(Blocks.stone) && world.getBlock(x, y, z).isAir(world, x, y, z);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {

//		CrazyOresLogger.write(Level.INFO, "BLOCK LIGHT LEVEL: " + world.getBlockLightValue(x, y + 1, z));
		if (super.correctLightingForGrowth(world, x, y, z)) {

			int metadata = world.getBlockMetadata(x, y, z);

			if (metadata < ItemBlockTapaziteStalagmite.maxMetadata) {
				float f = this.growMultiplier(world, x, y, z);

				if (rand.nextInt((int)(20.0F / f) + 1) == 0) {

					if (metadata < 4) {
						super.growCrystal(world, x, y, z, metadata);
					}
					else if (metadata < 5 && world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z)) {
						super.growCrystal(world, x, y, z, metadata);
					}
					else if (metadata == 5 && world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z) &&
							world.getBlock(x + 1, y, z).isAir(world, x + 1, y, z) && world.getBlock(x - 1, y, z).isAir(world, x - 1, y, z) &&
							world.getBlock(x, y, z + 1).isAir(world, x, y, z + 1) && world.getBlock(x, y, z - 1).isAir(world, x, y, z - 1) &&
							world.getBlock(x + 1, y, z + 1).isAir(world, x + 1, y, z + 1) && world.getBlock(x + 1, y, z - 1).isAir(world, x + 1, y, z - 1) &&
							world.getBlock(x - 1, y, z + 1).isAir(world, x - 1, y, z + 1) && world.getBlock(x - 1, y, z - 1).isAir(world, x - 1, y, z - 1)) {
						super.growCrystal(world, x, y, z, metadata);
					}
				}

				if (rand.nextInt((int)(30F / f) + 1) == 0) {
					super.spawnRandomCrystal(world, x, y, z, rand, metadata);
				}
			}
		}
	}

	@Override
	protected float growMultiplier(World world, int x, int y, int z) {

		float f = 1.0F;
		Block block = world.getBlock(x, y, z - 1);
		Block block1 = world.getBlock(x, y, z + 1);
		Block block2 = world.getBlock(x - 1, y, z);
		Block block3 = world.getBlock(x + 1, y, z);
		Block block4 = world.getBlock(x - 1, y, z - 1);
		Block block5 = world.getBlock(x + 1, y, z - 1);
		Block block6 = world.getBlock(x + 1, y, z + 1);
		Block block7 = world.getBlock(x - 1, y, z + 1);

		//if x axis has the same block
		boolean flag = block2 == this || block3 == this;

		//if z axis has the same block
		boolean flag1 = block == this || block1 == this;

		//if diagnols are the same block
		boolean flag2 = block4 == this || block5 == this || block6 == this || block7 == this;

		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = z - 1; j <= z + 1; ++j) 
			{
				float f1 = 0.0F;

				if (world.getBlock(i, y - 1, j).isAssociatedBlock(Blocks.stone)) {
					f1 = 1.0F;

//					CrazyOresLogger.write(Level.INFO, "I'm stone!");

					//If cool crystal mob guy is around 
					//                    if (world.getBlock(i, y - 1, j).isFertile(world,i, y - 1, j)) {
					//                        f1 = 5.0F;
					//                    }
				}

				if (i != x || j != z) {
					f1 /= 4.0F;
				}

				f += f1;
			}
		}

		if (flag2 || flag && flag1) {
			f /= 2.0F;
		}

//		CrazyOresLogger.write(Level.INFO, "THIS IS THE F VARIABLE: " + f);
		return f;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
		for (int metadata = 0; metadata < ItemBlockTapaziteStalagmite.maxMetadata; metadata++) {
			list.add(new ItemStack(item, 1, metadata));
		}
	}
}

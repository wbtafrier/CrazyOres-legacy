package crazyores.packs.core.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOre extends CoreBlock {

	private Random rand = new Random();
	
	protected BlockOre(String unlocalizedName, Material blockMaterial, float hardness, float resistance) {
		super(unlocalizedName, blockMaterial, hardness, resistance);
	}
	
	protected BlockOre(String unlocalizedName, Material blockMaterial, SoundType soundType, float hardness, float resistance) {
		super(unlocalizedName, blockMaterial, soundType, hardness, resistance);
	}

	protected BlockOre(String unlocalizedName, Material blockMaterial, CreativeTabs tab, SoundType soundType, float hardness, float resistance) {
		super(unlocalizedName, blockMaterial, tab, soundType, hardness, resistance);
	}
	
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return this == Blocks.coal_ore ? Items.coal : (this == Blocks.diamond_ore ? Items.diamond : (this == Blocks.lapis_ore ? Items.dye : (this == Blocks.emerald_ore ? Items.emerald : (this == Blocks.quartz_ore ? Items.quartz : Item.getItemFromBlock(this)))));
    }

	@Override
    public int quantityDropped(Random rand) {
        return this == Blocks.lapis_ore ? 4 + rand.nextInt(5) : 1;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random rand) {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, rand, fortune)) {
            int j = rand.nextInt(fortune + 2) - 1;
            if (j < 0) j = 0;
            return this.quantityDropped(rand) * (j + 1);
        }
        else {
            return this.quantityDropped(rand);
        }
    }

    @Override
    public int getExpDrop(IBlockAccess world, int metadata, int fortune) {
    	
        if (this.getItemDropped(metadata, rand, fortune) != Item.getItemFromBlock(this)) {
            int exp = 0;

//            if (this == Blocks.coal_ore) {
//            	exp = MathHelper.getRandomIntegerInRange(rand, 0, 2);
//            }
//            else if (this == Blocks.diamond_ore) {
//            	exp = MathHelper.getRandomIntegerInRange(rand, 3, 7);
//            }
//            else if (this == Blocks.emerald_ore) {
//            	exp = MathHelper.getRandomIntegerInRange(rand, 3, 7);
//            }
//            else if (this == Blocks.lapis_ore) {
//            	exp = MathHelper.getRandomIntegerInRange(rand, 2, 5);
//            }
//            else if (this == Blocks.quartz_ore) {
//            	exp = MathHelper.getRandomIntegerInRange(rand, 2, 5);
//            }
            return exp;
        }
        return 0;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    @Override
    public int damageDropped(int damage) {
        return this == Blocks.lapis_ore ? 4 : 0;
    }
}

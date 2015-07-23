package crazyores.packs.core.block;

import java.util.Random;

import cpw.mods.fml.common.Loader;
import crazyores.manager.pack.COPackManager;
import crazyores.packs.core.item.CoreItems;
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
	
	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		
		if (Loader.isModLoaded(COPackManager.corePack.getPackID())) {
			if (this == CoreBlocks.meteoriteOre) {
				int r = rand.nextInt(10) + 1;
				if (r <= 2) return CoreItems.meteoriteGem;
				else return CoreItems.meteoriteCoal;
			}
			else if (this == CoreBlocks.sapphireOre) {
				return CoreItems.sapphireGem;
			}
			else if (this == CoreBlocks.adamiteOre) {
				return CoreItems.adamiteShard;
			}
			else if (this == CoreBlocks.rubyOre) {
				return CoreItems.rubyGem;
			}
			else if (this == CoreBlocks.foolsRubyOre) {
				return CoreItems.foolsRubyGem;
			}
			else if (this == CoreBlocks.starconiumOre) {
				return CoreItems.starconiumShard;
			}
			else if (this == CoreBlocks.experiumOre) {
				return CoreItems.experiumOrb;
			}
			else if (this == CoreBlocks.demoniteOre) {
				return CoreItems.demoniteOrb;
			}
		}
		return Item.getItemFromBlock(this);
    }

	@Override
    public int quantityDropped(Random rand) {
		if (Loader.isModLoaded(COPackManager.corePack.getPackID())) {
			if (this == CoreBlocks.foolsRubyOre) {
				return rand.nextInt(4) + 1;
			}
			else if (this == CoreBlocks.experiumOre) {
				return rand.nextInt(6);
			}
			else if (this == CoreBlocks.demoniteOre) {
				return rand.nextInt(3) + 1;
			}
		}
		return 1;
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
            
            if (Loader.isModLoaded(COPackManager.corePack.getPackID())) {
            	if (this == CoreBlocks.meteoriteOre) 		exp = MathHelper.getRandomIntegerInRange(rand, 1, 3);
            	else if (this == CoreBlocks.sapphireOre)	exp = MathHelper.getRandomIntegerInRange(rand, 0, 0);
            	else if (this == CoreBlocks.adamiteOre) 	exp = MathHelper.getRandomIntegerInRange(rand, 0, 0);
            	else if (this == CoreBlocks.rubyOre) 		exp = MathHelper.getRandomIntegerInRange(rand, 0, 0);
            	else if (this == CoreBlocks.foolsRubyOre) 	exp = MathHelper.getRandomIntegerInRange(rand, 0, 0);
            	else if (this == CoreBlocks.starconiumOre) 	exp = MathHelper.getRandomIntegerInRange(rand, 0, 0);
            	else if (this == CoreBlocks.experiumOre) 	exp = MathHelper.getRandomIntegerInRange(rand, 0, 0);
            	else if (this == CoreBlocks.demoniteOre) 	exp = MathHelper.getRandomIntegerInRange(rand, 0, 0);
            }
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

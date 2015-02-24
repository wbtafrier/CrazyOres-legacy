package crazyores_core.common.block;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import crazyores_core.common.item.ItemList;
import crazyores_core.common.tab.COTabList;
import crazyores_core.util.ICOName;
import crazyores_core.util.TextureManager;

/**
 * Ore has the properties for all of the ore blocks in the CO Core.
 * @author Andy608 and ISQUISHALL
 */
public class Ore extends BlockOre implements ICOName {
	/**
	 * Default constructor.
	 */
	public Ore() {
		super();
		this.setStepSound(Block.soundTypeStone);
		this.setCreativeTab(COTabList.CO_BLOCKS);
	}
    
	/**
	 * Item drop method for all of the Ores.
	 * @return The specific item that should drop for the ore.
	 */
	@Override
	public Item getItemDropped(int metaData, Random rand, int fortuneLevel) {
		
		if (this.isAssociatedBlock(BlockList.meteorite_ore)) {
			if (rand.nextInt(10) <= 8) return ItemList.meteorite_coal;
			else return ItemList.meteorite_gem;
		}
		else if (this.isAssociatedBlock(BlockList.sapphire_ore)) {
			return ItemList.sapphire_gem;
		}
		else if (this.isAssociatedBlock(BlockList.adamite_ore)) {
			return ItemList.adamite_shard;
		}
		else if (this.isAssociatedBlock(BlockList.ruby_ore)) {
			return ItemList.ruby_gem;
		}
		else if (this.isAssociatedBlock(BlockList.fools_ruby_ore)) {
			return ItemList.fools_ruby_gem;
		}
		else if (this.isAssociatedBlock(BlockList.tapazite_ore)) {
			return ItemList.tapazite_gem;
		}
		else if (this.isAssociatedBlock(BlockList.starconium_ore)) {
			return ItemList.starconium_gem;
		}
		else if (this.isAssociatedBlock(BlockList.experium_ore)) {
			return ItemList.experium_orb;
		}
		else if (this.isAssociatedBlock(BlockList.demonite_ore)) {
			return ItemList.demonite_orb;
		}
		else if (this.isAssociatedBlock(BlockList.ender_ore)) {
			return ItemList.ender_gem;
		}
		else {
			return Item.getItemFromBlock(this);
		}
	}
	
	/**
     * Returns the quantity of items to drop on block destruction.
     */
	@Override
    public int quantityDropped(Random rand) {
		if (this.isAssociatedBlock(BlockList.fools_ruby_ore)) {
			return rand.nextInt(4) + 1;
		}
		else {
			return 1;
		}
    }
	
	private Random rand = new Random();
	
    @Override
    public int getExpDrop(IBlockAccess blockAccess, int metadata, int fortuneLevel) {
        if (this.getItemDropped(metadata, rand, fortuneLevel) != Item.getItemFromBlock(this)) {
            int experienceValue = 0;

            if (this.isAssociatedBlock(BlockList.meteorite_ore)) {
            	experienceValue = MathHelper.getRandomIntegerInRange(rand, 0, 3);
    		}
    		else if (this.isAssociatedBlock(BlockList.sapphire_ore)) {
    			experienceValue = MathHelper.getRandomIntegerInRange(rand, 1, 5);
    		}
    		else if (this.isAssociatedBlock(BlockList.adamite_ore)) {
    			experienceValue = MathHelper.getRandomIntegerInRange(rand, 1, 5);
    		}
    		else if (this.isAssociatedBlock(BlockList.ruby_ore)) {
    			experienceValue = MathHelper.getRandomIntegerInRange(rand, 1, 6);
    		}
    		else if (this.isAssociatedBlock(BlockList.fools_ruby_ore)) {
    			experienceValue = MathHelper.getRandomIntegerInRange(rand, 0, 2);
    		}
    		else if (this.isAssociatedBlock(BlockList.tapazite_ore)) {
    			experienceValue = MathHelper.getRandomIntegerInRange(rand, 4, 8);
    		}
    		else if (this.isAssociatedBlock(BlockList.starconium_ore)) {
    			experienceValue = MathHelper.getRandomIntegerInRange(rand, 5, 10);
    		}
    		else if (this.isAssociatedBlock(BlockList.experium_ore)) {
    			experienceValue = MathHelper.getRandomIntegerInRange(rand, 8, 14);
    		}
    		else if (this.isAssociatedBlock(BlockList.demonite_ore)) {
    			experienceValue = MathHelper.getRandomIntegerInRange(rand, 2, 7);
    		}
    		else if (this.isAssociatedBlock(BlockList.ender_ore)) {
    			experienceValue = MathHelper.getRandomIntegerInRange(rand, 6, 12);
    		}
            return experienceValue;
        }
        return 0;
    }

	@Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(String.format("%s%s", TextureManager.RESOURCE_PREFIX, this.parsePrefix(this.getReadableName(), '.')));
    }
	
	@Override
	public String parsePrefix(String unlocalizedName, char lastPrefixChar) {
		return unlocalizedName.substring(unlocalizedName.indexOf(lastPrefixChar) + 1);
	}
	
	@Override
	public String getReadableName() {
		return this.parsePrefix(super.getUnlocalizedName(), ':');
	}
}
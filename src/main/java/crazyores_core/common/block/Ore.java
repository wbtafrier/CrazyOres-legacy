package crazyores_core.common.block;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import crazyores_core.common.core.ICOName;
import crazyores_core.common.tab.COTabList;
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
	public Item getItemDropped(int metaData, Random rand, int fortuneLevel) {
		return this.isAssociatedBlock(BlockList.copper_ore) ? Item.getItemFromBlock(this) : Item.getItemFromBlock(this);
	}
	
	/**
	 * @return the name of the block for the language file and textures.
	 */
	@Override
	public String getUnlocalizedName() {
		return String.format("tile.%s%s", TextureManager.RESOURCE_PREFIX, this.parsePrefix(super.getUnlocalizedName(), '.'));
	}
	
	@Override
	public String parsePrefix(String unlocalizedName, char lastPrefixChar) {
		return unlocalizedName.substring(unlocalizedName.indexOf(lastPrefixChar) + 1);
	}
	
	@Override
	public String getReadableName() {
		return this.parsePrefix(this.getUnlocalizedName(), ':');
	}
}
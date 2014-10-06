package crazyores_core.common.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

/**
 * ItemLuminiteStorageBlock deals with the metadata issues for the luminiteStorageBlock
 * @author Andy608 and ISQUISHALL
 */
public class ItemLuminiteBlock extends ItemBlock {
	
	/**
	 * An ItemBlock instance of the Luminite Block.
	 * @param block The Block that this ItemBlock represents.
	 */
	public ItemLuminiteBlock(Block block) {
		super(block);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(BlockList.luminite_storage_block.getUnlocalizedName());
	}

	@Override
	public int getMetadata(int damageValue) {
		damageValue = MathHelper.clamp_int(damageValue, 0, BlockNames.LUMINITE_STORAGE_BLOCK_SUBTYPES.length - 1);
		return damageValue;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return super.getUnlocalizedName() + "_" + BlockNames.LUMINITE_STORAGE_BLOCK_SUBTYPES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, BlockNames.LUMINITE_STORAGE_BLOCK_SUBTYPES.length - 1)];
	}	
}

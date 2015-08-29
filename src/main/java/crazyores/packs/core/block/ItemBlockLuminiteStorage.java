package crazyores.packs.core.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class ItemBlockLuminiteStorage extends ItemBlock {
	
	/**
	 * An ItemBlock instance of the Luminite Block.
	 * @param block The Block that this ItemBlock represents.
	 */
	public ItemBlockLuminiteStorage(Block block) {
		super(block);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(CoreBlocks.luminiteStorageBlock.getUnlocalizedName());
	}

	@Override
	public int getMetadata(int damageValue) {
		damageValue = MathHelper.clamp_int(damageValue, 0, BlockLuminiteStorage.LUMINITE_STORAGE_BLOCK_SUBTYPES.length - 1);
		return damageValue;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return super.getUnlocalizedName() + "_" + BlockLuminiteStorage.LUMINITE_STORAGE_BLOCK_SUBTYPES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, BlockLuminiteStorage.LUMINITE_STORAGE_BLOCK_SUBTYPES.length - 1)];
	}	
}

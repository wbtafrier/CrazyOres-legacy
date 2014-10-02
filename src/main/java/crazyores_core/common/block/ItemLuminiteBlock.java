package crazyores_core.common.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class ItemLuminiteBlock extends ItemBlock {

	public ItemLuminiteBlock(Block block) {
		super(block);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(BlockList.luminite_block.getUnlocalizedName());
	}

	@Override
	public int getMetadata(int damageValue) {
		return damageValue;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return super.getUnlocalizedName() + "_" + BlockNames.LUMINITE_BLOCKS[MathHelper.clamp_int(itemStack.getItemDamage(), 0, BlockNames.LUMINITE_BLOCKS.length - 1)];
	}
	
}

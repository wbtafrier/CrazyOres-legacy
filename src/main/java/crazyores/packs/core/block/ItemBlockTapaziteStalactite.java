package crazyores.packs.core.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class ItemBlockTapaziteStalactite extends ItemBlock {

	public static final int maxMetadata = 7;
	
	public ItemBlockTapaziteStalactite(Block block) {
		super(block);
		this.setHasSubtypes(true);
		this.setUnlocalizedName(CoreBlocks.tapaziteStalactite.getUnlocalizedName());
	}
	
	@Override
	public int getMetadata(int damageValue) {
		damageValue = MathHelper.clamp_int(damageValue, 0, maxMetadata);
		return damageValue;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return super.getUnlocalizedName() + "_" + itemStack.getItemDamage();
	}
}

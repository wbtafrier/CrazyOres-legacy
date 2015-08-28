package crazyores.packs.core.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class CoreStairs extends BlockStairs {

	private String blockUnlocalizedName;
	
	protected CoreStairs(String unlocalizedName, Block block, float hardness, float resistance) {
		super(block, 0);
		this.setCreativeTab(block.getCreativeTabToDisplayOn());
		this.blockUnlocalizedName = unlocalizedName;
		this.useNeighborBrightness = true;
		this.blockHardness = hardness;
		this.blockResistance = resistance;
	}
	
	protected CoreStairs(String unlocalizedName, Block block, float hardness, float resistance, float lightLevel) {
		this(unlocalizedName, block, hardness, resistance);
		this.setLightLevel(lightLevel);
	}
	
	@Override
	public String getUnlocalizedName() {
		return blockUnlocalizedName;
	}
}

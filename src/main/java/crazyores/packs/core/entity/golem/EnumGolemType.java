package crazyores.packs.core.entity.golem;

import crazyores.packs.core.block.CoreBlocks;
import net.minecraft.block.Block;

public enum EnumGolemType {
	
	COPPER("copper", CoreBlocks.copperBlock),
	SAPPHIRE("sapphire", CoreBlocks.sapphireBlock),
	ADAMITE("adamite", CoreBlocks.adamiteBlock),
	RUBY("ruby", CoreBlocks.rubyBlock),
	FOOLS_RUBY("fools_ruby", CoreBlocks.foolsRubyBlock),
	ZECTIUM("zectium", CoreBlocks.zectiumBlock),
	TAPAZITE("tapazite", CoreBlocks.tapaziteBlock),
	OSMONIUM("osmonium", CoreBlocks.osmoniumBlock),
	STARCONIUM("starconium", CoreBlocks.starconiumBlock),
	DEMONITE("demonite", CoreBlocks.demoniteBlock),
	ENDER("ender", CoreBlocks.enderBlock);
	
	private String name;
	private Block bodyBlock;
	
	private EnumGolemType(String n, Block buildingBlock) {
		name = n;
		bodyBlock = buildingBlock;
	}
	
	public String getName() {
		return name;
	}
	
	public Block getBodyBlock() {
		return bodyBlock;
	}
}

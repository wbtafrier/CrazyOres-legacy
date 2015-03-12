package crazyores.packs.core.block;

import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;

public class BlockTransporter extends BlockDirectional {

	protected BlockTransporter(Material material) {
		super(material);
		this.setBlockBounds();
	}

	public void setBlockBounds() {
		super.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
	}
	
	/**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 14;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }
}

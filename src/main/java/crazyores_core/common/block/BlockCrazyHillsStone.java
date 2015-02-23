package crazyores_core.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores_core.common.tab.COTabList;
import crazyores_core.util.TextureManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockCrazyHillsStone extends COBlock {

	public BlockCrazyHillsStone() {
		super(Material.rock);
		this.setStepSound(Block.soundTypeStone);
		this.setCreativeTab(COTabList.CO_BLOCKS);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(String.format("%s%s%s", TextureManager.RESOURCE_PREFIX, TextureManager.DREAMSTATE_PREFIX, this.parsePrefix(this.getReadableName(), '.')));
    }
	
}

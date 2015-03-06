package crazyores.manager.support;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public interface IBlock {
	
	Material getBlockMaterial();
	
	IIcon getIcon(int side, int metadata);
	
	void registerBlockIcons(IIconRegister iconRegister);
}

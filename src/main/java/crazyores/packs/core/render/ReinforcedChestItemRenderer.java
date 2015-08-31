package crazyores.packs.core.render;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRendererChestHelper;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;

import com.google.common.collect.Maps;

import crazyores.packs.core.block.CoreBlocks;
import crazyores.packs.core.entity.tileentity.TileEntityReinforcedChest;

public class ReinforcedChestItemRenderer extends TileEntityRendererChestHelper {
	
    @Override
    public void renderChest(Block block, int i, float f) {
        
    	if (block == CoreBlocks.reinforcedChest) {
            TileEntityRendererDispatcher.instance.renderTileEntityAt((TileEntityReinforcedChest) CoreBlocks.reinforcedChest.createTileEntity(null, 0), 0.0D, 0.0D, 0.0D, 0.0F);
        }
        else {
            super.renderChest(block, i, f);
        }
    }
	
}

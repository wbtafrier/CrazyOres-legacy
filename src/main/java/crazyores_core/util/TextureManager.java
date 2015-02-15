package crazyores_core.util;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import crazyores_core.common.block.BlockList;
import crazyores_core.common.core.COData;
import crazyores_core.common.core.ICOName;
import crazyores_core.common.item.COItem;
import crazyores_core.common.item.ItemList;

/**
 * TextureManager manages the textures for all of the textures in the CO Core.
 * @author Andy608 and ISQUISHALL
 */
public class TextureManager {
	public static final String RESOURCE_PREFIX = COData.MOD_ID.toLowerCase() + ":";
	
	public static void initTextures(FMLInitializationEvent fmlInitEvent) {
		if (fmlInitEvent.getSide() == Side.CLIENT) {
    		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    		for (Item item : ItemList.item_list) {
    			COItem coItem = (COItem)item;
    			renderItem.getItemModelMesher().register(coItem, 0, new ModelResourceLocation(COData.MOD_ID + ":" + coItem.getReadableName(), "inventory"));
    		}
    		
    		for (Block block : BlockList.block_list) {
    			ICOName coBlock = (ICOName)block;
				renderItem.getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(COData.MOD_ID + ":" + coBlock.getReadableName(), "inventory"));
    		}
    	}
	}
}
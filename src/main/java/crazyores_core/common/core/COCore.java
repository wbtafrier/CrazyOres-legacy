package crazyores_core.common.core;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

import org.apache.logging.log4j.Level;

import crazyores_core.common.block.BlockDictionary;
import crazyores_core.common.block.BlockList;
import crazyores_core.common.config.ConfigManager;
import crazyores_core.common.item.COItem;
import crazyores_core.common.item.ItemDictionary;
import crazyores_core.common.item.ItemList;
import crazyores_core.proxy.IProxy;

/**
 * IF YOU ARE READING THIS MESSAGE THAT MEANS YOU HAVE VIOLATED OUR TERMS OF USE. PLEASE DO NOT DISTRIBUTE!
 * Welcome to the CrazyOres Core main file!
 * @author Andy608 and ISQUISHALL
 */

@Mod(modid = COData.MOD_ID, name = COData.MOD_NAME, version = COData.MOD_VERSION)
public class COCore implements IPack {
	
	/**
	 * The main way used to call the appropriate proxy files.
	 */
	@SidedProxy(clientSide = COData.CLIENT_PROXY, serverSide = COData.SERVER_PROXY)
	public static IProxy proxy;
    
	/**
	 * The instance of this file.
	 */
	@Instance(COData.MOD_ID)
	public static COCore instance = new COCore();
	
	/**
	 * Everything in this method is loaded before Minecraft is loaded.
	 */
	@EventHandler
	private void preInit(FMLPreInitializationEvent fmlPreInitEvent) {
    	COLogger.write(Level.INFO, COData.MOD_NAME + " recognized. Loading...");
    	ConfigManager.writeFiles(fmlPreInitEvent);
    	BlockList.blockInitialization();
    	ItemList.itemInitialization();
	}
	
	/**
	 * Everything in this method is loaded while Minecraft is loading.
	 */
    @EventHandler
    public void init(FMLInitializationEvent fmlInitEvent) {
    	if (fmlInitEvent.getSide() == Side.CLIENT) {
    		RenderItem ri = Minecraft.getMinecraft().getRenderItem();
    		for (Item item : ItemList.core_items) {
    			COItem coItem = (COItem)item;
    			ri.getItemModelMesher().register(item, 0, new ModelResourceLocation(COData.MOD_ID + ":" + coItem.stripName(coItem.getUnlocalizedName()), "inventory"));
    		}
    	}
    	
    	BlockDictionary.registerBlocksToOreDictionary();
    	ItemDictionary.registerItemsToOreDictionary();
    }
    
    /**
     * Everything in this method is loaded after Minecraft has loaded.
     */
    @EventHandler
    public void postInit(FMLPostInitializationEvent fmlPostInitEvent) {
    	COLogger.write(Level.INFO, COData.MOD_NAME + ", Version " + COData.MOD_VERSION + " has loaded!");
    }
    
	@Override
	public String getPackName() {
		return COData.MOD_NAME;
	}

	@Override
	public EnumChatFormatting getPackColor() {
		return EnumChatFormatting.RED;
	}

	@Override
	public String getPackChatPrefix() {
		return COData.PACK_NAME;
	}
}
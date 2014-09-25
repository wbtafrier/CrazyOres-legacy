package crazyores_core.common.core;

import net.minecraft.init.Blocks;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import crazyores_core.proxy.IProxy;

/**
 * IF YOU ARE READING THIS MESSAGE THAT MEANS YOU HAVE VIOLATED OUR TERMS OF USE. PLEASE DO NOT DISTRIBUTE!
 * Welcome to the CrazyOres Core main file!
 * @author Andy608 and ISQUISHALL
 */

@Mod(modid = COData.MOD_ID, name = COData.MOD_NAME, version = COData.VERSION)
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
	 * Anything in this method is loaded before minecraft.
	 */
	@EventHandler
	private void preInit(FMLPreInitializationEvent fmlPreInitEvent) {}
	
	/**
	 * Anything in this method is loaded during the loading of minecraft.
	 */
    @EventHandler
    public void init(FMLInitializationEvent fmlInitEvent) {}
    
    /**
     * Anything in this method is loading after everything else is loaded.
     */
    @EventHandler
    public void postInit(FMLPostInitializationEvent fmlPostInitEvent) {}
    
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

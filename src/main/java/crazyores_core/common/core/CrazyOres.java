package crazyores_core.common.core;


import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import crazyores_core.common.blocks.BlockList;
import crazyores_core.common.blocks.BlockNames;
import crazyores_core.common.blocks.BlockProperties;
import crazyores_core.common.blocks.OreGenerator;
import crazyores_core.common.entity.EntityNames;
import crazyores_core.common.items.ItemList;
import crazyores_core.common.items.ItemNames;
import crazyores_core.common.items.ItemProperties;

/**
 * CrazyOres Core main file. All registries are initialized here.
 * @author Andy608 and ISQUISHALL
 *
 */

@Mod(modid = COData.modID, name = COData.modName, version = COData.modName + " " + COData.version)

public class CrazyOres implements IPack
{
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///																														 ///
	/** IF YOU ARE READING THIS MESSAGE THAT MEANS YOU HAVE VIOLATED MY TERMS OF USE. PLEASE DO NOT DISTRIBUTE! **/	         ///
	///																														 ///
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@SidedProxy(clientSide = "crazyores_core.client.core.ClientProxy", serverSide = "crazyores_core.common.core.CommonProxy")
	public static CommonProxy proxy;

	/** INSTANCES **/

	@Instance(COData.modID)
	public static CrazyOres instance = new CrazyOres();

	private static BlockList bl;
	private static BlockNames bn;
	private static ItemList il;
	private static ItemNames in;
	private static EntityNames en;
	private static OreGenerator oreGen = new OreGenerator();
	private static FurnaceFuel fuel = new FurnaceFuel();
	private static GuiRegister guiHandler = new GuiRegister();

	private void registerEvents()
	{
		MinecraftForge.EVENT_BUS.register(new EventHooks());
	}
	
	@EventHandler
	private void preInit(FMLPreInitializationEvent event)
	{	
		PackManager.coreInstalled = true;
		COLogger.log(Level.INFO, COData.modName + " version " + COData.version + " loading");
		ConfigSetup.writeFile(event);
		this.registerEvents();
		this.itemInitialization();
		this.blockInitialization();
		this.harvestInitialization();
		this.addRecipes();
		Dictionary.registerItems(il);
		this.registerEntitiesAndTileEntities();
		this.miscRegisters();
		this.render();
		this.translateStrings();
	}

	private void blockInitialization()
	{
		BlockProperties.setProperties(bl, bn);
		BlockProperties.registerBlocks(bl, bn);
	}

	private void itemInitialization()
	{
		ItemProperties.setProperties(il, in);
		ItemProperties.registerItems(il, in);
	}
	
	private void harvestInitialization()
	{
	}

	private void addRecipes()
	{
		SmeltingRecipes.registerSmeltingRecipes();
		GameRegistry.registerFuelHandler(this.fuel);
		Recipes.craftingRecipes();
	}

	private void render()
	{
		this.proxy.renderEntities();
		this.proxy.clientRegs();
	}

	private void translateStrings()
	{
//		Localization.stringsToTranslate();
	}
	
	private void registerEntitiesAndTileEntities()
	{
		TileEntityRegisters.registerTileEntities();
		EntityRegisters.registerEntities(en);
	}

	private void miscRegisters()
	{
		if (COSettings.generateOres)
			GameRegistry.registerWorldGenerator(CrazyOres.oreGen, 0);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, this.guiHandler);
		
	}

	@EventHandler
	private void load(FMLInitializationEvent event)
	{
//		this.registerCommands();
	}

	@EventHandler
	private void postInit(FMLPostInitializationEvent event)
	{
		COLogger.log(Level.INFO, COData.modName + " has loaded and initialized successfully! Enjoy!");
	}

	public String getPackName()
	{
		return "Core";
	}

	public EnumChatFormatting getPackColor()
	{
		return EnumChatFormatting.RED;
	}

	public String getPackChatHeader()
	{
		return this.getPackColor() + "[CRAZYORES CORE]" + EnumChatFormatting.RESET;
	}
}

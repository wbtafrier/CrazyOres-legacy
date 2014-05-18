package crazyores_core.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;
import crazyores_core.common.core.COData;
import crazyores_core.common.tabs.TabList;

public class ItemProperties 
{
	/** Tools Strength**/
	public static ItemTool.ToolMaterial meteoriteEnum = EnumHelper.addToolMaterial("METEORITE",    2,  331,   4F, 1, 20);
	public static ItemTool.ToolMaterial copperEnum = EnumHelper.addToolMaterial("COPPER",          2,  446,   5F, 1, 14);
	public static ItemTool.ToolMaterial invisiumEnum = EnumHelper.addToolMaterial("INVISIUM",      3,  538,   6F, 1, 12);
	public static ItemTool.ToolMaterial sapphireEnum = EnumHelper.addToolMaterial("SAPPHIRE",      4,  601,   7F, 2, 13);
	public static ItemTool.ToolMaterial adamiteEnum = EnumHelper.addToolMaterial("ADAMITE",        4,  861,   8F, 2, 12);
	public static ItemTool.ToolMaterial rubyEnum = EnumHelper.addToolMaterial("RUBY",              5, 1011, 8.5F, 3, 12);
	public static ItemTool.ToolMaterial zectiumEnum = EnumHelper.addToolMaterial("ZECTIUM",        7, 1701,  10F, 4,  9);
	public static ItemTool.ToolMaterial tapaziteEnum = EnumHelper.addToolMaterial("TAPAZITE",      8, 1936,  12F, 5,  8);
	public static ItemTool.ToolMaterial crystalEnum = EnumHelper.addToolMaterial("CRYSTAL",        9, 2066,  14F, 6,  8);
	public static ItemTool.ToolMaterial osmoniumEnum = EnumHelper.addToolMaterial("OSMONIUM",     10, 2581,  10F, 4,  7);
	public static ItemTool.ToolMaterial enderEnum = EnumHelper.addToolMaterial("ENDER",           11, 2239,  15F, 7,  6);
	public static ItemTool.ToolMaterial starconiumEnum = EnumHelper.addToolMaterial("STARCONIUM", 11, 3001,  16F, 8,  6);
	public static ItemTool.ToolMaterial starhammerEnum = EnumHelper.addToolMaterial("STARHAMMER", 11, 1066,  65F, 8,  6);

	/** Armor Strength**/
	public static ItemArmor.ArmorMaterial MeteoriteArmor = EnumHelper.addArmorMaterial("METEORITE", 5, new int[]    {1,  3,  2, 1}, 20);//Immune to lava and fire
	public static ItemArmor.ArmorMaterial CopperArmor = EnumHelper.addArmorMaterial("COPPER", 14, new int[]         {1,  5,  3, 1}, 14);
	public static ItemArmor.ArmorMaterial SapphireArmor = EnumHelper.addArmorMaterial("SAPPHIRE", 17, new int[]     {2,  6,  4, 2}, 13);
	public static ItemArmor.ArmorMaterial InvisiumArmor = EnumHelper.addArmorMaterial("INVISIUM", 10, new int[]     {1,  4,  3, 1}, 10);//Gives the player the Invisium Effect
	public static ItemArmor.ArmorMaterial AdamiteArmor = EnumHelper.addArmorMaterial("ADAMITE", 21, new int[]       {2,  5,  4, 2}, 13);//Can stay underwater longer
	public static ItemArmor.ArmorMaterial RubyArmor = EnumHelper.addArmorMaterial("RUBY", 25, new int[]             {3,  7,  5, 3}, 12);
	public static ItemArmor.ArmorMaterial ZectiumArmor = EnumHelper.addArmorMaterial("ZECTIUM", 38, new int[]       {4,  9,  7, 4},  9);
	public static ItemArmor.ArmorMaterial TapaziteArmor = EnumHelper.addArmorMaterial("TAPAZITE", 42, new int[]     {5, 10,  8, 5},  8);//Is Blast resistant, but makes you walk slower
	public static ItemArmor.ArmorMaterial CrystalArmor = EnumHelper.addArmorMaterial("CRYSTAL", 45, new int[]       {6, 11,  9, 6},  8);
	public static ItemArmor.ArmorMaterial OsmoniumArmor = EnumHelper.addArmorMaterial("OSMONIUM", 48, new int[]     {3,  6,  5, 3},  7);//Makes you faster, but is not as protective
	public static ItemArmor.ArmorMaterial EnderArmor = EnumHelper.addArmorMaterial("ENDER", 43, new int[]           {2,  4,  3, 2},  6);//Is fall damage proof
	public static ItemArmor.ArmorMaterial StarconiumArmor = EnumHelper.addArmorMaterial("STARCONIUM", 53, new int[] {8, 13, 11, 8},  6);


	public static void setProperties(ItemList il, ItemNames in)
	{
		il.meteorite_coal = new BasicItem().setTextureName(in.METEORITE_COAL_PATH).setUnlocalizedName(in.METEORITE_COAL_PATH);
		il.meteorite_gem = new BasicItem().setTextureName(in.METEORITE_GEM_PATH).setUnlocalizedName(in.METEORITE_GEM_PATH);
		il.copper_ingot = new BasicItem().setTextureName(in.COPPER_INGOT_PATH).setUnlocalizedName(in.COPPER_INGOT_PATH);
		il.sapphire_gem = new BasicItem().setTextureName(in.SAPPHIRE_GEM_PATH).setUnlocalizedName(in.SAPPHIRE_GEM_PATH);
		il.adamite_shard = new BasicItem().setTextureName(in.ADAMITE_SHARD_PATH).setUnlocalizedName(in.ADAMITE_SHARD_PATH);
		il.ruby_gem = new BasicItem().setTextureName(in.RUBY_GEM_PATH).setUnlocalizedName(in.RUBY_GEM_PATH);
		il.fools_ruby_gem = new BasicItem().setTextureName(in.FOOLS_RUBY_GEM_PATH).setUnlocalizedName(in.FOOLS_RUBY_GEM_PATH);
		il.zectium_ingot = new BasicItem().setTextureName(in.ZECTIUM_INGOT_PATH).setUnlocalizedName(in.ZECTIUM_INGOT_PATH);
		il.tapazite_gem = new BasicItem().setTextureName(in.TAPAZITE_GEM_PATH).setUnlocalizedName(in.TAPAZITE_GEM_PATH);
		il.crystal_shard = new BasicItem().setTextureName(in.CRYSTAL_SHARD_PATH).setUnlocalizedName(in.CRYSTAL_SHARD_PATH);
		il.osmonium_ingot = new BasicItem().setTextureName(in.OSMONIUM_INGOT_PATH).setUnlocalizedName(in.OSMONIUM_INGOT_PATH);
		il.starconium_gem = new BasicItem().setTextureName(in.STARCONIUM_GEM_PATH).setUnlocalizedName(in.STARCONIUM_GEM_PATH);
		il.demonite_orb = new BasicItem().setTextureName(in.DEMONITE_ORB_PATH).setUnlocalizedName(in.DEMONITE_ORB_PATH);
		il.experium_orb = new BasicItem().setTextureName(in.EXPERIUM_ORB_PATH).setUnlocalizedName(in.EXPERIUM_ORB_PATH);
		il.ender_gem = new BasicItem().setTextureName(in.ENDER_GEM_PATH).setUnlocalizedName(in.ENDER_GEM_PATH);
		il.darkstone_ingot = new BasicItem().setTextureName(in.DARKSTONE_INGOT_PATH).setUnlocalizedName(in.DARKSTONE_INGOT_PATH);
		il.invisium_ingot = new BasicItem().setTextureName(in.INVISIUM_INGOT_PATH).setUnlocalizedName(in.INVISIUM_INGOT_PATH);
		il.ultra_gem = new BasicItem().setTextureName(in.ULTRA_GEM_PATH).setUnlocalizedName(in.ULTRA_GEM_PATH);
		il.white_luminite_crystal = new BasicItem().setTextureName(in.WHITE_LUMINITE_CRYSTAL_PATH).setUnlocalizedName(in.WHITE_LUMINITE_CRYSTAL_PATH);
		il.starconium_shard = new BasicItem().setTextureName(in.STARCONIUM_SHARD_PATH).setUnlocalizedName(in.STARCONIUM_SHARD_PATH);
		il.fools_ruby_mush = new BasicItem().setTextureName(in.FOOLS_RUBY_MUSH_PATH).setUnlocalizedName(in.FOOLS_RUBY_MUSH_PATH);
		
		il.copper_rod = new BasicItem().setTextureName(in.COPPER_ROD_PATH).setUnlocalizedName(in.COPPER_ROD_PATH);
		il.sapphire_rod = new BasicItem().setTextureName(in.SAPPHIRE_ROD_PATH).setUnlocalizedName(in.SAPPHIRE_ROD_PATH);
		il.adamite_rod = new BasicItem().setTextureName(in.ADAMITE_ROD_PATH).setUnlocalizedName(in.ADAMITE_ROD_PATH);
		il.meteorite_rod = new BasicItem().setTextureName(in.METEORITE_ROD_PATH).setUnlocalizedName(in.METEORITE_ROD_PATH);
		il.ruby_rod = new BasicItem().setTextureName(in.RUBY_ROD_PATH).setUnlocalizedName(in.RUBY_ROD_PATH);
		il.zectium_rod = new BasicItem().setTextureName(in.ZECTIUM_ROD_PATH).setUnlocalizedName(in.ZECTIUM_ROD_PATH);
		il.tapazite_rod = new BasicItem().setTextureName(in.TAPAZITE_ROD_PATH).setUnlocalizedName(in.TAPAZITE_ROD_PATH);
		il.crystal_rod = new BasicItem().setTextureName(in.CRYSTAL_ROD_PATH).setUnlocalizedName(in.CRYSTAL_ROD_PATH);
		il.osmonium_rod = new BasicItem().setTextureName(in.OSMONIUM_ROD_PATH).setUnlocalizedName(in.OSMONIUM_ROD_PATH);
		il.starconium_rod = new BasicItem().setTextureName(in.STARCONIUM_ROD_PATH).setUnlocalizedName(in.STARCONIUM_ROD_PATH);
		il.invisium_rod = new BasicItem().setTextureName(in.INVISIUM_ROD_PATH).setUnlocalizedName(in.INVISIUM_ROD_PATH);
		il.ender_rod = new BasicItem().setTextureName(in.ENDER_ROD_PATH).setUnlocalizedName(in.ENDER_ROD_PATH);
		
		il.meteorite_bow = new Bow(331).setTextureName(in.METEORITE_BOW_PATH).setUnlocalizedName(in.METEORITE_BOW_PATH);
	    il.copper_bow = new Bow(446).setTextureName(in.COPPER_BOW_PATH).setUnlocalizedName(in.COPPER_BOW_PATH);
	    il.invisium_bow = new Bow(538).setTextureName(in.INVISIUM_BOW_PATH).setUnlocalizedName(in.INVISIUM_BOW_PATH);
	    il.sapphire_bow = new Bow(601).setTextureName(in.SAPPHIRE_BOW_PATH).setUnlocalizedName(in.SAPPHIRE_BOW_PATH);
	    il.adamite_bow = new Bow(861).setTextureName(in.ADAMITE_BOW_PATH).setUnlocalizedName(in.ADAMITE_BOW_PATH);
	    il.ruby_bow = new Bow(1011).setTextureName(in.RUBY_BOW_PATH).setUnlocalizedName(in.RUBY_BOW_PATH);
	    il.zectium_bow = new Bow(1701).setTextureName(in.ZECTIUM_BOW_PATH).setUnlocalizedName(in.ZECTIUM_BOW_PATH);
	    il.tapazite_bow = new Bow(1936).setTextureName(in.TAPAZITE_BOW_PATH).setUnlocalizedName(in.TAPAZITE_BOW_PATH);
	    il.crystal_bow = new Bow(2066).setTextureName(in.CRYSTAL_BOW_PATH).setUnlocalizedName(in.CRYSTAL_BOW_PATH);
	    il.osmonium_bow = new Bow(2581).setTextureName(in.OSMONIUM_BOW_PATH).setUnlocalizedName(in.OSMONIUM_BOW_PATH);
	    il.ender_bow = new Bow(2239).setTextureName(in.ENDER_BOW_PATH).setUnlocalizedName(in.ENDER_BOW_PATH);
	    il.starconium_bow = new Bow(3001).setTextureName(in.STARCONIUM_BOW_PATH).setUnlocalizedName(in.STARCONIUM_BOW_PATH);
	    
	    il.meteorite_arrow = new BasicItem().setTextureName(in.METEORITE_ARROW_PATH).setUnlocalizedName(in.METEORITE_ARROW_PATH).setCreativeTab(TabList.COCombat);
	    il.copper_arrow = new BasicItem().setTextureName(in.COPPER_ARROW_PATH).setUnlocalizedName(in.COPPER_ARROW_PATH).setCreativeTab(TabList.COCombat);
	    il.invisium_arrow = new BasicItem().setTextureName(in.INVISIUM_ARROW_PATH).setUnlocalizedName(in.INVISIUM_ARROW_PATH).setCreativeTab(TabList.COCombat);
	    il.sapphire_arrow = new BasicItem().setTextureName(in.SAPPHIRE_ARROW_PATH).setUnlocalizedName(in.SAPPHIRE_ARROW_PATH).setCreativeTab(TabList.COCombat);
	    il.adamite_arrow = new BasicItem().setTextureName(in.ADAMITE_ARROW_PATH).setUnlocalizedName(in.ADAMITE_ARROW_PATH).setCreativeTab(TabList.COCombat);
	    il.ruby_arrow = new BasicItem().setTextureName(in.RUBY_ARROW_PATH).setUnlocalizedName(in.RUBY_ARROW_PATH).setCreativeTab(TabList.COCombat);
	    il.zectium_arrow = new BasicItem().setTextureName(in.ZECTIUM_ARROW_PATH).setUnlocalizedName(in.ZECTIUM_ARROW_PATH).setCreativeTab(TabList.COCombat);
	    il.tapazite_arrow = new BasicItem().setTextureName(in.TAPAZITE_ARROW_PATH).setUnlocalizedName(in.TAPAZITE_ARROW_PATH).setCreativeTab(TabList.COCombat);
	    il.crystal_arrow = new BasicItem().setTextureName(in.CRYSTAL_ARROW_PATH).setUnlocalizedName(in.CRYSTAL_ARROW_PATH).setCreativeTab(TabList.COCombat);
	    il.osmonium_arrow = new BasicItem().setTextureName(in.OSMONIUM_ARROW_PATH).setUnlocalizedName(in.OSMONIUM_ARROW_PATH).setCreativeTab(TabList.COCombat);
	    il.ender_arrow = new BasicItem().setTextureName(in.ENDER_ARROW_PATH).setUnlocalizedName(in.ENDER_ARROW_PATH).setCreativeTab(TabList.COCombat);
	    il.starconium_arrow = new BasicItem().setTextureName(in.STARCONIUM_ARROW_PATH).setUnlocalizedName(in.STARCONIUM_ARROW_PATH).setCreativeTab(TabList.COCombat);
		
		il.copper_bucket_empty = new Bucket(Blocks.air).setTextureName(in.COPPER_BUCKET_EMPTY_PATH).setUnlocalizedName(in.COPPER_BUCKET_EMPTY_PATH);
	    il.copper_bucket_water = new Bucket(Blocks.flowing_water).setTextureName(in.COPPER_BUCKET_WATER_PATH).setUnlocalizedName(in.COPPER_BUCKET_WATER_PATH).setContainerItem(ItemList.copper_bucket_empty);
	    il.copper_bucket_lava = new Bucket(Blocks.flowing_lava).setTextureName(in.COPPER_BUCKET_LAVA_PATH).setUnlocalizedName(in.COPPER_BUCKET_LAVA_PATH).setContainerItem(ItemList.copper_bucket_empty);

		il.meteorite_pickaxe = new Pickaxe(meteoriteEnum).setTextureName(in.METEORITE_PICKAXE_PATH).setUnlocalizedName(in.METEORITE_PICKAXE_PATH);
		il.copper_pickaxe = new Pickaxe(copperEnum).setTextureName(in.COPPER_PICKAXE_PATH).setUnlocalizedName(in.COPPER_PICKAXE_PATH);
		il.sapphire_pickaxe = new Pickaxe(sapphireEnum).setTextureName(in.SAPPHIRE_PICKAXE_PATH).setUnlocalizedName(in.SAPPHIRE_PICKAXE_PATH);
		il.adamite_pickaxe = new Pickaxe(adamiteEnum).setTextureName(in.ADAMITE_PICKAXE_PATH).setUnlocalizedName(in.ADAMITE_PICKAXE_PATH);
		il.ruby_pickaxe = new Pickaxe(rubyEnum).setTextureName(in.RUBY_PICKAXE_PATH).setUnlocalizedName(in.RUBY_PICKAXE_PATH);
		il.zectium_pickaxe = new Pickaxe(zectiumEnum).setTextureName(in.ZECTIUM_PICKAXE_PATH).setUnlocalizedName(in.ZECTIUM_PICKAXE_PATH);
		il.tapazite_pickaxe = new Pickaxe(tapaziteEnum).setTextureName(in.TAPAZITE_PICKAXE_PATH).setUnlocalizedName(in.TAPAZITE_PICKAXE_PATH);
		il.crystal_pickaxe = new Pickaxe(crystalEnum).setTextureName(in.CRYSTAL_PICKAXE_PATH).setUnlocalizedName(in.CRYSTAL_PICKAXE_PATH);
		il.osmonium_pickaxe = new Pickaxe(osmoniumEnum).setTextureName(in.OSMONIUM_PICKAXE_PATH).setUnlocalizedName(in.OSMONIUM_PICKAXE_PATH);
		il.starconium_pickaxe = new Pickaxe(starconiumEnum).setTextureName(in.STARCONIUM_PICKAXE_PATH).setUnlocalizedName(in.STARCONIUM_PICKAXE_PATH);
		il.invisium_pickaxe = new Pickaxe(invisiumEnum).setTextureName(in.INVISIUM_PICKAXE_PATH).setUnlocalizedName(in.INVISIUM_PICKAXE_PATH);
		il.ender_pickaxe = new Pickaxe(enderEnum).setTextureName(in.ENDER_PICKAXE_PATH).setUnlocalizedName(in.ENDER_PICKAXE_PATH);
		
		il.meteorite_axe = new Axe(meteoriteEnum).setTextureName(in.METEORITE_AXE_PATH).setUnlocalizedName(in.METEORITE_AXE_PATH);
		il.copper_axe = new Axe(copperEnum).setTextureName(in.COPPER_AXE_PATH).setUnlocalizedName(in.COPPER_AXE_PATH);
		il.sapphire_axe = new Axe(sapphireEnum).setTextureName(in.SAPPHIRE_AXE_PATH).setUnlocalizedName(in.SAPPHIRE_AXE_PATH);
		il.adamite_axe = new Axe(adamiteEnum).setTextureName(in.ADAMITE_AXE_PATH).setUnlocalizedName(in.ADAMITE_AXE_PATH);
		il.ruby_axe = new Axe(rubyEnum).setTextureName(in.RUBY_AXE_PATH).setUnlocalizedName(in.RUBY_AXE_PATH);
		il.zectium_axe = new Axe(zectiumEnum).setTextureName(in.ZECTIUM_AXE_PATH).setUnlocalizedName(in.ZECTIUM_AXE_PATH);
		il.tapazite_axe = new Axe(tapaziteEnum).setTextureName(in.TAPAZITE_AXE_PATH).setUnlocalizedName(in.TAPAZITE_AXE_PATH);
		il.crystal_axe = new Axe(crystalEnum).setTextureName(in.CRYSTAL_AXE_PATH).setUnlocalizedName(in.CRYSTAL_AXE_PATH);
		il.osmonium_axe = new Axe(osmoniumEnum).setTextureName(in.OSMONIUM_AXE_PATH).setUnlocalizedName(in.OSMONIUM_AXE_PATH);
		il.starconium_axe = new Axe(starconiumEnum).setTextureName(in.STARCONIUM_AXE_PATH).setUnlocalizedName(in.STARCONIUM_AXE_PATH);
		il.invisium_axe = new Axe(invisiumEnum).setTextureName(in.INVISIUM_AXE_PATH).setUnlocalizedName(in.INVISIUM_AXE_PATH);
		il.ender_axe = new Axe(enderEnum).setTextureName(in.ENDER_AXE_PATH).setUnlocalizedName(in.ENDER_AXE_PATH);

		il.meteorite_shovel = new Shovel(meteoriteEnum).setTextureName(in.METEORITE_SHOVEL_PATH).setUnlocalizedName(in.METEORITE_SHOVEL_PATH);
		il.copper_shovel = new Shovel(copperEnum).setTextureName(in.COPPER_SHOVEL_PATH).setUnlocalizedName(in.COPPER_SHOVEL_PATH);
		il.sapphire_shovel = new Shovel(sapphireEnum).setTextureName(in.SAPPHIRE_SHOVEL_PATH).setUnlocalizedName(in.SAPPHIRE_SHOVEL_PATH);
		il.adamite_shovel = new Shovel(adamiteEnum).setTextureName(in.ADAMITE_SHOVEL_PATH).setUnlocalizedName(in.ADAMITE_SHOVEL_PATH);
		il.ruby_shovel = new Shovel(rubyEnum).setTextureName(in.RUBY_SHOVEL_PATH).setUnlocalizedName(in.RUBY_SHOVEL_PATH);
		il.zectium_shovel = new Shovel(zectiumEnum).setTextureName(in.ZECTIUM_SHOVEL_PATH).setUnlocalizedName(in.ZECTIUM_SHOVEL_PATH);
		il.tapazite_shovel = new Shovel(tapaziteEnum).setTextureName(in.TAPAZITE_SHOVEL_PATH).setUnlocalizedName(in.TAPAZITE_SHOVEL_PATH);
		il.crystal_shovel = new Shovel(crystalEnum).setTextureName(in.CRYSTAL_SHOVEL_PATH).setUnlocalizedName(in.CRYSTAL_SHOVEL_PATH);
		il.osmonium_shovel = new Shovel(osmoniumEnum).setTextureName(in.OSMONIUM_SHOVEL_PATH).setUnlocalizedName(in.OSMONIUM_SHOVEL_PATH);
		il.starconium_shovel = new Shovel(starconiumEnum).setTextureName(in.STARCONIUM_SHOVEL_PATH).setUnlocalizedName(in.STARCONIUM_SHOVEL_PATH);
		il.invisium_shovel = new Shovel(invisiumEnum).setTextureName(in.INVISIUM_SHOVEL_PATH).setUnlocalizedName(in.INVISIUM_SHOVEL_PATH);
		il.ender_shovel = new Shovel(enderEnum).setTextureName(in.ENDER_SHOVEL_PATH).setUnlocalizedName(in.ENDER_SHOVEL_PATH);
		
		il.meteorite_sword = new Sword(meteoriteEnum).setTextureName(in.METEORITE_SWORD_PATH).setUnlocalizedName(in.METEORITE_SWORD_PATH);
		il.copper_sword = new Sword(copperEnum).setTextureName(in.COPPER_SWORD_PATH).setUnlocalizedName(in.COPPER_SWORD_PATH);
		il.sapphire_sword = new Sword(sapphireEnum).setTextureName(in.SAPPHIRE_SWORD_PATH).setUnlocalizedName(in.SAPPHIRE_SWORD_PATH);
		il.adamite_sword = new Sword(adamiteEnum).setTextureName(in.ADAMITE_SWORD_PATH).setUnlocalizedName(in.ADAMITE_SWORD_PATH);
		il.ruby_sword = new Sword(rubyEnum).setTextureName(in.RUBY_SWORD_PATH).setUnlocalizedName(in.RUBY_SWORD_PATH);
		il.zectium_sword = new Sword(zectiumEnum).setTextureName(in.ZECTIUM_SWORD_PATH).setUnlocalizedName(in.ZECTIUM_SWORD_PATH);
		il.tapazite_sword = new Sword(tapaziteEnum).setTextureName(in.TAPAZITE_SWORD_PATH).setUnlocalizedName(in.TAPAZITE_SWORD_PATH);
		il.crystal_sword = new Sword(crystalEnum).setTextureName(in.CRYSTAL_SWORD_PATH).setUnlocalizedName(in.CRYSTAL_SWORD_PATH);
		il.osmonium_sword = new Sword(osmoniumEnum).setTextureName(in.OSMONIUM_SWORD_PATH).setUnlocalizedName(in.OSMONIUM_SWORD_PATH);
		il.starconium_sword = new Sword(starconiumEnum).setTextureName(in.STARCONIUM_SWORD_PATH).setUnlocalizedName(in.STARCONIUM_SWORD_PATH);
		il.invisium_sword = new Sword(invisiumEnum).setTextureName(in.INVISIUM_SWORD_PATH).setUnlocalizedName(in.INVISIUM_SWORD_PATH);
		il.ender_sword = new Sword(enderEnum).setTextureName(in.ENDER_SWORD_PATH).setUnlocalizedName(in.ENDER_SWORD_PATH);
		
		il.meteorite_hoe = new Hoe(meteoriteEnum).setTextureName(in.METEORITE_HOE_PATH).setUnlocalizedName(in.METEORITE_HOE_PATH);
		il.copper_hoe = new Hoe(copperEnum).setTextureName(in.COPPER_HOE_PATH).setUnlocalizedName(in.COPPER_HOE_PATH);
		il.sapphire_hoe = new Hoe(sapphireEnum).setTextureName(in.SAPPHIRE_HOE_PATH).setUnlocalizedName(in.SAPPHIRE_HOE_PATH);
		il.adamite_hoe = new Hoe(adamiteEnum).setTextureName(in.ADAMITE_HOE_PATH).setUnlocalizedName(in.ADAMITE_HOE_PATH);
		il.ruby_hoe = new Hoe(rubyEnum).setTextureName(in.RUBY_HOE_PATH).setUnlocalizedName(in.RUBY_HOE_PATH);
		il.zectium_hoe = new Hoe(zectiumEnum).setTextureName(in.ZECTIUM_HOE_PATH).setUnlocalizedName(in.ZECTIUM_HOE_PATH);
		il.tapazite_hoe = new Hoe(tapaziteEnum).setTextureName(in.TAPAZITE_HOE_PATH).setUnlocalizedName(in.TAPAZITE_HOE_PATH);
		il.crystal_hoe = new Hoe(crystalEnum).setTextureName(in.CRYSTAL_HOE_PATH).setUnlocalizedName(in.CRYSTAL_HOE_PATH);
		il.osmonium_hoe = new Hoe(osmoniumEnum).setTextureName(in.OSMONIUM_HOE_PATH).setUnlocalizedName(in.OSMONIUM_HOE_PATH);
		il.starconium_hoe = new Hoe(starconiumEnum).setTextureName(in.STARCONIUM_HOE_PATH).setUnlocalizedName(in.STARCONIUM_HOE_PATH);
		il.invisium_hoe = new Hoe(invisiumEnum).setTextureName(in.INVISIUM_HOE_PATH).setUnlocalizedName(in.INVISIUM_HOE_PATH);
		il.ender_hoe = new Hoe(enderEnum).setTextureName(in.ENDER_HOE_PATH).setUnlocalizedName(in.ENDER_HOE_PATH);
		
		il.starconium_sledgehammer = new Sledgehammer(2.0F, starhammerEnum).setTextureName(in.STARCONIUM_SLEDGEHAMMER_PATH).setUnlocalizedName(in.STARCONIUM_SLEDGEHAMMER_PATH);

		il.copper_helmet = new Armor(CopperArmor, 4, 0).setTextureName(in.COPPER_HELMET_PATH).setUnlocalizedName(in.COPPER_HELMET_PATH);
		il.copper_chestplate = new Armor(CopperArmor, 4, 1).setTextureName(in.COPPER_CHESTPLATE_PATH).setUnlocalizedName(in.COPPER_CHESTPLATE_PATH);
		il.copper_leggings = new Armor(CopperArmor, 4, 2).setTextureName(in.COPPER_LEGGINGS_PATH).setUnlocalizedName(in.COPPER_LEGGINGS_PATH);
		il.copper_boots = new Armor(CopperArmor, 4, 3).setTextureName(in.COPPER_BOOTS_PATH).setUnlocalizedName(in.COPPER_BOOTS_PATH);
		
		il.sapphire_helmet = new Armor(SapphireArmor, 4, 0).setTextureName(in.SAPPHIRE_HELMET_PATH).setUnlocalizedName(in.SAPPHIRE_HELMET_PATH);
		il.sapphire_chestplate = new Armor(SapphireArmor, 4, 1).setTextureName(in.SAPPHIRE_CHESTPLATE_PATH).setUnlocalizedName(in.SAPPHIRE_CHESTPLATE_PATH);
		il.sapphire_leggings = new Armor(SapphireArmor, 4, 2).setTextureName(in.SAPPHIRE_LEGGINGS_PATH).setUnlocalizedName(in.SAPPHIRE_LEGGINGS_PATH);
		il.sapphire_boots = new Armor(SapphireArmor, 4, 3).setTextureName(in.SAPPHIRE_BOOTS_PATH).setUnlocalizedName(in.SAPPHIRE_BOOTS_PATH);
		
		il.invisium_helmet = new Armor(InvisiumArmor, 4, 0).setTextureName(in.INVISIUM_HELMET_PATH).setUnlocalizedName(in.INVISIUM_HELMET_PATH);
		il.invisium_chestplate = new Armor(InvisiumArmor, 4, 1).setTextureName(in.INVISIUM_CHESTPLATE_PATH).setUnlocalizedName(in.INVISIUM_CHESTPLATE_PATH);
		il.invisium_leggings = new Armor(InvisiumArmor, 4, 2).setTextureName(in.INVISIUM_LEGGINGS_PATH).setUnlocalizedName(in.INVISIUM_LEGGINGS_PATH);
		il.invisium_boots = new Armor(InvisiumArmor, 4, 3).setTextureName(in.INVISIUM_BOOTS_PATH).setUnlocalizedName(in.INVISIUM_BOOTS_PATH);
		
		il.adamite_helmet = new Armor(AdamiteArmor, 4, 0).setTextureName(in.ADAMITE_HELMET_PATH).setUnlocalizedName(in.ADAMITE_HELMET_PATH);
		il.adamite_chestplate = new Armor(AdamiteArmor, 4, 1).setTextureName(in.ADAMITE_CHESTPLATE_PATH).setUnlocalizedName(in.ADAMITE_CHESTPLATE_PATH);
		il.adamite_leggings = new Armor(AdamiteArmor, 4, 2).setTextureName(in.ADAMITE_LEGGINGS_PATH).setUnlocalizedName(in.ADAMITE_LEGGINGS_PATH);
		il.adamite_boots = new Armor(AdamiteArmor, 4, 3).setTextureName(in.ADAMITE_BOOTS_PATH).setUnlocalizedName(in.ADAMITE_BOOTS_PATH);
		
		il.meteorite_helmet = new Armor(MeteoriteArmor, 4, 0).setTextureName(in.METEORITE_HELMET_PATH).setUnlocalizedName(in.METEORITE_HELMET_PATH);
		il.meteorite_chestplate = new Armor(MeteoriteArmor, 4, 1).setTextureName(in.METEORITE_CHESTPLATE_PATH).setUnlocalizedName(in.METEORITE_CHESTPLATE_PATH);
		il.meteorite_leggings = new Armor(MeteoriteArmor, 4, 2).setTextureName(in.METEORITE_LEGGINGS_PATH).setUnlocalizedName(in.METEORITE_LEGGINGS_PATH);
		il.meteorite_boots = new Armor(MeteoriteArmor, 4, 3).setTextureName(in.METEORITE_BOOTS_PATH).setUnlocalizedName(in.METEORITE_BOOTS_PATH);
		
		il.ruby_helmet = new Armor(RubyArmor, 4, 0).setTextureName(in.RUBY_HELMET_PATH).setUnlocalizedName(in.RUBY_HELMET_PATH);
		il.ruby_chestplate = new Armor(RubyArmor, 4, 1).setTextureName(in.RUBY_CHESTPLATE_PATH).setUnlocalizedName(in.RUBY_CHESTPLATE_PATH);
		il.ruby_leggings = new Armor(RubyArmor, 4, 2).setTextureName(in.RUBY_LEGGINGS_PATH).setUnlocalizedName(in.RUBY_LEGGINGS_PATH);
		il.ruby_boots = new Armor(RubyArmor, 4, 3).setTextureName(in.RUBY_BOOTS_PATH).setUnlocalizedName(in.RUBY_BOOTS_PATH);
		
		il.zectium_helmet = new Armor(ZectiumArmor, 4, 0).setTextureName(in.ZECTIUM_HELMET_PATH).setUnlocalizedName(in.ZECTIUM_HELMET_PATH);
		il.zectium_chestplate = new Armor(ZectiumArmor, 4, 1).setTextureName(in.ZECTIUM_CHESTPLATE_PATH).setUnlocalizedName(in.ZECTIUM_CHESTPLATE_PATH);
		il.zectium_leggings = new Armor(ZectiumArmor, 4, 2).setTextureName(in.ZECTIUM_LEGGINGS_PATH).setUnlocalizedName(in.ZECTIUM_LEGGINGS_PATH);
		il.zectium_boots = new Armor(ZectiumArmor, 4, 3).setTextureName(in.ZECTIUM_BOOTS_PATH).setUnlocalizedName(in.ZECTIUM_BOOTS_PATH);
		
		il.tapazite_helmet = new Armor(TapaziteArmor, 4, 0).setTextureName(in.TAPAZITE_HELMET_PATH).setUnlocalizedName(in.TAPAZITE_HELMET_PATH);
		il.tapazite_chestplate = new Armor(TapaziteArmor, 4, 1).setTextureName(in.TAPAZITE_CHESTPLATE_PATH).setUnlocalizedName(in.TAPAZITE_CHESTPLATE_PATH);
		il.tapazite_leggings = new Armor(TapaziteArmor, 4, 2).setTextureName(in.TAPAZITE_LEGGINGS_PATH).setUnlocalizedName(in.TAPAZITE_LEGGINGS_PATH);
		il.tapazite_boots = new Armor(TapaziteArmor, 4, 3).setTextureName(in.TAPAZITE_BOOTS_PATH).setUnlocalizedName(in.TAPAZITE_BOOTS_PATH);
		
		il.crystal_helmet = new Armor(CrystalArmor, 4, 0).setTextureName(in.CRYSTAL_HELMET_PATH).setUnlocalizedName(in.CRYSTAL_HELMET_PATH);
		il.crystal_chestplate = new Armor(CrystalArmor, 4, 1).setTextureName(in.CRYSTAL_CHESTPLATE_PATH).setUnlocalizedName(in.CRYSTAL_CHESTPLATE_PATH);
		il.crystal_leggings = new Armor(CrystalArmor, 4, 2).setTextureName(in.CRYSTAL_LEGGINGS_PATH).setUnlocalizedName(in.CRYSTAL_LEGGINGS_PATH);
		il.crystal_boots = new Armor(CrystalArmor, 4, 3).setTextureName(in.CRYSTAL_BOOTS_PATH).setUnlocalizedName(in.CRYSTAL_BOOTS_PATH);
		
		il.osmonium_helmet = new Armor(OsmoniumArmor, 4, 0).setTextureName(in.OSMONIUM_HELMET_PATH).setUnlocalizedName(in.OSMONIUM_HELMET_PATH);
		il.osmonium_chestplate = new Armor(OsmoniumArmor, 4, 1).setTextureName(in.OSMONIUM_CHESTPLATE_PATH).setUnlocalizedName(in.OSMONIUM_CHESTPLATE_PATH);
		il.osmonium_leggings = new Armor(OsmoniumArmor, 4, 2).setTextureName(in.OSMONIUM_LEGGINGS_PATH).setUnlocalizedName(in.OSMONIUM_LEGGINGS_PATH);
		il.osmonium_boots = new Armor(OsmoniumArmor, 4, 3).setTextureName(in.OSMONIUM_BOOTS_PATH).setUnlocalizedName(in.OSMONIUM_BOOTS_PATH);
		
		il.ender_helmet = new Armor(EnderArmor, 4, 0).setTextureName(in.ENDER_HELMET_PATH).setUnlocalizedName(in.ENDER_HELMET_PATH);
		il.ender_chestplate = new Armor(EnderArmor, 4, 1).setTextureName(in.ENDER_CHESTPLATE_PATH).setUnlocalizedName(in.ENDER_CHESTPLATE_PATH);
		il.ender_leggings = new Armor(EnderArmor, 4, 2).setTextureName(in.ENDER_LEGGINGS_PATH).setUnlocalizedName(in.ENDER_LEGGINGS_PATH);
		il.ender_boots = new Armor(EnderArmor, 4, 3).setTextureName(in.ENDER_BOOTS_PATH).setUnlocalizedName(in.ENDER_BOOTS_PATH);
		
		il.starconium_helmet = new Armor(StarconiumArmor, 4, 0).setTextureName(in.STARCONIUM_HELMET_PATH).setUnlocalizedName(in.STARCONIUM_HELMET_PATH);
		il.starconium_chestplate = new Armor(StarconiumArmor, 4, 1).setTextureName(in.STARCONIUM_CHESTPLATE_PATH).setUnlocalizedName(in.STARCONIUM_CHESTPLATE_PATH);
		il.starconium_leggings = new Armor(StarconiumArmor, 4, 2).setTextureName(in.STARCONIUM_LEGGINGS_PATH).setUnlocalizedName(in.STARCONIUM_LEGGINGS_PATH);
		il.starconium_boots = new Armor(StarconiumArmor, 4, 3).setTextureName(in.STARCONIUM_BOOTS_PATH).setUnlocalizedName(in.STARCONIUM_BOOTS_PATH);
	}
	
	public static void registerItems(ItemList il, ItemNames in)
	{
		GameRegistry.registerItem(il.meteorite_coal, in.METEORITE_COAL);
		GameRegistry.registerItem(il.meteorite_gem, in.METEORITE_GEM);
		GameRegistry.registerItem(il.copper_ingot, in.COPPER_INGOT);
		GameRegistry.registerItem(il.sapphire_gem, in.SAPPHIRE_GEM);
		GameRegistry.registerItem(il.adamite_shard, in.ADAMITE_SHARD);
		GameRegistry.registerItem(il.ruby_gem, in.RUBY_GEM);
		GameRegistry.registerItem(il.fools_ruby_gem, in.FOOLS_RUBY_GEM);
		GameRegistry.registerItem(il.zectium_ingot, in.ZECTIUM_INGOT);
		GameRegistry.registerItem(il.tapazite_gem, in.TAPAZITE_GEM);
		GameRegistry.registerItem(il.crystal_shard, in.CRYSTAL_SHARD);
		GameRegistry.registerItem(il.osmonium_ingot, in.OSMONIUM_INGOT);
		GameRegistry.registerItem(il.starconium_gem, in.STARCONIUM_GEM);
		GameRegistry.registerItem(il.demonite_orb, in.DEMONITE_ORB);
		GameRegistry.registerItem(il.experium_orb, in.EXPERIUM_ORB);
		GameRegistry.registerItem(il.ender_gem, in.ENDER_GEM);
		GameRegistry.registerItem(il.darkstone_ingot, in.DARKSTONE_INGOT);
		GameRegistry.registerItem(il.invisium_ingot, in.INVISIUM_INGOT);
		GameRegistry.registerItem(il.ultra_gem, in.ULTRA_GEM);
		GameRegistry.registerItem(il.white_luminite_crystal, in.WHITE_LUMINITE_CRYSTAL);
		GameRegistry.registerItem(il.starconium_shard, in.STARCONIUM_SHARD);
		GameRegistry.registerItem(il.fools_ruby_mush, in.FOOLS_RUBY_MUSH);
		
		GameRegistry.registerItem(il.copper_rod, in.COPPER_ROD);
		GameRegistry.registerItem(il.sapphire_rod, in.SAPPHIRE_ROD);
		GameRegistry.registerItem(il.adamite_rod, in.ADAMITE_ROD);
		GameRegistry.registerItem(il.meteorite_rod, in.METEORITE_ROD);
		GameRegistry.registerItem(il.ruby_rod, in.RUBY_ROD);
		GameRegistry.registerItem(il.zectium_rod, in.ZECTIUM_ROD);
		GameRegistry.registerItem(il.tapazite_rod, in.TAPAZITE_ROD);
		GameRegistry.registerItem(il.crystal_rod, in.CRYSTAL_ROD);
		GameRegistry.registerItem(il.osmonium_rod, in.OSMONIUM_ROD);
		GameRegistry.registerItem(il.starconium_rod, in.STARCONIUM_ROD);
		GameRegistry.registerItem(il.invisium_rod, in.INVISIUM_ROD);
		GameRegistry.registerItem(il.ender_rod, in.ENDER_ROD);
		
		GameRegistry.registerItem(il.meteorite_bow, in.METEORITE_BOW);
	    GameRegistry.registerItem(il.copper_bow, in.COPPER_BOW);
	    GameRegistry.registerItem(il.invisium_bow, in.INVISIUM_BOW);
	    GameRegistry.registerItem(il.sapphire_bow, in.SAPPHIRE_BOW);
	    GameRegistry.registerItem(il.adamite_bow, in.ADAMITE_BOW);
	    GameRegistry.registerItem(il.ruby_bow, in.RUBY_BOW);
	    GameRegistry.registerItem(il.zectium_bow, in.ZECTIUM_BOW);
	    GameRegistry.registerItem(il.tapazite_bow, in.TAPAZITE_BOW);
	    GameRegistry.registerItem(il.crystal_bow, in.CRYSTAL_BOW);
	    GameRegistry.registerItem(il.osmonium_bow, in.OSMONIUM_BOW);
	    GameRegistry.registerItem(il.ender_bow, in.ENDER_BOW);
	    GameRegistry.registerItem(il.starconium_bow, in.STARCONIUM_BOW);
	    
	    GameRegistry.registerItem(il.meteorite_arrow, in.METEORITE_ARROW);
	    GameRegistry.registerItem(il.copper_arrow, in.COPPER_ARROW);
	    GameRegistry.registerItem(il.invisium_arrow, in.INVISIUM_ARROW);
	    GameRegistry.registerItem(il.sapphire_arrow, in.SAPPHIRE_ARROW);
	    GameRegistry.registerItem(il.adamite_arrow, in.ADAMITE_ARROW);
	    GameRegistry.registerItem(il.ruby_arrow, in.RUBY_ARROW);
	    GameRegistry.registerItem(il.zectium_arrow, in.ZECTIUM_ARROW);
	    GameRegistry.registerItem(il.tapazite_arrow, in.TAPAZITE_ARROW);
	    GameRegistry.registerItem(il.crystal_arrow, in.CRYSTAL_ARROW);
	    GameRegistry.registerItem(il.osmonium_arrow, in.OSMONIUM_ARROW);
	    GameRegistry.registerItem(il.ender_arrow, in.ENDER_ARROW);
	    GameRegistry.registerItem(il.starconium_arrow, in.STARCONIUM_ARROW);
		
		GameRegistry.registerItem(il.copper_bucket_empty, in.COPPER_BUCKET_EMPTY);
	    GameRegistry.registerItem(il.copper_bucket_water, in.COPPER_BUCKET_WATER);
	    GameRegistry.registerItem(il.copper_bucket_lava, in.COPPER_BUCKET_LAVA);

		GameRegistry.registerItem(il.meteorite_pickaxe, in.METEORITE_PICKAXE);
		GameRegistry.registerItem(il.copper_pickaxe, in.COPPER_PICKAXE);
		GameRegistry.registerItem(il.sapphire_pickaxe, in.SAPPHIRE_PICKAXE);
		GameRegistry.registerItem(il.adamite_pickaxe, in.ADAMITE_PICKAXE);
		GameRegistry.registerItem(il.ruby_pickaxe, in.RUBY_PICKAXE);
		GameRegistry.registerItem(il.zectium_pickaxe, in.ZECTIUM_PICKAXE);
		GameRegistry.registerItem(il.tapazite_pickaxe, in.TAPAZITE_PICKAXE);
		GameRegistry.registerItem(il.crystal_pickaxe, in.CRYSTAL_PICKAXE);
		GameRegistry.registerItem(il.osmonium_pickaxe, in.OSMONIUM_PICKAXE);
		GameRegistry.registerItem(il.starconium_pickaxe, in.STARCONIUM_PICKAXE);
		GameRegistry.registerItem(il.invisium_pickaxe, in.INVISIUM_PICKAXE);
		GameRegistry.registerItem(il.ender_pickaxe, in.ENDER_PICKAXE);
		
		
		GameRegistry.registerItem(il.meteorite_axe, in.METEORITE_AXE);
		GameRegistry.registerItem(il.copper_axe, in.COPPER_AXE);
		GameRegistry.registerItem(il.sapphire_axe, in.SAPPHIRE_AXE);
		GameRegistry.registerItem(il.adamite_axe, in.ADAMITE_AXE);
		GameRegistry.registerItem(il.ruby_axe, in.RUBY_AXE);
		GameRegistry.registerItem(il.zectium_axe, in.ZECTIUM_AXE);
		GameRegistry.registerItem(il.tapazite_axe, in.TAPAZITE_AXE);
		GameRegistry.registerItem(il.crystal_axe, in.CRYSTAL_AXE);
		GameRegistry.registerItem(il.osmonium_axe, in.OSMONIUM_AXE);
		GameRegistry.registerItem(il.starconium_axe, in.STARCONIUM_AXE);
		GameRegistry.registerItem(il.invisium_axe, in.INVISIUM_AXE);
		GameRegistry.registerItem(il.ender_axe, in.ENDER_AXE);

		GameRegistry.registerItem(il.meteorite_shovel, in.METEORITE_SHOVEL);
		GameRegistry.registerItem(il.copper_shovel, in.COPPER_SHOVEL);
		GameRegistry.registerItem(il.sapphire_shovel, in.SAPPHIRE_SHOVEL);
		GameRegistry.registerItem(il.adamite_shovel, in.ADAMITE_SHOVEL);
		GameRegistry.registerItem(il.ruby_shovel, in.RUBY_SHOVEL);
		GameRegistry.registerItem(il.zectium_shovel, in.ZECTIUM_SHOVEL);
		GameRegistry.registerItem(il.tapazite_shovel, in.TAPAZITE_SHOVEL);
		GameRegistry.registerItem(il.crystal_shovel, in.CRYSTAL_SHOVEL);
		GameRegistry.registerItem(il.osmonium_shovel, in.OSMONIUM_SHOVEL);
		GameRegistry.registerItem(il.starconium_shovel, in.STARCONIUM_SHOVEL);
		GameRegistry.registerItem(il.invisium_shovel, in.INVISIUM_SHOVEL);
		GameRegistry.registerItem(il.ender_shovel, in.ENDER_SHOVEL);
		
		GameRegistry.registerItem(il.meteorite_sword, in.METEORITE_SWORD);
		GameRegistry.registerItem(il.copper_sword, in.COPPER_SWORD);
		GameRegistry.registerItem(il.sapphire_sword, in.SAPPHIRE_SWORD);
		GameRegistry.registerItem(il.adamite_sword, in.ADAMITE_SWORD);
		GameRegistry.registerItem(il.ruby_sword, in.RUBY_SWORD);
		GameRegistry.registerItem(il.zectium_sword, in.ZECTIUM_SWORD);
		GameRegistry.registerItem(il.tapazite_sword, in.TAPAZITE_SWORD);
		GameRegistry.registerItem(il.crystal_sword, in.CRYSTAL_SWORD);
		GameRegistry.registerItem(il.osmonium_sword, in.OSMONIUM_SWORD);
		GameRegistry.registerItem(il.starconium_sword, in.STARCONIUM_SWORD);
		GameRegistry.registerItem(il.invisium_sword, in.INVISIUM_SWORD);
		GameRegistry.registerItem(il.ender_sword, in.ENDER_SWORD);
		
		
		GameRegistry.registerItem(il.meteorite_hoe, in.METEORITE_HOE);
		GameRegistry.registerItem(il.copper_hoe, in.COPPER_HOE);
		GameRegistry.registerItem(il.sapphire_hoe, in.SAPPHIRE_HOE);
		GameRegistry.registerItem(il.adamite_hoe, in.ADAMITE_HOE);
		GameRegistry.registerItem(il.ruby_hoe, in.RUBY_HOE);
		GameRegistry.registerItem(il.zectium_hoe, in.ZECTIUM_HOE);
		GameRegistry.registerItem(il.tapazite_hoe, in.TAPAZITE_HOE);
		GameRegistry.registerItem(il.crystal_hoe, in.CRYSTAL_HOE);
		GameRegistry.registerItem(il.osmonium_hoe, in.OSMONIUM_HOE);
		GameRegistry.registerItem(il.starconium_hoe, in.STARCONIUM_HOE);
		GameRegistry.registerItem(il.invisium_hoe, in.INVISIUM_HOE);
		GameRegistry.registerItem(il.ender_hoe, in.ENDER_HOE);
		
		GameRegistry.registerItem(il.starconium_sledgehammer, in.STARCONIUM_SLEDGEHAMMER);

		GameRegistry.registerItem(il.copper_helmet, in.COPPER_HELMET);
		GameRegistry.registerItem(il.copper_chestplate, in.COPPER_CHESTPLATE);
		GameRegistry.registerItem(il.copper_leggings, in.COPPER_LEGGINGS);
		GameRegistry.registerItem(il.copper_boots, in.COPPER_BOOTS);
		
		GameRegistry.registerItem(il.sapphire_helmet, in.SAPPHIRE_HELMET);
		GameRegistry.registerItem(il.sapphire_chestplate, in.SAPPHIRE_CHESTPLATE);
		GameRegistry.registerItem(il.sapphire_leggings, in.SAPPHIRE_LEGGINGS);
		GameRegistry.registerItem(il.sapphire_boots, in.SAPPHIRE_BOOTS);
		
		GameRegistry.registerItem(il.invisium_helmet, in.INVISIUM_HELMET);
		GameRegistry.registerItem(il.invisium_chestplate, in.INVISIUM_CHESTPLATE);
		GameRegistry.registerItem(il.invisium_leggings, in.INVISIUM_LEGGINGS);
		GameRegistry.registerItem(il.invisium_boots, in.INVISIUM_BOOTS);
		
		GameRegistry.registerItem(il.adamite_helmet, in.ADAMITE_HELMET);
		GameRegistry.registerItem(il.adamite_chestplate, in.ADAMITE_CHESTPLATE);
		GameRegistry.registerItem(il.adamite_leggings, in.ADAMITE_LEGGINGS);
		GameRegistry.registerItem(il.adamite_boots, in.ADAMITE_BOOTS);
		
		GameRegistry.registerItem(il.meteorite_helmet, in.METEORITE_HELMET);
		GameRegistry.registerItem(il.meteorite_chestplate, in.METEORITE_CHESTPLATE);
		GameRegistry.registerItem(il.meteorite_leggings, in.METEORITE_LEGGINGS);
		GameRegistry.registerItem(il.meteorite_boots, in.METEORITE_BOOTS);
		
		GameRegistry.registerItem(il.ruby_helmet, in.RUBY_HELMET);
		GameRegistry.registerItem(il.ruby_chestplate, in.RUBY_CHESTPLATE);
		GameRegistry.registerItem(il.ruby_leggings, in.RUBY_LEGGINGS);
		GameRegistry.registerItem(il.ruby_boots, in.RUBY_BOOTS);
		
		GameRegistry.registerItem(il.zectium_helmet, in.ZECTIUM_HELMET);
		GameRegistry.registerItem(il.zectium_chestplate, in.ZECTIUM_CHESTPLATE);
		GameRegistry.registerItem(il.zectium_leggings, in.ZECTIUM_LEGGINGS);
		GameRegistry.registerItem(il.zectium_boots, in.ZECTIUM_BOOTS);
		
		GameRegistry.registerItem(il.tapazite_helmet, in.TAPAZITE_HELMET);
		GameRegistry.registerItem(il.tapazite_chestplate, in.TAPAZITE_CHESTPLATE);
		GameRegistry.registerItem(il.tapazite_leggings, in.TAPAZITE_LEGGINGS);
		GameRegistry.registerItem(il.tapazite_boots, in.TAPAZITE_BOOTS);
		
		GameRegistry.registerItem(il.crystal_helmet, in.CRYSTAL_HELMET);
		GameRegistry.registerItem(il.crystal_chestplate, in.CRYSTAL_CHESTPLATE);
		GameRegistry.registerItem(il.crystal_leggings, in.CRYSTAL_LEGGINGS);
		GameRegistry.registerItem(il.crystal_boots, in.CRYSTAL_BOOTS);
		
		GameRegistry.registerItem(il.osmonium_helmet, in.OSMONIUM_HELMET);
		GameRegistry.registerItem(il.osmonium_chestplate, in.OSMONIUM_CHESTPLATE);
		GameRegistry.registerItem(il.osmonium_leggings, in.OSMONIUM_LEGGINGS);
		GameRegistry.registerItem(il.osmonium_boots, in.OSMONIUM_BOOTS);
		
		GameRegistry.registerItem(il.ender_helmet, in.ENDER_HELMET);
		GameRegistry.registerItem(il.ender_chestplate, in.ENDER_CHESTPLATE);
		GameRegistry.registerItem(il.ender_leggings, in.ENDER_LEGGINGS);
		GameRegistry.registerItem(il.ender_boots, in.ENDER_BOOTS);
		
		GameRegistry.registerItem(il.starconium_helmet, in.STARCONIUM_HELMET);
		GameRegistry.registerItem(il.starconium_chestplate, in.STARCONIUM_CHESTPLATE);
		GameRegistry.registerItem(il.starconium_leggings, in.STARCONIUM_LEGGINGS);
		GameRegistry.registerItem(il.starconium_boots, in.STARCONIUM_BOOTS);
	}
	
}

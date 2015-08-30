package crazyores.packs.core.item;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.manager.pack.COPackManager;
import crazyores.packs.core.event.CoreActionsEvent;
import crazyores.packs.core.tabs.CoreTabList;

public class CoreArmor extends ItemArmor {

	/** Armor Strength**/
	public static ItemArmor.ArmorMaterial COPPER_ARMOR = 			EnumHelper.addArmorMaterial("COPPER", 			14, new int[]	{1,  5,  3, 1}, 	14);
	public static ItemArmor.ArmorMaterial METEORITE_ARMOR = 		EnumHelper.addArmorMaterial("METEORITE", 		 5, new int[]	{1,  3,  2, 1}, 	20);//Immune to lava and fire
	public static ItemArmor.ArmorMaterial SAPPHIRE_ARMOR = 			EnumHelper.addArmorMaterial("SAPPHIRE", 		17, new int[]	{2,  6,  4, 2}, 	13);
	public static ItemArmor.ArmorMaterial INVISIUM_ARMOR = 			EnumHelper.addArmorMaterial("INVISIUM", 		10, new int[]	{1,  4,  3, 1}, 	10);//Gives the player the Invisium Effect
	public static ItemArmor.ArmorMaterial ADAMITE_ARMOR = 			EnumHelper.addArmorMaterial("ADAMITE", 			21, new int[]	{2,  5,  4, 2}, 	13);//Can stay underwater longer
	public static ItemArmor.ArmorMaterial RUBY_ARMOR = 				EnumHelper.addArmorMaterial("RUBY", 			25, new int[]	{3,  7,  5, 3}, 	12);
	public static ItemArmor.ArmorMaterial ZECTIUM_ARMOR = 			EnumHelper.addArmorMaterial("ZECTIUM", 			38, new int[]	{4,  9,  7, 4}, 	 9);//Is Blast resistant, but makes you walk slower
	public static ItemArmor.ArmorMaterial TAPAZITE_ARMOR = 			EnumHelper.addArmorMaterial("TAPAZITE", 		42, new int[]	{5, 10,  8, 5}, 	 8);
	public static ItemArmor.ArmorMaterial OSMONIUM_ARMOR = 			EnumHelper.addArmorMaterial("OSMONIUM", 		48, new int[]	{3,  6,  5, 3}, 	 7);//Makes you faster, but is not as protective
	public static ItemArmor.ArmorMaterial ENDER_ARMOR = 			EnumHelper.addArmorMaterial("ENDER", 			43, new int[]	{8,  9,  6, 5}, 	 6);//Is fall damage proof
	public static ItemArmor.ArmorMaterial STARCONIUM_ARMOR = 		EnumHelper.addArmorMaterial("STARCONIUM", 		53, new int[]	{12, 13, 11, 8}, 	 6);
	
	private String itemUnlocalizedName;
	
	//Default armor index ends at 4. So next armor should start at 5 and so on.
	public CoreArmor(String unlocalizedName, ItemArmor.ArmorMaterial material, int armorIndex, int armorType) {
		super(material, armorIndex, armorType);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CoreTabList.coreArmorTab);
	}
	
	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		if (itemstack.getItem() == CoreItems.meteoriteHelmet || itemstack.getItem() == CoreItems.meteoriteChestplate || itemstack.getItem() == CoreItems.meteoriteBoots) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Meteorite_1.png";
		}
		if (itemstack.getItem() == CoreItems.meteoriteLeggings) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Meteorite_2.png";
		}
		if (itemstack.getItem() == CoreItems.copperHelmet || itemstack.getItem() == CoreItems.copperChestplate || itemstack.getItem() == CoreItems.copperBoots) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Copper_1.png";
		}
		if (itemstack.getItem() == CoreItems.copperLeggings) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Copper_2.png";
		}
		if (itemstack.getItem() == CoreItems.sapphireHelmet || itemstack.getItem() == CoreItems.sapphireChestplate || itemstack.getItem() == CoreItems.sapphireBoots) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Sapphire_1.png";
		}
		if (itemstack.getItem() == CoreItems.sapphireLeggings) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Sapphire_2.png";
		}
		if (itemstack.getItem() == CoreItems.invisiumHelmet || itemstack.getItem() == CoreItems.invisiumChestplate || itemstack.getItem() == CoreItems.invisiumLeggings || itemstack.getItem() == CoreItems.invisiumBoots) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Invisium.png";
		}
		if (itemstack.getItem() == CoreItems.adamiteHelmet || itemstack.getItem() == CoreItems.adamiteChestplate || itemstack.getItem() == CoreItems.adamiteBoots) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Adamite_1.png";
		}
		if (itemstack.getItem() == CoreItems.adamiteLeggings) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Adamite_2.png";
		}
		if (itemstack.getItem() == CoreItems.rubyHelmet || itemstack.getItem() == CoreItems.rubyChestplate || itemstack.getItem() == CoreItems.rubyBoots) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Ruby_1.png";
		}
		if (itemstack.getItem() == CoreItems.rubyLeggings) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Ruby_2.png";
		}
		if (itemstack.getItem() == CoreItems.zectiumHelmet || itemstack.getItem() == CoreItems.zectiumChestplate || itemstack.getItem() == CoreItems.zectiumBoots) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Zectium_1.png";
		}
		if (itemstack.getItem() == CoreItems.zectiumLeggings) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Zectium_2.png";
		}
		if (itemstack.getItem() == CoreItems.tapaziteHelmet || itemstack.getItem() == CoreItems.tapaziteChestplate || itemstack.getItem() == CoreItems.tapaziteBoots) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Tapazite_1.png";
		}
		if (itemstack.getItem() == CoreItems.tapaziteLeggings) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Tapazite_2.png";
		}
		if (itemstack.getItem() == CoreItems.osmoniumHelmet || itemstack.getItem() == CoreItems.osmoniumChestplate || itemstack.getItem() == CoreItems.osmoniumBoots) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Osmonium_1.png";
		}
		if (itemstack.getItem() == CoreItems.osmoniumLeggings) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Osmonium_2.png";
		}
		if (itemstack.getItem() == CoreItems.starconiumHelmet || itemstack.getItem() == CoreItems.starconiumChestplate || itemstack.getItem() == CoreItems.starconiumBoots) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Starconium_1.png";
		}
		if (itemstack.getItem() == CoreItems.starconiumLeggings) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Starconium_2.png";
		}
		if (itemstack.getItem() == CoreItems.enderHelmet || itemstack.getItem() == CoreItems.enderChestplate || itemstack.getItem() == CoreItems.enderBoots) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Ender_1.png";
		}
		if (itemstack.getItem() == CoreItems.enderLeggings) {
			return COPackManager.corePack.getPackID() + ":" + "textures/armor/Ender_2.png";
		}
		return COPackManager.corePack.getPackID() + ":" + "textures/armor/Copper_1.png";
	}
	
	@Override
	public Item setUnlocalizedName(String unlocalizedName) {
		this.itemUnlocalizedName = unlocalizedName;
        return this;
    }
	
	@Override
	public String getUnlocalizedName() {
		return itemUnlocalizedName;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
        return itemUnlocalizedName;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(String.format("%s%s%s", COPackManager.corePack.getPackID(), ":", this.getUnlocalizedName()));
    }
}

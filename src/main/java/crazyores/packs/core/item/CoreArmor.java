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
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.manager.pack.COPackManager;
import crazyores.packs.core.tabs.CoreTabList;

public class CoreArmor extends ItemArmor {

	private String itemUnlocalizedName;
	private boolean invisium = false;
	
	//Default armor index ends at 4. So next armor should start at 5 and so on.
	public CoreArmor(String unlocalizedName, ItemArmor.ArmorMaterial material, int armorIndex, int armorType) {
		super(material, armorIndex, armorType);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CoreTabList.coreArmorTab);
	}
	
	/**
     * Called to tick armor in the armor slot. Override to do something
     *
     * @param world
     * @param player
     * @param itemStack
     */
	@Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
		if ((itemStack.getItem() == CoreItems.invisiumHelmet || itemStack.getItem() == CoreItems.invisiumChestplate || itemStack.getItem() == CoreItems.invisiumLeggings || itemStack.getItem() == CoreItems.invisiumBoots) && !player.isInvisible() && this.getInvisiumEffect()) {
			this.setInvisiumEffect(false);
		}
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
		if (itemstack.getItem() == CoreItems.invisiumHelmet || itemstack.getItem() == CoreItems.invisiumChestplate || itemstack.getItem() == CoreItems.invisiumBoots) {
			if (!this.invisium)
				return COPackManager.corePack.getPackID() + ":" + "textures/armor/Invisium_1.png";
			else if (invisium)
				return COPackManager.corePack.getPackID() + ":" + "textures/armor/Invisium_3.png";
		}
		if (itemstack.getItem() == CoreItems.invisiumLeggings) {
			if (!this.invisium)
				return COPackManager.corePack.getPackID() + ":" + "textures/armor/Invisium_2.png";
			else if (invisium)
				return COPackManager.corePack.getPackID() + ":" + "textures/armor/Invisium_3.png";
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
	
	private int counter = 0;
	public void updateCounter() {
//		System.out.println("INCREMENTING TO: " + counter);
		counter = counter == 60 ? 60 : counter + 1;
	}
	
	public void setInvisiumEffect(boolean effect) {
		
		if (counter != 60) {
			return;
		}
		else {
			invisium = effect;
			counter = 0;
		}
	}

	public boolean getInvisiumEffect() {
		return this.invisium;
	}
}

package crazyores.packs.core.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import crazyores.manager.pack.COPackManager;
import crazyores.manager.support.IName;
import crazyores.packs.core.tabs.CoreTabList;

public class CoreBow extends ItemBow implements IName {

	public static final String[] bowPullIconNameArray = new String[] {"1", "2", "3"};
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
	public String itemUnlocalizedName;
	
	private int enchantibility = 1;
	
	protected CoreBow(String unlocalizedName, int maxUses, int enchantibility) {
		this.setUnlocalizedName(unlocalizedName);
		setCreativeTab(CoreTabList.coreToolsTab);
		this.maxStackSize = 1;
		this.setMaxDamage(maxUses);
		this.enchantibility = enchantibility;
	}
	
	@Override
	public boolean isFull3D()
	{
		return true;
	}
	
	/**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
	@Override
    public int getItemEnchantability()
    {
        return enchantibility;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister registry)
    {
        this.itemIcon = registry.registerIcon(COPackManager.corePack.getPackID() + ":" + this.getUnlocalizedName() + "_0");
        this.iconArray = new IIcon[bowPullIconNameArray.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = registry.registerIcon(COPackManager.corePack.getPackID() + ":" + this.getUnlocalizedName() + "_" + bowPullIconNameArray[i]);
        }
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
		if (player.getItemInUse() == null) {
			return this.itemIcon;
		}
		
		int duration = stack.getMaxItemUseDuration() - useRemaining;
		if (duration >= 18) {
			return this.iconArray[2];
		}
		else if (duration > 13) {
			return this.iconArray[1];
		}
		else if (duration > 0) {
			return this.iconArray[0];
		}
		return this.itemIcon;
	}

    /**
     * used to cycle through icons based on their used duration, i.e. for the bow
     */
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(int stage) {
        return this.iconArray[stage];
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
	
	public int getBowEnhancement() {
		return -1;
	}
}

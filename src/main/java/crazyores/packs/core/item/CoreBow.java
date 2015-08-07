package crazyores.packs.core.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import crazyores.manager.support.IName;
import crazyores.packs.core.tabs.CoreTabList;

public class CoreBow extends ItemBow implements IName {

	public static final String[] bowPullIconNameArray = new String[] {"1", "2", "3"};
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
	public String itemUnlocalizedName;
	
	private ToolMaterial toolMaterial;
	
	protected CoreBow(String unlocalizedName, ToolMaterial material) {
		this.setUnlocalizedName(unlocalizedName);
		toolMaterial = material;
		setCreativeTab(CoreTabList.coreToolsTab);
		this.maxStackSize = 1;
		this.setMaxDamage(toolMaterial.getMaxUses());
	}
	
	/**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
	@Override
    public int getItemEnchantability()
    {
        return toolMaterial.getEnchantability();
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister registry)
    {
        this.itemIcon = registry.registerIcon(this.getIconString() + "_0");
        this.iconArray = new IIcon[bowPullIconNameArray.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = registry.registerIcon(this.getIconString() + "_" + bowPullIconNameArray[i]);
        }
    }

    /**
     * used to cycle through icons based on their used duration, i.e. for the bow
     */
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(int stage)
    {
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
	
}

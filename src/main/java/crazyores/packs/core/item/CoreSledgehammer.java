package crazyores.packs.core.item;

import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.manager.pack.COPackManager;
import crazyores.packs.core.tabs.CoreTabList;

public class CoreSledgehammer extends ItemTool {

	private float damageVsEntity;
	public String itemUnlocalizedName;
	
	public CoreSledgehammer(String unlocalizedName, ToolMaterial material) {
		super(2.0f, material, Block.blockRegistry.getKeys());
		this.damageVsEntity = 4.0F + material.getDamageVsEntity();
		this.setUnlocalizedName(unlocalizedName);
		setCreativeTab(CoreTabList.coreToolsTab);
	}
	
	@Override
	public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
        return this.efficiencyOnProperMaterial;
    }
	
	@Override
	public boolean func_150897_b(Block block)
	{
		if (block != Blocks.leaves && block != Blocks.leaves2 && block != Blocks.snow && block != Blocks.snow_layer)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase p_77644_2_, EntityLivingBase p_77644_3_)
    {
        p_77644_1_.damageItem(1, p_77644_3_);
        return true;
    }
	
	/**
     * returns the action that specifies what animation to play when the items is being used
     */
	@Override
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.block;
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 72000;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
        return p_77659_1_;
    }
	
    @Override
	public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.damageVsEntity, 0));
        return multimap;
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

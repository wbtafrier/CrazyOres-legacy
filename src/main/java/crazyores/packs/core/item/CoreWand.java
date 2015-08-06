package crazyores.packs.core.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import crazyores.manager.tabs.COTabList;


public class CoreWand extends CoreItem {

	private Item.ToolMaterial toolMaterial;
	
	protected CoreWand(String unlocalizedName, Item.ToolMaterial material) {
		super(unlocalizedName, COTabList.crazyOresItemsTab, 1);
		toolMaterial = material;
		setMaxDamage(material.getMaxUses());
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		return true;
    }
	
	@Override
	public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase livingBase) {
        if ((double)block.getBlockHardness(world, x, y, z) != 0.0D) {
        	itemStack.damageItem(3, livingBase);
        }
        return true;
    }
	
	@Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase livingBase1, EntityLivingBase livingBase2) {
		itemStack.damageItem(3, livingBase2);
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
	
	public Item.ToolMaterial getToolMaterial() {
        return toolMaterial;
    }
}

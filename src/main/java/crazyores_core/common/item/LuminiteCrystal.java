package crazyores_core.common.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LuminiteCrystal extends COItem {

//	@SideOnly(Side.CLIENT)
//	private IIcon[] icons;
	
	public LuminiteCrystal() {
		super();
		this.setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int damageValue) {
		return MathHelper.clamp_int(damageValue, 0, ItemNames.LUMINITE_CRYSTAL_SUBTYPES.length - 1);
	}
//	
//	@Override
//	@SideOnly(Side.CLIENT)
//	public void registerIcons(IIconRegister iconRegister) {
//		icons = new IIcon[ItemNames.LUMINITE_CRYSTAL_SUBTYPES.length];
//		
//		for (int i = 0; i < icons.length; i++) {
//			icons[i] = iconRegister.registerIcon(String.format("%s_%s", super.stripName(super.getUnlocalizedName()), ItemNames.LUMINITE_CRYSTAL_SUBTYPES[MathHelper.clamp_int(i, 0, ItemNames.LUMINITE_CRYSTAL_SUBTYPES.length - 1)]));
//		}
//	}
//	
//	@Override
//	@SideOnly(Side.CLIENT)
//	public IIcon getIconFromDamage(int metadata) {
//		return icons[MathHelper.clamp_int(metadata, 0, ItemNames.LUMINITE_CRYSTAL_SUBTYPES.length - 1)];
//	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int metadata = 0; metadata < ItemNames.LUMINITE_CRYSTAL_SUBTYPES.length; metadata++) {
			list.add(new ItemStack(item, 1, metadata));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return super.getUnlocalizedName() + "_" + ItemNames.LUMINITE_CRYSTAL_SUBTYPES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, ItemNames.LUMINITE_CRYSTAL_SUBTYPES.length - 1)];
	}
	
}

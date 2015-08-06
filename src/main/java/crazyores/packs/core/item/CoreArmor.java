package crazyores.packs.core.item;

import net.minecraft.item.ItemArmor;

public class CoreArmor extends ItemArmor {

	//Default armor index ends at 4. So next armor should start at 5 and so on.
	public CoreArmor(ItemArmor.ArmorMaterial material, int armorIndex, int armorType) {
		super(material, armorIndex, armorType);
	}
}

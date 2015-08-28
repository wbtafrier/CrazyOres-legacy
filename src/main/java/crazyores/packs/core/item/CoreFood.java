package crazyores.packs.core.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.manager.pack.COPackManager;
import crazyores.packs.core.tabs.CoreTabList;
import crazyores.packs.core.tabs.CoreTabs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class CoreFood extends ItemFood {

	private String itemUnlocalizedName;

	public CoreFood(String unlocalizedName, int healAmount, float saturationValue, boolean isWolfsFav) {
		super(healAmount, saturationValue, isWolfsFav);
		itemUnlocalizedName = unlocalizedName;
		this.setCreativeTab(CoreTabList.coreFoodTab);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {

        if (this == CoreItems.rawSharkMeat) {
            player.addPotionEffect(new PotionEffect(Potion.confusion.id, 300, 1));
            
            if (world.rand.nextInt(5) == 0) {
            	player.addPotionEffect(new PotionEffect(Potion.poison.id, 400, 2));
                player.addPotionEffect(new PotionEffect(Potion.hunger.id, 300, 2));
            }
        }
        else if (this == CoreItems.cookedSharkMeat) {
        	
        	if (world.rand.nextInt(15) == 0) {
        		player.addPotionEffect(new PotionEffect(Potion.poison.id, 200, 1));
        	}
        	
        	if (world.rand.nextInt(5) == 0) {
        		player.addPotionEffect(new PotionEffect(Potion.confusion.id, 200, 1));
        	}
        }
        super.onFoodEaten(stack, world, player);
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

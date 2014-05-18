package crazyores_core.common.core;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import crazyores_core.common.blocks.BlockList;
import crazyores_core.common.items.ItemList;

/**
 * All CrazyOres event hooks. Triggers certain in-game changes based on events.
 * @author Andy608 and ISQUISHALL - The CrazyOres Team
 *
 */
public class EventHooks
{	
	private static Random eventRand = new Random();
	
	/**
	 * Called by CrazyOres when a player interacts with an entity.
	 * Checks to see if armor has any special properties to take effect, or if a player has a Copper Bucket.
	 * @param event The event (must be EntityInteractEvent) with all details of the interaction, and the entity.
	 */
	@SubscribeEvent
	public void entityRightClicked(EntityInteractEvent event)
	{
		Entity ent = event.target;
		EntityPlayer player = event.entityPlayer;

		if (ent instanceof EntityCow && !ent.worldObj.isRemote)
		{
			EntityCow cow = (EntityCow)ent;
			ItemStack item = player.inventory.getCurrentItem();

			if (cow.interact(player))
			{
				return;
			}
			else if (PackManager.ediblesPackInstalled)
			{
				return;
			}
			else if (item != null && item.getItem() == ItemList.copper_bucket_empty && !player.capabilities.isCreativeMode)
			{
				player.addChatMessage(new ChatComponentText(CrazyOres.instance.getPackChatHeader() + " Install the " + 
						EnumChatFormatting.GREEN + EnumChatFormatting.ITALIC + "Edibles Expansion Pack" + EnumChatFormatting.RESET 
						+ " (when it's released) to fill up your bucket with milk, and get a bunch of other cool features involving food!"/* Click here for the link: "
						+ EnumChatFormatting.RESET +  EnumChatFormatting.GREEN + "http://goo.gl/JbwsNO"*/));
				player.addChatMessage(new ChatComponentText(""));
			}
		}
	}

	/**
	 * Called by CrazyOres when a player is injured. Checks to see if armor has any special properties to take effect.
	 * @param event The event (must be LivingHurtEvent), carries details of player's injury
	 */
	@SubscribeEvent
	public void playerDamaged(LivingHurtEvent event)
	{
		EntityLivingBase ent = event.entityLiving;
		DamageSource damage = event.source;

		if (ent instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)ent;
			ItemStack[] armor = player.inventory.armorInventory;
			
			//Check if player has full set of armor on
			for (int i = 0; i < armor.length; i++)
			{
				if (armor[i] == null)
					return;
			}

			if (armor[0].getItem() == ItemList.meteorite_boots && armor[1].getItem() == ItemList.meteorite_leggings && armor[2].getItem() == ItemList.meteorite_chestplate && armor[3].getItem() == ItemList.meteorite_helmet && (damage.getDamageType().equals("inFire") || damage.getDamageType().equals("onFire") || damage.getDamageType().equals("lava")))
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 1000, 1));
				for (int i = 0; i < armor.length; i++)
				{
					armor[i].attemptDamageItem(5, eventRand);
				}
			}
			else if (armor[0].getItem() == ItemList.tapazite_boots && armor[1].getItem() == ItemList.tapazite_leggings && armor[2].getItem() == ItemList.tapazite_chestplate && armor[3].getItem() == ItemList.tapazite_helmet && (damage.getDamageType().equals("explosion") || damage.getDamageType().equals("explosion.player")))
			{
				event.ammount = 0;
				for (int i = 0; i < armor.length; i++)
				{
					armor[i].attemptDamageItem(10, eventRand);
				}
			}
			else if (armor[0].getItem() == ItemList.adamite_boots && armor[1].getItem() == ItemList.adamite_leggings && armor[2].getItem() == ItemList.adamite_chestplate && armor[3].getItem() == ItemList.adamite_helmet && (damage.getDamageType().equals("drown")))
			{
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 1000, 1));
				for (int i = 0; i < armor.length; i++)
				{
					armor[i].attemptDamageItem(5, eventRand);
				}
			}
			else if (armor[0].getItem() == ItemList.ender_boots && armor[1].getItem() == ItemList.ender_leggings && armor[2].getItem() == ItemList.ender_chestplate && armor[3].getItem() == ItemList.ender_helmet && (damage.getDamageType().equals("fall")))
			{
				float preAmount = event.ammount;
				
				int armorDamage = MathHelper.floor_float(preAmount);
				
				if ((damage.getDamageType().equals("outOfWorld")))
				{
					event.ammount = 4;
				}
				else
				{
					event.ammount = 0;
				}
				
				for (int i = 0; i < armor.length; i++)
				{
					armor[i].attemptDamageItem(armorDamage, eventRand);
				}
			}
		}
	}

	/**
	 * Called by CrazyOres when a player left or right clicks.
	 * Checks to see if armor has any special properties to take effect.
	 * @param event The event with all details of the interaction.
	 */
	
	private static BlockList bl;
	
	@SubscribeEvent
	public void playerInteractsWithBlockAir(PlayerEvent event)
	{
		/*
		 * ==========================================
		 * LEAVE THIS ALONE!!!
		 * SEVERAL HOURS OF HARD WORK.
		 * ==========================================
		 * 
		 */
		
		//Only left and right click events
		if (!(event instanceof PlayerInteractEvent) && !(event instanceof EntityInteractEvent) && !(event instanceof AttackEntityEvent))
			return;

		//Set block harvest levels before mining
		HarvestLevels.addBlockHarvestLevels(bl);
		
		EntityPlayer player = event.entityPlayer;
		ItemStack[] armor = player.inventory.armorInventory;
		
		//Check if player has full set of armor on
		
		boolean full = true;
		
		for (int slot = 0; slot < armor.length; slot++)
		{
			if (armor[slot] == null)
			{
				full = false;
				break;
			}
		}
		
		if (full)
		{
			//Full set of Tapazite makes you slower
			if (armor[0].getItem() == ItemList.tapazite_boots && armor[1].getItem() == ItemList.tapazite_leggings && armor[2].getItem() == ItemList.tapazite_chestplate && armor[3].getItem() == ItemList.tapazite_helmet)
			{
				player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1000, 1));
			}
			//Full set of Osmonium makes you faster
			else if (armor[0].getItem() == ItemList.osmonium_boots && armor[1].getItem() == ItemList.osmonium_leggings && armor[2].getItem() == ItemList.osmonium_chestplate && armor[3].getItem() == ItemList.osmonium_helmet)
			{
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1000, 1));
			}
			//Full set of Invisium gives you the Invisium effect and invisibility.
			//Only PlayerInteractEvent, other events aren't applicable
//			else if (COSettings.invisiumEffect && armor[0].getItem() == ItemList.invisium_boots && armor[1].getItem() == ItemList.invisium_leggings && armor[2].getItem() == ItemList.invisium_chestplate && armor[3].getItem() == ItemList.invisium_helmet && !(event instanceof EntityInteractEvent) && !(event instanceof AttackEntityEvent))
//			{	
//				//Convert to correct subclass
//				PlayerInteractEvent pie = (PlayerInteractEvent)event;
//
//				//Only left-clicking the air toggles the effect
//				if (!pie.action.equals(PlayerInteractEvent.Action.RIGHT_CLICK_AIR)
//					|| player.inventory.getCurrentItem() != null)
//					return;
//
//				//Sort through the armor inventory
//				for (int i = 0; i < armor.length; i++)
//				{
//					Armor slot = (Armor)armor[i].getItem();
//
//					//If no Invisium effect toggle it and change texture
//					if (!slot.getInvisiumEffect())
//					{
//						slot.setInvisiumEffect(true);
//						slot.getArmorTexture(armor[i], player, i, null);
//					}
//					//If Invisium effect toggle it and change texture
//					else if (slot.getInvisiumEffect())
//					{
//						slot.setInvisiumEffect(false);
//						slot.getArmorTexture(armor[i], player, i, null);
//					}
//					
//					if (!player.isPotionActive(Potion.invisibility.id))
//					player.setInvisible(slot.getInvisiumEffect());
//				}
//			}
//			else if (COSettings.invisiumEffect)
//			{
//				for (int i = 0; i < armor.length; i++)
//				{
//					if (armor[i] != null && (armor[i].getItem() == ItemList.invisium_helmet
//						|| armor[i].getItem() == ItemList.invisium_chestplate
//						|| armor[i].getItem() == ItemList.invisium_leggings
//						|| armor[i].getItem() == ItemList.invisium_boots))
//					{
//						Armor slot = (Armor)armor[i].getItem();
//						
//						if (slot.getInvisiumEffect())
//						{
//							slot.setInvisiumEffect(false);
//							slot.getArmorTexture(armor[i], player, i, null);
//						}
//					}
//				}
//				
//				if (!player.isPotionActive(Potion.invisibility.id) && player.isInvisible())
//				{
//					player.setInvisible(false);
//				}
//				
//				for (int i = 0; i < player.inventory.mainInventory.length; i++)
//				{
//					ItemStack[] inv = player.inventory.mainInventory;
//					if (inv[i] != null && (inv[i].getItem() == ItemList.invisium_helmet
//							|| inv[i].getItem() == ItemList.invisium_chestplate
//							|| inv[i].getItem() == ItemList.invisium_leggings
//							|| inv[i].getItem() == ItemList.invisium_boots))
//					{
//						Armor slot = (Armor)inv[i].getItem();
//						
//						if (slot.getInvisiumEffect())
//						{
//							slot.setInvisiumEffect(false);
//						}
//					}
//				}
//			}
//		}
//		else if (COSettings.invisiumEffect)
//		{
//			for (int i = 0; i < armor.length; i++)
//			{
//				if (armor[i] != null && (armor[i].getItem() == ItemList.invisium_helmet
//					|| armor[i].getItem() == ItemList.invisium_chestplate
//					|| armor[i].getItem() == ItemList.invisium_leggings
//					|| armor[i].getItem() == ItemList.invisium_boots))
//				{
//					Armor slot = (Armor)armor[i].getItem();
//					
//					if (slot.getInvisiumEffect())
//					{
//						slot.setInvisiumEffect(false);
//						slot.getArmorTexture(armor[i], player, i, null);
//					}
//				}
//			}
//			
//			if (!player.isPotionActive(Potion.invisibility.id) && player.isInvisible())
//			{
//				player.setInvisible(false);
//			}
//			
//			for (int i = 0; i < player.inventory.mainInventory.length; i++)
//			{
//				ItemStack[] inv = player.inventory.mainInventory;
//				if (inv[i] != null && (inv[i].getItem() == ItemList.invisium_helmet
//						|| inv[i].getItem() == ItemList.invisium_chestplate
//						|| inv[i].getItem() == ItemList.invisium_leggings
//						|| inv[i].getItem() == ItemList.invisium_boots))
//				{
//					Armor slot = (Armor)inv[i].getItem();
//					
//					if (slot.getInvisiumEffect())
//					{
//						slot.setInvisiumEffect(false);
//					}
//				}
//			}
		}
	}
}

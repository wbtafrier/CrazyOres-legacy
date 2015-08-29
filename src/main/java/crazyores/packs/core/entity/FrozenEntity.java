package crazyores.packs.core.entity;

import java.util.UUID;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;

public class FrozenEntity {

	private EntityLivingBase entity;
	private int ticksLeft;
	public static final AttributeModifier slowness = (new AttributeModifier(UUID.fromString("7107DE5E-7CE8-4030-940E-514C1F160891"), "potion.moveFrozenSlowdown", -0.8D, 2));
	
	public FrozenEntity(EntityLivingBase entity, int freezeAmount) {
		this.entity = entity;
		ticksLeft = freezeAmount;
	}
	
	public EntityLivingBase getEntity() {
		return entity;
	}
	
	public void update() {
		ticksLeft--;
	}
	
	public boolean hasTicksLeft() {
		return ticksLeft > 0;
	}
	
	public int getTicks() {
		return ticksLeft;
	}
	
	public void applyModifier(boolean b) {
		
		IAttributeInstance instance = entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
		
		if (b && instance.getModifier(slowness.getID()) == null) {
			entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed).applyModifier(slowness);
			if (entity.isBurning()) entity.extinguish();
			
		}
		else if (instance.getModifier(slowness.getID()) != null) {
			entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed).removeModifier(slowness);
		}
	}
}

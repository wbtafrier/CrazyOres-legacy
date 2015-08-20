package crazyores.packs.core.entity;

import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;

public class FrozenEntity {

	private EntityLivingBase entity;
	private int ticksLeft;
	public static final AttributeModifier slowness = (new AttributeModifier(UUID.fromString("7107DE5E-7CE8-4030-940E-514C1F160890"), "potion.moveSlowdown", -0.5D, 2));
	private boolean isSlow = false;
	
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
		
		if (!isSlow && b) {
			entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed).applyModifier(slowness);
			System.out.println("HELLNFEB");
			isSlow = true;
		}
		else if (isSlow && !b){
			entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed).removeModifier(slowness);
			System.out.println("HELLOSKFOJNE???y" + entity.getEntityId());
			isSlow = false;
		}
	}
	
	public boolean isSlow() {
		return isSlow;
	}
}

package crazyores.packs.core.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityZectiumCore extends EntityThrowable {

	// LEAVE THE F ALONE!!!!! :P
	private float explosionStrength = 3.0F;
	
	public EntityZectiumCore(World world) {
		super(world);
	}
	
	public EntityZectiumCore(World world, EntityLivingBase entity) {
		super(world, entity);
	}
	
	public EntityZectiumCore(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	@Override
	protected void onImpact(MovingObjectPosition obj) {
		if (obj.entityHit != null) {
			double entX = obj.entityHit.posX;
			double entY = obj.entityHit.posY;
			double entZ = obj.entityHit.posZ;
			this.worldObj.createExplosion(this, (int)entX, (int)entY, (int)entZ, explosionStrength, true);
		}
		else {
			this.worldObj.createExplosion(this, obj.blockX, obj.blockY, obj.blockZ, explosionStrength, true);
		}
		
		if (!this.worldObj.isRemote) {
			this.setDead();
		}
	}

}

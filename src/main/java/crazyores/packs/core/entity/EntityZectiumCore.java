package crazyores.packs.core.entity;

import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.packs.core.config.COCoreConfigSettings;

public class EntityZectiumCore extends EntityThrowable {

	private float explosionStrength = 4.0f;
	
	@SideOnly(Side.CLIENT)
	public EntityZectiumCore(World world) {
		super(world);
	}
	
	@SideOnly(Side.CLIENT)
	public EntityZectiumCore(World world, EntityLivingBase entity) {
		super(world, entity);
	}
	
	@SideOnly(Side.CLIENT)
	public EntityZectiumCore(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	@Override
	protected void onImpact(MovingObjectPosition obj) {
		
		if (!this.worldObj.isRemote) {
            if (obj.entityHit != null) {
            	double entX = obj.entityHit.posX;
    			double entY = obj.entityHit.posY;
    			double entZ = obj.entityHit.posZ;
    			if (COCoreConfigSettings.zectiumCoreExplodes)
    				this.worldObj.createExplosion(this, (int)entX, (int)entY, (int)entZ, explosionStrength, false);
//    			else
//    				this.worldObj.playSoundEffect(entX, entY, entZ, "random.explode", 4.0F, (1.0F + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2F) * 0.7F);
            }

            if (COCoreConfigSettings.zectiumCoreExplodes)
            	this.worldObj.newExplosion((Entity)null, this.posX, this.posY, this.posZ, explosionStrength, false, true);
//          else
//            	this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 4.0F, (1.0F + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2F) * 0.7F);
            this.setDead();
        }
	}
}

package crazyores_core.common.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.IThrowableEntity;

public class EntityStarconiumArrow extends EntityArrows implements IThrowableEntity
{

	public EntityStarconiumArrow(World par1World)
	{
		super(par1World);
		this.setUniqueProperties();
	}
	
	public EntityStarconiumArrow(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5)
	{
		super(par1World, par2EntityLivingBase, par3EntityLivingBase, par4, par5);
		this.setUniqueProperties();
	}
	
	public EntityStarconiumArrow(World par1World, EntityLivingBase par2EntityLivingBase, float par3)
	{
		super(par1World, par2EntityLivingBase, par3);
		this.setUniqueProperties();
	}
	
	public void setUniqueProperties()
	{
		this.setName("starconium");
		this.setDamage(6.5D);
	}
	
}

package crazyores_core.common.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.IThrowableEntity;

public class EntityInvisiumArrow extends EntityArrows implements IThrowableEntity
{

	public EntityInvisiumArrow(World par1World)
	{
		super(par1World);
		setUniqueProperties();
	}
	
	public EntityInvisiumArrow(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5)
	{
		super(par1World, par2EntityLivingBase, par3EntityLivingBase, par4, par5);
		setUniqueProperties();
	}
	
	public EntityInvisiumArrow(World par1World, EntityLivingBase par2EntityLivingBase, float par3)
	{
		super(par1World, par2EntityLivingBase, par3);
		setUniqueProperties();
	}
	
	public void setUniqueProperties()
	{
		this.setName("invisium");
		this.setDamage(3.0D);
	}
	
}

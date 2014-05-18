package crazyores_core.common.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.IThrowableEntity;

public class EntityCrystalArrow extends EntityArrows implements IThrowableEntity
{

	public EntityCrystalArrow(World par1World)
	{
		super(par1World);
		this.setUniqueProperties();
	}
	
	public EntityCrystalArrow(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5)
	{
		super(par1World, par2EntityLivingBase, par3EntityLivingBase, par4, par5);
		this.setUniqueProperties();
	}
	
	public EntityCrystalArrow(World par1World, EntityLivingBase par2EntityLivingBase, float par3)
	{
		super(par1World, par2EntityLivingBase, par3);
		setUniqueProperties();
	}
	
	public void setUniqueProperties()
	{
		this.setName("crystal");
		this.setDamage(5.5D);
	}
}

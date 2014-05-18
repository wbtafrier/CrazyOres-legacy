package crazyores_core.common.entity;

import crazyores_core.common.items.ItemList;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityAdamiteGolem extends EntityGolems
{	
	public EntityAdamiteGolem(World par1World)
	{
		this(par1World, ItemList.adamite_shard);
	}
	
	public EntityAdamiteGolem(World par1World, Item d)
	{
		super(par1World, d);
		this.setSize(1.4F, 3.1F);
	}
	
	@Override
	protected void applyUniqueProperties()
	{
		this.setName("adamite");
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(130.0D);
        
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }
}

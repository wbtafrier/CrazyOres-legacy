package crazyores_core.common.entity;

import crazyores_core.common.items.ItemList;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityDemoniteGolem extends EntityGolems
{
	public EntityDemoniteGolem(World par1World)
	{
		this(par1World, ItemList.demonite_orb);
	}
	
	public EntityDemoniteGolem(World par1World, Item d)
	{
		super(par1World, d);
		this.setSize(1.9F, 3.4F);
	}
	
	@Override
	protected void applyUniqueProperties()
	{
		this.setName("demonite");
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0D);
        
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }
}

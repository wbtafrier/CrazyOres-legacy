package crazyores_core.common.entity;

import crazyores_core.common.items.ItemList;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityTapaziteGolem extends EntityGolems
{

	public EntityTapaziteGolem(World par1World)
	{
		this(par1World, ItemList.tapazite_gem);
	}
	
	public EntityTapaziteGolem(World par1World, Item d)
	{
		super(par1World, d);
		this.setSize(1.8F, 3.9F);
	}
	
	@Override
	protected void applyUniqueProperties()
	{
		this.setName("tapazite");
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(180.0D);
        
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }
}

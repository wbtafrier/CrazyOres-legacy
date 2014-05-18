package crazyores_core.common.entity;

import crazyores_core.common.items.ItemList;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityOsmoniumGolem extends EntityGolems
{	
	public EntityOsmoniumGolem(World par1World)
	{
		this(par1World, ItemList.osmonium_ingot);
	}
	
	public EntityOsmoniumGolem(World par1World, Item d)
	{
		super(par1World, d);
		this.setSize(2.2F, 4.4F);
	}
	
	@Override
	protected void applyUniqueProperties()
	{
		this.setName("osmonium");
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0D);
        
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }
}

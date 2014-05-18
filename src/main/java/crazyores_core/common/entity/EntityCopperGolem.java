package crazyores_core.common.entity;

import crazyores_core.common.items.ItemList;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityCopperGolem extends EntityGolems
{
	public EntityCopperGolem(World par1World)
	{
		this(par1World, ItemList.copper_ingot);
	}
	
	public EntityCopperGolem(World par1World, Item d)
	{
		super(par1World, d);
		this.setSize(1.4F, 2.9F);
	}
	
	@Override
	protected void applyUniqueProperties()
	{
		this.setName("copper");
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(106.0D);
        
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }
}

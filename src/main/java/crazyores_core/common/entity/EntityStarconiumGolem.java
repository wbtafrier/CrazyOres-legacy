package crazyores_core.common.entity;

import crazyores_core.common.items.ItemList;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityStarconiumGolem extends EntityGolems
{
	
	public EntityStarconiumGolem(World par1World)
	{
		this(par1World, ItemList.starconium_gem);
	}
	
	public EntityStarconiumGolem(World par1World, Item d)
	{
		super(par1World, d);
		this.setSize(3.0F, 5.0F);
	}
	
	@Override
	protected void applyUniqueProperties()
	{
		this.setName("starconium");
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(240.0D);
        
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }
}

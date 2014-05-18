package crazyores_core.common.entity;

import crazyores_core.common.items.ItemList;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntitySapphireGolem extends EntityGolems
{
	
	public EntitySapphireGolem(World par1World)
	{
		this(par1World, ItemList.sapphire_gem);
	}
	
	public EntitySapphireGolem(World par1World, Item d)
	{
		super(par1World, d);
		this.setSize(1.4F, 2.9F);
	}
	
	@Override
	protected void applyUniqueProperties()
	{
		this.setName("sapphire");
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(120.0D);
        
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }
}

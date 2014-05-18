package crazyores_core.common.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import crazyores_core.common.items.ItemList;

public class EntityZectiumGolem extends EntityGolems
{
	
	public EntityZectiumGolem(World par1World)
	{
		this(par1World, ItemList.zectium_ingot);
	}
	
	public EntityZectiumGolem(World par1World, Item d)
	{
		super(par1World, d);
		this.setSize(1.8F, 3.6F);
	}
	
	@Override
	protected void applyUniqueProperties()
	{
		this.setName("zectium");
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(166.0D);
        
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }
}

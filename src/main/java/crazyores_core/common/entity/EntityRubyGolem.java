package crazyores_core.common.entity;

import crazyores_core.common.items.ItemList;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityRubyGolem extends EntityGolems
{
	public EntityRubyGolem(World par1World)
	{
		this(par1World, ItemList.ruby_gem);
	}
	
	public EntityRubyGolem(World par1World, Item d)
	{
		super(par1World, d);
		this.setSize(1.6F, 3.3F);
	}
	
	@Override
	protected void applyUniqueProperties()
	{
		this.setName("ruby");
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(140.0D);
        
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }
}

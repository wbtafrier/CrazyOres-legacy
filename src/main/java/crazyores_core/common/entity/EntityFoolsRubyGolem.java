package crazyores_core.common.entity;

import crazyores_core.common.items.ItemList;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityFoolsRubyGolem extends EntityGolems
{
	
	public EntityFoolsRubyGolem(World par1World)
	{
		super(par1World, ItemList.fools_ruby_gem);
	}
	
	public EntityFoolsRubyGolem(World par1World, Item d)
	{
		super(par1World, d);
		this.setSize(1.2F, 2.9F);
	}
	
	@Override
	protected void applyUniqueProperties()
	{
		this.setName("foolsRuby");
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
        
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }
}

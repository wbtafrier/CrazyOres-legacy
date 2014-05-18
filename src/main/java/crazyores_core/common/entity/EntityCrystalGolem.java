package crazyores_core.common.entity;

import crazyores_core.common.items.ItemList;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityCrystalGolem extends EntityGolems
{
	
	public EntityCrystalGolem(World par1World)
	{
		this(par1World, ItemList.crystal_shard);
	}
	
	public EntityCrystalGolem(World par1World, Item d)
	{
		super(par1World, d);
		this.setSize(2.0F, 4.0F);
	}
	
	@Override
	protected void applyUniqueProperties()
	{
		this.setName("crystal");
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(190.0D);
        
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }
}

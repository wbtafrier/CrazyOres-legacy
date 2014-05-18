package crazyores_core.common.core;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import crazyores_core.common.entity.EntityArrows;

public class DamageHandler
{
	public String damageType;
	
	protected DamageHandler(String par1Str)
    {
        this.damageType = par1Str;
    }
		
	public static DamageSource causeMeteoriteArrowDamage(EntityArrows par0EntityMeteoriteArrow, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("meteorite_arrow", par0EntityMeteoriteArrow, par1Entity)).setProjectile();
    }
	
	public static DamageSource causeCopperArrowDamage(EntityArrows par0EntityCopperArrow, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("copper_arrow", par0EntityCopperArrow, par1Entity)).setProjectile();
    }
	
	public static DamageSource causeInvisiumArrowDamage(EntityArrows par0EntityInvisiumArrow, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("invisium_arrow", par0EntityInvisiumArrow, par1Entity)).setProjectile();
    }
    
    public static DamageSource causeSapphireArrowDamage(EntityArrows par0EntitySapphireArrow, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("sapphire_arrow", par0EntitySapphireArrow, par1Entity)).setProjectile();
    }
    
    public static DamageSource causeAdamiteArrowDamage(EntityArrows par0EntityAdamiteArrow, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("adamite_arrow", par0EntityAdamiteArrow, par1Entity)).setProjectile();
    }
    
    public static DamageSource causeRubyArrowDamage(EntityArrows par0EntityRubyArrow, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("ruby_arrow", par0EntityRubyArrow, par1Entity)).setProjectile();
    }
    
    public static DamageSource causeZectiumArrowDamage(EntityArrows par0EntityZectiumArrow, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("zectium_arrow", par0EntityZectiumArrow, par1Entity)).setProjectile();
    }
    
    public static DamageSource causeTapaziteArrowDamage(EntityArrows par0EntityTapaziteArrow, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("tapazite_arrow", par0EntityTapaziteArrow, par1Entity)).setProjectile();
    }
    
    public static DamageSource causeCrystalArrowDamage(EntityArrows par0EntityCrystalArrow, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("crystal_arrow", par0EntityCrystalArrow, par1Entity)).setProjectile();
    }
    
    public static DamageSource causeOsmoniumArrowDamage(EntityArrows par0EntityOsmoniumArrow, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("osmonium_arrow", par0EntityOsmoniumArrow, par1Entity)).setProjectile();
    }
    
    public static DamageSource causeEnderArrowDamage(EntityArrows par0EntityEnderArrow, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("ender_arrow", par0EntityEnderArrow, par1Entity)).setProjectile();
    }
    
    public static DamageSource causeStarconiumArrowDamage(EntityArrows par0EntityStarconiumArrow, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("starconium_arrow", par0EntityStarconiumArrow, par1Entity)).setProjectile();
    }
    
//    public static DamageSource causeExplosionDamage(Entity par1)
//    {
//        return (new EntityDamageSource("explosion", par1));
//    }
}

package crazyores_core.client.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores_core.common.entity.EntityInvisiumArrow;
import crazyores_core.common.entity.EntityNames;

@SideOnly(Side.CLIENT)
public class RenderInvisiumArrow extends RenderArrows
{
    private static final ResourceLocation field_110780_a = new ResourceLocation(EntityNames.INVISIUM_ARROW_PATH);
    
    public RenderInvisiumArrow()
    {
    	
    }
    
    protected ResourceLocation func_110779_a(EntityInvisiumArrow par1EntityInvisiumArrow)
    {
        return field_110780_a;
    }

    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return this.func_110779_a((EntityInvisiumArrow)par1Entity);
    }
}

package crazyores_core.client.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores_core.common.entity.EntityAdamiteArrow;
import crazyores_core.common.entity.EntityArrows;
import crazyores_core.common.entity.EntityNames;

@SideOnly(Side.CLIENT)
public class RenderAdamiteArrow extends RenderArrows
{
    private static final ResourceLocation field_110780_a = new ResourceLocation(EntityNames.ADAMITE_ARROW_PATH);
    
    public RenderAdamiteArrow()
    {
    	
    }
    
    @Override
    protected ResourceLocation getEntityTexture(EntityArrows par1EntityAdamiteArrow)
    {
        return field_110780_a;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getEntityTexture((EntityAdamiteArrow)par1Entity);
    }
}

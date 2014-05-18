package crazyores_core.client.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores_core.common.entity.EntityNames;
import crazyores_core.common.entity.EntityStarconiumArrow;

@SideOnly(Side.CLIENT)
public class RenderStarconiumArrow extends RenderArrows
{
    private static final ResourceLocation field_110780_a = new ResourceLocation(EntityNames.STARCONIUM_ARROW_PATH);

    public RenderStarconiumArrow()
    {
    	
    }
    
    protected ResourceLocation func_110779_a(EntityStarconiumArrow par1EntityStarconiumArrow)
    {
        return field_110780_a;
    }

    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return this.func_110779_a((EntityStarconiumArrow)par1Entity);
    }
}

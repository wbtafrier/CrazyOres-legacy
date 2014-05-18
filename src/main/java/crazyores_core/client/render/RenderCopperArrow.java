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
import crazyores_core.common.entity.EntityCopperArrow;
import crazyores_core.common.entity.EntityNames;

@SideOnly(Side.CLIENT)
public class RenderCopperArrow extends RenderArrows
{
    private static final ResourceLocation field_110780_a = new ResourceLocation(EntityNames.COPPER_ARROW_PATH);
    
    public RenderCopperArrow()
    {
    	
    }
    
    protected ResourceLocation func_110779_a(EntityCopperArrow par1EntityCopperArrow)
    {
        return field_110780_a;
    }

    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return this.func_110779_a((EntityCopperArrow)par1Entity);
    }
}

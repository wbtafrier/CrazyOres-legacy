package crazyores_core.common.world.render;

import java.lang.reflect.Field;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.common.ForgeHooks;

import org.apache.logging.log4j.Level;
import org.lwjgl.opengl.GL11;

import crazyores_core.common.core.COLogger;


public class CloudRenderer extends IRenderHandler {
	
	private ResourceLocation cloudTexture = new ResourceLocation("textures/environment/clouds.png");
	private RenderGlobal renderGlobal;
	private int cloudCounter;
	private float cloudSpeed;
	
	private RenderGlobal renderGlobalAccesser;
	private Field field;
	
	public CloudRenderer() {
		renderGlobal = Minecraft.getMinecraft().renderGlobal;
		initCloudProperties();
	}

	@Override
	public void render(float partialTicks, WorldClient world, Minecraft mc) {
		
		if (mc.gameSettings.shouldRenderClouds()) {
			this.renderClouds(partialTicks, world, mc);
		}
    }
		
	public void renderClouds(float partialTicks, WorldClient world, Minecraft mc) {
		this.updateCloudCounter();

		if (mc.gameSettings.fancyGraphics) {
            this.renderCloudsFancy(partialTicks, world, mc);
        }
        else {
            GL11.glDisable(GL11.GL_CULL_FACE);
            float f1 = (float)(mc.renderViewEntity.lastTickPosY + (mc.renderViewEntity.posY - mc.renderViewEntity.lastTickPosY) * (double)partialTicks);
            byte b0 = 32;
            int i = 256 / b0;
            Tessellator tessellator = Tessellator.instance;
            
            //Cloud Texture
            mc.renderEngine.bindTexture(cloudTexture);
            
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            Vec3 vec3 = world.getCloudColour(partialTicks);
            
            float f2 = (float)vec3.xCoord;
            float f3 = (float)vec3.yCoord;
            float f4 = (float)vec3.zCoord;
            float f5;

            if (mc.gameSettings.anaglyph)
            {
                f5 = (f2 * 30.0F + f3 * 59.0F + f4 * 11.0F) / 100.0F;
                float f6 = (f2 * 30.0F + f3 * 70.0F) / 100.0F;
                float f7 = (f2 * 30.0F + f4 * 70.0F) / 100.0F;
                f2 = f5;
                f3 = f6;
                f4 = f7;
            }

            f5 = 4.8828125E-4F;
            double d2 = (double)((float)this.cloudCounter + partialTicks) * this.cloudSpeed;
            double d0 = mc.renderViewEntity.prevPosX + (mc.renderViewEntity.posX - mc.renderViewEntity.prevPosX) * (double)partialTicks + d2 * 0.029999999329447746D;
            double d1 = mc.renderViewEntity.prevPosZ + (mc.renderViewEntity.posZ - mc.renderViewEntity.prevPosZ) * (double)partialTicks;
            int j = MathHelper.floor_double(d0 / 2048.0D);
            int k = MathHelper.floor_double(d1 / 2048.0D);
            d0 -= (double)(j * 2048);
            d1 -= (double)(k * 2048);
            float f8 = world.provider.getCloudHeight() - f1 + 0.33F;
            float f9 = (float)(d0 * (double)f5);
            float f10 = (float)(d1 * (double)f5);
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA_F(f2, f3, f4, 0.8F);

            for (int l = -b0 * i; l < b0 * i; l += b0)
            {
                for (int i1 = -b0 * i; i1 < b0 * i; i1 += b0)
                {
                    tessellator.addVertexWithUV((double)(l + 0), (double)f8, (double)(i1 + b0), (double)((float)(l + 0) * f5 + f9), (double)((float)(i1 + b0) * f5 + f10));
                    tessellator.addVertexWithUV((double)(l + b0), (double)f8, (double)(i1 + b0), (double)((float)(l + b0) * f5 + f9), (double)((float)(i1 + b0) * f5 + f10));
                    tessellator.addVertexWithUV((double)(l + b0), (double)f8, (double)(i1 + 0), (double)((float)(l + b0) * f5 + f9), (double)((float)(i1 + 0) * f5 + f10));
                    tessellator.addVertexWithUV((double)(l + 0), (double)f8, (double)(i1 + 0), (double)((float)(l + 0) * f5 + f9), (double)((float)(i1 + 0) * f5 + f10));
                }
            }

            tessellator.draw();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glEnable(GL11.GL_CULL_FACE);
        }
	}
	
	public void renderCloudsFancy(float partialTicks, WorldClient world, Minecraft mc) {
		
        GL11.glDisable(GL11.GL_CULL_FACE);
        float f1 = (float)(mc.renderViewEntity.lastTickPosY + (mc.renderViewEntity.posY - mc.renderViewEntity.lastTickPosY) * (double)partialTicks);
        Tessellator tessellator = Tessellator.instance;
        float f2 = 12.0F;
        float f3 = 4.0F;
        double d0 = (double)((float)this.cloudCounter + partialTicks) * this.cloudSpeed;
        double d1 = (mc.renderViewEntity.prevPosX + (mc.renderViewEntity.posX - mc.renderViewEntity.prevPosX) * (double)partialTicks + d0 * 0.029999999329447746D) / (double)f2;
        double d2 = (mc.renderViewEntity.prevPosZ + (mc.renderViewEntity.posZ - mc.renderViewEntity.prevPosZ) * (double)partialTicks) / (double)f2 + 0.33000001311302185D;
        float f4 = world.provider.getCloudHeight() - f1 + 0.33F;
        int i = MathHelper.floor_double(d1 / 2048.0D);
        int j = MathHelper.floor_double(d2 / 2048.0D);
        d1 -= (double)(i * 2048);
        d2 -= (double)(j * 2048);
        
        //Cloud Texture
        mc.renderEngine.bindTexture(cloudTexture);
        GL11.glEnable(GL11.GL_BLEND);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        Vec3 vec3 = world.getCloudColour(partialTicks);
        float f5 = (float)vec3.xCoord;
        float f6 = (float)vec3.yCoord;
        float f7 = (float)vec3.zCoord;
        float f8;
        float f9;
        float f10;

        if (mc.gameSettings.anaglyph)
        {
            f8 = (f5 * 30.0F + f6 * 59.0F + f7 * 11.0F) / 100.0F;
            f9 = (f5 * 30.0F + f6 * 70.0F) / 100.0F;
            f10 = (f5 * 30.0F + f7 * 70.0F) / 100.0F;
            f5 = f8;
            f6 = f9;
            f7 = f10;
        }

        f8 = (float)(d1 * 0.0D);
        f9 = (float)(d2 * 0.0D);
        f10 = 0.00390625F;
        f8 = (float)MathHelper.floor_double(d1) * f10;
        f9 = (float)MathHelper.floor_double(d2) * f10;
        float f11 = (float)(d1 - (double)MathHelper.floor_double(d1));
        float f12 = (float)(d2 - (double)MathHelper.floor_double(d2));
        byte b0 = 8;
        byte b1 = 4;
        float f13 = 9.765625E-4F;
        GL11.glScalef(f2, 1.0F, f2);

        for (int k = 0; k < 2; ++k)
        {
            if (k == 0)
            {
                GL11.glColorMask(false, false, false, false);
            }
            else if (mc.gameSettings.anaglyph)
            {
                if (EntityRenderer.anaglyphField == 0)
                {
                    GL11.glColorMask(false, true, true, true);
                }
                else
                {
                    GL11.glColorMask(true, false, false, true);
                }
            }
            else
            {
                GL11.glColorMask(true, true, true, true);
            }

            for (int l = -b1 + 1; l <= b1; ++l)
            {
                for (int i1 = -b1 + 1; i1 <= b1; ++i1)
                {
                    tessellator.startDrawingQuads();
                    float f14 = (float)(l * b0);
                    float f15 = (float)(i1 * b0);
                    float f16 = f14 - f11;
                    float f17 = f15 - f12;

                    if (f4 > -f3 - 1.0F)
                    {
                        tessellator.setColorRGBA_F(f5 * 0.7F, f6 * 0.7F, f7 * 0.7F, 0.8F);
                        tessellator.setNormal(0.0F, -1.0F, 0.0F);
                        tessellator.addVertexWithUV((double)(f16 + 0.0F), (double)(f4 + 0.0F), (double)(f17 + (float)b0), (double)((f14 + 0.0F) * f10 + f8), (double)((f15 + (float)b0) * f10 + f9));
                        tessellator.addVertexWithUV((double)(f16 + (float)b0), (double)(f4 + 0.0F), (double)(f17 + (float)b0), (double)((f14 + (float)b0) * f10 + f8), (double)((f15 + (float)b0) * f10 + f9));
                        tessellator.addVertexWithUV((double)(f16 + (float)b0), (double)(f4 + 0.0F), (double)(f17 + 0.0F), (double)((f14 + (float)b0) * f10 + f8), (double)((f15 + 0.0F) * f10 + f9));
                        tessellator.addVertexWithUV((double)(f16 + 0.0F), (double)(f4 + 0.0F), (double)(f17 + 0.0F), (double)((f14 + 0.0F) * f10 + f8), (double)((f15 + 0.0F) * f10 + f9));
                    }

                    if (f4 <= f3 + 1.0F)
                    {
                        tessellator.setColorRGBA_F(f5, f6, f7, 0.8F);
                        tessellator.setNormal(0.0F, 1.0F, 0.0F);
                        tessellator.addVertexWithUV((double)(f16 + 0.0F), (double)(f4 + f3 - f13), (double)(f17 + (float)b0), (double)((f14 + 0.0F) * f10 + f8), (double)((f15 + (float)b0) * f10 + f9));
                        tessellator.addVertexWithUV((double)(f16 + (float)b0), (double)(f4 + f3 - f13), (double)(f17 + (float)b0), (double)((f14 + (float)b0) * f10 + f8), (double)((f15 + (float)b0) * f10 + f9));
                        tessellator.addVertexWithUV((double)(f16 + (float)b0), (double)(f4 + f3 - f13), (double)(f17 + 0.0F), (double)((f14 + (float)b0) * f10 + f8), (double)((f15 + 0.0F) * f10 + f9));
                        tessellator.addVertexWithUV((double)(f16 + 0.0F), (double)(f4 + f3 - f13), (double)(f17 + 0.0F), (double)((f14 + 0.0F) * f10 + f8), (double)((f15 + 0.0F) * f10 + f9));
                    }

                    tessellator.setColorRGBA_F(f5 * 0.9F, f6 * 0.9F, f7 * 0.9F, 0.8F);
                    int j1;

                    if (l > -1)
                    {
                        tessellator.setNormal(-1.0F, 0.0F, 0.0F);

                        for (j1 = 0; j1 < b0; ++j1)
                        {
                            tessellator.addVertexWithUV((double)(f16 + (float)j1 + 0.0F), (double)(f4 + 0.0F), (double)(f17 + (float)b0), (double)((f14 + (float)j1 + 0.5F) * f10 + f8), (double)((f15 + (float)b0) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + (float)j1 + 0.0F), (double)(f4 + f3), (double)(f17 + (float)b0), (double)((f14 + (float)j1 + 0.5F) * f10 + f8), (double)((f15 + (float)b0) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + (float)j1 + 0.0F), (double)(f4 + f3), (double)(f17 + 0.0F), (double)((f14 + (float)j1 + 0.5F) * f10 + f8), (double)((f15 + 0.0F) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + (float)j1 + 0.0F), (double)(f4 + 0.0F), (double)(f17 + 0.0F), (double)((f14 + (float)j1 + 0.5F) * f10 + f8), (double)((f15 + 0.0F) * f10 + f9));
                        }
                    }

                    if (l <= 1)
                    {
                        tessellator.setNormal(1.0F, 0.0F, 0.0F);

                        for (j1 = 0; j1 < b0; ++j1)
                        {
                            tessellator.addVertexWithUV((double)(f16 + (float)j1 + 1.0F - f13), (double)(f4 + 0.0F), (double)(f17 + (float)b0), (double)((f14 + (float)j1 + 0.5F) * f10 + f8), (double)((f15 + (float)b0) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + (float)j1 + 1.0F - f13), (double)(f4 + f3), (double)(f17 + (float)b0), (double)((f14 + (float)j1 + 0.5F) * f10 + f8), (double)((f15 + (float)b0) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + (float)j1 + 1.0F - f13), (double)(f4 + f3), (double)(f17 + 0.0F), (double)((f14 + (float)j1 + 0.5F) * f10 + f8), (double)((f15 + 0.0F) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + (float)j1 + 1.0F - f13), (double)(f4 + 0.0F), (double)(f17 + 0.0F), (double)((f14 + (float)j1 + 0.5F) * f10 + f8), (double)((f15 + 0.0F) * f10 + f9));
                        }
                    }

                    tessellator.setColorRGBA_F(f5 * 0.8F, f6 * 0.8F, f7 * 0.8F, 0.8F);

                    if (i1 > -1)
                    {
                        tessellator.setNormal(0.0F, 0.0F, -1.0F);

                        for (j1 = 0; j1 < b0; ++j1)
                        {
                            tessellator.addVertexWithUV((double)(f16 + 0.0F), (double)(f4 + f3), (double)(f17 + (float)j1 + 0.0F), (double)((f14 + 0.0F) * f10 + f8), (double)((f15 + (float)j1 + 0.5F) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + (float)b0), (double)(f4 + f3), (double)(f17 + (float)j1 + 0.0F), (double)((f14 + (float)b0) * f10 + f8), (double)((f15 + (float)j1 + 0.5F) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + (float)b0), (double)(f4 + 0.0F), (double)(f17 + (float)j1 + 0.0F), (double)((f14 + (float)b0) * f10 + f8), (double)((f15 + (float)j1 + 0.5F) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + 0.0F), (double)(f4 + 0.0F), (double)(f17 + (float)j1 + 0.0F), (double)((f14 + 0.0F) * f10 + f8), (double)((f15 + (float)j1 + 0.5F) * f10 + f9));
                        }
                    }

                    if (i1 <= 1)
                    {
                        tessellator.setNormal(0.0F, 0.0F, 1.0F);

                        for (j1 = 0; j1 < b0; ++j1)
                        {
                            tessellator.addVertexWithUV((double)(f16 + 0.0F), (double)(f4 + f3), (double)(f17 + (float)j1 + 1.0F - f13), (double)((f14 + 0.0F) * f10 + f8), (double)((f15 + (float)j1 + 0.5F) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + (float)b0), (double)(f4 + f3), (double)(f17 + (float)j1 + 1.0F - f13), (double)((f14 + (float)b0) * f10 + f8), (double)((f15 + (float)j1 + 0.5F) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + (float)b0), (double)(f4 + 0.0F), (double)(f17 + (float)j1 + 1.0F - f13), (double)((f14 + (float)b0) * f10 + f8), (double)((f15 + (float)j1 + 0.5F) * f10 + f9));
                            tessellator.addVertexWithUV((double)(f16 + 0.0F), (double)(f4 + 0.0F), (double)(f17 + (float)j1 + 1.0F - f13), (double)((f14 + 0.0F) * f10 + f8), (double)((f15 + (float)j1 + 0.5F) * f10 + f9));
                        }
                    }

                    tessellator.draw();
                }
            }
        }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_CULL_FACE);
    }
	
	public void initCloudProperties() {
		try {
			renderGlobalAccesser = renderGlobal;
	        field = RenderGlobal.class.getDeclaredField("cloudTickCounter");
	        field.setAccessible(true);
		} catch (NoSuchFieldException | SecurityException e) {
			COLogger.write(Level.INFO, "REFLECTION FOR CLOUDCOUNTER COUND NOT BE INITIALIZED.");
			e.printStackTrace();
		}
		
		this.cloudSpeed = 10.0F;
	}
	
	public void updateCloudCounter() {
		try {
	        this.cloudCounter = (int) field.get(renderGlobalAccesser);
	        COLogger.write(Level.INFO, "CLOUD COUNTER: " + this.cloudCounter);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			COLogger.write(Level.INFO, "REFLECTION UPDATE FOR CLOUDCOUNTER COULD NOT BE PROCESSED.");
			e.printStackTrace();
		}
	}
}
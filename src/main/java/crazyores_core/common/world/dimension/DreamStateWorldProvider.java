package crazyores_core.common.world.dimension;

import org.apache.logging.log4j.Level;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IRenderHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores_core.common.core.COLogger;
import crazyores_core.common.world.biome.DreamStateBiomes;
//import crazyores_core.common.world.render.CloudRenderer;
import crazyores_core.common.world.render.SkyRenderer;

public class DreamStateWorldProvider extends WorldProvider {

	private static final String dimensionName = "Dream State";
	private static final long dayLength = 24000;
	private long cloudColor = 16777215L;
	private final int[] playerPosition = new int[3];
//	private CloudRenderer cloudRenderer;
	private SkyRenderer skyRenderer;
	private float[] sunsetSunriseColors;
	
	@Override
	public void registerWorldChunkManager() {
		this.dimensionId = DimensionList.dreamStateDimID;
//		this.cloudRenderer = new CloudRenderer();
		this.sunsetSunriseColors = new float[4];
		this.skyRenderer = new SkyRenderer();
		this.worldChunkMgr = new WorldChunkManagerHell(DreamStateBiomes.crazyHillsBiome, this.dimensionId);
		this.hasNoSky = false;
	}
	
	@Override
	public IChunkProvider createChunkGenerator() {
		return new DreamStateChunkProvider(this.worldObj, this.worldObj.getSeed(), false);
	}
	
	@Override
	public int getAverageGroundLevel() {
		return this.terrainType.getMinimumSpawnHeight(worldObj);
	}
	
	@Override
	public String getDimensionName() {
		return this.dimensionName;
	}
	
	@Override
	public String getWelcomeMessage() {
        return "Falling into the " + this.dimensionName;
    }
	
	@Override
	public String getDepartMessage() {
		return "Waking up";
	}

	@Override
	public boolean isSkyColored() {
		 return true;
	}
	
	@Override
	public String getSaveFolder() {
		return "DIM" + this.dimensionId + " " + this.dimensionName;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean canCoordinateBeSpawn(int x, int z) {
//		return this.worldObj.getTopBlock(x, z) == BlockList.dream_state_grass;
		return 
		(this.worldObj.getTopBlock(x, z) == DreamStateBiomes.crazyHillsBiome.topBlock)
		/* || (this.worldObj.getTopBlock(x, z) == DreamStateBiomes.anotherBiome.topBlock)*/;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public Vec3 getSkyColor(Entity cameraEntity, float partialTicks) {
        return  this.getSkyColorBody(cameraEntity, partialTicks);
    }
	
	@SideOnly(Side.CLIENT)
    public Vec3 getSkyColorBody(Entity entity, float angle) {
        float f1 = this.worldObj.getCelestialAngle(angle);
        float f2 = MathHelper.cos(f1 * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

        if (f2 < 0.2F) {
            f2 = 0.2F;
        }

        if (f2 > 1.0F) {
            f2 = 1.0F;
        }

        int i = MathHelper.floor_double(entity.posX);
        int j = MathHelper.floor_double(entity.posY);
        int k = MathHelper.floor_double(entity.posZ);
        int l = ForgeHooksClient.getSkyBlendColour(this.worldObj, i, j, k);
        
        float f4 = (float)(l >> 16 & 0x98) / 255.0F;
        float f5 = (float)(l >> 8 & 0x18) / 255.0F;
        float f6 = (float)(l & 0x98) / 255.0F;
        
        f4 *= f2;
        f5 *= f2;
        f6 *= f2;
//        float f7 = this.getRainStrength(angle);
        float f8;
        float f9;

//        if (f7 > 0.0F)
//        {
//            f8 = (f4 * 0.3F + f5 * 0.59F + f6 * 0.11F) * 0.6F;
//            f9 = 1.0F - f7 * 0.75F;
//            f4 = f4 * f9 + f8 * (1.0F - f9);
//            f5 = f5 * f9 + f8 * (1.0F - f9);
//            f6 = f6 * f9 + f8 * (1.0F - f9);
//        }

//        f8 = this.getWeightedThunderStrength(angle);
//
//        if (f8 > 0.0F)
//        {
//            f9 = (f4 * 0.3F + f5 * 0.59F + f6 * 0.11F) * 0.2F;
//            float f10 = 1.0F - f8 * 0.75F;
//            f4 = f4 * f10 + f9 * (1.0F - f10);
//            f5 = f5 * f10 + f9 * (1.0F - f10);
//            f6 = f6 * f10 + f9 * (1.0F - f10);
//        }
//
//        if (this.lastLightningBolt > 0)
//        {
//            f9 = (float)this.lastLightningBolt - angle;
//
//            if (f9 > 1.0F)
//            {
//                f9 = 1.0F;
//            }
//
//            f9 *= 0.45F;
//            f4 = f4 * (1.0F - f9) + 0.8F * f9;
//            f5 = f5 * (1.0F - f9) + 0.8F * f9;
//            f6 = f6 * (1.0F - f9) + 1.0F * f9;
//        }

        return Vec3.createVectorHelper((double)f4, (double)f5, (double)f6);
    }
	
//	@SideOnly(Side.CLIENT)
//    public Vec3 drawCloudsBody(float p_72824_1_)
//    {
//        float f1 = this.worldObj.getCelestialAngle(p_72824_1_);
//        float f2 = MathHelper.cos(f1 * (float)Math.PI * 2.0F) * 2.0F + 0.5F;
//
//        if (f2 < 0.0F)
//        {
//            f2 = 0.0F;
//        }
//
//        if (f2 > 1.0F)
//        {
//            f2 = 1.0F;
//        }
//
//        float f3 = (float)(this.cloudColor >> 16 & 0xff) / 255.0F;
//        float f4 = (float)(this.cloudColor >> 8 & 0xff) / 255.0F;
//        float f5 = (float)(this.cloudColor & 0xff) / 255.0F;
////        float f6 = this.getRainStrength(p_72824_1_);
////        float f7;
//        float f8;
//
////        if (f6 > 0.0F)
////        {
////            f7 = (f3 * 0.3F + f4 * 0.59F + f5 * 0.11F) * 0.6F;
////            f8 = 1.0F - f6 * 0.95F;
////            f3 = f3 * f8 + f7 * (1.0F - f8);
////            f4 = f4 * f8 + f7 * (1.0F - f8);
////            f5 = f5 * f8 + f7 * (1.0F - f8);
////        }
//
//        f3 *= f2 * 0.9F + 0.1F;
//        f4 *= f2 * 0.9F + 0.1F;
//        f5 *= f2 * 0.85F + 0.15F;
////        f7 = this.getWeightedThunderStrength(p_72824_1_);
//
////        if (f7 > 0.0F)
////        {
////            f8 = (f3 * 0.3F + f4 * 0.59F + f5 * 0.11F) * 0.2F;
////            float f9 = 1.0F - f7 * 0.95F;
////            f3 = f3 * f9 + f8 * (1.0F - f9);
////            f4 = f4 * f9 + f8 * (1.0F - f9);
////            f5 = f5 * f9 + f8 * (1.0F - f9);
////        }
//
//        return Vec3.createVectorHelper((double)f3, (double)f4, (double)f5);
//    }
	
	/**
     * Returns array with sunrise/sunset colors
     */
	@Override
    @SideOnly(Side.CLIENT)
    public float[] calcSunriseSunsetColors(float angle, float partialTicks)
    {
        float f2 = 0.4F;
        float f3 = MathHelper.cos(angle * (float)Math.PI * 2.0F) - 0.0F;
        float f4 = -0.0F;

        if (f3 >= f4 - f2 && f3 <= f4 + f2)
        {
            float f5 = (f3 - f4) / f2 * 0.5F + 0.5F;
            float f6 = 1.0F - (1.0F - MathHelper.sin(f5 * (float)Math.PI)) * 0.99F;
            f6 *= f6;
            
            float f7 = 1.0F;
            float f8 = 0.0F;
            float f9 = 0.0F;
            
            f7 *= f2 * 0.94F + 0.06F;
            f8 *= f2 * 0.94F + 0.06F;
            f9 *= f2 * 0.91F + 0.09F;
            
            this.sunsetSunriseColors[0] = 0.8F;
            this.sunsetSunriseColors[1] = 0.2F;
            this.sunsetSunriseColors[2] = 0.8F;
            
//            this.colorsSunriseSunset[0] = f5 * 0.3F + 0.7F;
//            this.colorsSunriseSunset[1] = f5 * f5 * 0.7F + 0.2F;
//            this.colorsSunriseSunset[2] = f5 * f5 * 0.0F + 0.2F;
//            this.colorsSunriseSunset[3] = f6;
            this.sunsetSunriseColors[3] = f6;
            return this.sunsetSunriseColors;
        }
        else
        {
            return null;
        }
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public Vec3 getFogColor(float p_76562_1_, float p_76562_2_) {
        float f2 = MathHelper.cos(p_76562_1_ * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

        if (f2 < 0.2F)
        {
            f2 = 0.2F;
        }

        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }

        float f3 = 1.0F;
        float f4 = 0.741176471F;
        float f5 = 1.0F;
        f3 *= f2 * 0.94F + 0.06F;
        f4 *= f2 * 0.94F + 0.06F;
        f5 *= f2 * 0.91F + 0.09F;
        
        return Vec3.createVectorHelper((double)f3, (double)f4, (double)f5);
//        return Vec3.createVectorHelper((double)1.0, (double)0, (double)0);

    }
	
	@Override
	public IRenderHandler getSkyRenderer() {
		return this.skyRenderer;
	}
	
//	@Override
//	public IRenderHandler getCloudRenderer() {
//		return this.cloudRenderer;
//	}
	
//	@Override
//	public float getCloudHeight() {
//		return 275.0F;
//	}
	
	@Override
	public boolean isSurfaceWorld() {
		return false;
	}
	
	@Override
	public boolean canRespawnHere() {
		return false;
	}
	
	@Override
	public double getMovementFactor() {
		return 1.0;
    }
	
	@Override
	public boolean shouldMapSpin(String entity, double x, double y, double z) {
		return true;
    }
	
	@Override
	public int getRespawnDimension(EntityPlayerMP player) {
		this.playerPosition[0] = player.playerLocation.posX;
		this.playerPosition[1] = player.playerLocation.posY;
		this.playerPosition[2] = player.playerLocation.posZ;
		return 0;
    }
	
	//TODO: Change these methods to implement our version of weather
	@Override
	public void setAllowedSpawnTypes(boolean allowHostile, boolean allowPeaceful) {}

	@Override
    public void calculateInitialWeather() {}

	@Override
    public void updateWeather() {}
	
	@Override
	public boolean canBlockFreeze(int x, int y, int z, boolean byWater) {return false;}

	@Override
    public boolean canSnowAt(int x, int y, int z, boolean checkLight) {return false;}
	
	@Override
	public boolean isBlockHighHumidity(int x, int y, int z) {return false;}
	
	@Override
	public void resetRainAndThunder() {}
	
	@Override
	public boolean canDoLightning(Chunk chunk) {return false;}
	
	@Override
	public boolean canDoRainSnowIce(Chunk chunk) {return false;}
	////////////////////////////////////////////////////////////////
	
	
	
}

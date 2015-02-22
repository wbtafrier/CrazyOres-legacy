package crazyores_core.common.world.dimension;

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
	
	@Override
	public void registerWorldChunkManager() {
		this.dimensionId = DimensionList.dreamStateDimID;
//		this.cloudRenderer = new CloudRenderer();
		this.skyRenderer = new SkyRenderer();
		this.worldChunkMgr = new WorldChunkManagerHell(DreamStateBiomes.dreamHillsBiome, this.dimensionId);
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
		(this.worldObj.getTopBlock(x, z) == DreamStateBiomes.dreamHillsBiome.topBlock)
		/* || (this.worldObj.getTopBlock(x, z) == DreamStateBiomes.anotherBiome.topBlock)*/;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public Vec3 getSkyColor(Entity cameraEntity, float partialTicks) {
        return  this.getSkyColorBody(cameraEntity, partialTicks);
    }
	
	@SideOnly(Side.CLIENT)
    public Vec3 getSkyColorBody(Entity p_72833_1_, float p_72833_2_) {
        float f1 = this.worldObj.getCelestialAngle(p_72833_2_);
        float f2 = MathHelper.cos(f1 * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

        if (f2 < 0.0F)
        {
            f2 = 0.0F;
        }

        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }

        int i = MathHelper.floor_double(p_72833_1_.posX);
        int j = MathHelper.floor_double(p_72833_1_.posY);
        int k = MathHelper.floor_double(p_72833_1_.posZ);
        int l = ForgeHooksClient.getSkyBlendColour(this.worldObj, i, j, k);
        float f4 = (float)(l >> 16 & 0xdd) / 255.0F;
        float f5 = (float)(l >> 8 & 0xaa) / 255.0F;
        float f6 = (float)(l & 0x33) / 255.0F;
        f4 *= f2;
        f5 *= f2;
        f6 *= f2;
//        float f7 = this.getRainStrength(p_72833_2_);
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

//        f8 = this.getWeightedThunderStrength(p_72833_2_);
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
//            f9 = (float)this.lastLightningBolt - p_72833_2_;
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
	
	@Override
	@SideOnly(Side.CLIENT)
    public Vec3 getFogColor(float p_76562_1_, float p_76562_2_) {
        float f2 = MathHelper.cos(p_76562_1_ * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

        if (f2 < 0.0F)
        {
            f2 = 0.0F;
        }

        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }

        float f3 = 0.7529412F;
        float f4 = 0.84705883F;
        float f5 = 1.0F;
//        f3 *= f2 * 0.867F + 0.133F;
//        f4 *= f2 * 0.66F + 0.33F;
//        f5 *= f2 * 0.2F + 0.8F;
        
//        return Vec3.createVectorHelper((double)f3, (double)f4, (double)f5);
        return Vec3.createVectorHelper((double)1.0, (double)0, (double)0);

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

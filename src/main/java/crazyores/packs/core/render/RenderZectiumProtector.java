package crazyores.packs.core.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import crazyores.packs.core.entity.mob.EntityZectiumProtector;
import crazyores.packs.core.model.mob.ModelZectiumProtector;
import crazyores.packs.core.util.CoreResourceHandler;

public class RenderZectiumProtector extends RenderLiving {

	private ModelZectiumProtector protector;
	
	public RenderZectiumProtector(ModelBase model) {
		super(model, 0.5f);
	}

	protected void rotateCorpse(EntityZectiumProtector protector, float x, float y, float z) {
        super.rotateCorpse(protector, x, y, z);
    }
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return CoreResourceHandler.ZECTIUM_PROTECTOR_TEXTURE;
	}
	
	public void doRender(EntityZectiumProtector protector, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(protector, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRender(EntityLiving entity, double x, double y, double z, float f1, float f2) {
    	this.doRender((EntityZectiumProtector)entity, x, y, z, f1, f2);
    }
	
	@Override
	public void doRender(EntityLivingBase entity, double x, double y, double z, float f1, float f2) {
        this.doRender((EntityZectiumProtector)entity, x, y, z, f1, f2);
    }
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float f1, float f2) {
        this.doRender((EntityZectiumProtector)entity, x, y, z, f1, f2);
    }

	@Override
    protected void rotateCorpse(EntityLivingBase entity, float x, float y, float z) {
        this.rotateCorpse((EntityZectiumProtector)entity, x, y, z);
    }
	
	@Override
    protected void preRenderCallback(EntityLivingBase entity, float par2) {
		EntityZectiumProtector protector = (EntityZectiumProtector)entity;
		this.scale(protector, protector.getScale());
    }
    
	protected void scale(EntityZectiumProtector entity, float scale) {
		GL11.glScalef(scale, scale, scale);
//		entity.updateSize();
    }
}

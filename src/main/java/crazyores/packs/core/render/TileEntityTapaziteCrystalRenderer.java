package crazyores.packs.core.render;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import crazyores.packs.core.entity.TileEntityTapaziteCrystal;
import crazyores.packs.core.model.ModelTapaziteCrystal;
import crazyores.packs.core.util.CoreResourceLoader;

public class TileEntityTapaziteCrystalRenderer extends TileEntitySpecialRenderer {

	public TileEntityTapaziteCrystalRenderer() {}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		GL11.glPushMatrix();
		GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
		GL11.glPopMatrix();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float scale) {
		//The PushMatrix tells the renderer to "start" doing something.
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_NORMALIZE);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		//This is setting the initial location.
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

		//Binding the textures
		this.bindTexture(CoreResourceLoader.tapaziteCrystalImage);

		//This rotation part is very important! Without it, your model will render upside-down! And for some reason you DO need PushMatrix again!                       
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

		//A reference to your Model file. Again, very important.
		
		TileEntityTapaziteCrystal c = (TileEntityTapaziteCrystal) entity;
		c.getModel().render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

		//Tell it to stop rendering for both the PushMatrix's
		
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}


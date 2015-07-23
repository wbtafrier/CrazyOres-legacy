package crazyores.packs.core.model;

import net.minecraft.client.model.ModelRenderer;

public class ModelObelisk {

	public final int[] boxBounds;
	public final float[] ballOffset;
	public final float[] rotationPoint;
	public final float[] obeliskRotation;
	
	public final int textureOffsetX;
	public final int textureOffsetY;
	
	/**
	 * 
	 * @param boxBounds
	 * @param ballOffset
	 * @param rotationPoint
	 * @param obeliskRotation
	 * @param mirror
	 * @param textureWidth
	 * @param textureHeight
	 * @param textureOffsetX
	 * @param textureOffsetY
	 */
	public ModelObelisk(int[] boxBounds, float[] ballOffset, float[] rotationPoint, float[] obeliskRotation, int textureOffsetX, int textureOffsetY) {
		
		this.boxBounds = boxBounds;
		this.ballOffset = ballOffset;
		this.rotationPoint = rotationPoint;
		this.obeliskRotation = obeliskRotation;
		this.textureOffsetX = textureOffsetX;
		this.textureOffsetY = textureOffsetY;
	}
}

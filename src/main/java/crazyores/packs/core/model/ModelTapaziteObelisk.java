package crazyores.packs.core.model;
import java.util.Random;


public class ModelTapaziteObelisk {

	private static Random rand = new Random();
	
	///////////////////
	// SAVE FOR NBTDATA 
	///////////////////
	
	public final int textureWidth;
	public final int textureHeight;
	
	public final int textureOffsetX;
	public final int textureOffsetY;
	
	public boolean mirror;
	
	public float ballOffsetPointX;
	public float ballOffsetPointY;
	public float ballOffsetPointZ;
	
	public int[] boxBounds = new int[3];
	
	public float rotationPointX;
	public float rotationPointY;
	public float rotationPointZ;
	
	public float obeliskRotationX;
	public float obeliskRotationY;
	public float obeliskRotationZ;
	
	///////////////////

	/**
	 * Holds properties of the obelisk.
	 * @param defaultBounds is the size of the obelisk.
	 * @param defaultOffset is the ball offset for the obelisk.
	 * @param defaultRotationPoint is the rotation point in space for the obelisk.
	 * @param defaultRotation is how much the obelisk should be rotated.
	 * @param width is the texture width.
	 * @param height is the texture height.
	 * @param offsetWidth is the texture offset width.
	 * @param offsetHeight is the texture offset height.
	 * @param mirror if the texture should be mirrored or not (Always set to true usually).
	 */
	public ModelTapaziteObelisk(int[] defaultBounds, float[] defaultOffset, float[] defaultRotationPoint, float[] defaultRotation, int width, int height, int offsetWidth, int offsetHeight, boolean mirror) {
		textureWidth = width;
		textureHeight = height;
		textureOffsetX = offsetWidth;
		textureOffsetY = offsetHeight;
		
		this.boxBounds = defaultBounds;
		
		this.ballOffsetPointX = defaultOffset[0];
		this.ballOffsetPointY = defaultOffset[1];
		this.ballOffsetPointZ = defaultOffset[2];
		
		this.rotationPointX = defaultRotationPoint[0];
		this.rotationPointY = defaultRotationPoint[1];
		this.rotationPointZ = defaultRotationPoint[2];
		
		this.obeliskRotationX = defaultRotation[0];
		this.obeliskRotationY = defaultRotation[1];
		this.obeliskRotationZ = defaultRotation[2];
		
		this.mirror = mirror;
	}
	
	public void growObelisk() {
		
		if (this.boxBounds[1] >= 14) {
			return;
		}
		
		int growLength = rand.nextInt(2);
		
		if (this.boxBounds[1] <= 12 && growLength == 1) {
			this.boxBounds[1] += 2;
			this.growOffset();
		}
		else {
			this.boxBounds[1] += 1;
			this.growOffset();
		}
	}
	
	private void growOffset() {
		this.ballOffsetPointX = -boxBounds[0] / 2;
		this.ballOffsetPointY =  -boxBounds[1] + 1;
		this.ballOffsetPointZ = -boxBounds[2] / 2;
	}
}

package crazyores.packs.core.model;

import java.util.List;
import java.util.Random;

public class ModelTapaziteObeliskHelper {

	private static Random rand = new Random();
	private ModelTapaziteObelisk[] obeliskContainer;
	private final int maximumObelisks = 5;
	
	public ModelTapaziteObeliskHelper() {
		
		initDefaultObelisks();
	}
	
//	public ModelTapaziteObeliskHelper(int obelisks, List<Integer> bounds, List<Float> ballOffset, List<Float> rotationPoint, List<Float> obeliskRotation) {
//		this.initObelisks(obelisks, bounds, ballOffset, rotationPoint, obeliskRotation);
//	}
	
	public ModelTapaziteObelisk[] getObelisks() {
		return obeliskContainer;
	}
	
	private void initDefaultObelisks() {
		int r = rand.nextInt(maximumObelisks) + 1;
		
		obeliskContainer = new ModelTapaziteObelisk[r];
		
		for (int i = 0; i < r; i++) {
			
			int[] bounds = new int[] {
					rand.nextInt(4) + 1,
					rand.nextInt(6) + 1,
					rand.nextInt(4) + 1
				};
				
				float[] ballOffset = new float[] {
					-bounds[0] / 2,
					-bounds[1] + 1,
					-bounds[2] / 2
				};
				
				float[] rotationPoint = new float[] {
					rand.nextFloat() * 5,
					24,
					rand.nextFloat() * 5
				};
				
				float[] obeliskRotation = new float[] {
					rand.nextFloat(),
					rand.nextFloat(),
					rand.nextFloat()
				};
			
			obeliskContainer[i] = new ModelTapaziteObelisk(bounds, ballOffset, rotationPoint, obeliskRotation, 16, 16, 0, 0, true);
		}
	}
	
//	public void initObelisks(int obelisks, List<Integer> bounds, List<Float> ballOffset, List<Float> rotationPoint, List<Float> obeliskRotation) {
//		
//		obeliskContainer = new ModelTapaziteObelisk[obelisks];
//		
//		int[] correctBounds;
//		float[] correctOffset;
//		float[] correctRotationPoint;
//		float[] correctObeliskRotation;
//		int counter = 0;
//		
//		for (int i = 0; i < obelisks; i++) {
//			
//			correctBounds = new int[3];
//			correctBounds[0] = bounds.get(counter);
//			correctBounds[1] = bounds.get(counter + 1);
//			correctBounds[2] = bounds.get(counter + 2);
//			
//			correctOffset = new float[3];
//			correctOffset[0] = ballOffset.get(counter);
//			correctOffset[1] = ballOffset.get(counter + 1);
//			correctOffset[2] = ballOffset.get(counter + 2);
//			
//			correctRotationPoint = new float[3];
//			correctRotationPoint[0] = rotationPoint.get(counter);
//			correctRotationPoint[1] = rotationPoint.get(counter + 1);
//			correctRotationPoint[2] = rotationPoint.get(counter + 2);
//			
//			correctObeliskRotation = new float[3];
//			correctObeliskRotation[0] = obeliskRotation.get(counter);
//			correctObeliskRotation[1] = obeliskRotation.get(counter + 1);
//			correctObeliskRotation[2] = obeliskRotation.get(counter + 2);
//			
//			obeliskContainer[i] = new ModelTapaziteObelisk(correctBounds, correctOffset, correctRotationPoint, correctObeliskRotation, 16, 16, 0, 0, true);
//			counter += 3;
//		}
//	}
	
//	public void loadObelisks(int[] bounds, float[] ballOffset, float[] rotationPoint, float[] obeliskRotation, boolean mirror, int obeliskIndex) {
//		
//		if (obeliskIndex < 5) {
//			
//			obeliskContainer[obeliskIndex].boxBounds = bounds;
//			
//			obeliskContainer[obeliskIndex].ballOffsetPointX = ballOffset[0];
//			obeliskContainer[obeliskIndex].ballOffsetPointY = ballOffset[1];
//			obeliskContainer[obeliskIndex].ballOffsetPointZ = ballOffset[2];
//			
//			obeliskContainer[obeliskIndex].rotationPointX = rotationPoint[0];
//			obeliskContainer[obeliskIndex].rotationPointY = rotationPoint[1];
//			obeliskContainer[obeliskIndex].rotationPointZ = rotationPoint[2];
//			
//			obeliskContainer[obeliskIndex].obeliskRotationX = obeliskRotation[0];
//			obeliskContainer[obeliskIndex].obeliskRotationY = obeliskRotation[1];
//			obeliskContainer[obeliskIndex].obeliskRotationZ = obeliskRotation[2];
//			
//			obeliskContainer[obeliskIndex].mirror = mirror;
//		}
//	}
	
	public void updateObelisk() {
		
		int r = rand.nextInt(obeliskContainer.length);
		obeliskContainer[r].growObelisk();
	}
}

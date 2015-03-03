package crazyores.packs.core.model.data;

import java.util.ArrayList;

import crazyores.packs.core.model.ModelCrystal;
import crazyores.packs.core.model.ModelObelisk;
import net.minecraft.client.model.ModelRenderer;

public class TapaziteObeliskData {

	public static final ModelCrystal tapaziteStalagmitePhase1 = new ModelCrystal(

			new ArrayList<ModelObelisk>() {{
				add(new ModelObelisk(

						new int[] {4, 10, 4},//Box bounds
						new float[] {-2F, -9F, -2F},//Ball offset
						new float[] {0F, 24F, 0F},//Rotation Point
						new float[] {0F, 0F, 0F},//Obelisk Rotation
						true,//Mirror texture
						16,//Texture Width
						16,//Texture Height
						0,//Texture OffsetX
						0//Texture OffsetY
						));

				add(new ModelObelisk(
						new int[] {2, 5, 2},//Box bounds
						new float[] {-1F, -4F, -1F},//Ball offset
						new float[] {2F, 24F, 2F},//Rotation Point
						new float[] {0F, 0F, 0F},//Obelisk Rotation
						true,//Mirror texture
						16,//Texture Width
						16,//Texture Height
						0,//Texture OffsetX
						0//Texture OffsetY	
						));
			};
			}
			);

	public static final ModelCrystal tapaziteStalagmitePhase2 = new ModelCrystal(

			new ArrayList<ModelObelisk>() {{
				add(new ModelObelisk(

						new int[] {6, 12, 6},//Box bounds
						new float[] {-3F, -11F, -3F},//Ball offset
						new float[] {0F, 24F, 0F},//Rotation Point
						new float[] {0F, 0F, 0F},//Obelisk Rotation
						true,//Mirror texture
						16,//Texture Width
						16,//Texture Height
						0,//Texture OffsetX
						0//Texture OffsetY
						));

			};
			}
			);

	//////////////////////////////////////////////////////////////////////////////////

	public static final ModelCrystal tapaziteStalactitePhase1 = new ModelCrystal(

			new ArrayList<ModelObelisk>() {{
				add(new ModelObelisk(

						new int[] {4, 10, 4},//Box bounds
						new float[] {-2F, -9F, -2F},//Ball offset
						new float[] {0F, -8F, 0F},//Rotation Point
						new float[] {0F, 0F, 0F},//Obelisk Rotation
						true,//Mirror texture
						16,//Texture Width
						16,//Texture Height
						0,//Texture OffsetX
						0//Texture OffsetY
						));

				add(new ModelObelisk(
						new int[] {2, 5, 2},//Box bounds
						new float[] {-1F, -4F, -1F},//Ball offset
						new float[] {2F, -8F, 2F},//Rotation Point
						new float[] {0F, 0F, 0F},//Obelisk Rotation
						true,//Mirror texture
						16,//Texture Width
						16,//Texture Height
						0,//Texture OffsetX
						0//Texture OffsetY	
						));
			};
			}
			);

	public static final ModelCrystal tapaziteStalactitePhase2 = new ModelCrystal(

			new ArrayList<ModelObelisk>() {{
				add(new ModelObelisk(

						new int[] {6, 12, 6},//Box bounds
						new float[] {-3F, -11F, -3F},//Ball offset
						new float[] {0F, -8F, 0F},//Rotation Point
						new float[] {0F, 0F, 0F},//Obelisk Rotation
						true,//Mirror texture
						16,//Texture Width
						16,//Texture Height
						0,//Texture OffsetX
						0//Texture OffsetY
						));

			};
			}
			);
}

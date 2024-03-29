package crazyores.packs.core.event;

import net.minecraftforge.client.event.FOVUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.packs.core.item.CoreBow;
import crazyores.packs.core.item.SwiftBow;

@SideOnly(Side.CLIENT)
public class CoreBowEvent {

	@SubscribeEvent
	public void updateFOV(FOVUpdateEvent event) {
		if (event.entity.isUsingItem() && event.entity.getItemInUse().getItem() instanceof CoreBow) {
			float fov = event.fov;
			
			int i;
			
			if (event.entity.getItemInUse().getItem() instanceof SwiftBow) {
				i = event.entity.getItemInUseDuration() * SwiftBow.PULL_BACK_SPEED_BOOST;
			}
			else {
				i = event.entity.getItemInUseDuration();
			}
			
            float f1 = (float)i / 20.0f;

            if (f1 > 1.0f) {
                f1 = 1.0f;
            }
            else {
                f1 *= f1;
            }

            fov *= 1.0f - f1 * 0.15f;
            event.newfov = fov;
		}
	}
}

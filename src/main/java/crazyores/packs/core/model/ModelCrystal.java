package crazyores.packs.core.model;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCrystal extends ModelBase {

	public List<ModelRenderer> obeliskModels;

	public ModelCrystal(List<ModelObelisk> obelisks, int textureWidth, int textureHeight) {

		this.obeliskModels = new ArrayList<>();


		ModelRenderer o;
		for (int i = 0; i < obelisks.size(); i++) {

			ModelObelisk currentObelisk = obelisks.get(i);

			o = new ModelRenderer(this, currentObelisk.textureOffsetX, currentObelisk.textureOffsetY);
			o.addBox(currentObelisk.ballOffset[0], currentObelisk.ballOffset[1], currentObelisk.ballOffset[2],currentObelisk.boxBounds[0], currentObelisk.boxBounds[1], currentObelisk.boxBounds[2]);
			o.setRotationPoint(currentObelisk.rotationPoint[0], currentObelisk.rotationPoint[1], currentObelisk.rotationPoint[2]);
			o.setTextureSize(textureWidth, textureHeight);
			o.mirror = true;
			this.setRotation(o, currentObelisk.obeliskRotation[0], currentObelisk.obeliskRotation[1], currentObelisk.obeliskRotation[2]);

			this.obeliskModels.add(o);
		}
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
		for (int i = 0; i < this.obeliskModels.size(); i++) {
			this.obeliskModels.get(i).render(f5);
		}
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}

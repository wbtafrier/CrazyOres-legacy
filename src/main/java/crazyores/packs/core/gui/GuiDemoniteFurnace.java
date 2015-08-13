package crazyores.packs.core.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.packs.core.container.ContainerDemoniteFurnace;
import crazyores.packs.core.entity.tileentity.TileEntityDemoniteFurnace;
import crazyores.packs.core.util.CoreResourceLoader;

@SideOnly(Side.CLIENT)
public class GuiDemoniteFurnace extends GuiContainer {

	private TileEntityDemoniteFurnace tileFurnace;
	
	public GuiDemoniteFurnace(InventoryPlayer invPlayer, TileEntityDemoniteFurnace furnace) {
        super(new ContainerDemoniteFurnace(invPlayer, furnace));
        this.tileFurnace = furnace;
    }

	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        String s = this.tileFurnace.hasCustomInventoryName() ? this.tileFurnace.getInventoryName() : I18n.format(this.tileFurnace.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(CoreResourceLoader.DEMONITE_FURNACE_GUI_IMAGE);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

		if (this.tileFurnace.isBurning()) {
			int i1 = this.tileFurnace.getBurnTimeRemainingScaled(13);
			this.drawTexturedModalRect(k + 46, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
			i1 = this.tileFurnace.getCookProgressScaled(24);
			this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
		}
	}
}

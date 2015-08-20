package crazyores.packs.core.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores.packs.core.container.ContainerDemoniteFurnace;
import crazyores.packs.core.entity.tileentity.TileEntityDemoniteFurnace;
import crazyores.packs.core.util.CoreResourceHandler;

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
		this.mc.getTextureManager().bindTexture(CoreResourceHandler.DEMONITE_FURNACE_GUI_TEXTURE);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

		int scaled;
		if (this.tileFurnace.isBurning()) {
			scaled = this.tileFurnace.getBurnTimeRemainingScaled(13);
			this.drawTexturedModalRect(k + 73, l + 37 + 12 - scaled, 176, 12 - scaled, 14, scaled + 1);
			scaled = this.tileFurnace.getCookProgressScaled(24);
			this.drawTexturedModalRect(k + 106, l + 34, 176, 14, scaled + 1, 16);
		}
		/**
	     * Draws a textured rectangle at the stored z-value. Args: x, y, u, v, width, height
	     */
		scaled = this.tileFurnace.getAgeTimeScaled(40);
		this.drawTexturedModalRect(k + 18, l + 26 + scaled, 176, 31 + scaled, 6, 40 - scaled);
		
		scaled = this.tileFurnace.getWarmthTimeScaled(40);
		this.drawTexturedModalRect(k + 43, l + 65 - scaled, 183, 70 - scaled, 6, scaled + 1);
	}
}

package crazyores_core.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import crazyores_core.common.tileentity.ContainerDemoniteFurnace;
import crazyores_core.common.tileentity.ContainerNames;
import crazyores_core.common.tileentity.TileEntityDemoniteFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiDemoniteFurnace extends GuiContainer
{
    private static final ResourceLocation field_110410_t = new ResourceLocation(ContainerNames.DEMONITE_FURNACE_IMG);
    private TileEntityDemoniteFurnace furnaceInventory;

    public GuiDemoniteFurnace(InventoryPlayer par1InventoryPlayer, TileEntityDemoniteFurnace par2TileEntityDemoniteFurnace)
    {
        super(new ContainerDemoniteFurnace(par1InventoryPlayer, par2TileEntityDemoniteFurnace));
        this.furnaceInventory = par2TileEntityDemoniteFurnace;
    }

    @Override
    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
    	String s = this.furnaceInventory.hasCustomInventoryName() ? this.furnaceInventory.getInventoryName() : I18n.format(this.furnaceInventory.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(field_110410_t);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;

        if (this.furnaceInventory.isBurning())
        {
            i1 = this.furnaceInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(k + 46, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        i1 = this.furnaceInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
    }
}

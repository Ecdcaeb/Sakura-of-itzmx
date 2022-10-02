package com.Hileb.itzmx.gui.Bitdo;

import com.Hileb.itzmx.IdlFramework;
import com.Hileb.itzmx.gui.Bitdo.ContainerBitDo;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiContainerBitDo extends GuiContainer
{
    private static final String TEXTURE_PATH = IdlFramework.MODID + ":" + "textures/gui/bitdo/gui_demo.png";
    private static final ResourceLocation TEXTURE = new ResourceLocation(TEXTURE_PATH);
    private ContainerBitDo inventorySlotsIn_;
    public GuiContainerBitDo(ContainerBitDo inventorySlotsIn)
    {
        super(inventorySlotsIn);
        this.xSize = 176;
        this.ySize = 133;
        inventorySlotsIn_=inventorySlotsIn;
    }
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(TEXTURE);
        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;

        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String title = I18n.format("tile.block_bitdo.name");
        this.fontRenderer.drawString(title, (this.xSize - this.fontRenderer.getStringWidth(title)) / 2, 6, 0x404040);
        if(inventorySlotsIn_.need>0 && inventorySlotsIn_.need<=1024){
            String need = I18n.format("desc.tile.bitdo.string1",inventorySlotsIn_.need);//38 + 2 * 32,52
            this.fontRenderer.drawString(need, 38 + 2 * 32,40, 0x404040);
            String copy=I18n.format("desc.tile.bitdo.string3");
            this.fontRenderer.drawString(copy, 102,26, 0x404040);
        }
        if(inventorySlotsIn_.need>1024){
            String need = I18n.format("desc.tile.bitdo.string2");//38 + 2 * 32,52
            this.fontRenderer.drawString(need, 38 + 2 * 32,40, 0x404040);
            String copy=I18n.format("desc.tile.bitdo.string3");
            this.fontRenderer.drawString(copy, 102,26, 0x404040);
        }
    }
}

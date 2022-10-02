package com.Hileb.itzmx.gui.Bitplanet;

import com.Hileb.itzmx.IdlFramework;
import com.Hileb.itzmx.blocks.blockMisc.BitplanetList;
import com.Hileb.itzmx.gui.Bitdo.ContainerBitDo;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiContainerBitplanet extends GuiContainer
{
    private static final String TEXTURE_PATH = IdlFramework.MODID + ":" + "textures/gui/bitplanet/bitplanet.png";
    private static final ResourceLocation TEXTURE = new ResourceLocation(TEXTURE_PATH);
    private ContainerBitplanet inventorySlotsIn_;
    public GuiContainerBitplanet(ContainerBitplanet inventorySlotsIn)
    {
        super(inventorySlotsIn);
        this.xSize = 176;
        this.ySize = 186;
        inventorySlotsIn_=inventorySlotsIn;
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
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String title = I18n.format("tile.block_bitplanet.name");
        this.fontRenderer.drawString(title, 4, 6, 0x404040);
    }
}

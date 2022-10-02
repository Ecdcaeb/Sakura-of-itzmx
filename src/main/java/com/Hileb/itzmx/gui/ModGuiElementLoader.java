package com.Hileb.itzmx.gui;

import com.Hileb.itzmx.IdlFramework;
import com.Hileb.itzmx.blocks.blockMisc.BitplanetList;
import com.Hileb.itzmx.gui.Bitdo.GuiContainerBitDo;
import com.Hileb.itzmx.gui.Bitplanet.ContainerBitplanet;
import com.Hileb.itzmx.gui.Bitplanet.GuiContainerBitplanet;
import com.Hileb.itzmx.gui.expOne.GuiContainerDemo;
import com.Hileb.itzmx.gui.Bitdo.ContainerBitDo;
import com.Hileb.itzmx.gui.expOne.ContainerDemo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import javax.annotation.Nullable;

//todo
//https://fmltutor.ustc-zzzz.net/3.4.3-GUI%E7%95%8C%E9%9D%A2%E4%B8%AD%E7%9A%84%E4%BA%A4%E4%BA%92.html
public class ModGuiElementLoader implements IGuiHandler {

    public static final int GUI_DEMO = 1;
    public static final int GUI_RESEARCH = 2;
    public static final int GUI_BITDO = 1001;
    public static final int GUI_BITPLANET = 1002;

    public ModGuiElementLoader()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(IdlFramework.instance, this);
    }

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID)
        {
            case GUI_DEMO:
                return new ContainerDemo(player);
            case GUI_BITDO:
                return new ContainerBitDo(player);
            case  GUI_BITPLANET:
                return new ContainerBitplanet(player, BitplanetList.bitplanetList);
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID)
        {
            case GUI_DEMO:
                return new GuiContainerDemo(new ContainerDemo(player));
            case GUI_BITDO:
                return new GuiContainerBitDo(new ContainerBitDo(player));
            case  GUI_BITPLANET:
                return new GuiContainerBitplanet(new ContainerBitplanet(player,BitplanetList.bitplanetList));
            default:
                return null;
        }
    }
}

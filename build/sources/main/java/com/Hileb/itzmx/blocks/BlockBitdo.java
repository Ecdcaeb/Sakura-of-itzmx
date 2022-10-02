package com.Hileb.itzmx.blocks;

import com.Hileb.itzmx.IdlFramework;
import com.Hileb.itzmx.gui.ModGuiElementLoader;
import com.Hileb.itzmx.util.CommonFunctions;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

public class BlockBitdo extends BlockBase  {
    public static BlockPos pos;

    public BlockBitdo(String name,  Material material){
        super(name,material);
        CommonFunctions.addToEventBus(this);
    }
    @SubscribeEvent
    public void openGui(PlayerInteractEvent.RightClickBlock event){
        if(!event.getWorld().isRemote){
            if(!event.getEntityPlayer().isSneaking()){
                if(event.getWorld().getBlockState(event.getPos()).getBlock()==this){
                    IdlFramework.Log("%s,open %s",event.getEntityPlayer().getName(), I18n.format(this.getUnlocalizedName()));
                    pos=event.getPos();
                    event.getEntityPlayer().openGui(IdlFramework.instance, ModGuiElementLoader.GUI_BITDO,event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
                }
            }
        }
    }
}

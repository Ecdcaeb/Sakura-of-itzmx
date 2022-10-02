package com.Hileb.itzmx.events;

import com.Hileb.itzmx.blocks.blockMisc.BitplanetList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class BitplanetLoadEvent extends BitplanetEvent {
    public BitplanetLoadEvent(EntityPlayer player, ItemStack stack, BitplanetList list){
        super(player,stack,list);
    }

    @Override
    public boolean isCancelable() {
        return true;
    }
}

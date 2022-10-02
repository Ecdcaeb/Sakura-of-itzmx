package com.Hileb.itzmx.events;

import com.Hileb.itzmx.blocks.blockMisc.BitplanetList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class BitplanetEvent extends PlayerCopyEvent {
    BitplanetList bitplanetList;
    public BitplanetEvent(EntityPlayer player, ItemStack stack,BitplanetList list){
        super(player,stack);
        bitplanetList=list;
    }

    @Override
    public boolean isCancelable() {
        return false;
    }
}

package com.Hileb.itzmx.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

public class PlayerCopyLoadEvent extends PlayerCopyEvent {
    public PlayerCopyLoadEvent(EntityPlayer player, ItemStack stack){
        super(player,stack);
    }

    @Override
    public boolean isCancelable() {
        return true;
    }
}
/*
public class PlayerCopyEvent extends PlayerEvent {
    public ItemStack result=ItemStack.EMPTY.copy();//if it is a real PlayerCopyEvent ,it is final!
    public PlayerCopyEvent(EntityPlayer player, ItemStack _result){
        super(player);
        result=_result;
    }
    @Override
    public boolean isCancelable() {
        return false;
    }
}
 */

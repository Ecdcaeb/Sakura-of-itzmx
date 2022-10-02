package com.Hileb.itzmx.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;

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

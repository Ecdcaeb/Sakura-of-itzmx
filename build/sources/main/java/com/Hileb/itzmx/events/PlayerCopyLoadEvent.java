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

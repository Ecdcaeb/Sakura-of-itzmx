package com.Hileb.itzmx.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class RainbowJEvent extends PlayerEvent {
    public static long time;
    public RainbowJEvent(EntityPlayer player,long time_){
        super(player);
        time=time_;
    }
    public long getUseWorldTotelTime(){
        return time;
    }
}

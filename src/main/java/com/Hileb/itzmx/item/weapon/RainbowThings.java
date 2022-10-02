package com.Hileb.itzmx.item.weapon;

import com.Hileb.itzmx.item.ItemBase;
import com.Hileb.itzmx.item.ModItems;
import com.Hileb.itzmx.util.CommonFunctions;
import com.Hileb.itzmx.util.EntityUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class RainbowThings extends ItemBase {
    public RainbowThings(String name) {
        super(name);
        CommonFunctions.addToEventBus(this);
    }



}

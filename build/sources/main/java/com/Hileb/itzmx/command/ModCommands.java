package com.Hileb.itzmx.command;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ModCommands {
    public static void give(EntityPlayer player,ItemStack stack){
        if (!player.addItemStackToInventory(stack))
        {
            player.dropItem(stack, false);
        }
    }
}

package com.Hileb.itzmx.blocks.blockMisc;

import net.minecraft.item.ItemStack;

public class BitplanetList {
    public ItemStack[][] itemStacks=new ItemStack[3][9];
    public int item_x=0;
    public int item_y=0;
    public BitplanetList(){
        itemStacks=new ItemStack[3][9];
        item_x=0;
        item_y=0;
    }
    public static BitplanetList bitplanetList=new BitplanetList();
}

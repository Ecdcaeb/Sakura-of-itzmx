package com.Hileb.itzmx.gui.Bitdo;

import com.Hileb.itzmx.IdlFramework;
import com.Hileb.itzmx.events.PlayerCopyEvent;
import com.Hileb.itzmx.events.PlayerCopyLoadEvent;
import com.Hileb.itzmx.item.ModItems;
import ibxm.Player;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.awt.event.KeyEvent;

//https://fmltutor.ustc-zzzz.net/3.4.2-GUI%E7%95%8C%E9%9D%A2%E7%9A%84%E4%B8%AA%E6%80%A7%E5%8C%96%E4%B8%8E%E7%89%A9%E5%93%81%E6%A7%BD%E7%9A%84%E6%B7%BB%E5%8A%A0.html
public class ContainerBitDo extends Container {
    private ItemStackHandler items = new ItemStackHandler(4);

    protected Slot Slot1;
    protected Slot Slot2;
    protected Slot Slot4;
    private ItemStack stackcopy;
    public int need=0;
    private boolean Slot4isEmpty=true;
    EntityPlayer player_;

    public ContainerBitDo(EntityPlayer player)
    {
        super();
        MinecraftForge.EVENT_BUS.register(this);
        player_=player;

        this.addSlotToContainer(this.Slot1 = new SlotItemHandler(items, 0, 38 , 20)
        {
            @Override
            public boolean isItemValid(ItemStack stack)
            {
                return stack != null && stack.getItem() !=ModItems.ITEM_EMC && super.isItemValid(stack);
            }

            @Override
            public int getItemStackLimit(ItemStack stack)
            {
                return 1;
            }
            @Override
          public void onSlotChanged()
            {
                onSlotUpdate(1);
          }
        });


        this.addSlotToContainer(this.Slot2 = new SlotItemHandler(items, 1, 38 + 32, 20)
        {
            @Override
            public boolean isItemValid(ItemStack stack)
            {
                return stack != null && stack.getItem() == ModItems.ITEM_EMC && super.isItemValid(stack);
            }

            @Override
            public int getItemStackLimit(ItemStack stack)
            {
                return 1024;
            }
            @Override
            public void onSlotChanged()
            {
                onSlotUpdate(2);
            }
        });


        this.addSlotToContainer(this.Slot4 = new SlotItemHandler(items, 3, 38 + 3 * 32, 20)
        {
            @Override
            public boolean isItemValid(ItemStack stack)
            {
                return false;
            }
            @Override
            public int getItemStackLimit(ItemStack stack)
            {
                return 0;
            }
            public void onSlotChanged()
            {
                onSlotUpdate(4);

            }
        });

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 51 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 109));
        }


    }


    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
        //return playerIn.getHeldItemOffhand().getItem() == ModItems.DEBUG_ITEM_3;
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn)
    {
        //if the gui does not connects a tile entity, this must be manually rewritten
        super.onContainerClosed(playerIn);

        if (playerIn.isServerWorld())
        {
            ItemStack Stack1 = this.Slot1.getStack();
            if (Stack1 != ItemStack.EMPTY)
            {
                playerIn.addItemStackToInventory(Stack1);
                this.Slot1.putStack(ItemStack.EMPTY);
            }
            ItemStack Stack2 = this.Slot2.getStack();
            if (Stack2 != ItemStack.EMPTY)
            {
                playerIn.addItemStackToInventory(Stack2);
                this.Slot2.putStack(ItemStack.EMPTY);
            }
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        Slot slot = inventorySlots.get(index);

        if (slot == null || !slot.getHasStack())
        {
            return null;
        }

        ItemStack newStack = slot.getStack(), oldStack = newStack.copy();

        //---------------------
        boolean isMerged = false;

        if (index == 0 || index == 1)
        {
            isMerged = mergeItemStack(newStack, 4, 40, true);
        }
        else if (index >= 3 && index < 30)
        {
            isMerged = !Slot1.getHasStack() && newStack.getCount() <= 1 && mergeItemStack(newStack, 0, 1, false)
                    || mergeItemStack(newStack, 30, 39, false);
        }
        else if (index >= 30 && index < 49)
        {
            isMerged = !Slot1.getHasStack() && newStack.getCount() <= 16 && mergeItemStack(newStack, 0, 1, false)
                    || mergeItemStack(newStack, 3, 30, false);
        }

        if (!isMerged)
        {
            return ItemStack.EMPTY;
        }

        //---------------------

        if (!isMerged)
        {
            return ItemStack.EMPTY;
        }

        if (newStack.getCount() == 0)
        {
            slot.putStack(ItemStack.EMPTY);
        }
        else
        {
            slot.onSlotChanged();
        }

        slot.onTake(playerIn, newStack);

        return oldStack;
    }
    private void onSlotUpdate(int i){
        if(i==2){
            if(Slot2.getStack().isEmpty()){
                clearSlot4();
            }
            else {
                if (Slot2.getStack().getCount()>=need){
                    updateSlot4();
                }
                else clearSlot4();
            }
        }
        //IdlFramework.Log("Slot1 changed!");
        if(i==1){
            if(!Slot1.getStack().isEmpty()){
                stackcopy=Slot1.getStack().copy();
                need=getneed(stackcopy.copy());
                updateSlot4();
            }
            else{
                need=0;
                stackcopy=ItemStack.EMPTY.copy();
                clearSlot4();
            }
            if(Slot2.getStack().copy().isEmpty()){
                clearSlot4();
            }
            else if(need>1024 || need<=0){
                clearSlot4();
            }
            else if (Slot2.getStack().copy().getCount()<need){
                clearSlot4();
            }
            int theneed=getneed(Slot4.getStack().copy());
            if(theneed!=need){
                if(stackcopy.isEmpty())clearSlot4();
                else putSlot4(stackcopy.copy());
                updateSlot4();
            }
        }


        //IdlFramework.Log("Slot4 changed!");
        if(i==4){
            if(!Slot4isEmpty){
                if(Slot4.getStack().isEmpty()){
                    if(!Slot2.getStack().copy().isEmpty())updateSlot4();
                    PlayerCopyEvent event=new PlayerCopyEvent(player_,stackcopy.copy());//it is final,修改它不会有任何效果！
                    MinecraftForge.EVENT_BUS.post(event);
                    Slot2.getStack().setCount(Slot2.getStack().getCount()-need);
                    return;
                }
            }
            if (!Slot4.getStack().isEmpty()){
                if(Slot2.getStack().copy().isEmpty()){
                    clearSlot4();
                    return;
                }
            }
        }
    }
    private void clearSlot4(){
        Slot4.putStack(ItemStack.EMPTY.copy());
        Slot4isEmpty=true;
    }
    private void putSlot4(ItemStack stack){
        if(!Slot2.getStack().isEmpty()){
            if(Slot2.getStack().getCount()>=need){
                if(need>0 && need<=1024){
                    Slot4.putStack(stack);
                    Slot4isEmpty=false;
                }
            }
        }
    }
    private void updateSlot4(){
        if(Slot4.getStack().isEmpty() && need!=0 && !Slot2.getStack().isEmpty()){
            if(!Slot1.getStack().isEmpty()){
                if(!stackcopy.isEmpty()){
                    if(!Slot2.getStack().isEmpty()){
                        if(Slot2.getStack().getCount()>=need && need<=1024){
                            ItemStack copy___=stackcopy.copy();//发布事件，便于mod魔改！
                            PlayerCopyLoadEvent event=new PlayerCopyLoadEvent(player_,copy___);
                            if(!MinecraftForge.EVENT_BUS.post(event))putSlot4(event.result.copy());
                        }
                    }
                }
            }
        }
    }
    private int getneed(ItemStack stack){
        if(stack.hasTagCompound()){
            if(stack.getTagCompound().hasKey("CopyCost") && stack.getTagCompound().getInteger("CopyCost")>0){
                return stack.getTagCompound().getInteger("CopyCost");
            }else{
                return stack.getTagCompound().toString().length()+1;
            }
        }
        else{return 1;}
    }
}

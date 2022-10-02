/*
Sakura of itzmx
Hileb
2022/8/21

Bitplanet ContainerBitplanet.java
this is the Gui of Bitplanet(not bitcomet(haha));
*/

package com.Hileb.itzmx.gui.Bitplanet;

import com.Hileb.itzmx.IdlFramework;
import com.Hileb.itzmx.blocks.blockMisc.BitplanetList;
import com.Hileb.itzmx.events.BitplanetEvent;
import com.Hileb.itzmx.events.BitplanetLoadEvent;
import com.Hileb.itzmx.item.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.lwjgl.input.Keyboard;


//https://fmltutor.ustc-zzzz.net/3.4.2-GUI%E7%95%8C%E9%9D%A2%E7%9A%84%E4%B8%AA%E6%80%A7%E5%8C%96%E4%B8%8E%E7%89%A9%E5%93%81%E6%A7%BD%E7%9A%84%E6%B7%BB%E5%8A%A0.html
public class ContainerBitplanet extends Container {
    BitplanetList bitplanetList_=new BitplanetList();
    private final boolean ts_mode =false;//调试模式，打包时应为false!
    private ItemStack the_last_stack;//上次的itemstack，避免double
    private ItemStack[][] itemStacks;//来自储存的itemstack
    private int item_x=0;//存入itemstack的光标_x
    private int item_y=0;//存入itemstack的光标_y
    private int money=0;//钱——同步于Slot_cost
    private boolean Slot_27_update=true;
    private ItemStackHandler items = new ItemStackHandler(29);//物品栏（GUI）

    protected Slot Slot_in;//拷贝
    protected Slot Slot_cost;//消费

    protected Slot[][] Slot_out=new Slot[3][9];
    private boolean[][] SlotisEmpty=new boolean[3][9];

    private EntityPlayer player;

    public ContainerBitplanet(EntityPlayer player_, BitplanetList bitplanetList)
    {
        super();
        for (int x=0;x<3;x++){
            for (int y=0;y<9;y++){
                SlotisEmpty[x][y]=true;
            }
        }
        itemStacks=bitplanetList.itemStacks;
        item_x=bitplanetList.item_x;
        item_y=bitplanetList.item_y;
        bitplanetList_=bitplanetList;
        MinecraftForge.EVENT_BUS.register(this);
        player=player_;
        this.addSlotToContainer(this.Slot_in = new SlotItemHandler(items, 27, 8, 18)
        {
            @Override
            public boolean isItemValid(ItemStack stack)
            {
                return ((!stack.isEmpty())&&(stack.getItem()!=ModItems.ITEM_EMC));
            }

            @Override
            public int getItemStackLimit(ItemStack stack)
            {
                return 1;
            }

            @Override
            public void onSlotChanged() {
                super.onSlotChanged();
                onSlotUpdate(1000);
            }
        });
        this.addSlotToContainer(this.Slot_cost = new SlotItemHandler(items, 28, 152, 18)
        {
            @Override
            public boolean isItemValid(ItemStack stack)
            {
                return stack.getItem()== ModItems.ITEM_EMC;
            }

            @Override
            public int getItemStackLimit(ItemStack stack)
            {
                return 1024;
            }
            @Override
            public void onSlotChanged() {
                super.onSlotChanged();
                onSlotUpdate(1001);
            }

        });
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(this.Slot_out[i][j] = new SlotItemHandler(items, i*9+j, 8 + (j * 18), 39 +( i * 18))
                {
                    @Override
                    public boolean isItemValid(ItemStack stack)
                    {
                        return false;
                    }

                    @Override
                    public int getItemStackLimit(ItemStack stack)
                    {
                        return 1;
                    }

                    @Override
                    public boolean canTakeStack(EntityPlayer playerIn){
                        return true;
                    }
                    @Override
                    public void onSlotChanged()
                    {
                        super.onSlotChanged();
                        onSlotUpdate(this.slotNumber);
                    }
                });
            }
        }
//玩家物品栏！
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 105 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 163));
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
        //关闭时返回物品（不然吞卡（/xyx））
        super.onContainerClosed(playerIn);
        bitplanetList_.itemStacks=itemStacks;
        bitplanetList_.item_x=item_x;
        bitplanetList_.item_y=item_y;

        if (playerIn.isServerWorld())
        {
            ItemStack Stack1 = this.Slot_in.getStack();
            if (Stack1 != ItemStack.EMPTY)
            {
                playerIn.addItemStackToInventory(Stack1);
                this.Slot_in.putStack(ItemStack.EMPTY);
            }
            ItemStack Stack2 = this.Slot_cost.getStack();
            if (Stack2 != ItemStack.EMPTY)
            {
                playerIn.addItemStackToInventory(Stack2);
                this.Slot_cost.putStack(ItemStack.EMPTY);
            }
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        Slot slot = inventorySlots.get(index);

        if (slot == null || !slot.getHasStack())
        {
            return ItemStack.EMPTY;
        }

        ItemStack newStack = slot.getStack(), oldStack = newStack.copy();

        //---------------------
        boolean isMerged = false;

        if (index == 27 || index == 28)
        {
            isMerged = mergeItemStack(newStack, 29, 65, true);
        }
        else if (index >= 29 && index < 56)
        {
            isMerged = !Slot_in.getHasStack() && newStack.getCount() <= 16 && mergeItemStack(newStack, 0, 1, false)
                    || !Slot_cost.getHasStack() && mergeItemStack(newStack, 2, 3, false)
                    || mergeItemStack(newStack, 56, 65, false);
        }
        else if (index >= 31 && index < 40)
        {
            isMerged = !Slot_in.getHasStack() && newStack.getCount() <= 16 && mergeItemStack(newStack, 0, 1, false)
                    || !Slot_cost.getHasStack() && mergeItemStack(newStack, 2, 3, false)
                    || mergeItemStack(newStack, 29, 56, false);
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
    //复制部分的核心
    private void onSlotUpdate(int i){
        Log("{bitplanet:onSlotUpdate i=%d",i);
        if(i==1000){//in
            if(Slot_27_update){
                Slot_27_update=false;
                Log("item_x=%d,item_y=%d",item_x,item_y);
                if(!Slot_in.getStack().isEmpty()){
                    boolean canputit=false;
                    ItemStack stack=Slot_in.getStack();
                    if(item_x==0 && item_y==0){
                        Log("the_last_stack==first!");
                        the_last_stack=Slot_in.getStack().copy();
                        canputit=true;
                    }
                    else{
                        if (stack.copy()==the_last_stack){
                            Log("禁止了stack的放入！");
                            canputit=false;
                        }
                        else{
                            Log("不为0且可以放入！");
                            canputit=true;
                        }
                    }
                    if(item_y==9){
                        item_x++;
                        item_y=0;
                    }
                    if(item_x<3 && item_y<9) {
                        if(canputit){
                            itemStacks[item_x][item_y]=Slot_in.getStack().copy();
                            Log("itemadd i=%d,j=%d,item=%s",item_x,item_y,itemStacks[item_x][item_y].getUnlocalizedName());
                            item_y++;
                            if(ts_mode){
                                for (int x=0;x<3;x++){
                                    for (int y=0;y<9;y++){
                                        if(turntoint(x,y)<turntoint(item_x,item_y)){
                                            Log("{播报！}itemstacks[%d][%d]=%s",x,y,itemStacks[x][y].copy().getUnlocalizedName());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                put_and_update();
                return;
            }
            else Slot_27_update=true;
            return;
        }
        //IdlFramework.Log("Slot1 changed!");
        if(i==1001){//cost
            if(!Slot_cost.getStack().isEmpty() && Slot_cost.getStack().getItem()==ModItems.ITEM_EMC){
                money=Slot_cost.getStack().getCount();
            }
            else money=0;
            Log("money=%d",money);
            put_and_update();
            return;
        }
        //IdlFramework.Log("Slot4 changed!");
        for(int x=0;x<3;x++){
            for (int y=0;y<9;y++){
                if(!SlotisEmpty[x][y]) {//如果xx不应为空（不在代码中清空），而xx为空，则被玩家拿走
                    if (turntoint(x, y) < turntoint(item_x, item_y)) {
                        //Log.warn("i=%d,j=%d",x,y);
                        if (Slot_out[x][y].getStack().isEmpty() && itemStacks[x][y] != null && !itemStacks[x][y].copy().isEmpty()) {
                            //Log.warn("warn____i=%d,j=%d",x,y);
                            ItemStack field_77158_a=itemStacks[x][y].copy();
                            BitplanetEvent event=new BitplanetEvent(player,field_77158_a.copy(),bitplanetList_);//see only
                            MinecraftForge.EVENT_BUS.post(event);
                            putSlot(x, y, field_77158_a);
                            //支付复制价
                            Log("pay %d for %s", getcopycost(itemStacks[x][y].copy()), itemStacks[x][y].copy().getUnlocalizedName());
                            Slot_cost.getStack().setCount(Slot_cost.getStack().getCount() - getcopycost(itemStacks[x][y].copy()));
                        }
                    }
                }
            }
        }
    }
    //一些函数
    private void put_and_update(){
        for(int x=0;x<3;x++){
            for (int y=0;y<9;y++){
                if(itemStacks[x][y]!=null){
                    Log("i=%d,j=%d,item[%d][%d]!=null! it==%s",x,y,x,y,itemStacks[x][y].copy().getUnlocalizedName());
                    if(money>=getcopycost(itemStacks[x][y].copy()) && money!=0){
                        ItemStack itemStacks_77158=itemStacks[x][y].copy();
                        BitplanetLoadEvent event=new BitplanetLoadEvent(player,itemStacks_77158,bitplanetList_);
                        if (!MinecraftForge.EVENT_BUS.post(event)){
                            putSlot(x,y,itemStacks_77158);
                            Log("put item:%s i=%d,j=%d，cost=%d",itemStacks[x][y].getUnlocalizedName(),x,y,getcopycost(itemStacks[x][y].copy()));
                        }
                    }
                    else cleanSlot(x,y);
                }
            }
        }
    }
    private int getcopycost(ItemStack stack){
        if(stack.hasTagCompound()){
            if(stack.getTagCompound().hasKey("CopyCost") && stack.getTagCompound().getInteger("CopyCost")>0){
                return stack.getTagCompound().getInteger("CopyCost");
            }else{
                return stack.getTagCompound().toString().length()+1;
            }
        }
        else{return 1;}
    }
    private void cleanSlot(int i,int j){
        Slot_out[i][j].putStack(ItemStack.EMPTY.copy());
        SlotisEmpty[i][j]=true;
    }
    private void putSlot(int i,int j ,ItemStack stack ){
        Slot_out[i][j].putStack(stack.copy());
        SlotisEmpty[i][j]=false;
        Log("{bitplanet:putSlot:i=%d,j=%d,item=%s}",i,j,stack.getUnlocalizedName());
    }
    private int turntoint(int i,int j){
        return (i*9)+j;
    }
    private void Log(String str){
        if (ts_mode)IdlFramework.Log(str);
    }
    private void Log(String str,Object... args){
        if (ts_mode)IdlFramework.Log(str,args);
    }
}

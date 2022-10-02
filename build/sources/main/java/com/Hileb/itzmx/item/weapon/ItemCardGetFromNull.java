package com.Hileb.itzmx.item.weapon;

import com.Hileb.itzmx.command.ModCommands;
import com.Hileb.itzmx.init.ModLootList;
import com.Hileb.itzmx.item.ItemBase;
import com.Hileb.itzmx.item.ItemInformationAdder;
import com.Hileb.itzmx.item.ModItems;
import com.Hileb.itzmx.meta.MetaUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.handshake.FMLHandshakeMessage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.libraries.ModList;

import java.util.List;
import java.util.Random;

public class ItemCardGetFromNull extends ItemBase {
    private final ItemInformationAdder ItemDesc=new ItemInformationAdder("item.item_card_get_from_null.desc1","item.item_card_get_from_null.desc2");
    public ItemCardGetFromNull(){
        super("item_card_get_from_null");
        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void onUse(PlayerInteractEvent.RightClickItem event){
        World world=event.getWorld();
        if(!world.isRemote){
            if(event.getEntityPlayer()!=null){
                EntityPlayer player=event.getEntityPlayer();
                if(player.getHeldItemMainhand().getItem()==this){
                    if (MetaUtil.isLoaded_Momostories) {
                        int ran = new Random().nextInt(29);
                        String str=null;
                        switch (ran) {
                            case 0:
                                str="momostories:adjudicator_balance";
                                break;
                            case 1:
                                str="momostories:oham_heavy_cavalry_regiment";
                                break;
                            case 2:
                                str="momostories:erin";
                                break;
                            case 3:
                                str="momostories:soul_puppets";
                                break;
                            case 4:
                                str="momostories:lucy_the_axe_card";
                                break;
                            case 5:
                                str="momostories:devils_blood";
                                break;
                            case 6:
                                str="momostories:blood_colored_calidan";
                                break;
                            case 7:
                                str="momostories:leyden_jar";
                                break;
                            case 8:
                                str="momostories:fort_slim";
                                break;
                            case 9:
                                str="momostories:garland_redemption";
                                break;
                            case 10:
                                str="momostories:conscription_order";
                                break;
                            case 11:
                                str="momostories:alchemist_medal";
                                break;
                            case 12:
                                str="momostories:forgotten_ancient_mirrors";
                                break;
                            case 13:
                                str="momostories:the_supreme_magi_deep_lake";
                                break;
                            case 14:
                                str="momostories:luna_church";
                                break;
                            case 15:
                                str="momostories:church_of_the_sun_god";
                                break;
                            case 16:
                                str="momostories:the_book_of_forgery";
                                break;
                            case 17:
                                str="momostories:plague_doctor";
                                break;
                            case 18:
                                str="momostories:fraudulent_bottles";
                                break;
                            case 19:
                                str="momostories:twist";
                                break;
                            case 20:
                                str="momostories:the_book_of_manifestation";
                                break;
                            case 21:
                                str="momostories:daytime";
                                break;
                            case 22:
                                str="momostories:night";
                                break;
                            case 23:
                                str="momostories:fine";
                                break;
                            case 24:
                                str="momostories:dark_clouds";
                                break;
                            case 25:
                                str="momostories:the_fruit_of_the_flowing_years_card";
                                break;
                            case 26:
                                str="momostories:freshman";
                                break;
                            case 27:
                                str="momostories:reed";
                                break;
                            case 28:
                                str="itzmx:item_card_get_from_null";
                                break;
                        }
                        if (str!=null){
                            if (Item.getByNameOrId(str)!=null){
                                ItemStack stack=new ItemStack(Item.getByNameOrId(str));
                                ModCommands.give(player,stack.copy());
                            }
                            else give(player);
                        }
                        else give(player);
                    }
                    else{
                        give(player);
                    }
                    if (!player.isCreative()){
                        player.getHeldItemMainhand().shrink(1);
                    }
                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        ItemDesc.func_addInformation_item_base(stack,world,tooltip,flag);
    }
    private void give(EntityPlayer player){
        ModCommands.give(player,new ItemStack(ModItems.ITEM_CARD_NULL));
        ModCommands.give(player,new ItemStack(ModItems.ITEM_MAIN_TR));
        ModCommands.give(player,new ItemStack(ModItems.ITEM_MAIN_XK));
    }
}

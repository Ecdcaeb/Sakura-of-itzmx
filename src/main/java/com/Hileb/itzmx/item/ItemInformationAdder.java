package com.Hileb.itzmx.item;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.List;

@SideOnly(Side.CLIENT)
public class ItemInformationAdder {
    public String lang;
    public String langS;
    private Boolean lvl;
    public boolean isNull;
    public ItemInformationAdder(){
        isNull=true;
    }
    public ItemInformationAdder(String langq,String langSq){
        lang=langq;//按下lshift
        langS=langSq;//没按下lshift
        lvl=false;
        isNull=false;
    }
    public ItemInformationAdder(String langq){
        lang=langq;//按下lshift
        lvl=true;
        isNull=false;
    }
    public void func_addInformation_item_base(ItemTooltipEvent event){
        if(event.getEntityPlayer()!=null){
            if(event.getEntityPlayer().world.isRemote){//SideOnly();
                func_addInformation_item_base(event.getItemStack(),event.getEntityPlayer().world,event.getToolTip(),event.getFlags());
            }
        }
    }
    public void func_addInformation_item_base(ItemStack stack,World worldIn,List<String> str,ITooltipFlag flagIn){
        if(lvl)addInformations_item_base(stack,worldIn,str,flagIn,lang);
        else addInformations_item_base(stack,worldIn,str,flagIn,lang,langS);
    }
    public void func_addInformation_item_base(List<String> str){
        if(lvl)addInformations_item_base(null,null,str,null,lang);
        else addInformations_item_base(null,null,str,null,lang,langS);
    }

    private void addInformations_item_base(ItemStack stack, World worldIn, List<String> str, ITooltipFlag flagIn,String lang,String langS){
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
            for(String strline:I18n.format(lang).split("\n")){
                str.add(strline);
            }
        }
        else {
            for (String strline:I18n.format(langS).split("\n")){
                str.add(strline);
            }
        }
    }
    private void addInformations_item_base(ItemStack stack, World worldIn, List<String> str, ITooltipFlag flagIn,String lang){
        for (String strline:I18n.format(lang).split("\n")){
            str.add(strline);
        }
    }
    private void addInformations_item_base(List<String> str,String lang){
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
            for(String strline:I18n.format(lang).split("\n")){
                str.add(strline);
            }
        }
        else {
            for (String strline:I18n.format(langS).split("\n")){
                str.add(strline);
            }
        }
    }
    private void addInformations_item_base(List<String> str,String lang,String langS){
        for (String strline:I18n.format(lang).split("\n")){
            str.add(strline);
        }
    }
}

package com.Hileb.itzmx.common;

import com.Hileb.itzmx.IdlFramework;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class SakuraHello {
    private String str;
    private boolean hasdo=false;
    private int time;
    public SakuraHello(String s ,int time_){
        str=s;
        time=time_;
    }
    public void say(World world){
        if(world.getWorldTime()==(time-1)){
            hasdo=true;
        }
        if(world.getWorldTime()==time && hasdo==true){
            hasdo=false;
            hello(world,str);
        }
    }
    private void hello(World world, String str){
        for (int i=0;i<world.playerEntities.size();i++){
            String msg="§f<Sakura>:"+world.playerEntities.get(i).getName()+new TextComponentTranslation(str).getFormattedText();
            world.playerEntities.get(i).sendMessage( new TextComponentString(msg));
        }
    }
}

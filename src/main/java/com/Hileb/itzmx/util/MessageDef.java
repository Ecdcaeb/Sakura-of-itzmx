package com.Hileb.itzmx.util;

import net.minecraft.item.ItemStack;

public class MessageDef {
    //GENERAL:
    public static final String OUT_OF_RANGE = "itzmx.msg.out_of_range";
    public static final String IN_COOLDOWN = "itzmx.skill.msg.cool_down";
    public static final String NOT_CASTABLE_MAINHAND = "itzmx.skill.msg.not_castable_mainhand";
    public static final String NOT_CASTABLE_OFFHAND = "itzmx.skill.msg.not_castable_offhand";

    public static String getSkillCastKey(ItemStack stack, int index)
    {
        //remove"item."
        return String.format("msg.%s.cast.%d", stack.getUnlocalizedName().substring(5), index);
    }
}

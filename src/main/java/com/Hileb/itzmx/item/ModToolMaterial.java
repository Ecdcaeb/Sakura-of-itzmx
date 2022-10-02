package com.Hileb.itzmx.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ModToolMaterial {
    //材料：彩虹
    public static final Item.ToolMaterial TOOL_MATERIAL_RAINBOW =
            EnumHelper.addToolMaterial("material_blood", 3, 5012, 3.0F, 12F, 20).setRepairItem(new ItemStack( ModItems.ITEM_BLOOD_RAINBOW));
    //材料：欺诈钻石！
    public static final Item.ToolMaterial TOOL_FAKE_DIA =
            EnumHelper.addToolMaterial("material_diamond", 3, 1561, 8.0F, 3.0F, 10).setRepairItem(new ItemStack( ModItems.ITEM_BLOOD_RAINBOW));


}

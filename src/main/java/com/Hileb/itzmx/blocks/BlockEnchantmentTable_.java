package com.Hileb.itzmx.blocks;

import com.Hileb.itzmx.init.ModCreativeTab;
import com.Hileb.itzmx.item.ModItems;
import net.minecraft.block.BlockEnchantmentTable;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;

public class BlockEnchantmentTable_ extends BlockEnchantmentTable{
    public BlockEnchantmentTable_(){
        super();
        setUnlocalizedName("block_enchantment_table");
        setRegistryName("block_enchantment_table");
        setCreativeTab(ModCreativeTab.IDL_MISC);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        setHardness(5.0F);
        setLightOpacity(1);
        MinecraftForge.EVENT_BUS.register(this);
    }
}

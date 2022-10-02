package com.Hileb.itzmx.blocks;

import com.Hileb.itzmx.blocks.tileEntity.ItzmxDoorBlockBace;
import com.Hileb.itzmx.blocks.tileEntity.ItzmxWorldsakuraBlock;
import com.Hileb.itzmx.init.ModCreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	/*
	 * To add a block, put a line here,
	 * -Create a json at assets.eo.blockstates
	 * -Create a json at assets.eo.models.block
	 * -Create a json at assets.eo.models.item
	 * -Add corresponding texture png
	 */

	//public static final Block GRID_BLOCK_1 = new BlockBase("test", Material.CLAY).setCreativeTab(ModCreativeTab.IDL_MISC).setHardness(15f);
	public static final Block BLOCK_RAINBOW = new BlockBase("block_rainbow", Material.GOURD).setCreativeTab(ModCreativeTab.IDL_MISC).setHardness(50f);
//
    public static final Block BLOCK_BITPLANET = new BlockBitplanet("block_bitplanet", Material.GOURD).setCreativeTab(ModCreativeTab.IDL_MISC).setHardness(3f);
	public static final Block BLOCK_BITDO = new BlockBitdo("block_bitdo", Material.GOURD).setCreativeTab(ModCreativeTab.IDL_MISC).setHardness(15f);


	public static final Block BLOCK_WORLDSAKURA = new ItzmxWorldsakuraBlock("block_worldsakura", Material.GOURD).setCreativeTab(ModCreativeTab.IDL_MISC).setHardness(3f);
	public static final Block BLOCK_WORLDSAKURAWa = new ItzmxDoorBlockBace("block_worldsakurawa", Material.GOURD).setCreativeTab(ModCreativeTab.IDL_MISC).setHardness(3f);

	//public static final Block BLOCK_ENCHANTMENT_TABLE=new BlockEnchantmentTable_();
	public static final Block BLOCK_INFINITY_CAKE=new BlockInfinityCake();

}

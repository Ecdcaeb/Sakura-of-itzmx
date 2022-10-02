package com.Hileb.itzmx.blocks;

import com.Hileb.itzmx.IdlFramework;
import com.Hileb.itzmx.init.ModCreativeTab;
import com.Hileb.itzmx.item.ItemInformationAdder;
import com.Hileb.itzmx.item.ModItems;
import com.Hileb.itzmx.util.CommonFunctions;
import com.Hileb.itzmx.util.IDLSkillNBT;
import com.Hileb.itzmx.util.IHasModel;

import com.Hileb.itzmx.util.NBTStrDef.IDLNBTDef;
import com.Hileb.itzmx.util.NBTStrDef.IDLNBTUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlockBase extends Block implements IHasModel
{
	private ItemInformationAdder itemInformationAdder;
	public BlockBase(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModCreativeTab.IDL_MISC);;

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		itemInformationAdder=new ItemInformationAdder();

		setHardness(5.0F);
		//setResistance(1000.0F);
		//setHarvestLevel("pickaxe", 1);
		//setLightLevel(1f);
		setLightOpacity(1);
		CommonFunctions.addToEventBus(this);
	}
	public BlockBase(String name, Material material, ItemInformationAdder ItemDesc_)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModCreativeTab.IDL_MISC);;
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		itemInformationAdder=ItemDesc_;

		setHardness(5.0F);
		//setResistance(1000.0F);
		//setHarvestLevel("pickaxe", 1);
		//setLightLevel(1f);
		setLightOpacity(1);
		CommonFunctions.addToEventBus(this);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return super.getItemDropped(state, rand, fortune);
	}

	@Override
	public int quantityDropped(Random rand) {
		return super.quantityDropped(rand);
	}
	
	@Override
	public void registerModels() {
		IdlFramework.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
		return this==ModBlocks.BLOCK_RAINBOW;
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void event_tooltip(ItemTooltipEvent event){
		if(event.getEntityPlayer()!=null){
			if(event.getItemStack().getItem()==Item.getByNameOrId(this.getRegistryName().toString())){
				if (I18n.hasKey(this.getUnlocalizedName()+".desc")){
					event.getToolTip().add(I18n.format(this.getUnlocalizedName()+".desc"));
				}
				if (!itemInformationAdder.isNull){
					itemInformationAdder.func_addInformation_item_base(event.getToolTip());
				}
			}
		}
	}
}

package com.Hileb.itzmx.blocks;

import com.Hileb.itzmx.command.ModCommands;
import com.Hileb.itzmx.item.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockInfinityCake extends BlockBase {
    protected static final AxisAlignedBB CAKE_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.5D, 0.9375D);


    public BlockInfinityCake(){
        super("block_infinitycake", Material.CAKE);
    }
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return CAKE_AABB;
    }
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return CAKE_AABB;
    }
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!worldIn.isRemote)
        {
            this.eatCake(worldIn, pos, state, playerIn);
            return false;
        }
        else
        {
            return false;
        }
    }
    private boolean eatCake(World world, BlockPos pos,IBlockState state,EntityPlayer player){
        if(!world.isRemote){
            if (player!=null){
                player.playSound(SoundEvents.ENTITY_GENERIC_EAT,1.0F,1.0F);
                player.getFoodStats().addStats(2, 0.1F);
                //ModCommands.give(player,new ItemStack(ModItems.ITEM_RAINBOW));
                return true;
            }
            else return false;
        }
        else return false;
    }
//    @Override
//    public boolean isFullCube(IBlockState state)
//    {
//        return false;
//    }
//
//    @Override
//    public boolean isFullBlock(IBlockState state) {
//        return false;
//    }
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public BlockRenderLayer getBlockLayer()
//    {
//        return BlockRenderLayer.CUTOUT;
//    }

}

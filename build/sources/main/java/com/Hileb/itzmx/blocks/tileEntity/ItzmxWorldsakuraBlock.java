package com.Hileb.itzmx.blocks.tileEntity;

import com.Hileb.itzmx.Advancements.Advancementkeys;
import com.Hileb.itzmx.Advancements.ModAdvancementsInit;
import com.Hileb.itzmx.IdlFramework;
import com.Hileb.itzmx.blocks.ModBlocks;
import com.Hileb.itzmx.command.ModCommands;
import com.Hileb.itzmx.item.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.command.CommandFunction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItzmxWorldsakuraBlock extends ItzmxDoorBlockBace {
    public ItzmxWorldsakuraBlock(String name, Material material) {
        super(name,material);
        this.setLightLevel(1.0f);
        this.setHardness(50f);
        this.setResistance(6000000.99f);
        MinecraftForge.EVENT_BUS.register(this);
    }
    public static void function_TpToItzmx(){
        //player.attemptTeleport(player.posX+1,player.posY,player.posZ);//attemptTeleport



        //异世界传送门
        String url=new String();
        url="https://bbs.itzmx.com/";

        try{
            Process process = Runtime.getRuntime().exec("cmd /c start "+url);
            IdlFramework.logger.info("§fOpen the web successfully");
            IdlFramework.logger.info("somebody 传送至了论坛！");
            return;

        }
        catch (Exception e){
            IdlFramework.logger.info("§fWARN");
            return;
        }
    }
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if(entityIn instanceof EntityPlayer){
            //entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 1.0F);
            EntityPlayer player=(EntityPlayer) entityIn;//pos.getZ()
            if((entityIn.world.getBlockState(new BlockPos(pos.getX()+1,pos.getY(),pos.getZ())).getBlock()==ModBlocks.BLOCK_WORLDSAKURAWa)&&(entityIn.world.getBlockState(new BlockPos(pos.getX()-1,pos.getY(),pos.getZ())).getBlock()==ModBlocks.BLOCK_WORLDSAKURAWa)&&(entityIn.world.getBlockState(new BlockPos(pos.getX(),pos.getY(),pos.getZ()+1)).getBlock()==ModBlocks.BLOCK_WORLDSAKURAWa)&&(entityIn.world.getBlockState(new BlockPos(pos.getX(),pos.getY(),pos.getZ()-1)).getBlock()==ModBlocks.BLOCK_WORLDSAKURAWa)&&(entityIn.world.getBlockState(new BlockPos(pos.getX()+1,pos.getY(),pos.getZ()+1)).getBlock()==ModBlocks.BLOCK_WORLDSAKURAWa)&&(entityIn.world.getBlockState(new BlockPos(pos.getX()+1,pos.getY(),pos.getZ()-1)).getBlock()==ModBlocks.BLOCK_WORLDSAKURAWa)&&(entityIn.world.getBlockState(new BlockPos(pos.getX()-1,pos.getY(),pos.getZ()+1)).getBlock()==ModBlocks.BLOCK_WORLDSAKURAWa)&&(entityIn.world.getBlockState(new BlockPos(pos.getX()-1,pos.getY(),pos.getZ()-1)).getBlock()==ModBlocks.BLOCK_WORLDSAKURAWa)){
                player.attemptTeleport(player.posX+1.0f,player.posY+1,player.posZ);//attemptTeleport
                function_TpToItzmx();
            }
            else{
                player.attemptTeleport(player.posX+1.0f,player.posY+1,player.posZ);//attemptTelepor
                player.sendMessage(new TextComponentString("无论你怎么努力，传送门依然没有半点动静，也许你需要考虑传送门是否搭建正确，"));
            }
        }

        super.onEntityWalk(worldIn, pos, entityIn);
    }

//    @SubscribeEvent
//    public void CheckTheItzmxBlock(PlayerInteractEvent.RightClickBlock event){
//        if(!event.getWorld().isRemote){
//            if(event.getWorld().getBlockState(event.getPos()).getBlock()== ModBlocks.BLOCK_WORLDSAKURA){
//                function_TpToItzmx();
//            }
//        }
//    }
//    @SubscribeEvent
//    public void  playerontheBloke(InputUpdateEvent event){
//        if(!event.getEntityPlayer().getEntityWorld().isRemote){
//            BlockPos posdown = new BlockPos(event.getEntityPlayer().posX,event.getEntityPlayer().posY,event.getEntityPlayer().posZ);
//            BlockPos posup = new BlockPos(event.getEntityPlayer().posX,event.getEntityPlayer().posY+1,event.getEntityPlayer().posZ);
//            if((event.getEntityPlayer().getEntityWorld().getBlockState(posdown).getBlock()==ModBlocks.BLOCK_WORLDSAKURA) || (event.getEntityPlayer().getEntityWorld().getBlockState(posup).getBlock()==ModBlocks.BLOCK_WORLDSAKURA)){
//                function_TpToItzmx();
//            }
//        }
//
//    }
    //操作的穿透
    /*@Override
    public boolean isCollidable(){
        return false;
    }*/
    //碰撞箱null
//    @Override
//    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
//        return Block.NULL_AABB;
//    }
    @SubscribeEvent
    public void ondo(BlockEvent.PlaceEvent event){
        World world=event.getWorld();
        if (!world.isRemote){
            EntityPlayer player=event.getPlayer();
            if(player!=null){
                if(event.getPlacedBlock().getBlock()==this){
                    if(ModAdvancementsInit.giveAdvancement(player, Advancementkeys.AD_ITZMXBLOCK)){
                        ModCommands.give(player,new ItemStack(ModItems.ITEM_SAKURA_ITZMX));
                    }
                }
            }
        }
    }
}

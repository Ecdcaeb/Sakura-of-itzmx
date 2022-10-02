/*
Hileb
2022
itzmx
Sakura of Itzmx
ItemItzmxJ.java
*/
package com.Hileb.itzmx.item.weapon;

import com.Hileb.itzmx.IdlFramework;
import com.Hileb.itzmx.command.ModCommands;
import com.Hileb.itzmx.enchantments.ModEnchantmentInit;
import com.Hileb.itzmx.events.RainbowJEvent;
import com.Hileb.itzmx.init.ModCreativeTab;
import com.Hileb.itzmx.item.ItemSwordBase;
import com.Hileb.itzmx.util.CommonFunctions;
import com.Hileb.itzmx.util.EntityUtil;
import com.Hileb.itzmx.util.IDLNBT;
import com.Hileb.itzmx.util.NBTStrDef.IDLNBTUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;
import java.util.Random;

public class ItemItzmxJ extends ItemSwordBase {
    public boolean only=false;
    public ItemItzmxJ(String name, ToolMaterial material) {
        super(name, material);
        CommonFunctions.addToEventBus(this);
    }
    @SubscribeEvent
    public void onAttack(LivingHurtEvent event){
        World world = event.getEntity().world;
        if(!world.isRemote){
            EntityLivingBase hurtOne = event.getEntityLiving();
            EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();

           // if(attacker.getHeldItemMainhand().getItem() == this){
           //     EntityUtil.ApplyBuff(attacker, MobEffects.NAUSEA,1,1);
           // }

            if(attacker != null && attacker.getHeldItemMainhand().getItem() == this){
                    if(attacker.getHeldItemMainhand().getItem().getDamage(attacker.getHeldItemMainhand())<=5012){
                        EntityUtil.ApplyBuff(hurtOne, MobEffects.POISON,1,10);
                        EntityUtil.ApplyBuff(attacker, MobEffects.NAUSEA,2,1);
                        EntityUtil.ApplyBuff(attacker, MobEffects.INSTANT_HEALTH,2,1);
                    }
                    else{
                        attacker.sendMessage(new TextComponentString("§l§3彩虹剑已经没有耐久了！"));
                        event.isCanceled();
                    }
            }
        }
    }
    @SubscribeEvent
    public  void PlayerRightClickBlockEvent(PlayerInteractEvent.LeftClickBlock event){
        World world=event.getWorld();
        if(!world.isRemote){
            if(event.getEntityPlayer().getHeldItemMainhand().getItem() == this) {
                //if(world.getBlockState(event.getPos()).getBlock()== Blocks.GOLD_BLOCK)
                if(event.getEntityPlayer().getHeldItemMainhand().getItem().getDamage(event.getItemStack())<=4512) {
                    Random rsss = new Random();
                    Boolean boolssss = new Boolean(false);

                    rsss.setSeed(rsss.nextLong());
                    int a1 = rsss.nextInt(9);
                    rsss.setSeed(rsss.nextLong());
                    int a2 = rsss.nextInt(9);
                    rsss.setSeed(rsss.nextLong());
                    int a3 = rsss.nextInt(9);
                    rsss.setSeed(rsss.nextLong());
                    int a4 = rsss.nextInt(9);
                    rsss.setSeed(rsss.nextLong());
                    int a5 = rsss.nextInt(9);
                    rsss.setSeed(rsss.nextLong());
                    int a6 = rsss.nextInt(9);
                    rsss.setSeed(rsss.nextLong());
                    int a7 = rsss.nextInt(9);
                    rsss.setSeed(rsss.nextLong());
                    int a8 = rsss.nextInt(9);
                    String str = new String();
                    str = "§" + a1 + "彩" + "§" + a2 + "虹" + "§" + a3 + "剑" + "§" + a4 + ":" + "§" + a5 + "撕" + "§" + a6 + "裂" + "§" + a7 + "斩" + "§" + a8 + "击";
                    IdlFramework.logger.info("someone use 彩红剑！\n" + str);


                    rsss.setSeed(rsss.nextLong());
                    if (rsss.nextInt(100) >= 85) {
                        boolssss = true;
                    } else boolssss = false;


                    world.destroyBlock(event.getPos(), boolssss);
                    event.getEntityPlayer().sendMessage(new TextComponentString(str));

                    if (boolssss == false) {
                        event.getEntityPlayer().sendMessage(new TextComponentString("§5方块被斩碎所以没有掉落"));
                    }
                    event.getEntityPlayer().getHeldItemMainhand().getItem().setDamage(event.getItemStack(), event.getEntityPlayer().getHeldItemMainhand().getItem().getDamage(event.getItemStack()) + 500);
                    if (event.getEntityPlayer().getHeldItemMainhand().getItem().getDamage(event.getItemStack()) >= 5012) {
                        event.getEntityPlayer().getHeldItemMainhand().getItem().setDamage(event.getItemStack(), 5012);

                    }
                }
                else{
                    event.getEntityPlayer().sendMessage(new TextComponentString("§l§3彩虹剑已经没有耐久了！"));
                }


            }
        }
    }
    @SubscribeEvent
    public void isBroken(PlayerDestroyItemEvent event){
        World world=event.getEntityPlayer().world;
        if(!world.isRemote){
            if(event.getOriginal().getItem()==this){
                EntityPlayer player=event.getEntityPlayer();
                event.isCanceled();
                player.sendMessage(new TextComponentString("§f你的剑受神秘力量保护，不可破坏！"));
                ItemStack stack=event.getOriginal();
                stack.getItem().setDamage(stack, 5011);
                ModCommands.give(player,stack);
            }
        }
    }
    @SubscribeEvent
    public void isRightClick(PlayerInteractEvent.RightClickItem event){
        World world=event.getWorld();
        if(!world.isRemote){
            if(event.getEntityPlayer()!=null){
                EntityPlayer player=event.getEntityPlayer();
                ItemStack stack=player.getHeldItemMainhand();
                if(stack.getItem() instanceof ItemItzmxJ){
                    EntityUtil.ApplyBuff(player, MobEffects.SPEED,5,1);
                    if(stack.isItemEnchanted()){
                        if(ModEnchantmentInit.ENCH_RAINBOW.getLevelOnCreature((EntityLivingBase)player)>0){
                            RainbowJEvent rainbowJEvent=new RainbowJEvent(player,world.getTotalWorldTime());
                            MinecraftForge.EVENT_BUS.post(rainbowJEvent);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if(tab== ModCreativeTab.IDL_MISC){
            ItemStack stack=new ItemStack(this);
            stack.setTranslatableName("itemname.rainbowj.name");
            stack.addEnchantment(ModEnchantmentInit.ENCH_AROMATIC,1);
            items.add(stack);
//            ItemStack stack1=new ItemStack(this);
//            NBTTagCompound tag=JsonToNBT.getTagFromJson("{AttributeModifiers:[{Operation:0,Amount:20,UUIDLeast:-1636566883658978815L,UUIDMost:2638783885547454956L,AttributeName:\\\"generic.attackDamage\\\",Name:\\\"generic.attackDamage\\\"},{Operation:0,Amount:7,UUIDLeast:-1638981694166994575L,UUIDMost:2758339918956387275L,AttributeName:\\\"generic.attackSpeed\\\",Name:\\\"generic.attackSpeed\\\"},{Operation:0,Amount:10,UUIDLeast:-1279788928773863394L,UUIDMost:2544227529513753741L,AttributeName:\\\"generic.maxHealth\\\",Name:\\\"generic.maxHealth\\\"},{Operation:0,Amount:10,UUIDLeast:-1659178232929925869L,UUIDMost:2833975587743687341L,AttributeName:\\\"generic.armor\\\",Name:\\\"generic.armor\\\"},{Operation:0,Amount:7,UUIDLeast:-1447981584344182248L,UUIDMost:2341862761718693555L,AttributeName:\\\"generic.reachDistance\\\",Name:\\\"generic.reachDistance\\\"}],display:{Name:\\\"彩虹剑-真\\\",Lore:[\\\"§7撕裂斩击 X\\\",\\\"\\\",\\\"\\\",\\\"-真正的彩虹剑-\\\",\\\" -独一无二的-\\\",\\\"  -论坛专属-\\\"]},Tags:[\\\"really rainbowj\\\"],HideFlags:7,ench:[{id:20s,lvl:10s},{id:21s,lvl:10s}]}");
//            stack1.setTagCompound(tag);
//            items.add(stack1);
            //{AttributeModifiers:[{Operation:0,Amount:20,UUIDLeast:-1636566883658978815L,UUIDMost:2638783885547454956L,AttributeName:\"generic.attackDamage\",Name:\"generic.attackDamage\"},{Operation:0,Amount:7,UUIDLeast:-1638981694166994575L,UUIDMost:2758339918956387275L,AttributeName:\"generic.attackSpeed\",Name:\"generic.attackSpeed\"},{Operation:0,Amount:10,UUIDLeast:-1279788928773863394L,UUIDMost:2544227529513753741L,AttributeName:\"generic.maxHealth\",Name:\"generic.maxHealth\"},{Operation:0,Amount:10,UUIDLeast:-1659178232929925869L,UUIDMost:2833975587743687341L,AttributeName:\"generic.armor\",Name:\"generic.armor\"},{Operation:0,Amount:7,UUIDLeast:-1447981584344182248L,UUIDMost:2341862761718693555L,AttributeName:\"generic.reachDistance\",Name:\"generic.reachDistance\"}],display:{Name:\"彩虹剑-真\",Lore:[\"§7撕裂斩击 X\",\"\",\"\",\"-真正的彩虹剑-\",\" -独一无二的-\",\"  -论坛专属-\"]},Tags:[\"really rainbowj\"],HideFlags:7,ench:[{id:20s,lvl:10s},{id:21s,lvl:10s}]}
        }
    }
//    @SubscribeEvent
//    public void onAddEntity(RainbowJEvent event){
//        IdlFramework.Log("hadit");
//        World world=event.getEntityPlayer().world;
//        if(!world.isRemote){
//            EntityPlayer player=event.getEntityPlayer();
//            if(((event.getUseWorldTotelTime()+20)>=world.getTotalWorldTime())){
//                if((world.getTotalWorldTime()-event.getUseWorldTotelTime())%20==0){
//                    List<Entity> entitys=world.getLoadedEntityList();
//                    for(int i=0;i<entitys.size();i++){
//                       if((entitys.get(i) instanceof EntityLivingBase)){
//                           EntityLivingBase entity=(EntityLivingBase) entitys.get(i);
//                           if(entity instanceof EntityPlayer) {
//                               EntityPlayer entityPlayer = (EntityPlayer) entity;
//                               if (!(entityPlayer.getUniqueID() == player.getUniqueID())) {
//                                   if(inAblock((Entity)player,(Entity)entityPlayer,1.5f)){
//                                       AttactByPlayer(player,entityPlayer,1.0f);
//                                   }
//                               }
//                           }
//                           else {
//                               AttactByPlayer(player,entity,1.0f);
//                           }
//                       }
//                    }
//                }
//                MinecraftForge.EVENT_BUS.post(event);
//            }
//        }
//    }
    private void AttactByPlayer(EntityPlayer player,EntityLivingBase entity,float amount){
        if(!player.world.isRemote){
            entity.attackEntityFrom(DamageSource.causePlayerDamage(player),amount);
        }
    }
    private boolean inAblock(Entity a,Entity b,double c){
        double DOUBLE_PLAYER_ENTITY_X=(a.posX-b.posX);
        double DOUBLE_PLAYER_ENTITY_Y=(a.posY-b.posY);
        double DOUBLE_PLAYER_ENTITY_Z=(a.posZ-b.posZ);
        DOUBLE_PLAYER_ENTITY_X=DOUBLE_PLAYER_ENTITY_X*DOUBLE_PLAYER_ENTITY_X;
        DOUBLE_PLAYER_ENTITY_Y=DOUBLE_PLAYER_ENTITY_Y*DOUBLE_PLAYER_ENTITY_Y;
        DOUBLE_PLAYER_ENTITY_Z=DOUBLE_PLAYER_ENTITY_Z*DOUBLE_PLAYER_ENTITY_Z;
        double DOUBLE_PLAYER_ENTITY_ALL=Math.sqrt((DOUBLE_PLAYER_ENTITY_X+DOUBLE_PLAYER_ENTITY_Y+DOUBLE_PLAYER_ENTITY_Z));
        return (DOUBLE_PLAYER_ENTITY_ALL<=c);
    }
}

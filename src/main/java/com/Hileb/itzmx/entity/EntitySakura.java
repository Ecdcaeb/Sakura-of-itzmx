package com.Hileb.itzmx.entity;

import com.Hileb.itzmx.IdlFramework;
import com.Hileb.itzmx.common.SakuraHello;
import com.Hileb.itzmx.events.PlayerCopyLoadEvent;
import com.Hileb.itzmx.item.ModItems;
import com.Hileb.itzmx.util.CommonFunctions;
import com.Hileb.itzmx.util.ModSoundHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nullable;
import java.util.Random;

public class EntitySakura extends EntityAnimal {
    private final SakuraHello hello_1=new SakuraHello("say.itzmx.sakura.4.say",18000);
    private final SakuraHello hello_2=new SakuraHello("say.itzmx.sakura.3.say",14000);
    private final SakuraHello hello_3=new SakuraHello("say.itzmx.sakura.8.say",6000);
    private final SakuraHello hello_4=new SakuraHello("say.itzmx.sakura.7.say",5000);
    private final SakuraHello hello_5=new SakuraHello("say.itzmx.sakura.9.say",7000);
    private final SakuraHello hello_6=new SakuraHello("say.itzmx.sakura.5.say",17000);
    private final SakuraHello hello_7=new SakuraHello("say.itzmx.sakura.10.say",12000);
    private final SakuraHello hello_8=new SakuraHello("say.itzmx.sakura.11.say",11000);


    private final int SAY_MAX=20;

    public EntitySakura(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 1.95F);
        CommonFunctions.addToEventBus(this);
    }
    //interact

    @Override
    public EnumActionResult applyPlayerInteraction(EntityPlayer player, Vec3d vec, EnumHand hand) {
        if(!world.isRemote){
            if (hand==EnumHand.MAIN_HAND){
                if(player.getHeldItemMainhand().getItem()==ModItems.ITEM_FOOD_MIF_UN){
                    say(114514,player);
                    super.applyPlayerInteraction(player,vec,hand);
                }
                if(player.getHeldItemMainhand().getItem()!=ModItems.ITEM_FOOD_MIF){
                    say_something(player);
                    super.applyPlayerInteraction(player,vec,hand);
                }
            }
        }
        return super.applyPlayerInteraction(player, vec, hand);
    }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return this;
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, ModItems.ITEM_FOOD_MIF, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));

        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWanderAvoidWaterFlying(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 64.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
    }

    protected SoundEvent getAmbientSound()
    {
        return null;
    }

//    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
//    {
//        return ModSoundHandler.SOUND_1;
//    }

    protected SoundEvent getDeathSound()
    {
        return ModSoundHandler.SOUND_1;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return LootTableList.EMPTY;
    }



    private double getJvli(EntityLivingBase a,EntityLivingBase b){
        double x=a.posX-b.posX;
        double y=a.posY-b.posY;
        double z=a.posZ-b.posZ;
        return Math.sqrt(((x*x)+(y*y)+z*z));
    }




    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (itemstack.getItem() == ModItems.ITEM_FOOD_MIF && !player.capabilities.isCreativeMode && !this.isChild() && !player.getCooldownTracker().hasCooldown(itemstack.getItem()))
        {
            player.getCooldownTracker().setCooldown(player.getHeldItem(hand).getItem(),10*20);
           //IdlFramework.Log("小樱被喂食！");
            player.playSound(ModSoundHandler.SOUND_3, 1.0F, 1.0F);
            itemstack.shrink(1);

            if (itemstack.isEmpty())
            {
                player.setHeldItem(hand, new ItemStack(ModItems.ITEM_RAINBOW));
            }
            else if (!player.inventory.addItemStackToInventory(new ItemStack(ModItems.ITEM_RAINBOW)))
            {
                player.dropItem(new ItemStack(ModItems.ITEM_RAINBOW), false);
            }

            return true;
        }
        return super.processInteract(player, hand);
    }
    public float getEyeHeight()
    {
        return this.isChild() ? this.height : 1.3F;
    }
    @Override
    protected void dropFewItems(boolean arg1, int arg2)
    {
        if (arg1==true) {
            this.dropItem(ModItems.ITEM_SAKURA_ITZMX, 1);
        }
    }
    @SubscribeEvent
    public void onAttact(LivingHurtEvent event){
        World world=event.getEntity().world;
        if(!world.isRemote){
            if(event.getEntityLiving()==this){
                event.getEntityLiving().setHealth(event.getEntityLiving().getMaxHealth());
                EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
                if(attacker!=null ){
                    if(attacker instanceof EntityPlayer){
                        IdlFramework.LogWarning("Player attack sakura!");
                        event.setCanceled(true);
                        IdlFramework.LogWarning(" at : onAttact__not hand");
                        say_something((EntityPlayer)attacker);
                    }
                    else{
                        playSound(ModSoundHandler.SOUND_1,1.0F,1.0F);
                        attacker.isDead=true;
                        attacker.onDeath(DamageSource.MAGIC);
                        hello(world,"say.itzmx.sakura.2.say");
                    }
                }
                else playSound(ModSoundHandler.SOUND_1,1.0F,1.0F);
            }
        }
    }

    @Override
    public boolean attackable() {
        return true;
    }



    @SubscribeEvent
    public void onKill(LivingDeathEvent event){
        World world=event.getEntity().world;
        if(!world.isRemote){
            IdlFramework.LogWarning("sakura death!");
            if(event.getEntityLiving()==this){
                event.setCanceled(true);
                event.getEntityLiving().isDead=false;
            }
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if(!this.world.isRemote){
            hello_1.say(world);
            hello_2.say(world);
            hello_3.say(world);
            hello_4.say(world);
            hello_5.say(world);
            hello_6.say(world);
            hello_7.say(world);
            hello_8.say(world);
        }
    }

    private void hello(World world, String str){
        for (int i=0;i<world.playerEntities.size();i++){
            String msg="§f<Sakura>:"+world.playerEntities.get(i).getName()+new TextComponentTranslation(str).getFormattedText();
            world.playerEntities.get(i).sendMessage( new TextComponentString(msg));
        }
    }
    private void say(int i,EntityPlayer player){
            String str=String.format("say.itzmx.sakura.click.%d.say",i);
            if(str!=null){
                str="§f<sakura>:"+new TextComponentTranslation(str).getFormattedText();
                player.sendMessage(new TextComponentString(str));
            }
    }
    private void say_something(EntityPlayer player){
        playSound(ModSoundHandler.SOUND_2,1.0F,1.0F);
        say(randomInt(0,SAY_MAX),player);

    }
    private static int randomInt(int min, int max){
        return new Random().nextInt(max)%(max-min+1) + min;
    }

//    @SubscribeEvent//魔改复制机的范例
//    public void onssss(PlayerCopyLoadEvent event){
//        if (event.result.getItem()==ModItems.ITEM_FOOD_MIF)event.setCanceled(true);
//        else event.result=new ItemStack(Items.DIAMOND);
//    }
}


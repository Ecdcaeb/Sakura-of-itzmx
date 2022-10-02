package com.Hileb.itzmx.item.weapon;

import com.Hileb.itzmx.Advancements.Advancementkeys;
import com.Hileb.itzmx.Advancements.ModAdvancementsInit;
import com.Hileb.itzmx.entity.EntitySakura;
import com.Hileb.itzmx.item.ItemBase;
import com.Hileb.itzmx.item.ItemInformationAdder;
import com.Hileb.itzmx.item.ModItems;
import com.Hileb.itzmx.util.CommonFunctions;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class ItemAddSakura extends ItemBase {
    private ItemInformationAdder ItemDesc=new ItemInformationAdder("desc.sakura.desc","desc.sakura.lshift.desc");

    public ItemAddSakura(String name, CreativeTabs tabs, int maxStackSize){
        super(name, tabs, maxStackSize);
        CommonFunctions.addToEventBus(this);
    }

    @SubscribeEvent
    public  void PlayerRightClickBlockEvent(PlayerInteractEvent.LeftClickBlock event){
        World world=event.getWorld();
        if(!world.isRemote){
            if(event.getEntityPlayer().getHeldItemMainhand().getItem() == this) {
                event.getWorld().addWeatherEffect(new EntityLightningBolt(event.getWorld(),event.getPos().getX(),event.getPos().getY(),event.getPos().getZ(),true));
                EntitySakura sakura=new EntitySakura(world);
                sakura.setPosition(event.getPos().getX(),event.getPos().getY()+1,event.getPos().getZ());
                event.getWorld().spawnEntity(sakura);
                //return super.onItemUse(event.getEntityPlayer(),event.getWorld(),event.getPos(), EnumHand.MAIN_HAND,);
                if(!event.getEntityPlayer().isCreative()==true)event.getItemStack().setCount(0);
                ModAdvancementsInit.giveAdvancement(event.getEntityPlayer(), Advancementkeys.AD_HELLOSAKURA);

            }
        }
    }


    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> str, ITooltipFlag flagIn){
        super.addInformation(stack,worldIn,str,flagIn);
        ItemDesc.func_addInformation_item_base(stack,worldIn,str,flagIn);
    }
}

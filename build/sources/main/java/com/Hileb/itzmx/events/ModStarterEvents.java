package com.Hileb.itzmx.events;

import com.Hileb.itzmx.Advancements.Advancementkeys;
import com.Hileb.itzmx.Advancements.ModAdvancementsInit;
import com.Hileb.itzmx.IdlFramework;
import com.Hileb.itzmx.util.IDLNBT;
import com.Hileb.itzmx.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.time.LocalDate;

import static com.Hileb.itzmx.util.IDLNBT.getPlayerIdeallandIntSafe;
import static com.Hileb.itzmx.util.NBTStrDef.IDLNBTDef.CUR_STARTER_KIT_VERSION;
import static com.Hileb.itzmx.util.NBTStrDef.IDLNBTDef.STARTER_KIT_VERSION_TAG;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ModStarterEvents {
	  @SubscribeEvent
	  public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {//玩家登入
		  EntityPlayer player = event.player;
		  //IdlFramework.Log(getPlyrIdlTagSafe(player).toString());
		  int lastStarterVer = getPlayerIdeallandIntSafe(player, STARTER_KIT_VERSION_TAG);
		  if(lastStarterVer < CUR_STARTER_KIT_VERSION) {
			  IDLNBT.setPlayerIdeallandTagSafe(player, STARTER_KIT_VERSION_TAG, CUR_STARTER_KIT_VERSION);
			  //第一次登入。
//
//			  ItemStack scry = new ItemStack(Items.QUARTZ);
//			  player.addItemStackToInventory(scry);
//
//			  if (player instanceof EntityPlayerMP) {
//				  CommonFunctions.SendMsgToPlayerStyled((EntityPlayerMP)player, "itzmx.msg.starter_kit_given", TextFormatting.AQUA);
//			  }
//			  IdlFramework.Log(String.format("Given starter items to player %s, ver %d", player.getDisplayNameString(), CUR_STARTER_KIT_VERSION));
		  }
		  World world = event.player.world;
		  if (!world.isRemote) {
			  EntityPlayer _player_=event.player;
			  LocalDate date=LocalDate.now();
			  IdlFramework.LogWarning("date:getmonth==%d,getday==%d",date.getMonthValue(),date.getDayOfMonth());
			  if (date.getMonthValue()==8 && date.getDayOfMonth()==23){
				  ModAdvancementsInit.giveAdvancement(_player_, Advancementkeys.AD_SAKURADAY);
			  }
		  }
	  }
	
}

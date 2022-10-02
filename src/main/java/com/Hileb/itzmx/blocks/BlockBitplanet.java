package com.Hileb.itzmx.blocks;

import com.Hileb.itzmx.IdlFramework;
import com.Hileb.itzmx.gui.ModGuiElementLoader;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockBitplanet extends BlockBase {

    public BlockBitplanet(String name, Material material){
        super(name,material);
        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void openGui(PlayerInteractEvent.RightClickBlock event){
        if(!event.getWorld().isRemote){
            if(!event.getEntityPlayer().isSneaking()) {
                if (event.getWorld().getBlockState(event.getPos()).getBlock() == this) {
                    IdlFramework.Log("%s,open %s", event.getEntityPlayer().getName(), I18n.format(this.getUnlocalizedName()));
                    event.getEntityPlayer().openGui(IdlFramework.instance, ModGuiElementLoader.GUI_BITPLANET, event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
                }
            }
        }
    }
}

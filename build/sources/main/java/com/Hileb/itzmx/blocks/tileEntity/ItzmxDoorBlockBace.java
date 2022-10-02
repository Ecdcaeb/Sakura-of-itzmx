package com.Hileb.itzmx.blocks.tileEntity;

import com.Hileb.itzmx.blocks.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public class ItzmxDoorBlockBace extends BlockBase {
    public ItzmxDoorBlockBace(String name, Material material) {
        super(name,material);
        this.setLightLevel(1.0f);
        this.setHardness(50f);
        this.setResistance(6000000.99f);
        MinecraftForge.EVENT_BUS.register(this);
    }

}

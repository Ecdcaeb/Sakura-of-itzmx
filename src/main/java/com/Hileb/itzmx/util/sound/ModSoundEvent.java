package com.Hileb.itzmx.util.sound;

import com.Hileb.itzmx.util.ModSoundHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class ModSoundEvent extends SoundEvent
{

    public ModSoundEvent(String path) {
        super(new ResourceLocation("itzmx", path));
        ModSoundHandler.SOUNDS.add(this);
        this.setRegistryName(path);
    }
}

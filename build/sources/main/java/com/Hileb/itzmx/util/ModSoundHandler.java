package com.Hileb.itzmx.util;

import com.Hileb.itzmx.IdlFramework;
import com.Hileb.itzmx.util.sound.ModSoundEvent;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class ModSoundHandler {
    //To add a sound, remember assets.itzmx.sounds.json
    public static final List<ModSoundEvent> SOUNDS = new ArrayList<>();
    public static SoundEvent SOUND_1 = new ModSoundEvent("entity.sakura.hurt");
    public static SoundEvent SOUND_2 = new ModSoundEvent("entity.sakura.en");
    public static SoundEvent SOUND_3 = new ModSoundEvent("entity.sakura.feed");

//    public static SoundEvent SOUND_1 = new ModSoundEvent("entity.moroon.ambient");
//    public static SoundEvent SOUND_2 = new ModSoundEvent("entity.moroon.hurt");

    public static void soundRegister()
    {
        IdlFramework.Log("Registering %s sounds.", SOUNDS.size());
        ForgeRegistries.SOUND_EVENTS.registerAll(ModSoundHandler.SOUNDS.toArray(new SoundEvent[0]));
        IdlFramework.Log("Registered %s sounds.", SOUNDS.size());
    }

}

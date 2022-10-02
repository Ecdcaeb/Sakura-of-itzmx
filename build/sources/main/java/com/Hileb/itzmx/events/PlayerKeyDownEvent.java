package com.Hileb.itzmx.events;

import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.UUID;

public class PlayerKeyDownEvent extends Event {
    private static UUID uuid;
    private static int key;
    private static World world;
    public PlayerKeyDownEvent(UUID uuid_,int key_,World world_){
        uuid=uuid_;
        key=key_;
        world=world_;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getKey() {
        return key;
    }

    public World getWorld() {
        return world;
    }
}

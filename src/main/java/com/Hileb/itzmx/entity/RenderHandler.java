package com.Hileb.itzmx.entity;

import com.Hileb.itzmx.IdlFramework;
import com.Hileb.itzmx.entity.creatures.moroon.EntityMoroonUnitBase;
import com.Hileb.itzmx.entity.creatures.render.RenderBullet;
import com.Hileb.itzmx.entity.creatures.render.RenderMoroonHumanoid;
import com.Hileb.itzmx.entity.creatures.render.RenderSakura;
import com.Hileb.itzmx.entity.creatures.render.RenderZFP;
import com.Hileb.itzmx.entity.projectiles.EntityIdlProjectile;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityMoroonUnitBase.class, RenderMoroonHumanoid::new);

        RenderingRegistry.registerEntityRenderingHandler(EntitySakura.class, RenderSakura::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityZFP.class, RenderZFP::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityIdlProjectile.class, renderManager -> new RenderBullet<>(renderManager, new ResourceLocation(IdlFramework.MODID,
                "textures/entity/projectiles/bullet_norm.png")));

    }
}

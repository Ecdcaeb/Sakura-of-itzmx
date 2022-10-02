package com.Hileb.itzmx.entity.creatures.render;

import com.Hileb.itzmx.entity.creatures.EntityModUnit;
import com.Hileb.itzmx.entity.creatures.model.ModelTurretPrototype;
import com.Hileb.itzmx.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderTurret extends RenderLiving<EntityModUnit> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/turret_one.png");
    public RenderTurret(RenderManager manager){
        super(manager, new ModelTurretPrototype(), 0.5F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityModUnit entity) {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityModUnit entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);

    }
}

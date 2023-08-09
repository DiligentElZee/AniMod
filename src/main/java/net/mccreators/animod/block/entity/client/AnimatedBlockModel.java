package net.mccreators.animod.block.entity.client;

import net.mccreators.animod.AniMod;
import net.mccreators.animod.block.entity.AnimatedBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedBlockModel extends GeoModel<AnimatedBlockEntity> {
    @Override
    public ResourceLocation getModelResource(AnimatedBlockEntity animatable) {
        return new ResourceLocation(AniMod.MOD_ID, "geo/rotater.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedBlockEntity animatable) {
        return new ResourceLocation(AniMod.MOD_ID, "textures/block/rotater.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedBlockEntity animatable) {
        return new ResourceLocation(AniMod.MOD_ID, "animations/rotater.animation.json");
    }
}

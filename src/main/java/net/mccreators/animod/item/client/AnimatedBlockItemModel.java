package net.mccreators.animod.item.client;

import net.mccreators.animod.AniMod;
import net.mccreators.animod.item.custom.AnimatedBlockItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedBlockItemModel extends GeoModel<AnimatedBlockItem> {
    @Override
    public ResourceLocation getModelResource(AnimatedBlockItem animatable) {
        return new ResourceLocation(AniMod.MOD_ID, "geo/rotater.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedBlockItem animatable) {
        return new ResourceLocation(AniMod.MOD_ID, "textures/block/rotater.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedBlockItem animatable) {
        return new ResourceLocation(AniMod.MOD_ID, "animations/rotater.animation.json");
    }
}


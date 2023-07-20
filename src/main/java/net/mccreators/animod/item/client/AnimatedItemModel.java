package net.mccreators.animod.item.client;

import net.mccreators.animod.AniMod;
import net.mccreators.animod.item.custom.AnimatedItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedItemModel extends GeoModel<AnimatedItem> {
    @Override
    public ResourceLocation getModelResource(AnimatedItem animatable) {
        return new ResourceLocation(AniMod.MOD_ID, "geo/placeholder_staff.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedItem animatable) {
        return new ResourceLocation(AniMod.MOD_ID, "textures/item/placeholder_staff.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedItem animatable) {
        return new ResourceLocation(AniMod.MOD_ID, "animations/placeholder_staff.animation.json");
    }
}

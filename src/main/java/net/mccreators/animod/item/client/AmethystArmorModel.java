package net.mccreators.animod.item.client;

import net.mccreators.animod.AniMod;
import net.mccreators.animod.item.ModArmorMaterials;
import net.mccreators.animod.item.custom.AmethystArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AmethystArmorModel extends GeoModel<AmethystArmorItem> {
    @Override
    public ResourceLocation getModelResource(AmethystArmorItem animatable) {
        return new ResourceLocation(AniMod.MOD_ID, "geo/amethyst_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AmethystArmorItem animatable) {
        return new ResourceLocation(AniMod.MOD_ID, "textures/armor/amethyst_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AmethystArmorItem animatable) {
        return new ResourceLocation(AniMod.MOD_ID, "animations/amethyst_armor.animation.json");
    }
}

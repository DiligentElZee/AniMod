package net.mccreators.animod.entity.client;

import net.mccreators.animod.AniMod;
import net.mccreators.animod.entity.custom.WIPEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class WIPModel extends GeoModel<WIPEntity> {
    @Override
    public ResourceLocation getModelResource(WIPEntity animatable) {
        return new ResourceLocation(AniMod.MOD_ID, "geo/wip.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WIPEntity animatable) {
        return new ResourceLocation(AniMod.MOD_ID, "textures/entity/wip.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WIPEntity animatable) {
        return new ResourceLocation(AniMod.MOD_ID, "animations/wip.animation.json");
    }

        @Override
        public void setCustomAnimations(WIPEntity animatable, long instanceId, AnimationState<WIPEntity> animationState) {
            CoreGeoBone head = getAnimationProcessor().getBone("head");

            if (head != null) {
                EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

                head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
                head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
            }
        }
    }

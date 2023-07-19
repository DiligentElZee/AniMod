package net.mccreators.animod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mccreators.animod.AniMod;
import net.mccreators.animod.entity.custom.WIPEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WIPRenderer extends GeoEntityRenderer<WIPEntity> {
    public WIPRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WIPModel());
    }

    @Override
    public ResourceLocation getTextureLocation(WIPEntity animatable) {
        return new ResourceLocation(AniMod.MOD_ID, "textures/entity/wip.png");
    }

    @Override
    public void render(WIPEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
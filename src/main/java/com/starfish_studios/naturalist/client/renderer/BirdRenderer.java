package com.starfish_studios.naturalist.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.starfish_studios.naturalist.client.model.BirdModel;
import com.starfish_studios.naturalist.entity.Bird;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

@OnlyIn(Dist.CLIENT)
public class BirdRenderer extends GeoEntityRenderer<Bird> {
    public BirdRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BirdModel());
        this.shadowRadius = 0.3F;
    }

    @Override
    public void renderEarly(Bird animatable, PoseStack stackIn, float ticks, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float partialTicks) {
        super.renderEarly(animatable, stackIn, ticks, renderTypeBuffer, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, partialTicks);
        if (animatable.isBaby()) {
            stackIn.scale(0.5F, 0.5F, 0.5F);
        }
    }
}
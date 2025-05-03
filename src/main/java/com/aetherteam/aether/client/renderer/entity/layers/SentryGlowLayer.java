package com.aetherteam.aether.client.renderer.entity.layers;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.client.renderer.entity.state.SentryRenderState;
import com.aetherteam.aether.entity.monster.dungeon.Sentry;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class SentryGlowLayer<T extends SentryRenderState, M extends EntityModel<EntityRenderState>> extends RenderLayer<T, M> {
    private static final RenderType SENTRY_EYE = RenderType.eyes(ResourceLocation.fromNamespaceAndPath(Aether.MODID, "textures/entity/mobs/sentry/eye.png"));

    public SentryGlowLayer(RenderLayerParent<T, M> entityRenderer) {
        super(entityRenderer);
    }

    /**
     * Renders the glowing eye layer for the Sentry when it is awake.
     *
     * @param poseStack       The rendering {@link PoseStack}.
     * @param buffer          The rendering {@link MultiBufferSource}.
     * @param packedLight     The {@link Integer} for the packed lighting for rendering.
     * @param renderState     The {@link T} for the entity.
     * @param netHeadYaw      The {@link Float} for the head yaw rotation.
     * @param headPitch       The {@link Float} for the head pitch rotation.
     */
    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, T renderState, float netHeadYaw, float headPitch) {
        VertexConsumer vertexConsumer = buffer.getBuffer(this.renderType());
        if (renderState.awake) {
            this.getParentModel().renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
        }
    }

    public RenderType renderType() {
        return SENTRY_EYE;
    }
}

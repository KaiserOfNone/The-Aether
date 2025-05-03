package com.aetherteam.aether.client.renderer.entity;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.client.renderer.entity.state.HammerRenderState;
import com.aetherteam.aether.entity.projectile.weapon.HammerProjectile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class HammerProjectileRenderer extends EntityRenderer<HammerProjectile, HammerRenderState> {
    public static final ResourceLocation KINGBDOGZ_WAVE_TEXTURE = ResourceLocation.fromNamespaceAndPath(Aether.MODID, "textures/entity/projectile/kingbdogz_wave.png");
    public static final ResourceLocation JEB_WAVE_TEXTURE = ResourceLocation.fromNamespaceAndPath(Aether.MODID, "textures/entity/projectile/jeb_wave.png");

    public HammerProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.0F;
    }

    @Override
    public HammerRenderState createRenderState() {
        return new HammerRenderState();
    }

    @Override
    public void extractRenderState(HammerProjectile entity, HammerRenderState reusedState, float partialTick) {
        super.extractRenderState(entity, reusedState, partialTick);
        reusedState.jeb = entity.getIsJeb();
    }

    /**
     * [VANILLA COPY] - {@link net.minecraft.client.renderer.entity.DragonFireballRenderer}.
     */
    @Override
    public void render(HammerRenderState renderState, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        PoseStack.Pose pose = poseStack.last();
        VertexConsumer consumer = buffer.getBuffer(RenderType.entityCutout(this.getTextureLocation(renderState)));
        vertex(consumer, pose, packedLight, 0.0F, 0.0F, 0.0F, 1.0F);
        vertex(consumer, pose, packedLight, 1.0F, 0.0F, 1.0F, 1.0F);
        vertex(consumer, pose, packedLight, 1.0F, 1.0F, 1.0F, 0.0F);
        vertex(consumer, pose, packedLight, 0.0F, 1.0F, 0.0F, 0.0F);
        poseStack.popPose();
        super.render(renderState, poseStack, buffer, packedLight);
    }

    private static void vertex(VertexConsumer consumer, PoseStack.Pose pose, int packedLight, float offsetX, float offsetY, float textureX, float textureY) {
        consumer.addVertex(pose, offsetX - 0.5F, offsetY - 0.25F, 0.0F)
            .setColor(-1)
            .setUv(textureX, textureY)
            .setOverlay(OverlayTexture.NO_OVERLAY)
            .setLight(packedLight)
            .setNormal(pose, 0.0F, 1.0F, 0.0F);
    }

    /**
     * Checks whether the projectile should use the Kingbdogz or Jeb hammer texture.
     *
     * @param renderState The {@link HammerRenderState} entity.
     * @return The texture {@link ResourceLocation}.
     */
    public ResourceLocation getTextureLocation(HammerRenderState renderState) {
        return !renderState.jeb ? KINGBDOGZ_WAVE_TEXTURE : JEB_WAVE_TEXTURE;
    }
}

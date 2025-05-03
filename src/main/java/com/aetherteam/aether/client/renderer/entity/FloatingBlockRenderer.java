package com.aetherteam.aether.client.renderer.entity;

import com.aetherteam.aether.entity.block.FloatingBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.FallingBlockRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.RenderTypeHelper;
import net.neoforged.neoforge.client.model.data.ModelData;

public class FloatingBlockRenderer extends EntityRenderer<FloatingBlockEntity, FallingBlockRenderState> {
    private final BlockRenderDispatcher dispatcher;

    public FloatingBlockRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.5F;
        this.dispatcher = context.getBlockRenderDispatcher();
    }

    @Override
    public FallingBlockRenderState createRenderState() {
        return new FallingBlockRenderState();
    }

    @Override
    public void extractRenderState(FloatingBlockEntity entity, FallingBlockRenderState reusedState, float partialTick) {
        super.extractRenderState(entity, reusedState, partialTick);
        BlockPos blockpos = BlockPos.containing(entity.getX(), entity.getBoundingBox().maxY, entity.getZ());
        reusedState.startBlockPos = entity.getStartPos();
        reusedState.blockPos = blockpos;
        reusedState.blockState = entity.getBlockState();
        reusedState.biome = entity.level().getBiome(blockpos);
        reusedState.level = entity.level();
    }

    @Override
    public boolean shouldRender(FloatingBlockEntity entity, Frustum frustum, double camX, double camY, double camZ) {
        return super.shouldRender(entity, frustum, camX, camY, camZ) && entity.getBlockState() != entity.level().getBlockState(entity.blockPosition());
    }

    @Override
    public void render(FallingBlockRenderState renderState, PoseStack poseStack, MultiBufferSource bufferSource, int partialTick) {
        BlockState blockstate = renderState.blockState;
        if (blockstate.getRenderShape() == RenderShape.MODEL) {
            poseStack.pushPose();
            poseStack.translate(-0.5, 0.0, -0.5);
            BakedModel model = this.dispatcher.getBlockModel(blockstate);
            for (RenderType renderType : model.getRenderTypes(blockstate, RandomSource.create(blockstate.getSeed(renderState.startBlockPos)), ModelData.EMPTY)) {
                this.dispatcher.getModelRenderer().tesselateBlock(
                    renderState,
                    this.dispatcher.getBlockModel(blockstate),
                    blockstate,
                    renderState.blockPos,
                    poseStack,
                    bufferSource.getBuffer(RenderTypeHelper.getMovingBlockRenderType(renderType)),
                    false,
                    RandomSource.create(),
                    blockstate.getSeed(renderState.startBlockPos),
                    OverlayTexture.NO_OVERLAY,
                    ModelData.EMPTY,
                    renderType
                );
            }
            poseStack.popPose();
            super.render(renderState, poseStack, bufferSource, partialTick);
        }
    }
}

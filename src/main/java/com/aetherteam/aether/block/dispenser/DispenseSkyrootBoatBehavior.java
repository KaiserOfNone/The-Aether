package com.aetherteam.aether.block.dispenser;

import com.aetherteam.aether.entity.miscellaneous.SkyrootBoat;
import com.aetherteam.aether.entity.miscellaneous.SkyrootChestBoat;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BoatDispenseItemBehavior;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

/**
 * [CODE COPY] - {@link BoatDispenseItemBehavior}
 */
public class DispenseSkyrootBoatBehavior extends DefaultDispenseItemBehavior {
    private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();
    private final boolean isChestBoat;

    public DispenseSkyrootBoatBehavior() {
        this(false);
    }

    public DispenseSkyrootBoatBehavior(boolean isChestBoat) {
        this.isChestBoat = isChestBoat;
    }

    public ItemStack execute(BlockSource source, ItemStack stack) {
        Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
        Level level = source.getLevel();
        double width = 0.5625 + EntityType.BOAT.getWidth() / 2.0;
        double x = source.x() + direction.getStepX() * width;
        double y = source.y() + direction.getStepY() * 1.125F;
        double z = source.z() + direction.getStepZ() * width;
        BlockPos blockPos = source.getPos().relative(direction);
        double h;
        if (level.getFluidState(blockPos).is(FluidTags.WATER)) {
            h = 1.0;
        } else {
            if (!level.getBlockState(blockPos).isAir() || !level.getFluidState(blockPos.below()).is(FluidTags.WATER)) {
                return this.defaultDispenseItemBehavior.dispense(source, stack);
            }

            h = 0.0;
        }

        Boat boat = this.isChestBoat ? new SkyrootChestBoat(level, x, y + h, z) : new SkyrootBoat(level, x, y + h, z);
        boat.setYRot(direction.toYRot());
        level.addFreshEntity(boat);
        stack.shrink(1);
        return stack;
    }

    protected void playSound(BlockSource source) {
        source.getLevel().levelEvent(1000, source.getPos(), 0);
    }
}

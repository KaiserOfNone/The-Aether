package com.aetherteam.aether.mixin.mixins.client.accessor;

import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.world.item.CreativeModeTab;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CreativeModeInventoryScreen.class)
public interface CreativeModeInventoryScreenAccessor {
    @Accessor("selectedTab")
    static CreativeModeTab aether$getSelectedTab() {
        throw new AssertionError();
    }

    @Accessor("searchBox")
    EditBox aether$getSearchBox();
}

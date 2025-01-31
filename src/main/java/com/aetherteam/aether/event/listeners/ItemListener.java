package com.aetherteam.aether.event.listeners;

import com.aetherteam.aether.item.combat.loot.FlamingSwordItem;
import com.aetherteam.aether.item.combat.loot.HolySwordItem;
import com.aetherteam.aether.item.combat.loot.PigSlayerItem;
import io.github.fabricators_of_create.porting_lib.entity.events.living.LivingDamageEvent;

public class ItemListener {
    public static void init() {
        LivingDamageEvent.DAMAGE.register(HolySwordItem::onLivingDamage);
        LivingDamageEvent.DAMAGE.register(PigSlayerItem::onLivingDamage);
        LivingDamageEvent.DAMAGE.register(FlamingSwordItem::onLivingDamage);
    }
}

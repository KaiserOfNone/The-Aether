package com.aetherteam.aether.entity;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.data.resources.AetherMobCategory;
import com.aetherteam.aether.entity.block.FloatingBlockEntity;
import com.aetherteam.aether.entity.block.TntPresent;
import com.aetherteam.aether.entity.miscellaneous.CloudMinion;
import com.aetherteam.aether.entity.miscellaneous.Parachute;
import com.aetherteam.aether.entity.miscellaneous.SkyrootBoat;
import com.aetherteam.aether.entity.miscellaneous.SkyrootChestBoat;
import com.aetherteam.aether.entity.monster.*;
import com.aetherteam.aether.entity.monster.dungeon.FireMinion;
import com.aetherteam.aether.entity.monster.dungeon.Mimic;
import com.aetherteam.aether.entity.monster.dungeon.Sentry;
import com.aetherteam.aether.entity.monster.dungeon.Valkyrie;
import com.aetherteam.aether.entity.monster.dungeon.boss.Slider;
import com.aetherteam.aether.entity.monster.dungeon.boss.SunSpirit;
import com.aetherteam.aether.entity.monster.dungeon.boss.ValkyrieQueen;
import com.aetherteam.aether.entity.passive.*;
import com.aetherteam.aether.entity.projectile.PoisonNeedle;
import com.aetherteam.aether.entity.projectile.ZephyrSnowball;
import com.aetherteam.aether.entity.projectile.crystal.CloudCrystal;
import com.aetherteam.aether.entity.projectile.crystal.FireCrystal;
import com.aetherteam.aether.entity.projectile.crystal.IceCrystal;
import com.aetherteam.aether.entity.projectile.crystal.ThunderCrystal;
import com.aetherteam.aether.entity.projectile.dart.EnchantedDart;
import com.aetherteam.aether.entity.projectile.dart.GoldenDart;
import com.aetherteam.aether.entity.projectile.dart.PoisonDart;
import com.aetherteam.aether.entity.projectile.weapon.HammerProjectile;
import com.aetherteam.aether.entity.projectile.weapon.ThrownLightningKnife;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;

public class AetherEntityTypes {
    public static final LazyRegistrar<EntityType<?>> ENTITY_TYPES = LazyRegistrar.create(Registries.ENTITY_TYPE, Aether.MODID);

    // Passive Mobs
    public static final RegistryObject<EntityType<Phyg>> PHYG = ENTITY_TYPES.register("phyg",
            () -> FabricEntityTypeBuilder.create(MobCategory.CREATURE, Phyg::new).dimensions(EntityDimensions.scalable(0.9F, 0.9F)).trackRangeChunks(10).build());

    public static final RegistryObject<EntityType<FlyingCow>> FLYING_COW = ENTITY_TYPES.register("flying_cow",
            () -> FabricEntityTypeBuilder.create(MobCategory.CREATURE, FlyingCow::new).dimensions(EntityDimensions.scalable(0.9F, 1.4F)).trackRangeChunks(10).build());

    public static final RegistryObject<EntityType<Sheepuff>> SHEEPUFF = ENTITY_TYPES.register("sheepuff",
            () -> FabricEntityTypeBuilder.create(MobCategory.CREATURE, Sheepuff::new).dimensions(EntityDimensions.scalable(0.9F, 1.3F)).trackRangeChunks(10).build());

    public static final RegistryObject<EntityType<Moa>> MOA = ENTITY_TYPES.register("moa",
            () -> FabricEntityTypeBuilder.create(MobCategory.CREATURE, Moa::new).dimensions(EntityDimensions.scalable(0.9F, 2.15F)).trackRangeChunks(10).build());

    public static final RegistryObject<EntityType<Aerbunny>> AERBUNNY = ENTITY_TYPES.register("aerbunny",
            () -> FabricEntityTypeBuilder.create(MobCategory.CREATURE, Aerbunny::new).dimensions(EntityDimensions.scalable(0.6F, 0.5F)).trackRangeChunks(10).build());

    public static final RegistryObject<EntityType<Aerwhale>> AERWHALE = ENTITY_TYPES.register("aerwhale",
            () -> FabricEntityTypeBuilder.create(AetherMobCategory.AETHER_AERWHALE, Aerwhale::new).fireImmune().dimensions(EntityDimensions.scalable(3.0F, 3.0F)).trackRangeChunks(10).build());

    // Hostile Mobs
    public static final RegistryObject<EntityType<Swet>> BLUE_SWET = ENTITY_TYPES.register("blue_swet",
            () -> FabricEntityTypeBuilder.create(AetherMobCategory.AETHER_SURFACE_MONSTER, Swet::new).dimensions(EntityDimensions.scalable(0.9F, 0.9F)).trackRangeChunks(10).build());

    public static final RegistryObject<EntityType<Swet>> GOLDEN_SWET = ENTITY_TYPES.register("golden_swet",
            () -> FabricEntityTypeBuilder.create(AetherMobCategory.AETHER_SURFACE_MONSTER, Swet::new).dimensions(EntityDimensions.scalable(0.9F, 0.9F)).trackRangeChunks(10).build());

    public static final RegistryObject<EntityType<PassiveWhirlwind>> WHIRLWIND = ENTITY_TYPES.register("whirlwind",
            () -> FabricEntityTypeBuilder.create(AetherMobCategory.AETHER_SURFACE_MONSTER, PassiveWhirlwind::new).fireImmune().dimensions(EntityDimensions.scalable(0.6F, 0.8F)).trackRangeChunks(8).build());

    public static final RegistryObject<EntityType<EvilWhirlwind>> EVIL_WHIRLWIND = ENTITY_TYPES.register("evil_whirlwind",
            () -> FabricEntityTypeBuilder.create(AetherMobCategory.AETHER_SURFACE_MONSTER, EvilWhirlwind::new).fireImmune().dimensions(EntityDimensions.scalable(0.6F, 0.8F)).trackRangeChunks(8).build());

    public static final RegistryObject<EntityType<AechorPlant>> AECHOR_PLANT = ENTITY_TYPES.register("aechor_plant",
            () -> FabricEntityTypeBuilder.create(AetherMobCategory.AETHER_SURFACE_MONSTER, AechorPlant::new).dimensions(EntityDimensions.scalable(1.0F, 1.0F)).trackRangeChunks(8).build());

    public static final RegistryObject<EntityType<Cockatrice>> COCKATRICE = ENTITY_TYPES.register("cockatrice",
            () -> FabricEntityTypeBuilder.create(AetherMobCategory.AETHER_DARKNESS_MONSTER, Cockatrice::new).dimensions(EntityDimensions.scalable(0.9F, 2.15F)).trackRangeChunks(10).build());

    public static final RegistryObject<EntityType<Zephyr>> ZEPHYR = ENTITY_TYPES.register("zephyr",
            () -> FabricEntityTypeBuilder.create(AetherMobCategory.AETHER_SKY_MONSTER, Zephyr::new).dimensions(EntityDimensions.scalable(4.5F, 3.5F)).trackRangeChunks(10).build());

    // Dungeon Mobs
    public static final RegistryObject<EntityType<Mimic>> MIMIC = ENTITY_TYPES.register("mimic",
            () -> FabricEntityTypeBuilder.create(MobCategory.MONSTER, Mimic::new).dimensions(EntityDimensions.scalable(1.0F, 2.0F)).trackRangeChunks(8).build());

    public static final RegistryObject<EntityType<Sentry>> SENTRY = ENTITY_TYPES.register("sentry",
            () -> FabricEntityTypeBuilder.create(MobCategory.MONSTER, Sentry::new).dimensions(EntityDimensions.scalable(2.0F, 2.0F)).trackRangeChunks(10).build());

    public static final RegistryObject<EntityType<Slider>> SLIDER = ENTITY_TYPES.register("slider",
            () -> FabricEntityTypeBuilder.create(MobCategory.MONSTER, Slider::new).dimensions(EntityDimensions.scalable(2.0F, 2.0F)).fireImmune().trackRangeChunks(10).build());

    public static final RegistryObject<EntityType<Valkyrie>> VALKYRIE = ENTITY_TYPES.register("valkyrie",
            () -> FabricEntityTypeBuilder.create(MobCategory.MONSTER, Valkyrie::new).dimensions(EntityDimensions.scalable(0.8F, 1.95F)).trackRangeChunks(8).build());

    public static final RegistryObject<EntityType<ValkyrieQueen>> VALKYRIE_QUEEN = ENTITY_TYPES.register("valkyrie_queen",
            () -> FabricEntityTypeBuilder.create(MobCategory.MONSTER, ValkyrieQueen::new).dimensions(EntityDimensions.scalable(0.8F, 1.95F)).fireImmune().trackRangeChunks(10).build());

    public static final RegistryObject<EntityType<FireMinion>> FIRE_MINION = ENTITY_TYPES.register("fire_minion",
            () -> FabricEntityTypeBuilder.create(MobCategory.MONSTER, FireMinion::new).dimensions(EntityDimensions.scalable(1.1F, 1.95F)).fireImmune().trackRangeChunks(8).build());

    public static final RegistryObject<EntityType<SunSpirit>> SUN_SPIRIT = ENTITY_TYPES.register("sun_spirit",
            () -> FabricEntityTypeBuilder.create(MobCategory.MONSTER, SunSpirit::new).dimensions(EntityDimensions.scalable(2.5F, 3.4F)).fireImmune().trackRangeChunks(10).build());

    // Miscellaneous Entities
    public static final RegistryObject<EntityType<SkyrootBoat>> SKYROOT_BOAT = ENTITY_TYPES.register("skyroot_boat",
            () -> FabricEntityTypeBuilder.<SkyrootBoat>create(MobCategory.MISC, SkyrootBoat::new).dimensions(EntityDimensions.scalable(1.375F, 0.5625F)).trackRangeChunks(10).build());

    public static final RegistryObject<EntityType<SkyrootChestBoat>> SKYROOT_CHEST_BOAT = ENTITY_TYPES.register("skyroot_chest_boat",
            () -> FabricEntityTypeBuilder.<SkyrootChestBoat>create(MobCategory.MISC, SkyrootChestBoat::new).dimensions(EntityDimensions.scalable(1.375F, 0.5625F)).trackRangeChunks(10).build());

    public static final RegistryObject<EntityType<CloudMinion>> CLOUD_MINION = ENTITY_TYPES.register("cloud_minion",
            () -> FabricEntityTypeBuilder.<CloudMinion>create(MobCategory.MISC, CloudMinion::new).dimensions(EntityDimensions.scalable(0.75F, 0.75F)).trackRangeChunks(5).build());

    public static final RegistryObject<EntityType<Parachute>> COLD_PARACHUTE = ENTITY_TYPES.register("cold_parachute",
            () -> FabricEntityTypeBuilder.create(MobCategory.MISC, Parachute::new).dimensions(EntityDimensions.scalable(1.0F, 1.0F)).trackRangeChunks(8).build());

    public static final RegistryObject<EntityType<Parachute>> GOLDEN_PARACHUTE = ENTITY_TYPES.register("golden_parachute",
            () -> FabricEntityTypeBuilder.create(MobCategory.MISC, Parachute::new).dimensions(EntityDimensions.scalable(1.0F, 1.0F)).trackRangeChunks(8).build());

    public static final RegistryObject<EntityType<FloatingBlockEntity>> FLOATING_BLOCK = ENTITY_TYPES.register("floating_block",
            () -> FabricEntityTypeBuilder.<FloatingBlockEntity>create(MobCategory.MISC, FloatingBlockEntity::new).dimensions(EntityDimensions.scalable(1.0F, 1.0F)).trackRangeChunks(10).trackedUpdateRate(20).build());

    public static final RegistryObject<EntityType<TntPresent>> TNT_PRESENT = ENTITY_TYPES.register("tnt_present",
            () -> FabricEntityTypeBuilder.<TntPresent>create(MobCategory.MISC, TntPresent::new).fireImmune().dimensions(EntityDimensions.scalable(1.0F, 1.0F)).trackRangeChunks(10).trackedUpdateRate(10).build());

    // Projectiles
    public static final RegistryObject<EntityType<ZephyrSnowball>> ZEPHYR_SNOWBALL = ENTITY_TYPES.register("zephyr_snowball",
            () -> FabricEntityTypeBuilder.<ZephyrSnowball>create(MobCategory.MISC, ZephyrSnowball::new).dimensions(EntityDimensions.scalable(1.0F, 1.0F)).trackRangeChunks(4).trackedUpdateRate(10).build());

    public static final RegistryObject<EntityType<CloudCrystal>> CLOUD_CRYSTAL = ENTITY_TYPES.register("cloud_crystal",
            () -> FabricEntityTypeBuilder.<CloudCrystal>create(MobCategory.MISC, CloudCrystal::new).dimensions(EntityDimensions.scalable(0.5F, 0.5F)).trackRangeChunks(4).trackedUpdateRate(10).build());

    public static final RegistryObject<EntityType<FireCrystal>> FIRE_CRYSTAL = ENTITY_TYPES.register("fire_crystal",
            () -> FabricEntityTypeBuilder.<FireCrystal>create(MobCategory.MISC, FireCrystal::new).dimensions(EntityDimensions.scalable(0.85F, 0.85F)).trackRangeChunks(4).trackedUpdateRate(10).fireImmune().build());

    public static final RegistryObject<EntityType<IceCrystal>> ICE_CRYSTAL = ENTITY_TYPES.register("ice_crystal",
            () -> FabricEntityTypeBuilder.<IceCrystal>create(MobCategory.MISC, IceCrystal::new).dimensions(EntityDimensions.scalable(1.2F, 1.2F)).trackRangeChunks(4).trackedUpdateRate(10).fireImmune().build());

    public static final RegistryObject<EntityType<ThunderCrystal>> THUNDER_CRYSTAL = ENTITY_TYPES.register("thunder_crystal",
            () -> FabricEntityTypeBuilder.<ThunderCrystal>create(MobCategory.MISC, ThunderCrystal::new).dimensions(EntityDimensions.scalable(0.7F, 0.7F)).trackedUpdateRate(2).build());

    public static final RegistryObject<EntityType<GoldenDart>> GOLDEN_DART = ENTITY_TYPES.register("golden_dart",
            () -> FabricEntityTypeBuilder.<GoldenDart>create(MobCategory.MISC, GoldenDart::new).dimensions(EntityDimensions.scalable(0.5F, 0.5F)).trackRangeChunks(4).trackedUpdateRate(20).build());

    public static final RegistryObject<EntityType<PoisonDart>> POISON_DART = ENTITY_TYPES.register("poison_dart",
            () -> FabricEntityTypeBuilder.<PoisonDart>create(MobCategory.MISC, PoisonDart::new).dimensions(EntityDimensions.scalable(0.5F, 0.5F)).trackRangeChunks(4).trackedUpdateRate(20).build());

    public static final RegistryObject<EntityType<EnchantedDart>> ENCHANTED_DART = ENTITY_TYPES.register("enchanted_dart",
            () -> FabricEntityTypeBuilder.<EnchantedDart>create(MobCategory.MISC, EnchantedDart::new).dimensions(EntityDimensions.scalable(0.5F, 0.5F)).trackRangeChunks(4).trackedUpdateRate(20).build());

    public static final RegistryObject<EntityType<PoisonNeedle>> POISON_NEEDLE = ENTITY_TYPES.register("poison_needle",
            () -> FabricEntityTypeBuilder.<PoisonNeedle>create(MobCategory.MISC, PoisonNeedle::new).dimensions(EntityDimensions.scalable(0.5F, 0.5F)).trackRangeChunks(4).trackedUpdateRate(20).build());

    public static final RegistryObject<EntityType<ThrownLightningKnife>> LIGHTNING_KNIFE = ENTITY_TYPES.register("lightning_knife",
            () -> FabricEntityTypeBuilder.<ThrownLightningKnife>create(MobCategory.MISC, ThrownLightningKnife::new).dimensions(EntityDimensions.scalable(0.25F, 0.25F)).trackRangeChunks(4).trackedUpdateRate(10).build());

    public static final RegistryObject<EntityType<HammerProjectile>> HAMMER_PROJECTILE = ENTITY_TYPES.register("hammer_projectile",
            () -> FabricEntityTypeBuilder.<HammerProjectile>create(MobCategory.MISC, HammerProjectile::new).dimensions(EntityDimensions.scalable(0.35F, 0.35F)).trackRangeChunks(4).trackedUpdateRate(10).build());

    public static void registerSpawnPlacements() {
        // Passive Mobs
        SpawnPlacements.register(AetherEntityTypes.PHYG.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AetherAnimal::checkAetherAnimalSpawnRules);
        SpawnPlacements.register(AetherEntityTypes.FLYING_COW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AetherAnimal::checkAetherAnimalSpawnRules);
        SpawnPlacements.register(AetherEntityTypes.SHEEPUFF.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AetherAnimal::checkAetherAnimalSpawnRules);
        SpawnPlacements.register(AetherEntityTypes.MOA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AetherAnimal::checkAetherAnimalSpawnRules);
        SpawnPlacements.register(AetherEntityTypes.AERBUNNY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AetherAnimal::checkAetherAnimalSpawnRules);
        SpawnPlacements.register(AetherEntityTypes.AERWHALE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Aerwhale::checkAerwhaleSpawnRules);

        // Hostile Mobs
        SpawnPlacements.register(AetherEntityTypes.BLUE_SWET.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Swet::checkSwetSpawnRules);
        SpawnPlacements.register(AetherEntityTypes.GOLDEN_SWET.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Swet::checkSwetSpawnRules);
        SpawnPlacements.register(AetherEntityTypes.WHIRLWIND.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AbstractWhirlwind::checkWhirlwindSpawnRules);
        SpawnPlacements.register(AetherEntityTypes.EVIL_WHIRLWIND.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AbstractWhirlwind::checkWhirlwindSpawnRules);
        SpawnPlacements.register(AetherEntityTypes.AECHOR_PLANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AechorPlant::checkAechorPlantSpawnRules);
        SpawnPlacements.register(AetherEntityTypes.COCKATRICE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Cockatrice::checkCockatriceSpawnRules);
        SpawnPlacements.register(AetherEntityTypes.ZEPHYR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Zephyr::checkZephyrSpawnRules);
    }

    public static void registerEntityAttributes() {
        // Passive Mobs
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.PHYG.get(), Phyg.createMobAttributes().build());
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.FLYING_COW.get(), FlyingCow.createMobAttributes().build());
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.SHEEPUFF.get(), Sheepuff.createMobAttributes().build());
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.MOA.get(), Moa.createMobAttributes().build());
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.AERBUNNY.get(), Aerbunny.createMobAttributes().build());
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.AERWHALE.get(), Aerwhale.createMobAttributes().build());

        // Hostile Mobs
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.BLUE_SWET.get(), Swet.createMobAttributes().build());
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.GOLDEN_SWET.get(), Swet.createMobAttributes().build());
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.WHIRLWIND.get(), AbstractWhirlwind.createMobAttributes().build());
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.EVIL_WHIRLWIND.get(), AbstractWhirlwind.createMobAttributes().build());
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.AECHOR_PLANT.get(), AechorPlant.createMobAttributes().build());
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.COCKATRICE.get(), Cockatrice.createMobAttributes().build());
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.ZEPHYR.get(), Zephyr.createMobAttributes().build());

        // Dungeon Mobs
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.MIMIC.get(), Mimic.createMobAttributes().build());
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.SENTRY.get(), Sentry.createMobAttributes().build());
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.SLIDER.get(), Slider.createMobAttributes().build());
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.VALKYRIE.get(), Valkyrie.createMobAttributes().build());
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.VALKYRIE_QUEEN.get(), ValkyrieQueen.createMobAttributes().build());
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.FIRE_MINION.get(), FireMinion.createMobAttributes().build());
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.SUN_SPIRIT.get(), SunSpirit.createMobAttributes().build());

        // Miscellaneous Entities
        FabricDefaultAttributeRegistry.register(AetherEntityTypes.CLOUD_MINION.get(), CloudMinion.createMobAttributes().build());
    }

    public static void init() {
        registerSpawnPlacements();
        registerEntityAttributes();
    }
}
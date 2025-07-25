package com.magafin.no_mans_delight.food_values;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.Map;

public class FoodValues {
    public static final int BRIEF_DURATION = 600;    // 30 seconds
    public static final int SHORT_DURATION = 1200;    // 1 minute
    public static final int MEDIUM_DURATION = 3600;    // 3 minutes
    public static final int LONG_DURATION = 6000;// 5 minutes
    public static final int VERY_LONG_DURATION = 8400;// 7 minutes

    public static final FoodProperties HORSE_SOUP = (new FoodProperties.Builder())
            .nutrition(8).saturationModifier(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT, MEDIUM_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, MEDIUM_DURATION, 0), 0.2F).build();
    public static final FoodProperties MUSHROOMS_WITH_TOMATO = (new FoodProperties.Builder())
            .nutrition(12).saturationModifier(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties SWEET_FROG_LEGS = (new FoodProperties.Builder())
            .nutrition(12).saturationModifier(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT, MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties VENISON_TART = (new FoodProperties.Builder())
            .nutrition(8).saturationModifier(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT, LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties VENISON_ROULADE = (new FoodProperties.Builder())
            .nutrition(12).saturationModifier(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, VERY_LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties SHROOMBURGER = (new FoodProperties.Builder())
            .nutrition(10).saturationModifier(0.6f).build();
    public static final FoodProperties HORSE_LOIN = (new FoodProperties.Builder())
            .nutrition(2).saturationModifier(0.3f).build();
    public static final FoodProperties COOKED_HORSE_LOIN = (new FoodProperties.Builder())
            .nutrition(4).saturationModifier(0.6f).build();
    public static final FoodProperties VENISON_MEDALLIONS = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.3f).build();
    public static final FoodProperties COOKED_VENISON_MEDALLIONS = (new FoodProperties.Builder())
            .nutrition(3).saturationModifier(0.6f).build();
    public static final FoodProperties WALNUT_COOKIE = (new FoodProperties.Builder())
            .nutrition(2).saturationModifier(0.3f).build();
    public static final FoodProperties STUFFED_SHELF_MUSHROOM = (new FoodProperties.Builder())
            .nutrition(10).saturationModifier(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT, MEDIUM_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, SHORT_DURATION, 0), 1.0F).build();
    public static final FoodProperties VENISON_MUSCLE = (new FoodProperties.Builder())
            .nutrition(2).saturationModifier(0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, SHORT_DURATION, 0), 0.3F).build();
    public static final FoodProperties COOKED_VENISON_MUSCLE = (new FoodProperties.Builder())
            .nutrition(4).saturationModifier(0.6f).build();
    public static final FoodProperties BILLHOOK_BASS_SLICE = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.6f).build();
    public static final FoodProperties COOKED_BILLHOOK_BASS_SLICE = (new FoodProperties.Builder())
            .nutrition(3).saturationModifier(0.6f).build();
    public static final FoodProperties BILLHOOK_BASS_ROLL = (new FoodProperties.Builder())
            .nutrition(7).saturationModifier(0.6f).build();
    public static final FoodProperties PICKLED_BRAINS = (new FoodProperties.Builder())
            .nutrition(9).saturationModifier(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, MEDIUM_DURATION, 0), 0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200, 0), 0.2F).build();
    public static final FoodProperties BOILED_CAVE_WEEDS = (new FoodProperties.Builder())
            .nutrition(5).saturationModifier(0.6f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT, SHORT_DURATION, 0), 1.0F).build();
    public static final FoodProperties RIVER_MEAL = (new FoodProperties.Builder())
            .nutrition(7).saturationModifier(0.7f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT, MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties ORANGE = (new FoodProperties.Builder())
            .nutrition(4).saturationModifier(0.3f).build();
    public static final FoodProperties CHOCO_GLAZED_ORANGE = (new FoodProperties.Builder())
            .nutrition(6).saturationModifier(0.6f).build();
    public static final FoodProperties ORANGE_JUICE = (new FoodProperties.Builder())
            .alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0), 1.0F).build();
    public static final FoodProperties CHOCOLATE_CAKE_SLICE = (new FoodProperties.Builder())
            .nutrition(4).saturationModifier(0.3f).build();
    public static final FoodProperties CHOCOLATE_TART = (new FoodProperties.Builder())
            .nutrition(8).saturationModifier(0.5f).build();
    public static final FoodProperties KOZINAK = (new FoodProperties.Builder())
            .nutrition(4).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT, 400, 0), 1.0F).build();
    public static final FoodProperties HORSE_WRAP = (new FoodProperties.Builder())
            .nutrition(10).saturationModifier(0.7f).build();
}


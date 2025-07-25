package com.magafin.no_mans_delight.common.register;


import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;

import static com.magafin.no_mans_delight.No_mans_delight.MODID;


public class DamageReg {
    public static final ResourceKey<DamageType> ZOMBIE_HEAD = registerDamageType("zombie_head_damage");

    private static ResourceKey<DamageType> registerDamageType(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(MODID, name));
    }

    public static DamageSource getSimpleDamageSource(Level level, ResourceKey<DamageType> type, BlockPos pos) {
        return new DamageSource(level.registryAccess().registry(Registries.DAMAGE_TYPE).orElseThrow().getHolderOrThrow(type),pos.getCenter());
    }


}

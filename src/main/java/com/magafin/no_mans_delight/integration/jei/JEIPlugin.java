package com.magafin.no_mans_delight.integration.jei;

import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

import com.magafin.no_mans_delight.register.ItemReg;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.common.utility.TextUtils;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@JeiPlugin
public class JEIPlugin implements IModPlugin {
    private static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("farmersdelight", "jei_plugin");

    public JEIPlugin() {
    }

    public void registerRecipes(IRecipeRegistration registration) {
        registration.addIngredientInfo(new ItemStack((ItemLike) ItemReg.VENISON_MUSCLE.get()), VanillaTypes.ITEM_STACK, new Component[]{TextUtils.getTranslation("jei.info.venison_muscle", new Object[0])});
        registration.addIngredientInfo(new ItemStack((ItemLike)ItemReg.COOKED_VENISON_MUSCLE.get()), VanillaTypes.ITEM_STACK, new Component[]{TextUtils.getTranslation("jei.info.venison_muscle", new Object[0])});
        registration.addIngredientInfo(new ItemStack((ItemLike)ItemReg.PICKLED_BRAINS_ITEM.get()), VanillaTypes.ITEM_STACK, new Component[]{TextUtils.getTranslation("jei.info.pickled_brains", new Object[0])});

    }
    public ResourceLocation getPluginUid() {
        return ID;
    }
}
package com.magafin.no_mans_delight.register;

import com.farcr.nomansland.NoMansLand;
import com.farcr.nomansland.common.registry.items.NMLCreativeTabs;
import com.magafin.no_mans_delight.No_mans_delight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import com.magafin.no_mans_delight.register.ItemReg;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.magafin.no_mans_delight.No_mans_delight.MODID;

public class TabReg {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create( Registries.CREATIVE_MODE_TAB,MODID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> NMD_TAB = TABS.register("no_mans_delight", () -> CreativeModeTab.builder().withTabsBefore(ResourceLocation.fromNamespaceAndPath(NoMansLand.MODID, "nomansland")).title(Component.translatable("itemGroup." + MODID + ".no_mans_delight")).icon(() -> ItemReg.NO_MANS_POT.get().getDefaultInstance()).displayItems((parameters, output) -> {
        output.accept(ItemReg.VENISON_MEDALLIONS.get());
        output.accept(ItemReg.COOKED_VENISON_MEDALLIONS.get());
        output.accept(ItemReg.HORSE_LOIN.get());
        output.accept(ItemReg.COOKED_HORSE_LOIN.get());
        output.accept(ItemReg.BILLHOOK_BASS_SLICE.get());
        output.accept(ItemReg.COOKED_BILLHOOK_BASS_SLICE.get());
        output.accept(ItemReg.VENISON_MUSCLE.get());
        output.accept(ItemReg.COOKED_VENISON_MUSCLE.get());
        output.accept(ItemReg.ORANGE.get());
        output.accept(ItemReg.CHOCO_GLAZED_ORANGE.get());
        output.accept(ItemReg.ORANGE_JUICE.get());
        output.accept(ItemReg.CHOCOLATE_TART.get());
        output.accept(ItemReg.SHROOMBURGER.get());
        output.accept(ItemReg.HORSE_WRAP.get());
        output.accept(ItemReg.WALNUT_COOKIE.get());
        output.accept(ItemReg.KOZINAK.get());
        output.accept(ItemReg.BILLHOOK_BASS_ROLL.get());
        output.accept(ItemReg.VENISON_TART.get());
        output.accept(ItemReg.MUSHROOMS_WITH_TOMATO.get());
        output.accept(ItemReg.SWEET_FROG_LEGS.get());
        output.accept(ItemReg.BOILED_CAVE_WEEDS.get());
        output.accept(ItemReg.RIVER_MEAL.get());
        output.accept(ItemReg.VENISON_ROULADE_BLOCK_ITEM.get());
        output.accept(ItemReg.VENISON_ROULADE.get());
        output.accept(ItemReg.STUFFED_SHELF_MUSHROOM_BLOCK_ITEM.get());
        output.accept(ItemReg.STUFFED_SHELF_MUSHROOM.get());
        output.accept(ItemReg.PICKLED_BRAINS_ITEM.get());
        output.accept(ItemReg.PICKLED_BRAINS.get());
        output.accept(ItemReg.HORSE_SOUP_POT_ITEM.get());
        output.accept(ItemReg.HORSE_SOUP.get());
        output.accept(ItemReg.CHOCOLATE_CAKE_ITEM.get());
        output.accept(ItemReg.CHOCOLATE_CAKE_SLICE.get());
        output.accept(ItemReg.OLD_GOBLET.get());
        output.accept(ItemReg.ORANGE_FRUIT_LEAVES.get());
        output.accept(ItemReg.ORANGE_CRATE_ITEM.get());
    }).build());
}
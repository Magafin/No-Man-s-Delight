package com.magafin.no_mans_delight.client.color;

import com.magafin.no_mans_delight.register.BlockReg;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.util.Mth;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(
        modid = "no_mans_delight",
        bus = Bus.MOD,
        value = {Dist.CLIENT}
)

public class ColorHandler {
    public ColorHandler() {
    }

    @SubscribeEvent
    public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event) {
        event.register((stack, index) -> {
            return FoliageColor.get(0.5, 1.0);
        }, new ItemLike[]{(ItemLike)BlockReg.ORANGE_FRUIT_LEAVES.get()});
    }

    @SubscribeEvent
    public static void registerBlockColorHandlers(RegisterColorHandlersEvent.Block event) {
        event.register((state, level, pos, tintIndex) -> {
            return level != null && pos != null ? BiomeColors.getAverageFoliageColor(level, pos) : GrassColor.get(0.5, 1.0);
        }, new Block[]{(Block)BlockReg.ORANGE_FRUIT_LEAVES.get()});
    }

    private static float unpackRed(int rgb) {
        return (float)(rgb >> 16 & 255) / 255.0F;
    }

    private static float unpackGreen(int rgb) {
        return (float)(rgb >> 8 & 255) / 255.0F;
    }

    private static float unpackBlue(int rgb) {
        return (float)(rgb & 255) / 255.0F;
    }

    private static int packColor(float r, float g, float b) {
        return ((int)(Mth.clamp(r, 0.0F, 1.0F) * 255.0F) & 255) << 16 | ((int)(Mth.clamp(g, 0.0F, 1.0F) * 255.0F) & 255) << 8 | (int)(Mth.clamp(b, 0.0F, 1.0F) * 255.0F) & 255;
    }
}

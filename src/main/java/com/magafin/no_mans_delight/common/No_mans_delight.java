package com.magafin.no_mans_delight;

import com.magafin.no_mans_delight.register.BlockReg;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterNamedRenderTypesEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;


import static com.magafin.no_mans_delight.common.register.BlockEntityReg.BLOCK_ENTITIES;
import static com.magafin.no_mans_delight.register.ItemReg.ITEMS;
import static com.magafin.no_mans_delight.register.BlockReg.BLOCKS;
import static com.magafin.no_mans_delight.register.TabReg.TABS;

@Mod(No_mans_delight.MODID)
public class No_mans_delight {
    public static final String MODID = "no_mans_delight";
    private static final Logger LOGGER = LogUtils.getLogger();

    public No_mans_delight(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);
        TABS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}

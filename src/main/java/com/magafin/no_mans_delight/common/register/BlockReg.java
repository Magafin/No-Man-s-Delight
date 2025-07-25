package com.magafin.no_mans_delight.register;

import com.farcr.nomansland.common.definitions.BlockDefinition;
import com.farcr.nomansland.common.definitions.BlockProperties;
import com.magafin.no_mans_delight.No_mans_delight;
import com.magafin.no_mans_delight.block.StuffedShelfMushroomBlock;
import com.magafin.no_mans_delight.block.VenisonRouladeBlock;
import com.magafin.no_mans_delight.common.block.*;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import com.farcr.nomansland.common.registry.blocks.NMLBlocks;


import static net.minecraft.world.item.Items.registerBlock;
import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.of;
import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy;

import java.util.function.Supplier;

public class BlockReg {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(No_mans_delight.MODID);

    public static <T extends Block> BlockDefinition<T> registerNoItem(String name, Supplier<T> block, BlockProperties properties) {
        DeferredBlock<T> deferred = BLOCKS.register(name, block);
        BlockDefinition<T> definition = BlockDefinition.fromHolder(deferred, properties);
        return definition;
    }

    public static <T extends Block> BlockDefinition<T> registerNoItem(String name, Supplier<T> block) {
        return registerNoItem(name, block, BlockProperties.custom(false));
    }


    public static final Supplier<Block> VENISON_ROULADE_BLOCK = BLOCKS.register("venison_roulade_block",
            () -> new VenisonRouladeBlock(ofFullCopy(Blocks.CAKE), com.magafin.no_mans_delight.register.ItemReg.VENISON_ROULADE, true));
    public static final Supplier<Block> STUFFED_SHELF_MUSHROOM_BLOCK = BLOCKS.register("stuffed_shelf_mushroom_block",
            () -> new StuffedShelfMushroomBlock(ofFullCopy(NMLBlocks.SHELF_MUSHROOM_BLOCK.get()), com.magafin.no_mans_delight.register.ItemReg.STUFFED_SHELF_MUSHROOM, false));
    public static final Supplier<Block> PICKLED_BRAINS = BLOCKS.register("pickled_brains_block",
            () -> new PickledBrainsBlock(ofFullCopy(Blocks.CAKE).randomTicks(), com.magafin.no_mans_delight.register.ItemReg.PICKLED_BRAINS, true));
    public static final DeferredHolder<Block, OldGobletBlock> OLD_GOBLET = BLOCKS.register("old_goblet",
            () -> new OldGobletBlock(of()
                    .strength(1.5F)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
                    .sound(SoundType.CHERRY_WOOD)
                    .randomTicks()
            ));
    public static final BlockDefinition<Block> ORANGE_FRUIT = registerNoItem("orange",
            () -> new OrangeBlock(of()
                    .mapColor(MapColor.PLANT)
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.AZALEA)
                    .pushReaction(PushReaction.DESTROY)
                    .offsetType(BlockBehaviour.OffsetType.XYZ)
                    .dynamicShape()
                    ,OrangeFruit.ORANGE_FRUIT));

    public static final  BlockDefinition<Block> ORANGE_FRUIT_LEAVES =  registerNoItem("orange_fruit_leaves",
            () -> new OrangeLeavesBlock(ofFullCopy(Blocks.JUNGLE_LEAVES).isViewBlocking((s, g, p) -> false).isSuffocating(((s, g, p) -> false)), OrangeFruit.ORANGE_FRUIT));
    public static final Supplier<Block> ORANGE_CRATE = BLOCKS.register("orange_crate",
            () -> new Block(ofFullCopy(Blocks.BARREL)));
    public static final Supplier<Block> CHOCOLATE_CAKE = BLOCKS.register("chocolate_cake_block",() -> new ChocolateCakeBlock(Block.Properties.ofFullCopy(Blocks.CAKE), com.magafin.no_mans_delight.register.ItemReg.CHOCOLATE_CAKE_SLICE));;
    public static final Supplier<Block> HORSE_SOUP_POT = BLOCKS.register("horse_soup_pot",
            () -> new HorseSoupBlock(ofFullCopy(Blocks.FLOWER_POT).sound(SoundType.DECORATED_POT), com.magafin.no_mans_delight.register.ItemReg.HORSE_SOUP, true));
}